package travel.management.system;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewCustomer extends JFrame implements ActionListener {

    JButton back;
    String username;

    ViewCustomer(String username) {
        this.username = username;
        setBounds(400, 160, 870, 625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel usernamelbl = new JLabel("Username :");
        usernamelbl.setBounds(30, 50, 150, 25);
        usernamelbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(usernamelbl);

        JLabel usernamelabel = new JLabel("");
        usernamelabel.setBounds(220, 50, 150, 25);
        usernamelabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        usernamelabel.setForeground(Color.red);
        add(usernamelabel);

        JLabel idlbl = new JLabel("Id :");
        idlbl.setBounds(30, 110, 150, 25);
        idlbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(idlbl);

        JLabel idlabel = new JLabel("");
        idlabel.setBounds(220, 110, 150, 25);
        idlabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        idlabel.setForeground(Color.red);
        add(idlabel);

        JLabel numberlbl = new JLabel("Number :");
        numberlbl.setBounds(30, 170, 150, 25);
        numberlbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(numberlbl);

        JLabel numberlabel = new JLabel("");
        numberlabel.setBounds(220, 170, 150, 25);
        numberlabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        numberlabel.setForeground(Color.red);
        add(numberlabel);

        JLabel namelbl = new JLabel("Name :");
        namelbl.setBounds(30, 230, 150, 25);
        namelbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(namelbl);

        JLabel namelabel = new JLabel("");
        namelabel.setBounds(220, 230, 150, 25);
        namelabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        namelabel.setForeground(Color.red);
        add(namelabel);

        JLabel genderlbl = new JLabel("Gender :");
        genderlbl.setBounds(30, 290, 150, 25);
        genderlbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(genderlbl);

        JLabel genderlabel = new JLabel("");
        genderlabel.setBounds(220, 290, 150, 25);
        genderlabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        genderlabel.setForeground(Color.red);
        add(genderlabel);

        JLabel countrylbl = new JLabel("Country :");
        countrylbl.setBounds(435, 50, 150, 25);
        countrylbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(countrylbl);

        JLabel countrylabel = new JLabel("");
        countrylabel.setBounds(625, 50, 150, 25);
        countrylabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        countrylabel.setForeground(Color.red);
        add(countrylabel);

        JLabel addresslbl = new JLabel("Address :");
        addresslbl.setBounds(435, 110, 150, 25);
        addresslbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(addresslbl);

        JLabel addresslabel = new JLabel("");
        addresslabel.setBounds(625, 110, 150, 25);
        addresslabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        addresslabel.setForeground(Color.red);
        add(addresslabel);

        JLabel phonelbl = new JLabel("Phone :");
        phonelbl.setBounds(435, 170, 150, 25);
        phonelbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(phonelbl);

        JLabel phonelabel = new JLabel("");
        phonelabel.setBounds(625, 170, 150, 25);
        phonelabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        phonelabel.setForeground(Color.red);
        add(phonelabel);

        JLabel emaillbl = new JLabel("Email :");
        emaillbl.setBounds(435, 230, 150, 25);
        emaillbl.setFont(new Font("Times New Roman", Font.BOLD, 16));

        add(emaillbl);

        JLabel emaillabel = new JLabel("");
        emaillabel.setBounds(625, 230, 150, 25);
        emaillabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        emaillabel.setForeground(Color.red);
        add(emaillabel);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(350, 350, 100, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i6 = i5.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i7 = new ImageIcon(i6);
        JLabel image1 = new JLabel(i7);
        image1.setBounds(20, 400, 350, 200);
        add(image1);

        ImageIcon i8 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i9 = i8.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i10 = new ImageIcon(i9);
        JLabel image2 = new JLabel(i10);
        image2.setBounds(380, 400, 600, 200);
        add(image2);

        try {
            Connectivity c = new Connectivity();
            String query = "select * from customer where username ='" + username + "'";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {
                usernamelabel.setText(rs.getString("username"));
                idlabel.setText(rs.getString("id"));
                numberlabel.setText(rs.getString("number"));
                namelabel.setText(rs.getString("name"));
                genderlabel.setText(rs.getString("gender"));
                countrylabel.setText(rs.getString("country"));
                addresslabel.setText(rs.getString("address"));
                phonelabel.setText(rs.getString("phone"));
                emaillabel.setText(rs.getString("email"));
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
