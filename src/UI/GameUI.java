package UI;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import finalGame.GameObject;
import finalGame.GamePanel;
import finalGame.KeyHandler;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GameUI extends GameObject{
	
	ImageIcon uI = new ImageIcon("src\\Resourses\\SSSBackgrounds.png");
	Image top;
	BufferedImage bar;
	
	String topBar = "src\\Resourses\\SSSBackgrounds.png";
	
	public GameUI (GamePanel gp, KeyHandler keyH) {
		super(gp, keyH);
		
		try {
			bar = ImageIO.read( new File (topBar));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		
		Image sprite = bar.getScaledInstance(20, 20, 0);
		
		g2.drawImage(sprite, 0, 0, Color.red, null);
		
	}
}