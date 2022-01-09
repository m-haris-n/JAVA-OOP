package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.List;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class FormulaOneChamps {

    static F1CM f1CM = new F1CM();


    public static String[][] getDrivers(ArrayList<FormulaDriver> allDriv) {
        String[][] drivers = new String[allDriv.size()][7];
        for (int i = 0; i < allDriv.size(); i++) {
            ArrayList<String> drivStats = allDriv.get(i).getDriverData();
            String[] drivData = new String[7];
            for (int j = 0; j < 7; j++) {
                drivData[j] = drivStats.get(j);
            }
            drivers[i] = drivData;
        }
        return drivers;
    }


    public static String[][] getRaceStats(ArrayList<FormulaDriver> allDriv) {
        allDriv.sort(Comparator.comparing(FormulaDriver::getCurrentPos));
        String[][] drivers = new String[allDriv.size()][6];
        for (int i = 0; i < allDriv.size(); i++) {
            ArrayList<String> drivStats = allDriv.get(i).getDriverData();
            String[] drivData = new String[6];
            for (int j = 0; j < 4; j++) {
                drivData[j] = drivStats.get(j);
            }
            drivData[4] = drivStats.get(7);
            drivData[5] = drivStats.get(8);
            drivers[i] = drivData;
        }
        return drivers;
    }

    public static String[][] getHistory(HashMap<LocalDate, String> hist) {
        int j = 0;
        String[][] history = new String[hist.keySet().size()][2];
        TreeMap<LocalDate, String> sorted = new TreeMap<>(hist);
        ArrayList<LocalDate> dates = new ArrayList(sorted.keySet());
        ArrayList<String> winners = new ArrayList(sorted.values());
        for (int i = winners.size() - 1; i >= 0; i--) {
            history[j][0] = dates.get(i).toString();
            history[j][1] = winners.get(i);
            j++;
        }
        return history;
    }

    public static FormulaDriver searchDriver(String name, ArrayList<FormulaDriver> drivers) {
        System.out.println(name.toUpperCase(Locale.ROOT));
        for (FormulaDriver d: drivers){
            if(Objects.equals(d.getName(), name.toUpperCase(Locale.ROOT))){
                System.out.println("result: "+ d);
                return d;
            }
        }
        return null;
    }


    public static void main(String[] args) throws FileNotFoundException {

        f1CM.posToPtsInit();
        f1CM.winProbInit();
        ArrayList<Object> allData = FileWriteAndRead.fileReader();
        f1CM.setDrivers((ArrayList<FormulaDriver>) allData.get(0));
        f1CM.setTeams((ArrayList<CarCons>) allData.get(1));
        f1CM.setRaceOrder(DateWriteAndRead.fileReader());
        System.out.println(f1CM.getRaceOrder());
        Set<LocalDate> allDates = f1CM.getRaceOrder().keySet();
        List<LocalDate> dateArr = new ArrayList<>(allDates);
        if (dateArr.size() != 0) {
            LocalDate latest = dateArr.stream().max(LocalDate::compareTo).get();
            f1CM.setDate(latest);
            f1CM.incDate(7);
        } else {
            LocalDate.of(2021, Month.JANUARY, 1);
        }

        ArrayList<FormulaDriver> allDrivers = f1CM.getDriversForGUI(f1CM.getDrivers());
        System.out.println(allDrivers);
        String[][] drivers = getDrivers(allDrivers);
        String[][] raceHistory = getHistory(f1CM.getRaceOrder());


        JFrame frame = new JFrame();

        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.setBackground(Color.blue);
        p1.setSize(900, 50);
        Font largeFont = new Font("TimesRoman", Font.BOLD, 50);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        JLabel l = new JLabel("                       FORMULA 1 CHAMPIONSHIP                        ");
        l.setBounds(20, 0, 550, 50);
        l.setForeground(Color.WHITE);
        l.setFont(largeFont);
        p1.setBorder(blackline);
        p1.add(l);
        frame.add(p1, BorderLayout.NORTH);


        JButton i1 = new JButton("   RACE   ");

        JButton i2 = new JButton("   REAL RACE");

        JButton i3 = new JButton("   HISTORY   ");
        JButton i4 = new JButton("   SEARCH  ");
        JTextField t = new JTextField(12);
        Font mediumFont = new Font("TimesRoman", Font.PLAIN, 20);
        i1.setPreferredSize(new Dimension(170, 30));
        i2.setPreferredSize(new Dimension(170, 30));
        i3.setPreferredSize(new Dimension(170, 30));
        i4.setPreferredSize(new Dimension(170, 30));
        t.setPreferredSize(new Dimension(400, 30));
        i1.setFont(mediumFont);
        i2.setFont(mediumFont);
        i3.setFont(mediumFont);
        i4.setFont(mediumFont);
        t.setFont(mediumFont);

        frame.add(i1);
        frame.add(i2);
        frame.add(i3);
        frame.add(t);
        frame.add(i4);


        JPanel p22 = new JPanel();
        p22.setMaximumSize(new Dimension(700, 100));
        p22.setLayout(new FlowLayout());
        p22.setLayout(new GridLayout(1, 2, 3, 3));
        JButton addDriv = new JButton("  Add Driver  ");
        JButton deleteDriv = new JButton("  Delete Driver ");
        addDriv.setPreferredSize(new Dimension(250, 30));
        deleteDriv.setPreferredSize(new Dimension(250, 30));
        addDriv.setFont(mediumFont);
        deleteDriv.setFont(mediumFont);
        JButton i5 = new JButton("  Sort By Scores  ");
        JButton i6 = new JButton("  Sort by 1st Positions ");
        i5.setPreferredSize(new Dimension(250, 30));
        i6.setPreferredSize(new Dimension(250, 30));
        i5.setFont(mediumFont);
        i6.setFont(mediumFont);
        p22.add(addDriv);
        p22.add(deleteDriv);
        p22.add(i5);
        p22.add(i6);
        frame.add(p22);

        JPanel p3 = new JPanel();
        p3.setPreferredSize(new Dimension(1170, 500));
        p3.setBackground(Color.LIGHT_GRAY);
        String[] column = {"Name", "Age", "Country", "Team", "Score", "No. of 1st Positions", "No. of races"};

        JTable table = new JTable(drivers, column);
        Font headerFont = new Font("Rubik", Font.BOLD, 20);
        table.setBounds(100, 50, 100, 50);
        table.setRowHeight(30);
        table.setFont(new Font("Roman", Font.PLAIN, 22));
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setBackground(Color.black);
        tableHeader.setForeground(Color.white);
        tableHeader.setFont(headerFont);
        JScrollPane scroll = new JScrollPane(table);

        p3.setLayout(new GridLayout(1, 1));
        p3.add(scroll, BorderLayout.CENTER);
        scroll.setLayout(new ScrollPaneLayout());
        frame.add(p3);

        frame.setLayout(new FlowLayout());
        frame.setSize(1200, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

        // EVENT HANDLING

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

                try {
                    FileWriteAndRead.fileWriter(f1CM.getDrivers());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                try {
                    DateWriteAndRead.fileWriter(f1CM.getRaceOrder());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        i5.addActionListener(new SortByScoreAction(table, f1CM.getDriversPosOrdered(f1CM.getDrivers()), column));
        i6.addActionListener(new SortByPosAction(table, f1CM.getDriversPosOrdered(f1CM.getDrivers()), column));

//      -------------- RACE WINDOW -----------------------

        JFrame frame2 = new JFrame();
        frame2.setVisible(false);
        frame2.setSize(1100, 500);
        frame2.setLayout(new FlowLayout());
        frame2.setLocationRelativeTo(frame);
        frame2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel race1 = new JPanel();
        race1.setLayout(new FlowLayout());
        race1.setPreferredSize(new Dimension(1000, 70));
        JLabel race = new JLabel("                RACE                 ");
        race.setFont(largeFont);
        race.setBounds(20, 0, 1000, 50);
        race.setForeground(Color.DARK_GRAY);
        race1.setBackground(Color.LIGHT_GRAY);
        race1.setBorder(blackline);
        race1.add(race);
        frame2.add(race1);

        JPanel race2 = new JPanel();
        race2.setPreferredSize(new Dimension(1000, 360));
        race2.setBackground(Color.gray);
        race2.setLayout(new GridLayout(1, 1));


        String[] column2 = {"Name", "Country", "Team", "Score", "Starting Positions", "Current Position"};
        String[][] data2 = getRaceStats(f1CM.getDrivers());

        JTable table2 = new JTable(data2, column2);
        table2.setBounds(100, 50, 100, 50);
        table2.setRowHeight(30);
        table2.setFont(new Font("Roman", Font.PLAIN, 22));
        JTableHeader tableHeader2 = table2.getTableHeader();
        tableHeader2.setBackground(Color.black);
        tableHeader2.setForeground(Color.white);
        Font headerFont2 = new Font("Rubik", Font.BOLD, 20);
        tableHeader2.setFont(headerFont2);
        JScrollPane scroll2 = new JScrollPane(table2);
        scroll2.setLayout(new ScrollPaneLayout());
        race2.add(scroll2);
        frame2.add(race2);

        //EVENT HANDLING

        i1.addActionListener(e -> {
            if (f1CM.getDrivers().size()>=10){
                f1CM.race();
                String[][] latestData = getRaceStats(f1CM.getDrivers());
                table2.setModel(new DefaultTableModel(latestData, column2));
                frame2.setVisible(true);
            }
            else {
                JFrame popUp = new JFrame();
                popUp.setSize(300,200);
                popUp.add(new JLabel("Need 10 or more drivers to race"));
                popUp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                popUp.setVisible(true);
            }
        });
        i2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (f1CM.getDrivers().size() >=10){
                    f1CM.weightedRace();
                    String[][] latestData = getRaceStats(f1CM.getDrivers());
                    table2.setModel(new DefaultTableModel(latestData, column2));
                    frame2.setVisible(true);
                }
                else {
                    JFrame popUp = new JFrame();
                    popUp.setSize(300,200);
                    popUp.add(new JLabel("Need 10 or more drivers to race"));
                    popUp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    popUp.setVisible(true);
                }
            }
        });
        frame2.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                String[][] data = getDrivers(f1CM.getDriversForGUI(f1CM.getDrivers()));
                DefaultTableModel tm = new DefaultTableModel(data, column);
                table.setModel(tm);

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });


