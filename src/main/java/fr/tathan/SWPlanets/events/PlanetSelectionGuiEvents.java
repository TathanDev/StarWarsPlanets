package  fr.tathan.SWPlanets.events;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.tathan.SWPlanets.SWPlanets;
import  fr.tathan.SWPlanets.network.PlanetSelectionGuiNetworkHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mrscauthd.beyond_earth.events.forgeevents.PlanetSelectionGuiBackgroundRenderEvent;
import net.mrscauthd.beyond_earth.events.forgeevents.PlanetSelectionGuiButtonVisibilityEvent;
import net.mrscauthd.beyond_earth.events.forgeevents.PlanetSelectionGuiInitEvent;
import net.mrscauthd.beyond_earth.guis.helper.ImageButtonPlacer;
import net.mrscauthd.beyond_earth.guis.screens.planetselection.PlanetSelectionGuiWindow;
import net.mrscauthd.beyond_earth.guis.screens.planetselection.helper.CategoryHelper;
import net.mrscauthd.beyond_earth.guis.screens.planetselection.helper.PlanetSelectionGuiHelper;

import java.util.List;

@Mod.EventBusSubscriber(modid = SWPlanets.MODID, value = Dist.CLIENT)
public class PlanetSelectionGuiEvents {

    /** TEXT */
    public static final Component SOLAR_SYSTEM_BUTTON_TEXT = tl("solar_system_button");
    public static final Component TATOOINE_BUTTON_TEXT = tl("tatooine_button");

    public static final Component KAMINO_BUTTON_TEXT = tl("kamino_button");


    /** BUTTONS */
    private static ImageButtonPlacer backButton;

    private static ImageButtonPlacer solarSystemButton;


    private static ImageButtonPlacer tatooineCategoryButton;
    private static ImageButtonPlacer tatooineHandlerButton;
    private static ImageButtonPlacer tatooineOrbitHandlerButton;
    private static ImageButtonPlacer tatooineSpaceStationHandlerButton;

    private static ImageButtonPlacer kaminoCategoryButton;
    private static ImageButtonPlacer kaminoHandlerButton;
    private static ImageButtonPlacer kaminoOrbitHandlerButton;
    private static ImageButtonPlacer kaminoSpaceStationHandlerButton;

    /** CATEGORY */
    private static CategoryHelper category;

    /** TEXTURES */
    public static final ResourceLocation TATOOINE_TEXTURE = new ResourceLocation(SWPlanets.MODID, "textures/sky/tatooine.png");
    public static final ResourceLocation KAMINO_TEXTURE = new ResourceLocation(SWPlanets.MODID, "textures/sky/kamino.png");



    @SubscribeEvent
    public static void buttonVisibilityPre(PlanetSelectionGuiButtonVisibilityEvent.Pre event) {
        PlanetSelectionGuiWindow screen = (PlanetSelectionGuiWindow) event.getScreen();

        /** SET THE MAIN (BEYOND EARTH) CATEGORY TO -1 */
        if (PlanetSelectionGuiHelper.categoryRange(category.get(), 1,2)) {
            screen.category.set(-1);
        }
    }

    @SubscribeEvent
    public static void buttonVisibilityPost(PlanetSelectionGuiButtonVisibilityEvent.Post event) {
        PlanetSelectionGuiWindow screen = (PlanetSelectionGuiWindow) event.getScreen();

        /** BUTTONS VISIBLE SYSTEM */
        screen.visibleButton(backButton, PlanetSelectionGuiHelper.categoryRange(category.get(), 1, 2));

        screen.visibleButton(solarSystemButton, screen.category.get() == 0);
        screen.visibleButton(tatooineCategoryButton, category.get() == 1);
        screen.visibleButton(tatooineHandlerButton, category.get() == 2);
        screen.visibleButton(tatooineOrbitHandlerButton, category.get() == 2);
        screen.visibleButton(tatooineSpaceStationHandlerButton, category.get() == 2);
    }

