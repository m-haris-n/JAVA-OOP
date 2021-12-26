package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyFrame extends JFrame implements ActionListener {
    int fwidth;
    int fheight;
    private JButton b;

    public MyFrame(int w, int h){
        this.fwidth = w;
        this.fheight = h;
        setTitle("A Title");
        setSize(w, h);
        setBackground(Color.pink);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if(e.getSource()==b){
//            this.setTitle("New Title");
//            b.setText("See Title!!");
//        }
    }
}

