package fr.tathan.SWPlanets.events;

import fr.tathan.SWPlanets.SWPlanets;
import fr.tathan.SWPlanets.world.PlanetsRegistry;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


public class MeteoChanger {

    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world instanceof ServerLevel _origLevel) {
            LevelAccessor _worldorig = world;
            world = _origLevel.getServer().getLevel(PlanetsRegistry.KAMINO);
            if (world != null) {
                if (world instanceof ServerLevel _level)
                    _level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level,
                            4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(), "weather thunder");
            }
            world = _worldorig;
        }
        if (world instanceof ServerLevel _level)
            _level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",
                    new TextComponent(""), _level.getServer(), null).withSuppressedOutput(), "weather thunder");
    }

}



