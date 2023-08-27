package Modalita;

import Interfaces.*;
import MainProject.*;
import Modalita.*;
import World.*;
import Inventory.*;
import Entity.*;
  
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mainModalita extends JFrame{
    
    public static final Dimension DIM_FRAME_MODALITA = new Dimension(800,250);
    private panelModalita p;
    
    public mainModalita(){
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                panelMenu.flag = 0;
            }
        });
        
        p = new panelModalita();

        add(p);
        setTitle("Modalita'");
        setSize(new Dimension(DIM_FRAME_MODALITA));
        setLocationRelativeTo(null);
        setUndecorated(true);
        setAlwaysOnTop(true);
    }
    
}
