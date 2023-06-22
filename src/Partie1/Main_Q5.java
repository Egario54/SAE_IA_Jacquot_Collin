package Partie1;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;
import static javax.imageio.ImageIO.write;

public class Main_Q5 {
    public static void main(String[] args) throws IOException {
        File file = new File("img/images_fleur/copie.png");
        BufferedImage copie = read(file);

        int width = copie.getWidth();
        int height = copie.getHeight();
        BufferedImage imgCopie = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

        Color[] couleursDispo = new Color[2];
        couleursDispo[0] = Color.BLACK;
        couleursDispo[1] = Color.WHITE;
        for(int i = 0; i<width; i++){
            for(int j = 0; j<height; j++){
                int[] couleurs = separerRGB(copie.getRGB(i,j));
                double[] distance = new double[couleursDispo.length];
                for (int k = 0; k < distance.length; k++) {
                    distance[k]= (Math.pow(couleurs[0]-couleursDispo[k].getRed(),2))
                            +(Math.pow(couleurs[1]-couleursDispo[k].getGreen(),2))
                            +(Math.pow(couleurs[2]-couleursDispo[k].getBlue(),2));
                }
                System.out.println(distance[0] + " , " + distance[1]);
                if(distance[0]<distance[1]){
                    imgCopie.setRGB(i, j, couleursDispo[0].getRGB());
                } else imgCopie.setRGB(i, j, couleursDispo[1].getRGB());

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
