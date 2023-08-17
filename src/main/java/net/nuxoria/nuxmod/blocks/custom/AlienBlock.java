package net.nuxoria.nuxmod.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.nuxoria.nuxmod.blocks.ModBlock;
import net.nuxoria.nuxmod.items.ModItems;

public class AlienBlock extends Block {

    public AlienBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {

        if (!level.isClientSide && interactionHand == InteractionHand.MAIN_HAND) {

            if (player.getItemInHand(interactionHand).getItem().equals(ModItems.ALIEN_SHIT.get())) {

                level.setBlock(blockPos, ModBlock.ALIEN_SHIT_BLOCK.get().defaultBlockState(), 3);

            }

        }

        return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
    }

}
