package fr.tathan.SWPlanets.events;

import fr.tathan.SWPlanets.SWPlanets;
import fr.tathan.SWPlanets.world.PlanetsRegistry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mrscauthd.beyond_earth.entities.LanderEntity;
import net.mrscauthd.beyond_earth.events.forgeevents.EntityTickEvent;

@Mod.EventBusSubscriber(modid = SWPlanets.MODID)
public class Event {

    @SubscribeEvent
    public static void playerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            Level world = player.level;

            /** LANDER ORBIT TELEPORT SYSTEM */
            if (player.getVehicle() instanceof LanderEntity) {
                PlanetsMethods.landerTeleportOrbit(player, world);
            }

            Oxygen.OxygenSystem(player);

        }
    }
    @SubscribeEvent
    public static void entityTick(EntityTickEvent event) {
        Entity entity = event.getEntity();
        Level level = entity.level;

        /** ORBIT TELEPORT SYSTEM */
        if (entity.getY() < 1 && !(entity.getVehicle() instanceof LanderEntity)) {

            if ((entity instanceof LanderEntity) && entity.isVehicle()) {
                return;
            }

            PlanetsMethods.entityFallToPlanet(level, entity);
        }
    }


    @SubscribeEvent
    public static void worldTick(TickEvent.WorldTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Level world = event.world;

            if (PlanetsMethods.worldsWithoutRain.contains(world.dimension())) {
                world.thunderLevel = 0;
                world.rainLevel = 0;
            } else if (PlanetsMethods.isWorld(world, PlanetsRegistry.KAMINO_ORBIT)) {
                world.thunderLevel = 1;
                world.rainLevel = 1;

            }
        }
    }
}