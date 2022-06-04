package fr.tathan.SWPlanets.registries;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeTabsRegistry {

    public static final CreativeModeTab SWPLANETS_TAB = new CreativeModeTab("swplanets_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemsRegistry.KYBER_CRYSTAL.get());
        }
    };
}
