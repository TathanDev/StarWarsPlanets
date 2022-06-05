package fr.tathan.SWPlanets.registries;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class Tiers {

    public static final ForgeTier KYBER = new ForgeTier(2, 1400, 1,
            0, 10, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ItemsRegistry.KYBER_CRYSTAL.get()));
}
