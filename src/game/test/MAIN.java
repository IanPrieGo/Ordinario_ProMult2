package game.test;


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
		
		
		gameScreen.startGameThread();
		
//		System.out.println(gameScreen.keyH);

	}
	

//	public static void main(String[] args) {
//	    JFrame window = new JFrame();
//	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	    window.setResizable(false);
//	    window.setTitle("School Super Star");
//	    window.setLocation(900, 150);
//	    window.setVisible(true); // ← LAST, after everything is added
////	    window.setFocusable(false);
//
//	    GamePanel gameScreen = new GamePanel();
//	    window.add(gameScreen);
//
//	    window.pack();
//	    gameScreen.startGameThread();
//
//	    
//	}
	
	
//	public static void main(String[] args) {
//	    JFrame window = new JFrame();
//	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	    window.setResizable(false);
//	    window.setTitle("School Super Star");
//	    window.setLocation(900, 150);
//
//	    GamePanel gameScreen = new GamePanel();
//	    window.add(gameScreen);
//	    window.pack();
//
//	    window.setVisible(true);
//	    
////	    gameScreen.requestFocusInWindow(); // ← call AFTER setVisible
//	    gameScreen.startGameThread();
//
////	    System.out.println("Focus owner: " + window.getFocusOwner());
//	}

}