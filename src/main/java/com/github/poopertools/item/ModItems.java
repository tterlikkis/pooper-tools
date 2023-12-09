package com.github.poopertools.item;

import com.github.poopertools.PooperTools;
import com.github.poopertools.item.custom.CopperPickaxe;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

//        Tool	    Damage	Speed
//        Shovel	3.5	    1
//        Pickaxe	3	    1.2
//        Axe	    9	    0.8
//        Hoe	    1	    2
//        Sword	    5	    1.6


public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PooperTools.MODID);

    // PickaxeItem defaults to 1 Damage and 4 Speed
    public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", CopperPickaxe::new);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
