package tmaahmedsayed20450062;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
public class Q3 extends JApplet {
   public static void main(String[] args) {
        JApplet applet = new Q3();
        JFrame frame = new JFrame();
        frame.getContentPane().add(applet);
        applet.init();
        frame.setTitle("Q3: composition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }// end of main method

    public void init() {
        JPanel panel = new Q3Panel();
        getContentPane().add(panel);
    }

}// end of class

class Q3Panel extends JPanel {

    public Q3Panel() {
        setPreferredSize(new Dimension(640, 480));
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.translate(200, 200);
       
        g2.setColor(Color.blue);
        int n = 101000;int r = 80; int x1 = 0, y1 = 0, x2, y2;
        GeneralPath p = new GeneralPath();
        p.moveTo(x1, y1);
        for (int i = 0; i < n; i++) {
            double t = i * 12 * Math.PI / n;
            x2 = (int) (r * Math.sin(t) * (Math.exp(Math.cos(t)) - 2 * Math.cos(4 * t) - Math.pow(Math.sin(t / 12), 5)));
            y2 = (int) (r * Math.cos(t) * (Math.exp(Math.cos(t)) - 2 * Math.cos(4 * t) - Math.pow(Math.sin(t / 12), 5)));
            p.lineTo(x2,y2);
        }
                g2.draw(p);

         g2.setClip(p);
                 g2.translate(-200, -200);

          for (int i = 0; i < 8000; i++) {
            Shape shape = new Ellipse2D.Double(Math.random() * 700,
                    Math.random() * 500, 2, 2);
            g2.draw(shape);
        } 
    }
}
