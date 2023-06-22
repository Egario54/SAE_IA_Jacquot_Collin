package Partie1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;
import static javax.imageio.ImageIO.write;

public class Main_Q2 {
    public static void main(String[] args) throws IOException {
        File file = new File("img/images_fleur/copie.png");
        BufferedImage image = read(file);

        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage imgCopie = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        for(int i = 0; i<width; i++){
            for(int j = 0; j<height; j++){
                imgCopie.setRGB(i, j, image.getRGB(i,j));
            }
        }

        boolean b = write(imgCopie, "jpg", new File("img/Output/copie.jpg"));
        if (b){
            System.out.println("Copie réussie");
        } else {
            System.out.println("Copie échouée");
        }
    }
}
