package  fr.tathan.SWPlanets.network;

import fr.tathan.SWPlanets.registries.LevelRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.mrscauthd.beyond_earth.common.menus.planetselection.helper.PlanetSelectionMenuNetworkHandlerHelper;
import net.mrscauthd.beyond_earth.common.util.Methods;

import java.util.function.Supplier;

public class PlanetSelectionGuiNetworkHandler extends PlanetSelectionMenuNetworkHandlerHelper {
    private int integer;

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
                Methods.createLanderAndTeleportTo(player, LevelRegistry.TATOOINE, 700, false);
                break;

            case 1:
                message.defaultOptions(player);
                Methods.createLanderAndTeleportTo(player, LevelRegistry.TATOOINE_ORBIT, 700, false);
                break;

            case 2:
                message.defaultOptions(player);
                message.deleteItems(player);
                Methods.createLanderAndTeleportTo(player, LevelRegistry.TATOOINE_ORBIT, 700,true);
                break;

            /** KAMINO */
            case 3:
                message.defaultOptions(player);
                Methods.createLanderAndTeleportTo(player, LevelRegistry.KAMINO, 700,false);
                break;

            case 4:
                message.defaultOptions(player);
                Methods.createLanderAndTeleportTo(player, LevelRegistry.KAMINO_ORBIT, 700,false);
                break;

            case 5:
                message.defaultOptions(player);
                message.deleteItems(player);
                Methods.createLanderAndTeleportTo(player, LevelRegistry.KAMINO_ORBIT, 700,true);
                break;

            /** ENDOR */
            case 6:
                message.defaultOptions(player);
                Methods.createLanderAndTeleportTo(player, LevelRegistry.ENDOR, 700,false);
                break;

            case 7:
                message.defaultOptions(player);
                Methods.createLanderAndTeleportTo(player, LevelRegistry.ENDOR_ORBIT, 700,false);
                break;

            case 8:
                message.defaultOptions(player);
                message.deleteItems(player);
                Methods.createLanderAndTeleportTo(player, LevelRegistry.ENDOR_ORBIT, 700,true);
                break;

            /** HOT */
            case 9:
                message.defaultOptions(player);
                Methods.createLanderAndTeleportTo(player, LevelRegistry.HOT,700, false);
                break;

            case 10:
                message.defaultOptions(player);
                Methods.createLanderAndTeleportTo(player, LevelRegistry.HOT_ORBIT, 700,false);
                break;

            case 11:
                message.defaultOptions(player);
                message.deleteItems(player);
                Methods.createLanderAndTeleportTo(player, LevelRegistry.HOT_ORBIT, 700, true);
                break;
        }

        context.setPacketHandled(true);
    }
}