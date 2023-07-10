package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener {
    JTextField usernamefield,namefield,securityfield,answerfield,passwordfield;
    JButton search,retrieve,back;
    ForgetPassword()
    {
        setLayout(null);
        setBounds(350,200,850,380);
        getContentPane().setBackground(Color.white);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(560, 70, 250, 200);
        add(image);
        
        JPanel p1= new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,280);
        add(p1);
        
        JLabel usernamelabel=new JLabel("Username : ");
        usernamelabel.setBounds(40,20,100,25);
        usernamelabel.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(usernamelabel);
        
        usernamefield=new JTextField();
        usernamefield.setBounds(200,20,150,25);
        usernamefield.setBorder(BorderFactory.createEmptyBorder());
        usernamefield.setFont(new Font("Consolas",Font.BOLD,14));
        p1.add(usernamefield);
        
        search = new JButton("Search");
        search.setBackground(Color.gray);
        search.setForeground(Color.white);
        search.setBounds(380,20,100,25);
        search.addActionListener(this);
        p1.add(search);
        
        JLabel namelabel=new JLabel("Name : ");
        namelabel.setBounds(40,60,100,25);
        namelabel.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(namelabel);
        
        namefield=new JTextField();
        namefield.setBounds(200,60,150,25);
        namefield.setBorder(BorderFactory.createEmptyBorder());
        namefield.setFont(new Font("Consolas",Font.BOLD,14));
        p1.add(namefield);
        
        JLabel securitylabel=new JLabel("Security Question : ");
        securitylabel.setBounds(40,100,150,25);
        securitylabel.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(securitylabel);
        
        securityfield=new JTextField();
        securityfield.setBounds(200,100,150,25);
        securityfield.setBorder(BorderFactory.createEmptyBorder());
        securityfield.setFont(new Font("Consolas",Font.BOLD,14));
        p1.add(securityfield);
        
        JLabel answerlabel=new JLabel("Answer : ");
        answerlabel.setBounds(40,140,150,25);
        answerlabel.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(answerlabel);
        
        answerfield=new JTextField();
        answerfield.setBounds(200,140,150,25);
        answerfield.setBorder(BorderFactory.createEmptyBorder());
        answerfield.setFont(new Font("Consolas",Font.BOLD,14));
        p1.add(answerfield);
        
        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.gray);
        retrieve.setForeground(Color.white);
        retrieve.setBounds(380,140,100,25);
        retrieve.addActionListener(this);
        p1.add(retrieve);
        
        JLabel passwordlabel=new JLabel("Password : ");
        passwordlabel.setBounds(40,180,150,25);
        passwordlabel.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(passwordlabel);
        
        passwordfield=new JTextField();
        passwordfield.setBounds(200,180,150,25);
        passwordfield.setBorder(BorderFactory.createEmptyBorder());
        passwordfield.setFont(new Font("Consolas",Font.BOLD,14));
        p1.add(passwordfield);
        
        back = new JButton("Back");
        back.setBackground(Color.gray);
        back.setForeground(Color.white);
        back.setBounds(200,230,100,25);
        back.addActionListener(this);
        p1.add(back);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Login();
        }else if(ae.getSource()==search)
        {
            try{
                String query="select * from user_account where username='"+usernamefield.getText()+"'";
                Connectivity c=new Connectivity();
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next())
                {
                    namefield.setText(rs.getString("name"));
                    securityfield.setText(rs.getString("security_question"));
                }
                        
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==retrieve)
        {
            try{
                String query="select * from user_account where username='"+usernamefield.getText()+"' and answer='"+answerfield.getText()+"'";
                Connectivity c=new Connectivity();
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next())
                {
                    passwordfield.setText(rs.getString("password"));
                    
                }
                        
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
            
        
    }
    public static void main(String args[])
    {
        new ForgetPassword();
    }
    
}
