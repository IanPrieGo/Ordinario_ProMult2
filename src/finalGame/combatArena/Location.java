package finalGame.combatArena;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

import finalGame.*;

public class Location extends GameObject{
	

	String arenaName;
	String arenaDescription;
	BufferedImage backgroundImage;
	
	int posX = 0;
	int posY = 0;
	
	int height = 500;
	int width = 0;
	
	boolean key = true;
	
	String arena1Path = "src\\finalGame\\combatarena\\Arena1.png";
	String arena2Path = "src\\finalGame\\combatarena\\Arena2.png";
	
	public Location(GamePanel gp, KeyHandler keyH) {
		super(gp, keyH);
		
		
		
		try {
			
			backgroundImage = ImageIO.read(new File(arena1Path));
			
		} catch(IOException e) {
			
			e.printStackTrace();
			
		}
		
		width = (height * backgroundImage.getWidth()) / backgroundImage.getHeight();
	}
	
	public void update() {
		
		if (key) {
			height = gp.getHeight();
			width = (height * backgroundImage.getWidth()) / backgroundImage.getHeight();
			key = !key;
		}
		
		
	}
	
	public void draw(Graphics2D g2) {
		
		Image sprite = backgroundImage.getScaledInstance(width, height, 0);
		
		g2.drawImage(sprite, 0, 0, Color.red, null);
		
	}
	
}
	

	

