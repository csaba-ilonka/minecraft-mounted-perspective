package io.github.csabailonka.minecraft.template;

import lombok.extern.log4j.Log4j2;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartedEvent;

/**
 * https://mcforge.readthedocs.io/en/1.16.x/
 */
@Log4j2
@Mod(ThisMod.ID)
public class ThisMod {
    public static final String ID = "THIS_MOD_ID";

    public ThisMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onFMLServerStartedEvent(FMLServerStartedEvent event) {
        log.info("FMLServerStartedEvent");
    }
}
