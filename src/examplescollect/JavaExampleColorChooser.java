/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examplescollect;

import java.awt.BorderLayout; 
import java.awt.Color; 
import java.awt.Container; 
import java.awt.FlowLayout; 
import java.awt.Font; 
import javax.swing.JColorChooser; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.colorchooser.DefaultColorSelectionModel; 
import javax.swing.event.ChangeEvent; 
import javax.swing.event.ChangeListener; 
class JavaExampleColorChooser extends JFrame implements ChangeListener 
 { 
     JLabel Lbl; 
     JavaExampleColorChooser(String TTL) 
     { 
        setTitle(TTL); 
        setSize(550,500); 
        setLayout(new FlowLayout()); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container Cntnr=getContentPane(); 
        Cntnr.setLayout(new BorderLayout()); 
        JColorChooser Chsr=new JColorChooser(Color.BLACK); 
        Chsr.getSelectionModel().addChangeListener(this);    
        Cntnr.add(Chsr,BorderLayout.NORTH); 
        Lbl=new JLabel("Select Color To Make The Change",JLabel.CENTER);  
        Lbl.setFont(new Font("Arial",Font.PLAIN, 30)); 
        Cntnr.add(Lbl,BorderLayout.CENTER);
        
        setVisible(true);  
      } 
     @Override
        public void stateChanged(ChangeEvent ee) 
         { 
            DefaultColorSelectionModel Mdl=(DefaultColorSelectionModel)ee.getSource(); 
            Lbl.setForeground(Mdl.getSelectedColor()); 
         } 
        /*
               public static void main(String[] aa) 
                 { 
                    new JavaExampleColorChooser("Java Color Chooser"); 
                 } 
        */
 } 