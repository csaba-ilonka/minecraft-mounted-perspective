package io.github.csabailonka.minecraft.template;

import lombok.extern.log4j.Log4j2;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartedEvent;

@Log4j2
@Mod(MountedPerspectiveMod.ID)
public class MountedPerspectiveMod {
    public static final String ID = "icsaba_mounted_perspective";

    public MountedPerspectiveMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onFMLServerStartedEvent(FMLServerStartedEvent event) {
        log.info("FMLServerStartedEvent");
    }
}
