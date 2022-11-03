package fr.tathan.SWPlanets.events;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.tathan.SWPlanets.SWPlanets;
import fr.tathan.SWPlanets.network.PlanetSelectionGuiNetworkHandler;
import fr.tathan.SWPlanets.network.SWPlanetsNetworkRegistry;
import fr.tathan.SWPlanets.registries.PlanetsRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mrscauthd.beyond_earth.client.events.forge.PlanetSelectionScreenBackgroundRenderEvent;
import net.mrscauthd.beyond_earth.client.events.forge.PlanetSelectionScreenButtonVisibilityEvent;
import net.mrscauthd.beyond_earth.client.events.forge.PlanetSelectionScreenInitEvent;
import net.mrscauthd.beyond_earth.client.screens.buttons.ModifiedButton;
import net.mrscauthd.beyond_earth.client.screens.buttons.TexturedButton;
import net.mrscauthd.beyond_earth.client.screens.helper.ScreenHelper;
import net.mrscauthd.beyond_earth.client.screens.planetselection.PlanetSelectionScreen;
import net.mrscauthd.beyond_earth.client.screens.planetselection.helper.CategoryHelper;
import net.mrscauthd.beyond_earth.client.screens.planetselection.helper.PlanetSelectionScreenHelper;
import net.mrscauthd.beyond_earth.common.util.Planets;


import java.util.List;

import static net.mrscauthd.beyond_earth.client.screens.planetselection.PlanetSelectionScreen.BUTTON_TEXTURE;
import static net.mrscauthd.beyond_earth.client.screens.planetselection.PlanetSelectionScreen.SMALL_MENU_LIST;

@Mod.EventBusSubscriber(modid = SWPlanets.MODID, value = Dist.CLIENT)
public class PlanetSelectionGuiEvents {

    /** TEXT */
    public static final Component SOLAR_SYSTEM_BUTTON_TEXT = tl("solar_system_button");
    public static final Component TATOOINE_BUTTON_TEXT = tl("tatooine_button");
    public static final Component KAMINO_BUTTON_TEXT = tl("kamino_button");
    public static final Component ENDOR_BUTTON_TEXT = tl("endor_button");
    public static final Component HOT_BUTTON_TEXT = tl("hot_button");

    /** BUTTONS */
    private static ModifiedButton  backButton;

    private static ModifiedButton  solarSystemButton;

    private static ModifiedButton  tatooineCategoryButton;
    private static ModifiedButton  tatooineHandlerButton;
    private static ModifiedButton  tatooineOrbitHandlerButton;
    private static ModifiedButton  tatooineSpaceStationHandlerButton;

    private static ModifiedButton  kaminoCategoryButton;
    private static ModifiedButton  kaminoHandlerButton;
    private static ModifiedButton  kaminoOrbitHandlerButton;
    private static ModifiedButton  kaminoSpaceStationHandlerButton;

    private static ModifiedButton  endorCategoryButton;
    private static ModifiedButton  endorHandlerButton;
    private static ModifiedButton  endorOrbitHandlerButton;
    private static ModifiedButton  endorSpaceStationHandlerButton;

    private static ModifiedButton  hotCategoryButton;
    private static ModifiedButton  hotHandlerButton;
    private static ModifiedButton  hotOrbitHandlerButton;
    private static ModifiedButton  hotSpaceStationHandlerButton;

    /** CATEGORY */
    private static CategoryHelper category;

    /** TEXTURES */
    public static final ResourceLocation TATOOINE_TEXTURE = new ResourceLocation(SWPlanets.MODID, "textures/sky/tatooine.png");
    public static final ResourceLocation KAMINO_TEXTURE = new ResourceLocation(SWPlanets.MODID, "textures/sky/kamino.png");
    public static final ResourceLocation ENDOR_TEXTURE = new ResourceLocation(SWPlanets.MODID, "textures/sky/endor.png");
    public static final ResourceLocation HOT_TEXTURE = new ResourceLocation(SWPlanets.MODID, "textures/sky/hot.png");

    static Planets.Planet TATOOINE = new Planets.Planet(PlanetsRegistry.TATOOINE, PlanetsRegistry.TATOOINE_ORBIT);
    static Planets.Planet KAMINO = new Planets.Planet(PlanetsRegistry.KAMINO, PlanetsRegistry.KAMINO_ORBIT);
    static Planets.Planet ENDOR = new Planets.Planet(PlanetsRegistry.ENDOR, PlanetsRegistry.ENDOR_ORBIT);
    static Planets.Planet HOT = new Planets.Planet(PlanetsRegistry.HOT, PlanetsRegistry.HOT_ORBIT);



