package fr.tathan.SWPlanets.events;

import fr.tathan.SWPlanets.SWPlanets;
import fr.tathan.SWPlanets.world.PlanetsRegistry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mrscauthd.beyond_earth.entities.LanderEntity;
import net.mrscauthd.beyond_earth.events.EntityGravity;
import net.mrscauthd.beyond_earth.events.ItemGravity;
import net.mrscauthd.beyond_earth.events.Methods;
import net.mrscauthd.beyond_earth.events.forge.EntityTickEvent;
import net.mrscauthd.beyond_earth.events.forge.ItemEntityTickEndEvent;
import net.mrscauthd.beyond_earth.events.forge.LivingEntityTickEndEvent;

@Mod.EventBusSubscriber(modid = SWPlanets.MODID)
public class Event {

    @SubscribeEvent
    public static void entityGravity(LivingEntityTickEndEvent event) {

        /** PLANET GRAVITY */
        //TODO FINISH IT I JUST DO IT FOR ENDOR!
        if (Methods.isWorld(event.getEntityLiving().level, PlanetsRegistry.ENDOR)) {
            EntityGravity.gravitySystem(event.getEntityLiving(), 0.03F);
        }
    }

    @SubscribeEvent
    public static void itemGravity(ItemEntityTickEndEvent event) {
        ItemEntity entity = event.getEntityItem();
        Level level = entity.level;

        /** ITEM ENTITY GRAVITY SYSTEM */
        //TODO FINISH IT I JUST DO IT FOR ENDOR!
        if (Methods.isWorld(level, PlanetsRegistry.ENDOR)) {
            ItemGravity.gravitySystem(entity, 0.05F);
        }
    }

    @SubscribeEvent
    public static void entityGravityFallDamageHandler(LivingFallEvent event) {
        LivingEntity entity = event.getEntityLiving();
        Level level = entity.level;

        //TODO FINISH IT I JUST DO IT NOW FOR ENDOR!
        if (Methods.isWorld(level, PlanetsRegistry.ENDOR)) {
            event.setDistance(event.getDistance() - 5.5F);
        }
    }

    @SubscribeEvent
    public static void playerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            Level world = player.level;

            /** LANDER ORBIT TELEPORT SYSTEM */
            if (player.getVehicle() instanceof LanderEntity) {
                PlanetsMethods.landerTeleportOrbit(player, world);
            }
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
}