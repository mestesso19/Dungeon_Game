package Modalita;

import Interfaces.*;
import MainProject.*;
import Modalita.*;
import World.*;
import Inventory.*;
import Entity.*;
  
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class panelOptions extends JPanel implements ChangeListener, ActionListener, KeyListener, ListaAttributi, Runnable{
    
    private JPanel currentPanel; // Pannello attualmente visualizzato
    
    private JSlider s1, s2;
    private JTextField txt1, txt2;
    private JButton ok, cancel, rip;
    private JButton grafica, audio, tasti;
    private JButton [] btTasti;
    private JPanel impGrafica, impAudio, impTasti;
    
    private char tastoPremuto;
    private int index = -1;
    private int listenerOn = 0;
    
    public panelOptions(){
        settingOptions();
        
        setImpGrafica();
        setImpAudio();
        setImpTasti();
        
        showPanel(impGrafica);
        grafica.setBorder(new LineBorder(Color.green, 3));
        audio.setBorder(new LineBorder(Color.black, 3));
        tasti.setBorder(new LineBorder(Color.black, 3));
       
        setLayout(null);
        setSize(new Dimension(mainOptions.DIM_FRAME_OPTIONS));
    }
    
    private void showPanel(JPanel newPanel) {
        if (currentPanel != null)
            remove(currentPanel);
        add(newPanel);
        currentPanel = newPanel;
        revalidate();
        repaint();
    }

    
    public void settingOptions(){
        ok = new JButton("OK");
        cancel = new JButton("CANCEL");
        rip = new JButton("RIPRISTINA");
        grafica = new JButton("GRAFICA");
        audio = new JButton("AUDIO");
        tasti = new JButton("TASTI");

        ok.setBounds(150,375,100,50);
        ok.setFont(new Font("Caladea",Font.BOLD,15));
        
        cancel.setBounds(300,375,100,50);
        cancel.setFont(new Font("Caladea",Font.BOLD,15));
        
        rip.setBounds(450,375,120,50);
        rip.setFont(new Font("Caladea",Font.BOLD,15));
        
        grafica.setBounds(0,0,150,80);
        grafica.setFont(new Font("Caladea",Font.BOLD,15));
        
        audio.setBounds(0,80,150,80);
        audio.setFont(new Font("Caladea",Font.BOLD,15));
        
        tasti.setBounds(0,160,150,80);
        tasti.setFont(new Font("Caladea",Font.BOLD,15));
        
        ok.addActionListener(this);
        cancel.addActionListener(this);
        rip.addActionListener(this);
        grafica.addActionListener(this);
        audio.addActionListener(this);
        tasti.addActionListener(this);

        add(ok);
        add(cancel);
        add(rip);
        add(grafica);
        add(audio);
        add(tasti);
    }
    
    public void setImpGrafica(){
        impGrafica = new JPanel();
        
        impGrafica.setLayout(null);
        impGrafica.setBounds(150,0,550,350);
        
        JLabel tx1 = new JLabel("Luminosita'");
        tx1.setBounds(40,30,100,25);
        tx1.setFont(new Font("Caladea",Font.BOLD,15));
        
        txt1 = new JTextField("50");
        txt1.setEditable(false);
        txt1.setBounds(tx1.getX()+120,tx1.getY()+5,50,20);
        txt1.setFont(new Font("Caladea",Font.BOLD,15));
        
        s1 = new JSlider(1,100,Gioco.luminosita);
        s1.setBounds(tx1.getX()+200,tx1.getY()+5,270,20);
        s1.addChangeListener(this);
        
        impGrafica.add(tx1);
        impGrafica.add(txt1);
        impGrafica.add(s1);   
    }
    
    public void setImpAudio(){
        impAudio = new JPanel();
        
        impAudio.setLayout(null);
        impAudio.setBounds(150,0,550,350);
        
        JLabel tx2 = new JLabel("Musica");
        tx2.setBounds(40,30,100,25);
        tx2.setFont(new Font("Caladea",Font.BOLD,15));
        
        txt2 = new JTextField("50");
        txt2.setEditable(false);
        txt2.setBounds(tx2.getX()+95,tx2.getY()+5,50,20);
        txt2.setFont(new Font("Caladea",Font.BOLD,15));
        
        s2 = new JSlider(1,100,Gioco.luminosita);
        s2.setBounds(tx2.getX()+180,tx2.getY()+5,270,20);
        s2.addChangeListener(this);
        
        impAudio.add(tx2);
        impAudio.add(txt2);
        impAudio.add(s2);
    }
    
    public void setImpTasti(){
        impTasti = new JPanel();
        
        impTasti.setLayout(null);
        impTasti.setBounds(150,0,550,350);
        
        JLabel [] txTasti = new JLabel[Dungeon.numTasti];
        txTasti[0] = new JLabel("Su");
        txTasti[1] = new JLabel("Giu");
        txTasti[2] = new JLabel("Destra");
        txTasti[3] = new JLabel("Sinistra");
        txTasti[4] = new JLabel("Attacco");
        txTasti[5] = new JLabel("Mini mappa");
        txTasti[6] = new JLabel("Uso oggetti");

        btTasti = new JButton[7];
        btTasti[0] = new JButton("" + Dungeon.tasti[0]);
        btTasti[1] = new JButton("" + Dungeon.tasti[1]);
        btTasti[2] = new JButton("" + Dungeon.tasti[2]);
        btTasti[3] = new JButton("" + Dungeon.tasti[3]);
        btTasti[4] = new JButton("" + Dungeon.tasti[4]);
        btTasti[5] = new JButton("" + Dungeon.tasti[5]);
        btTasti[6] = new JButton("" + Dungeon.tasti[6]);
        
        
        for(int i=0;i<Dungeon.numTasti;i++){
            txTasti[i].setBounds(60,(50*i)+30,100,25);
            txTasti[i].setFont(new Font("Caladea",Font.BOLD,15));
            impTasti.add(txTasti[i]);
            
            btTasti[i].setBounds(200,(50*i)+20,150,40);
            btTasti[i].setFont(new Font("Caladea",Font.BOLD,15));
            if(btTasti[i].getText().equals(" "))
                btTasti[i].setText("SPACE");
            btTasti[i].addActionListener(this);
            impTasti.add(btTasti[i]);
        }
        
    }

    public void paint(Graphics g){
        super.paint(g);
        
        g.drawLine(150, 0, 150, 350);
        g.drawLine(0, 350, 700, 350);
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        
        JSlider source = (JSlider) e.getSource();
        
        if(source == s1)
            txt1.setText(String.valueOf(s1.getValue()));
     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String [] optionsAgg = {"SI", "NO"};
        
        if(e.getSource() == ok){
            confirmTasti();
            panelMenu.cancelOptions();
            panelPause.cancel();
        }
        else if(e.getSource() == cancel){
            panelMenu.cancelOptions();
            panelPause.cancel();
        }
        else if(e.getSource() == rip){
            int num = JOptionPane.showOptionDialog(this, "Le modifiche che hai fatto fino ad adesso verranno cancellate\n                     Sei sicuro di voler continuare?", "", 0, 1, null, optionsAgg, optionsAgg[0]);
            if(num == 0)
                setTasti();
        }
        else if(e.getSource() == grafica){
            showPanel(impGrafica);
            grafica.setBorder(new LineBorder(Color.green, 3));
            audio.setBorder(new LineBorder(Color.black, 3));
            tasti.setBorder(new LineBorder(Color.black, 3));
        }
        else if(e.getSource() == audio){
            showPanel(impAudio);
            grafica.setBorder(new LineBorder(Color.black, 3));
            audio.setBorder(new LineBorder(Color.green, 3));
            tasti.setBorder(new LineBorder(Color.black, 3));
        }
        else if(e.getSource() == tasti){
            showPanel(impTasti);
            grafica.setBorder(new LineBorder(Color.black, 3));
            audio.setBorder(new LineBorder(Color.black, 3));
            tasti.setBorder(new LineBorder(Color.green, 3));
        }
        else if(e.getSource() == btTasti[0]){
            index = 0;
            btTasti[0].addKeyListener(this);
        }
        else if(e.getSource() == btTasti[1]){
            index = 1;
            btTasti[1].addKeyListener(this);
        }
        else if(e.getSource() == btTasti[2]){
            index = 2;
            btTasti[2].addKeyListener(this);
        }
        else if(e.getSource() == btTasti[3]){
            index = 3;
            btTasti[3].addKeyListener(this);
        }
        else if(e.getSource() == btTasti[4]){
            index = 4;
            btTasti[4].addKeyListener(this);
        }
        else if(e.getSource() == btTasti[5]){
            index = 5;
            btTasti[5].addKeyListener(this);
        }
        else if(e.getSource() == btTasti[6]){
            index = 6;
            btTasti[6].addKeyListener(this);
        }
    }

    public boolean controlCharacter(char c){
        for(int i=0;i<Dungeon.numTasti;i++){
            if(btTasti[i].getText().charAt(0) == c)
                return false;
            else if(btTasti[i].getText().equals("SPACE") && c == ' ')
                return false;
        }
        return true;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(index != -1){
            tastoPremuto = (char) e.getKeyCode();
            if(controlCharacter(tastoPremuto) == true){
                if(tastoPremuto == ' ')
                    btTasti[index].setText("SPACE");
                else
                    btTasti[index].setText("" + tastoPremuto);
            }
            else
                JOptionPane.showMessageDialog(null, "Tasto gia' in uso");
            
            index = -1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void run() {
        try{ Thread.sleep(3000); } 
        catch (InterruptedException e) { e.printStackTrace(); }
    }
    
    public void setTasti(){ 
        btTasti[0].setText("" + ListaAttributi.tsSu);
        btTasti[1].setText("" + ListaAttributi.tsGiu);
        btTasti[2].setText("" + ListaAttributi.tsDx);
        btTasti[3].setText("" + ListaAttributi.tsSx);
        btTasti[4].setText("" + ListaAttributi.tsAtt);
        btTasti[5].setText("" + ListaAttributi.tsMap);
        
        for(int i=0;i<Dungeon.numTasti;i++){
            if(btTasti[i].getText().charAt(0) == ' ')
                btTasti[i].setText("SPACE");
        }
    }
    
    public void confirmTasti(){
        for(int i=0;i<Dungeon.numTasti;i++){
            if(btTasti[i].getText().equals("SPACE"))
                Dungeon.tasti[i] = ' ';
            else
                Dungeon.tasti[i] = btTasti[i].getText().charAt(0);
        }
    }

    
}
