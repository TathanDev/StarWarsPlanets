package fr.tathan.SWPlanets.events;

import fr.tathan.SWPlanets.SWPlanets;
import fr.tathan.SWPlanets.world.PlanetsRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mrscauthd.beyond_earth.events.EntityGravity;
import net.mrscauthd.beyond_earth.events.Methods;
import net.mrscauthd.beyond_earth.events.forgeevents.LivingEntityTickEndEvent;

@Mod.EventBusSubscriber(modid = SWPlanets.MODID)
public class GravityEvents {

    @SubscribeEvent
    public static void livingEntityEndTick(LivingEntityTickEndEvent event) {

        /** PLANET GRAVITY
        if (Methods.isWorld(event.getEntityLiving().level, PlanetsRegistry.TATOOINE)) {
            EntityGravity.gravitySystem(event.getEntityLiving(), 0.03F);
        }
        */

       

        /** ORBIT GRAVITY */
        if (Methods.isWorld(event.getEntityLiving().level, PlanetsRegistry.TATOOINE_ORBIT)) {
            EntityGravity.gravitySystem(event.getEntityLiving(), 0.02F);
        }

        if (Methods.isWorld(event.getEntityLiving().level, PlanetsRegistry.KAMINO_ORBIT)) {
            EntityGravity.gravitySystem(event.getEntityLiving(), 0.02F);
        }
    }
}
