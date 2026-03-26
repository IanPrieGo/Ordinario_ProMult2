package experimentation;

import java.awt.*;

import javax.swing.*;

public class ExperimentalGUI {
	
	public static void main (String [] args) {
		
		Color lightGreen = new Color(183, 207, 104);
		Color lightMagenta = new Color(175, 146, 190);
		Color cafe = new Color(54, 21, 12);
		Color cafeOscuro = new Color(18, 0, 0);
		
		JFrame window = new JFrame();
		window.setVisible(true);
		window.setSize(new Dimension(900, 500));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.getContentPane().setBackground(cafeOscuro);
		window.setLayout(new GridBagLayout());
//		window.setLayout(new RelativeLayout());
		
		PanelProporcional windowContent = new PanelProporcional(1.5 / 1.0);
//		windowContent.setPreferredSize(new Dimension(500, 500));
		windowContent.setBackground(lightMagenta);
		
		window.getContentPane().add(windowContent);
		
		JPanel menu = new JPanel();
		menu.setLayout(new BorderLayout());
		
		JLabel tituloMenu = new JLabel("Menu", JLabel.CENTER);
		tituloMenu.setPreferredSize(new Dimension(300, 90));
		tituloMenu.setBackground(lightGreen);
		tituloMenu.setFont(new Font("", Font.PLAIN, 50));
		
		JPanel opcionesMenu = new JPanel();
		opcionesMenu.setLayout(new FlowLayout());
		opcionesMenu.setBackground(Color.red);
		
		JButton iniciar = new JButton("START");
		JButton configuracion = new JButton("SETTINGS");
		JButton salir = new JButton("QUIT");
		
		opcionesMenu.add(iniciar);
		opcionesMenu.add(configuracion);
		opcionesMenu.add(salir);
		
		
		JPanel test = new JPanel();
		test.setBackground(Color.BLUE);
		
		
		menu.add(tituloMenu, BorderLayout.SOUTH);
		menu.add(test, BorderLayout.CENTER);
		
		windowContent.add(menu, BorderLayout.CENTER);
		
		
		System.out.println("Close from here beech");
		
	}
	
}
