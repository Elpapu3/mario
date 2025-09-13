package Clases;

import java.awt.Color;
import java.awt.Graphics;

public class Enemigo {
    private int x, y;
    private int ancho = 40, alto = 40;

    public Enemigo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void dibujar(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y - alto, ancho, alto); // Enemigo como cuadrado verde
    }

    // Getters y setters
    public int getX() { return x; }
    public int getY() { return y; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
}
