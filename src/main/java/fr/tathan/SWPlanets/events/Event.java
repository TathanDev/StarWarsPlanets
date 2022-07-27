package fr.tathan.SWPlanets.events;

import fr.tathan.SWPlanets.registries.ItemsRegistry;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import fr.tathan.SWPlanets.SWPlanets;
import fr.tathan.SWPlanets.registries.PlanetsRegistry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mrscauthd.beyond_earth.common.entities.LanderEntity;
import net.mrscauthd.beyond_earth.common.events.forge.EntityTickEvent;
import net.mrscauthd.beyond_earth.common.util.Methods;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = SWPlanets.MODID)
public class Event {

    /**
    @SubscribeEvent
    public static void entityGravity(LivingEntityTickEndEvent event) {


        if (Methods.isWorld(event.getEntityLiving().level, PlanetsRegistry.ENDOR)) {
            EntityGravity.gravitySystem(event.getEntityLiving(), 0.03F);
        } else if (Methods.isWorld(event.getEntityLiving().level, PlanetsRegistry.TATOOINE)) {
            EntityGravity.gravitySystem(event.getEntityLiving(), 0.03F);
        } else if (Methods.isWorld(event.getEntityLiving().level, PlanetsRegistry.HOT)) {
            EntityGravity.gravitySystem(event.getEntityLiving(), 0.03F);
        } else if (Methods.isWorld(event.getEntityLiving().level, PlanetsRegistry.KAMINO)) {
            EntityGravity.gravitySystem(event.getEntityLiving(), 0.03F);
        }

         //ORBIT GRAVITY
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

     /**
    @SubscribeEvent
    public static void itemGravity(ItemEntityTickEndEvent event) {
        ItemEntity entity = event.getEntityItem();
        Level level = entity.level;

        // ITEM ENTITY GRAVITY SYSTEM
        if (Methods.isWorld(level, PlanetsRegistry.ENDOR_ORBIT)) {
            ItemGravity.gravitySystem(entity, 0.05F);
        } else if (Methods.isWorld(level, PlanetsRegistry.HOT_ORBIT)) {
            ItemGravity.gravitySystem(entity, 0.05F);
        } else if (Methods.isWorld(level, PlanetsRegistry.KAMINO_ORBIT)) {
            ItemGravity.gravitySystem(entity, 0.05F);
        } else if (Methods.isWorld(level, PlanetsRegistry.TATOOINE_ORBIT)) {
            ItemGravity.gravitySystem(entity, 0.05F);
        }
    }



    @SubscribeEvent
    public static void entityGravityFallDamageHandler(LivingFallEvent event) {
        LivingEntity entity = event.getEntityLiving();
        Level level = entity.level;

        if (Methods.isWorld(level, PlanetsRegistry.ENDOR)) {
            event.setDistance(event.getDistance() - 5.5F);
        } else if (Methods.isWorld(level, PlanetsRegistry.TATOOINE)) {
            event.setDistance(event.getDistance() - 5.5F);
        } else if (Methods.isWorld(level, PlanetsRegistry.HOT)) {
            event.setDistance(event.getDistance() - 5.5F);
        } else if (Methods.isWorld(level, PlanetsRegistry.KAMINO)) {
            event.setDistance(event.getDistance() - 5.5F);
        }



    }

    @SubscribeEvent
    public static void playerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            Level world = player.level;

            /** LANDER ORBIT TELEPORT SYSTEM
            if (player.getVehicle() instanceof LanderEntity) {
                PlanetsMethods.landerTeleportOrbit(player, world);
            }


            if (Methods.isLevel(world, PlanetsRegistry.ENDOR)) {
                world.setRainLevel(2);
            }
        }
    }   
    @SubscribeEvent
    public static void entityTick(EntityTickEvent event) {
        Entity entity = event.getEntity();
        Level level = entity.level;

        /** ORBIT TELEPORT SYSTEM
        if (entity.getY() < 1 && !(entity.getVehicle() instanceof LanderEntity)) {

            if ((entity instanceof LanderEntity) && entity.isVehicle()) {
                return;
            }

            PlanetsMethods.entityFallToPlanet(level, entity);
        }
    }
    */

    //CUSTOM TRADES

    @SubscribeEvent
    public static  void addCustomTrades(VillagerTradesEvent event)
    {

        if(event.getType() == VillagerProfession.WEAPONSMITH) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ItemsRegistry.KYBER_CRYSTAL.get(), 1); 
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 59), //Price
                    stack,1,12,0.09F));
                               //Max use            Xp        Price X
        }

    }
}