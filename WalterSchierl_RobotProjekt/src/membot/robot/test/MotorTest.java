package membot.robot.test;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import membot.robot.IMotor;
import membot.robot.Motor;
/**
 *
 * @author Walter
 */
public class MotorTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IMotor leftMotor = new Motor("leftMotor");
        IMotor rightMotor = new Motor("rightMotor");
        
        leftMotor.setSpeed(10);
        rightMotor.setSpeed(5);
    } 
}
