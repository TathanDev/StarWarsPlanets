package fr.tathan.SWPlanets.items;

import fr.tathan.SWPlanets.SWPlanets;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.property.Properties;
import net.minecraftforge.fml.ModList;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;



public class StarManual extends Item {


    public static final TranslatableComponent PATCHOULI_ERROR = new TranslatableComponent("message." + SWPlanets.MODID + ".error.patchouli");

    public StarManual(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
        if (ModList.get().isLoaded("patchouli")) {
            if (level.isClientSide) {
                vazkii.patchouli.api.PatchouliAPI.get().openBookGUI(new ResourceLocation("swplanets:star_manual"));
            }
        } else {
            if (level.isClientSide) {
                //I Know this part is stupid but...
                playerIn.displayClientMessage(PATCHOULI_ERROR, true);
            }
        }

        return new InteractionResultHolder<>(InteractionResult.SUCCESS, playerIn.getItemInHand(handIn));

    }

}
