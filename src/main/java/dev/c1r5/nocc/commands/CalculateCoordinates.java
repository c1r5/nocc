package dev.c1r5.nocc.commands;

public class CalculateCoordinates {

    public static double[] nether2overworld(double x, double z) {
        double overworldX = x * 8;
        double overworldZ = z * 8;
        return new double[]{overworldX, overworldZ};
    }

    public static double[] overworld2nether(double x, double z) {
        double netherX = x / 8;
        double netherZ = z / 8;
        return new double[]{netherX, netherZ};
    }
    
}
