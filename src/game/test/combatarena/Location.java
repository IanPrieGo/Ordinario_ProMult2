package game.test.combatarena;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

import game.test.*;

public class Location extends GameObject{
	

	String arenaName;
	String arenaDescription;
	BufferedImage backgroundImage;
	
	int posX = 0;
	int posY = 0;
	
	int height = 500;
	int width = 0;
	
	boolean key = true;
	
	String arena1Path = "C:\\Users\\priet\\eclipse-workspace\\Ordinario_Progra2\\src\\game\\test\\combatarena\\Arena1.png";
	String arena2Path = "C:\\Users\\priet\\eclipse-workspace\\Ordinario_Progra2\\bin\\game\\test\\combatarena\\Arena2.png";
	
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
		
		g2.drawImage(sprite, posX, posY, Color.red, null);
		
	}
	
}
	

	

