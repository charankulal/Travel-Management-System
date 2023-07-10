package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField userfield;
    JPasswordField passfield;
    JButton login, signup, forgot;

    Login() {
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setSize(900, 400);
        setLocation(350, 200);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        p2.setLayout(null);
        add(p2);

        JLabel userlabel = new JLabel("Username : ");
        userlabel.setBounds(40, 20, 150, 25);
        userlabel.setFont(new Font("Raleway", Font.BOLD, 20));
        p2.add(userlabel);

        userfield = new JTextField();
        userfield.setBounds(40, 60, 250, 25);
        userfield.setBorder(BorderFactory.createEmptyBorder());
        userfield.setFont(new Font("Consolas", Font.BOLD, 20));
        p2.add(userfield);

        JLabel passlabel = new JLabel("Password : ");
        passlabel.setBounds(40, 110, 150, 25);
        passlabel.setFont(new Font("Raleway", Font.BOLD, 20));
        p2.add(passlabel);

        passfield = new JPasswordField();
        passfield.setBounds(40, 150, 250, 25);
        passfield.setBorder(BorderFactory.createEmptyBorder());
        passfield.setFont(new Font("Consolas", Font.BOLD, 20));
        p2.add(passfield);

        login = new JButton("Login");
        login.setBounds(60, 200, 100, 30);
        login.setBackground(new Color(133, 193, 233));
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Raleway", Font.BOLD, 20));
        login.setBorder(new LineBorder(new Color(133, 193, 233)));
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("Sign Up");
        signup.setBounds(190, 200, 100, 30);
        signup.setBackground(new Color(133, 193, 233));
        signup.setForeground(Color.WHITE);
        signup.setFont(new Font("Raleway", Font.BOLD, 20));
        signup.setBorder(new LineBorder(new Color(133, 193, 233)));
        signup.addActionListener(this);
        p2.add(signup);

        forgot = new JButton("Forgot Password");
        forgot.setBounds(85, 250, 180, 30);
        forgot.setBackground(new Color(133, 193, 233));
        forgot.setForeground(Color.WHITE);
        forgot.setFont(new Font("Raleway", Font.BOLD, 20));
        forgot.setBorder(new LineBorder(new Color(133, 193, 233)));
        forgot.addActionListener(this);
        p2.add(forgot);

        JLabel text = new JLabel("Trouble in Login");
        text.setBounds(280, 255, 170, 25);
        text.setForeground(Color.red);
        text.setFont(new Font("Raleway", Font.BOLD, 18));
        p2.add(text);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==signup)
        {
            setVisible(false);
            new SignUp();
        }else if(ae.getSource()==forgot)
        {
            setVisible(false);
            new ForgetPassword();
        }
        else if(ae.getSource()==login)
        {
            try{
                String username=userfield.getText();
                String password=passfield.getText();
                
                String query="select * from user_account where username='"+username+"' and password='"+password+"'";
                Connectivity c=new Connectivity();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Loading(username);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                }
                
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
    }

    public static void main(String args[]) {
        Login login = new Login();
    }
}
