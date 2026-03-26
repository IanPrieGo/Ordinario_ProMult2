package experimentation;

import java.awt.*;

import javax.swing.*;

public class PanelProporcional extends JPanel{
	
	private final double aspectRatio;
	
	public PanelProporcional(double aspectRatio) {
		this.aspectRatio = aspectRatio;
	}
	
    @Override
    public Dimension getPreferredSize() {
        Container parent = getParent();
        if (parent == null) return super.getPreferredSize();

        int parentWidth  = parent.getWidth();
        int parentHeight = parent.getHeight();

        // Ajusta al padre sin deformar
        int width  = parentWidth;
        int height = (int)(parentWidth / aspectRatio);

        if (height > parentHeight) {
            height = parentHeight;
            width  = (int)(parentHeight * aspectRatio);
        }

        return new Dimension(width, height);
    }
}
