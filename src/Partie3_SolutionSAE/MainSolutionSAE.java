package Partie3_SolutionSAE;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.imageio.ImageIO.read;
import static javax.imageio.ImageIO.write;

public class MainSolutionSAE {
    public static void main(String[] args) throws IOException {

        //création d'une BUfferedImage
        File file = new File("img/images_fleur/originale.jpg");
        BufferedImage image = read(file);
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage imgCopie = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

        //Création d'une map des couleurs possibles de l'image
        List<,Pixel> couleurs = new HashMap<>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if(!couleurs.containsKey(image.getRGB(i,j))){
                    couleurs.put(1,new Pixel(i,j,new Color(image.getRGB(i,j))));
                }
            }
        }
        //Faire un classement de la fréquence d'apparition de la couleur


        //Application de l'algorithme KMeans
        int nbGroupes= 10;
        KMeans(couleurs, nbGroupes);



        //écrire le résultat
        boolean b = write(imgCopie, "jpg", new File("img/Output/copie.jpg"));
        if (b){
            System.out.println("Copie réussie");
        } else {
            System.out.println("Copie échouée");
        }
    }

    public static void KMeans(Map<Integer,Pixel> couleurs, int nbGroupes){
        //Initialisation des centroïdes
        List<int[]> centroides = new ArrayList<>();
        for (int i = 0; i < nbGroupes; i++) {
            centroides[i]=
        }
        //Boucle principale
        boolean nonFini = false;
        while(!nonFini){
            //On initialise les groupes
            for (int i = 0; i < nbGroupes; i++) {
                
            }
            //On construit ces groupes
            for (int i = 0; i < ; i++) {

            }
            //On met à jour les centroïdes
            for (int i = 0; i < nbGroupes; i++) {
                centroides[i]
            }
        }

    }

    public static int[] separerRGB(int color) {
        int blue = color & 0xff;
        int green = (color& 0xff00) >> 8;
        int red = (color & 0xff0000) >> 16;
        return new int[]{red, green, blue};
    }
}

/**
 * commented code
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
 */