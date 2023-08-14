package fr.tathan.SWPlanets.events;

import fr.tathan.SWPlanets.SWPlanets;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mrscauthd.beyond_earth.BeyondEarth;
import net.mrscauthd.beyond_earth.common.events.forge.PlanetRegisterEvent;
import net.mrscauthd.beyond_earth.common.util.Planets;

import fr.tathan.SWPlanets.registries.LevelRegistry;



@Mod.EventBusSubscriber(modid = SWPlanets.MODID)
public class PlanetRegistry {
    private static final ResourceLocation SUN_TEXTURE = new ResourceLocation(BeyondEarth.MODID,
            "textures/environment/planet/sun.png");

    private static final ResourceLocation TATOOINE_PLANET_BAR = new ResourceLocation(SWPlanets.MODID,
            "textures/planet_bar/tatooine_planet_bar.png");
    private static final ResourceLocation KAMINO_PLANET_BAR = new ResourceLocation(SWPlanets.MODID,
            "textures/planet_bar/kamino_planet_bar.png");
    private static final ResourceLocation ENDOR_PLANET_BAR = new ResourceLocation(SWPlanets.MODID,
            "textures/planet_bar/endor_planet_bar.png");
    private static final ResourceLocation MUSTAFAR_PLANET_BAR = new ResourceLocation(BeyondEarth.MODID,
            "textures/planet_bar/mercury_planet_bar.png");
    private static final ResourceLocation HOT_PLANET_BAR = new ResourceLocation(BeyondEarth.MODID,
            "textures/planet_bar/glacio_planet_bar.png");

    private static final ResourceLocation TATOOINE_TEXTURE = new ResourceLocation(SWPlanets.MODID, "textures/sky/tatooine.png");
    private static final ResourceLocation KAMINO_TEXTURE = new ResourceLocation(SWPlanets.MODID, "textures/sky/kamino.png");
    private static final ResourceLocation ENDOR_TEXTURE = new ResourceLocation(SWPlanets.MODID, "textures/sky/endor.png");
    private static final ResourceLocation HOT_TEXTURE = new ResourceLocation(SWPlanets.MODID, "textures/sky/hot.png");
    private static final ResourceLocation MUSTAFAR_TEXTURE = new ResourceLocation(SWPlanets.MODID, "textures/sky/mustafar.png");

    public static final float PLANET_ORBIT_SCALE = 149598023;

    private static final double PLANET_MASS_SCALE = 5.9e24;
    private static final double STAR_MASS_SCALE = 2e30;


    @SubscribeEvent
    public static void registerPlanets(PlanetRegisterEvent.Load event) {

        registerPlanets();
    }

    public static void registerPlanets() {
        SWPlanets.LOGGER.info("Registering planets");
        Planets.registerPlanet(LevelRegistry.TATOOINE, LevelRegistry.TATOOINE_ORBIT);
        Planets.registerPlanet(LevelRegistry.KAMINO, LevelRegistry.KAMINO_ORBIT);
        Planets.registerPlanet(LevelRegistry.ENDOR, LevelRegistry.ENDOR_ORBIT);
        Planets.registerPlanet(LevelRegistry.HOT, LevelRegistry.HOT_ORBIT);
        Planets.registerPlanet(LevelRegistry.MUSTAFAR, LevelRegistry.MUSTAFAR_ORBIT);

        Planets.registerPlanetBar(LevelRegistry.TATOOINE, TATOOINE_PLANET_BAR);
        Planets.registerPlanetBar(LevelRegistry.KAMINO, KAMINO_PLANET_BAR);
        Planets.registerPlanetBar(LevelRegistry.ENDOR, ENDOR_PLANET_BAR);
        Planets.registerPlanetBar(LevelRegistry.HOT, HOT_PLANET_BAR);
        Planets.registerPlanetBar(LevelRegistry.MUSTAFAR, MUSTAFAR_PLANET_BAR);

        Planets.StarSystem starwars = new Planets.StarSystem();
        starwars.name = "starwars";
        starwars.texture = SUN_TEXTURE;


        Planets.Planet tatooine = Planets.BY_DIMENSION.get(LevelRegistry.TATOOINE);
        tatooine.orbitRadius = 0.39f * PLANET_ORBIT_SCALE;
        tatooine.mass = 0.055f * PLANET_MASS_SCALE;
        tatooine.orbit = LevelRegistry.TATOOINE_ORBIT;
        tatooine.texture = TATOOINE_TEXTURE;
        tatooine.rotation = 270;
        tatooine.tier = 4;
        tatooine.g = 0.38f;
        tatooine.radius = 2439.7;
        tatooine.temperature = 55;
        tatooine.hasRain = false;
        tatooine.orbitColour = new int[] { 179, 49, 44 };
        tatooine.hasDustStorms = true;


        Planets.Planet mustafar = Planets.BY_DIMENSION.get(LevelRegistry.MUSTAFAR);
        mustafar.orbitRadius = 0.72f * PLANET_ORBIT_SCALE;
        mustafar.orbit = LevelRegistry.MUSTAFAR_ORBIT;
        mustafar.mass = 0.81f * PLANET_MASS_SCALE;
        mustafar.texture = MUSTAFAR_TEXTURE;
        mustafar.rotation = 180;
        mustafar.tier = 4;
        mustafar.g = 0.904f;
        mustafar.radius = 6051.8;
        mustafar.temperature = 330;
        mustafar.hasRain = false;
        mustafar.airDensity = 100;
        mustafar.orbitColour = new int[] { 235, 136, 68 };

        Planets.Planet endor = Planets.BY_DIMENSION.get(LevelRegistry.ENDOR);
        endor.orbit = LevelRegistry.ENDOR_ORBIT;

        endor.texture = ENDOR_TEXTURE;
        endor.rotation = 90;
        endor.tier = 4;
        endor.radius = 6371.0;
        endor.airDensity = 1;
        endor.hasOxygen = true;
        endor.spaceLevel = false;
        endor.hasRain = true;
        endor.orbitColour = new int[] { 53, 163, 79 };


        Planets.Planet kamino = Planets.BY_DIMENSION.get(LevelRegistry.KAMINO);
        kamino.orbitRadius = 1.52f * PLANET_ORBIT_SCALE;
        kamino.orbit = LevelRegistry.KAMINO_ORBIT;

        kamino.mass = 0.107f * PLANET_MASS_SCALE;
        kamino.texture = KAMINO_TEXTURE;
        kamino.tier = 4;
        kamino.radius = 3389.5;
        kamino.g = 0.3794f;
        kamino.temperature = -63;
        kamino.airDensity = 0.001f;
        kamino.hasRain = true;
        kamino.orbitColour = new int[] { 37, 49, 146 };

        Planets.Planet hot = Planets.BY_DIMENSION.get(LevelRegistry.HOT);
        hot.orbitRadius = 1.52f * PLANET_ORBIT_SCALE;
        hot.mass = 0.107f * PLANET_MASS_SCALE;
        hot.texture = HOT_TEXTURE;
        hot.tier = 4;
        hot.radius = 3389.5;
        hot.g = 0.3794f;
        hot.temperature = -63;
        hot.airDensity = 0.001f;
        hot.hasRain = true;
        hot.orbitColour = new int[] { 37, 49, 146 };
        hot.orbit = LevelRegistry.HOT_ORBIT;

        starwars.addChild(tatooine);
        starwars.addChild(mustafar);
        starwars.addChild(endor);
        starwars.addChild(hot);
        //starwars.addChild(kamino);
        starwars.register();


    }

}
