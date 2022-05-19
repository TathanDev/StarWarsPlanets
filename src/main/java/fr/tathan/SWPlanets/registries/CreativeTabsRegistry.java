package fr.tathan.SWPlanets.registries;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeTabsRegistry {

    public static final CreativeModeTab MUSIC_TAB = new CreativeModeTab("music_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemsRegistry.STAR_WARS_OPENING_MUSIC_DISC.get());
        }
    };
}
