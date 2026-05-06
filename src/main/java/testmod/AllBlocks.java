package testmod;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AllBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Mcmod.MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Mcmod.MODID);

    public static final DeferredBlock<Block> TEST_BLOCK = BLOCKS.registerSimpleBlock("test_block", BlockBehaviour.Properties.of().dropsLike(Blocks.DRAGON_EGG).strength(1f));
    public static final DeferredItem<BlockItem> TEST_ITEM = ITEMS.registerSimpleBlockItem("test_block", TEST_BLOCK);
}
