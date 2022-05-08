package fr.tathan.SWPlanets.world;

import fr.tathan.SWPlanets.SWPlanets;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class PlanetsRegistry {

    public static final ResourceKey<Level> TATOOINE = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(SWPlanets.MODID, "tatooine"));
    public static final ResourceKey<Level> TATOOINE_ORBIT = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(SWPlanets.MODID, "tatooine_orbit"));

    public static final ResourceKey<Level> KAMINO = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(SWPlanets.MODID, "kamino"));
    public static final ResourceKey<Level> KAMINO_ORBIT = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(SWPlanets.MODID, "kamino_orbit"));



}



