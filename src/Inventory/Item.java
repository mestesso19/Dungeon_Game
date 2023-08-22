package Inventory;

import Interfaces.*;
import MainProject.*;
import Modalita.*;
import World.*;
import Inventory.*;
import Entity.*;  
        
public class Item {
    
    public int numChiave;
    public int numDisegno;
    
    public Item(int num){
        this.numDisegno = num;
    }
    
    public int getNumDisegno(){
        return numDisegno;
    }
    
    public int getNumItem(){
        return -1;
    }
    
}
