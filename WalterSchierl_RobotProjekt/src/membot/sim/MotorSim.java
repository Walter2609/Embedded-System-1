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
public class MotorSim implements IMotor {
    private double v; //Einheit in mm/sec
   
    //Konstruktor der Klasse MotorSim
    public MotorSim(double v) {
        this.v = v;
        System.out.printf("\n MotorSim wurde erzeug: "); 
    }
    
    @Override
    public void setSpeed(double v) { 
        System.out.printf("\n setSpeed: Actual Speed of ");
        System.out.printf(" = %f\n", v);
        this.v = v;
    }
    
    @Override
    public double getSpeed() {
        System.out.printf("\n getSpeed:");
        return v;
    }  
}
