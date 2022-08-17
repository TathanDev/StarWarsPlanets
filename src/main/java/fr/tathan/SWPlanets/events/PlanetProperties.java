package fr.tathan.SWPlanets.events;

import fr.tathan.SWPlanets.SWPlanets;
import fr.tathan.SWPlanets.registries.PlanetsRegistry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.Mod;

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
            PlanetsRegistry.MUSTAFAR

    );


    public static final Set<ResourceKey<Level>> spaceWorldsWithoutOxygen = Set.of(
            PlanetsRegistry.KAMINO_ORBIT,
            PlanetsRegistry.TATOOINE_ORBIT,
            PlanetsRegistry.ENDOR_ORBIT,
            PlanetsRegistry.HOT_ORBIT,
            PlanetsRegistry.MUSTAFAR_ORBIT

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
            PlanetsRegistry.MUSTAFAR

    );

    private static final Set<ResourceKey<Level>> orbitWorlds = Set.of(
            PlanetsRegistry.KAMINO_ORBIT,
            PlanetsRegistry.TATOOINE_ORBIT,
            PlanetsRegistry.ENDOR_ORBIT,
            PlanetsRegistry.HOT_ORBIT,
            PlanetsRegistry.MUSTAFAR_ORBIT
    );

    /**
    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Methods.worldsWithoutRain = new ImmutableSet.Builder<ResourceKey<Level>>().addAll(Methods.worldsWithoutRain).addAll(worldsWithoutRain).build();
            Methods.spaceWorldsWithoutOxygen = new ImmutableSet.Builder<ResourceKey<Level>>().addAll(Methods.spaceWorldsWithoutOxygen).addAll(spaceWorldsWithoutOxygen).build();
            Methods.spaceWorlds = new ImmutableSet.Builder<ResourceKey<Level>>().addAll(Methods.spaceWorlds).addAll(spaceWorlds).build();
            Methods.orbitWorlds = new ImmutableSet.Builder<ResourceKey<Level>>().addAll(Methods.orbitWorlds).addAll(orbitWorlds).build();
        });
    }
    */
}
