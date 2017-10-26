/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package membot.robot.test;

import membot.robot.ICommandServer;

/**
 *
 * @author Walter
 */
public class CommandServerString implements ICommandServer {
    
    private String commandString = "";  // selbst hinzugefügt

    
    public void setCommandString(String commandString)  {
        this.commandString = commandString;
        System.out.println("\n CommandString wurde gesetzt! " +commandString);
    }
    
    @Override
    public String getCommand() {
        return commandString;
    }    
    
}
