package com.github.poopertools.item;

import com.github.poopertools.PooperTools;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PooperTools.MODID);

    public static final RegistryObject<CreativeModeTab> POOPER_TAB = CREATIVE_MODE_TABS.register("pooper_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COPPER_PICKAXE.get()))
                    .title(Component.translatable("creativetab.pooper_tab"))
                    .displayItems((p_270258_, p_259752_) -> {
                        p_259752_.accept(ModItems.COPPER_PICKAXE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
