package fr.tathan.SWPlanets.world.oregen;


import fr.tathan.SWPlanets.SWPlanets;
import fr.tathan.SWPlanets.registries.BiomesRegistry;
import fr.tathan.SWPlanets.registries.BlocksRegistry;
import fr.tathan.SWPlanets.registries.FeatureRegistry;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

@Mod.EventBusSubscriber(modid = SWPlanets.MODID)
public class OreGeneration {

    public static int kyber_vein_size = 9;
    public static int kyber_vein_common = 20;






    // KYBER ORE DEEPSLATE
    public static final RegistryObject<ConfiguredFeature<?, ?>> KYBER_ORE_DEEPSLATE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("kyber_crystal_ore_deepslate", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlocksRegistry.CRYSTAL_KYBER_ORE.get().defaultBlockState(), kyber_vein_size)));
    //public static final RegistryObject<PlacedFeature> KYBER_ORE = FeatureRegistry.PLACED_FEATURES.register("kyber_crystal_ore", () -> new PlacedFeature(KYBER_ORE_DEEPSLATE_CONFIGURED.getHolder().get(), commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(100)))));
    public static final RegistryObject<PlacedFeature> KYBER_ORE_DEEPSLATE = FeatureRegistry.PLACED_FEATURES.register("kyber_crystal_ore_deepslate", () -> new PlacedFeature(KYBER_ORE_DEEPSLATE_CONFIGURED.getHolder().get(), commonOrePlacement(kyber_vein_common, HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(100)))));

    //KYBER ORE TATOOINE
    public static final TagKey<Block> TATOOINE_ORE_REPLACEABLES = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(SWPlanets.MODID, "tatooine_ore_replaceables"));
    public static final RuleTest TATOOINE_MATCH = new TagMatchTest(TATOOINE_ORE_REPLACEABLES);

    public static final RegistryObject<ConfiguredFeature<?, ?>> KYBER_ORE_TATOOINE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("kyber_crystal_ore_tatooine", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(TATOOINE_MATCH, BlocksRegistry.CRYSTAL_KYBER_ORE.get().defaultBlockState(), kyber_vein_size)));
    public static final RegistryObject<PlacedFeature> KYBER_ORE_TATOOINE = FeatureRegistry.PLACED_FEATURES.register("kyber_crystal_ore_tatooine", () -> new PlacedFeature(KYBER_ORE_TATOOINE_CONFIGURED.getHolder().get(), commonOrePlacement(kyber_vein_common, HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(100)))));


    @SubscribeEvent
    public static void biomesLoading(BiomeLoadingEvent biome) {

        if (biome.equals(BiomesRegistry.ENDOR_TAIGA)) {
            biome.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(KYBER_ORE_DEEPSLATE.getHolder().get());

        } else if (biome.equals(BiomesRegistry.KAMINO_OCEAN)) {
            biome.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(KYBER_ORE_DEEPSLATE.getHolder().get());

        } else if (biome.equals(BiomesRegistry.TATOOINE_DESERT)) {
            biome.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(KYBER_ORE_TATOOINE.getHolder().get());

        }  else if (biome.equals(BiomesRegistry.MUSTAFAR_HILL)) {
        biome.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(KYBER_ORE_DEEPSLATE.getHolder().get());

    }

    }

    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }


}
