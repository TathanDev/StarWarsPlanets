package fr.tathan.SWPlanets.events;
/**

import fr.tathan.SWPlanets.registries.PlanetsRegistry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.mrscauthd.beyond_earth.common.util.Methods;
import net.mrscauthd.beyond_earth.events.Methods;

public class PlanetsMethods {

    
    public static void entityFallWithLanderToPlanet(Player player, Level world) {
        ServerPlayer player = context.getSender();


        if (Methods.isLevel(world, PlanetsRegistry.KAMINO_ORBIT)) {
            Methods.createLanderAndTeleportTo(player, PlanetsRegistry.KAMINO, 700, false);
        } else if (Methods.isWorld(world, PlanetsRegistry.TATOOINE_ORBIT)) {
            Methods.landerTeleport(player, PlanetsRegistry.TATOOINE);
        } else if (Methods.isWorld(world, PlanetsRegistry.ENDOR_ORBIT)) {
            Methods.landerTeleport(player, PlanetsRegistry.ENDOR);
        } else if (Methods.isWorld(world, PlanetsRegistry.HOT_ORBIT)) {
            Methods.landerTeleport(player, PlanetsRegistry.HOT);
        }
    }

    public static void entityFallToPlanet(Level world, Entity entity) {
        ResourceKey<Level> world2 = world.dimension();

        if (world2 == PlanetsRegistry.KAMINO_ORBIT) {
            Methods.entityFallWithLanderToPlanet(entity, PlanetsRegistry.KAMINO, 450);
        } else if (world2 == PlanetsRegistry.TATOOINE_ORBIT) {
            Methods.entityWorldTeleporter(entity, PlanetsRegistry.TATOOINE, 450);
        } else if (world2 == PlanetsRegistry.ENDOR_ORBIT) {
            Methods.entityWorldTeleporter(entity, PlanetsRegistry.ENDOR, 450);
        } else if (world2 == PlanetsRegistry.HOT_ORBIT) {
            Methods.entityWorldTeleporter(entity, PlanetsRegistry.HOT, 450);
        }
    }
}
 */
