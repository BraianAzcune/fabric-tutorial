package com.zairous.tutorial.registry;

import com.zairous.tutorial.Tutorial;
import com.zairous.tutorial.items.Antorcha;
import com.zairous.tutorial.mixininterface.IItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModItems{
    //items
    public static final Item RUBY = new Item(new Item.Settings()
            .group(Tutorial.ITEM_GROUP));


    public static final Item ANTORCHA = new Antorcha(new Item.Settings()
            .maxCount(16)
            .group(Tutorial.ITEM_GROUP));

    public static final Item MI_ESPADA = new Item(new Item.Settings().group(Tutorial.ITEM_GROUP));

    //block items
    public static final BlockItem RUBY_BLOCK = new BlockItem(ModBlocks.RUBY_BLOCK, new Item.Settings().group(Tutorial.ITEM_GROUP));


    public static void register() {
        //item
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "ruby"), RUBY);

        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "mi_espada"), MI_ESPADA);

        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "antorcha"), ANTORCHA);

        //block Item
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID, "ruby_block"), RUBY_BLOCK);

        changeVanillaItems();
    }

    private static void changeVanillaItems() {
        ((IItem)Items.TOTEM_OF_UNDYING).setMaxCount(10);
    }

}
