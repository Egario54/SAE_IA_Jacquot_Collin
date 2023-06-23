package Partie3_SolutionSAE;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;
import static javax.imageio.ImageIO.write;

public class MainSolutionPerso {

    public static void main(String[] args) throws IOException {
        int nbCouleurs = 1500;
        if (args.length > 0) {
            nbCouleurs = Integer.parseInt(args[0]);
        }
        File file = new File("img/images_fleur/originale.jpg");
        BufferedImage copie = read(file);
        int width = copie.getWidth();
        int height = copie.getHeight();
        BufferedImage imgCopie = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        Calcul couleurs = new Calcul();

        Color[] tabCouleurs = couleurs.DonnerCouleursPresentes(copie, nbCouleurs);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height ; j++) {
                Color colorIJ = couleurs.DonnerCouleurPixel(copie, i, j, tabCouleurs);
                imgCopie.setRGB(i, j, colorIJ.getRGB());
            }
        }

        boolean b = write(imgCopie, "jpg", new File("img/Output/Part3.jpg"));
        if (b){
            System.out.println("Copie réussie");
        } else {
            System.out.println("Copie échouée");
        }
    }
}
