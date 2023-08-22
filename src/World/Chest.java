package World;

import Interfaces.*;
import MainProject.*;
import Modalita.*;
import World.*;
import Inventory.*;
import Entity.*;

import java.awt.*;
import java.io.*;

public class Chest {
    
    private int chiave;
    private int aperto = 0;
    
    public Chest(int chiave){
        this.chiave = chiave;
    }
    
    public int controlloChest(Avventuriero umano){
        if(this.aperto == 0)
            if(umano.getX() >= 490 && umano.getX() <= 600 && umano.getY() <= 220 && umano.getY() >= 130){
                aperto = 1;
                return chiave;
            }
        return -1;
    }
    
}