//      ................... RACE HISTORY................

        JFrame frame3 = new JFrame();
        frame3.setVisible(false);
        frame3.setSize(1100, 500);
        frame3.setLayout(new FlowLayout());
        frame3.setLocationRelativeTo(frame);
        frame3.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel history = new JPanel();
        history.setLayout(new FlowLayout());
        history.setPreferredSize(new Dimension(1000, 70));
        JLabel hist = new JLabel("                HISTORY                 ");
        hist.setFont(largeFont);
        hist.setBounds(20, 0, 1000, 50);
        hist.setForeground(Color.white);
        history.setBackground(Color.black);
        history.setBorder(blackline);
        history.add(hist);
        frame3.add(history);

        JPanel history1 = new JPanel();
        history1.setPreferredSize(new Dimension(1000, 360));
        history1.setBackground(Color.gray);
        history1.setLayout(new GridLayout(1, 1));

        String[] column3 = {"DATE", "WINNER"};

        JTable table3 = new JTable(raceHistory, column3);
        table3.setBounds(100, 50, 100, 50);
        table3.setRowHeight(30);
        table3.setFont(new Font("Roman", Font.PLAIN, 22));
        JTableHeader tableHeader3 = table3.getTableHeader();
        tableHeader3.setBackground(Color.black);
        tableHeader3.setForeground(Color.white);
        Font headerFont3 = new Font("Rubik", Font.BOLD, 20);
        tableHeader3.setFont(headerFont3);
        JScrollPane scroll3 = new JScrollPane(table3);
        scroll3.setLayout(new ScrollPaneLayout());
        history1.add(scroll3);
        frame3.add(history1);
        frame3.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JFrame searchBox = new JFrame("Search Result");
        searchBox.setSize(500,500);
        JPanel text = new JPanel(new GridLayout(7,2));
        searchBox.add(text);
        String srchTxt;


        i4.addActionListener(e -> {
            searchBox.setVisible(true);
            System.out.println();
        });
        searchPlayer sp = new searchPlayer(f1CM.getDrivers(), t, text);
        i4.addActionListener(sp);
        searchBox.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        i3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[][] data = FormulaOneChamps.getHistory(f1CM.getRaceOrder());
                DefaultTableModel tm = new DefaultTableModel(data, column3);
                table3.setModel(tm);
                frame3.setVisible(true);
            }
        });

        // ADD DRIVER FORM

        JFrame form = new JFrame();
        form.setSize(450, 500);
        form.setLayout(new FlowLayout());
        form.setLocationRelativeTo(frame);
        form.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel pf = new JPanel();
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
        ln.setFont(mediumFont);
        la.setFont(mediumFont);
        lg.setFont(mediumFont);
        lc.setFont(mediumFont);
        lt.setFont(mediumFont);
        tn.setFont(mediumFont);
        ta.setFont(mediumFont);
        tg.setFont(mediumFont);
        tc.setFont(mediumFont);
        tt.setFont(mediumFont);
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

        //EVENT HANDLING

        addDriv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                form.setVisible(true);
            }
        });
        done.addActionListener(new addDriver(form, tn, ta, tc, tg, tt));
        form.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                String[][] data = getDrivers(f1CM.getDriversForGUI(f1CM.getDrivers()));
                DefaultTableModel tm = new DefaultTableModel(data, column);
                table.setModel(tm);
            }
        });

        // DELTE POPUP

        JFrame dltFrm = new JFrame();
        dltFrm.setSize(450, 200);
        dltFrm.setLayout(new FlowLayout());
        dltFrm.setLocationRelativeTo(frame);
        dltFrm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel dltPn = new JPanel();
        dltPn.setLayout(new GridLayout(2, 2, 5, 5));
        dltPn.setPreferredSize(new Dimension(400, 100));

        JLabel nm = new JLabel("Name:");
        nm.setFont(mediumFont);
        JTextField nmFld = new JTextField();
        nmFld.setBounds(10, 0, 200, 50);
        JButton dlt = new JButton("Delete");
        dlt.setFont(mediumFont);
        nm.setFont(mediumFont);
        nmFld.setFont(mediumFont);
        dlt.setBounds(150, 50, 100, 50);
        dltPn.add(nm);
        dltPn.add(nmFld);
        dltPn.add(new JLabel(""));
        dltPn.add(dlt, BorderLayout.NORTH);
        dltFrm.add(dltPn);

        // EVENT HANDLING

        dlt.addActionListener(new deleteDriver(frame, nmFld));
        dlt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dltFrm.setVisible(false);
            }
        });

        dltFrm.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                String[][] data = getDrivers(f1CM.getDriversForGUI(f1CM.getDrivers()));
                DefaultTableModel tm = new DefaultTableModel(data, column);
                table.setModel(tm);

            }
        });
        deleteDriv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dltFrm.setVisible(true);
            }
        });
    }



}

