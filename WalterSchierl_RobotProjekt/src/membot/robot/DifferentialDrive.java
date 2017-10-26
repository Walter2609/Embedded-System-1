/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package membot.robot;

/**
 *
 * @author Walter
 */
public class DifferentialDrive {
    private double width;
    private IMotor leftMotor;
    private IMotor rightMotor;
    
    // Konstruktor Klasse DifferentialDrive
    public DifferentialDrive(IMotor left, IMotor right, double axisWidth) {
        this.width = axisWidth; //Achsweite bzw. Abstand zwischen den Radmotoren
        this.leftMotor = left;
        this.rightMotor = right;
        System.out.println("\n DifferentialDrive wurde erzeugt");
    }
    
    public void move(double v, double w) { //w=Winkelgeschwindigkeit
        leftMotor.setSpeed(v+w*width/2);
        rightMotor.setSpeed(v-w*width/2);
        //System.out.println("\n v= " + v);
        //System.out.println("\n w= " + w);
    }
}
