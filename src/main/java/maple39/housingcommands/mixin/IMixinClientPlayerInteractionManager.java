package maple39.housingcommands.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerInteractionManager;

@Mixin(ClientPlayerInteractionManager.class)
public interface IMixinClientPlayerInteractionManager {
    @Accessor
    ClientPlayNetworkHandler getNetworkHandler();
}
