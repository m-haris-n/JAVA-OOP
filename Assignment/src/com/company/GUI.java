package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GUI extends JFrame {
    public static void main(String[] args) {
        JFrame form = new JFrame();
        form.setVisible(true);
        form.setSize(450, 500);
        form.setLayout(new FlowLayout());
//        form.setLocationRelativeTo(frame);
        form.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel pf = new JPanel();
        pf.setVisible(true);
        pf.setLayout(new GridLayout(6, 1, 5, 5));
        pf.setPreferredSize(new Dimension(400, 450));
        pf.setBorder(new TitledBorder("Player's Data"));

        JLabel ln = new JLabel("Name: ");
        JLabel la = new JLabel("Age: ");
        JLabel lg = new JLabel("Gender: ");
        JLabel lc = new JLabel("Country: ");
        JLabel lt = new JLabel("Team: ");
        ln.setPreferredSize(new Dimension(400, 30));
        la.setPreferredSize(new Dimension(400, 30));
        lg.setPreferredSize(new Dimension(400, 30));
        lc.setPreferredSize(new Dimension(400, 30));
        lt.setPreferredSize(new Dimension(400, 30));
        JTextField tn = new JTextField("", 15);
        JTextField ta = new JTextField("", 15);
        JTextField tg = new JTextField("", 15);
        JTextField tc = new JTextField("", 15);
        JTextField tt = new JTextField("", 15);
        tn.setBounds(10, 0, 200, 50);
        ta.setBounds(10, 0, 200, 50);
        tg.setBounds(10, 0, 200, 50);
        tc.setBounds(10, 0, 200, 50);
        tt.setBounds(10, 0, 200, 50);
//        ln.setFont(mediumFont);
//        la.setFont(mediumFont);
//        lg.setFont(mediumFont);
//        lc.setFont(mediumFont);
//        lt.setFont(mediumFont);
//        tn.setFont(mediumFont);
//        ta.setFont(mediumFont);
//        tg.setFont(mediumFont);
//        tc.setFont(mediumFont);
//        tt.setFont(mediumFont);
        pf.add(ln);
        pf.add(tn);
        pf.add(la);
        pf.add(ta);
        pf.add(lg);
        pf.add(tg);
        pf.add(lc);
        pf.add(tc);
        pf.add(lt);
        pf.add(tt);
        JButton done = new JButton("Done");
        done.setBounds(150, 600, 100, 70);
        pf.add(done, BorderLayout.SOUTH);
        form.getContentPane().add(pf);
    }

}
