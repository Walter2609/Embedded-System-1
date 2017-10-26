/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package membot.sim;

import membot.robot.*;
import membot.robot.test.*;

/**
 *
 * @author Walter
 */
public class RobotSimMainConsole {
 
    private IMotor left = new Motor("LEFT");
    private IMotor right = new Motor("RIGHT");
    private DifferentialDrive drive = new DifferentialDrive(left, right, 20);
    private ICommandServer csr = new CommandServerRandom();
    private ICommandServer csp = new CommandServerPatrol();
    private Robot robot = new Robot(csp, drive); //nun mit CS-Patrol
    private RobotTracker robotTracker = new RobotTracker(left, right, 20);
      
    private void startSimulation() {
        long dT = 0;
        while (true) {
            robot.run();
            robotTracker.update(dT);
            robotTracker.getPhi();
            robotTracker.getX();
            robotTracker.getY();
            dT = (System.currentTimeMillis() - dT)/1000; //Zeitdifferenz im Aufruf in Sek.
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                System.out.println("sleep interrupted");
            }
        }
    }

    public static void main(String args[]) {
        RobotSimMainConsole robotSim = new RobotSimMainConsole();
        robotSim.startSimulation();
    }

}
