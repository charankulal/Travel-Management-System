package travel.management.system;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewBookedHotel extends JFrame implements ActionListener {

    JButton back;
    String username;

    ViewBookedHotel(String username) {
        this.username = username;
        setBounds(400, 200, 1000, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("View Booked Hotel Details");
        text.setBounds(60, 5, 300, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel usernamelbl = new JLabel("Username :");
        usernamelbl.setBounds(30, 50, 150, 25);
        usernamelbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(usernamelbl);

        JLabel usernamelabel = new JLabel("");
        usernamelabel.setBounds(220, 50, 150, 25);
        usernamelabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        usernamelabel.setForeground(Color.red);
        add(usernamelabel);

        JLabel hotellbl = new JLabel("Hotel Name :");
        hotellbl.setBounds(30, 90, 150, 25);
        hotellbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(hotellbl);

        JLabel hotellabel = new JLabel("");
        hotellabel.setBounds(220, 90, 150, 25);
        hotellabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        hotellabel.setForeground(Color.red);
        add(hotellabel);

        JLabel totalperonslbl = new JLabel("Total Persons :");
        totalperonslbl.setBounds(30, 130, 150, 25);
        totalperonslbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(totalperonslbl);

        JLabel totalperonslabel = new JLabel("");
        totalperonslabel.setBounds(220, 130, 150, 25);
        totalperonslabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        totalperonslabel.setForeground(Color.red);
        add(totalperonslabel);
        
        JLabel dayslbl = new JLabel("Total Days :");
        dayslbl.setBounds(30, 170, 150, 25);
        dayslbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(dayslbl);

        JLabel dayslabel = new JLabel("");
        dayslabel.setBounds(220, 170, 150, 25);
        dayslabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        dayslabel.setForeground(Color.red);
        add(dayslabel);
        
        JLabel aclbl = new JLabel("Ac/Non-AC :");
        aclbl.setBounds(30, 210, 150, 25);
        aclbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(aclbl);

        JLabel aclabel = new JLabel("");
        aclabel.setBounds(220, 210, 150, 25);
        aclabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        aclabel.setForeground(Color.red);
        add(aclabel);
        
        JLabel foodlbl = new JLabel("Food Included? :");
        foodlbl.setBounds(30, 250, 150, 25);
        foodlbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(foodlbl);

        JLabel foodlabel = new JLabel("");
        foodlabel.setBounds(220, 250, 150, 25);
        foodlabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        foodlabel.setForeground(Color.red);
        add(foodlabel);

        JLabel idlbl = new JLabel("ID :");
        idlbl.setBounds(30, 290, 150, 25);
        idlbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(idlbl);

        JLabel idlabel = new JLabel("");
        idlabel.setBounds(220, 290, 150, 25);
        idlabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        idlabel.setForeground(Color.red);
        add(idlabel);

        JLabel numberlbl = new JLabel("Number :");
        numberlbl.setBounds(30, 330, 150, 25);
        numberlbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(numberlbl);

        JLabel numberlabel = new JLabel("");
        numberlabel.setBounds(220, 330, 150, 25);
        numberlabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        numberlabel.setForeground(Color.red);
        add(numberlabel);

        JLabel phonelbl = new JLabel("Phone :");
        phonelbl.setBounds(30, 370, 150, 25);
        phonelbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(phonelbl);

        JLabel phonelabel = new JLabel("");
        phonelabel.setBounds(220, 370, 150, 25);
        phonelabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        phonelabel.setForeground(Color.red);
        add(phonelabel);

        JLabel pricelbl = new JLabel("Total Price :");
        pricelbl.setBounds(30, 410, 150, 25);
        pricelbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(pricelbl);

        JLabel pricelabel = new JLabel("");
        pricelabel.setBounds(220, 410, 150, 25);
        pricelabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        pricelabel.setForeground(Color.red);
        add(pricelabel);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(130, 490, 100, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i6 = i5.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i7 = new ImageIcon(i6);
        JLabel image1 = new JLabel(i7);
        image1.setBounds(400, 10, 450, 400);
        add(image1);

       

        try {
            Connectivity c = new Connectivity();
            String query = "select * from bookhotel where username ='" + username + "'";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {
                usernamelabel.setText(rs.getString("username"));
                idlabel.setText(rs.getString("id"));
                numberlabel.setText(rs.getString("number"));
                hotellabel.setText(rs.getString("name"));
                pricelabel.setText(rs.getString("price"));
                totalperonslabel.setText(rs.getString("persons"));
                dayslabel.setText(rs.getString("days"));
                foodlabel.setText(rs.getString("food"));
                aclabel.setText(rs.getString("ac"));
                
                phonelabel.setText(rs.getString("phone"));
               
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);

    }
    
   

    
}
