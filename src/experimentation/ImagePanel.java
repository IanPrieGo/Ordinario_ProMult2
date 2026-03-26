package experimentation;

//Source - https://stackoverflow.com/q/24125249
//Posted by jackal992, modified by community. See post 'Timeline' for change history
//Retrieved 2026-03-16, License - CC BY-SA 3.0

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ImagePanel extends JPanel {
     private ImageIcon background;
     private JFrame parentFrame;
     private ImageIcon smallerImage = new ImageIcon("C:\\Users\\priet\\OneDrive\\Escritorio\\tILE_00.png");

     public ImagePanel(String imgPath, JFrame parentFrame)  {
         this.parentFrame = parentFrame;
         background = new ImageIcon(getClass().getResource(imgPath));
     }

     @Override
     public void paintComponent(Graphics g) {
         super.paintComponent(g);
         Graphics2D g2d = (Graphics2D) g.create();
         g2d.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
         g2d.drawImage(smallerImage.getImage(), 119*((parentFrame.getWidth()/768)), 172*((parentFrame.getHeight())/768), 32*((parentFrame.getWidth())/768), 32*((parentFrame.getHeight())/768),this);
     }   
}
