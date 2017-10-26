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
public class Robot {
    protected double v;
    protected double w;
    protected DifferentialDrive drive;
    protected ICommandServer cs;
    protected ISensor colliSensor;
    
    //Konstruktor
    public Robot(ICommandServer cs, DifferentialDrive drive) {
        this.cs = cs;
        this.drive = drive;
        System.out.println("\nRobot wurde erzeug");
    }
    
   public Robot(ICommandServer cs, DifferentialDrive drive, ISensor collisionSensor) {
        this.cs = cs;
        this.drive = drive;
        this.colliSensor = collisionSensor;
        System.out.println("\nRobot wurde mit Kollisions-Sensor erzeug");
    }
   
    public void run() {
        parseCommand(cs.getCommand());
        if (colliSensor.getCollision()) {
            drive.move(0,0);
        } else {
           drive.move(v/10, w/1000); 
        }
    }
    
    public void parseCommand(String command) {
        String firstCommand; // Nimmt 1. Eintrag, also v oder w und schreibt sie auf s1
        String secondCommand;   // Nimmt Eintrag ab dem = und schreib somit den Wert auf s2
        
        if(!command.isEmpty()) {
            firstCommand = command.substring(0, 1);
            try {           
                secondCommand = command.substring(2);
                switch (firstCommand) {
                    case "v":
                        this.v = Double.parseDouble(secondCommand);
                        break;
                    case "w":
                        this.w = Double.parseDouble(secondCommand);
                        break;
                    case "c":
                        this.v = 0;
                        this.w = 0;
                        break;
                    default:
                        break;
                }    
            } catch (Exception e) {
                //System.out.println("Command Fehler: " + e);
            }     
        }
        //System.out.println("Der Command ist leer: " + command);
    }
    
    
     public double getLinearVelocity() {
        return v;  
    }
    
    public double getAngularVelocity() {
        return w; 
    }
    
}
