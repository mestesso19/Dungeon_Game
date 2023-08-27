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

public class panelPause extends JPanel implements ActionListener{
    private JButton resume, options, menu, quit;
    private Image img;
    
    private static mainOptions o;
    
    public panelPause(){
        loadImg();
        setButtons();
        
        setLayout(null);
        setSize(new Dimension(mainPause.DIM_FRAME_PAUSE));
    }
    
    public void loadImg(){
        try{
            img = ImageIO.read(new File("ImgGioco/titolo.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void setButtons(){
        resume = new JButton("RESUME");
        options = new JButton("OPTIONS");
        menu = new JButton("MENU");
        quit = new JButton("QUIT");
        
        resume.setBounds(45,90,200,30);
        options.setBounds(45,130,200,30);
        menu.setBounds(45,170,200,30);
        quit.setBounds(45,210,200,30);
        
        resume.setFont(new Font("Caladea",Font.BOLD,12));
        resume.setForeground(Color.red);
            
        options.setFont(new Font("Caladea",Font.BOLD,12));
        options.setForeground(Color.red);    
        
        menu.setFont(new Font("Caladea",Font.BOLD,12));
        menu.setForeground(Color.red);
        
        quit.setFont(new Font("Caladea",Font.BOLD,12));
        quit.setForeground(Color.red);
        
        resume.addActionListener(this);
        options.addActionListener(this);
        menu.addActionListener(this);
        quit.addActionListener(this);
        
        add(resume);
        add(options);
        add(menu);
        add(quit);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.drawImage(img, 5, 10, 280, 80, null);
       
        g2d.dispose();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String [] optionsAgg = {"SI", "NO"};
        
        if(e.getSource() == resume){
            Gioco.pause = true;
            Gioco.stopPause();
        }
        else if(e.getSource() == options){
            o = new mainOptions();
            o.setVisible(true);
        }
        else if(e.getSource() == menu){
            int num = JOptionPane.showOptionDialog(this, "I progressi che hai fatto fino ad adesso verranno cancellati\n                     Sei sicuro di voler continuare?", "", 0, 1, null, optionsAgg, optionsAgg[0]);
            if(num == 0){
                Dungeon.quitGame();
                Dungeon.restartMenu();
            }
        }
        else if(e.getSource() == quit){
            int num = JOptionPane.showOptionDialog(this, "I progressi che hai fatto fino ad adesso verranno cancellati\n                     Sei sicuro di voler continuare?", "", 0, 1, null, optionsAgg, optionsAgg[0]);
            if(num == 0)
                Dungeon.quitGame();
        }
    }
    
    public static void cancel(){
        try{
            o.dispose();
        }
        catch(Exception ignored){}
    }
    
}
