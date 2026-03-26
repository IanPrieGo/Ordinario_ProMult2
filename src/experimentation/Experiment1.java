package experimentation;

import java.awt.*;

import javax.swing.*;

public class Experiment1 {
	
	public static void main (String [] args) {
		
		JFrame window = new JFrame();
		window.setSize(500, 500);
		window.setPreferredSize(new Dimension(250, 500));
		window.setVisible(true);
		window.getContentPane().setBackground(Color.red);
		window.setLayout(null);
		window.setLocation(100, 100);
		window.setTitle("0wo");

		
		JPanel panel1 = new JPanel(); panel1.setSize(200, 200);
		JPanel panel2 = new JPanel(); panel2.setSize(300, 300);
		JPanel panel3 = new JPanel(); panel3.setSize(400, 400);
		
		panel1.setBackground(Color.red);
		panel2.setBackground(Color.green);
		panel3.setBackground(Color.blue);
		
		window.add(panel1);
		window.add(panel2);
		window.add(panel3);
				
		
//		window.pack();
		
		System.out.println("End Program from here IDJIT");
		
	}
}
