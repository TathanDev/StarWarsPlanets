package fr.tathan.SWPlanets.items;

import fr.tathan.SWPlanets.SWPlanets;
import fr.tathan.SWPlanets.registries.SoundsRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class JediLightSaber extends SwordItem {

    public JediLightSaber(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);


    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.setSecondsOnFire(8);

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
    

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.swplanets.jedilightsaber.tooltip.shift"));
            pTooltipComponents.add(new TranslatableComponent("tooltip.swplanets.jedilightsaber.tooltip.shift.two"));

    }


}
