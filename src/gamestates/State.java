package gamestates;

import finalGame.GamePanel;

public class State {
	
	protected GamePanel game;
	public State (GamePanel game) {
		this.game=game;
	}
	
	public GamePanel getGamePanel() {
		return game;
	}
	
}
