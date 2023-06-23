package Partie3_SolutionSAE;

import java.awt.*;
import java.awt.image.BufferedImage;

import static Partie3_SolutionSAE.MainSolutionSAE.separerRGB;

public class Distance {
    public Long distance(BufferedImage i1, BufferedImage i2) {
        int width = i1.getWidth();
        int height = i1.getHeight();
        double distance = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int[] couleurs1 = separerRGB(i1.getRGB(i, j));
                int[] couleurs2 = separerRGB(i2.getRGB(i, j));
                distance += (Math.pow(couleurs1[0] - couleurs2[0], 2))
                        + (Math.pow(couleurs1[1] - couleurs2[1], 2))
                        + (Math.pow(couleurs1[2] - couleurs2[2], 2));
            }
        }
        return Math.round(distance);
    }

    public static Long distanceCouleurs(Color i1, Color i2) {
        int[] couleurs1 = separerRGB(i1.getRGB());
        int[] couleurs2 = separerRGB(i2.getRGB());
        double distance = (Math.pow(couleurs1[0] - couleurs2[0], 2))
                + (Math.pow(couleurs1[1] - couleurs2[1], 2))
                + (Math.pow(couleurs1[2] - couleurs2[2], 2));
        return Math.round(distance);
    }
}
