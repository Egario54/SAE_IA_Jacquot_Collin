package Partie3_SolutionSAE;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

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
        Map<Pixel,Integer> couleurs = new HashMap<>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Pixel p = new Pixel(i,j,new Color(image.getRGB(i,j)));
                if(!couleurs.containsKey(p)){
                    couleurs.put(p,1);
                }
                //L'integer sert à faire un classement de couleurs pour en avoir une fréquence
                else {
                    couleurs.put(p,couleurs.get(p)+1);
                }
            }
        }

        //Application de l'algorithme KMeans
        int nbGroupes= 10;
        KMeans(couleurs, nbGroupes, width, height);

        //écrire le résultat
        boolean b = write(imgCopie, "jpg", new File("img/Output/copie.jpg"));
        if (b){
            System.out.println("Copie réussie");
        } else {
            System.out.println("Copie échouée");
        }
    }

    public static void KMeans(Map<Pixel,Integer> couleurs, int nbGroupes, int width, int height){
        //Initialisation des centroïdes
        List<int[]> centroides = new ArrayList<>();
        for (int i = 0; i < nbGroupes; i++) {
            centroides.add(new int[]{(int) (Math.random()*width),(int) (Math.random()*height)});
        }
        //Boucle principale
        boolean nonFini = false;
        while(!nonFini){
            Map<Integer[], List<Integer[]>> groupes = new HashMap<>();
            //On initialise les groupes
            for (int i = 0; i < nbGroupes; i++) {
                groupes.put(new Integer[]{centroides.get(i)[0],centroides.get(i)[1]}, null);
            }
            //On construit ces groupes
            Pixel[] pixels = couleurs.keySet().toArray(new Pixel[0]);
            for (int i = 0; i < couleurs.size(); i++) {
                //On associe la seconde valeur des groupes
                int[] centroïde = associerCentroide(new int[]{pixels[i].getX(),pixels[i].getY()}, centroides);
                //
                groupes.
                distance =
            }
            //On met à jour les centroïdes
            for (int i = 0; i < nbGroupes; i++) {
                centroides.set(i, barycentre(groupes.get(centroides.get(i))));
            }
        }

    }

    /**
     * Cherche le centroïde le plus proche
     * @param donnee la donnée concernée (un pixel)
     * @param centroides
     * @return le centroide sélectionné
     */
    private static int[] associerCentroide(int [] donnee, List<int[]> centroides) {

        return
    }

    private static int[] barycentre(List<Integer[]> ensemblePoints) {
        int x=0;
        int y=0;
        for (Integer[] ensemblePoint : ensemblePoints) {
            x += ensemblePoint[0];
            y += ensemblePoint[1];
        }
        return new int[]{Math.round((float) x / ensemblePoints.size()), Math.round((float) y / ensemblePoints.size())};
    }

    public static int[] separerRGB(int color) {
        int blue = color & 0xff;
        int green = (color& 0xff00) >> 8;
        int red = (color & 0xff0000) >> 16;
        return new int[]{red, green, blue};
    }
}
