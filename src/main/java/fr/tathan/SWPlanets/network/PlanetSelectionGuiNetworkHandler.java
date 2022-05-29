package  fr.tathan.SWPlanets.network;

import  fr.tathan.SWPlanets.world.PlanetsRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.mrscauthd.beyond_earth.events.Methods;
import net.mrscauthd.beyond_earth.guis.screens.planetselection.helper.PlanetSelectionGuiNetworkHandlerHelper;

import java.util.function.Supplier;

public class PlanetSelectionGuiNetworkHandler extends PlanetSelectionGuiNetworkHandlerHelper {
    private int integer = 0;

    public PlanetSelectionGuiNetworkHandler(int integer) {
        this.setInteger(integer);
    }

    public int getInteger() {
        return this.integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public PlanetSelectionGuiNetworkHandler(FriendlyByteBuf buffer) {
        this.setInteger(buffer.readInt());
    }

    public static PlanetSelectionGuiNetworkHandler decode(FriendlyByteBuf buffer) {
        return new PlanetSelectionGuiNetworkHandler(buffer);
    }

    public static void encode(PlanetSelectionGuiNetworkHandler message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.getInteger());
    }

    public static void handle(PlanetSelectionGuiNetworkHandler message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        ServerPlayer player = context.getSender();

        switch (message.getInteger()) {

            /** TATOOINE */
            case 0:
                message.defaultOptions(player);
                Methods.teleportButton(player, PlanetsRegistry.TATOOINE, false);
                break;

            case 1:
                message.defaultOptions(player);
                Methods.teleportButton(player, PlanetsRegistry.TATOOINE_ORBIT, false);
                break;

            case 2:
                message.defaultOptions(player);
                message.deleteItems(player);
                Methods.teleportButton(player, PlanetsRegistry.TATOOINE_ORBIT, true);
                break;

            /** KAMINO */
            case 3:
                message.defaultOptions(player);
                Methods.teleportButton(player, PlanetsRegistry.KAMINO, false);
                break;

            case 4:
                message.defaultOptions(player);
                Methods.teleportButton(player, PlanetsRegistry.KAMINO_ORBIT, false);
                break;

            case 5:
                message.defaultOptions(player);
                message.deleteItems(player);
                Methods.teleportButton(player, PlanetsRegistry.KAMINO_ORBIT, true);
                break;

            /** ENDOR */
            case 6:
                message.defaultOptions(player);
                Methods.teleportButton(player, PlanetsRegistry.ENDOR, false);
                break;

            case 7:
                message.defaultOptions(player);
                Methods.teleportButton(player, PlanetsRegistry.ENDOR_ORBIT, false);
                break;

            case 8:
                message.defaultOptions(player);
                message.deleteItems(player);
                Methods.teleportButton(player, PlanetsRegistry.ENDOR_ORBIT, true);
                break;

            /** HOT */
            case 9:
                message.defaultOptions(player);
                Methods.teleportButton(player, PlanetsRegistry.HOT, false);
                break;

            case 10:
                message.defaultOptions(player);
                Methods.teleportButton(player, PlanetsRegistry.HOT_ORBIT, false);
                break;

            case 11:
                message.defaultOptions(player);
                message.deleteItems(player);
                Methods.teleportButton(player, PlanetsRegistry.HOT_ORBIT, true);
                break;
        }

        context.setPacketHandled(true);
    }
}