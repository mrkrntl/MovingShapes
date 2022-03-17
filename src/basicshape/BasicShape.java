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
                    //bspanel_canvas.squareX +=10;
                    if (!bspanel_canvas.checkMoveLeftOvalX(predictionpoint, bspanel_canvas.squareY)) {
                        bspanel_canvas.squareX -=10;
                        repaint();
                    }
                    //repaint();
                  }
                  

                  
                  break;
               case KeyEvent.VK_RIGHT:
                   
                  predictionpoint = bspanel_canvas.squareX + 10; 
                  
                  if(!bspanel_canvas.hitEdgeX(predictionpoint)) {
                    //bspanel_canvas.squareX +=10;
                    if (!bspanel_canvas.checkMoveRightOvalX(predictionpoint, bspanel_canvas.squareY)) {
                        bspanel_canvas.squareX +=10;
                        repaint();
                    }
                    System.out.println("RIGHT");
                    //repaint();
                  }
                  
                  
                  
                  break;
               case KeyEvent.VK_UP:
                   
                  predictionpoint = bspanel_canvas.squareY - 10;
                  
                  if(!bspanel_canvas.hitEdgeY(predictionpoint)) {
                    //bspanel_canvas.squareY -=10;
                    if (!bspanel_canvas.checkMoveUpOvalY(bspanel_canvas.squareX, predictionpoint)) {
                        bspanel_canvas.squareY -= 10;
                        repaint();
                    }
                    //repaint();
                  }
                  break;
               case KeyEvent.VK_DOWN:

                  predictionpoint = bspanel_canvas.squareY + 10;
                  
                  if(!bspanel_canvas.hitEdgeY(predictionpoint)) {
                    //bspanel_canvas.squareY +=10;
                    if (!bspanel_canvas.checkMoveDownOvalY(bspanel_canvas.squareX, predictionpoint)) {
                        bspanel_canvas.squareY +=10;
                        repaint();
                    }
                    System.out.println("UP");
                    //repaint();
                  }
                  break;
            }
            System.out.println("SquareX: " + Integer.toString(bspanel_canvas.squareX) + "  ||  OvalX: " + Integer.toString(bspanel_canvas.OvalX));
            System.out.println("SquareY: " + Integer.toString(bspanel_canvas.squareY) + "  ||  OvalY: " + Integer.toString(bspanel_canvas.OvalY));
         }
      });
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handle the CLOSE button
      setTitle("Basic Shape");
      pack();       // pack all the components in the JFrame
      setLocationRelativeTo(null);
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
