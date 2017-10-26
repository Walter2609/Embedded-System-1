/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package membot.robot.test;

import membot.robot.DifferentialDrive;
import membot.robot.ICommandServer;
import membot.robot.IMotor;
import membot.robot.Motor;
import membot.robot.Robot;

/**
 *
 * @author Walter
 */
public class RobotTest {

    private IMotor left = new Motor("LEFT");
    private IMotor right = new Motor("RIGHT");
    private DifferentialDrive drive = new DifferentialDrive(left, right, 20);
    private ICommandServer csr = new CommandServerRandom();
    private ICommandServer csp = new CommandServerPatrol();
    private Robot robot = new Robot(csp, drive); //nun mit CS-Patrol

    private void startApp() {
        while (true) {
            robot.run();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println("sleep interrupted");
            }
        }
    }

    public static void main(String args[]) {
        RobotTest robotTest = new RobotTest();
        robotTest.startApp();  
    }   
}
