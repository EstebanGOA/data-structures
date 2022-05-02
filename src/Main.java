import entities.JDraw;
import entities.Menu;
import entities.Point;
import entities.Rectangle;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        JDraw window = new JDraw();
        Rectangle r = new Rectangle(200, 200, 150, 150);
        Rectangle r2 = new Rectangle(500,500, 200, 200);
        r.addFigura(r2);
        Point p = new Point(200, 200, 10, "Blue");
        r2.addFigura(p);
        window.paintComponent(window.getGraphics(), r);
        menu.run();
    }
}