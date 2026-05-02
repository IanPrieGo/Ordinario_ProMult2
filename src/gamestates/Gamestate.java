package gamestates;

public enum Gamestate {
	
	PLAYING, 
	MENU,
	AI_TESTING,
	PAUSE;
	
	public static Gamestate state = AI_TESTING;
	
}
