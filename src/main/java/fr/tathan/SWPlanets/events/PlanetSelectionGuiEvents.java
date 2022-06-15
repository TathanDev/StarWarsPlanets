package fr.tathan.SWPlanets.events;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.tathan.SWPlanets.SWPlanets;
import fr.tathan.SWPlanets.network.PlanetSelectionGuiNetworkHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mrscauthd.beyond_earth.events.forge.PlanetSelectionGuiBackgroundRenderEvent;
import net.mrscauthd.beyond_earth.events.forge.PlanetSelectionGuiButtonVisibilityEvent;
import net.mrscauthd.beyond_earth.events.forge.PlanetSelectionGuiInitEvent;
import net.mrscauthd.beyond_earth.guis.helper.ImageButtonPlacer;
import net.mrscauthd.beyond_earth.guis.screens.planetselection.PlanetSelectionGuiWindow;
import net.mrscauthd.beyond_earth.guis.screens.planetselection.helper.CategoryHelper;
import net.mrscauthd.beyond_earth.guis.screens.planetselection.helper.PlanetSelectionGuiHelper;

import net.minecraftforge.network.simple.SimpleChannel  ;

import java.util.List;

@Mod.EventBusSubscriber(modid = SWPlanets.MODID, value = Dist.CLIENT)
public class PlanetSelectionGuiEvents {

    /** TEXT */
    public static final Component SOLAR_SYSTEM_BUTTON_TEXT = tl("solar_system_button");
    public static final Component TATOOINE_BUTTON_TEXT = tl("tatooine_button");
    public static final Component KAMINO_BUTTON_TEXT = tl("kamino_button");
    public static final Component ENDOR_BUTTON_TEXT = tl("endor_button");
    public static final Component HOT_BUTTON_TEXT = tl("hot_button");

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

    private static ImageButtonPlacer endorCategoryButton;
    private static ImageButtonPlacer endorHandlerButton;
    private static ImageButtonPlacer endorOrbitHandlerButton;
    private static ImageButtonPlacer endorSpaceStationHandlerButton;

    private static ImageButtonPlacer hotCategoryButton;
    private static ImageButtonPlacer hotHandlerButton;
    private static ImageButtonPlacer hotOrbitHandlerButton;
    private static ImageButtonPlacer hotSpaceStationHandlerButton;

    /** CATEGORY */
    private static CategoryHelper category;

    /** TEXTURES */
    public static final ResourceLocation TATOOINE_TEXTURE = new ResourceLocation(SWPlanets.MODID, "textures/sky/tatooine.png");
    public static final ResourceLocation KAMINO_TEXTURE = new ResourceLocation(SWPlanets.MODID, "textures/sky/kamino.png");
    public static final ResourceLocation ENDOR_TEXTURE = new ResourceLocation(SWPlanets.MODID, "textures/sky/endor.png");
    public static final ResourceLocation HOT_TEXTURE = new ResourceLocation(SWPlanets.MODID, "textures/sky/hot.png");

    @SubscribeEvent
    public static void buttonVisibilityPre(PlanetSelectionGuiButtonVisibilityEvent.Pre event) {
        PlanetSelectionGuiWindow screen = (PlanetSelectionGuiWindow) event.getScreen();

        /** SET THE MAIN (BEYOND EARTH) CATEGORY TO -1 */
        if (PlanetSelectionGuiHelper.categoryRange(category.get(), 1,5)) {
            screen.category.set(-1);
        }
    }

