package fr.tathan.SWPlanets.events;

import fr.tathan.SWPlanets.registries.ItemsRegistry;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import fr.tathan.SWPlanets.SWPlanets;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;

import java.util.List;

@Mod.EventBusSubscriber(modid = SWPlanets.MODID)
public class Event {

    @SubscribeEvent
    public static  void addCustomTrades(VillagerTradesEvent event)
    {

        if(event.getType() == VillagerProfession.WEAPONSMITH) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ItemsRegistry.KYBER_CRYSTAL.get(), 1); 
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 59), //Price
                    stack,1,12,0.09F));
                               //Max use            Xp        Price X
        }

    }
}