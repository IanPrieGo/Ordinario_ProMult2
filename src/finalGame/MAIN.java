package finalGame;


import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MAIN {
	
	public static void main (String [] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true) ;
		window.setTitle("School Super Star");
		window.setLocation(550, 150);
		window.setVisible (true);
		window.requestFocus();
		window.setLayout(new BorderLayout());
//		window.setFocusable(false); // DONOT COMMENT THIS IN, IT BREAKS EVERYTHING D:>
		
		GamePanel gameScreen = new GamePanel();	
		window.add(gameScreen, BorderLayout.CENTER);
		
		window.pack();
		
		System.out.println(window.getContentPane().getComponentCount());
		
		gameScreen.startGameThread();
		
	}
	

}