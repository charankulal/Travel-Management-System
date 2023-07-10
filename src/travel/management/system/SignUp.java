package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class SignUp extends JFrame implements ActionListener{
    JTextField usrnamefield,namefield,passwordfield,answerfield;
    Choice security;
    JButton create,back;
    
    SignUp(){
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setBounds(350,200,900,360);
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0, 0, 500, 360);
        add(p1);
        
        JLabel userlabel=new JLabel("Username :");
        userlabel.setFont(new Font("Tahoma",Font.BOLD,14));
        userlabel.setBounds(50,20,125,25);
        p1.add(userlabel);
        
        usrnamefield=new JTextField();
        usrnamefield.setBounds(200,20,180,25);
        usrnamefield.setBorder(BorderFactory.createEmptyBorder());
        usrnamefield.setFont(new Font("Consolas",Font.BOLD,14));
        p1.add(usrnamefield);
        
        JLabel namelabel=new JLabel("Name :");
        namelabel.setFont(new Font("Tahoma",Font.BOLD,14));
        namelabel.setBounds(50,60,125,25);
        p1.add(namelabel);
        
        namefield=new JTextField();
        namefield.setBounds(200,60,180,25);
        namefield.setBorder(BorderFactory.createEmptyBorder());
        namefield.setFont(new Font("Consolas",Font.BOLD,14));
        p1.add(namefield);
        
        JLabel passwordlabel=new JLabel("Password :");
        passwordlabel.setFont(new Font("Tahoma",Font.BOLD,14));
        passwordlabel.setBounds(50,100,125,25);
        p1.add(passwordlabel);
        
        passwordfield=new JTextField();
        passwordfield.setBounds(200,100,180,25);
        passwordfield.setBorder(BorderFactory.createEmptyBorder());
        passwordfield.setFont(new Font("Consolas",Font.BOLD,14));
        p1.add(passwordfield);
        
        JLabel securitylabel=new JLabel("Security Ouestion :");
        securitylabel.setFont(new Font("Tahoma",Font.BOLD,14));
        securitylabel.setBounds(50,140,145,25);
        p1.add(securitylabel);

        security =new Choice();
        security.add("Favourite Color");
        security.add("Favourite Avenger");
        security.add("Your Lucky Number");
        security.add("Your childhood superhero");
        security.setBounds(200,140,180,25);
        p1.add(security);
        
        JLabel answerlabel=new JLabel("Answer :");
        answerlabel.setFont(new Font("Tahoma",Font.BOLD,14));
        answerlabel.setBounds(50,180,125,25);
        p1.add(answerlabel);
        
        answerfield=new JTextField();
        answerfield.setBounds(200,180,180,25);
        answerfield.setBorder(BorderFactory.createEmptyBorder());
        answerfield.setFont(new Font("Consolas",Font.BOLD,14));
        p1.add(answerfield);
        
        create =new JButton("Create");
        create.setBounds(80, 250, 100, 30);
        create.setBackground(Color.white);
        create.setForeground(new Color(133, 193, 233));
        create.setFont(new Font("Raleway", Font.BOLD, 16));
        create.addActionListener(this);
        p1.add(create);
        
        back =new JButton("Back");
        back.setBounds(250, 250, 100, 30);
        back.setBackground(Color.white);
        back.setForeground(new Color(133, 193, 233));
        back.setFont(new Font("Raleway", Font.BOLD, 16));
        back.addActionListener(this);
        p1.add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(575, 55, 250, 250);
        add(image);
        
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==create)
        {
            String username=usrnamefield.getText();
            String name=namefield.getText();
            String password=passwordfield.getText();
            String question=security.getSelectedItem();
            String answer=answerfield.getText();
            
            String query= "insert into user_account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
            
            try{
                Connectivity conn=new Connectivity();
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Account Created Successfully");
                
                setVisible(false);
                new Login();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==back)
        {
            setVisible(false);
            new Login();
        }
                
    }
    public static void main(String args[]){
        SignUp signUp = new SignUp();
    }
}
