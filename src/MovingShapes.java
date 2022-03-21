//MovingShapes Class imports
import java.awt.*;       // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT's event classes and listener interface
import javax.swing.*;

//MSFrame Class imports
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

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
    public static void main(String[] args) {               //main
         java.awt.EventQueue.invokeLater(new Runnable() { //making new runnable for the jframe
            @Override
            public void run() {
                new MovingShapes();
            }
        });
    }
}




class MSFrame extends JPanel {
    // square
    public int squareX = 100;
    public int squareY = 200;
    public int squareW = 20;
    public int squareH = 20;
    
    //oval
    public int OvalX = 150;
    public int OvalY = 150;
    public int OvalW = 50;
    public int OvalH = 50;
    
    //Ring
    Random rn = new Random();
    public int RingXmax = 580;
    public int RingYmax = 280;
    public int RingMin = 40;
    public int RingX = RandomEvenGenerator(RingMin,RingXmax);
    public int RingY = RandomEvenGenerator(RingMin,RingYmax);
    
    
    //DIMENSION
    private int WIDTH = 640;
    private int HEIGHT = 360;
        
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH,HEIGHT);
    }
    
    //printing components to the Java Frame or Window Panel
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //title
        g.setColor(Color.CYAN);
        g.drawString("Activity 5", 10, 20);
        
        //members
        g.drawString("Members:", 10, 45);
        g.drawString("Princess Joy Borlagdan", 10, 60);
        g.drawString("Jevah Rea Montas", 10, 75);
        g.drawString("Leomil Arvi Relorcasa", 10, 90);
        g.drawString("Mark Benedick Rantael", 10, 105);
        
        //Instructrion
        g.setColor(Color.YELLOW);
        g.drawString("Intructions:",215,30);
        g.drawString("Bring The Yellow Ball to the Red Ring using the small box!",295,30);

        //Square
        g.setColor(Color.RED);
        g.fillRect(squareX,squareY,squareW,squareH);
        g.setColor(Color.WHITE);
        g.drawRect(squareX,squareY,squareW,squareH);
        
        //Oval
        g.setColor(Color.YELLOW);
        g.fillOval(OvalX, OvalY, OvalW, OvalH);
        g.setColor(Color.WHITE);
        g.drawOval(OvalX, OvalY, OvalW, OvalH);
        
        //Ring
        g.setColor(Color.RED);
        g.drawOval(RingX, RingY, 50, 50);
       
    }
    
    //for generating Red Ring coordinates, even numbers divisible by 10 because the movement of shapes is by 10 pixels
    public int RandomEvenGenerator(int min, int max){
        int RandomInt = 0;
        while (true){
            RandomInt = rn.nextInt(max - min + 1) + min;
            if (RandomInt % 10 != 0) {
                continue;
            } else {
            break;
            }
        }
        return RandomInt;
    }
    
    //FOR CHECKING IF SHAPE IS IN THE BORDER OF THE WINDOW
    public boolean hitEdgeX(int point) {
       
        if(point >= (this.WIDTH - 20) || point <= 0) {
            return true;
        } else {
            return false;
        }
    }   
    
    public boolean hitEdgeY(int point) {
        if(point >= (this.HEIGHT - 20) || point <= 0) {
            return true;
        } else {
            return false;
        }
    }  
    
    //FOR CHECKING IF SQUARE BOX IS IN BORDER OF CIRCLE/OVAL
    public boolean checkMoveRightOvalX(int pointX, int pointY) {
        if(pointY > OvalY-20 && pointY < OvalY+50) {
            if (pointX == OvalX-10) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkMoveLeftOvalX(int pointX, int pointY) {
        if(pointY > OvalY-20 && pointY < OvalY+50) {
            if (pointX == OvalX+40) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkMoveDownOvalY(int pointX, int pointY) {
        if(pointX > OvalX-20 && pointX < OvalX+50) {
            if (pointY == OvalY-10) {
                return true;
            }
        }
        return false;
    }

    public boolean checkMoveUpOvalY(int pointX, int pointY) {
        if(pointX > OvalX-20 && pointX < OvalX+50) {
            if (pointY == OvalY+40) {
                return true;
            }
        }
        return false;
    }
}
