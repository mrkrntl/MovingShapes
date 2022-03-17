/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicshape;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author EL
 */
class BSPanel extends JPanel {
    
    // square
    public int squareX = 50;
    public int squareY = 50;
    public int squareW = 20;
    public int squareH = 20;
    
    //oval
    public int OvalX = 100;
    public int OvalY = 100;
    public int OvalW = 50;
    public int OvalH = 50;
    
    private int WIDTH = 640;
    private int HEIGHT = 360;
    
    public BSPanel() {
    }
        
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH,HEIGHT);
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //background
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
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
    }
    
    public boolean hitEdgeX(int point) {
        System.out.println(this.WIDTH);
        System.out.println(point);
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
    
    public boolean checkMoveRightOvalX(int pointX, int pointY) {
        if(pointY > 80 && pointY < 150) {
            if (pointX == 90) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkMoveLeftOvalX(int pointX, int pointY) {
        if(pointY > 80 && pointY < 150) {
            if (pointX == 140) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkMoveDownOvalY(int pointX, int pointY) {
        if(pointX > 80 && pointX < 150) {
            if (pointY == 90) {
                return true;
            }
        }
        return false;
    }

    public boolean checkMoveUpOvalY(int pointX, int pointY) {
        if(pointX > 80 && pointX < 150) {
            if (pointY == 140) {
                return true;
            }
        }
        return false;
    }
    
    
}
