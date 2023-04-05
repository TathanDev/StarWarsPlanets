package fr.tathan.SWPlanets.registries;

import fr.tathan.SWPlanets.SWPlanets;
import fr.tathan.SWPlanets.items.JediLightSaber;
import fr.tathan.SWPlanets.items.SithLightSaber;
import fr.tathan.SWPlanets.items.StarManual;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mrscauthd.beyond_earth.globe.GlobeItem;
import net.mrscauthd.beyond_earth.itemgroups.ItemGroups;

public class ItemsRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SWPlanets.MODID);


    /**Music Disc */
    public static final RegistryObject<Item> STAR_WARS_OPENING_MUSIC_DISC = ITEMS.register("star_wars_opening_music_disc",
            () -> new RecordItem(4, SoundsRegistry.STAR_WARS_OPENING_MUSIC,
                    new Item.Properties().tab(CreativeTabsRegistry.SWPLANETS_TAB).stacksTo(1)));


    public static final RegistryObject<Item> KYBER_CRYSTAL = ITEMS.register("kyber_crystal", () -> new Item(new Item.Properties().tab(CreativeTabsRegistry.SWPLANETS_TAB).stacksTo(16)));

    /** Light Sabers */
    public static final RegistryObject<Item> LIGHT_SABER_BASE = ITEMS.register("light_saber_base", () -> new Item(new Item.Properties().tab(CreativeTabsRegistry.SWPLANETS_TAB).stacksTo(1)));

    //Jedi Light Saber
    public static final RegistryObject<SwordItem> LIGHT_SABER_BLUE = ITEMS.register("light_saber_blue", () -> new JediLightSaber(Tiers.KYBER, 8, -2, new  Item.Properties().rarity(Rarity.EPIC).fireResistant().tab(CreativeTabsRegistry.SWPLANETS_TAB).stacksTo(1).durability(1400).setNoRepair()));
    public static final RegistryObject<SwordItem> LIGHT_SABER_GREEN = ITEMS.register("light_saber_green", () -> new JediLightSaber(Tiers.KYBER, 8, -2, new  Item.Properties().rarity(Rarity.EPIC).fireResistant().tab(CreativeTabsRegistry.SWPLANETS_TAB).stacksTo(1).durability(1400).setNoRepair()));
    public static final RegistryObject<SwordItem> LIGHT_SABER_VIOLET = ITEMS.register("light_saber_violet", () -> new JediLightSaber(Tiers.KYBER, 8, -2, new  Item.Properties().rarity(Rarity.EPIC).fireResistant().tab(CreativeTabsRegistry.SWPLANETS_TAB).stacksTo(1).durability(1400).setNoRepair()));


    //Sith Light Saber
    public static final RegistryObject<SwordItem> LIGHT_SABER_RED = ITEMS.register("light_saber_red", () -> new SithLightSaber(Tiers.KYBER, 8, -2, new  Item.Properties().rarity(Rarity.EPIC).fireResistant().tab(CreativeTabsRegistry.SWPLANETS_TAB).stacksTo(1).durability(1400).setNoRepair()));
    public static final RegistryObject<SwordItem> LIGHT_SABER_KYLO_REN = ITEMS.register("light_saber_kylo_ren", () -> new SithLightSaber(Tiers.KYBER, 8, -2, new  Item.Properties().rarity(Rarity.EPIC).fireResistant().tab(CreativeTabsRegistry.SWPLANETS_TAB).stacksTo(1).durability(1400).setNoRepair()));
    public static final RegistryObject<SwordItem> LIGHT_SABER_DARK_MAUL = ITEMS.register("light_saber_dark_maul", () -> new SithLightSaber(Tiers.KYBER, 8, -2, new  Item.Properties().rarity(Rarity.EPIC).fireResistant().tab(CreativeTabsRegistry.SWPLANETS_TAB).stacksTo(1).durability(1400).setNoRepair()));

    //Mandalorian
    public static final RegistryObject<SwordItem> DARKSABER = ITEMS.register("darksaber", () -> new SwordItem(Tiers.BESKAR, 8, -2, new  Item.Properties().rarity(Rarity.EPIC).fireResistant().tab(CreativeTabsRegistry.SWPLANETS_TAB).stacksTo(1).durability(4000)));
    public static final RegistryObject<Item> BESKAR = ITEMS.register("beskar", () -> new Item(new Item.Properties().fireResistant().stacksTo(16).tab(CreativeTabsRegistry.SWPLANETS_TAB)));


    /** Blocks */
    public static final RegistryObject<BlockItem> KYBER_CRYSTAl_ORE_ITEM = ITEMS.register("kyber_crystal_ore", () -> new BlockItem(BlocksRegistry.CRYSTAL_KYBER_ORE.get(), new Item.Properties().tab(CreativeTabsRegistry.SWPLANETS_TAB)));
    public static final RegistryObject<BlockItem> KYBER_CRYSTAl_ORE_SANDSTONE_ITEM = ITEMS.register("kyber_crystal_ore_sandstone", () -> new BlockItem(BlocksRegistry.CRYSTAL_KYBER_ORE_SANDSTONE.get(), new Item.Properties().tab(CreativeTabsRegistry.SWPLANETS_TAB)));
    public static final RegistryObject<BlockItem> MUSTAFAR_STONE_ITEM = ITEMS.register("mustafar_stone", () -> new BlockItem(BlocksRegistry.MUSTAFAR_STONE.get(), new Item.Properties().tab(CreativeTabsRegistry.SWPLANETS_TAB)));
    public static final RegistryObject<BlockItem> MUSTAFAR_SAND_ITEM = ITEMS.register("mustafar_sand", () -> new BlockItem(BlocksRegistry.MUSTAFAR_SAND.get(), new Item.Properties().tab(CreativeTabsRegistry.SWPLANETS_TAB)));

    public static final RegistryObject<BlockItem> BESKAR_SANDSTONE_ITEM = ITEMS.register("beskar_ore_sandstone", () -> new BlockItem(BlocksRegistry.BESKAR_ORE_SANDSTONE.get(), new Item.Properties().tab(CreativeTabsRegistry.SWPLANETS_TAB)));

    /** Armors */
    public static final RegistryObject<Item> STORMTROOPER_MASK = ITEMS.register("stormtrooper_mask",
            () -> new ArmorItem(ArmorMaterials.STORMTROOPER, EquipmentSlot.HEAD,
                    new Item.Properties().tab(CreativeTabsRegistry.SWPLANETS_TAB)));

    public static final RegistryObject<Item> STORMTROOPER_CHESTPLATE = ITEMS.register("stormtrooper_chestplate",
            () -> new ArmorItem(ArmorMaterials.STORMTROOPER, EquipmentSlot.CHEST,
                    new Item.Properties().tab(CreativeTabsRegistry.SWPLANETS_TAB)));
    public static final RegistryObject<Item> STORMTROOPER_LEGGINGS = ITEMS.register("stormtrooper_leggings",
            () -> new ArmorItem(ArmorMaterials.STORMTROOPER, EquipmentSlot.LEGS,
                    new Item.Properties().tab(CreativeTabsRegistry.SWPLANETS_TAB)));
    public static final RegistryObject<Item> STORMTROOPER_BOOTS = ITEMS.register("stormtrooper_boots",
            () -> new ArmorItem(ArmorMaterials.STORMTROOPER, EquipmentSlot.FEET,
                    new Item.Properties().tab(CreativeTabsRegistry.SWPLANETS_TAB)));

    /** Plates */
    public static final RegistryObject<Item> PLASTIC_PLATE = ITEMS.register("plastic_plate", () -> new Item(new Item.Properties().tab(CreativeTabsRegistry.SWPLANETS_TAB).stacksTo(64)));

    /** Manuals */
    public static final RegistryObject<Item> STAR_MANUAL = ITEMS.register("star_manual", () -> new StarManual(new Item.Properties().tab(CreativeTabsRegistry.SWPLANETS_TAB).stacksTo(1)));


     /** Globes */
    // public static final RegistryObject<BlockItem> TATOOINE_GLOBE_ITEM = ITEMS.register("tatooine_globe", () -> new GlobeItem(BlocksRegistry.TATOOINE_GLOBE_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_globes).rarity(Rarity.EPIC).stacksTo(1)));



}
