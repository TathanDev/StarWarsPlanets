package fr.tathan.SWPlanets.events;

import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;
import fr.tathan.SWPlanets.SWPlanets;
import fr.tathan.SWPlanets.registries.PlanetsRegistry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.mrscauthd.beyond_earth.common.registries.LevelRegistry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(modid = SWPlanets.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PlanetProperties {

    public static final Set<ResourceKey<Level>> LEVELS_WITHOUT_RAIN = Set.of(
            PlanetsRegistry.TATOOINE,
            PlanetsRegistry.TATOOINE_ORBIT,
            PlanetsRegistry.KAMINO_ORBIT,
            PlanetsRegistry.ENDOR_ORBIT,
            PlanetsRegistry.HOT_ORBIT,
            PlanetsRegistry.MUSTAFAR,
            PlanetsRegistry.MUSTAFAR_ORBIT

    );


    public static final Set<ResourceKey<Level>> LEVELS_WITHOUT_OXYGEN = Set.of(
            PlanetsRegistry.KAMINO_ORBIT,
            PlanetsRegistry.TATOOINE_ORBIT,
            PlanetsRegistry.ENDOR_ORBIT,
            PlanetsRegistry.HOT_ORBIT,
            PlanetsRegistry.MUSTAFAR_ORBIT

    );

    public static final Set<ResourceKey<Level>> SPACE_LEVELS = Set.of(
            PlanetsRegistry.KAMINO_ORBIT,
            PlanetsRegistry.TATOOINE_ORBIT,
            PlanetsRegistry.ENDOR_ORBIT,
            PlanetsRegistry.HOT_ORBIT,
            PlanetsRegistry.MUSTAFAR_ORBIT

    );

    private static final Set<ResourceKey<Level>> ORBIT_LEVELS = Set.of(
            PlanetsRegistry.KAMINO_ORBIT,
            PlanetsRegistry.TATOOINE_ORBIT,
            PlanetsRegistry.ENDOR_ORBIT,
            PlanetsRegistry.HOT_ORBIT,
            PlanetsRegistry.MUSTAFAR_ORBIT

    );

    public static List<Pair<ResourceKey<Level>, ResourceKey<Level>>> LEVELS_WITH_ORBIT = Arrays.asList(
            new Pair<>(PlanetsRegistry.TATOOINE, PlanetsRegistry.TATOOINE_ORBIT),
            new Pair<>(PlanetsRegistry.ENDOR, PlanetsRegistry.ENDOR_ORBIT),
            new Pair<>(PlanetsRegistry.KAMINO, PlanetsRegistry.KAMINO_ORBIT),
            new Pair<>(PlanetsRegistry.HOT, PlanetsRegistry.HOT_ORBIT),
            new Pair<>(PlanetsRegistry.MUSTAFAR, PlanetsRegistry.MUSTAFAR_ORBIT)


            );


/**
    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

            LevelRegistry.LEVELS_WITHOUT_RAIN = new ArrayList<>(LevelRegistry.LEVELS_WITHOUT_RAIN);
            LevelRegistry.LEVELS_WITHOUT_RAIN.addAll(LEVELS_WITHOUT_RAIN);

            LevelRegistry.LEVELS_WITHOUT_OXYGEN = new ArrayList<>(LevelRegistry.LEVELS_WITHOUT_OXYGEN);
            LevelRegistry.LEVELS_WITHOUT_OXYGEN.addAll(LEVELS_WITHOUT_OXYGEN);

            LevelRegistry.SPACE_LEVELS = new ArrayList<>(LevelRegistry.SPACE_LEVELS);
            LevelRegistry.SPACE_LEVELS.addAll(SPACE_LEVELS);

            LevelRegistry.LEVELS_WITH_ORBIT = new ArrayList<>(LevelRegistry.LEVELS_WITH_ORBIT);
            LevelRegistry.LEVELS_WITH_ORBIT.addAll(LEVELS_WITH_ORBIT);

            LevelRegistry.ORBIT_LEVELS = new ArrayList<>(LevelRegistry.ORBIT_LEVELS);
            LevelRegistry.ORBIT_LEVELS.addAll(ORBIT_LEVELS);
        });

    }
    */

}
