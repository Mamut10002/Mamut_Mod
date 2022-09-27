package net.mamut.mamutmod.item;

import net.mamut.mamutmod.MamutMod;
import net.minecraft.world.item.*;
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

    public static final RegistryObject<Item> Mamutinium_Sword = ITEMS.register("mamutinium_sword",
            () -> new SwordItem(ModTiers.Mamutinium, 9, -2.4f,
                    new Item.Properties().tab(ModCreativeModeTab.MAMUT_TAB)));

    public static final RegistryObject<Item> Mamutinium_Pickaxe = ITEMS.register("mamutinium_pickaxe",
            () -> new PickaxeItem(ModTiers.Mamutinium, 6, -2.8f,
                    new Item.Properties().tab(ModCreativeModeTab.MAMUT_TAB)));

    public static final RegistryObject<Item> Mamutinium_Axe = ITEMS.register("mamutinium_axe",
            () -> new AxeItem(ModTiers.Mamutinium, 12, -3f,
                    new Item.Properties().tab(ModCreativeModeTab.MAMUT_TAB)));

    public static final RegistryObject<Item> Mamutinium_Shovel = ITEMS.register("mamutinium_shovel",
            () -> new ShovelItem(ModTiers.Mamutinium, 6.5f, -3f,
                    new Item.Properties().tab(ModCreativeModeTab.MAMUT_TAB)));

    public static final RegistryObject<Item> Mamutinium_Hoe = ITEMS.register("mamutinium_hoe",
            () -> new HoeItem(ModTiers.Mamutinium, 2, 0f,
                    new Item.Properties().tab(ModCreativeModeTab.MAMUT_TAB)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    

}
