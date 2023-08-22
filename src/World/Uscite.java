package World;

import Interfaces.*;
import MainProject.*;
import Modalita.*;
import World.*;
import Inventory.*;
import Entity.*;

public class Uscite implements ListaAttributi{
    
    private String tipo;
    private int tipoUscita;
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    
    public Uscite(String tipo, int tipoUscita, int x1, int x2, int y1, int y2){
        this.tipo = tipo;
        this.tipoUscita = tipoUscita;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    
    public int controlloUscita(Avventuriero umano){
        
        switch(tipo){
            case "U":
                if(umano.getX() >= x1 && umano.getX() <= x2 && umano.getY() <= y1)
                    if(Stanze.numMat == 4 && Stanze.portaAperta == 0)
                        return -1;
                    else
                        return tipoUscita;
            break;
            case "D":
                if(umano.getX() >= x1 && umano.getX() <= x2 && umano.getY() >= y1)
                    return tipoUscita;
            break;
            case "R":
                if(umano.getY() >= y1 && umano.getY() <= y2 && umano.getX() >= x1)
                    return tipoUscita;
            break;
            case "L":
                if(umano.getY() >= y1 && umano.getY() <= y2 && umano.getX() <= x1)
                    return tipoUscita;
            break;
        }
        
        return -1;
        
    }
    
    public void respawn(Avventuriero umano){
        switch(tipo){
            case "U":
                umano.setY((numCaselleVer*caselleSize)-245);
            break;
            case "D":
                umano.setY(150);
            break;
            case "R":
                umano.setX(135);
            break;
            case "L":
                umano.setX(880);
            break;
        }
    }
    
}
