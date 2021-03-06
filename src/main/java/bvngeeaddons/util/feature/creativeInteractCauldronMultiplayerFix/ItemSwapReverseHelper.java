package bvngeeaddons.util.feature.creativeInteractCauldronMultiplayerFix;

import bvngeeaddons.config.BvngeeAddonsFeatures;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.ScreenHandlerSlotUpdateS2CPacket;

public class ItemSwapReverseHelper {

    private static int slotNumber = -1;
    
    public static void onScreenHandlerSlotUpdate(ScreenHandlerSlotUpdateS2CPacket packet, MinecraftClient client) {
        if (packet.getSlot() == slotNumber && shouldRemoveJunkItem(client.player) && client.player != null && client.interactionManager != null) {
            client.player.getInventory().setStack(slotNumber, ItemStack.EMPTY);
            client.interactionManager.clickCreativeStack(ItemStack.EMPTY, slotNumber);
        }
        slotNumber = -1;
    }

    public static void onCauldronUse(PlayerEntity player) {
        if (shouldRemoveJunkItem(player)) {
            final int emptySlot = player.getInventory().getEmptySlot();
            slotNumber = (emptySlot < 9 ? 36 + emptySlot : emptySlot);
        }
    }

    private static boolean shouldRemoveJunkItem(PlayerEntity player) {
        return !MinecraftClient.getInstance().isInSingleplayer()
                && player.getAbilities().creativeMode
                && BvngeeAddonsFeatures.creativeInteractCauldronFix.getBooleanValue()
                && BvngeeAddonsFeatures.creativeInteractCauldronMultiplayerFix.getBooleanValue();
    }

}