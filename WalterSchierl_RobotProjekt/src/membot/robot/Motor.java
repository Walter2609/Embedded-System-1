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
public class Motor implements IMotor {
    private double v; //Einheit in mm/sec
    private String name; //Name Motor e.g. "left motor"
    
    //Konstruktor der Klasse Motor
    public Motor(String nameMotor) {
        this.name = nameMotor;
        //System.out.printf("\n Motor wurde erzeug: "); 
        //System.out.printf(name);
    }
    
    @Override
    public void setSpeed(double v) { 
        //System.out.printf("\n setSpeed: Actual Speed of ");
        //System.out.printf(name);
        //System.out.printf(" = %f\n", v);
        this.v = v;
    }
    
    @Override
    public double getSpeed() {
        //System.out.printf("\n getSpeed: Actual Speed of ", name);
        return v;
    }
    
}
