package Partie2;

import java.awt.image.BufferedImage;

import static Partie1.Main_Q5.separerRGB;

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
}
