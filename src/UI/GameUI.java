package UI;

import java.awt.*;
import javax.swing.*;


public class GameUI extends JPanel{
	
	ImageIcon uI = new ImageIcon("src/Resourses/SSSBackgrounds.png");
	Image top;
	
	public GameUI() {
		
		top = new ImageIcon("src/Resourses/SSSBackgrounds.png").getImage();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(top, 0, 0, 10, 10, this);
	}
}