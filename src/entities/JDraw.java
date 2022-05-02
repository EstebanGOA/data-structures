package entities;

import utilities.ArrayList;

import javax.swing.*;
import java.awt.*;

public class JDraw extends JFrame {

    public JDraw() {
        super("Árbol");
        setSize(1280, 720);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void draw(Graphics g, Figura f) {
        if (f instanceof Rectangle r) {
            int width = (int) (r.getMaxX() - r.getMinX());
            int height = (int) (r.getMaxY() - r.getMinY());
            g.drawRect((int) r.getMinX(), (int) r.getMinY(), width, height);
            ArrayList<Figura> list = r.getFiguras();
            for (int i = 0; i < list.size(); i++) {
                draw(g, list.get(i));
            }
        } else if (f instanceof Point p) {
            g.drawOval((int) p.getX(), (int) p.getY(), 10, 10);
        }
    }

    public void paintComponent(Graphics g, Figura f) {
        super.paintComponents(g);
        draw(g, f);
    }

}
