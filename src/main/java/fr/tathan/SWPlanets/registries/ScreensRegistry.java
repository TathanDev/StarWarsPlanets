package fr.tathan.SWPlanets.registries;

import fr.tathan.SWPlanets.SWPlanets;
//import fr.tathan.SWPlanets.gui.speeder.SpeederGUI;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ScreensRegistry {

    public static final DeferredRegister<MenuType<?>> SCREENS = DeferredRegister.create(ForgeRegistries.CONTAINERS, SWPlanets.MODID);

    //public static final RegistryObject<MenuType<SpeederGUI.GuiContainer>> SPEEDER_GUI = SCREENS.register("speeder_gui", () -> new MenuType(new SpeederGUI.GuiContainerFactory()));




}
