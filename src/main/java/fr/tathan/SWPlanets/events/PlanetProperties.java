package fr.tathan.SWPlanets.events;

import com.google.common.collect.ImmutableSet;
import fr.tathan.SWPlanets.SWPlanets;
import fr.tathan.SWPlanets.registries.PlanetsRegistry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.mrscauthd.beyond_earth.events.Methods;

import java.util.Set;

@Mod.EventBusSubscriber(modid = SWPlanets.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PlanetProperties {

    public static final Set<ResourceKey<Level>> worldsWithoutRain = Set.of(
            PlanetsRegistry.TATOOINE,
            PlanetsRegistry.TATOOINE_ORBIT,
            PlanetsRegistry.KAMINO_ORBIT,
            PlanetsRegistry.ENDOR_ORBIT,
            PlanetsRegistry.HOT_ORBIT,
            PlanetsRegistry.MUSTAFAR_ORBIT,
            PlanetsRegistry.MUSTAFAR,
            PlanetsRegistry.MANDALORE_ORBIT


    );


    public static final Set<ResourceKey<Level>> spaceWorldsWithoutOxygen = Set.of(
            PlanetsRegistry.KAMINO_ORBIT,
            PlanetsRegistry.TATOOINE_ORBIT,
            PlanetsRegistry.ENDOR_ORBIT,
            PlanetsRegistry.HOT_ORBIT,
            PlanetsRegistry.MUSTAFAR_ORBIT,
            PlanetsRegistry.MANDALORE,
            PlanetsRegistry.MANDALORE_ORBIT


    );

    public static final Set<ResourceKey<Level>> spaceWorlds = Set.of(
            PlanetsRegistry.TATOOINE,
            PlanetsRegistry.KAMINO,
            PlanetsRegistry.KAMINO_ORBIT,
            PlanetsRegistry.TATOOINE_ORBIT,
            PlanetsRegistry.ENDOR,
            PlanetsRegistry.ENDOR_ORBIT,
            PlanetsRegistry.HOT_ORBIT,
            PlanetsRegistry.HOT,
            PlanetsRegistry.MUSTAFAR_ORBIT,
            PlanetsRegistry.MUSTAFAR,
            PlanetsRegistry.MANDALORE,
            PlanetsRegistry.MANDALORE_ORBIT



    );

    private static final Set<ResourceKey<Level>> orbitWorlds = Set.of(
            PlanetsRegistry.KAMINO_ORBIT,
            PlanetsRegistry.TATOOINE_ORBIT,
            PlanetsRegistry.ENDOR_ORBIT,
            PlanetsRegistry.HOT_ORBIT,
            PlanetsRegistry.MUSTAFAR_ORBIT,
            PlanetsRegistry.MANDALORE_ORBIT

    );


    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

            /**
            Methods.worldsWithoutRain = new ImmutableSet.Builder<ResourceKey<Level>>().addAll(Methods.worldsWithoutRain).addAll(worldsWithoutRain).build();
            Methods.spaceWorldsWithoutOxygen = new ImmutableSet.Builder<ResourceKey<Level>>().addAll(Methods.spaceWorldsWithoutOxygen).addAll(spaceWorldsWithoutOxygen).build();
            Methods.spaceWorlds = new ImmutableSet.Builder<ResourceKey<Level>>().addAll(Methods.spaceWorlds).addAll(spaceWorlds).build();

            Methods.worldsWithoutRain.add(PlanetsRegistry.MANDALORE);
            Methods.worldsWithoutRain.add(PlanetsRegistry.TATOOINE);
            Methods.worldsWithoutRain.add(PlanetsRegistry.TATOOINE_ORBIT);
            Methods.worldsWithoutRain.add(PlanetsRegistry.ENDOR_ORBIT);
            Methods.worldsWithoutRain.add(PlanetsRegistry.HOT_ORBIT);
            Methods.worldsWithoutRain.add(PlanetsRegistry.MUSTAFAR);
            Methods.worldsWithoutRain.add(PlanetsRegistry.MUSTAFAR_ORBIT);
            Methods.worldsWithoutRain.add(PlanetsRegistry.MANDALORE_ORBIT);

            Methods.spaceWorldsWithoutOxygen.add(PlanetsRegistry.MANDALORE);
            Methods.spaceWorldsWithoutOxygen.add(PlanetsRegistry.TATOOINE_ORBIT);
            Methods.spaceWorldsWithoutOxygen.add(PlanetsRegistry.ENDOR_ORBIT);
            Methods.spaceWorldsWithoutOxygen.add(PlanetsRegistry.HOT_ORBIT);
            Methods.spaceWorldsWithoutOxygen.add(PlanetsRegistry.MUSTAFAR_ORBIT);
            Methods.spaceWorldsWithoutOxygen.add(PlanetsRegistry.MANDALORE_ORBIT);
            */

        });
    }

}
