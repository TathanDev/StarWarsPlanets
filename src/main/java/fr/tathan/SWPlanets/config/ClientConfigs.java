package fr.tathan.SWPlanets.config;

import net.minecraftforge.common.ForgeConfigSpec;


public class ClientConfigs {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> CUSTOMEMENUACTIVATE;
    public static final ForgeConfigSpec.ConfigValue<Integer> CUSTOMEMENU;



    static {
        BUILDER.push("Star Wars Planets Config");

        CUSTOMEMENUACTIVATE = BUILDER.comment("Should the menu need to be change ?\nDefault = true (Boolean)\n").define("Custom Screen", true);
        
        CUSTOMEMENU = BUILDER.comment("Which Menu do you want? Star = 1\nPlanet = 2\nDefault = 1 (1-2)").define("Custom Screen number", 2);

        
        BUILDER.pop();
        SPEC = BUILDER.build();

    }
}


