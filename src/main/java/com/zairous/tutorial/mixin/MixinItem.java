package com.zairous.tutorial.mixin;

import com.zairous.tutorial.Tutorial;
import com.zairous.tutorial.mixininterface.IItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.zairous.tutorial.Tutorial.LOG;

/**
 * Este es un mixin, mezclar adentro, literalmetne, decimos  que queremos que el codigo que ponemos aca
 * se agrege al codigo de la clase que le indicamos a la anotacion.
 *
 * es importante que la Clase herede de la misma que hereda la original, para que los enlaces estaticos.
 * (aquellos que hacen llamadas con la instruccion super, funcionen).
 *
 * y si queremos agregarle algun metodo para usar con nuestro codigo, debemos hacer que implemente una interfaz, para
 * despues castear el objeto en tiempo de ejecucion.
 *
 * se suele poner en abstracto, para evitar tener que implementar todas las cosas de las interfaces, o sobrescribir
 * los metodos abstractos de los que heredes, despues de _todo esta clase no se deberia poder instanciar.
 */
@Mixin(Item.class)
public abstract class MixinItem implements IItem {

    /**
     * Esta anotacion sirve para crear un link, entre una variable que tiene nuestra clase objetivo
     * y deseamos usar, en este caso la variable no es tal cual ya que falta la instruccion final.
     */
    @Shadow
    private int maxCount;


    /**
     * Con esta anotacion inyectamos codigo sobre un metodo ya existente en la clase objetivo, y indicamos
     * como queremos hacerlo
     * en este caso se hace sobre el metodo getMaxCount, al principio del metodo ("HEAD")
     * y indicamos con cancellable que podemos salir sin respetar el fluyo original.
     *
     */
    @Inject(method="getMaxCount", at= @At("HEAD"), cancellable = true)
    public void getMaxCount(CallbackInfoReturnable<Integer> cir) {
        //LOG.info("me llamaron maxCount= "+this.maxCount);
        cir.setReturnValue(this.maxCount);

    }

    /**
     * Implementacion de nuestra interfaz
     *
     */
    @Override
    public void setMaxCount(int count) {

        Tutorial.LOG.info("el valor por defecto es: "+this.maxCount);
        this.maxCount = count;
    }


    //    public int tutorial_maxCount;

//    @Inject(method="<init>", at= @At("RETURN"))
//    public void init(Item.Settings settings, CallbackInfo ci){
//        this.tutorial_maxCount=this.maxCount;
//    }
}
