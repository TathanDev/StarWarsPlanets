package fr.tathan.SWPlanets.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<String> GALAXYNAME;



    static {
        BUILDER.push("Star Wars Planets Config");

        GALAXYNAME = BUILDER.comment("What should be the name of the Star Wars Galaxy. I hope you will don't touch this part of the config^^\nDefault = Starwarus (String)").define("Galaxy Name", "Starwarus");
        

        BUILDER.pop();
        SPEC = BUILDER.build();

    }
}
