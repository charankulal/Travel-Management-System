package travel.management.system;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class UpdateCustomer extends JFrame implements ActionListener {

    JComboBox comboid;
    JTextField numberfield, addressfield, countryfield, phonefield, emailfield,  namefield;
    JRadioButton rmale, rfemale;
    JButton update, back;
    String username;
    JLabel usernamefield;

    UpdateCustomer(String username) {
        this.username=username;

        setLayout(null);
        getContentPane().setBackground(Color.white);
        setBounds(450, 200, 850, 550);

        JLabel textHeading = new JLabel("UPDATE CUSTOMER DETAILS");
        textHeading.setBounds(50, 5, 300, 25);
        textHeading.setForeground(Color.RED);
        textHeading.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(textHeading);

        JLabel usernamelbl = new JLabel("Username");
        usernamelbl.setBounds(30, 50, 150, 25);
        add(usernamelbl);

        usernamefield = new JLabel("");
        usernamefield.setBounds(220, 50, 150, 25);
        add(usernamefield);

        JLabel labelid = new JLabel("ID : ");
        labelid.setBounds(30, 90, 150, 25);
        add(labelid);

        comboid = new JComboBox(new String[]{"Adhaar card", "PAN card", "Passport", "Driving License", "Voter Id"});
        comboid.setBounds(220, 90, 150, 25);
        comboid.setBackground(Color.white);
        add(comboid);

        JLabel numberlbl = new JLabel("Number :");
        numberlbl.setBounds(30, 130, 150, 25);
        add(numberlbl);

        numberfield = new JTextField();
        numberfield.setBounds(220, 130, 150, 25);
        add(numberfield);

        JLabel namelabel = new JLabel("Name : ");
        namelabel.setBounds(30, 170, 150, 25);
        add(namelabel);

        namefield = new JTextField();
        namefield.setBounds(220, 170, 150, 25);
        add(namefield);

        JLabel genderlabel = new JLabel("Gender : ");
        genderlabel.setBounds(30, 210, 150, 25);
        add(genderlabel);

        rmale = new JRadioButton("Male");
        rmale.setBackground(Color.white);
        rmale.setBounds(220, 210, 75, 25);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBackground(Color.white);
        rfemale.setBounds(300, 210, 75, 25);
        add(rfemale);

        ButtonGroup gender = new ButtonGroup();
        gender.add(rmale);
        gender.add(rfemale);

        JLabel countrylbl = new JLabel("Country :");
        countrylbl.setBounds(30, 250, 150, 25);
        add(countrylbl);

        countryfield = new JTextField();
        countryfield.setBounds(220, 250, 150, 25);
        add(countryfield);

        JLabel addresslbl = new JLabel("Address :");
        addresslbl.setBounds(30, 290, 150, 25);
        add(addresslbl);

        addressfield = new JTextField();
        addressfield.setBounds(220, 290, 150, 25);
        add(addressfield);

        JLabel phonelbl = new JLabel("Phone :");
        phonelbl.setBounds(30, 330, 150, 25);
        add(phonelbl);

        phonefield = new JTextField();
        phonefield.setBounds(220, 330, 150, 25);
        add(phonefield);

        JLabel emaillbl = new JLabel("Email Id :");
        emaillbl.setBounds(30, 370, 150, 25);
        add(emaillbl);

        emailfield = new JTextField();
        emailfield.setBounds(220, 370, 150, 25);
        add(emailfield);

        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.white);
        update.setBounds(70, 430, 100, 25);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(270, 430, 100, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i6 = i5.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i7 = new ImageIcon(i6);
        JLabel image1 = new JLabel(i7);
        image1.setBounds(400, 40, 450, 500);
        add(image1);
        
        
        try {
            Connectivity c = new Connectivity();
            String query = "select * from customer where username ='" + username + "'";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {
                usernamefield.setText(rs.getString("username"));
               comboid.setSelectedItem(rs.getString("id"));
                numberfield.setText(rs.getString("number"));
                
                namefield.setText(rs.getString("name"));
                countryfield.setText(rs.getString("country"));
                addressfield.setText(rs.getString("address"));
                phonefield.setText(rs.getString("phone"));
                emailfield.setText(rs.getString("email"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
         if (ae.getSource() == update) {
            String username1 = usernamefield.getText();
            String id = (String) comboid.getSelectedItem();
            String number = numberfield.getText();
            String name = namefield.getText();
            String gender = null;
            if (rmale.isSelected()) {
                gender = "Male";
            } else {
                gender = "Female";
            }
            String country = countryfield.getText();
            String address = addressfield.getText();
            String phone = phonefield.getText();
            String email = emailfield.getText();

            try {
                Connectivity c = new Connectivity();
                String query = "update customer set id='" + id + "',number='" + number + "',name='" + name + "',gender='" + gender + "',country='" + country + "',address='" + address + "',phone='" + phone + "',email='" + email + "' where username='"+username1+"'";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
            

        } else {
            setVisible(false);
            
        }
        

        

    }

}
