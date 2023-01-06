package fr.tathan.SWPlanets.registries;

import fr.tathan.SWPlanets.SWPlanets;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class LevelRegistry {

    public static final ResourceKey<Level> TATOOINE;
    public static final ResourceKey<Level> TATOOINE_ORBIT;

    public static final ResourceKey<Level> KAMINO;
    public static final ResourceKey<Level> KAMINO_ORBIT;


    public static final ResourceKey<Level> ENDOR;
    public static final ResourceKey<Level> ENDOR_ORBIT;

    public static final ResourceKey<Level> HOT;
    public static final ResourceKey<Level> HOT_ORBIT;

    public static final ResourceKey<Level> MUSTAFAR;
    public static final ResourceKey<Level> MUSTAFAR_ORBIT;

     public static void init() {
        }

        static {
            TATOOINE = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(SWPlanets.MODID, "tatooine"));
            TATOOINE_ORBIT = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(SWPlanets.MODID, "tatooine_orbit"));
            KAMINO = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(SWPlanets.MODID, "kamino"));
            KAMINO_ORBIT = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(SWPlanets.MODID, "kamino_orbit"));
            ENDOR = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(SWPlanets.MODID, "endor"));
            ENDOR_ORBIT = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(SWPlanets.MODID, "endor_orbit"));
            HOT = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(SWPlanets.MODID, "hot"));
            HOT_ORBIT = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(SWPlanets.MODID, "hot_orbit"));
            MUSTAFAR = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(SWPlanets.MODID, "mustafar"));
            MUSTAFAR_ORBIT = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(SWPlanets.MODID, "mustafar_orbit"));



        }


}
