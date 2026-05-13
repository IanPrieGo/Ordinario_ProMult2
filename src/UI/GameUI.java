package UI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class GameUI extends JPanel{
	
	ImageIcon uI = new ImageIcon("src/Resourses/SSSBackgrounds.png");
	Image top;
	
	public GameUI() {
		
		top = new ImageIcon("SSSBackgrounds.png").getImage();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(top, 10, 10, 10, 10, this);
	}
}