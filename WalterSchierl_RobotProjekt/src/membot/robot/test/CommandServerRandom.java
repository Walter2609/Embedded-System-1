/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package membot.robot.test;

import java.util.Random;
import membot.robot.ICommandServer;
/**
 *
 * @author Walter
 */
public class CommandServerRandom implements ICommandServer {
    
    //Konstruktor
    public CommandServerRandom() {
    }
    
    @Override
    public String getCommand() {
        Random random = new Random(); 
        double d = random.nextDouble()*100;
        System.out.println("der Randomwert ist nun = " + d);
        return ("v=" +d);
    }  
}
