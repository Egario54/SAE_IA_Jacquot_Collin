package Partie1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import static javax.imageio.ImageIO.read;
import static javax.imageio.ImageIO.write;

public class Main_Q1 {
    public static void main(String[] args) throws IOException {
        File file = new File("img/images_fleur/copie_rouge.png");
        BufferedImage copie = read(file);

        boolean b = write(copie, "jpg", new File("img/Output/copie_rouge.jpg"));
        if (b){
            System.out.println("Copie réussie");
        } else {
            System.out.println("Copie échouée");
        }
    }
}
