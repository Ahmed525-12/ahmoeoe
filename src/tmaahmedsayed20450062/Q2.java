package tmaahmedsayed20450062;


import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;

public class Q2 extends JApplet {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JApplet applet = new Q2();
        applet.init();
        frame.setTitle("Q2: Draw Car");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(applet);
        frame.pack();
        frame.setVisible(true);
    }// end of main

    public void init() {
        JPanel panel = new PanelQ2();
        getContentPane().add(panel);
    } // end of init  
}//end of applet class

class PanelQ2 extends JPanel {

    public PanelQ2() {
        setPreferredSize(new Dimension(700, 700));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        GeneralPath safety = new GeneralPath();

        safety.moveTo(26, 193);
        safety.lineTo(427, 193);
        safety.quadTo(447, 207, 427, 222);
        safety.lineTo(26, 222);
        safety.quadTo(12, 206, 26, 193);
        safety.closePath();

        GeneralPath door = new GeneralPath();
        door.moveTo(177, 20);
        door.lineTo(177, 212);
        door.lineTo(295, 212);
        door.quadTo(295, 190, 337, 170);
        door.lineTo(337, 108);

        GeneralPath window = new GeneralPath();
        window.moveTo(81, 109);
        window.quadTo(105, 45, 177, 20);
        window.quadTo(300, 0, 333, 109);
        window.lineTo(81, 109);
        window.closePath();

        GeneralPath mirror1 = new GeneralPath();
        mirror1.moveTo(312, 88);
        mirror1.curveTo(341, 90, 341, 115, 312, 118);
        mirror1.lineTo(312, 88);
        mirror1.closePath();

        GeneralPath mirror2 = new GeneralPath();
        mirror2.moveTo(330, 97);
        mirror2.curveTo(348, 95, 348, 115, 330, 112);
        mirror2.lineTo(330, 100);
        mirror2.closePath();

        GeneralPath body = new GeneralPath();
        body.moveTo(37, 193);
        body.curveTo(100, -70, 320, -10, 347, 104);
        body.quadTo(388, 96, 411, 133);
        body.lineTo(425, 191);
        body.lineTo(372, 192);
        body.lineTo(298, 221);
        body.lineTo(157, 222);
        body.lineTo(79, 194);
        body.closePath();
        Ellipse2D tire1 = new Ellipse2D.Double(80, 178, 80, 80);
        Ellipse2D tire2 = new Ellipse2D.Double(305, 178, 80, 80);
        Ellipse2D tire3 = new Ellipse2D.Double(100, 198, 40, 40);
        Ellipse2D tire4 = new Ellipse2D.Double(325, 198, 40, 40);
        Ellipse2D frontled = new Ellipse2D.Double(362, 140, 20, 40);
        Ellipse2D backled = new Ellipse2D.Double(82, 144, 15, 40);

        Rectangle2D lock = new Rectangle2D.Double(190, 118, 30, 10);

        g2.setColor(new Color(213, 222, 227)); //gray
        g2.fill(safety);
        g2.setColor(Color.black);
        g2.draw(safety);

        g2.setColor(new Color(113, 194, 220)); // light blue
        g2.fill(body);
        g2.setColor(Color.black);
        g2.draw(body);

        g2.setColor(new Color(237, 251, 254)); //foam
        g2.fill(window);
        g2.setColor(Color.black);
        g2.draw(window);

        g2.setColor(Color.black);
        g2.draw(door);

        g2.setColor(new Color(113, 194, 220)); // light blue
        g2.fill(mirror2);
        g2.setColor(Color.black);
        g2.draw(mirror2);

        g2.setColor(new Color(113, 194, 220)); // light blue
        g2.fill(mirror1);
        g2.setColor(Color.black);
        g2.draw(mirror1);

        g.setColor(new Color(66, 67, 69));  // dark gray
        g2.fill(tire1);
        g2.fill(tire2);
        g.setColor(new Color(192, 197, 201)); // silver

        g2.fill(tire3);
        g2.fill(tire4);
        g2.setColor(Color.black);

        g2.draw(lock);

        AffineTransform tx = new AffineTransform();
        tx.setToShear(0.2, 0);
        g2.transform(tx);
        g.setColor(new Color(255, 251, 224)); // scotch mist
        g2.fill(frontled);
        g2.setColor(Color.black);
        g2.draw(frontled);

        AffineTransform tx2 = new AffineTransform();
        tx2.setToShear(-0.4, 0);
        g2.transform(tx2);
        g.setColor(new Color(231, 108, 103)); // scotch mist
        g2.fill(backled);
        g2.setColor(Color.black);
        g2.draw(backled);

    }// end of panel class
}
    

