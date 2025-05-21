package net.teamluxron.sheepspeek.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.block.piston.PistonHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.teamluxron.sheepspeek.SheepSpeekConfig;

import java.util.List;
import java.util.Random;

public class SheepSpeekEventHandler {
    private final Random random = new Random();
    private static final List<String> SECRET_MESSAGES = List.of(
            "KILL YOURSELF",
            "I hate you with every fibre of my being",
            "Redstone was a mistake",
            "You want a medal you failed abortion?"
    );

    @SubscribeEvent
    public void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
        if (!(event.getTarget() instanceof Sheep) || event.getLevel().isClientSide()) return;

        Player player = event.getEntity();
        Sheep sheep = (Sheep) event.getTarget();

        if (checkSecretTrigger(event.getLevel(), sheep.blockPosition())) {
            sendSecretMessage(player, "[Secret Sheep] ", SECRET_MESSAGES);
        } else if (SheepSpeekConfig.SERVER.secretMessages.get() && random.nextFloat() < 0.1f) {
            sendSecretMessage(player, "[Sheep] ", SECRET_MESSAGES);
        } else {
            sendRegularMessage(player);
        }

        event.setCanceled(true);
        event.setCancellationResult(InteractionResult.SUCCESS);
    }

    private void sendRegularMessage(Player player) {
        List<? extends String> messages = SheepSpeekConfig.SERVER.messages.get();
        if (!messages.isEmpty()) {
            String msg = messages.get(random.nextInt(messages.size()));
            player.sendSystemMessage(Component.literal("§e[Sheep]§r " + msg));
        }
    }

    private void sendSecretMessage(Player player, String prefix, List<String> messages) {
        String msg = messages.get(random.nextInt(messages.size()));
        player.sendSystemMessage(Component.literal("§5" + prefix + "§r " + msg));
    }

    private boolean checkSecretTrigger(Level level, BlockPos pos) {
        for (BlockPos checkPos : BlockPos.withinManhattan(pos, 1, 1, 1)) {
            if (isEndRodNextToPiston(level, checkPos)) return true;
        }
        return false;
    }

    private boolean isEndRodNextToPiston(Level level, BlockPos pos) {
        if (!level.getBlockState(pos).is(Blocks.END_ROD)) return false;

        for (Direction direction : Direction.values()) {
            BlockPos pistonPos = pos.relative(direction);
            BlockState state = level.getBlockState(pistonPos);
            Block block = state.getBlock();

            if (block instanceof PistonBaseBlock || block instanceof PistonHeadBlock) {
                return true;
            }
        }
        return false;
    }
}