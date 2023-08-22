package Inventory;

import Interfaces.*;
import MainProject.*;
import Modalita.*;
import World.*;
import Inventory.*;
import Entity.*;
  
public class Inventory {
 
    public Item [] inventario;
    
    public Inventory(){
        setInventory();
    }
    
    public int getNumInventory(int num){
        return inventario[num].getNumDisegno();
    }
    
    public void setInventory(){
        inventario = new Item[5];
        
        for(int i=0;i<5;i++)
            inventario[i] = new Item(5);
    }
    
    public boolean insertItem(Item o){
        for(int i=0;i<5;i++){
            if(inventario[i] == o)
                break;
            if(inventario[i].getClass() == Item.class){
                inventario[i] = o;
                return true;
            }
        }
        
        return false;
    }
    
    public void cancelItem(Item o){
        for(int i=0;i<5;i++){
            if(inventario[i] == o){
                inventario[i] = new Item(5);
                sortInventario();
            }
        }
    }
    
    private void sortInventario(){
        for(int i=0;i<5;i++){
            if(inventario[i].getClass() == Item.class){
                for(int j=i;j<5;j++){
                    if(inventario[j].getClass() != Item.class){
                        inventario[i] = inventario[j];
                        inventario[j] = new Item(5);
                    }
                }
            }
        }
    }
    
}
