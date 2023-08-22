package Modalita;

import Interfaces.*;
import MainProject.*;
import Modalita.*;
import World.*;
import Inventory.*;
import Entity.*;
        
import java.awt.Dimension;
import javax.swing.JFrame;

public class mainOptions extends JFrame{
    public static final Dimension DIM_FRAME_OPTIONS = new Dimension(700,350);
    private panelOptions p;
    
    public mainOptions(){
        p = new panelOptions();

        add(p);
        setTitle("Options");
        setSize(new Dimension(DIM_FRAME_OPTIONS));
        setLocationRelativeTo(null);
        setUndecorated(true);
    }
}