    @SubscribeEvent
    public static void backgroundRenderPost(PlanetSelectionGuiBackgroundRenderEvent.Post event) {
        PlanetSelectionGuiWindow screen = (PlanetSelectionGuiWindow) event.getScreen();
        PoseStack poseStack = event.getPoseStack();

        /** ENABLE BLEND */
        PlanetSelectionGuiHelper.enableRenderSystem();

        /** SOLAR SYSTEM */
        if (PlanetSelectionGuiHelper.categoryRange(category.get(), 1, 2)) {
            PlanetSelectionGuiHelper.addCircle(screen.width / 2, screen.height / 2, 23.0D, 180);
            PlanetSelectionGuiHelper.addCircle(screen.width / 2, screen.height / 2, 46.0D, 180);

        }

        /** SUN */
        if (PlanetSelectionGuiHelper.categoryRange(category.get(), 1, 2)) {
            PlanetSelectionGuiHelper.addTexture(poseStack, (screen.width - 15) / 2, (screen.height - 15) / 2, 15, 15, PlanetSelectionGuiWindow.SUN_TEXTURE);
        }

        /** PLANETS */
        if (PlanetSelectionGuiHelper.categoryRange(category.get(), 1, 2)) {
            PlanetSelectionGuiHelper.addRotatedObject(screen, poseStack, TATOOINE_TEXTURE, -20.5F, -20.5F, 10, 10, screen.rotationEarth);
            PlanetSelectionGuiHelper.addRotatedObject(screen, poseStack, KAMINO_TEXTURE, -37, -37, 10, 10, screen.rotationMars);

        }

        /** SMALL MENU RENDERER */
        if (PlanetSelectionGuiHelper.categoryRange(category.get(), 1, 1)) {
            PlanetSelectionGuiHelper.addTexture(poseStack, 0, (screen.height / 2) - 177 / 2, 105, 177, PlanetSelectionGuiWindow.SMALL_MENU_LIST);
        }

        /** LARGE MENU RENDERER */
        if (PlanetSelectionGuiHelper.categoryRange(category.get(), 2, 2)) {
            PlanetSelectionGuiHelper.addTexture(poseStack, 0, (screen.height / 2) - 177 / 2, 215, 177, PlanetSelectionGuiWindow.LARGE_MENU_TEXTURE);
        }

        /** DISABLE BLEND */
        PlanetSelectionGuiHelper.disableRenderSystem();
    }

