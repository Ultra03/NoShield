package net.ultra03.noshield.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.ultra03.noshield.client.NoShieldClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(HeldItemRenderer.class)
public class MixinHeldItemRenderer {

    @ModifyVariable(method = "Lnet/minecraft/client/render/item/HeldItemRenderer;renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformation$Mode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V", at = @At("HEAD"), ordinal = 0)
    private ItemStack injected(ItemStack stack) {
        if(stack.getHolder() != null && stack.getHolder().getType() != EntityType.PLAYER) return stack;

        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if(player == null) return stack;
        if(MinecraftClient.getInstance().gameRenderer.getCamera().isThirdPerson()) return stack;
        if(stack.getItem() == Items.SHIELD && !NoShieldClient.shouldRender)
            return new ItemStack(Items.AIR, 0);
        else if(stack.getItem() == Items.TOTEM_OF_UNDYING)
            return new ItemStack(Items.AIR, 0);
        else
            return stack;
    }

}
