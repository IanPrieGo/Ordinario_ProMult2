package UI;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import finalGame.GamePanel;
import finalGame.KeyHandler;
import finalGame.champion.Champion;
import finalGame.combatArena.Location;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GameUI extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Champion player1;
	public Location arena;
	
	int xWhy = 700;
	int yWhy = 180;
	
	BufferedImage bar;
	
	public int timer = 200;
	private long lastTime = System.currentTimeMillis();
	
	public void update() {

	    long currentTime = System.currentTimeMillis();

	    if(currentTime - lastTime >= 1000) {

	        if(timer > 0) {
	            timer--;
	        }

	        lastTime = currentTime;
	    }
	}
		
	public GameUI (GamePanel gp, KeyHandler keyH) {
		
		
		
		try {
			bar = ImageIO.read( new File ("src\\Resourses\\SSSBackgrounds.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		g2.setComposite(AlphaComposite.getInstance(
			    AlphaComposite.SRC_OVER, 1.0f));
        g2.drawImage(bar, -30, -5, 860, 360, null);
        
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.BOLD, 40));

        g2.drawString(String.valueOf(timer), xWhy/2, yWhy/2);
        
    }
}