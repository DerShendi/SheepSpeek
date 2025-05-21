package net.teamluxron.sheepspeek.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
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
    private final List<String> SECRET_MESSAGES = List.of(
            "I hate you with every fibre of my being",
            "Redstone was a mistake",
            "You want a medal you failed abortion?"
    );

    public void onEntityInteractSpecific(PlayerInteractEvent.EntityInteractSpecific event) {
        if (!(event.getTarget() instanceof Sheep) || event.getLevel().isClientSide()) return;

        Player player = event.getEntity();
        Sheep sheep = (Sheep) event.getTarget();
        Level level = event.getLevel();
        BlockPos pos = sheep.blockPosition();

        if (!SheepSpeekConfig.SERVER.enabled.get()) return;
        if (event.getHand() != InteractionHand.MAIN_HAND) return;

        if (checkSecretTrigger(level, pos)) {
            sendSecretMessage(player, "[Sheep] ", SECRET_MESSAGES);
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

    private boolean checkSecretTrigger(Level level, BlockPos sheepPos) {
        for (BlockPos nearbyPos : BlockPos.withinManhattan(sheepPos, 20, 10, 20)) {
            BlockState state = level.getBlockState(nearbyPos);
            if (state.is(Blocks.END_ROD)) {
                for (Direction dir : Direction.values()) {
                    BlockPos neighborPos = nearbyPos.relative(dir);
                    Block neighbor = level.getBlockState(neighborPos).getBlock();
                    if (neighbor instanceof PistonBaseBlock || neighbor instanceof PistonHeadBlock) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}