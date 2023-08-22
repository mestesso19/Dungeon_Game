package World;

import Interfaces.*;
import MainProject.*;
import Modalita.*;
import World.*;
import Inventory.*;
import Entity.*;
        
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Map {
    
    private Image img2;
    
    public Map(){
        ImgIniz();
    }
    public void ImgIniz(){
        
        try{
            img2 = ImageIO.read(new File("ImgGioco/mappa.png"));
        }
        catch(IOException ex){
            System.out.println("Errore nel trovare immagini");
        }
        
    }
    
    public void draw(Graphics2D g2D){
        g2D.drawImage(img2, 250, 100, 600, 550, null);
    }
}