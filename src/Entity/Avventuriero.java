package Entity;

import Interfaces.*;
import Modalita.*;
import World.*;
import Inventory.*;
import Entity.*;

import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Avventuriero implements ListaAttributi, Entita{
    
    private int x;
    private int y;
    private int direzione;
    public Image [] img;
    
    public int chiavi = 0;
    
    public Avventuriero(){
        
        x = xIniz;
        y = yIniz;
        
        this.direzione = 4;
        
        img = new Image[8];
        ImgIniz();
        
    }
    
    public void ImgIniz(){
        
        try{
            img[0] = ImageIO.read(new File("ImgAvventuriero/su1.png"));
            img[1] = ImageIO.read(new File("ImgAvventuriero/su2.png"));
            img[2] = ImageIO.read(new File("ImgAvventuriero/Sinistra1.png"));
            img[3] = ImageIO.read(new File("ImgAvventuriero/Sinistra2.png"));
            img[4] = ImageIO.read(new File("ImgAvventuriero/Giu1.png"));
            img[5] = ImageIO.read(new File("ImgAvventuriero/Giu2.png"));
            img[6] = ImageIO.read(new File("ImgAvventuriero/Destra1.png"));
            img[7] = ImageIO.read(new File("ImgAvventuriero/Destra2.png"));
        }
        catch(IOException ex){
            System.out.println("Errore nel trovare l'immagine");
        }
        
    }
    
    public void MovX(int mov){
        if(x+mov > 120 && x+mov < 905)
            this.x += mov;
    }
    
    public void MovY(int mov){
        if(y+mov > 130 && y+mov < (numCaselleVer*caselleSize)-230)
            this.y += mov;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setDirezione(int d){
        this.direzione = d;
    }
    
    public void draw(Graphics2D g2D, int print){ 
        g2D.drawImage(img[direzione+print], x, y, objectSize, objectSize, null);
    }
    
    public void drawAttack(Graphics2D g2D, boolean spacePressed){
        if(spacePressed == true && direzione == 0)         // su
            g2D.drawArc(x, y, 100, 100, 35, 110);
        else if(spacePressed == true && direzione == 2)    // sinistra
            g2D.drawArc(x, y, 100, 100, 115, 125);
        else if(spacePressed == true && direzione == 4)    // giu
            g2D.drawArc(x, y, 100, 100, 220, 100);
        else if(spacePressed == true && direzione == 6)    // destra
            g2D.drawArc(x, y, 100, 100, 295, 135);
    }
    
    public void chiaveTrovata(){
        this.chiavi++;
    }
}
