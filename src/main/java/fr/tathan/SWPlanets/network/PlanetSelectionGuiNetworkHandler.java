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

        /** Teleport Planet Button */
        if (message.getInteger() == 1) {
            message.defaultOptions(player);
            Methods.teleportButton(player, PlanetsRegistry.TATOOINE, false);
        }

        /** Teleport Orbit Button */
        if (message.getInteger() == 2) {
            message.defaultOptions(player);
            Methods.teleportButton(player, PlanetsRegistry.TATOOINE_ORBIT, false);
        }

        /** Teleport Space Station Button */
        if (message.getInteger() == 3) {
            message.defaultOptions(player);
            message.deleteItems(player);
            Methods.teleportButton(player, PlanetsRegistry.TATOOINE_ORBIT, true);
        }

        /**
         *
         * KAMINO
         *
         */

        /** Teleport Planet Button */
        if (message.getInteger() == 4) {
            message.defaultOptions(player);
            Methods.teleportButton(player, PlanetsRegistry.KAMINO, false);
        }

        /** Teleport Orbit Button */
        if (message.getInteger() == 5) {
            message.defaultOptions(player);
            Methods.teleportButton(player, PlanetsRegistry.KAMINO_ORBIT, false);
        }

        /** Teleport Space Station Button */
        if (message.getInteger() == 6) {
            message.defaultOptions(player);
            message.deleteItems(player);
            Methods.teleportButton(player, PlanetsRegistry.KAMINO_ORBIT, true);
        }

        /**
         *
         * ENDOR
         *
         */

        /** Teleport Planet Button */
        if (message.getInteger() == 7) {
            message.defaultOptions(player);
            Methods.teleportButton(player, PlanetsRegistry.ENDOR, false);
        }

        /** Teleport Orbit Button */
        if (message.getInteger() == 8) {
            message.defaultOptions(player);
            Methods.teleportButton(player, PlanetsRegistry.ENDOR_ORBIT, false);
        }

        /** Teleport Space Station Button */
        if (message.getInteger() == 9) {
            message.defaultOptions(player);
            message.deleteItems(player);
            Methods.teleportButton(player, PlanetsRegistry.ENDOR_ORBIT, true);
        }

        /**
         *
         * ENDOR
         *
         */

        /** Teleport Planet Button */
        if (message.getInteger() == 10) {
            message.defaultOptions(player);
            Methods.teleportButton(player, PlanetsRegistry.HOT, false);
        }

        /** Teleport Orbit Button */
        if (message.getInteger() == 11) {
            message.defaultOptions(player);
            Methods.teleportButton(player, PlanetsRegistry.HOT_ORBIT, false);
        }

        /** Teleport Space Station Button */
        if (message.getInteger() == 12) {
            message.defaultOptions(player);
            message.deleteItems(player);
            Methods.teleportButton(player, PlanetsRegistry.HOT_ORBIT, true);
        }


        context.setPacketHandled(true);
    }
}