class SortByPosAction implements ActionListener {
    JTable t;
    ArrayList<FormulaDriver> drivers;
    String[][] data;
    String[] column;

    public JTable getT() {
        return t;
    }

    public void setT(JTable t) {
        this.t = t;
    }


    public ArrayList<FormulaDriver> getDrivers() {
        return drivers;
    }

    public void setDrivers(ArrayList<FormulaDriver> drivers) {
        this.drivers = drivers;
    }

    public SortByPosAction(JTable t, ArrayList<FormulaDriver> drivers, String[] col) {
        this.t = t;
        this.drivers = drivers;
        this.column = col;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        drivers = FormulaOneChamps.f1CM.getDriversPosOrdered(drivers);
        data = FormulaOneChamps.getDrivers(this.drivers);
        DefaultTableModel tm = new DefaultTableModel(data, column);
        t.setModel(tm);
    }


}


class SortByScoreAction implements ActionListener {
    JTable t;
    ArrayList<FormulaDriver> drivers;
    String[][] data;
    String[] column;

    public JTable getT() {
        return t;
    }

    public void setT(JTable t) {
        this.t = t;
    }


    public ArrayList<FormulaDriver> getDrivers() {
        return drivers;
    }

    public void setDrivers(ArrayList<FormulaDriver> drivers) {
        this.drivers = drivers;
    }

