
import javax.swing.*;
import java.awt.*;


public class GUITest extends JFrame{
	
	
	
	public GUITest() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 128));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(250, 100));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 230, 37);
		panel_1.setBackground(new Color(255, 128, 255));
		panel.add(panel_1);
		
		setVisible(true);
		setLocation(100, 100);
		setSize(900, 500);
		setResizable(true);
		
		JPanel healthBar = new JPanel();
		healthBar.setSize(new Dimension(1280, 1112));
		healthBar.setLocation(370, 143);
		healthBar.setBackground(Color.red);
		panel.add(healthBar);
		
		
	}

	public static void main(String[] args) {
		
		GUITest window = new GUITest();

	}
}
