package tmaahmedsayed20450062;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Q4 extends JPanel implements ActionListener {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Q4: Circle draw");
                Q4 co = new Q4();
                frame.add(co);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 800);
                frame.setVisible(true);
            }
        });
    }
    private double r1 = 150;
    private int n = 0;
    Timer tm = new Timer(50, this);
    boolean grow = true;
    public Q4() {
        tm.start();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.translate(300,250);

        BufferedImage im = null;
        try {
            im = ImageIO.read(new File("tree.jpg"));
        } catch (IOException e) {
        }
        int x1 = (int) r1;int y1 = 0;
        int x0 =(int)  r1;int y0 = 0;
        int x2; int y2;
        for (int i = 0; i < n; i++) {
            double t = i / (Math.PI * 2);
            x2 = (int) ((r1) * Math.cos(t));
            y2 = (int) ((r1) * Math.sin(t));
            g2.drawLine(x1, y1, x2, y2);
            x1 = x2; y1 = y2;
        }
        g2.drawLine(x0, y0, x1, y1);
        g2.drawImage(im, x1, y1, this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
       move();
        repaint();
    }

    public void move() {
        if (n <= 40) {
            n += 1;
        } else {
            n = 0;
        }
    }

   
}
