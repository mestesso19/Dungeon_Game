package Modalita;

import Interfaces.*;
import MainProject.*;
import Modalita.*;
import World.*;
import Inventory.*;
import Entity.*;
        
import java.awt.*;
import javax.swing.*;

public class mainOptions extends JFrame{
    public static final Dimension DIM_FRAME_OPTIONS = new Dimension(700,450);
    private panelOptions p;
    private JPanel imp;
    
    public mainOptions(){
        p = new panelOptions();
        
        add(p);
        setTitle("Options");
        setSize(new Dimension(DIM_FRAME_OPTIONS));
        setLocationRelativeTo(null);
        setUndecorated(true);
        setAlwaysOnTop(true);
    }
}
