package travel.management.system;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener {

    JLabel usernamelbl1, namelbl;
    JComboBox comboid;
    JTextField numberfield, addressfield, countryfield, phonefield, emailfield;
    JRadioButton rmale, rfemale;
    JButton add, back;

    AddCustomer(String username) {

        setLayout(null);
        getContentPane().setBackground(Color.white);
        setBounds(450, 200, 850, 550);

        JLabel usernamelbl = new JLabel("Username");
        usernamelbl.setBounds(30, 50, 150, 25);
        add(usernamelbl);

        usernamelbl1 = new JLabel("");
        usernamelbl1.setBounds(220, 50, 150, 25);
        add(usernamelbl1);

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

        namelbl = new JLabel("");
        namelbl.setBounds(220, 170, 150, 25);
        add(namelbl);

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

        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.setBounds(70, 430, 100, 25);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(270, 430, 100, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i6 = i5.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i7 = new ImageIcon(i6);
        JLabel image1 = new JLabel(i7);
        image1.setBounds(400, 0, 500, 500);
        add(image1);

        try {
            Connectivity c = new Connectivity();
            ResultSet rs = c.s.executeQuery("select * from user_account where username='" + username + "'");
            while (rs.next()) {
                usernamelbl1.setText(rs.getString("username"));
                namelbl.setText(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String username = usernamelbl1.getText();
            String id = (String) comboid.getSelectedItem();
            String number = numberfield.getText();
            String name = namelbl.getText();
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
                String query = "insert into customer values('" + username + "','" + id + "','" + number + "','" + name + "','" + gender + "','" + country + "','" + address + "','" + phone + "','" + email + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
            new Dashboard("");
        }

    }

    public static void main(String args[]) {
        new AddCustomer("");
    }
}
