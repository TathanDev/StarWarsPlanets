package fr.tathan.SWPlanets.registries;

import fr.tathan.SWPlanets.SWPlanets;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemsRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SWPlanets.MODID);

    public static final RegistryObject<Item> STAR_WARS_OPENING_MUSIC_DISC = ITEMS.register("star_wars_opening_music_disc",
            () -> new RecordItem(4, SoundsRegistry.STAR_WARS_OPENING_MUSIC,
                    new Item.Properties().tab(CreativeTabsRegistry.SWPLANETS_TAB).stacksTo(1)));


    public static final RegistryObject<Item> KYBER_CRYSTAL = ITEMS.register("kyber_crystal", () -> new Item(new Item.Properties().tab(CreativeTabsRegistry.SWPLANETS_TAB).stacksTo(16)));

    /** Light Saber */
    //TODO Add Damage to lightSaber
    public static final RegistryObject<Item> LIGHT_SABER_BASE = ITEMS.register("light_saber_base", () -> new Item(new Item.Properties().tab(CreativeTabsRegistry.SWPLANETS_TAB).stacksTo(1)));
        public static final RegistryObject<Item> LIGHT_SABER_BLUE = ITEMS.register("light_saber_blue", () -> new Item(new Item.Properties().rarity(Rarity.EPIC).tab(CreativeTabsRegistry.SWPLANETS_TAB).stacksTo(1).durability(9).setNoRepair()));
    public static final RegistryObject<Item> LIGHT_SABER_RED = ITEMS.register("light_saber_red", () -> new Item(new Item.Properties().rarity(Rarity.EPIC).tab(CreativeTabsRegistry.SWPLANETS_TAB).stacksTo(1).durability(9).setNoRepair()));

    /**
    public static final RegistryObject<SwordItem> BEAN_SWORD = ITEMS.register("bean_sword",
            () -> new SwordItem(LIGHT_SABER_BASE,20, 5f,
                    new Item.Properties().tab(CreativeTabsRegistry.SWPLANETS_TAB)));

*/
    //** Block */
    public static final RegistryObject<BlockItem> KYBER_CRYSTAl_ORE_ITEM = ITEMS.register("kyber_crystal_ore", () -> new BlockItem(BlocksRegistry.CRYSTAL_KYBER_ORE.get(), new Item.Properties().tab(CreativeTabsRegistry.SWPLANETS_TAB)));


}