    @SubscribeEvent
    public static void buttonVisibilityPost(PlanetSelectionGuiButtonVisibilityEvent.Post event) {
        PlanetSelectionGuiWindow screen = (PlanetSelectionGuiWindow) event.getScreen();

        /** BUTTONS VISIBLE SYSTEM */
        screen.visibleButton(backButton, PlanetSelectionGuiHelper.categoryRange(category.get(), 1, 5));

        screen.visibleButton(solarSystemButton, screen.category.get() == 0);
        screen.visibleButton(tatooineCategoryButton, category.get() == 1);

        screen.visibleButton(tatooineHandlerButton, category.get() == 2);
        screen.visibleButton(tatooineOrbitHandlerButton, category.get() == 2);
        screen.visibleButton(tatooineSpaceStationHandlerButton, category.get() == 2);

        screen.visibleButton(kaminoCategoryButton, category.get() == 1);

        screen.visibleButton(kaminoHandlerButton, category.get() == 3);
        screen.visibleButton(kaminoOrbitHandlerButton, category.get() == 3);
        screen.visibleButton(kaminoSpaceStationHandlerButton, category.get() == 3);

        screen.visibleButton(endorCategoryButton, category.get() == 1);

        screen.visibleButton(endorHandlerButton, category.get() == 4);
        screen.visibleButton(endorOrbitHandlerButton, category.get() == 4);
        screen.visibleButton(endorSpaceStationHandlerButton, category.get() == 4);

        screen.visibleButton(hotCategoryButton, category.get() == 1);

        screen.visibleButton(hotHandlerButton, category.get() == 5);
        screen.visibleButton(hotOrbitHandlerButton, category.get() == 5);
        screen.visibleButton(hotSpaceStationHandlerButton, category.get() == 5);
    }

    @SubscribeEvent
    public static void backgroundRenderPost(PlanetSelectionGuiBackgroundRenderEvent.Post event) {
        PlanetSelectionGuiWindow screen = (PlanetSelectionGuiWindow) event.getScreen();
        PoseStack poseStack = event.getPoseStack();

        System.out.println("FUCK IT IS NULL " + category.get() + " " + screen.category.get());

        /** ENABLE BLEND */
        PlanetSelectionGuiHelper.enableRenderSystem();

        /** SOLAR SYSTEM */
        if (PlanetSelectionGuiHelper.categoryRange(category.get(), 1, 5)) {
            PlanetSelectionGuiHelper.addCircle(screen.width / 2, screen.height / 2, 23.0D, 180);
            PlanetSelectionGuiHelper.addCircle(screen.width / 2, screen.height / 2, 46.0D, 180);
            PlanetSelectionGuiHelper.addCircle(screen.width / 2, screen.height / 2, 69.5D, 180);
            PlanetSelectionGuiHelper.addCircle(screen.width / 2, screen.height / 2, 92.5D, 180);
        }

        /** SUN */
        if (PlanetSelectionGuiHelper.categoryRange(category.get(), 1, 5)) {
            PlanetSelectionGuiHelper.addTexture(poseStack, (screen.width - 15) / 2, (screen.height - 15) / 2, 15, 15, PlanetSelectionGuiWindow.SUN_TEXTURE);
        }

        /** PLANETS */
        if (PlanetSelectionGuiHelper.categoryRange(category.get(), 1, 5)) {
            PlanetSelectionGuiHelper.addRotatedObject(screen, poseStack, TATOOINE_TEXTURE, -20.5F, -20.5F, 10, 10, screen.rotationEarth);
            PlanetSelectionGuiHelper.addRotatedObject(screen, poseStack, KAMINO_TEXTURE, -37, -37, 10, 10, screen.rotationMars);
            PlanetSelectionGuiHelper.addRotatedObject(screen, poseStack, ENDOR_TEXTURE, -54, -54, 10, 10, screen.rotationVenus);
            PlanetSelectionGuiHelper.addRotatedObject(screen, poseStack, HOT_TEXTURE, -70, -70, 10, 10, screen.rotationMercury);
        }

        /** SMALL MENU RENDERER */
        if (PlanetSelectionGuiHelper.categoryRange(category.get(), 1, 1)) {
            PlanetSelectionGuiHelper.addTexture(poseStack, 0, (screen.height / 2) - 177 / 2, 105, 177, PlanetSelectionGuiWindow.SMALL_MENU_LIST);
        }

        /** LARGE MENU RENDERER */
        if (PlanetSelectionGuiHelper.categoryRange(category.get(), 2, 5)) {
            PlanetSelectionGuiHelper.addTexture(poseStack, 0, (screen.height / 2) - 177 / 2, 215, 177, PlanetSelectionGuiWindow.LARGE_MENU_TEXTURE);
        }

        /** DISABLE BLEND */
        PlanetSelectionGuiHelper.disableRenderSystem();
    }

