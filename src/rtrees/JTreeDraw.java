package rtrees;

import utilities.ArrayList;

import javax.swing.*;
import java.awt.*;

public class JTreeDraw extends JPanel {

    private Figura f;

    public JTreeDraw(Figura f) {
        this.f = f;
        setSize(1280, 720);
        setVisible(true);
    }

    public void draw(Graphics g, Figura f, double maxX, double maxY) {
        g.setColor(Color.BLACK);
        int normalizedX = (int) ((f.getMinX() / maxX) * 1280);
        int normalizedY = (int) ((f.getMinY() / maxY) * 720);
        if (f instanceof Rectangle r) {
            int width = (int) (((r.getMaxX() - r.getMinX()) / maxX) * 1280);
            int height = (int) (((r.getMaxY() - r.getMinY()) / maxY) * 720);
            g.drawRect(normalizedX, normalizedY, width + 10, height + 10);
            ArrayList<Figura> list = r.getFiguras();
            for (int i = 0; i < list.size(); i++) {
                draw(g, list.get(i), maxX, maxY);
            }
        } else if (f instanceof Point p) {
            g.drawOval(normalizedX, normalizedY, 10, 10);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.setColor(Color.RED);
        draw(g, f, f.getMaxX(), f.getMaxY());
    }

}
