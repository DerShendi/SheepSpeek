package net.teamluxron.sheepspeek;

import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.teamluxron.sheepspeek.event.SheepSpeekEventHandler;

@Mod(SheepSpeekMod.MODID)
public class SheepSpeekMod {
    public static final String MODID = "sheepspeek";

    public SheepSpeekMod(IEventBus modEventBus) {
        ModLoadingContext.get().getActiveContainer().registerConfig(
                ModConfig.Type.SERVER,
                SheepSpeekConfig.SERVER_SPEC,
                "sheepspeek-server.toml"
        );

        NeoForge.EVENT_BUS.addListener(EventPriority.NORMAL, false, PlayerInteractEvent.EntityInteractSpecific.class,
                handler -> new SheepSpeekEventHandler().onEntityInteractSpecific(handler)
        );
    }
}