package dev.c1r5.nocc.overlays;

import dev.c1r5.nocc.commands.CalculateCoordinates;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.Level;

public class NoccOverlay {
    public static void render() {
        HudElementRegistry.attachElementAfter(
            VanillaHudElements.BOSS_BAR,
            Identifier.fromNamespaceAndPath("nocc", "coords_hud"),
            (drawContext, tickCounter) -> {
                Minecraft client = Minecraft.getInstance();

                if (client.player == null) return;

                double x = client.player.getX();
                double z = client.player.getZ();

                String line1;
                String line2;

                if (client.player.level().dimension() == Level.NETHER) {
                    double[] overworldCoords = CalculateCoordinates.nether2overworld(x, z);
                    line1 = String.format("Nether: %.1f, %.1f", x, z);
                    line2 = String.format("Overworld: %.1f, %.1f", overworldCoords[0], overworldCoords[1]);
                } else if (client.player.level().dimension() == Level.OVERWORLD) {
                    double[] netherCoords = CalculateCoordinates.overworld2nether(x, z);
                    line1 = String.format("Overworld: %.1f, %.1f", x, z);
                    line2 = String.format("Nether: %.1f, %.1f", netherCoords[0], netherCoords[1]);
                } else {
                    line1 = String.format("Current: %.1f, %.1f", x, z);
                    line2 = "";
                }

                Font font = client.font;

                int padding = 5;
                int screenWidth = drawContext.guiWidth();

                int y = 5;

                int line1X = screenWidth - font.width(line1) - padding;
                int line2X = screenWidth - font.width(line2) - padding;

                drawContext.text(font, line1, line1X, y, 0xFFFFFFFF);

                if (!line2.isEmpty()) {
                    drawContext.text(font, line2, line2X, y + 10, 0xFFFFFFFF);
                }
            }
        );
    }
}
