package dev.c1r5.nocc.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.coordinates.Vec3Argument;
import net.minecraft.network.chat.Component;
import net.minecraft.world.phys.Vec3;

public class NoccCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("nocc")
            .then(Commands.literal("nether")
                .then(Commands.argument("pos", Vec3Argument.vec3(false))
                    .executes(NoccCommand::sendNetherCoordinates)))
            .then(Commands.literal("overworld")
                .then(Commands.argument("pos", Vec3Argument.vec3(false))
                    .executes(NoccCommand::sendOverworldCoordinates))));
    }

    private static int sendNetherCoordinates(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        CommandSourceStack source = context.getSource();
        Vec3 pos = Vec3Argument.getVec3(context, "pos");
        double[] coords = CalculateCoordinates.overworld2nether(pos.x, pos.z);

        source.sendSuccess(
            () -> Component.literal(String.format("Nether Coordinates: %.3f, %.3f, %.3f", coords[0], pos.y, coords[1])),
            false
        );
        return 1;
    }

    private static int sendOverworldCoordinates(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        CommandSourceStack source = context.getSource();
        Vec3 pos = Vec3Argument.getVec3(context, "pos");
        double[] coords = CalculateCoordinates.nether2overworld(pos.x, pos.z);

        source.sendSuccess(
            () -> Component.literal(String.format("Overworld Coordinates: %.3f, %.3f, %.3f", coords[0], pos.y, coords[1])),
            false
        );
        return 1;
    }
}
