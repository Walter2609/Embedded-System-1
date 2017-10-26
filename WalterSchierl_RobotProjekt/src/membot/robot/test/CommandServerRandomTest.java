/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package membot.robot.test;


//import membot.robot.CommandServerRandom;
import membot.robot.ICommandServer;

/**
 *
 * @author Walter
 */
public class CommandServerRandomTest {

    public static void main(String args[]) {
        
        ICommandServer cs = new CommandServerRandom();
        System.out.println(cs.getCommand());
        
    }
}
