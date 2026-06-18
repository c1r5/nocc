package dev.c1r5.nocc.commands;

import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateCoordinatesTest {

    @Test
    void testNetherToOverworldFormatted() {
        double[] result = CalculateCoordinates.nether2overworld(1.23456, -2.34567);
        String formatted = String.format(Locale.US, "%.3f, %.3f", result[0], result[1]);

        assertEquals("9.876, -18.765", formatted);
    }
}
