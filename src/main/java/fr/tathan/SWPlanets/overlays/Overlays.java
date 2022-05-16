package fr.tathan.SWPlanets.overlays;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import fr.tathan.SWPlanets.SWPlanets;
import fr.tathan.SWPlanets.events.PlanetsMethods;
import fr.tathan.SWPlanets.world.PlanetsRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.client.gui.IIngameOverlay;
import net.minecraftforge.client.gui.OverlayRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mrscauthd.beyond_earth.BeyondEarthMod;
import net.mrscauthd.beyond_earth.entities.LanderEntity;
import net.mrscauthd.beyond_earth.events.Methods;
import net.mrscauthd.beyond_earth.guis.helper.GuiHelper;

@Mod.EventBusSubscriber(modid = SWPlanets.MODID, value = Dist.CLIENT)
public class Overlays {

    private static boolean check = false;
    private static float counter = 0;



    private static final ResourceLocation TATOOINE_BAR_TEXTURE = new ResourceLocation(SWPlanets.MODID, "textures/planet_bar/tatooine_planet_bar.png");
    private static final ResourceLocation KAMINO_BAR_TEXTURE = new ResourceLocation(SWPlanets.MODID, "textures/planet_bar/kamino_planet_bar.png");
    private static final ResourceLocation ENDOR_BAR_TEXTURE = new ResourceLocation(SWPlanets.MODID, "textures/planet_bar/endor_planet_bar.png");

    private static final ResourceLocation EARTH_PLANET_BAR_TEXTURE = new ResourceLocation(BeyondEarthMod.MODID, "textures/planet_bar/earth_planet_bar.png");
    private static final ResourceLocation ORBIT_PLANET_BAR_TEXTURE = new ResourceLocation(BeyondEarthMod.MODID, "textures/planet_bar/orbit_planet_bar.png");
    private static final ResourceLocation ROCKET_PLANET_BAR_TEXTURE = new ResourceLocation(BeyondEarthMod.MODID, "textures/planet_bar/rocket.png");

    @SubscribeEvent
    public static void overlayEnableOrDisable(RenderGameOverlayEvent.PostLayer event) {
        Player player = Minecraft.getInstance().player;

        /** ROCKET HEIGHT */
        if (Methods.isRocket(player.getVehicle()) || player.getVehicle() instanceof LanderEntity) {
            OverlayRegistry.enableOverlay(Overlays.ROCKET_BAR, true);
        } else {
            OverlayRegistry.enableOverlay(Overlays.ROCKET_BAR, false);
        }
    }



    public static IIngameOverlay ROCKET_BAR = new IIngameOverlay() {
        @Override
        public void render(ForgeIngameGui gui, PoseStack mStack, float partialTicks, int width, int height) {
            Player player = Minecraft.getInstance().player;
            Level world = Minecraft.getInstance().level;

            float yHeight = (float) player.getY() / 5.3F;

            if (yHeight < 0) {
                yHeight = 0;
            }
            else if (yHeight > 113) {
                yHeight = 113;
            }

            ResourceLocation planet;

            if (Methods.isWorld(world, PlanetsRegistry.TATOOINE)) {
                planet = TATOOINE_BAR_TEXTURE;
            }
            else if (Methods.isWorld(world, PlanetsRegistry.KAMINO)) {
                planet = KAMINO_BAR_TEXTURE;
            }
            else if (Methods.isWorld(world, PlanetsRegistry.ENDOR)) {
                planet = ENDOR_BAR_TEXTURE;
            }
            else if (PlanetsMethods.isOrbitWorld(world)) {
                planet = ORBIT_PLANET_BAR_TEXTURE;
            }
            else {
                planet = EARTH_PLANET_BAR_TEXTURE;
            }

            /** ROCKET BAR IMAGE */
            RenderSystem.setShaderTexture(0, planet);
            gui.blit(mStack, 0, (height / 2) - 128 / 2, 0, 0, 16, 128, 16, 128);

            /** ROCKET_Y IMAGE */
            RenderSystem.setShaderTexture(0, ROCKET_PLANET_BAR_TEXTURE);
            GuiHelper.blit(mStack, 4, (height / 2) + (103 / 2) - yHeight, 0, 0, 8, 11, 8, 11);
        }
    };
}