    public SortByScoreAction(JTable t, ArrayList<FormulaDriver> drivers, String[] col) {
        this.t = t;
        this.drivers = drivers;
        this.column = col;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        drivers = FormulaOneChamps.f1CM.getDriversForGUI(drivers);
        data = FormulaOneChamps.getDrivers(this.drivers);
        DefaultTableModel tm = new DefaultTableModel(data, column);
        t.setModel(tm);
    }


}


class searchPlayer implements ActionListener {
    ArrayList<FormulaDriver> drivers;
    JTextField name;
    JPanel p;


    public ArrayList<FormulaDriver> getDrivers() {
        return drivers;
    }

    public void setDrivers(ArrayList<FormulaDriver> drivers) {
        this.drivers = drivers;
    }

    public searchPlayer(ArrayList<FormulaDriver> drivers, JTextField name, JPanel t){
        this.drivers = drivers;
        this.name = name;
        this.p = t;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(this.name);
        FormulaDriver driver = FormulaOneChamps.searchDriver(this.name.getText().trim(), this.drivers);
        p.removeAll();
        if(driver!=null){
            p.add(new JLabel("Name: "));
            p.add(new JLabel(driver.getName()));
            p.add(new JLabel("Age: "));
            p.add(new JLabel(String.valueOf(driver.getAge())));
            p.add(new JLabel("Gender: "));
            p.add(new JLabel(driver.getGender()));
            p.add(new JLabel("Country "));
            p.add(new JLabel(driver.getCountry()));
            p.add(new JLabel("Team: "));
            p.add(new JLabel(driver.getTeam().getName()));
            p.add(new JLabel("Score: "));
            p.add(new JLabel(String.valueOf(driver.getScore())));
            p.add(new JLabel("Num of 1st Pos: "));
            p.add(new JLabel(String.valueOf(driver.getPos()[0])));
        }
        else {
            p.add(new JLabel("No Drivers Found."));
        }
    }


}


