// Source - https://stackoverflow.com/a/17865740
// Posted by Daniel Kaplan
// Retrieved 2026-03-14, License - CC BY-SA 3.0

package com.sandbox;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SwingSandbox {

    public static void main(String[] args) throws IOException {
        JFrame frame = buildFrame();

        final BufferedImage image = ImageIO.read(new File("C:\\Users\\priet\\OneDrive\\Escritorio\\absolute-programmingcinema.png"));

        JPanel pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
                
            }
        };


        frame.add(pane);
        System.out.println(image);
    }


    private static JFrame buildFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);
        return frame;
    }


}
