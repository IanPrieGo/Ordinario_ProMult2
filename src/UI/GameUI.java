package UI;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameUI {
	
	ImageIcon uI = new ImageIcon("src/Resourses/SSSBackgrounds.png");
	Image top;
	
	public GameUI() {
		
		top = uI.getImage();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(top, 10, 10, 10, 10, this);
	}
}