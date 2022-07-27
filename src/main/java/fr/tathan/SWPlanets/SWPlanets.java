package fr.tathan.SWPlanets;

import fr.tathan.SWPlanets.network.SWPlanetsNetworkRegistry;
import fr.tathan.SWPlanets.registries.*;
import fr.tathan.SWPlanets.world.oregen.OreGeneration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



@Mod(SWPlanets.MODID)
public class SWPlanets {

    public static final String MODID = "swplanets";
    public static final Logger LOGGER = LogManager.getLogger();

    /** PACKET HANDLER */
    private static int messageID;

    public SWPlanets() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.register(this);

        SWPlanetsNetworkRegistry.register();

        ItemsRegistry.ITEMS.register(bus);
        SoundsRegistry.SOUNDS.register(bus);
        BlocksRegistry.BLOCKS.register(bus);
        //PlanetBiomeModifier.BIOME_MODIFIERS.register(bus);
        OreGeneration.CONFIGURED_FEATURES.register(bus);
        OreGeneration.PLACED_FEATURES.register(bus);




        // NETWORK
    }


}
