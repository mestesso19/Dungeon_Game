package File;

import Interfaces.*;
import MainProject.*;
import Modalita.*;
import World.*;
import Inventory.*;
import Entity.*;

import java.awt.*;
import java.io.*;

public class Matrix implements ListaAttributi{
    
    private int nStanza;
    private int [][] mat;
    public Uscite [] usc = new Uscite[4];
    
    public Matrix(String s){
        
        mat = new int[numCaselleVer][numCaselleOriz];
        
        try{
            
            BufferedReader file = new BufferedReader(new FileReader(s));
            
            String str = file.readLine();
            nStanza = Integer.parseInt(str);
            
            for(int i=0;i<4;i++){
                str = file.readLine();        
                if(!str.equals("null")){
                    String uscite = str.substring(0, 1);
                    String temp = (str.substring(1, 2));
                    int tipoUscite = 0;
                    switch(temp){
                        case "A": tipoUscite = 10; break;
                        case "B": tipoUscite = 11; break;
                        case "C": tipoUscite = 12; break;
                        case "D": tipoUscite = 13; break;
                        default: tipoUscite = Integer.parseInt(temp); break;
                    }
                    int y1 = Integer.parseInt(str.substring(2, 5));
                    int y2 = Integer.parseInt(str.substring(5, 8));
                    int x1 = Integer.parseInt(str.substring(8, 11));
                    int x2 = Integer.parseInt(str.substring(11, 14));
                    usc[i] = new Uscite(uscite,tipoUscite,x1,x2,y1,y2);
                }
                else
                    usc[i] = null;
            }
            
            int num = 0;
            str = "";
            
            for(int i=0;i<numCaselleVer;i++){
                str = file.readLine();
                   
                for(int j=0;j<numCaselleOriz;j++){
                    num = Integer.parseInt(str.substring(j, j+1));
                    mat[i][j] = num;
                }
            }
            
            file.close();
            
        }
        catch(IOException ex){
            System.out.println("Errore: nella lettura da file");
        }
        catch(StringIndexOutOfBoundsException ex){
            System.out.println("Errore: uscita dalla stringa");
        }
        
    }
    
    public int [][] getMat(){
        return mat;
    }
    
}