package io.github.csabailonka.minecraft.template;

import lombok.extern.log4j.Log4j2;
import net.minecraft.client.GameSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.PointOfView;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.item.minecart.MinecartEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Arrays;
import java.util.List;

@Log4j2
@Mod(MountedPerspectiveMod.ID)
public class MountedPerspectiveMod {
    public static final String ID = "icsaba_mounted_perspective";

    public MountedPerspectiveMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onEntityMountEvent(EntityMountEvent event) {
        if (isPlayer(event.getEntityMounting())) {
            GameSettings gameSettings = Minecraft.getInstance().gameSettings;
            if (event.isMounting()) {
                if (gameSettings.getPointOfView() == PointOfView.FIRST_PERSON) {
                    gameSettings.setPointOfView(PointOfView.THIRD_PERSON_BACK);
                }
            } else {
                if (gameSettings.getPointOfView() == PointOfView.THIRD_PERSON_BACK) {
                    gameSettings.setPointOfView(PointOfView.FIRST_PERSON);
                }
            }
        }
    }

    private boolean isPlayer(Entity entity) {
        return entity instanceof PlayerEntity;
    }

    private boolean isVehicle(Entity entity) {
        return mountableEntities().stream().anyMatch(mountableEntity -> mountableEntity.isInstance(entity));
    }

    private List<Class<? extends Entity>> mountableEntities() {
        return Arrays.asList(HorseEntity.class, BoatEntity.class, MinecartEntity.class);
    }
}
