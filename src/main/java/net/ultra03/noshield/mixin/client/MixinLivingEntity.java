package net.ultra03.noshield.mixin.client;

import net.minecraft.entity.LivingEntity;
import net.ultra03.noshield.client.NoShieldClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class MixinLivingEntity {

    @Inject(method = "Lnet/minecraft/entity/LivingEntity;stopUsingItem()V", at = @At("HEAD"))
    public void stopUsingItem(CallbackInfo ci) {
        NoShieldClient.shouldRender = false;
    }

}
