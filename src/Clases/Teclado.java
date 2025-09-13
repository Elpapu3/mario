package Clases;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Teclado extends KeyAdapter {
    private final Jugador jugador;
    private boolean moviendose = false;

    public Teclado(Jugador jugador) {
        this.jugador = jugador;
    }

  
    @Override
    public void keyPressed(KeyEvent e) {
        int codigo = e.getKeyCode();
        moviendose = false; // por defecto no se mueve

        switch (codigo) {
            case KeyEvent.VK_LEFT -> {
                jugador.moverIzquierda();
                moviendose = true;
            }
            case KeyEvent.VK_RIGHT -> {
                jugador.moverDerecha();
                moviendose = true;
            }
            case KeyEvent.VK_SPACE -> jugador.saltar();
            // ignorar UP y DOWN
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        int codigo = e.getKeyCode();
        if (codigo == KeyEvent.VK_LEFT || codigo == KeyEvent.VK_RIGHT) {
            moviendose = false;
        }
    }

    public boolean isMoviendose() {
        return moviendose;
    }
}
