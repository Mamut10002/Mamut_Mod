package net.mamut.mamutmod.item;

import net.mamut.mamutmod.MamutMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MamutMod.MOD_ID);

    public static final RegistryObject<Item> Mamutinium = ITEMS.register("mamutinium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MAMUT_TAB)));
    public static final RegistryObject<Item> Mamut_Stick = ITEMS.register("mamut_stick",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MAMUT_TAB)));
    public static final RegistryObject<Item> Mamutininium = ITEMS.register("mamutininium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MAMUT_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    

}
