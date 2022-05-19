package fr.tathan.SWPlanets.registries;

import fr.tathan.SWPlanets.SWPlanets;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundsRegistry {


    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SWPlanets.MODID);

    /** SOUNDS */
    public static final RegistryObject<SoundEvent> STAR_WARS_OPENING_MUSIC = SOUNDS.register("star_wars_opening_music",() -> new SoundEvent(new ResourceLocation(SWPlanets.MODID, "star_wars_opening_music")));

}
