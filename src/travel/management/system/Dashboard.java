package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener {

    JButton personalDetails, updatePersonalDetails, viewPersonalDetails, deletePersonalDetails, checkPackages, bookPackages, viewPackages, viewHotels;
    JButton bookHotels, viewBookedHotels, destinations, Payments, calculators, notepad, about;
    String username;

    Dashboard(String username) {
        this.username = username;
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 1600, 65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(5, 0, 70, 70);
        p1.add(image);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Tahoma", Font.BOLD, 35));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 40, 102));
        p2.setBounds(0, 65, 300, 900);
        add(p2);

        personalDetails = new JButton("Add Personal Details");
        personalDetails.setBounds(0, 0, 300, 50);
        personalDetails.setBackground(new Color(0, 0, 102));
        personalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        personalDetails.setMargin(new Insets(0, 0, 0, 60));
        personalDetails.setForeground(Color.white);
        personalDetails.addActionListener(this);
        p2.add(personalDetails);

        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0, 50, 300, 50);
        updatePersonalDetails.setBackground(new Color(0, 0, 102));
        updatePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        updatePersonalDetails.setMargin(new Insets(0, 0, 0, 40));
        updatePersonalDetails.setForeground(Color.white);
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);

        viewPersonalDetails = new JButton("View Personal Details");
        viewPersonalDetails.setBounds(0, 100, 300, 50);
        viewPersonalDetails.setBackground(new Color(0, 0, 102));
        viewPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewPersonalDetails.setForeground(Color.white);
        viewPersonalDetails.setMargin(new Insets(0, 0, 0, 60));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);

        deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0, 150, 300, 50);
        deletePersonalDetails.setBackground(new Color(0, 0, 102));
        deletePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        deletePersonalDetails.setForeground(Color.white);
        deletePersonalDetails.setMargin(new Insets(0, 0, 0, 50));
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);

        checkPackages = new JButton("Check Packages");
        checkPackages.setBounds(0, 200, 300, 50);
        checkPackages.setBackground(new Color(0, 0, 102));
        checkPackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkPackages.setForeground(Color.white);
        checkPackages.setMargin(new Insets(0, 0, 0, 110));
        checkPackages.addActionListener(this);
        p2.add(checkPackages);

        bookPackages = new JButton("Book Package");
        bookPackages.setBounds(0, 250, 300, 50);
        bookPackages.setBackground(new Color(0, 0, 102));
        bookPackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookPackages.setForeground(Color.white);
        bookPackages.setMargin(new Insets(0, 0, 0, 130));
        bookPackages.addActionListener(this);
        p2.add(bookPackages);

        viewPackages = new JButton("View Package");
        viewPackages.setBounds(0, 300, 300, 50);
        viewPackages.setBackground(new Color(0, 0, 102));
        viewPackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewPackages.setForeground(Color.white);
        viewPackages.setMargin(new Insets(0, 0, 0, 130));
        viewPackages.addActionListener(this);
        p2.add(viewPackages);

        viewHotels = new JButton("View Hotels");
        viewHotels.setBounds(0, 350, 300, 50);
        viewHotels.setBackground(new Color(0, 0, 102));
        viewHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewHotels.setForeground(Color.white);
        viewHotels.setMargin(new Insets(0, 0, 0, 150));
        viewHotels.addActionListener(this);
        p2.add(viewHotels);

        bookHotels = new JButton("Book Hotel");
        bookHotels.setBounds(0, 400, 300, 50);
        bookHotels.setBackground(new Color(0, 0, 102));
        bookHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookHotels.setForeground(Color.white);
        bookHotels.setMargin(new Insets(0, 0, 0, 150));
        bookHotels.addActionListener(this);
        p2.add(bookHotels);

        viewBookedHotels = new JButton("View Booked Hotel");
        viewBookedHotels.setBounds(0, 450, 300, 50);
        viewBookedHotels.setBackground(new Color(0, 0, 102));
        viewBookedHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewBookedHotels.setForeground(Color.white);
        viewBookedHotels.setMargin(new Insets(0, 0, 0, 80));
        viewBookedHotels.addActionListener(this);
        p2.add(viewBookedHotels);

        destinations = new JButton("Destinations");
        destinations.setBounds(0, 500, 300, 50);
        destinations.setBackground(new Color(0, 0, 102));
        destinations.setFont(new Font("Tahoma", Font.PLAIN, 20));
        destinations.setForeground(Color.white);
        destinations.setMargin(new Insets(0, 0, 0, 140));
        destinations.addActionListener(this);
        p2.add(destinations);

        Payments = new JButton("Payments");
        Payments.setBounds(0, 550, 300, 50);
        Payments.setBackground(new Color(0, 0, 102));
        Payments.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Payments.setForeground(Color.white);
        Payments.setMargin(new Insets(0, 0, 0, 160));
        Payments.addActionListener(this);
        p2.add(Payments);

        calculators = new JButton("Calculator");
        calculators.setBounds(0, 600, 300, 50);
        calculators.setBackground(new Color(0, 0, 102));
        calculators.setFont(new Font("Tahoma", Font.PLAIN, 20));
        calculators.setForeground(Color.white);
        calculators.setMargin(new Insets(0, 0, 0, 160));
        calculators.addActionListener(this);
        p2.add(calculators);

        notepad = new JButton("Notepad");
        notepad.setBounds(0, 650, 300, 50);
        notepad.setBackground(new Color(0, 0, 102));
        notepad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        notepad.setForeground(Color.white);
        notepad.setMargin(new Insets(0, 0, 0, 170));
        notepad.addActionListener(this);
        p2.add(notepad);

        about = new JButton("About");
        about.setBounds(0, 700, 300, 50);
        about.setBackground(new Color(0, 0, 102));
        about.setFont(new Font("Tahoma", Font.PLAIN, 20));
        about.setForeground(Color.white);
        about.setMargin(new Insets(0, 0, 0, 190));
        about.addActionListener(this);
        p2.add(about);

        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i6 = i5.getImage().getScaledInstance(1350, 935, Image.SCALE_DEFAULT);
        ImageIcon i7 = new ImageIcon(i6);
        JLabel image1 = new JLabel(i7);
        image1.setBounds(300, 65, 1350, 935);
        add(image1);

        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(150, 70, 1000, 70);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway", Font.BOLD, 50));
        image1.add(text);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == personalDetails) {

            new AddCustomer(username);
        } else if (ae.getSource() == viewPersonalDetails) {

            new ViewCustomer(username);
        } else if (ae.getSource() == updatePersonalDetails) {

            new UpdateCustomer(username);
        } else if (ae.getSource() == checkPackages) {

            new CheckPackage();
        } else if (ae.getSource() == bookPackages) {

            new BookPackage(username);
        } else if (ae.getSource() == viewPackages) {

            new ViewPackage(username);
        } else if (ae.getSource() == viewHotels) {

            new CheckHotels();
        } else if (ae.getSource() == destinations) {

            new ViewDestinations();
        } else if (ae.getSource() == bookHotels) {

            new BookHotel(username);
        } else if (ae.getSource() == viewBookedHotels) {

            new ViewBookedHotel(username);
        } else if (ae.getSource() == Payments) {

            new Payment();
        } else if (ae.getSource() == calculators) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == notepad) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == about) {

            new About();
        } else if (ae.getSource() == deletePersonalDetails) {

            new DeleteDetails(username);
        }

    }

}
