/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package membot.sim;

import membot.robot.*;

/**
 *
 * @author Walter
 */
public class RobotTracker {
    private double x = 0;
    private double y = 0;
    private double phi = 0;
    private IMotor leftMotor;
    private IMotor rightMotor;
    private double axisWidth;

    // Konstruktor Klasse RobotTracker
    public RobotTracker(IMotor left, IMotor right, double axisWidth) {
        this.leftMotor = left;
        this.rightMotor = right;
        this.axisWidth = axisWidth;
        
        System.out.println("\n RobotTracker wurde erzeugt");
    }

    public void update(double dT) { 
        double v_l = leftMotor.getSpeed(); // Speed of the left Motor
        double v_r = rightMotor.getSpeed(); // Speed of the right Motor
        double v_m = (v_l + v_r)/2; // Mittlere Geschwindigkeit
        double deltaPhi = (v_l -v_r)/axisWidth; 
        
        this.x = x + v_m*dT*Math.cos(phi + deltaPhi*dT/2);
        //System.out.println("\n x=" +x);
        this.y = y + v_m*dT*Math.sin(phi + deltaPhi*dT/2);
        //System.out.println("\n y=" +y);
        this.phi = phi + deltaPhi*dT;
    }
    
    public double getX() {
        //System.out.println("x=" +x);
        return x;
    }
    
    public double getY() {
        //System.out.println("y=" +y);
        return y;
    }
    
    public double getPhi() {
        //System.out.println("phi=" +phi);
        return phi;
    }
    
    public void putRobotBackHome() {
        x=0;
        y=0;
        phi=0;
    }

}
