package travel.management.system;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class CheckPackage extends JFrame {

    String[] package1 = {"GOLD PACKAGE", "6 Days and 7 Nights", "Airport Assistance", "Half Day City Tour", "Daily Buffet", "Welcome Drinks on Arrival", "Full-Day 3 Is-land Cruise", "English Speaking Guide", "BOOK NOW", "Summer Special", "Rs. 1200/-", "icons/package1.jpg"};
    String[] package2 = {"SILVER PACKAGE", "5 Days and 5 Nights", "Toll-Free Entrance free tickets", "Meet and Greet at Airport", "Free drinks and lunch", "Welcome Drinks on Arrival", "Night safary", "Dinner", "BOOK NOW", "Summer Special", "Rs. 1000/-", "icons/package2.jpg"};
    String[] package3 = {"BRONZE PACKAGE", "4 Days and 4 Nights", "Return Airfare", "Games-horse riding/clubbing", "Lunch", "Welcome Drinks on Arrival", "Daily Buffet", "BBQ Dinner", "BOOK NOW", "Summer Special", "Rs. 900/-", "icons/package2.jpg"};

    CheckPackage() {
//        setLayout(null);
//        getContentPane().setBackground(Color.white);
        setBounds(450, 200, 900, 600);

        JTabbedPane tab = new JTabbedPane();

        JPanel p1 = createPackage(package1);
        JPanel p2 = createPackage(package2);
        JPanel p3 = createPackage(package3);

        tab.addTab("Gold Package", null, p1);
        tab.addTab("Silver Package", null, p2);
        tab.addTab("Bronze Package", null, p3);
        add(tab);

        setVisible(true);
    }

    public JPanel createPackage(String[] pack) {
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.white);
        add(p1);
        JLabel l1 = new JLabel(pack[0]);
        l1.setBounds(30, 5, 300, 30);
        l1.setForeground(Color.YELLOW);
        l1.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(l1);

        JLabel l2 = new JLabel(pack[1]);
        l2.setBounds(30, 60, 300, 30);
        l2.setForeground(Color.RED);
        l2.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l2);

        JLabel l3 = new JLabel(pack[2]);
        l3.setBounds(30, 110, 300, 30);
        l3.setForeground(Color.BLUE);
        l3.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l3);

        JLabel l4 = new JLabel(pack[3]);
        l4.setBounds(30, 160, 300, 30);
        l4.setForeground(Color.RED);
        l4.setFont(new Font("Raleway", Font.BOLD, 20));
        p1.add(l4);

        JLabel l5 = new JLabel(pack[4]);
        l5.setBounds(30, 210, 300, 30);
        l5.setForeground(Color.BLUE);
        l5.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l5);

        JLabel l6 = new JLabel(pack[5]);
        l6.setBounds(30, 260, 300, 30);
        l6.setForeground(Color.RED);
        l6.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l6);

        JLabel l7 = new JLabel(pack[6]);
        l7.setBounds(30, 310, 300, 30);
        l7.setForeground(Color.BLUE);
        l7.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l7);

        JLabel l8 = new JLabel(pack[7]);
        l8.setBounds(30, 360, 300, 30);
        l8.setForeground(Color.RED);
        l8.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(l8);

        JLabel l9 = new JLabel(pack[8]);
        l9.setBounds(60, 430, 300, 30);
        l9.setForeground(Color.BLACK);
        l9.setFont(new Font("Consolas", Font.BOLD, 25));
        p1.add(l9);

        JLabel l10 = new JLabel(pack[9]);
        l10.setBounds(80, 480, 300, 30);
        l10.setForeground(Color.MAGENTA);
        l10.setFont(new Font("Consolas", Font.BOLD, 25));
        p1.add(l10);

        JLabel l11 = new JLabel(pack[10]);
        l11.setBounds(500, 500, 300, 30);
        l11.setForeground(Color.CYAN);
        l11.setFont(new Font("Consolas", Font.BOLD, 25));
        p1.add(l11);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(pack[11]));
        Image i2 = i1.getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(350, 40, 500, 350);
        p1.add(image1);

        return p1;
    }

    public static void main(String args[]) {
        CheckPackage checkPackage = new CheckPackage();
    }
}
