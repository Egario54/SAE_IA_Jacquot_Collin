package Partie3_SolutionSAE;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class KMeans {
    private int k;
    private List<Color> centroides;

    private int width;

    private int height;

    public KMeans(int k, int width, int height) {
        this.k = k;
        this.width = width;
        this.height = height;
        this.centroides = new ArrayList<>();
    }

    public List<Color> compress(List<Color> pixels, int maxIterations) {
        //initialisation
        creerCentroides(pixels);

        //boucle principale
        for (int i = 0; i < maxIterations; i++) {
            List<Color>[] clusters = creerClusters(pixels);
            List<Color> nouveauxCentroides = calculerNouveauxCentroides(clusters);

            if (centroides.equals(nouveauxCentroides)) {
                System.out.println("Pas de changements dans les clusters à l'itération " + i + ", on quitte l'algorithme");
                break;
            }

            centroides = nouveauxCentroides;
        }
        //fin : on assigne les centroides
        return assignerCentroides(pixels);
    }

    /**
     * Initialise K centroïdes
     * @param pixels
     */
    private void creerCentroides(List<Color> pixels) {
        List<Color> listePix = new ArrayList<>(pixels);
        java.util.Collections.shuffle(listePix);
        centroides.addAll(listePix.subList(0, k));
    }

    private List<Color>[] creerClusters(List<Color> pixels) {
        List<Color>[] clusters = new List[k];

        for (int i = 0; i < k; i++) {
            clusters[i] = new ArrayList<>();
        }

        for (Color pixel : pixels) {
            int indexCentroide = trouverCentroide(pixel);
            clusters[indexCentroide].add(pixel);
        }

        return clusters;
    }

    private int trouverCentroide(Color pixel) {
        int index = 0;
        int pluspetitedistance = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {
            Color centroide = centroides.get(i);
            int distance = calculerDistance(pixel, centroide);

            if (distance < pluspetitedistance) {
                index = i;
                pluspetitedistance = distance;
            }
        }
        return index;
    }

    private int calculerDistance(Color pixel1, Color pixel2) {
        int r1 = pixel1.getRed();
        int g1 = pixel1.getGreen();
        int b1 = pixel1.getBlue();

        int r2 = pixel2.getRed();
        int g2 = pixel2.getGreen();
        int b2 = pixel2.getBlue();

        return (int) (Math.pow(r1-r2,2) + Math.pow(g1-g2,2) + Math.pow(b1-b2,2));
    }

    private List<Color> calculerNouveauxCentroides(List<Color>[] clusters) {
        List<Color> nouveauCentroides = new ArrayList<>();

        for (List<Color> cluster : clusters) {
            int taille = cluster.size();

            if (taille == 0) {
                // s'il n'y a pas de pixels, on continue
                nouveauCentroides.add(centroides.get(nouveauCentroides.size()));
                continue;
            }

            int sommeRed = 0;
            int sommeGreen = 0;
            int sommeBlue = 0;
            for (Color pixel : cluster) {
                sommeRed += pixel.getRed();
                sommeGreen += pixel.getGreen();
                sommeBlue += pixel.getBlue();
            }
            int R = sommeRed / taille;
            int G = sommeGreen / taille;
            int B = sommeBlue / taille;

            Color nouveauCentroide = new Color(R,G,B);
            nouveauCentroides.add(nouveauCentroide);
        }

        return nouveauCentroides;
    }

    /**
     * Assigne un pixel à un centroide
     * @param pixels
     * @return
     */
    private List<Color> assignerCentroides(List<Color> pixels) {
        List<Color> listePixels = new ArrayList<>();

        for (Color pixel : pixels) {
            //on trouve le meilleur centroïde
            Color centroide = centroides.get(trouverCentroide(pixel));
            listePixels.add(centroide);
        }

        return listePixels;
    }
}

