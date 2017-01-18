
/**
 *
 * @author MS Dhoni (C) (wk)
 */

package Project;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Admin extends NewWindow {
    int flag;
    /*JFrame frame = new JFrame("Login Window :");
    
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    
    ImageIcon i = new ImageIcon("background.jpg");
    ImageIcon i1 = new ImageIcon("avn_logo.jpg");
    ImageIcon i2 = new ImageIcon("background1.jpg");
    
    JLabel Image = new JLabel(i);
    JLabel Image1 = new JLabel(i1);
    JLabel Image2 = new JLabel(i2);*/
    
    JButton b1 = new JButton("Add User");
    JButton b2 = new JButton("Add Task");
    JButton b3 = new JButton("Performance");
    JButton b4 = new JButton("Compose Mail");
    JButton b5 = new JButton("Notifications");
    JButton b6 = new JButton("Back");
    JButton b7 = new JButton("Logout");
    
    Admin() {
        /*Image.setBounds(342,0,658,125);
        Image1.setBounds(0,0,341,124);
        Image2.setBounds(0,0,875,575);*/
        
        b1.setBounds(120,200,120,75);
        b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    AddUser a = new AddUser();
            }
        });
        
        b2.setBounds(260,200,120,75);
        b2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    AddTask a = new AddTask();
            }
        });
        
        b3.setBounds(400,200,120,75);
        b3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    Performance p = new Performance();
            }
        });
        
        b6.setBounds(0,0,120,25);
        b6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    LoginWindow m = new LoginWindow();
            }
        });
        
        b7.setBounds(755,0,120,25);
        b7.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    LoginWindow m = new LoginWindow();
            }
        });
        
        /*p1.setBounds(0,0,1000,125);
        p1.setBackground(Color.WHITE);
        p1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        p1.setLayout(null);
        p1.add(Image);
        p1.add(Image1);
        
        p2.setBounds(0,125,875,575);
        p2.setBackground(Color.WHITE);
        p2.setLayout(null);*/
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b6);
        panel.add(b7);
        panel.add(Image2);
        
        /*frame.setIconImage(Toolkit.getDefaultToolkit().getImage("avn_logo.jpg"));
        frame.setSize(1000,700);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(p1);
        frame.add(p2);*/
        frame.setVisible(true);
    }
}