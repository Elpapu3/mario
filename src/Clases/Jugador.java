package Clases;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Jugador {
    private int x, y;
    private int ancho, alto;
    private BufferedImage sprite;

    private int frameActual = 0;
    private int frameContador = 0;
    private int cantidadFrames;

    private double velY = 0;          // velocidad vertical
    private final double gravedad = 0.8;
    private final double impulso = -15;
    private boolean enSuelo = true;
    private boolean saltando = false;
    private final int suelo = 550;

    public Jugador(int x, int y, int ancho, int alto, int cantidadFrames, String rutaImagen) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.cantidadFrames = cantidadFrames;

        try {
            sprite = ImageIO.read(getClass().getResource(rutaImagen));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dibujar(Graphics g) {
        if (sprite != null) {
            int cuadroAncho = sprite.getWidth() / cantidadFrames;

            BufferedImage cuadro = sprite.getSubimage(
                frameActual * cuadroAncho,
                0,
                cuadroAncho,
                sprite.getHeight()
            );

            g.drawImage(cuadro, x, y - alto, ancho, alto, null);
        }
    }

    public void actualizar(boolean moviendose) {
        // gravedad / salto
        if (!enSuelo || saltando) {
            velY += gravedad;
            y += velY;

            if (y >= suelo) {
                y = suelo;
                velY = 0;
                enSuelo = true;
                saltando = false;
            } else {
                enSuelo = false;
                saltando = true;
            }
        }

        // animación solo si se mueve
        if (moviendose) {
            frameContador++;
            if (frameContador % 5 == 0) {
                frameActual = (frameActual + 1) % cantidadFrames;
            }
        } else {
            frameActual = 0;
        }
    }

    public void moverIzquierda() { x -= 10; }
    public void moverDerecha() { x += 10; }
    public void saltar() {
        if (enSuelo) {
            velY = impulso;
            enSuelo = false;
            saltando = true;
        }
    }

    public int getX() { return x; }
    public int getY() { return y; }
}
