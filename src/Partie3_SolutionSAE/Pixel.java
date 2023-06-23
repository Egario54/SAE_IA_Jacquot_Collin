package Partie3_SolutionSAE;

import java.awt.*;

public class Pixel {
    private int x;
    private int y;
    private Color col;
    private int frequence;

    public Pixel(int x, int y, Color c){
        this.x = x;
        this.y = y;
        this.col = c;
        this.frequence = 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getFrequence() {
        return frequence;
    }

    public void augmenterFrequence(){
        frequence++;
    }

    public Color getColor() {
        return col;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj.getClass()==this.getClass())) return false;
        return ((Pixel) obj).getColor().getRed() == this.getColor().getRed()
                && ((Pixel) obj).getColor().getBlue() == this.getColor().getBlue()
                && ((Pixel) obj).getColor().getGreen() == this.getColor().getGreen();
    }
}