class addDriver implements ActionListener{
    JTextField name;
    JTextField age;
    JTextField country;
    JTextField gender;
    JTextField team;
    JFrame form;

    public addDriver(JFrame f, JTextField name, JTextField age, JTextField country, JTextField gender, JTextField team) {
        this.form = f;
        this.name = name;
        this.age = age;
        this.country = country;
        this.gender = gender;
        this.team = team;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean nmVld = !name.getText().isEmpty();
        boolean cntrVld = !country.getText().isEmpty();
        boolean gndrVld = !gender.getText().isEmpty();
        boolean tmVld = !team.getText().isEmpty();
        boolean ageVld = isNumeric(this.age.getText());
        if (nmVld && cntrVld && gndrVld && tmVld && ageVld){
            String name = this.name.getText();
            String cntry = this.country.getText();
            String gndr = this.gender.getText();
            String team = this.team.getText();
            int age = Integer.parseInt(this.age.getText());
            FormulaOneChamps.f1CM.addDriver(name, age, cntry, gndr, new CarCons(team));
        }
        else {
            JFrame popUp = new JFrame();
            popUp.setSize(300,200);
            popUp.add(new JLabel("Input Invalid"));
            popUp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            popUp.setVisible(true);
        }
        name.setText("");
        country.setText("");
        gender.setText("");
        age.setText("");
        team.setText("");
        this.form.setVisible(false);
    }

    public boolean isNumeric(String num){
        try {
            if (!num.isEmpty()){
                int number = Integer.parseInt(num);
            }
            else return false;
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}

class deleteDriver implements ActionListener{
    JFrame f;
    JTextField name;

    public deleteDriver(JFrame f, JTextField name) {
        this.f = f;
        this.name = name;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isNameNotEmpty() && isNamePresent()){
            System.out.println(this.name.getText());
            FormulaOneChamps.f1CM.removeDriver(this.name.getText());
        }else {
            JFrame popUp = new JFrame();
            popUp.setSize(300,200);
            popUp.add(new JLabel("No such drivers"));
            popUp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            popUp.setVisible(true);

        }
        name.setText("");

    }
    public boolean isNamePresent(){
        if (isNameNotEmpty()){
            FormulaDriver driver = FormulaOneChamps.searchDriver(this.name.getText().trim(), FormulaOneChamps.f1CM.drivers);
            return driver != null;
        }else return false;
    }
    public boolean isNameNotEmpty(){
        return !this.name.getText().isEmpty();
    }
}