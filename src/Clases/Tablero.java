package Clases;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Tablero extends JPanel {
    private final int ancho = 800, alto = 600;  
    private final Jugador jugador;
    private final Teclado teclado;

    public Tablero() {
        setPreferredSize(new java.awt.Dimension(ancho, alto));
        setBackground(Color.green);

        // sprite sheet: 4 frames, ruta de imagen
        jugador = new Jugador(100, 550, 64, 64, 4, "/imagen/ju.png");

        teclado = new Teclado(jugador);
        setFocusable(true);
        addKeyListener(teclado);

        Timer timer = new Timer(30, e -> {
            jugador.actualizar(teclado.isMoviendose());
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // dibujar suelo
        g.setColor(Color.RED);
        g.fillRect(0, 550, ancho, 50);

        // dibujar jugador
        jugador.dibujar(g);
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Mini Mario Bros");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(new Tablero());
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
