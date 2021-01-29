package com.zairous.tutorial.mixin;

import com.zairous.tutorial.mixininterface.IItem;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.zairous.tutorial.Tutorial.LOG;

@Mixin(Item.class)
public class MixinItem implements IItem {


    private int maxCount;
//    public int tutorial_maxCount;

//    @Inject(method="<init>", at= @At("RETURN"))
//    public void init(Item.Settings settings, CallbackInfo ci){
//        this.tutorial_maxCount=this.maxCount;
//    }


    @Inject(method="getMaxCount", at= @At("HEAD"), cancellable = true)
    public void getMaxCount(CallbackInfoReturnable<Integer> cir) {
        //LOG.info("me llamaron maxCount= "+this.maxCount);
        cir.setReturnValue(this.maxCount);

    }

    @Override
    public void setMaxCount(int count) {
        this.maxCount = count;
    }
}
