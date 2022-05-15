package fr.tathan.SWPlanets.events;

import fr.tathan.SWPlanets.world.PlanetsRegistry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.mrscauthd.beyond_earth.events.Methods;

import java.util.Set;

public class PlanetsMethods {

    public static final Set<ResourceKey<Level>> worldsWithoutRain = Set.of(
            PlanetsRegistry.TATOOINE,
            PlanetsRegistry.TATOOINE_ORBIT,
            PlanetsRegistry.KAMINO_ORBIT,
            PlanetsRegistry.ENDOR_ORBIT
            );


    public static final Set<ResourceKey<Level>> spaceWorldsWithoutOxygen = Set.of(
            PlanetsRegistry.KAMINO_ORBIT,
            PlanetsRegistry.TATOOINE_ORBIT,
            PlanetsRegistry.ENDOR_ORBIT


    );

    public static final Set<ResourceKey<Level>> spaceWorlds = Set.of(
            PlanetsRegistry.TATOOINE,
            PlanetsRegistry.KAMINO,
            PlanetsRegistry.KAMINO_ORBIT,
            PlanetsRegistry.TATOOINE_ORBIT,
            PlanetsRegistry.ENDOR,
            PlanetsRegistry.ENDOR_ORBIT
    );

    private static final Set<ResourceKey<Level>> orbitWorlds = Set.of(
            PlanetsRegistry.KAMINO_ORBIT,
            PlanetsRegistry.TATOOINE_ORBIT,
            PlanetsRegistry.ENDOR_ORBIT

    );

    public static boolean isSpaceWorld(Level world) {
        return spaceWorlds.contains(world.dimension());
    }

    public static boolean isSpaceWorldWithoutOxygen(Level world) {
        return spaceWorldsWithoutOxygen.contains(world.dimension());
    }

    public static boolean isOrbitWorld(Level world) {
        return orbitWorlds.contains(world.dimension());
    }

    public static boolean isWorld(Level world, ResourceKey<Level> loc) {
        return world.dimension() == loc;
    }


    public static void landerTeleportOrbit(Player player, Level world) {
        if (Methods.isWorld(world, PlanetsRegistry.KAMINO_ORBIT)) {
            Methods.landerTeleport(player, PlanetsRegistry.KAMINO);
        } else if (Methods.isWorld(world, PlanetsRegistry.TATOOINE_ORBIT)) {
            Methods.landerTeleport(player, PlanetsRegistry.TATOOINE);
        } else if (Methods.isWorld(world, PlanetsRegistry.ENDOR_ORBIT)) {
            Methods.landerTeleport(player, PlanetsRegistry.ENDOR);
        }
    }

    public static void entityFallToPlanet(Level world, Entity entity) {
        ResourceKey<Level> world2 = world.dimension();

        if (world2 == PlanetsRegistry.KAMINO_ORBIT) {
            Methods.entityWorldTeleporter(entity, PlanetsRegistry.KAMINO, 450);
        } else if (world2 == PlanetsRegistry.TATOOINE_ORBIT) {
            Methods.entityWorldTeleporter(entity, PlanetsRegistry.TATOOINE, 450);

        } else if (world2 == PlanetsRegistry.ENDOR_ORBIT) {
            Methods.entityWorldTeleporter(entity, PlanetsRegistry.ENDOR, 450);
        }
    }

}