    @SubscribeEvent
    public static void buttonVisibilityPre(PlanetSelectionScreenButtonVisibilityEvent.Pre event) {
        PlanetSelectionScreen screen = (PlanetSelectionScreen) event.getScreen();

        /** SET THE MAIN (BEYOND EARTH) CATEGORY TO -1 */
        if (PlanetSelectionScreenHelper.categoryRange(category.get(), 1,5)) {
            screen.category.set(-1);
        }
    }

    @SubscribeEvent
    public static void buttonVisibilityPost(PlanetSelectionScreenButtonVisibilityEvent.Post event) {
        PlanetSelectionScreen screen = (PlanetSelectionScreen) event.getScreen();

        /** BUTTONS VISIBLE SYSTEM */
        screen.visibleButton(backButton, PlanetSelectionScreenHelper.categoryRange(category.get(), 1, 5));

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
    public static void backgroundFucRenderPost(PlanetSelectionScreenBackgroundRenderEvent.Post event) {
        PlanetSelectionScreen screen = (PlanetSelectionScreen) event.getScreen();
        PoseStack poseStack = event.getPoseStack();

        //System.out.println("FUCK IT IS NULL " + category.get() + " " + screen.category.get());

        /** ENABLE BLEND */
        //PlanetSelectionScreenHelper.enableRenderSystem();

        Vec3 colour = new Vec3(2, 2, 2);


        /** SOLAR SYSTEM */
        if (PlanetSelectionScreenHelper.categoryRange(category.get(), 1, 5)) {
            PlanetSelectionScreenHelper.drawCircle(screen.width / 2, screen.height / 2, 23.0D, 180, 2 , colour);
            PlanetSelectionScreenHelper.drawCircle(screen.width / 2, screen.height / 2, 46.0D, 180, 2 , colour);
            PlanetSelectionScreenHelper.drawCircle(screen.width / 2, screen.height / 2, 69.5D, 180, 2 , colour);
            PlanetSelectionScreenHelper.drawCircle(screen.width / 2, screen.height / 2, 92.5D, 180, 2 , colour);
            PlanetSelectionScreenHelper.drawCircle(screen.width / 2, screen.height / 2, 23.0D, 180, 2 , colour);
        }

        /** SUN */
        if (PlanetSelectionScreenHelper.categoryRange(category.get(), 1, 5)) {
            ScreenHelper.drawTexture(poseStack, (screen.width - 15) / 2, (screen.height - 15) / 2, 15, 15, PlanetSelectionScreen.MILKY_WAY_TEXTURE, true);
        }

        /** PLANETS */
        if (PlanetSelectionScreenHelper.categoryRange(category.get(), 1, 5)) {
            PlanetSelectionScreenHelper.drawPlanet(poseStack, TATOOINE, 20, 20, true);
            PlanetSelectionScreenHelper.drawPlanet(poseStack, KAMINO, -37, 20, true);
            PlanetSelectionScreenHelper.drawPlanet(poseStack, ENDOR, -54, 20, true);
            PlanetSelectionScreenHelper.drawPlanet(poseStack, HOT, -70, 20, true);
        }

        /** SMALL MENU RENDERER */

        if (PlanetSelectionScreenHelper.categoryRange(category.get(), 1, 1)) {
            ScreenHelper.drawTexture(poseStack, 0, (screen.height / 2) - 177 / 2, 105, 177, SMALL_MENU_LIST, true);
            //ScreenHelper.drawScroller(poseStack, 92);

        }
            /** LARGE MENU RENDERER */

            if (PlanetSelectionScreenHelper.categoryRange(category.get(), 2, 5)) {
                ScreenHelper.drawTexture(poseStack, 0, (screen.height / 2) - 177 / 2, 215, 177, PlanetSelectionScreen.LARGE_MENU_TEXTURE, true);
            }

        }

    @SubscribeEvent
    public static void screenInitPost(PlanetSelectionScreenInitEvent.Post event) {
        PlanetSelectionScreen screen = (PlanetSelectionScreen) event.getScreen();

        System.out.println("ERROR NOT FOUNDED");

        /** CREATE A CATEGORY */
        category = new CategoryHelper();

        /** SOLAR SYSTEM BUTTON */
        solarSystemButton = PlanetSelectionScreenHelper.addCategoryButton(screen, category, 10, 1, 70, 20, 1, true, false, ModifiedButton.ButtonTypes.MILKY_WAY_CATEGORY, List.of(SOLAR_SYSTEM_BUTTON_TEXT.getString()), BUTTON_TEXTURE, ModifiedButton.ColorTypes.BLUE, SOLAR_SYSTEM_BUTTON_TEXT);
        screen.visibleButton(solarSystemButton, false);

        /** BACK BUTTON */
        backButton = PlanetSelectionScreenHelper.addBackButton(screen, 10, 1, 70, 20, false, BUTTON_TEXTURE, ModifiedButton.ColorTypes.BLUE, PlanetSelectionScreen.BACK_TEXT, (onPress) -> {

            if (category.get() == 1) {
                category.set(0);
                screen.category.set(0);
                screen.scrollIndex = 0;
                screen.updateButtonVisibility();

            } else if (PlanetSelectionScreenHelper.categoryRange(category.get(), 2, 5)) {
                category.set(1);
                screen.scrollIndex = 0;
                screen.updateButtonVisibility();
            }
        });



        /** TATOOINE BUTTONS */
        tatooineCategoryButton = PlanetSelectionScreenHelper.addCategoryButton(screen, category, 10, 1, 70, 20, 2, screen.checkTier(4), false, ModifiedButton.ButtonTypes.SOLAR_SYSTEM_CATEGORY, List.of(TATOOINE_BUTTON_TEXT.getString(), screen.ROCKET_TIER_4_TEXT.getString()), BUTTON_TEXTURE, ModifiedButton.ColorTypes.RED, TATOOINE_BUTTON_TEXT);
        screen.visibleButton(tatooineCategoryButton, false);

        /** TATOOINE TELEPORT BUTTONS */
        tatooineHandlerButton = PlanetSelectionScreenHelper.addHandlerButton(screen, 10, 1, 70, 20, true, false, true, SWPlanetsNetworkRegistry.PACKET_HANDLER, getNetworkHandler(0), ModifiedButton.ButtonTypes.PLANET_CATEGORY, List.of(screen.PLANET_TEXT.getString(), "3.721 m/s", "a" + screen.OXYGEN_TRUE_TEXT.getString(), "a" + "40"), BUTTON_TEXTURE, TexturedButton.ColorTypes.LIGHT_BLUE, TATOOINE_BUTTON_TEXT);
        screen.visibleButton(tatooineHandlerButton, false);

        /** TATOOINE ORBIT TELEPORT BUTTONS */
        tatooineOrbitHandlerButton = PlanetSelectionScreenHelper.addHandlerButton(screen, 84, 2, 37, 20, true, false,true, SWPlanetsNetworkRegistry.PACKET_HANDLER, getNetworkHandler(1), ModifiedButton.ButtonTypes.PLANET_CATEGORY, List.of(screen.ORBIT_TEXT.getString(), screen.NO_GRAVITY_TEXT.getString(), "c" + screen.OXYGEN_FALSE_TEXT.getString(), "c" + "-270"), BUTTON_TEXTURE, TexturedButton.ColorTypes.LIGHT_BLUE, screen.ORBIT_TEXT);
        screen.visibleButton(tatooineOrbitHandlerButton, false);

        /** TATOOINE SPACE STATION TELEPORT BUTTONS */
        tatooineSpaceStationHandlerButton = PlanetSelectionScreenHelper.addHandlerButton(screen, 125, 3, 75, 20, false, false,screen.spaceStationItemList, SWPlanetsNetworkRegistry.PACKET_HANDLER, getNetworkHandler(2), ModifiedButton.ButtonTypes.PLANET_SPACE_STATION_CATEGORY, List.of(screen.ORBIT_TEXT.getString(), screen.NO_GRAVITY_TEXT.getString(), "c" + screen.OXYGEN_FALSE_TEXT.getString(), "c" + "-270"), BUTTON_TEXTURE, TexturedButton.ColorTypes.LIGHT_BLUE, screen.SPACE_STATION_TEXT);
        screen.visibleButton(tatooineSpaceStationHandlerButton, false);

        /**
         *
         * KAMINO
         *
         */

        /** KAMINO BUTTONS */
        kaminoCategoryButton = PlanetSelectionScreenHelper.addCategoryButton(screen, category, 10, 1, 70, 20, 3, screen.checkTier(4), false, ModifiedButton.ButtonTypes.SOLAR_SYSTEM_CATEGORY, List.of(KAMINO_BUTTON_TEXT.getString(), screen.ROCKET_TIER_4_TEXT.getString()), BUTTON_TEXTURE, ModifiedButton.ColorTypes.RED, KAMINO_BUTTON_TEXT);
        screen.visibleButton(kaminoCategoryButton, false);

        /** KAMINO TELEPORT BUTTONS */
        kaminoHandlerButton = PlanetSelectionScreenHelper.addHandlerButton(screen, 10, 1, 70, 20, true, false,true, SWPlanetsNetworkRegistry.PACKET_HANDLER, getNetworkHandler(3), ModifiedButton.ButtonTypes.PLANET_CATEGORY, List.of(screen.PLANET_TEXT.getString(), "3.721 m/s", "a" + screen.OXYGEN_TRUE_TEXT.getString(), "a" + "40"), BUTTON_TEXTURE, ModifiedButton.ColorTypes.LIGHT_BLUE, KAMINO_BUTTON_TEXT);
        screen.visibleButton(kaminoHandlerButton, false);

        /** KAMINO ORBIT TELEPORT BUTTONS */
        kaminoOrbitHandlerButton = PlanetSelectionScreenHelper.addHandlerButton(screen, 84, 2, 37, 20, true, false, true, SWPlanetsNetworkRegistry.PACKET_HANDLER, getNetworkHandler(4), ModifiedButton.ButtonTypes.PLANET_CATEGORY, List.of(screen.ORBIT_TEXT.getString(), screen.NO_GRAVITY_TEXT.getString(), "c" + screen.OXYGEN_FALSE_TEXT.getString(), "c" + "-270"), BUTTON_TEXTURE, ModifiedButton.ColorTypes.LIGHT_BLUE, screen.ORBIT_TEXT);
        screen.visibleButton(kaminoOrbitHandlerButton, false);

        /** KAMINO SPACE STATION TELEPORT BUTTONS */
        kaminoSpaceStationHandlerButton = PlanetSelectionScreenHelper.addHandlerButton(screen, 125, 3, 75, 20, true, screen.spaceStationItemList, true, SWPlanetsNetworkRegistry.PACKET_HANDLER, getNetworkHandler(5), ModifiedButton.ButtonTypes.PLANET_CATEGORY, List.of(screen.ORBIT_TEXT.getString(), screen.NO_GRAVITY_TEXT.getString(), "c" + screen.OXYGEN_FALSE_TEXT.getString(), "c" + "-270"), BUTTON_TEXTURE, ModifiedButton.ColorTypes.LIGHT_BLUE, screen.SPACE_STATION_TEXT);
        screen.visibleButton(kaminoSpaceStationHandlerButton, false);

        /**
         *
         * ENDOR
         *
         */

        /** ENDOR BUTTONS */
        endorCategoryButton = PlanetSelectionScreenHelper.addCategoryButton(screen, category, 10, 1, 70, 20, 4, screen.checkTier(4), false, ModifiedButton.ButtonTypes.SOLAR_SYSTEM_CATEGORY, List.of(ENDOR_BUTTON_TEXT.getString(), screen.ROCKET_TIER_4_TEXT.getString()), BUTTON_TEXTURE, ModifiedButton.ColorTypes.RED, ENDOR_BUTTON_TEXT);
        screen.visibleButton(endorCategoryButton, false);

        /** ENDOR TELEPORT BUTTONS */
        endorHandlerButton = PlanetSelectionScreenHelper.addHandlerButton(screen, 10, 1, 70, 20, true,  false, true, SWPlanetsNetworkRegistry.PACKET_HANDLER, getNetworkHandler(6), ModifiedButton.ButtonTypes.PLANET_CATEGORY, List.of(screen.PLANET_TEXT.getString(), "3.721 m/s", "a" + screen.OXYGEN_TRUE_TEXT.getString(), "a" + "30"), BUTTON_TEXTURE, TexturedButton.ColorTypes.LIGHT_BLUE, ENDOR_BUTTON_TEXT);
        screen.visibleButton(endorHandlerButton, false);

        /** ENDOR ORBIT TELEPORT BUTTONS */
       endorOrbitHandlerButton = PlanetSelectionScreenHelper.addHandlerButton(screen, 84, 2, 37, 20, true, false, true, SWPlanetsNetworkRegistry.PACKET_HANDLER, getNetworkHandler(7), ModifiedButton.ButtonTypes.PLANET_CATEGORY, List.of(screen.ORBIT_TEXT.getString(), screen.NO_GRAVITY_TEXT.getString(), "c" + screen.OXYGEN_FALSE_TEXT.getString(), "c" + "-270"), BUTTON_TEXTURE, TexturedButton.ColorTypes.LIGHT_BLUE, screen.ORBIT_TEXT);
        screen.visibleButton(endorOrbitHandlerButton, false);

        /** ENDOR SPACE STATION TELEPORT BUTTONS */
        endorSpaceStationHandlerButton = PlanetSelectionScreenHelper.addHandlerButton(screen, 125, 3, 75, 20, false, true, screen.spaceStationItemList, SWPlanetsNetworkRegistry.PACKET_HANDLER, getNetworkHandler(8), ModifiedButton.ButtonTypes.PLANET_SPACE_STATION_CATEGORY, List.of(screen.ORBIT_TEXT.getString(), screen.NO_GRAVITY_TEXT.getString(), "c" + screen.OXYGEN_FALSE_TEXT.getString(), "c" + "-270"), BUTTON_TEXTURE, TexturedButton.ColorTypes.LIGHT_BLUE, screen.SPACE_STATION_TEXT);
        screen.visibleButton(endorSpaceStationHandlerButton, false);

        /**
         *
         * HOT
         *
         */

        /** HOT BUTTONS */
        hotCategoryButton = PlanetSelectionScreenHelper.addCategoryButton(screen, category, 10, 1, 70, 20, 5, screen.checkTier(4), false,ModifiedButton.ButtonTypes.SOLAR_SYSTEM_CATEGORY, List.of(HOT_BUTTON_TEXT.getString(), screen.ROCKET_TIER_4_TEXT.getString()), BUTTON_TEXTURE, TexturedButton.ColorTypes.RED, HOT_BUTTON_TEXT);
        screen.visibleButton(hotCategoryButton, false);

        /** HOT TELEPORT BUTTONS */
        hotHandlerButton = PlanetSelectionScreenHelper.addHandlerButton(screen, 10, 1, 70, 20, true, false, true, SWPlanetsNetworkRegistry.PACKET_HANDLER, getNetworkHandler(9), ModifiedButton.ButtonTypes.PLANET_CATEGORY, List.of(screen.PLANET_TEXT.getString(), "3.721 m/s", "a" + screen.OXYGEN_TRUE_TEXT.getString(), "a" + "-30"), BUTTON_TEXTURE, TexturedButton.ColorTypes.LIGHT_BLUE, HOT_BUTTON_TEXT);
        screen.visibleButton(hotHandlerButton, false);

        /** HOT ORBIT TELEPORT BUTTONS */
        hotOrbitHandlerButton = PlanetSelectionScreenHelper.addHandlerButton(screen, 84, 2, 37, 20, true, false, true, SWPlanetsNetworkRegistry.PACKET_HANDLER, getNetworkHandler(10), ModifiedButton.ButtonTypes.PLANET_CATEGORY, List.of(screen.ORBIT_TEXT.getString(), screen.NO_GRAVITY_TEXT.getString(), "c" + screen.OXYGEN_FALSE_TEXT.getString(), "c" + "-270"), BUTTON_TEXTURE, TexturedButton.ColorTypes.LIGHT_BLUE, screen.ORBIT_TEXT);
        screen.visibleButton(hotOrbitHandlerButton, false);

        /** HOT SPACE STATION TELEPORT BUTTONS */
        hotSpaceStationHandlerButton = PlanetSelectionScreenHelper.addHandlerButton(screen, 125, 3, 75, 20, screen.spaceStationItemList, false, true, SWPlanetsNetworkRegistry.PACKET_HANDLER, getNetworkHandler(11), ModifiedButton.ButtonTypes.PLANET_SPACE_STATION_CATEGORY, List.of(screen.ORBIT_TEXT.getString(), screen.NO_GRAVITY_TEXT.getString(), "c" + screen.OXYGEN_FALSE_TEXT.getString(), "c" + "-270"), BUTTON_TEXTURE, TexturedButton.ColorTypes.LIGHT_BLUE, screen.SPACE_STATION_TEXT);
        screen.visibleButton(hotSpaceStationHandlerButton, false);
    }

    /** GET NETWORK HANDLER */
    public static PlanetSelectionGuiNetworkHandler getNetworkHandler(int handler) {
        return new PlanetSelectionGuiNetworkHandler(handler);
    }

    /** CREATE A TRANSLATABLE KEY */
    public static Component tl(String text) {
        return Component.translatable("gui." + SWPlanets.MODID + ".planet_selection." + text);
    }
}
