package UI;

import java.awt.*;

import javax.imageio.ImageIO;
import finalGame.GamePanel;
import finalGame.KeyHandler;
import finalGame.champion.Champion;
import finalGame.combatArena.Location;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GameUI{
	
	public GamePanel gp;
	public KeyHandler keyHan;
	public Champion player;
	public Champion enemy;
	public Location arena;
	
	int xWhy;
	int yWhy=500;
	int timerWidth = 25;
	boolean timerKey = true;
	
	BufferedImage bar;
	BufferedImage win;
	BufferedImage lose;
	
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
		if (timer < 100 && timerKey) {
	    	timerWidth -= 10;
	    	
	    	timerKey = !timerKey;
		}
	}
		
	public GameUI (GamePanel gp, KeyHandler keyH, Champion player, Champion enemy) {
		this.gp = gp;
		this.keyHan = keyH;
		xWhy = gp.screenWidth;
		this.player = player;
	    this.enemy = enemy;
	    
	    
		try {
			bar = ImageIO.read( new File ("src\\Resourses\\SSSBackgrounds.png"));
			win = ImageIO.read( new File ("src\\Resourses\\Win.png"));
			lose = ImageIO.read( new File ("src\\Resourses\\Lose.png"));
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

        g2.drawString(String.valueOf(timer), (xWhy/2) - timerWidth, yWhy-410);
        
    }
}