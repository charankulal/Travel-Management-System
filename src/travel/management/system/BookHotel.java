package travel.management.system;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener{
    
    Choice chotel,cac,cfood;
    JTextField personsfield,daysfield;
    String username;
    JLabel usernamelabel,idlabel,numberlabel,phonelabel,totallabel;
    JButton checkprice,bookpackage,back;
    
    BookHotel(String username)
    {
        this.username=username;
        setBounds(350,200,1100,600);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel text = new JLabel("BOOK HOTEL");
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

        JLabel hotellbl = new JLabel("Select Hotel :");
        hotellbl.setBounds(30, 110, 150, 25);
        hotellbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(hotellbl);

        chotel=new Choice();
        chotel.setBounds(250,110,200,20);
        add(chotel);
        
        try{
            Connectivity c=new Connectivity();
            ResultSet rs= c.s.executeQuery("select * from hotel");
            while(rs.next())
            {
                chotel.add(rs.getString("name"));
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        JLabel personlbl = new JLabel("Total Persons :");
        personlbl.setBounds(30, 150, 150, 25);
        personlbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(personlbl);

        personsfield=new JTextField();
        personsfield.setBounds(250, 150, 200, 25);
        personsfield.setFont(new Font("Times New Roman", Font.BOLD, 16));
        personsfield.setForeground(Color.red);
        add(personsfield);
        
        
        JLabel dayslbl = new JLabel("Total Days :");
        dayslbl.setBounds(30, 190, 190, 25);
        dayslbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(dayslbl);

        daysfield=new JTextField();
        daysfield.setBounds(250, 190, 200, 25);
        daysfield.setFont(new Font("Times New Roman", Font.BOLD, 16));
        daysfield.setForeground(Color.red);
        add(daysfield);

        JLabel aclbl = new JLabel("AC/ Non-AC :");
        aclbl.setBounds(30, 230, 150, 25);
        aclbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(aclbl);
        
        cac=new Choice();
        cac.setBounds(250,230,200,20);
        cac.add("AC");
        cac.add("Non-Ac");
        add(cac);

        JLabel foodlbl = new JLabel("Is Food Included :");
        foodlbl.setBounds(30, 270, 150, 25);
        foodlbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(foodlbl);
        
        cfood=new Choice();
        cfood.setBounds(250,270,200,20);
        cfood.add("YES");
        cfood.add("NO");
        add(cfood);
        
        JLabel idlbl = new JLabel("ID :");
        idlbl.setBounds(30, 310, 150, 25);
        idlbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(idlbl);

        idlabel = new JLabel("");
        idlabel.setBounds(250, 310, 200, 25);
        idlabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        idlabel.setForeground(Color.red);
        add(idlabel);
        
        JLabel numberlbl = new JLabel("Number :");
        numberlbl.setBounds(30, 350, 150, 25);
        numberlbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(numberlbl);

        numberlabel = new JLabel("");
        numberlabel.setBounds(250, 350, 200, 25);
        numberlabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        numberlabel.setForeground(Color.red);
        add(numberlabel);
        
        JLabel phonelbl = new JLabel("Phone :");
        phonelbl.setBounds(30, 390, 150, 25);
        phonelbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(phonelbl);

        phonelabel = new JLabel("");
        phonelabel.setBounds(250, 390, 200, 25);
        phonelabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        phonelabel.setForeground(Color.red);
        add(phonelabel);

        JLabel totallbl = new JLabel("Total Price :");
        totallbl.setBounds(30, 430, 150, 25);
        totallbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(totallbl);

        totallabel = new JLabel("");
        totallabel.setBounds(250, 430, 200, 25);
        totallabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        totallabel.setForeground(Color.red);
        add(totallabel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(500, 40, 550, 400);
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
        checkprice.setBounds(60,490,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage=new JButton("Book Hotel");
        bookpackage.setBackground(Color.black);
        bookpackage.setForeground(Color.white);
        bookpackage.setBounds(200,490,120,25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back=new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(340,490,120,25);
        back.addActionListener(this);
        add(back);
       
        setVisible(true);
        
    }
    
     @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()== checkprice)
        {
            try{
            Connectivity c=new Connectivity();
            ResultSet rs=c.s.executeQuery("select * from hotel where name ='"+chotel.getSelectedItem()+"'");
            while(rs.next())
            {
                int cost=Integer.parseInt(rs.getString("costperperson"));
                int food=Integer.parseInt(rs.getString("foodincluded"));
                int ac=Integer.parseInt(rs.getString("acroom"));
                int persons=Integer.parseInt(personsfield.getText());
                int days=Integer.parseInt(personsfield.getText());
                
                String acselected= cac.getSelectedItem();
                String foodselected=cfood.getSelectedItem();
                
                if(persons*days>0)
                {
                    int total=0;
                    total+=acselected.equals("AC")? ac :0;
                    total+=foodselected.equals("YES")?food:0;
                    total+=cost;
                    total=total*days*persons;
                    
                    totallabel.setText("Rs. "+total);
                }else
                {
                    JOptionPane.showMessageDialog(null,"Please enter a valid number.");
                }
                
            }
            
            
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
            
            
        }else if(ae.getSource()==bookpackage)
        {
            try{
                Connectivity c=new Connectivity();
                c.s.executeUpdate("insert into bookhotel values('"+usernamelabel.getText()+"','"+chotel.getSelectedItem()+"','"+personsfield.getText()+"','"+daysfield.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+idlabel.getText()+"','"+numberlabel.getText()+"','"+phonelabel.getText()+"','"+totallabel.getText()+"')");
                JOptionPane.showMessageDialog(null,"Hotel Booked Successfully");
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
   

   
    
}
