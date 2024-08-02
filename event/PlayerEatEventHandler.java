package net.oakamer.cropcraft.event;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.oakamer.cropcraft.item.ModItems;

@Mod.EventBusSubscriber(modid = "cropcraft", bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class PlayerEatEventHandler {


    @SubscribeEvent
    public static void onPlayerFinishUsingItem(LivingEntityUseItemEvent.Finish event) {

        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            ItemStack itemStack = event.getItem();
            Level world = player.getCommandSenderWorld();

            if (itemStack.getItem() == ModItems.CREEPER_COOKIE.get()) { // Checks if the item is food
                player.setInvulnerable(true);
                // Create an explosion at the player's location
                player.getCommandSenderWorld().explode(null, player.getX(), player.getY(), player.getZ(), 4.0F, Level.ExplosionInteraction.BLOCK);
            }
            player.setInvulnerable(false);

            if (itemStack.getItem() == ModItems.ENDER_BISCUIT.get()) { // Checks if the item is food

                // Define the teleport distance
                double teleportDistance = 5.0;
                Vec3 lookVec = player.getLookAngle().scale(teleportDistance);

                // Calculate new position
                double newX = player.getX() + lookVec.x;
                double newY = player.getY() + lookVec.y;
                double newZ = player.getZ() + lookVec.z;

                // Teleport the player
                player.teleportTo(newX, newY, newZ);
            }

        }
    }

}


