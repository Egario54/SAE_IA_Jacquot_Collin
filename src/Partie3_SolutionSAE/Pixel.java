package Partie3_SolutionSAE;

import java.awt.*;

public class Pixel {
    private int x;
    private int y;
    private Color col;

    public Pixel(int x, int y, Color c){
        this.x = x;
        this.y = y;
        this.col = c;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
