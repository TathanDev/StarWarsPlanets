package fr.tathan.SWPlanets;

import com.mojang.logging.LogUtils;
import fr.tathan.SWPlanets.config.ClientConfigs;
import fr.tathan.SWPlanets.config.CommonConfig;
import  fr.tathan.SWPlanets.network.PlanetSelectionGuiNetworkHandler;
import fr.tathan.SWPlanets.registries.BlocksRegistry;
import fr.tathan.SWPlanets.registries.FeatureRegistry;
import fr.tathan.SWPlanets.registries.ItemsRegistry;
import fr.tathan.SWPlanets.registries.SoundsRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.slf4j.Logger;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Mod(SWPlanets.MODID)
public class SWPlanets {

    public static final String MODID = "swplanets";
    public static final Logger LOGGER = LogUtils.getLogger();

    /** PACKET HANDLER */
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, MODID), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
    private static int messageID;

    public SWPlanets() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.register(this);

        //CONFIGS
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC, "starwarsplanets-common.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfigs.SPEC, "starwarsplanets-client.toml");


        ItemsRegistry.ITEMS.register(bus);
        SoundsRegistry.SOUNDS.register(bus);
        BlocksRegistry.BLOCKS.register(bus);
        FeatureRegistry.FEATURES.register(bus);
        FeatureRegistry.CONFIGURED_FEATURES.register(bus);
        FeatureRegistry.PLACED_FEATURES.register(bus);


        // NETWORK
        SWPlanets.addNetworkMessage(PlanetSelectionGuiNetworkHandler.class, PlanetSelectionGuiNetworkHandler::encode, PlanetSelectionGuiNetworkHandler::decode, PlanetSelectionGuiNetworkHandler::handle);
    }

    public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
        PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
        messageID++;
    }
}
