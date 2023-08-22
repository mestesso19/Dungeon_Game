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
import javafx.beans.value.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class panelOptions extends JPanel implements ChangeListener, ActionListener, ListaAttributi{
    
    public JSlider s1, s2, s3;
    public JLabel tx1, tx2, tx3;
    public JTextField t1, t2, t3;
    public JButton ok, cancel;
    
    public panelOptions(){
        settingOptions();
        
        setLayout(null);
        setSize(new Dimension(mainOptions.DIM_FRAME_OPTIONS));
    }
    
    public void settingOptions(){
        tx1 = new JLabel("Luminosita'");
        tx2 = new JLabel("Musica");
        tx3 = new JLabel("FPS");
        
        tx1.setFont(new Font("Caladea",Font.BOLD,15));
        tx2.setFont(new Font("Caladea",Font.BOLD,15));
        tx3.setFont(new Font("Caladea",Font.BOLD,15));
        
        tx1.setBounds(50,10,300,100);
        tx2.setBounds(50,95,300,100);
        tx3.setBounds(50,180,300,100);
        
        add(tx1);
        add(tx2);
        add(tx3);
        
        t1 = new JTextField(String.valueOf(Gioco.luminosita));
        t2 = new JTextField(String.valueOf(Gioco.musica));
        t3 = new JTextField(String.valueOf(Gioco.FPS));
        
        t1.setFont(new Font("Caladea",Font.BOLD,15));
        t2.setFont(new Font("Caladea",Font.BOLD,15));
        t3.setFont(new Font("Caladea",Font.BOLD,15));
        
        t1.setBounds(180,tx1.getY()+40,50,20);
        t2.setBounds(180,tx2.getY()+40,50,20);
        t3.setBounds(180,tx3.getY()+40,50,20);
        
        add(t1);
        add(t2);
        add(t3);
        
        s1 = new JSlider(0,100,Gioco.luminosita);
        s2 = new JSlider(0,100,Gioco.musica);
        s3 = new JSlider(30,100,Gioco.FPS);
        
        s1.setBounds(280,tx1.getY(),370,100);
        s2.setBounds(280,tx2.getY(),370,100);
        s3.setBounds(280,tx3.getY(),370,100);
        
        s1.addChangeListener(this);
        s2.addChangeListener(this);
        s3.addChangeListener(this);
        
        add(s1);
        add(s2);
        add(s3);
        
        ok = new JButton("OK");
        cancel = new JButton("CANCEL");
        
        ok.setBounds(200,280,100,50);
        ok.setFont(new Font("Caladea",Font.BOLD,15));
        
        cancel.setBounds(400,280,100,50);
        cancel.setFont(new Font("Caladea",Font.BOLD,15));
        
        ok.addActionListener(this);
        cancel.addActionListener(this);
        
        add(ok);
        add(cancel);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        
        JSlider source = (JSlider) e.getSource();
        
        if(source == s1)
            t1.setText(String.valueOf(s1.getValue()));
        else if(source == s2)
            t2.setText(String.valueOf(s2.getValue()));
        else if(source == s3)
            t3.setText(String.valueOf(s3.getValue()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == ok){
            Gioco.setValue(s1.getValue(), s2.getValue(), s3.getValue());
        }
        
        panelMenu.cancelOptions();
        panelPause.cancel();
    }

    
}
