package Partie3_SolutionSAE;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Calcul {

    public static Color[] DonnerCouleursPresentes(BufferedImage image, int size) {
        Map<Integer, Integer> colorCountMap = new HashMap<>();

        int width = image.getWidth();
        int height = image.getHeight();

        // Parcours de tous les pixels de l'image pour compter les occurrences de chaque couleur
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int rgb = image.getRGB(i, j);
                colorCountMap.put(rgb, colorCountMap.getOrDefault(rgb, 1) + 1);
            }
        }

        // Tri du map selon les valeurs (nombre d'occurrences) dans l'ordre décroissant
        List<Map.Entry<Integer, Integer>> colorCountList = new ArrayList<>(colorCountMap.entrySet());
        colorCountList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Si les couleurs on une distance inférieure à 100, on les fusionne
        for (int i = 0; i < colorCountList.size(); i++) {
            for (int j = i + 1; j < colorCountList.size(); j++) {
                Color color1 = new Color(colorCountList.get(i).getKey());
                Color color2 = new Color(colorCountList.get(j).getKey());
                if (Distance.distanceCouleurs(color1, color2) < colorCountMap.size() / size *0.6 ) {
                    int rgb = color1.getRGB();
                    int count = colorCountList.get(i).getValue() + colorCountList.get(j).getValue();
                    colorCountList.set(i, Map.entry(rgb, count));
                    colorCountList.remove(j);
                    j--;
                }
            }
        }

        // Sélection des couleurs les plus présentes jusqu'à la taille spécifiée
        Color[] colorsPresent = new Color[size];
        for (int i = 0; i < size; i++) {
            int rgb = colorCountList.get(i).getKey();
            colorsPresent[i] = new Color(rgb);
        }
        return colorsPresent;
    }

    public Color DonnerCouleurPixel(BufferedImage image, int x, int y, Color[] Couleurs){
        Color couleur = new Color(image.getRGB(x,y));
        Color couleurRGB;
        Distance d = new Distance();
        couleurRGB = Couleurs[0];
        for (int i = 1; i<Couleurs.length; i++){
            Long distance = d.distanceCouleurs(couleur, Couleurs[i]);
            if (distance < d.distanceCouleurs(couleur, couleurRGB)){
                couleurRGB = Couleurs[i];
            }
        }
        return couleurRGB;
    }
}
