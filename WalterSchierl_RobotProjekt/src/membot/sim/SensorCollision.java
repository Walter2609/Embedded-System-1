/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package membot.sim;

import membot.robot.DifferentialDrive;
import membot.robot.ISensor;

/**
 *
 * @author Walter
 */
public class SensorCollision implements ISensor { 
    
    private RobotTracker robotTracker;
    int x=0;
    int y=0;
    
    public SensorCollision (RobotTracker robotTracker) {
        this.robotTracker = robotTracker;
        this.x = (int)robotTracker.getX();
        this.y = (int)robotTracker.getY();
    }
    
    @Override
    public Boolean getCollision () {
        this.x = (int)robotTracker.getX();
        this.y = (int)robotTracker.getY();
        //System.out.println("\n\n x=" +x);
        //System.out.println("\n y=" +y);
        if ( x < 340 && x > -315) {
            if ( y < 340 && y > -310) {
                return false;
            } else { 
            return true;
            } 
        }
        return true;
    } 
}
