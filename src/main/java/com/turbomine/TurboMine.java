package com.turbomine;

import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(TurboMine.MODID)
public class TurboMine {
    public static final String MODID = "turbomine";

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    /** Herramientas rapidas: solo cambian la velocidad de minado, sin tareas por tick. */
    public static final IItemTier TURBO = new IItemTier() {
        @Override public int getUses() { return 1561; }
        @Override public float getSpeed() { return 20.0F; }            // diamante = 8
        @Override public float getAttackDamageBonus() { return 3.0F; }
        @Override public int getLevel() { return 3; }                  // minan obsidiana
        @Override public int getEnchantmentValue() { return 15; }
        @Override public Ingredient getRepairIngredient() { return Ingredient.of(Items.DIAMOND); }
    };

    public static final RegistryObject<Item> TURBO_PICKAXE = ITEMS.register("turbo_pickaxe",
            () -> new PickaxeItem(TURBO, 1, -2.8F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
    public static final RegistryObject<Item> TURBO_AXE = ITEMS.register("turbo_axe",
            () -> new AxeItem(TURBO, 5.0F, -3.0F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
    public static final RegistryObject<Item> TURBO_SHOVEL = ITEMS.register("turbo_shovel",
            () -> new ShovelItem(TURBO, 1.5F, -3.0F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));

    public TurboMine() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
