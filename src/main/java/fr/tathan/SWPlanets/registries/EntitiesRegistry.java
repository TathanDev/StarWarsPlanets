package fr.tathan.SWPlanets.registries;

import fr.tathan.SWPlanets.SWPlanets;
import fr.tathan.SWPlanets.entities.SpeederEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntitiesRegistry {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, SWPlanets.MODID);



    public static final RegistryObject<EntityType<SpeederEntity>> SPEEDER = ENTITIES.register("speeder", () -> EntityType.Builder.of(SpeederEntity::new, MobCategory.MISC).sized(2.5f, 1.0f).fireImmune().build(new ResourceLocation(SWPlanets.MODID, "speeder").toString()));

}
