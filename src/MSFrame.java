import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

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
