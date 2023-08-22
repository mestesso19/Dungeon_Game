package World;

import Interfaces.*;
import MainProject.*;
import Modalita.*;
import World.*;
import Inventory.*;
import Entity.*;
import File.*;

import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Stanze implements ListaAttributi{
    
    private static Matrix [] mat;
    private static int [][] m;
    public static int num, numMat = 0;
    private Image [] img;
    private Image img2;
    public Chest [] chest = new Chest[2];
    public static Inventory inventario;

    private Item chiaveBlu = new Chiave(0, 6);
    private Item chiaveRossa = new Chiave(1, 7);
    
    private int NchiaveBlu = 0;
    private int NchiaveRossa = 0;
    
    private int chiaviInserite = 0;
    public static int portaAperta = 0;
    
    public Stanze(){
        setMatrici();
        setInventory();
        setM(0);      // imposto la stanza iniziale
        ImgIniz();
        
        chest[0] = new Chest(0);
        chest[1] = new Chest(1);
    }
    
    public void setMatrici(){
        mat = new Matrix[14];
        
        mat[0] = new Matrix("FileStanze/stanzaIniziale.txt");
        mat[1] = new Matrix("FileStanze/stanzaSnodo.txt");
        mat[2] = new Matrix("FileStanze/stanzaD1.txt");
        mat[3] = new Matrix("FileStanze/stanzaS1.txt");
        mat[4] = new Matrix("FileStanze/stanzaC1.txt");
        mat[5] = new Matrix("FileStanze/stanzaS2.txt");
        mat[6] = new Matrix("FileStanze/stanzaS3.txt");
        mat[7] = new Matrix("FileStanze/stanzaS4.txt");
        mat[8] = new Matrix("FileStanze/stanzaS5.txt");
        mat[9] = new Matrix("FileStanze/stanzaD2.txt");
        mat[10] = new Matrix("FileStanze/stanzaD3.txt");
        mat[11] = new Matrix("FileStanze/stanzaD4.txt");
        mat[12] = new Matrix("FileStanze/stanzaD5.txt");
        mat[13] = new Matrix("FileStanze/stanzaC2.txt");
    }
    
    public void setInventory(){
        inventario = new Inventory();
    }
    
    public void setChiavi(){
        inventario.insertItem(chiaveBlu);
        inventario.insertItem(chiaveRossa);
        NchiaveBlu = 1;
        NchiaveRossa = 1;
        m[9][9] = 6;
        m[9][10] = 7;
    }
    
    public static void setM(int num){
        m = mat[num].getMat();
        numMat = num;
        
        setImageInventory();
    }
    
    public static void setImageInventory(){
        for(int i=0;i<5;i++)
            m[9][9+i] = inventario.getNumInventory(i);
    }
    
    public void ImgIniz(){
        
        img = new Image[14];
        
        try{
            img2 = ImageIO.read(new File("ImgGioco/mappa.png"));
            
            img[0] = ImageIO.read(new File("ImgStanze/vuoto.jpg"));
            img[1] = ImageIO.read(new File("ImgStanze/muro.jpg"));
            img[2] = ImageIO.read(new File("ImgStanze/pavimento.jpg"));
            img[3] = ImageIO.read(new File("ImgStanze/acqua.jpg"));
            img[4] = ImageIO.read(new File("ImgStanze/chest.png"));
            img[5] = ImageIO.read(new File("ImgStanze/inventario.png"));
            img[6] = ImageIO.read(new File("ImgStanze/inv_ChiaveBlu.png"));
            img[7] = ImageIO.read(new File("ImgStanze/inv_ChiaveRossa.png"));
            img[8] = ImageIO.read(new File("ImgStanze/porta.png"));
            img[9] = ImageIO.read(new File("ImgStanze/serratura.png"));
            img[10] = ImageIO.read(new File("ImgStanze/serraturaBlu.png"));
            img[11] = ImageIO.read(new File("ImgStanze/serraturaRossa.png"));
            img[12] = ImageIO.read(new File("ImgStanze/portaAperta.png"));
            img[13] = ImageIO.read(new File("ImgStanze/chestAperta.png"));

        }
        catch(IOException ex){
            System.out.println("Errore nel trovare immagini");
        }
        
    }
    
    public void draw(Graphics2D g2D){
        for (int i=0, y=0; i < numCaselleVer; i++, y += caselleSize) {
            for (int j=0, x=0; j < numCaselleOriz; j++, x += caselleSize)
                g2D.drawImage(img[m[i][j]], x, y, caselleSize, caselleSize, null);
        }
        Gioco.pause = true;
    }
    
    public static void controlloUscita(Avventuriero umano){
        for(int i=0;i<4;i++){
            if(mat[numMat].usc[i] != null){
                num = mat[numMat].usc[i].controlloUscita(umano);
                if(num != -1){
                    mat[numMat].usc[i].respawn(umano);
                    setM(num);
                }
            }
        }
    }
    
    public int controlloChest(Avventuriero umano){
        if(this.numMat == 8 && chest[0].controlloChest(umano) == 0){
            if(inventario.insertItem(chiaveBlu) == true){
                NchiaveBlu = 1;
                m[2][7] = 13;
                setImageInventory();
                return 0;
            }
        }
        else if(this.numMat == 12 && chest[1].controlloChest(umano) == 1){
            if(inventario.insertItem(chiaveRossa) == true){
                NchiaveRossa = 1;
                m[2][7] = 13;
                setImageInventory();
                return 1;
            }
        }
        return -1;
    }
    
    public void controlloSerratura(Avventuriero umano){
        if(NchiaveBlu == 1 && umano.getX() >= 340 && umano.getX() <= 420 && umano.getY() <= 225){
            m[1][5] = 10;
            inventario.cancelItem(chiaveBlu);
            NchiaveBlu = 0;
            chiaviInserite++;
            setImageInventory();
        }
        else if(NchiaveRossa == 1 && umano.getX() >= 640 && umano.getX() <= 720 && umano.getY() <= 225){
            m[1][9] = 11;
            inventario.cancelItem(chiaveRossa);
            NchiaveRossa = 0;
            chiaviInserite++;
            setImageInventory();
        }
        if(chiaviInserite == 2){
            m[1][7] = 12;
            chiaviInserite = 0;
            portaAperta = 1;
        }
    }
    
}