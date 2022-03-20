/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicshape;

import java.awt.*;       // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT's event classes and listener interface
import javax.swing.*;

/**
 *
 * @author EL
 */
public class BasicShape extends JFrame {
    
    private BSPanel bspanel_canvas;

    private int predictionpoint; 
    
    public BasicShape() {
      bspanel_canvas = new BSPanel();
      bspanel_canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
      
      Container cp = getContentPane();
      cp.setLayout(new BorderLayout());
      cp.add(bspanel_canvas, BorderLayout.CENTER);
                    
      addKeyListener(new KeyAdapter() {
         @Override
         public void keyPressed(KeyEvent evt) {
            switch(evt.getKeyCode()) {
                
               case KeyEvent.VK_LEFT:                 
                  predictionpoint = bspanel_canvas.squareX - 10;
                  
                  if(!bspanel_canvas.hitEdgeX(predictionpoint)) {
                    if (!bspanel_canvas.checkMoveLeftOvalX(predictionpoint, bspanel_canvas.squareY)) {
                        bspanel_canvas.squareX -=10;
                        repaint();
                    } else {
                        if(!bspanel_canvas.hitEdgeX(bspanel_canvas.OvalX-30)) {    //30 because 10 for the border and 20 for the square to move around the oval
                        bspanel_canvas.squareX -= 10;
                        bspanel_canvas.OvalX -= 10;
                        repaint();
                        }
                    }
                    if (bspanel_canvas.OvalX == bspanel_canvas.RingX && bspanel_canvas.OvalY == bspanel_canvas.RingY) {
                        JOptionPane.showMessageDialog(null, "You're the Best!","Activity 5 - Message",JOptionPane.PLAIN_MESSAGE);
                        bspanel_canvas.RingX = bspanel_canvas.RandomEvenGenerator(bspanel_canvas.RingMin, bspanel_canvas.RingXmax);
                        bspanel_canvas.RingY = bspanel_canvas.RandomEvenGenerator(bspanel_canvas.RingMin, bspanel_canvas.RingYmax);  
                        repaint();
                    }
                  }
                  break;
                  
               case KeyEvent.VK_RIGHT:
                  predictionpoint = bspanel_canvas.squareX + 10; 
                  
                  System.out.println(bspanel_canvas.OvalX+60);
                  if(!bspanel_canvas.hitEdgeX(predictionpoint)) {
                    if (!bspanel_canvas.checkMoveRightOvalX(predictionpoint, bspanel_canvas.squareY)) {
                        bspanel_canvas.squareX +=10;
                        repaint();
                    } else {
                        if(!bspanel_canvas.hitEdgeX(bspanel_canvas.OvalX+60)) {    //60 because 20 for border and 40 for the square to move around the oval
                        bspanel_canvas.squareX += 10;
                        bspanel_canvas.OvalX += 10;
                        repaint();
                        }
                    }
                    if (bspanel_canvas.OvalX == bspanel_canvas.RingX && bspanel_canvas.OvalY == bspanel_canvas.RingY) {
                        JOptionPane.showMessageDialog(null, "Threee Poooooints!","Activity 5 - Message",JOptionPane.PLAIN_MESSAGE);
                        bspanel_canvas.RingX = bspanel_canvas.RandomEvenGenerator(bspanel_canvas.RingMin, bspanel_canvas.RingXmax);
                        bspanel_canvas.RingY = bspanel_canvas.RandomEvenGenerator(bspanel_canvas.RingMin, bspanel_canvas.RingYmax);  
                        repaint();
                    }
                  }
                  break;
                  
               case KeyEvent.VK_UP:                  
                  predictionpoint = bspanel_canvas.squareY - 10;

                  if(!bspanel_canvas.hitEdgeY(predictionpoint)) {              
                    if (!bspanel_canvas.checkMoveUpOvalY(bspanel_canvas.squareX, predictionpoint)) {
                        bspanel_canvas.squareY -= 10;
                        repaint();
                    } else {
                        if(!bspanel_canvas.hitEdgeY(bspanel_canvas.OvalY-30)) {    //30 because 10 for the border and 20 for the square to move around the oval
                        bspanel_canvas.squareY -= 10;
                        bspanel_canvas.OvalY -= 10;
                        repaint();
                        }
                    }
                    if (bspanel_canvas.OvalX == bspanel_canvas.RingX && bspanel_canvas.OvalY == bspanel_canvas.RingY) {
                        JOptionPane.showMessageDialog(null, "Ang Galing Mo!","Activity 5 - Message",JOptionPane.PLAIN_MESSAGE);
                        bspanel_canvas.RingX = bspanel_canvas.RandomEvenGenerator(bspanel_canvas.RingMin, bspanel_canvas.RingXmax);
                        bspanel_canvas.RingY = bspanel_canvas.RandomEvenGenerator(bspanel_canvas.RingMin, bspanel_canvas.RingYmax);  
                        repaint();
                    }
                  }
                  break;
                  
               case KeyEvent.VK_DOWN:
                  predictionpoint = bspanel_canvas.squareY + 10;
                
                  if(!bspanel_canvas.hitEdgeY(predictionpoint)) {
                    if (!bspanel_canvas.checkMoveDownOvalY(bspanel_canvas.squareX, predictionpoint)) {  
                        bspanel_canvas.squareY += 10;
                        repaint();
                    } else {
                        if(!bspanel_canvas.hitEdgeY(bspanel_canvas.OvalY+60)) {    //60 because 20 for border and 40 for the square to move around the oval
                        bspanel_canvas.squareY += 10;
                        bspanel_canvas.OvalY += 10;
                        repaint();
                        }
                    }
                    if (bspanel_canvas.OvalX == bspanel_canvas.RingX && bspanel_canvas.OvalY == bspanel_canvas.RingY) {
                        JOptionPane.showMessageDialog(null, "You're Amazing","Activity 5 - Message",JOptionPane.PLAIN_MESSAGE);
                        bspanel_canvas.RingX = bspanel_canvas.RandomEvenGenerator(bspanel_canvas.RingMin, bspanel_canvas.RingXmax);
                        bspanel_canvas.RingY = bspanel_canvas.RandomEvenGenerator(bspanel_canvas.RingMin, bspanel_canvas.RingYmax);  
                        repaint();
                    }
                  }
                  break;
            }
            System.out.println("SquareX: " + Integer.toString(bspanel_canvas.squareX) + "  ||  OvalX: " + Integer.toString(bspanel_canvas.OvalX));
            System.out.println("SquareY: " + Integer.toString(bspanel_canvas.squareY) + "  ||  OvalY: " + Integer.toString(bspanel_canvas.OvalY));
            System.out.println("RingX: " + bspanel_canvas.RingX + " || Ring Y: " + bspanel_canvas.RingY);
            System.out.println("");
         }
      });
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handle the CLOSE button
      setTitle("Activity 5 - Moving Shapes");
      pack();       // pack all the components in the JFrame
      setLocationRelativeTo(null);
      bspanel_canvas.setBackground( Color.black );
      setResizable(false);
      setVisible(true); // show it
      requestFocus();
      
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BasicShape();
            }
        });
    }
}
