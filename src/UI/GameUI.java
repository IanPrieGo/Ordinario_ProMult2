package UI;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import finalGame.GamePanel;
import finalGame.KeyHandler;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GameUI extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	BufferedImage bar;
		
	public GameUI (GamePanel gp, KeyHandler keyH) {
		
		try {
			bar = ImageIO.read( new File ("src\\Resourses\\SSSBackgrounds.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {

        g2.drawImage(bar, -30, 0, 860, 320, null);
    }
}