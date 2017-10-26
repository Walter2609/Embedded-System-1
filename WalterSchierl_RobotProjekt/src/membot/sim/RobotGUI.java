/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package membot.sim;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import membot.robot.ICommandServer;
import membot.robot.test.CommandServerString;

/**
 *
 * @author Walter
 */
public class RobotGUI extends JFrame implements ActionListener {
    private RobotTracker robotTracker;    
    private JLabel labelX = new JLabel("my Label");
    private JTextField command = new JTextField();
    private CommandServerString cs;
    private RobotViewPanel drawArea;
    private JButton buttonHumanInteraction = new JButton("Press for collision!!!"); 
    private JButton reset = new JButton("RESET - Put Robot Home!");
     
    
    //constructor
    public RobotGUI(RobotTracker robotSim, CommandServerString cs) {
        this.robotTracker = robotSim;
        this.cs = cs;
        drawArea = new RobotViewPanel(this.robotTracker);
    }

    
    public void showFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        getContentPane().add(labelX, BorderLayout.NORTH);
        getContentPane().add(command, BorderLayout.SOUTH);
        getContentPane().add(drawArea, BorderLayout.CENTER);
        getContentPane().add(buttonHumanInteraction, BorderLayout.EAST);
        getContentPane().add(reset, BorderLayout.WEST);
        
        ActionListener actionText = new ActionListener() {  //Annonyme  innere Klasse, da ActionListener hier definiert wird
            @Override
            public void actionPerformed(ActionEvent e) {
                cs.setCommandString(command.getText());
                command.setText("");              
                //getCommandServer();
            }
        };     
        
        ActionListener actionCollisionButton = new ActionListener() {  //Annonyme  innere Klasse, da ActionListener hier definiert wird
            @Override
            public void actionPerformed(ActionEvent e) {
                cs.setCommandString("c=0");  // v und w werden auf 0 gesetzt
            }
        };    
        ActionListener actionResetButton = new ActionListener() {  //Annonyme  innere Klasse, da ActionListener hier definiert wird
            @Override
            public void actionPerformed(ActionEvent e) {
                robotTracker.putRobotBackHome();
                cs.setCommandString("c=0");  // v und w werden auf 0 gesetzt
            }
        }; 
        
        command.addActionListener(actionText);  
        buttonHumanInteraction.addActionListener(actionCollisionButton);
        reset.addActionListener(actionResetButton);
        
        setSize(new Dimension(1200, 950));
        setVisible(true);        
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        labelX.setText("x = " + Integer.toString((int) Math.round(
                                                        robotTracker.getX()))
              + "  " + "y = " + Integer.toString((int) Math.round(
                                                        robotTracker.getY()))
              + "  " + "phi = " + Integer.toString((int) Math.round(
                                                        robotTracker.getPhi()))
        );
    }
 
    public ICommandServer getCommandServer() {
        String text = command.getText();
        cs.setCommandString(text);
        return cs;
    }
    
 //   public ISensor getSensor() {
        //.....
 //   }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
