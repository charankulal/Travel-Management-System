package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About extends JFrame implements ActionListener {

    JButton back;

    About() {
        setBounds(600, 200, 500, 550);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel l1 = new JLabel("About Project");
        l1.setBounds(150, 10, 150, 40);
        l1.setForeground(Color.red);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l1);

        String Add1 = "Travel Management sytem is a desktop based application which is implemented using java and swings. The database used is MySQL";

        TextArea area = new TextArea(Add1, 10, 40, Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setFont(new Font("Consolas", Font.PLAIN, 18));
        area.setBounds(20, 100, 450, 300);
        add(area);

        back = new JButton("Back");
        back.setBounds(200, 450, 80, 30);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String args[]) {
        new About();

    }
}
