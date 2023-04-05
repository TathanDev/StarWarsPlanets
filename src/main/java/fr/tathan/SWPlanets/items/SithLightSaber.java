package fr.tathan.SWPlanets.items;

import fr.tathan.SWPlanets.SWPlanets;
import fr.tathan.SWPlanets.registries.SoundsRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class SithLightSaber extends SwordItem {

    public SithLightSaber(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);


    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {

        Random rand = new Random();

        int random_sound = rand.nextInt(4);

        if(random_sound == 0) {
            entity.playSound(SoundsRegistry.SABER_ATTACK_SOUND_1.get(), 1f, 1f);
            SWPlanets.LOGGER.info("Play Light Saber sound 1");
            SWPlanets.LOGGER.info("Sound" + random_sound);

        }  else if (random_sound == 1){
            entity.playSound(SoundsRegistry.SABER_ATTACK_SOUND_2.get(), 1f, 1f);
            SWPlanets.LOGGER.info("Play Light Saber sound 2");
            SWPlanets.LOGGER.info("Sound" + random_sound);


        }    else if (random_sound == 2){
            entity.playSound(SoundsRegistry.SABER_ATTACK_SOUND_3.get(), 1f, 1f);
            SWPlanets.LOGGER.info("Play Light Saber sound 3");
            SWPlanets.LOGGER.info("Sound" + random_sound);
        }  else if (random_sound == 3){
            entity.playSound(SoundsRegistry.SABER_ATTACK_SOUND_4.get(), 1f, 1f);
            SWPlanets.LOGGER.info("Play Light Saber sound 4");
            SWPlanets.LOGGER.info("Sound" + random_sound);
        }

        return super.onEntitySwing(stack, entity);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.setSecondsOnFire(6);
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }




    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(new TranslatableComponent("tooltip.swplanets.sithlightsaber.tooltip.shift"));
        pTooltipComponents.add(new TranslatableComponent("tooltip.swplanets.sithlightsaber.tooltip.shift.two"));

    }

    @Override
    public void onCraftedBy(ItemStack pStack, Level pLevel, Player player) {
        super.onCraftedBy(pStack, pLevel, player);
        player.playSound(SoundsRegistry.SABER_ATTACK_SOUND_3.get(), 1f, 1f);

    }


}
    