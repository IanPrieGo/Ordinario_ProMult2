package game.test;

import java.awt.*;

import javax.swing.*;

import game.test.champion.Champion;
import game.test.champion.HitBox;
import game.test.combatarena.Location;


public class GamePanel extends JPanel implements Runnable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// SCREEN SETTINGS
	final double scale = 1;
	final int size = 500;

	final int screenWidth = (int) (size * scale * 1.5);
	final int screenHeight = (int) (size * scale);
	
	//FPS
	int FPS = 24;
	int oneSecondInNano = 1000000000;
	
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	HitBox enemy = new HitBox(400, 400-250, 250, 100, Color.pink, HitBox.enemy);
	Champion player1 = new Champion(this, keyH, enemy);
	Location arena = new Location(this, keyH);
	
	
	int healthPlayer1 = player1.health;
	
	

	public GamePanel () {
		


	this.setPreferredSize(new Dimension (screenWidth, screenHeight) );
	this.setBackground (Color.black);
	this.setDoubleBuffered (true);
	this.setFocusable(true);
	this.requestFocusInWindow(true);
	this.setFocusTraversalKeysEnabled(false);
	this.setLayout(null);
	this.addKeyListener(keyH);
	
	JPanel healthBar = new JPanel();
	healthBar.setPreferredSize(new Dimension(500,500));
	
	
	
	healthBar.setLocation(0, 0);
	this.add(healthBar);
	
	JPanel panel_1 = new JPanel();
	panel_1.setBounds(10, 10, 230, 37);
	panel_1.setBackground(new Color(255, 128, 255));
	this.add(panel_1);
	
	
	
//	this.addFocusListener(new java.awt.event.FocusAdapter() {
//	    public void focusGained(java.awt.event.FocusEvent e) {
//	        System.out.println("Panel gained focus");
//	    }
//	    public void focusLost(java.awt.event.FocusEvent e) {
//	        System.out.println("Panel lost focus");
//	    }
//	});
	
//	System.out.println("Focus owner: " + getParent().getFocus);
	
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		
		double drawInterval = oneSecondInNano/FPS; //0.01666 Secs
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;	
			lastTime = currentTime;
			
			if (delta >= 1) {
				// UPDATE: Update info & data
				update();
				
				// DRAW: Draws the grpahics whith new info & data
				repaint();
				
				delta--;
				
			}
					
		}
		
	}
	
	public void update() {
		
		arena.update();
		player1.update();
		
	}
	
	public void paintComponent(Graphics g) {
	
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
	
		arena.draw(g2);
		player1.draw(g2);
		
	
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.75f));
		g2.setColor(enemy.color);
		g2.fillRect(enemy.x, enemy.y, enemy.width, enemy.height);
//		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC));
		
//		g2.fillRect(0, 200, 500, 500);
		
		g2.dispose();
		
	}

}
