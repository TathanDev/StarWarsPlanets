package fr.tathan.SWPlanets.events;
/**

import fr.tathan.SWPlanets.SWPlanets;
import fr.tathan.SWPlanets.entities.renderer.speeder.SpeederItemRenderer;
import fr.tathan.SWPlanets.entities.renderer.speeder.SpeederModel;
import fr.tathan.SWPlanets.entities.renderer.speeder.SpeederRenderer;
import fr.tathan.SWPlanets.gui.speeder.SpeederGuiWindow;
import fr.tathan.SWPlanets.registries.EntitiesRegistry;
import fr.tathan.SWPlanets.registries.ScreensRegistry;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.gui.OverlayRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.mrscauthd.beyond_earth.BeyondEarthMod;
import net.mrscauthd.beyond_earth.entities.renderer.TileEntityBoxRenderer;
import net.mrscauthd.beyond_earth.entities.renderer.alien.AlienModel;
import net.mrscauthd.beyond_earth.entities.renderer.alienzombie.AlienZombieModel;
import net.mrscauthd.beyond_earth.entities.renderer.alienzombie.AlienZombieRenderer;
import net.mrscauthd.beyond_earth.entities.renderer.flag.TileEntityHeadModel;
import net.mrscauthd.beyond_earth.entities.renderer.flag.TileEntityHeadRenderer;
import net.mrscauthd.beyond_earth.entities.renderer.globe.GlobeModel;
import net.mrscauthd.beyond_earth.entities.renderer.globe.GlobeRenderer;
import net.mrscauthd.beyond_earth.entities.renderer.lander.LanderModel;
import net.mrscauthd.beyond_earth.entities.renderer.lander.LanderRenderer;
import net.mrscauthd.beyond_earth.entities.renderer.martianraptor.MartianRaptorModel;
import net.mrscauthd.beyond_earth.entities.renderer.martianraptor.MartianRaptorRenderer;
import net.mrscauthd.beyond_earth.entities.renderer.mogler.MoglerModel;
import net.mrscauthd.beyond_earth.entities.renderer.mogler.MoglerRenderer;
import net.mrscauthd.beyond_earth.entities.renderer.pygro.PygroModel;
import net.mrscauthd.beyond_earth.entities.renderer.pygro.PygroRenderer;
import net.mrscauthd.beyond_earth.entities.renderer.pygrobrute.PygroBruteRenderer;
import net.mrscauthd.beyond_earth.entities.renderer.rockettier1.RocketTier1ItemRenderer;
import net.mrscauthd.beyond_earth.entities.renderer.rockettier1.RocketTier1Model;
import net.mrscauthd.beyond_earth.entities.renderer.rockettier1.RocketTier1Renderer;
import net.mrscauthd.beyond_earth.entities.renderer.rockettier2.RocketTier2ItemRenderer;
import net.mrscauthd.beyond_earth.entities.renderer.rockettier2.RocketTier2Model;
import net.mrscauthd.beyond_earth.entities.renderer.rockettier2.RocketTier2Renderer;
import net.mrscauthd.beyond_earth.entities.renderer.rockettier3.RocketTier3ItemRenderer;
import net.mrscauthd.beyond_earth.entities.renderer.rockettier3.RocketTier3Model;
import net.mrscauthd.beyond_earth.entities.renderer.rockettier3.RocketTier3Renderer;
import net.mrscauthd.beyond_earth.entities.renderer.rockettier4.RocketTier4ItemRenderer;
import net.mrscauthd.beyond_earth.entities.renderer.rockettier4.RocketTier4Model;
import net.mrscauthd.beyond_earth.entities.renderer.rockettier4.RocketTier4Renderer;
import net.mrscauthd.beyond_earth.entities.renderer.rover.RoverItemRenderer;
import net.mrscauthd.beyond_earth.entities.renderer.rover.RoverModel;
import net.mrscauthd.beyond_earth.entities.renderer.rover.RoverRenderer;
import net.mrscauthd.beyond_earth.entities.renderer.starcrawler.StarCrawlerModel;
import net.mrscauthd.beyond_earth.entities.renderer.starcrawler.StarCrawlerRenderer;
import net.mrscauthd.beyond_earth.guis.screens.coalgenerator.CoalGeneratorGuiWindow;
import net.mrscauthd.beyond_earth.guis.screens.compressor.CompressorGuiWindow;
import net.mrscauthd.beyond_earth.guis.screens.fuelrefinery.FuelRefineryGuiWindow;
import net.mrscauthd.beyond_earth.guis.screens.lander.LanderGuiWindow;
import net.mrscauthd.beyond_earth.guis.screens.nasaworkbench.NasaWorkbenchGuiWindow;
import net.mrscauthd.beyond_earth.guis.screens.oxygenbubbledistributor.OxygenBubbleDistributorGuiWindow;
import net.mrscauthd.beyond_earth.guis.screens.oxygenloader.OxygenLoaderGuiWindow;
import net.mrscauthd.beyond_earth.guis.screens.planetselection.PlanetSelectionGuiWindow;
import net.mrscauthd.beyond_earth.guis.screens.rocket.RocketGuiWindow;
import net.mrscauthd.beyond_earth.guis.screens.rover.RoverGuiWindow;
import net.mrscauthd.beyond_earth.guis.screens.solarpanel.SolarPanelGuiWindow;
import net.mrscauthd.beyond_earth.guis.screens.waterpump.WaterPumpGuiWindow;
import net.mrscauthd.beyond_earth.overlays.Overlays;
import net.mrscauthd.beyond_earth.particles.*;
import net.mrscauthd.beyond_earth.entities.renderer.alien.AlienRenderer;
import org.lwjgl.glfw.GLFW;


@Mod.EventBusSubscriber(modid = SWPlanets.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    public static final SpeederItemRenderer SPEEDER_ITEM_RENDERER = new SpeederItemRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());

    @SubscribeEvent
    public static void registerEntityRenderingHandler(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntitiesRegistry.SPEEDER.get(), SpeederRenderer::new);


    }

    @SubscribeEvent
    public static void registerEntityRenderingHandler(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(SpeederModel.LAYER_LOCATION, SpeederModel::createBodyLayer);

    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {

        MenuScreens.register(ScreensRegistry.SPEEDER_GUI.get(), SpeederGuiWindow::new);

    }

    }
*/