package fr.tathan.SWPlanets.events;


import fr.tathan.SWPlanets.SWPlanets;
import fr.tathan.SWPlanets.overlays.Overlays;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.gui.OverlayRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = SWPlanets.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {

        //OVERLAY
        OverlayRegistry.registerOverlayBottom("rocket_height", Overlays.ROCKET_BAR);
    }
}
