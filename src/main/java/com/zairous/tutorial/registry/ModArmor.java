package com.zairous.tutorial.registry;

import com.zairous.tutorial.Tutorial;
import com.zairous.tutorial.armor.ModArmorMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModArmor{

    public static final Item GUNPOWDER_HELMET = new ArmorItem(ModArmorMaterial.GUNPOWDER,
            EquipmentSlot.HEAD, new Item.Settings().group(Tutorial.ITEM_GROUP));

    public static final Item GUNPOWDER_BOOTS = new ArmorItem(ModArmorMaterial.GUNPOWDER,
            EquipmentSlot.FEET, new Item.Settings().group(Tutorial.ITEM_GROUP));

    public static void register(){
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID,"gunpowder_helmet"),GUNPOWDER_HELMET);
        Registry.register(Registry.ITEM, new Identifier(Tutorial.MOD_ID,"gunpowder_boots"),GUNPOWDER_BOOTS);
    }
}
