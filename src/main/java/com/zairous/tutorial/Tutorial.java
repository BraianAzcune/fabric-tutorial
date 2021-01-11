package com.zairous.tutorial;

import com.zairous.tutorial.registry.ModBlocks;
import com.zairous.tutorial.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.UniformLootTableRange;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.util.Identifier;

public class Tutorial implements ModInitializer {

    public static final String MOD_ID = "tutorial";

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier(MOD_ID, "general"),
            () -> new ItemStack(ModItems.RUBY)
    );

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
        modifyLootTables();
    }

    private static final Identifier EMERALD_ORE_LOOT_TABLE_ID = new Identifier(
            "minecraft",
            "blocks/emerald_ore");
    private static final Identifier RUBY_BLOCK_LOOT_TABLE_ID = new Identifier(
            Tutorial.MOD_ID,
            "blocks/ruby_block");

    private void modifyLootTables() {
        LootTableLoadingCallback.EVENT.register(
                ((resourceManager, lootManager, identifier, fabricLootSupplierBuilder, lootTableSetter) -> {
                    if (EMERALD_ORE_LOOT_TABLE_ID.equals(identifier)) {
                        //añadir un entry
                        FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                                .rolls(ConstantLootTableRange.create(1))
                                .with(ItemEntry.builder(Items.APPLE))
                                .withFunction(SetCountLootFunction.builder(
                                        UniformLootTableRange.between(1f, 3f)).build());

                        fabricLootSupplierBuilder.withPool(poolBuilder.build());
                        //añadir un loot_table al inicio
                        FabricLootPoolBuilder poolBuilder2 = FabricLootPoolBuilder.builder()
                                .rolls(ConstantLootTableRange.create(1))
                                .with(LootTableEntry.builder(RUBY_BLOCK_LOOT_TABLE_ID));
                        fabricLootSupplierBuilder.withPool(poolBuilder2.build());
                    }
                }
                ));
    }

}
