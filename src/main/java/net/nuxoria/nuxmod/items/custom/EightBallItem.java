package net.nuxoria.nuxmod.items.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class EightBallItem extends Item {
    public EightBallItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {

        if (!level.isClientSide && interactionHand == InteractionHand.MAIN_HAND) {

            // OUTPUT A RANDOM NUMBER
            outPutRandomNumber(player);
            // SET A COOLDOWN
            player.getCooldowns().addCooldown(this, 20);

        }

        return super.use(level, player, interactionHand);
    }

    private void outPutRandomNumber(Player p) {
        p.sendSystemMessage(Component.literal("Your number is: " + getRandomNumber()));
    }

    private int getRandomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(8) + 1;
        return randomNumber;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {

        if (Screen.hasShiftDown()) {

            components.add(Component.literal("Right click to print a random number").withStyle(ChatFormatting.GREEN));

        } else {

            components.add(Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.GOLD).withStyle(ChatFormatting.BOLD));

        }

        super.appendHoverText(itemStack, level, components, tooltipFlag);
    }
}
