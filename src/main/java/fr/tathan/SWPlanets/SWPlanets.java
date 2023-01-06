package fr.tathan.SWPlanets;

import fr.tathan.SWPlanets.config.ClientConfigs;
import fr.tathan.SWPlanets.config.CommonConfig;
import fr.tathan.SWPlanets.network.SWPlanetsNetworkRegistry;
import fr.tathan.SWPlanets.registries.*;
import fr.tathan.SWPlanets.world.oregen.OreGeneration;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
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

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC, "starwarsplanets-common.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfigs.SPEC, "starwarsplanets-client.toml");


        ItemsRegistry.ITEMS.register(bus);
        SoundsRegistry.SOUNDS.register(bus);
        BlocksRegistry.BLOCKS.register(bus);
        FeatureRegistry.FEATURES.register(bus);
        FeatureRegistry.CONFIGURED_FEATURES.register(bus);
        FeatureRegistry.PLACED_FEATURES.register(bus);
        StructuresRegistry.STRUCTURES.register(bus);
        OreGeneration.CONFIGURED_FEATURES.register(bus);
        LevelRegistry.init();

        SWPlanetsNetworkRegistry.register();



    
    }

}
