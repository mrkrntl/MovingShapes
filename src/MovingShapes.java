import java.awt.*;       // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT's event classes and listener interface
import javax.swing.*;

public class MovingShapes extends JFrame {
    
    private MSFrame msframe;

    private int predictionpoint; //container for next coordinate to check if applicable to paint or draw
    
    public MovingShapes() {
      msframe = new MSFrame();
      msframe.setPreferredSize(new Dimension(WIDTH, HEIGHT));
      
      Container cp = getContentPane();
      cp.setLayout(new BorderLayout());
      cp.add(msframe, BorderLayout.CENTER);
                    
      addKeyListener(new KeyAdapter() {
         @Override
         public void keyPressed(KeyEvent evt) {
             
            switch(evt.getKeyCode()) {
                
               case KeyEvent.VK_LEFT:
                    System.out.println("LEFT"); //DEBUGGING
                    predictionpoint = msframe.squareX - 10; //set prediction point for next paint coordinate
                  
                    if(!msframe.hitEdgeX(predictionpoint)) { //IF for checking small square box in border
                        if (!msframe.checkMoveLeftOvalX(predictionpoint, msframe.squareY)) { //IF for checking if small square box is in border of oval/circle
                            msframe.squareX -=10; //if not in border, apply prediction point to reality
                            repaint();              //then repaint
                        } else {
                            //IF for checking oval/circle in border when pushed by small squarebox THEN proceed to repaint if not in border
                            if(!msframe.hitEdgeX(msframe.OvalX-30)) {    //30 because 10 for the border and 20 for the square to move around the oval
                            msframe.squareX -= 10;
                            msframe.OvalX -= 10;
                            repaint();
                            }
                        }
                        if (msframe.OvalX == msframe.RingX && msframe.OvalY == msframe.RingY) { //IF for checking if Oval/Circle is inside the Red Ring
                            JOptionPane.showMessageDialog(null, "You're the Best!","Activity 5 - Message",JOptionPane.PLAIN_MESSAGE);
                            //Generating New Coordinates for the Red Ring
                            msframe.RingX = msframe.RandomEvenGenerator(msframe.RingMin, msframe.RingXmax); 
                            msframe.RingY = msframe.RandomEvenGenerator(msframe.RingMin, msframe.RingYmax);  
                            repaint();
                        }
                    } 
                  break;
                  
               case KeyEvent.VK_RIGHT:
                    System.out.println("RIGHT"); //DEBUGGING
                    predictionpoint = msframe.squareX + 10; 
                  
                    if(!msframe.hitEdgeX(predictionpoint)) {
                        if (!msframe.checkMoveRightOvalX(predictionpoint, msframe.squareY)) {
                            msframe.squareX +=10;
                            repaint();
                        } else {
                            if(!msframe.hitEdgeX(msframe.OvalX+60)) {    //60 because 20 for border and 40 for the square to move around the oval
                            msframe.squareX += 10;
                            msframe.OvalX += 10;
                            repaint();
                            }
                        }
                        if (msframe.OvalX == msframe.RingX && msframe.OvalY == msframe.RingY) {
                            JOptionPane.showMessageDialog(null, "Threee Poooooints!","Activity 5 - Message",JOptionPane.PLAIN_MESSAGE);
                            msframe.RingX = msframe.RandomEvenGenerator(msframe.RingMin, msframe.RingXmax);
                            msframe.RingY = msframe.RandomEvenGenerator(msframe.RingMin, msframe.RingYmax);  
                            repaint();
                        }
                    }
                    break;
                  
               case KeyEvent.VK_UP:      
                    System.out.println("UP"); //DEBUGGING
                    predictionpoint = msframe.squareY - 10;

                    if(!msframe.hitEdgeY(predictionpoint)) {              
                        if (!msframe.checkMoveUpOvalY(msframe.squareX, predictionpoint)) {
                            msframe.squareY -= 10;
                            repaint();
                        } else {
                            if(!msframe.hitEdgeY(msframe.OvalY-30)) {    //30 because 10 for the border and 20 for the square to move around the oval
                            msframe.squareY -= 10;
                            msframe.OvalY -= 10;
                            repaint();
                            }
                        }
                        if (msframe.OvalX == msframe.RingX && msframe.OvalY == msframe.RingY) {
                            JOptionPane.showMessageDialog(null, "Ang Galing Mo!","Activity 5 - Message",JOptionPane.PLAIN_MESSAGE);
                            msframe.RingX = msframe.RandomEvenGenerator(msframe.RingMin, msframe.RingXmax);
                            msframe.RingY = msframe.RandomEvenGenerator(msframe.RingMin, msframe.RingYmax);  
                            repaint();
                        }
                    }
                    break;
                  
               case KeyEvent.VK_DOWN:
                    System.out.println("DOWN"); //DEBUGGING
                    predictionpoint = msframe.squareY + 10;
                
                    if(!msframe.hitEdgeY(predictionpoint)) {
                        if (!msframe.checkMoveDownOvalY(msframe.squareX, predictionpoint)) {  
                            msframe.squareY += 10;
                            repaint();
                        } else {
                            if(!msframe.hitEdgeY(msframe.OvalY+60)) {    //60 because 20 for border and 40 for the square to move around the oval
                            msframe.squareY += 10;
                            msframe.OvalY += 10;
                            repaint();
                            }
                        }
                        if (msframe.OvalX == msframe.RingX && msframe.OvalY == msframe.RingY) {
                            JOptionPane.showMessageDialog(null, "You're Amazing","Activity 5 - Message",JOptionPane.PLAIN_MESSAGE);
                            msframe.RingX = msframe.RandomEvenGenerator(msframe.RingMin, msframe.RingXmax);
                            msframe.RingY = msframe.RandomEvenGenerator(msframe.RingMin, msframe.RingYmax);  
                            repaint();
                        }
                    }
                    break;
            }
            //For Debugging/Testing
            System.out.println("SquareX: " + Integer.toString(msframe.squareX) + "  ||  OvalX: " + Integer.toString(msframe.OvalX));
            System.out.println("SquareY: " + Integer.toString(msframe.squareY) + "  ||  OvalY: " + Integer.toString(msframe.OvalY));
            System.out.println("RingX: " + msframe.RingX + " || Ring Y: " + msframe.RingY);
            System.out.println("");
         }
      });
      
      //Setting Up Java JFrame or the Window Panel
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handle the CLOSE button
      setTitle("Activity 5 - Moving Shapes");
      pack();       // pack all the components in the JFrame
      setLocationRelativeTo(null);
      msframe.setBackground( Color.black );
      setResizable(false);
      setVisible(true); // show it
      requestFocus();
      
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         java.awt.EventQueue.invokeLater(new Runnable() { //making new runnable for the jframe
            @Override
            public void run() {
                new MovingShapes();
            }
        });
    }
}
