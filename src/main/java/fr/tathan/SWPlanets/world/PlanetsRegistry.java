package fr.tathan.SWPlanets.world;

import fr.tathan.SWPlanets.SWPlanets;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class PlanetsRegistry {

    public static final ResourceKey<Level> PLANET = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(SWPlanets.MODID, "planet"));
    public static final ResourceKey<Level> ORBIT = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(SWPlanets.MODID, "orbit"));
}
