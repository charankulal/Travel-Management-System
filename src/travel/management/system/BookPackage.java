package travel.management.system;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener{
    
    Choice cpackage;
    JTextField personsfield;
    String username;
    JLabel usernamelabel,idlabel,numberlabel,phonelabel,totallabel;
    JButton checkprice,bookpackage,back;
    
    BookPackage(String username)
    {
        this.username=username;
        setBounds(350,200,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100, 10, 300, 30);
        text.setFont(new Font("Raleway", Font.BOLD, 25));
        text.setForeground(Color.red);
        add(text);
        
        JLabel usernamelbl = new JLabel("Username :");
        usernamelbl.setBounds(30, 70, 150, 25);
        usernamelbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(usernamelbl);

        usernamelabel = new JLabel("");
        usernamelabel.setBounds(250, 70, 150, 25);
        usernamelabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        usernamelabel.setForeground(Color.red);
        add(usernamelabel);

        JLabel packagelbl = new JLabel("Select Package :");
        packagelbl.setBounds(30, 110, 150, 25);
        packagelbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(packagelbl);

        cpackage=new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250,110,200,20);
        add(cpackage);

        JLabel personlbl = new JLabel("Total Persons :");
        personlbl.setBounds(30, 150, 150, 25);
        personlbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(personlbl);

        personsfield=new JTextField();
        personsfield.setBounds(250, 150, 200, 25);
        personsfield.setFont(new Font("Times New Roman", Font.BOLD, 16));
        personsfield.setForeground(Color.red);
        add(personsfield);

        JLabel idlbl = new JLabel("Id :");
        idlbl.setBounds(30, 190, 150, 25);
        idlbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(idlbl);

        idlabel = new JLabel("");
        idlabel.setBounds(250, 190, 200, 25);
        idlabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        idlabel.setForeground(Color.red);
        add(idlabel);

        JLabel numberlbl = new JLabel("Number :");
        numberlbl.setBounds(30, 230, 150, 25);
        numberlbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(numberlbl);

        numberlabel = new JLabel("");
        numberlabel.setBounds(250, 230, 200, 25);
        numberlabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        numberlabel.setForeground(Color.red);
        add(numberlabel);
        
        JLabel phonelbl = new JLabel("Phone :");
        phonelbl.setBounds(30, 270, 150, 25);
        phonelbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(phonelbl);

        phonelabel = new JLabel("");
        phonelabel.setBounds(250, 270, 200, 25);
        phonelabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        phonelabel.setForeground(Color.red);
        add(phonelabel);

        JLabel totallbl = new JLabel("Total Price :");
        totallbl.setBounds(30, 310, 150, 25);
        totallbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(totallbl);

        totallabel = new JLabel("");
        totallabel.setBounds(250, 310, 200, 25);
        totallabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        totallabel.setForeground(Color.red);
        add(totallabel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(550, 40, 500, 350);
        add(image1);
        
        try {
            Connectivity c = new Connectivity();
            String query = "select * from customer where username ='" + username + "'";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {
                usernamelabel.setText(rs.getString("username"));
                idlabel.setText(rs.getString("id"));
                numberlabel.setText(rs.getString("number"));
                
                phonelabel.setText(rs.getString("phone"));
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        checkprice=new JButton("Check Price");
        checkprice.setBackground(Color.black);
        checkprice.setForeground(Color.white);
        checkprice.setBounds(60,380,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage=new JButton("Book Package");
        bookpackage.setBackground(Color.black);
        bookpackage.setForeground(Color.white);
        bookpackage.setBounds(200,380,120,25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back=new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(340,380,120,25);
        back.addActionListener(this);
        add(back);
       
        setVisible(true);
        
    }
    
     @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()== checkprice)
        {
            String pack = cpackage.getSelectedItem();
            int cost=0;
            if(pack.equals("Gold Package"))
            {
                cost+=12000;
            }
            else if(pack.equals("Silver Package"))
            {
                cost+=10000;
            }
            else
            {
                cost+=8000;
            }
            
            int persons=Integer.parseInt(personsfield.getText());
            cost*=persons;
            
            totallabel.setText("Rs. "+cost);
            
        }else if(ae.getSource()==bookpackage)
        {
            try{
                Connectivity c=new Connectivity();
                c.s.executeUpdate("insert into bookpackage values('"+usernamelabel.getText()+"','"+cpackage.getSelectedItem()+"','"+personsfield.getText()+"','"+idlabel.getText()+"','"+numberlabel.getText()+"','"+phonelabel.getText()+"','"+totallabel.getText()+"')");
                JOptionPane.showMessageDialog(null,"Package Booked Successfully");
                setVisible(false);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }else if(ae.getSource()==back)
        {
            setVisible(false);
        }
     
    }
    public static void main(String[] args)
    {
        new BookPackage("Krishna123");
    }

   
    
}
