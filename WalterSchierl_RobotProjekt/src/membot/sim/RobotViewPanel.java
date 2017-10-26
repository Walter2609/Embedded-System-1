/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package membot.sim;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.PageAttributes;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.function.DoubleToIntFunction;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javax.swing.JPanel;

/**
 *
 * @author Walter
 */
public class RobotViewPanel extends JPanel {
    
    RobotTracker robotView;
    
    RobotViewPanel(RobotTracker robotView) {   
        this.robotView = robotView;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        //call paintComponent of superclass JPanel
        super.paintComponent(g);      
        //set background color to white
        setBackground(Color.white);      
        //downcast Graphics g to class Graphics2D
        Graphics2D g2 = (Graphics2D) g;       
        //turn on anti aliasing
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        

        Polygon p = new Polygon();
       // Circle c2 = new Circle(5, 5, 5, g);
        p.addPoint(-20, -40);
        p.addPoint(-10, -40);
        p.addPoint(-10, -50);
        p.addPoint(10, -50);
        p.addPoint(10, -40);
        
       
        
        p.addPoint(20, -40);
        p.addPoint(20, 40);  
        p.addPoint(-20, 40);
        

        g2.fillRect(20, 20, 20, 800);
        g2.fillRect(800, 20, 20, 800);
        g2.fillRect(20, 20, 800, 20);
        g2.fillRect(20, 800, 800, 20);
        

        g2.setColor(Color.DARK_GRAY);
        
      
/*
        p.addPoint(5, 0);
        p.addPoint(25, 0);
        p.addPoint(25, 5);  // erster Reifenanfang
        p.addPoint(30, 5);
        p.addPoint(30, 15);
        p.addPoint(25, 15);  // erster Reifen Ende
        
        p.addPoint(25, 30);   // zweiter Reifenanfang
        p.addPoint(30, 30);
        p.addPoint(30, 35);
        p.addPoint(25, 35);
        p.addPoint(25, 40);   // Anfang Heckteil
        
                p.addPoint(5, 40); // linke Seite Auto
        p.addPoint(5, 35);
        p.addPoint(0, 35);
        p.addPoint(0, 30);
        p.addPoint(5, 30);   // Ende zweiter Reifen
            p.addPoint(5, 10);   
        p.addPoint(0, 10);
        p.addPoint(0, 5);
        p.addPoint(5, 5);
        p.addPoint(5, 0);
        
 */       
        
        //alpha = robotView.getPhi();
        AffineTransform at = new AffineTransform();
        at.setToTranslation(robotView.getX()+400, robotView.getY()+400);
        //System.out.println("\n DifferentialDrive wurde erzeugt" + robotView.;
        at.rotate(robotView.getPhi()+Math.PI/2);                         
        //at.rotate(45);
        
        g2.fill(at.createTransformedShape(p));
        //g2.fill(p);
    }

    private int DoubleToIntFunction(double x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
