package Partie2;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class Main_Q6 {

    public static void main(String[] args) throws IOException {
        Distance distance = new Distance();
        BufferedImage originale = read(new File("img/images_fleur/originale.jpg"));

        // récupère toutes les images dans le dossier img/images_fleur et les compare à l'image originale
        File folder = new File("img/images_fleur");
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                BufferedImage image = read(file);
                System.out.println("distance(originale.jpg, " + file.getName() + ") = " + distance.distance(originale, image));
            }
        }
    }
}
