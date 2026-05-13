package finalGame;


import java.awt.BorderLayout;

import javax.swing.JFrame;

import UI.GameUI;

public class MAIN extends JFrame{
	
	public MAIN() {
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true) ;
		window.setTitle("School Super Star");
		window.setLocation(550, 150);
		
		window.requestFocus();
		window.setLayout(new BorderLayout());
//		window.setFocusable(false); // DONOT COMMENT THIS IN, IT BREAKS EVERYTHING D:>
		
		GamePanel gameScreen = new GamePanel();	
		window.add(gameScreen, BorderLayout.CENTER);
		
		window.pack();
		
		gameScreen.startGameThread();
		
		//Pablo atempt to add UI
				add(new GameUI());
		
		window.setVisible (true);
		
	}
	
	public static void main (String [] args) {
		
		new MAIN();
		
	}
}