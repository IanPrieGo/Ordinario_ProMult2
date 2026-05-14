package UI;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GameUI extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	BufferedImage bar;
		
	public GameUI () {
		
		try {
			bar = ImageIO.read( new File ("src\\Resourses\\SSSBackgrounds.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setPreferredSize(new Dimension(800, 600));
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // Draw image on top-left corner
        g2.drawImage(bar, 0, 0, 200, 100, null);
    }
}