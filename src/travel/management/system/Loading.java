package travel.management.system;

import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;

public class Loading extends JFrame implements Runnable{
    JProgressBar bar;
    Thread t;
    String username;
    
    public void run()
    {
        try{
            for(int i=1;i<=101;i++)
            {
                int max=bar.getMaximum();
                int value=bar.getValue();
                
                
                if(value<max)
                {
                    bar.setValue(value+1);
                }
                else
                {
                    setVisible(false);
                    new Dashboard(username);
                    
                }
                Thread.sleep(50);
            }
        }catch(Exception e)
        {
            
        }
    }
    Loading(String username)
    {
        this.username=username;
        t=new Thread(this);
        setLayout(null);
        setBounds(450,200,750,400);
        getContentPane().setBackground(Color.white);
        
        JLabel text=new JLabel("Travel and Tourism Management System");
        text.setBounds(20,20,700,40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway",Font.BOLD,35));
        add(text);
        
        bar = new JProgressBar();
        bar.setBounds(225,100,300,35);
        bar.setStringPainted(true);
        add(bar);
        
        JLabel loading=new JLabel("Loading..Please wait!!");
        loading.setBounds(240,140,450,30);
        loading.setForeground(Color.red);
        loading.setFont(new Font("Raleway",Font.BOLD,25));
        add(loading);
        
        JLabel username1=new JLabel();
        username1.setBounds(220,280,350,30);
        username1.setForeground(Color.red);
        username1.setFont(new Font("Raleway",Font.BOLD,25));
        add(username1);
        try{
            String query="select * from user_account where username='"+username+"'";
            Connectivity c=new Connectivity();
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next())
                {
                    username1.setText("Welcome "+rs.getString("name"));
                }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        t.start();
        
        setVisible(true);
    }
    
    public static void main(String args[])
    {
        new Loading("");
    }
}
