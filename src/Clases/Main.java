package Clases;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main extends JFrame {
	public Main() {
		setTitle("Mario trucho");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Tablero panel = new Tablero();
		setContentPane(panel);	
		pack();
		setLocationRelativeTo(null);
	    setVisible(true);
	}
	   public static void main(String[] args) {
	        SwingUtilities.invokeLater(Main::new);
	   }
}
