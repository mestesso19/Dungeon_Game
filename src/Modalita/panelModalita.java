package Modalita;

import Interfaces.*;
import MainProject.*;
import Modalita.*;
import World.*;
import Inventory.*;
import Entity.*;
  
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class panelModalita extends JPanel implements ActionListener{
    
    private Image img;

    private JButton facile, normale, difficile, ok, indietro;
    
    public panelModalita(){
        loadImg();
        setButtons();
        
        setLayout(null);
        setOpaque(false);
        setSize(new Dimension(mainModalita.DIM_FRAME_MODALITA));
    }
    
    public void loadImg(){
        
    }

    public void paintComponent(Graphics g){
        
    }
    
    public void setButtons(){
        facile = new JButton("FACILE");
        normale = new JButton("NORMALE");
        difficile = new JButton("DIFFICILE");
        ok = new JButton("OK");
        indietro = new JButton("INDIETRO");

        facile.setBounds(30,40,200,50);
        normale.setBounds(290,40,200,50);
        difficile.setBounds(550,40,200,50);
        ok.setBounds(200,140,180,70);
        indietro.setBounds(400,140,180,70);
        
        facile.setBorder(new LineBorder(Color.black, 8));
        facile.setFont(new Font("Caladea",Font.BOLD,30));
        facile.setForeground(Color.black);
        facile.setBackground(Color.gray);
        
        normale.setBorder(new LineBorder(Color.black, 8));
        normale.setFont(new Font("Caladea",Font.BOLD,30));
        normale.setForeground(Color.black);    
        normale.setBackground(Color.gray);
        
        difficile.setBorder(new LineBorder(Color.black, 8));
        difficile.setFont(new Font("Caladea",Font.BOLD,30));
        difficile.setForeground(Color.black);
        difficile.setBackground(Color.gray);
        
        ok.setBorder(new LineBorder(Color.black, 8));
        ok.setFont(new Font("Caladea",Font.BOLD,30));
        ok.setForeground(Color.black);
        ok.setBackground(new Color(255, 215, 0));
       
        indietro.setBorder(new LineBorder(Color.black, 8));
        indietro.setFont(new Font("Caladea",Font.BOLD,30));
        indietro.setForeground(Color.black);
        indietro.setBackground(new Color(255, 215, 0));
        
        facile.addActionListener(this);
        normale.addActionListener(this);
        difficile.addActionListener(this);
        ok.addActionListener(this);
        indietro.addActionListener(this);
        
        add(facile);
        add(normale);
        add(difficile);
        add(ok);
        add(indietro);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == facile){
            Gioco.modalita = 0;
            facile.setBackground(new Color(255, 215, 0));
            normale.setBackground(Color.gray);
            difficile.setBackground(Color.gray);
        }
        else if(e.getSource() == normale){
            Gioco.modalita = 1;
            facile.setBackground(Color.gray);
            normale.setBackground(new Color(255, 215, 0));
            difficile.setBackground(Color.gray);
        }
        else if(e.getSource() == difficile){
            Gioco.modalita = 2;
            facile.setBackground(Color.gray);
            normale.setBackground(Color.gray);
            difficile.setBackground(new Color(255, 215, 0));
        }
        else if(e.getSource() == ok){
            if(Gioco.modalita != -1){
                Dungeon.startGame();
                panelMenu.cancelModalita();
            }
        }
        else if(e.getSource() == indietro){
            panelMenu.flag = 0;
            panelMenu.cancelModalita();
        }
        
    }
    
}
