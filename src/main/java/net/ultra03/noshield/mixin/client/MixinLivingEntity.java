package net.ultra03.noshield.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.ultra03.noshield.client.NoShieldClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity {

    @Inject(method = "Lnet/minecraft/entity/LivingEntity;stopUsingItem()V", at = @At("HEAD"))
    public void stopUsingItem(CallbackInfo ci) {
        if(((LivingEntity) (Object) this) instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) (Object) this;
            if(player.getUuid().equals(MinecraftClient.getInstance().player.getUuid()))
                NoShieldClient.shouldRender = false;
        }
    }

}
