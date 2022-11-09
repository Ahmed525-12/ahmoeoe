
package tmaahmedsayed20450062;

/**
 *
 * @author ahmedsayed
 */

import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
public class Q1 extends JApplet {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Q1: Image processing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JApplet applete = new Q1();
        applete.init();
        frame.getContentPane().add(applete);
        frame.pack();
        frame.setVisible(true);
    }
    public void init() {
        JPanel panel = new JAppQ1();
        getContentPane().add(panel);
    }
}
class JAppQ1 extends JPanel {
    public JAppQ1() {
        setPreferredSize(new Dimension(1400, 1200));
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        BufferedImage imageReader = null;
        try {
            imageReader = ImageIO.read(new File("noiseimg.jpg"));
        } catch (IOException e) {
        }
        g2.drawImage(imageReader, 0, 0, this);
        g2.drawString("input image", 50, 380);
///------------remove the noise-----------////
        float[] noise = {1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f,
             1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f};
        Kernel noiseKernel = new Kernel(3, 3, noise);
        ConvolveOp op1 = new ConvolveOp(noiseKernel);
        BufferedImage img2 = op1.filter(imageReader, null);
        g2.drawImage(img2, 320, 0, null);//draw smooth image
        g2.drawString("output remove noise", 350,380);


    ///-----------------inverted colors------------------------////        
        RescaleOp inverter = new RescaleOp(-1f, 255f, null);
        BufferedImage invertedColor= inverter.filter(imageReader,null);
        g2.drawImage(invertedColor, 960,0, this);    
        g2.drawString("inverted colors image", 1250, 380);        

///------------------gray scale---------------------------////
        ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
        ColorConvertOp opcolor = new ColorConvertOp(cs, null); 
        //resImage=op.filter(im, null);
        BufferedImage img1 = opcolor.filter(imageReader, null);
       g2.drawImage(img1, 640, 0, null);//draw the image with RescaleOp
       g2.drawString("gray scale image", 750, 380);        
        ///----------------  sheared to x-------------------------////
        AffineTransform af = new AffineTransform();
        af.setToShear(0.2, 0);
        
        AffineTransformOp tfop= new AffineTransformOp(af, AffineTransformOp.TYPE_BILINEAR);
        BufferedImage shearedim = tfop.filter(imageReader, null);
        g2.drawImage(shearedim, 0,400, this);


///----------------  sheared to y-------------------------////
        AffineTransform af2 = new AffineTransform();
        af2.setToShear(0, 0.2);
        
        AffineTransformOp tfop2= new AffineTransformOp(af2, AffineTransformOp.TYPE_BILINEAR);
        BufferedImage shearedim2 = tfop2.filter(imageReader, null);
        g2.drawImage(shearedim2,  960, 400, this);
    ///----------------  zoom image-------------------------////
        AffineTransform af3 = new AffineTransform();
        af3.setToScale(1.5, 0.8);
        AffineTransformOp tfop3= new AffineTransformOp(af3, AffineTransformOp.TYPE_BILINEAR);
        BufferedImage shearedim3 = tfop3.filter(imageReader, null);
        g2.drawImage(shearedim3, 320,400, this);    
        
     
       
    }

}// end of JApp1Panel class
