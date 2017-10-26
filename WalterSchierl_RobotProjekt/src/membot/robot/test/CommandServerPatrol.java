/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package membot.robot.test;

import java.util.*;
import membot.robot.ICommandServer;


/**
 *
 * @author Walter
 */
public class CommandServerPatrol implements ICommandServer {
    
    //Konstruktor
    public CommandServerPatrol() {
        System.out.println("\n CommandServerPatrol wurde erzeugt.");
    }
    
    @Override
    public String getCommand() {
        long millis = System.currentTimeMillis();
        long k = millis/1000; // Sekunden mit Komma und Nachkommastellen
        int seconds = (int)k; // Casting - hier werden die Nachkommastellen weggelassen
        
        if ((seconds) % 2 == 0) {
        System.out.println("Vorwärts"); 
           return ("v=" +100); 
        } else {  
        System.out.println("Rückwärts "); 
           return("v=" +(-100));
        }
    }     
}
