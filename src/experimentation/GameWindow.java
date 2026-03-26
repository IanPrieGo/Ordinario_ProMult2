// Source - https://stackoverflow.com/q/24125249
// Posted by jackal992, modified by community. See post 'Timeline' for change history
// Retrieved 2026-03-16, License - CC BY-SA 3.0

package experimentation;

import java.awt.BorderLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;



public class GameWindow extends JFrame {
    private JPanel mapPicture = new JPanel();

    public GameWindow(){
        super("WELCOME!!!");
        setSize(768, 768);
        addComponentListener(new ResizeListener(this));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setBackground();
        setVisible(true);
    }


    private void setBackground() {
        mapPicture = new ImagePanel("C:\\Users\\priet\\OneDrive\\Escritorio\\P&L.png", this);
        add(mapPicture, BorderLayout.CENTER);
        mapPicture.setLayout(new BorderLayout());
    }


    public class ResizeListener implements ComponentListener {
        private JFrame parentFrame;
        public ResizeListener(JFrame parentFrame) {
            this.parentFrame = parentFrame;
        }
        public void componentHidden(ComponentEvent e) {}
        public void componentMoved(ComponentEvent e) {}
        public void componentShown(ComponentEvent e) {}

        public void componentResized(ComponentEvent e) {
            repaint();
        }
    }


    public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() { 
                    new GameWindow();
                }
            });
        } 
}
