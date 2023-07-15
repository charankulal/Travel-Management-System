package travel.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Payment extends JFrame implements ActionListener{
    
    JButton pay,back;
    
    Payment()
    {
        setBounds(500,200,800,600);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 600);
        add(image);

        
        pay=new JButton("Pay");
        pay.setBounds(100,500,80,40);
        pay.setForeground(Color.white);
        pay.setBackground(Color.BLACK);
        pay.addActionListener(this);
        image.add(pay);
        
        back=new JButton("Back");
        back.setBounds(620,500,80,40);
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        image.add(back);
        
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==pay)
        {
            setVisible(false);
            new Paytm();
        }else
        {
            setVisible(false);
        }
    }
    
    public static void main(String args[])
    {
        new Payment();
    }
    
}
