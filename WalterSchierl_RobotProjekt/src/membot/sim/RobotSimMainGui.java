/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package membot.sim;

import javax.swing.SwingUtilities;
import membot.robot.*;
import membot.robot.test.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import membot.robot.ICommandServer;

/**
 *
 * @author Walter
 */
public class RobotSimMainGui {
    private IMotor left = new Motor("LEFT");
    private IMotor right = new Motor("RIGHT");
    private DifferentialDrive drive = new DifferentialDrive(left, right, 20);
    //private ICommandServer cs = new CommandServerRandom();
    //private ICommandServer cs = new CommandServerPatrol(); 
    private CommandServerString cs = new CommandServerString();    
    private Robot robot;
    private RobotTracker robotTracker;
    private RobotGUI robotGUI;
    private Timer robotTimer;
    private Timer visuTimer;
    private ISensor sensorCollision;
    
    public RobotSimMainGui () {
        this.robotTracker = new RobotTracker(left, right, 20);
        this.robotGUI = new RobotGUI(robotTracker,cs);
        this.sensorCollision = new SensorCollision(robotTracker);
        this.robot = new Robot(cs, drive, sensorCollision);
    }
    
    private void startSimulation() {      
        robotGUI.showFrame();
        
        //add action listeners
        ActionListener visuTimerListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                robotTracker.update(20);             //!!!!! dT sollte noch eingefügt werden
                robotGUI.repaint();
                //System.out.println("\n VisuTimer");              
            }
        }; 
        
        ActionListener robotTimerListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                robot.run();
                //System.out.println("\n robotTimer");
            }
        };
                  
        //create visuTimer (20ms)
        visuTimer = new Timer(20,visuTimerListener); 
        //create robotTimer (15ms)
        robotTimer = new Timer(15,robotTimerListener); 
        
        System.out.println("\n nun gehts los mit .start!");
        //start visuTimer 
        visuTimer.start();
        //start robotTimer
        robotTimer.start();     
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() { // Runable ist ein Objekt
            @Override
            public void run() {
                RobotSimMainGui robotSimGui = new RobotSimMainGui();
                robotSimGui.startSimulation();
            }
        });
    }
   
}
