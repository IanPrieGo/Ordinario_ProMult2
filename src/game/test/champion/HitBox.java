package game.test.champion;

import java.awt.Color;
import java.awt.Rectangle;

public class HitBox extends Rectangle{
	
	public static final int player = 1;
	public static final int enemy = 2;
	
	public Color color;
	
	public int collisionLayer;
	
	public HitBox(int x, int y, int height, int width, Color color) {
		this.x =  x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.color = color;
	}
	
	public HitBox(int x, int y, int height, int width, Color color, int collisionLayer) {
		this.x =  x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.color = color;
		this.collisionLayer = collisionLayer;
	}
	
	public HitBox() {
		this.x =  0;
		this.y = 0;
		this.height = 0;
		this.width = 0;
		this.color = Color.red;
	}
	
//	void isColliding() {
//		
//		
//		
//	}
	
	

}
