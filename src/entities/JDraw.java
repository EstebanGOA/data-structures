package entities;

import utilities.ArrayList;

import javax.swing.*;
import java.awt.*;

public class JDraw extends JPanel {

    private Figura f;

    public JDraw(Figura f) {
        this.f = f;
        setVisible(true);
        setAutoscrolls(true);
    }

    public void draw(Graphics g, Figura f) {

        if (f instanceof Rectangle r) {
            int width = (int) (r.getMaxX() - r.getMinX());
            int height = (int) (r.getMaxY() - r.getMinY());
            g.drawRect((int) r.getMinX(), (int) r.getMinY(), width + 10, height + 10);
            ArrayList<Figura> list = r.getFiguras();
            for (int i = 0; i < list.size(); i++) {
                draw(g, list.get(i));
            }
        } else if (f instanceof Point p) {
            g.drawOval((int) p.getMaxX(), (int) p.getMaxY(), 10, 10);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponents(g);
        g2.setColor(Color.RED);
        draw(g2, f);
    }

}
