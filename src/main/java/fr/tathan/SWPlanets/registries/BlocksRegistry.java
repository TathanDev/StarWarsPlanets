package fr.tathan.SWPlanets.registries;

import fr.tathan.SWPlanets.SWPlanets;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.minecraft.world.item.Item;

import java.util.function.Supplier;




public class BlocksRegistry {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SWPlanets.MODID);


    /** ORES */
    //TODO Add Worldgen
    public static final RegistryObject<Block> CRYSTAL_KYBER_ORE = BLOCKS.register("kyber_crystal_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(3.0F, 3.0F).explosionResistance(3).requiresCorrectToolForDrops()));



    /** CLUSTERS
    public static final RegistryObject<Block> CRYSTAL_KYBER_CLUSTER = registerBlock("kyber_crystal_cluster",
            () -> new CristalKyberBlock(BlockBehaviour.Properties.of(Material.AMETHYST).randomTicks().strength(1.5F).sound(SoundType.NETHER_ORE).requiresCorrectToolForDrops()), CreativeTabsRegistry.SWPLANETS_TAB);



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ItemsRegistry.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

*/
}
