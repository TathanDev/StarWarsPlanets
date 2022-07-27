package fr.tathan.SWPlanets.events;

import fr.tathan.SWPlanets.SWPlanets;
import fr.tathan.SWPlanets.registries.PlanetsRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mrscauthd.beyond_earth.BeyondEarth;
import net.mrscauthd.beyond_earth.client.events.forge.PlanetOverlayEvent;

@Mod.EventBusSubscriber(modid = SWPlanets.MODID, value = Dist.CLIENT)
public class ModClientEvents {

    private static final ResourceLocation ENDOR_BAR_TEXTURE = new ResourceLocation(SWPlanets.MODID, "textures/planet_bar/endor_planet_bar.png");
    private static final ResourceLocation HOT_BAR_TEXTURE = new ResourceLocation(BeyondEarth.MODID, "textures/planet_bar/glacio_planet_bar.png");
    private static final ResourceLocation TATOOINE_BAR_TEXTURE = new ResourceLocation(SWPlanets.MODID, "textures/planet_bar/tatooine_planet_bar.png");
    private static final ResourceLocation KAMINO_BAR_TEXTURE = new ResourceLocation(SWPlanets.MODID, "textures/planet_bar/kamino_planet_bar.png");
    

    @SubscribeEvent
    public static void overlayChange(PlanetOverlayEvent event) {
        Level level = Minecraft.getInstance().level;

        if (level.dimension() == PlanetsRegistry.TATOOINE) {
            event.setResourceLocation(TATOOINE_BAR_TEXTURE);
        }  else  if (level.dimension() == PlanetsRegistry.HOT) {
            event.setResourceLocation(HOT_BAR_TEXTURE);
        } else  if (level.dimension() == PlanetsRegistry.ENDOR) {
            event.setResourceLocation(ENDOR_BAR_TEXTURE);
        } else  if (level.dimension() == PlanetsRegistry.KAMINO) {
            event.setResourceLocation(KAMINO_BAR_TEXTURE);
        }
    }

}
