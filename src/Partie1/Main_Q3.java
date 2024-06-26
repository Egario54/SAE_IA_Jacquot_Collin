package Partie1;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static javax.imageio.ImageIO.read;
import static javax.imageio.ImageIO.write;

public class Main_Q3 {
    public static void main(String[] args) throws IOException {
        File file = new File("img/images_fleur/originale.jpg");
        BufferedImage copie = read(file);

        int width = copie.getWidth();
        int height = copie.getHeight();
        BufferedImage imgCopie = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        for(int i = 0; i<width; i++){
            for(int j = 0; j<height; j++){
                int[] couleurs = separerRGB(copie.getRGB(i,j));
                int gris = 0;
                for (int k = 0; k < couleurs.length; k++) {
                    gris += couleurs[k];
                }
                int g = gris / couleurs.length;
                imgCopie.setRGB(i, j, new Color(g,g,g).getRGB());
            }
        }

        boolean b = write(imgCopie, "jpg", new File("img/Output/copie.jpg"));
        if (b){
            System.out.println("Copie réussie");
        } else {
            System.out.println("Copie échouée");
        }
    }

    public static int[] separerRGB(int color) {
        int blue = color & 0xff;
        int green = (color& 0xff00) >> 8;
        int red = (color & 0xff0000) >> 16;
        return new int[]{red, green, blue};
    }
}

