package experimentation;

import java.awt.*;
import javax.swing.*;

public class JavaSwingLayoutTut {
	
	public static void main (String [] args) {
		
		JFrame window = new JFrame();
		
		window.setSize(640, 400);
		window.setLocation(100, 100);
		window.setTitle("uwu");
		
		CardLayout cards = new CardLayout();
		
		window.setLayout(cards);

		
		JLabel label1 = new JLabel("Label1");
		label1.setBounds(10, 10, 100, 20);
		label1.setBackground(Color.red);
		window.add(label1, "Label 1");
		
		JButton button1 = new JButton("Button1");
		button1.setBounds(200, 10, 100, 20);
		button1.setBackground(Color.red);
		window.add(button1, "Button 1");
		
		
		JLabel label2 = new JLabel("Label2");
		label2.setBounds(150, 40, 100, 20);
		label2.setBackground(Color.red);
		window.add(label2, "Label 2");
		
		JButton button2 = new JButton("Button2");
		button2.setBounds(300, 40, 100, 20);
		button2.setBackground(Color.red);
		window.add(button2, "Button 2");
		
		
		
		cards.show(window.getContentPane(), "Button 1");
		
		
		
		window.setVisible(true);
		System.out.println("CLOSE FROM HERE YOU IDJIT");
	}

}
