package finalGame;

import java.awt.Graphics2D;

import finalGame.champion.*;
import finalGame.combatArena.*;

public class GameMatch {
	
	Champion player1;
	Champion player2;
	Location combatArena;
	MatchInfoDisplay gui;
	
	int timer;
	
	
	public void update() {
		
		player1.update();
		player2.update();
		combatArena.update();
		gui.update();
		
	}
	
	public void draw(Graphics2D g2)  {
		
		player1.draw(g2);
		player2.draw(g2);
		combatArena.draw(g2);
		gui.draw(g2);
		
	}
	

}
