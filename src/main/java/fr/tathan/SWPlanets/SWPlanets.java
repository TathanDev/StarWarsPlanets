package fr.tathan.SWPlanets;

import com.mojang.logging.LogUtils;
import  fr.tathan.SWPlanets.network.PlanetSelectionGuiNetworkHandler;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
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
        MinecraftForge.EVENT_BUS.register(this);

        // NETWORK
        SWPlanets.addNetworkMessage(PlanetSelectionGuiNetworkHandler.class, PlanetSelectionGuiNetworkHandler::encode, PlanetSelectionGuiNetworkHandler::decode, PlanetSelectionGuiNetworkHandler::handle);
    }

    public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
        PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
        messageID++;
    }
}