    @SubscribeEvent
    public static void screenInitPost(PlanetSelectionGuiInitEvent.Post event) {
        PlanetSelectionGuiWindow screen = (PlanetSelectionGuiWindow) event.getScreen();

        System.out.println("ERROR NOT FOUNDED");

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
            } else if (PlanetSelectionGuiHelper.categoryRange(category.get(), 2, 5)) {
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
        tatooineHandlerButton = PlanetSelectionGuiHelper.addHandlerButton(screen, 10, 1, 70, 20, true, true, SWPlanets.PACKET_HANDLER, getNetworkHandler(0), ImageButtonPlacer.Types.PLANET_CATEGORY, List.of(screen.PLANET_TEXT.getString(), "3.721 m/s", "a" + screen.OXYGEN_TRUE_TEXT.getString(), "a" + "40"), screen.BLUE_BUTTON_TEXTURE, screen.BLUE_LIGHT_BUTTON_TEXTURE, TATOOINE_BUTTON_TEXT);
        screen.visibleButton(tatooineHandlerButton, false);

        /** TATOOINE ORBIT TELEPORT BUTTONS */
        tatooineOrbitHandlerButton = PlanetSelectionGuiHelper.addHandlerButton(screen, 84, 2, 37, 20, true, true, SWPlanets.PACKET_HANDLER, getNetworkHandler(1), ImageButtonPlacer.Types.PLANET_CATEGORY, List.of(screen.ORBIT_TEXT.getString(), screen.NO_GRAVITY_TEXT.getString(), "c" + screen.OXYGEN_FALSE_TEXT.getString(), "c" + "-270"), screen.SMALL_BLUE_BUTTON_TEXTURE, screen.SMALL_BLUE_LIGHT_BUTTON_TEXTURE, screen.ORBIT_TEXT);
        screen.visibleButton(tatooineOrbitHandlerButton, false);

        /** TATOOINE SPACE STATION TELEPORT BUTTONS */
        tatooineSpaceStationHandlerButton = PlanetSelectionGuiHelper.addHandlerButton(screen, 125, 3, 75, 20, screen.spaceStationItemList, SWPlanets.PACKET_HANDLER, getNetworkHandler(2), ImageButtonPlacer.Types.PLANET_SPACE_STATION_CATEGORY, List.of(screen.ORBIT_TEXT.getString(), screen.NO_GRAVITY_TEXT.getString(), "c" + screen.OXYGEN_FALSE_TEXT.getString(), "c" + "-270"), screen.LARGE_RED_BUTTON_TEXTURE, screen.LARGE_RED_LIGHT_BUTTON_TEXTURE, screen.SPACE_STATION_TEXT);
        screen.visibleButton(tatooineSpaceStationHandlerButton, false);

        /**
         *
         * KAMINO
         *
         */

        /** KAMINO BUTTONS */
        kaminoCategoryButton = PlanetSelectionGuiHelper.addCategoryButton(screen, category, 10, 1, 70, 20, 3, screen.checkTier(4), ImageButtonPlacer.Types.SOLAR_SYSTEM_CATEGORY, List.of(KAMINO_BUTTON_TEXT.getString(), screen.ROCKET_TIER_4_TEXT.getString()), screen.RED_BUTTON_TEXTURE, screen.RED_LIGHT_BUTTON_TEXTURE, KAMINO_BUTTON_TEXT);
        screen.visibleButton(kaminoCategoryButton, false);

        /** KAMINO TELEPORT BUTTONS */
        kaminoHandlerButton = PlanetSelectionGuiHelper.addHandlerButton(screen, 10, 1, 70, 20, true, true, SWPlanets.PACKET_HANDLER, getNetworkHandler(3), ImageButtonPlacer.Types.PLANET_CATEGORY, List.of(screen.PLANET_TEXT.getString(), "3.721 m/s", "a" + screen.OXYGEN_TRUE_TEXT.getString(), "a" + "40"), screen.BLUE_BUTTON_TEXTURE, screen.BLUE_LIGHT_BUTTON_TEXTURE, KAMINO_BUTTON_TEXT);
        screen.visibleButton(kaminoHandlerButton, false);

        /** KAMINO ORBIT TELEPORT BUTTONS */
        kaminoOrbitHandlerButton = PlanetSelectionGuiHelper.addHandlerButton(screen, 84, 2, 37, 20, true, true, SWPlanets.PACKET_HANDLER, getNetworkHandler(4), ImageButtonPlacer.Types.PLANET_CATEGORY, List.of(screen.ORBIT_TEXT.getString(), screen.NO_GRAVITY_TEXT.getString(), "c" + screen.OXYGEN_FALSE_TEXT.getString(), "c" + "-270"), screen.SMALL_BLUE_BUTTON_TEXTURE, screen.SMALL_BLUE_LIGHT_BUTTON_TEXTURE, screen.ORBIT_TEXT);
        screen.visibleButton(kaminoOrbitHandlerButton, false);

        /** KAMINO SPACE STATION TELEPORT BUTTONS */
        kaminoSpaceStationHandlerButton = PlanetSelectionGuiHelper.addHandlerButton(screen, 125, 3, 75, 20, true, screen.spaceStationItemList, true, SWPlanets.PACKET_HANDLER, getNetworkHandler(5), ImageButtonPlacer.Types.PLANET_SPACE_STATION_CATEGORY, List.of(screen.ORBIT_TEXT.getString(), screen.NO_GRAVITY_TEXT.getString(), "c" + screen.OXYGEN_FALSE_TEXT.getString(), "c" + "-270"), screen.LARGE_RED_BUTTON_TEXTURE, screen.LARGE_RED_LIGHT_BUTTON_TEXTURE, screen.SPACE_STATION_TEXT);
        screen.visibleButton(kaminoSpaceStationHandlerButton, false);

        /**
         *
         * ENDOR
         *
         */

        /** ENDOR BUTTONS */
        endorCategoryButton = PlanetSelectionGuiHelper.addCategoryButton(screen, category, 10, 1, 70, 20, 4, screen.checkTier(4), ImageButtonPlacer.Types.SOLAR_SYSTEM_CATEGORY, List.of(ENDOR_BUTTON_TEXT.getString(), screen.ROCKET_TIER_4_TEXT.getString()), screen.RED_BUTTON_TEXTURE, screen.RED_LIGHT_BUTTON_TEXTURE, ENDOR_BUTTON_TEXT);
        screen.visibleButton(endorCategoryButton, false);

        /** ENDOR TELEPORT BUTTONS */
        endorHandlerButton = PlanetSelectionGuiHelper.addHandlerButton(screen, 10, 1, 70, 20, true,  true, SWPlanets.PACKET_HANDLER, getNetworkHandler(6), ImageButtonPlacer.Types.PLANET_CATEGORY, List.of(screen.PLANET_TEXT.getString(), "3.721 m/s", "a" + screen.OXYGEN_TRUE_TEXT.getString(), "a" + "30"), screen.BLUE_BUTTON_TEXTURE, screen.BLUE_LIGHT_BUTTON_TEXTURE, ENDOR_BUTTON_TEXT);
        screen.visibleButton(endorHandlerButton, false);

        /** ENDOR ORBIT TELEPORT BUTTONS */
       endorOrbitHandlerButton = PlanetSelectionGuiHelper.addHandlerButton(screen, 84, 2, 37, 20, true, true, SWPlanets.PACKET_HANDLER, getNetworkHandler(7), ImageButtonPlacer.Types.PLANET_CATEGORY, List.of(screen.ORBIT_TEXT.getString(), screen.NO_GRAVITY_TEXT.getString(), "c" + screen.OXYGEN_FALSE_TEXT.getString(), "c" + "-270"), screen.SMALL_BLUE_BUTTON_TEXTURE, screen.SMALL_BLUE_LIGHT_BUTTON_TEXTURE, screen.ORBIT_TEXT);
        screen.visibleButton(endorOrbitHandlerButton, false);

        /** ENDOR SPACE STATION TELEPORT BUTTONS */
        endorSpaceStationHandlerButton = PlanetSelectionGuiHelper.addHandlerButton(screen, 125, 3, 75, 20, screen.spaceStationItemList, SWPlanets.PACKET_HANDLER, getNetworkHandler(8), ImageButtonPlacer.Types.PLANET_SPACE_STATION_CATEGORY, List.of(screen.ORBIT_TEXT.getString(), screen.NO_GRAVITY_TEXT.getString(), "c" + screen.OXYGEN_FALSE_TEXT.getString(), "c" + "-270"), screen.LARGE_RED_BUTTON_TEXTURE, screen.LARGE_RED_LIGHT_BUTTON_TEXTURE, screen.SPACE_STATION_TEXT);
        screen.visibleButton(endorSpaceStationHandlerButton, false);

        /**
         *
         * HOT
         *
         */

        /** HOT BUTTONS */
        hotCategoryButton = PlanetSelectionGuiHelper.addCategoryButton(screen, category, 10, 1, 70, 20, 5, screen.checkTier(4), ImageButtonPlacer.Types.SOLAR_SYSTEM_CATEGORY, List.of(HOT_BUTTON_TEXT.getString(), screen.ROCKET_TIER_4_TEXT.getString()), screen.RED_BUTTON_TEXTURE, screen.RED_LIGHT_BUTTON_TEXTURE, HOT_BUTTON_TEXT);
        screen.visibleButton(hotCategoryButton, false);

        /** HOT TELEPORT BUTTONS */
        hotHandlerButton = PlanetSelectionGuiHelper.addHandlerButton(screen, 10, 1, 70, 20, true, SWPlanets.PACKET_HANDLER, getNetworkHandler(9), ImageButtonPlacer.Types.PLANET_CATEGORY, List.of(screen.PLANET_TEXT.getString(), "3.721 m/s", "a" + screen.OXYGEN_TRUE_TEXT.getString(), "a" + "-30"), screen.BLUE_BUTTON_TEXTURE, screen.BLUE_LIGHT_BUTTON_TEXTURE, HOT_BUTTON_TEXT);
        screen.visibleButton(hotHandlerButton, false);

        /** HOT ORBIT TELEPORT BUTTONS */
        hotOrbitHandlerButton = PlanetSelectionGuiHelper.addHandlerButton(screen, 84, 2, 37, 20, true, SWPlanets.PACKET_HANDLER, getNetworkHandler(10), ImageButtonPlacer.Types.PLANET_CATEGORY, List.of(screen.ORBIT_TEXT.getString(), screen.NO_GRAVITY_TEXT.getString(), "c" + screen.OXYGEN_FALSE_TEXT.getString(), "c" + "-270"), screen.SMALL_BLUE_BUTTON_TEXTURE, screen.SMALL_BLUE_LIGHT_BUTTON_TEXTURE, screen.ORBIT_TEXT);
        screen.visibleButton(hotOrbitHandlerButton, false);

        /** HOT SPACE STATION TELEPORT BUTTONS */
        hotSpaceStationHandlerButton = PlanetSelectionGuiHelper.addHandlerButton(screen, 125, 3, 75, 20, screen.spaceStationItemList, SWPlanets.PACKET_HANDLER, getNetworkHandler(11), ImageButtonPlacer.Types.PLANET_SPACE_STATION_CATEGORY, List.of(screen.ORBIT_TEXT.getString(), screen.NO_GRAVITY_TEXT.getString(), "c" + screen.OXYGEN_FALSE_TEXT.getString(), "c" + "-270"), screen.LARGE_RED_BUTTON_TEXTURE, screen.LARGE_RED_LIGHT_BUTTON_TEXTURE, screen.SPACE_STATION_TEXT);
        screen.visibleButton(hotSpaceStationHandlerButton, false);
    }

    /** GET NETWORK HANDLER */
    public static PlanetSelectionGuiNetworkHandler getNetworkHandler(int handler) {
        return new PlanetSelectionGuiNetworkHandler(handler);
    }

    /** CREATE A TRANSLATABLE KEY */
    public static Component tl(String string) {
        return Component.translatable("gui." + SWPlanets.MODID + ".planet_selection." + string);
    }
}
