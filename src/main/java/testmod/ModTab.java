package testmod;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Mcmod.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MOD_TAB = CREATIVE_MODE_TABS.register("mod_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("mcmod.mod_tab"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> AllBlocks.HEHEHA_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(AllBlocks.TEST_ITEM.get());
                output.accept(AllBlocks.HEHEHA_ITEM.get());
            }).build());
}
