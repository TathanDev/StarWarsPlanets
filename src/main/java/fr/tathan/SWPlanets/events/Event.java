package fr.tathan.SWPlanets.events;

import fr.tathan.SWPlanets.items.JediLightSaber;
import fr.tathan.SWPlanets.registries.ItemsRegistry;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import fr.tathan.SWPlanets.SWPlanets;
import fr.tathan.SWPlanets.registries.PlanetsRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mrscauthd.beyond_earth.entities.LanderEntity;
import net.mrscauthd.beyond_earth.events.EntityGravity;
import net.mrscauthd.beyond_earth.events.ItemGravity;
import net.mrscauthd.beyond_earth.events.Methods;
import net.mrscauthd.beyond_earth.events.forge.EntityTickEvent;
import net.mrscauthd.beyond_earth.events.forge.ItemEntityTickEndEvent;
import net.mrscauthd.beyond_earth.events.forge.LivingEntityTickEndEvent;
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


    @SubscribeEvent
    public static void entityGravity(LivingEntityTickEndEvent event) {

        /**
         if (Methods.isWorld(event.getEntityLiving().level, PlanetsRegistry.ENDOR)) {
         EntityGravity.gravitySystem(event.getEntityLiving(), 0.03F);
         } else if (Methods.isWorld(event.getEntityLiving().level, PlanetsRegistry.TATOOINE)) {
         EntityGravity.gravitySystem(event.getEntityLiving(), 0.03F);
         } else if (Methods.isWorld(event.getEntityLiving().level, PlanetsRegistry.HOT)) {
         EntityGravity.gravitySystem(event.getEntityLiving(), 0.03F);
         } else if (Methods.isWorld(event.getEntityLiving().level, PlanetsRegistry.KAMINO)) {
         EntityGravity.gravitySystem(event.getEntityLiving(), 0.03F);
         }
         */
        //ORBIT GRAVITY
        if (Methods.isWorld(event.getEntityLiving().level, PlanetsRegistry.TATOOINE_ORBIT)) {
            EntityGravity.gravitySystem(event.getEntityLiving(), 0.02F);
        } else if (Methods.isWorld(event.getEntityLiving().level, PlanetsRegistry.KAMINO_ORBIT)) {
            EntityGravity.gravitySystem(event.getEntityLiving(), 0.02F);
        } else if (Methods.isWorld(event.getEntityLiving().level, PlanetsRegistry.ENDOR_ORBIT)) {
            EntityGravity.gravitySystem(event.getEntityLiving(), 0.02F);
        } else if (Methods.isWorld(event.getEntityLiving().level, PlanetsRegistry.HOT_ORBIT)) {
            EntityGravity.gravitySystem(event.getEntityLiving(), 0.02F);
        } else if (Methods.isWorld(event.getEntityLiving().level, PlanetsRegistry.MUSTAFAR_ORBIT)) {
            EntityGravity.gravitySystem(event.getEntityLiving(), 0.02F);
        } else if (Methods.isWorld(event.getEntityLiving().level, PlanetsRegistry.MANDALORE)) {
            EntityGravity.gravitySystem(event.getEntityLiving(), 0.02F);
        } else if (Methods.isWorld(event.getEntityLiving().level, PlanetsRegistry.MANDALORE_ORBIT)) {
            EntityGravity.gravitySystem(event.getEntityLiving(), 0.02F);


        }
    }

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
        } else if (Methods.isWorld(level, PlanetsRegistry.MUSTAFAR_ORBIT)) {
            ItemGravity.gravitySystem(entity, 0.05F);
        } else if (Methods.isWorld(level, PlanetsRegistry.MANDALORE_ORBIT)) {
            ItemGravity.gravitySystem(entity, 0.05F);
        }else if (Methods.isWorld(level, PlanetsRegistry.MANDALORE)) {
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
        } else if (Methods.isWorld(level, PlanetsRegistry.MUSTAFAR)) {
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


            if (Methods.isWorld(world, PlanetsRegistry.ENDOR)) {
                world.setRainLevel(2);
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

   /** @SubscribeEvent
    public static void onRightClick(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getWorld();
        Player player = event.getPlayer();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);
        InteractionHand hand = event.getHand();
        if (state.is(Blocks.PUMPKIN) ) {
            if (player.getMainHandItem().getItem() instanceof JediLightSaber && hand.equals(InteractionHand.MAIN_HAND)) {
                level.setBlockAndUpdate(pos, state.cycle(Blocks.GLOWSTONE.defaultBlockState().getBlock().getStateDefinition().getProperty("")));
                SWPlanets.LOGGER.info(player.getDirection().getName());


    }*/
}