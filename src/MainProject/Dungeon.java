package MainProject;

import Interfaces.*;
import MainProject.*;
import Modalita.*;
import World.*;
import Inventory.*;
import Entity.*;

public class Dungeon {

    private static mainMenu m;
    private static Gioco g;
    
    public static void main(String[] args) {        
        m = new mainMenu();
        m.setVisible(true);
    }
    
    public static void startGame(){
        try{
            m.dispose();
        }catch (NullPointerException ignored){}
        
        g = new Gioco();
        g.setVisible(true);
    }
    
    public static void quitGame(){
        try{
            m.dispose();
            g.dispose();
            g.p.dispose();
            g.run = false;
            g.pause = false;
        }catch (Exception ignored){}
    }
    
    public static void restartMenu(){
        m = new mainMenu();
        m.setVisible(true);
        panelMenu.flag = 0;
    }
    
}
