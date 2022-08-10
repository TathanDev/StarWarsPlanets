package fr.tathan.SWPlanets.registries;

import fr.tathan.SWPlanets.SWPlanets;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class SoundsRegistry {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SWPlanets.MODID);

    /**
     * SOUNDS
     */

    
    public static final RegistryObject<SoundEvent> STAR_WARS_OPENING_MUSIC = SOUNDS.register("star_wars_opening_music", () -> new SoundEvent(new ResourceLocation(SWPlanets.MODID, "star_wars_opening_music")));
    public static final RegistryObject<SoundEvent> SABER_ATTACK_SOUND_1 = SOUNDS.register("saber_attack_sound_1", () -> new SoundEvent(new ResourceLocation(SWPlanets.MODID, "saber_attack_sound_1")));
    public static final RegistryObject<SoundEvent> SABER_ATTACK_SOUND_2 = SOUNDS.register("saber_attack_sound_2", () -> new SoundEvent(new ResourceLocation(SWPlanets.MODID, "saber_attack_sound_2")));
    public static final RegistryObject<SoundEvent> SABER_ATTACK_SOUND_3 = SOUNDS.register("saber_attack_sound_3", () -> new SoundEvent(new ResourceLocation(SWPlanets.MODID, "saber_attack_sound_3")));
    public static final RegistryObject<SoundEvent> SABER_ATTACK_SOUND_4 = SOUNDS.register("saber_attack_sound_4", () -> new SoundEvent(new ResourceLocation(SWPlanets.MODID, "saber_attack_sound_4")));



}
