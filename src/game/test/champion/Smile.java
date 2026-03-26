package game.test.champion;

import javax.swing.*;
import java.awt.*;

public class Smile extends JPanel{
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		int faceSize = 500;
		int eyeSize = 35;
		int mouthSize = 150;
		
		int centerX = (getWidth()/2);
		int centerY = (getHeight()/2);
		
		g.setColor(Color.yellow); //Rostro
		g.fillOval((centerX - (faceSize/2)), (centerY - (faceSize/2)), faceSize, faceSize);
		
		g.setColor(Color.black); //Ojos
		g.fillOval(
				(centerX - ((eyeSize/2) + 75)), 
				(centerY - ((eyeSize/2) + 25)), 
				eyeSize, 
				eyeSize
				);
		g.fillOval(
				(centerX + ((eyeSize/2) + 45)), 
				(centerY - ((eyeSize/2) + 25)), 
				eyeSize, 
				eyeSize
				);
		
		g.fillOval(
				(centerX - ((mouthSize/2) + 0)), 
				(centerY + ((mouthSize/2) - 75)), 
				mouthSize, 
				mouthSize/3
				);
		
		g.setColor(Color.yellow); //Ojos
		g.fillOval(
				(centerX - ((mouthSize/2) + 0)), 
				(centerY + ((mouthSize/2) - 90)), 
				mouthSize, 
				mouthSize/3
				);
		
	}
	
	public static void main(String [] args) {
		
		JFrame window = new JFrame(); 
		window.setSize(new Dimension(500, 500));
		window.setResizable(true);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		window.setLayout(null);
		
		
		Smile smilePanel = new Smile();
		
		
		window.add(smilePanel);	

		
		
	}

}
