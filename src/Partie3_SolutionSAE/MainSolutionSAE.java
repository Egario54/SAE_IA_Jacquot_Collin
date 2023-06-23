package Partie3_SolutionSAE;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

import static javax.imageio.ImageIO.write;

public class MainSolutionSAE {
    private static int maxIterations = 100;

    public static void main(String[] args) {
        String path = "img/images_fleur/originale.jpg";
        String output = "img/Output/output.jpg";
        int k = 50;
        if(args.length>0){
            k = Integer.parseInt(args[0]);
        }

        try {
            BufferedImage original = ImageIO.read(new File(path));
            BufferedImage copie = effectuerCopie(original, k);
            ImageIO.write(copie, "jpg", new File("img/Output/copie.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage effectuerCopie(BufferedImage origine, int k) {
        int width = origine.getWidth();
        int height = origine.getHeight();

        // Obtenir la liste de pixels
        List<Color> pixels = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color pixel = new Color(origine.getRGB(i, j));
                pixels.add(pixel);
            }
        }

        // Algorithme KMeans
        KMeans kmeans = new KMeans(k,width,height);
        List<Color> compressedPixels = kmeans.compress(pixels, maxIterations);


        BufferedImage copie = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        int index = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color pixel = compressedPixels.get(index++);
                copie.setRGB(i, j, pixel.getRGB());
            }
        }

        return copie;
    }
}

