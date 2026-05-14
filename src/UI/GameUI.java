package UI;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import finalGame.GamePanel;
import finalGame.KeyHandler;
import finalGame.champion.Champion;
import finalGame.combatArena.Location;
import gamestates.Playing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GameUI{
	
	public Champion player;
	public Champion enemy;
	public GamePanel gp;
	public KeyHandler keyHan;
	public Location arena;
	public Playing play;
	
	int xWhy;
	int yWhy=500;
	int timerWidth = 25;
	boolean timerKey = true;
	boolean timerKey2 = true;
	
	BufferedImage bar;
	BufferedImage win;
	BufferedImage lose;
	
	int resultScreenW = 860;
	int resultScreenH = 360;
	
	JButton newGame;
	
	public int timer = 100;
	private long lastTime = System.currentTimeMillis();
	
	public void update() {

	    long currentTime = System.currentTimeMillis();

	    if(currentTime - lastTime >= 1000) {
	    	if(timer > 0) {
	            timer-=10;
	            
	   
	            
	            
	        }
	    	
	         if (timer < 100 && timerKey) {
	        	 timerWidth -= 10;
	        	 timerKey = !timerKey;
	         } else if (timer < 10 && timerKey2) {
	        	 timerWidth -= 10;
	        	 timerKey2 = !timerKey2;
	         }
	            

	        lastTime = currentTime;
	    }
		
	}
		
	public GameUI (GamePanel gp, KeyHandler keyH, Champion player, Champion enemy) {
		this.gp = gp;
		this.keyHan = keyH;
		this.player=player;
		this.enemy=enemy;
		xWhy = gp.screenWidth;
		yWhy = gp.screenHeight;
		
			    
	    
		try {
			bar = ImageIO.read( new File ("src\\Resourses\\SSSBackgrounds.png"));
			win = ImageIO.read( new File ("src\\Resourses\\Win.png"));
			lose = ImageIO.read( new File ("src\\Resourses\\Lose.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		newGame = new JButton("New Game");
		newGame.setBounds((gp.screenWidth/2)-50,gp.screenHeight/2,100,100);
		newGame.addActionListener(
            e -> restartGame()
        );

        gp.add(newGame);
        newGame.setVisible(true);

	}
	
	public void draw(Graphics2D g2) {
		g2.setComposite(
		        AlphaComposite.getInstance(
		            AlphaComposite.SRC_OVER, 1.0f));

		    g2.drawImage(bar, -30, -5, 860, 360, null);

		    g2.setColor(Color.WHITE);
		    g2.setFont(new Font("Arial", Font.BOLD, 40));

		    g2.drawString(
		        String.valueOf(timer),
		        (xWhy / 2) - timerWidth,
		        90
		    );

		    if (player.health <= 0) {
		        g2.drawImage(lose, (xWhy/2) - (resultScreenW/2), (yWhy/2) - (resultScreenH/2), resultScreenW, resultScreenH, null);
		    }

		    if (enemy.enemyHealth <= 0) {
		        g2.drawImage(win, (xWhy/2) - (resultScreenW/2), (yWhy/2) - (resultScreenH/2), resultScreenW, resultScreenH, null);

		    }

		    if (timer == 0) {

		        if (player.health < enemy.enemyHealth) {
		            g2.drawImage(lose, (xWhy/2) - (resultScreenW/2), (yWhy/2) - (resultScreenH/2), resultScreenW, resultScreenH, null);

		        }

		        if (player.health > enemy.enemyHealth) {
		            g2.drawImage(win, (xWhy/2) - (resultScreenW/2), (yWhy/2) - (resultScreenH/2), resultScreenW, resultScreenH, null);

		        }
		    } else {
		    	
		    }

//		    newGame.setVisible(gameEnd());
    }

	public boolean gameEnd() {
		if (player.health <= 0) {
			return true;
        }
        if (enemy.enemyHealth <= 0) {
        	return true;
        }
        if (timer == 0) {
        	return true;
        }
        return false;
	}
	
	public void restartGame(){
		 if (gameEnd()) {

		        timer = 200;
		        timerWidth = 25;

		        player.health = 100;

		        enemy.enemyHealth = 100;

		        player.x = 50;
		        player.y = (int)(player.floorHeight - player.height);

		        enemy.x = 500;
		        enemy.y = (int)(enemy.floorHeight - enemy.height);

		    }
    }
}