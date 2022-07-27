package fr.tathan.SWPlanets.network;
import fr.tathan.SWPlanets.SWPlanets;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class SWPlanetsNetworkRegistry {

    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(SWPlanets.MODID, SWPlanets.MODID), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
    private static int messageID;

    public static void register() {
        addNetworkMessage(PlanetSelectionGuiNetworkHandler.class, PlanetSelectionGuiNetworkHandler::encode, PlanetSelectionGuiNetworkHandler::decode, PlanetSelectionGuiNetworkHandler::handle);
    }

    private static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
        PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
        messageID++;
    }

}
