package Partie1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;
import static javax.imageio.ImageIO.write;

public class Main_Q2 {
    public static void main(String[] args) throws IOException {

        // fais moi un file pouvant être utilisé par bufferedImage avec imageUrl
        File file = new File("img/images_fleur/copie.png");
        BufferedImage copie = read(file);

        int width = copie.getWidth();
        int height = copie.getHeight();
        BufferedImage imgCopie = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        for(int i = 0; i<width; i++){
            for(int j = 0; j<height; j++){
                imgCopie.setRGB(i, j, copie.getRGB(i,j));
            }
        }

        boolean b = write(copie, "jpg", new File("img/Output/copie.jpg"));
        if (b){
            System.out.println("Copie réussie");
        } else {
            System.out.println("Copie échouée");
        }
    }
}
