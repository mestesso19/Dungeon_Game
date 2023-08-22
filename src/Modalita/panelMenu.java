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
import javax.swing.border.*;

public class panelMenu extends JPanel implements ActionListener{
    
    private static mainModalita m;
    private static mainOptions o;
    
    private Image img, img2;

    private JButton start, options, quit;
    
    public static int flag = 0;
    
    public panelMenu(){
        loadImg();
        setButtons();
        
        setLayout(null);
        setOpaque(false);
        setSize(new Dimension(mainMenu.DIM_FRAME_MENU));
    }

    public void loadImg(){
        try{
            img = ImageIO.read(new File("ImgGioco/imgMenu.jpeg"));
            img2 = ImageIO.read(new File("ImgGioco/titolo.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.drawImage(img, 0, 0, mainMenu.DIM_FRAME_MENU.width, mainMenu.DIM_FRAME_MENU.height, null);
        g2d.drawImage(img2, 50, 50, 900, 300, null);
        
        g2d.dispose();
    }
    
    public void setButtons(){
        start = new JButton("START");
        options = new JButton("OPTIONS");
        quit = new JButton("QUIT");
        
        start.setBounds(100,350,180,100);
        options.setBounds(400,350,180,100);
        quit.setBounds(700,350,180,100);
        
        start.setBorder(new LineBorder(Color.black, 8));
        start.setFont(new Font("Caladea",Font.BOLD,30));
        start.setForeground(Color.black);
        start.setBackground(new Color(255, 215, 0));
        
        options.setBorder(new LineBorder(Color.black, 8));
        options.setFont(new Font("Caladea",Font.BOLD,30));
        options.setForeground(Color.black);    
        options.setBackground(new Color(255, 215, 0));
        
        quit.setBorder(new LineBorder(Color.black, 8));
        quit.setFont(new Font("Caladea",Font.BOLD,30));
        quit.setForeground(Color.black);
        quit.setBackground(new Color(255, 215, 0));
        
        start.addActionListener(this);
        options.addActionListener(this);
        quit.addActionListener(this);
        
        add(start);
        add(options);
        add(quit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(flag == 0){
            if(e.getSource() == start){
                m = new mainModalita();
                m.setVisible(true);
                flag = 1;
            }
            else if(e.getSource() == options){
                o = new mainOptions();
                o.setVisible(true);
            }
            else if(e.getSource() == quit)
                Dungeon.quitGame();
        }
    }
    
    public static void cancelOptions(){
        try{
            o.dispose();
        }
        catch(Exception ignored){}
    }
    
    public static void cancelModalita(){
        try{
            m.dispose();
        }
        catch(Exception ignored){}
    }
    
}