    @SubscribeEvent
    public static void screenInitPost(PlanetSelectionGuiInitEvent.Post event) {
        PlanetSelectionGuiWindow screen = (PlanetSelectionGuiWindow) event.getScreen();

        /** CREATE A CATEGORY */
        category = new CategoryHelper();

        /** SOLAR SYSTEM BUTTON */
        solarSystemButton = PlanetSelectionGuiHelper.addCategoryButton(screen, category, 10, 1, 70, 20, 1, true, ImageButtonPlacer.Types.MILKY_WAY_CATEGORY, List.of(SOLAR_SYSTEM_BUTTON_TEXT.getString()), screen.BLUE_BUTTON_TEXTURE, screen.BLUE_LIGHT_BUTTON_TEXTURE, SOLAR_SYSTEM_BUTTON_TEXT);
        screen.visibleButton(solarSystemButton, false);

        /** BACK BUTTON */
        backButton = PlanetSelectionGuiHelper.addBackButton(screen, 10, 1, 70, 20, PlanetSelectionGuiWindow.DARK_BLUE_BUTTON_TEXTURE, PlanetSelectionGuiWindow.DARK_BLUE_LIGHT_BUTTON_TEXTURE, PlanetSelectionGuiWindow.BACK_TEXT, (onPress) -> {
            if (category.get() == 1) {
                category.set(0);
                screen.category.set(0);
                screen.scrollIndex = 0;
                screen.updateButtonVisibility();
            } else if (PlanetSelectionGuiHelper.categoryRange(category.get(), 2, 3)) {
                category.set(1);
                screen.scrollIndex = 0;
                screen.updateButtonVisibility();
            }
        });
        screen.visibleButton(backButton, false);



        /** TATOOINE BUTTONS */
        tatooineCategoryButton = PlanetSelectionGuiHelper.addCategoryButton(screen, category, 10, 1, 70, 20, 2, screen.checkTier(4), ImageButtonPlacer.Types.SOLAR_SYSTEM_CATEGORY, List.of(TATOOINE_BUTTON_TEXT.getString(), screen.ROCKET_TIER_4_TEXT.getString()), screen.RED_BUTTON_TEXTURE, screen.RED_LIGHT_BUTTON_TEXTURE, TATOOINE_BUTTON_TEXT);
        screen.visibleButton(tatooineCategoryButton, false);

        /** TATOOINE TELEPORT BUTTONS */
        tatooineHandlerButton = PlanetSelectionGuiHelper.addHandlerButton(screen, 10, 1, 70, 20, true, SWPlanets.PACKET_HANDLER, getNetworkHandler(1), ImageButtonPlacer.Types.PLANET_CATEGORY, List.of(screen.PLANET_TEXT.getString(), "3.721 m/s", "a" + screen.OXYGEN_TRUE_TEXT.getString(), "a" + "-20"), screen.BLUE_BUTTON_TEXTURE, screen.BLUE_LIGHT_BUTTON_TEXTURE, TATOOINE_BUTTON_TEXT);
        screen.visibleButton(tatooineHandlerButton, false);

        /** TATOOINE ORBIT TELEPORT BUTTONS */
        tatooineOrbitHandlerButton = PlanetSelectionGuiHelper.addHandlerButton(screen, 84, 2, 37, 20, true, SWPlanets.PACKET_HANDLER, getNetworkHandler(2), ImageButtonPlacer.Types.PLANET_CATEGORY, List.of(screen.ORBIT_TEXT.getString(), screen.NO_GRAVITY_TEXT.getString(), "c" + screen.OXYGEN_FALSE_TEXT.getString(), "c" + "-270"), screen.SMALL_BLUE_BUTTON_TEXTURE, screen.SMALL_BLUE_LIGHT_BUTTON_TEXTURE, screen.ORBIT_TEXT);
        screen.visibleButton(tatooineOrbitHandlerButton, false);

        /** TATOOINE SPACE STATION TELEPORT BUTTONS */
        tatooineSpaceStationHandlerButton = PlanetSelectionGuiHelper.addHandlerButton(screen, 125, 3, 75, 20, screen.spaceStationItemList, SWPlanets.PACKET_HANDLER, getNetworkHandler(3), ImageButtonPlacer.Types.PLANET_SPACE_STATION_CATEGORY, List.of(screen.ORBIT_TEXT.getString(), screen.NO_GRAVITY_TEXT.getString(), "c" + screen.OXYGEN_FALSE_TEXT.getString(), "c" + "-270"), screen.LARGE_RED_BUTTON_TEXTURE, screen.LARGE_RED_LIGHT_BUTTON_TEXTURE, screen.SPACE_STATION_TEXT);
        screen.visibleButton(tatooineSpaceStationHandlerButton, false);

        /**
         *
         * KAMINO
         *
         */

        /** KAMINO BUTTONS */
        kaminoCategoryButton = PlanetSelectionGuiHelper.addCategoryButton(screen, category, 10, 1, 70, 20, 3, screen.checkTier(4), ImageButtonPlacer.Types.SOLAR_SYSTEM_CATEGORY, List.of(TATOOINE_BUTTON_TEXT.getString(), screen.ROCKET_TIER_4_TEXT.getString()), screen.RED_BUTTON_TEXTURE, screen.RED_LIGHT_BUTTON_TEXTURE, TATOOINE_BUTTON_TEXT);
        screen.visibleButton(tatooineCategoryButton, false);

        /** KAMINO TELEPORT BUTTONS */
        kaminoHandlerButton = PlanetSelectionGuiHelper.addHandlerButton(screen, 10, 1, 70, 20, true, SWPlanets.PACKET_HANDLER, getNetworkHandler(4), ImageButtonPlacer.Types.PLANET_CATEGORY, List.of(screen.PLANET_TEXT.getString(), "3.721 m/s", "a" + screen.OXYGEN_TRUE_TEXT.getString(), "a" + "40"), screen.BLUE_BUTTON_TEXTURE, screen.BLUE_LIGHT_BUTTON_TEXTURE, TATOOINE_BUTTON_TEXT);
        screen.visibleButton(kaminoHandlerButton, false);


        /** UPDATE BUTTON VISIBILITY */
        screen.updateButtonVisibility();
    }

    /** GET NETWORK HANDLER */
    public static PlanetSelectionGuiNetworkHandler getNetworkHandler(int handler) {
        return new PlanetSelectionGuiNetworkHandler(handler);
    }

    /** CREATE A TRANSLATABLE KEY */
    public static Component tl(String string) {
        return new TranslatableComponent("gui." + SWPlanets.MODID + ".planet_selection." + string);
    }
}