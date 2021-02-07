package com.zairous.tutorial.registry;

import com.zairous.tutorial.Tutorial;
import com.zairous.tutorial.enchantment.BoomEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModEnchantment {
    private static final BoomEnchantment BOOM_ENCHANTMENT = new BoomEnchantment(
            Enchantment.Rarity.RARE,
            EnchantmentTarget.WEAPON,
            new EquipmentSlot[]{EquipmentSlot.MAINHAND}
    );


    public static void register() {
        Registry.register(Registry.ENCHANTMENT,new Identifier(Tutorial.MOD_ID, "boom_enchantment"), BOOM_ENCHANTMENT);
    }
}
