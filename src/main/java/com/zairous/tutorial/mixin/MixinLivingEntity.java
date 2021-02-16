package com.zairous.tutorial.mixin;

import com.zairous.tutorial.Tutorial;
import com.zairous.tutorial.registry.ModArmor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity extends Entity {

    /**
     * Este constructor esta siendo obligado a creacer por heredar de Entity.
     * Sin embargo, no parece sobrescribir el constructor de LivingEntity.
     * ya que se llama distinto.
     *
     */
    public MixinLivingEntity(EntityType<?> type, World world) {
        super(type, world);
    }

    /**
     * variable importada desde LivingEntity.class
     * marcamos con shadow. mas info en MixinItem
     *
     * Final se utiliza para indicar con final aquellas variables que importamos que tenian el final
     * pero necesitamos quitarlo para evitar que nos pida que lo incialicemos nosotros.
     * tambien previene que dentro de nuestro codigo lo modifiquemos.
     *
     * 0=botas
     * 1=piernas
     * 2=pechera
     * 3=casco
     */
    @Shadow @Final
    private DefaultedList<ItemStack> equippedArmor;

    @Inject(at=@At("HEAD"), method="tick")
    private void tick(CallbackInfo info){
        if(this.isOnFire()){

            ItemStack boots= this.equippedArmor.get(0);
            ItemStack helmet= this.equippedArmor.get(3);

            int explosionCount=0;

            if(helmet.getItem().equals(ModArmor.GUNPOWDER_HELMET)){
                explosionCount++;
            }
            if(boots.getItem().equals(ModArmor.GUNPOWDER_BOOTS)){
                explosionCount++;
            }
            float power = 0.6F*explosionCount;
            if(power>0){
                this.world.createExplosion(null,this.getX(), this.getBodyY(0.0625D), this.getZ(), power, Explosion.DestructionType.NONE);
                this.setFireTicks(0);
            }

        }
    }
}
