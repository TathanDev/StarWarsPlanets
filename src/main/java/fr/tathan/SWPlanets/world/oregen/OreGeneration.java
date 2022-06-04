package fr.tathan.SWPlanets.world.oregen;


import fr.tathan.SWPlanets.SWPlanets;
import fr.tathan.SWPlanets.registries.BlocksRegistry;
import fr.tathan.SWPlanets.registries.FeatureRegistry;
import fr.tathan.SWPlanets.registries.PlanetsRegistry;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
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



    // KYBER ORE
    public static final RegistryObject<ConfiguredFeature<?, ?>> KYBER_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("kyber_crystal_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlocksRegistry.CRYSTAL_KYBER_ORE.get().defaultBlockState(), 8)));
    public static final RegistryObject<PlacedFeature> KYBER_ORE = FeatureRegistry.PLACED_FEATURES.register("kyber_crystal_ore", () -> new PlacedFeature(KYBER_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(192)))));

    @SubscribeEvent
    public static void biomesLoading(BiomeLoadingEvent event) {

        if (event.getCategory() == Biome.BiomeCategory.JUNGLE) {
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(KYBER_ORE.getHolder().get());
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
