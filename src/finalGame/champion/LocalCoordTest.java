package finalGame.champion;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;

import finalGame.GameObject;
import finalGame.GamePanel;
import finalGame.KeyHandler;

public class LocalCoordTest extends GameObject{
	
	int localX = 0;
	int localY = 0;
	
	int globalX;
	int globalY;
	
	int size = 100;
	int ovalSize = 10;
	
	int ovalX = 50;
	int ovalY = 0;
	
	

	public LocalCoordTest(GamePanel gp, KeyHandler keyH) {
		super(gp, keyH);
		
		globalX = gp.screenWidth/2;
		globalY = gp.screenHeight/2;
		
	}
	
	
	public void draw(Graphics2D g2) {
		AlphaComposite alcom;
		
		alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f);
		g2.setComposite(alcom);
		
		g2.setColor(Color.black);
		g2.fillRect((localX + globalX)-size/2, (localY + globalY) - size/2, size, size);
		
		g2.setColor(Color.GREEN);
		g2.fillOval(
			(globalX + ovalX) - ovalSize/2, 
			(globalY + ovalY) - ovalSize/2, 
			ovalSize, 
			ovalSize
		);
		
	}
	
	public void update() {
		
		ovalX *= -1;
		
		
	}
	

}
