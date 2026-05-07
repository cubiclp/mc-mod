package testmod;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import testmod.block.HehehaBlock;
import testmod.block.TestBlock;

public class AllBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Mcmod.MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Mcmod.MODID);

    public static final DeferredBlock<Block> TEST_BLOCK = BLOCKS.registerBlock("test_block", TestBlock::new, BlockBehaviour.Properties.of().strength(3f));
    public static final DeferredItem<BlockItem> TEST_ITEM = ITEMS.registerSimpleBlockItem("test_block", TEST_BLOCK);

    public static final DeferredBlock<Block> HEHEHA_BLOCK = BLOCKS.registerBlock("heheha_block", HehehaBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredItem<BlockItem> HEHEHA_ITEM = ITEMS.registerSimpleBlockItem("heheha_block", HEHEHA_BLOCK);
}
