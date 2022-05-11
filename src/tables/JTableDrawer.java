package tables;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class JTableDrawer extends JPanel {

    private final int WIDTH = 1280;
    private final int HEIGHT = 720;

    private int[] values = new int[7];
    private final String[] days = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    public JTableDrawer(int[] values)
    {
        this.values = values;
        this.setSize(WIDTH, HEIGHT);
        this.setBorder( new EmptyBorder(10, 10, 10, 10) );
        this.setVisible(true);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        final int margin = 30;

        int maxHeight = 0;
        for (int i = 0; i < 7; i++) {
            if (maxHeight < values[i]) {
                maxHeight = values[i];
            }
        }

        int x = 15;
        int width = (WIDTH / values.length) - 5;


        for (int i = 0; i < values.length; i++) {

            g.setColor(new Color((int)(Math.random() * 0x1000000)));
            int height = (int) ( (HEIGHT-100) * ((double) values[i] / maxHeight));

            g.fillRect(x, HEIGHT - (height+margin), (width-margin), height);
            g.setColor(Color.black);
            g.drawRect(x, HEIGHT - (height+margin), (width-margin), height);


            g.drawString(days[i] + ": " + values[i], x + (width/4), HEIGHT - (height + 40) );

            x += width + (margin / values.length);

        }

    }

}