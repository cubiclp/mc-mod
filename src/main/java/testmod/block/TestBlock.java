package testmod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import testmod.AllBlocks;

public class TestBlock extends Block {

    public TestBlock(Properties properties) {
        super(properties);
        NeoForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onPlayerTick(ServerTickEvent.Post event) {
        event.getServer().getPlayerList().getPlayers().forEach(player -> {
            ServerLevel level = (ServerLevel) player.level();
            BlockPos below = player.blockPosition().below();
            if(level.getBlockState(below).getBlock().equals(AllBlocks.TEST_BLOCK.get()) && player.onGround() && !player.hasEffect(MobEffects.MOVEMENT_SPEED)) {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1, 1, false, false));
            }
        });
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        super.onRemove(state, level, pos, newState, movedByPiston);
        //dont do anything if the block was moved by a piston
        if(movedByPiston) {
            return;
        }
        //are we on the sever or not?
        ServerLevel serverLevel;
        if (level instanceof ServerLevel) {
            serverLevel = (ServerLevel) level;
        } else {
            return;
        }
        //summon lightning
        LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(serverLevel);

        if (lightningBolt != null) {
            lightningBolt.moveTo(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
            serverLevel.addFreshEntity(lightningBolt);
        }
    }
}
