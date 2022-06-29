package fr.tathan.SWPlanets.events;

import fr.tathan.SWPlanets.SWPlanets;
import fr.tathan.SWPlanets.config.ClientConfigs;
import fr.tathan.SWPlanets.events.forge.PlanetOverlayEvent;
import fr.tathan.SWPlanets.registries.PlanetsRegistry;
import fr.tathan.SWPlanets.util.CustomTitleScreenPlanet;
import fr.tathan.SWPlanets.util.CustomTitleScreenStars;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mrscauthd.beyond_earth.BeyondEarthMod;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ScreenOpenEvent;



@Mod.EventBusSubscriber(modid = SWPlanets.MODID, value = Dist.CLIENT)
public class ModClientEvents {

    private static final ResourceLocation ENDOR_BAR_TEXTURE = new ResourceLocation(SWPlanets.MODID, "textures/planet_bar/endor_planet_bar.png");
    private static final ResourceLocation HOT_BAR_TEXTURE = new ResourceLocation(BeyondEarthMod.MODID, "textures/planet_bar/glacio_planet_bar.png");
    private static final ResourceLocation TATOOINE_BAR_TEXTURE = new ResourceLocation(SWPlanets.MODID, "textures/planet_bar/tatooine_planet_bar.png");
    private static final ResourceLocation KAMINO_BAR_TEXTURE = new ResourceLocation(SWPlanets.MODID, "textures/planet_bar/kamino_planet_bar.png");

    @SubscribeEvent
    public static void overlayChange(PlanetOverlayEvent event) {
        Level level = Minecraft.getInstance().level;
        if (level.dimension() == PlanetsRegistry.ENDOR) {
            event.setResourceLocation(ENDOR_BAR_TEXTURE);

        } else if (level.dimension() == PlanetsRegistry.HOT) {
            event.setResourceLocation(HOT_BAR_TEXTURE);

        } else if (level.dimension() == PlanetsRegistry.TATOOINE) {
            event.setResourceLocation(TATOOINE_BAR_TEXTURE);

        } else if (level.dimension() == PlanetsRegistry.KAMINO) {
            event.setResourceLocation(KAMINO_BAR_TEXTURE);
        }
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void openGui(ScreenOpenEvent event) {

        if (ClientConfigs.CUSTOMEMENUACTIVATE.get()) {
            //I think that when you see this code you will suffer (sorry)
            if (ClientConfigs.CUSTOMEMENU.get() == 1) {

                if (event.getScreen() instanceof TitleScreen && !(event.getScreen() instanceof CustomTitleScreenStars)) {
                    event.setScreen(new CustomTitleScreenStars());
                }
            } else if (ClientConfigs.CUSTOMEMENU.get() == 2) {
                if (event.getScreen() instanceof TitleScreen && !(event.getScreen() instanceof CustomTitleScreenPlanet)) {
                    event.setScreen(new CustomTitleScreenPlanet());
                }
            } else {
                if (event.getScreen() instanceof TitleScreen && !(event.getScreen() instanceof CustomTitleScreenStars)) {
                    event.setScreen(new CustomTitleScreenStars());
                }

            }
        }
    }
}


