package fr.tathan.SWPlanets.registries;

import com.mojang.serialization.Codec;
import fr.tathan.SWPlanets.SWPlanets;
import fr.tathan.SWPlanets.world.structures.TatooineHouses;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class StructuresRegistry {

    public static final DeferredRegister<StructureType<?>> DEFERRED_REGISTRY_STRUCTURE
            = DeferredRegister.create(Registry.STRUCTURE_TYPE_REGISTRY, SWPlanets.MODID);


    /**
     * Registers the base structure itself and sets what its path is. In this case,
     * this base structure will have the resourcelocation of structure_tutorial:sky_structures. */

    public static final RegistryObject<StructureType<?>> TATOOINE_HOUSES =
            DEFERRED_REGISTRY_STRUCTURE.register("tatooine_houses",  () -> typeConvert(TatooineHouses.CODEC));

    private static <S extends Structure> StructureType<S> typeConvert(Codec<S> codec) {
        return () -> codec;
    }


}
