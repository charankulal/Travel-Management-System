package travel.management.system;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JLabel usernamelbl1,namelbl;
    JComboBox comboid;
    JTextField numberfield,addressfield,countryfield;
    JRadioButton rmale,rfemale;
    
    AddCustomer()
    {
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setBounds(450,200,850,550);
        
        JLabel usernamelbl=new JLabel("Username");
        usernamelbl.setBounds(30,50,150,25);
        add(usernamelbl);
        
        usernamelbl1=new JLabel("");
        usernamelbl1.setBounds(220,50,150,25);
        add(usernamelbl1);
        
        JLabel labelid=new JLabel("ID : ");
        labelid.setBounds(30,90,150,25);
        add(labelid);
        
        comboid=new JComboBox(new String[] {"Adhaar card","PAN card","Passport","Driving License","Voter Id"});
        comboid.setBounds(220,90,150,25);
        comboid.setBackground(Color.white);
        add(comboid);
        
        JLabel numberlbl=new JLabel("Number :");
        numberlbl.setBounds(30,130,150,25);
        add(numberlbl);
        
        numberfield=new JTextField();
        numberfield.setBounds(220,130,150,25);
        add(numberfield);
        
        JLabel namelabel=new JLabel("Name : ");
        namelabel.setBounds(30,170,150,25);
        add(namelabel);
        
        namelbl=new JLabel("");
        namelbl.setBounds(220,170,150,25);
        add(namelbl);
        
        JLabel genderlabel=new JLabel("Gender : ");
        genderlabel.setBounds(30,210,150,25);
        add(genderlabel);
        
        rmale=new JRadioButton("Male");
        rmale.setBackground(Color.white);
        rmale.setBounds(220,210,75,25);
        add(rmale);
        
        rfemale=new JRadioButton("Female");
        rfemale.setBackground(Color.white);
        rfemale.setBounds(300,210,75,25);
        add(rfemale);
        
        ButtonGroup gender=new ButtonGroup();
        gender.add(rmale);
        gender.add(rfemale);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        
    }
    public static void main(String args[])
    {
        new AddCustomer();
    }
}
