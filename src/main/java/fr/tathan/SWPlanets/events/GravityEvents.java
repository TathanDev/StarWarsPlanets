package fr.tathan.SWPlanets.events;

import fr.tathan.SWPlanets.SWPlanets;
import fr.tathan.SWPlanets.world.PlanetsRegistry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
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
        } else if (Methods.isWorld(event.getEntityLiving().level, PlanetsRegistry.KAMINO_ORBIT)) {
            EntityGravity.gravitySystem(event.getEntityLiving(), 0.02F);
        } else if (Methods.isWorld(event.getEntityLiving().level, PlanetsRegistry.ENDOR_ORBIT)) {
            EntityGravity.gravitySystem(event.getEntityLiving(), 0.02F);
        } else if (Methods.isWorld(event.getEntityLiving().level, PlanetsRegistry.HOT_ORBIT)) {
            EntityGravity.gravitySystem(event.getEntityLiving(), 0.02F);
        }

    }


}
