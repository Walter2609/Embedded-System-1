package membot.robot.test;

import membot.robot.DifferentialDrive;
import membot.robot.IMotor;
import membot.robot.Motor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Walter
 */
public class DifferentialDriveTest {
    public static void main(String[] args) {
        
    IMotor leftMotor = new Motor("Lena \n");
    IMotor rightMotor = new Motor("Richard \n");
    
    DifferentialDrive diffDrive = new DifferentialDrive(leftMotor, rightMotor,20);
    diffDrive.move(100, 2);
    
    }
}
