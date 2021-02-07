package com.zairous.tutorial.enchantment;

import com.zairous.tutorial.Tutorial;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class BoomEnchantment extends Enchantment {
    public BoomEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }

    /**
     * el nivel minimo para obtener este encantamiento, en la tabla de encantamiento
     * @param level
     * @return
     */
    @Override
    public int getMinPower(int level) {
        return 15;
    }

    /**
     * cuantos niveles tiene nuestro encantamiento
     * @return
     */
    @Override
    public int getMaxLevel() {
        return 3;
    }

    /**
     *se llama cuando golpeamos a una entidad con un arma
     * encantada con nuestro encantamiento
     *
     * @param user
     * @param target
     * @param level
     */
    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {

       if(target instanceof LivingEntity){

           float power = 1.2F*level;
           user.world.createExplosion(user,target.getX(), target.getBodyY(0.0625D), target.getZ(), power, Explosion.DestructionType.NONE);
       }
    }
}
