package fr.tathan.SWPlanets.events;

import fr.tathan.SWPlanets.SWPlanets;
import fr.tathan.SWPlanets.world.PlanetsRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mrscauthd.beyond_earth.BeyondEarthMod;
import net.mrscauthd.beyond_earth.events.forge.PlanetOverlayEvent;

@Mod.EventBusSubscriber(modid = SWPlanets.MODID, value = Dist.CLIENT)
public class ModClientEvents {

    private static final ResourceLocation PLANET_BAR_TEXTURE = new ResourceLocation(BeyondEarthMod.MODID, "textures/planet_bar/moon_planet_bar.png");

    @SubscribeEvent
    public static void overlayChange(PlanetOverlayEvent event) {
        Level level = Minecraft.getInstance().level;

        //TODO YOU NEED TO DO IT WITH YOUR PLANETS SELF
        if (level.dimension() == PlanetsRegistry.ENDOR) {
            event.setResourceLocation(PLANET_BAR_TEXTURE);
        }
    }
}
