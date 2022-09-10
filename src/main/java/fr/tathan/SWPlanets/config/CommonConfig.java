package fr.tathan.SWPlanets.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfig {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<String> GALAXYNAME;
    //public static final ForgeConfigSpec.ConfigValue<Boolean> CUSTOMEMENU;




    static {
        BUILDER.push("Star Wars Planets Config");

        GALAXYNAME = BUILDER.comment("What should be the name of the Star Wars Galaxy. I hope you will don't touch this part of the config^^\nDefault = Starwarus (String)").define("Galaxy Name", "Starwarus");
        //CUSTOMEMENU = BUILDER.comment("Should the menu need to be change ?\nDefault = true (Boolean").define("Custom Screen", true);


        BUILDER.pop();
        SPEC = BUILDER.build();

    }
}
