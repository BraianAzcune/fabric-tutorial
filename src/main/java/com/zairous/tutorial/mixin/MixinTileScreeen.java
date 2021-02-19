package com.zairous.tutorial.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.ingame.AnvilScreen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public abstract class MixinTileScreeen extends Screen {

    protected MixinTileScreeen(Text title) {
        super(title);
    }

    @Inject(at= @At("RETURN"), method="initWidgetsNormal")
    private void addMyButton(int y, int spacingY, CallbackInfo cbi){
        this.addButton(new ButtonWidget(this.width / 2 - 100 + 205, y, 100, 20, new TranslatableText("menu.hello"),
                (buttonWidget) -> {
                    MinecraftClient.getInstance().openScreen(new SelectWorldScreen(this));
                }
        ));
    }
}
