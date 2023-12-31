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
    
    public static char [] tasti;
    public static int numTasti = 7;
    
    public static void main(String[] args){
        setTasti();
        
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
    
    public static void setTasti(){
        tasti = new char[numTasti];
        
        tasti[0] = ListaAttributi.tsSu;
        tasti[1] = ListaAttributi.tsGiu;
        tasti[2] = ListaAttributi.tsDx;
        tasti[3] = ListaAttributi.tsSx;
        tasti[4] = ListaAttributi.tsAtt;
        tasti[5] = ListaAttributi.tsMap;
        tasti[6] = ListaAttributi.tsOgg;
    }
    
}
