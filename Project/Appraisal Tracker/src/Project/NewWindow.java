

package Project;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

abstract class NewWindow {
    JDBCConnection c;
    Statement s = null;
    ResultSet rs = null;
    JFrame frame = new JFrame ("Appraisal Tracker");
    
    JPanel upperPanel = new JPanel();
    JPanel panel = new JPanel();
    
    ImageIcon i = new ImageIcon("tr.jpg");
    ImageIcon i1 = new ImageIcon("tit.jpg");
    ImageIcon i2 = new ImageIcon("b.jpg");
    ImageIcon i3 = new ImageIcon("globe.jpg");
    JLabel Image = new JLabel(i);
    JLabel Image1 = new JLabel(i1);
    JLabel Image2 = new JLabel(i2);
    JLabel Image3 = new JLabel(i3);
    NewWindow() {
        Image.setBounds(150,15,650,125);
        Image1.setBounds(-100,0,341,124);
        Image2.setBounds(0,0,875,575);
        Image3.setBounds(680,0,200,160);
        //Image3.setBounds(x, y, width, height);
        upperPanel.setBounds(0,0,1000,125);
        upperPanel.setBackground(Color.BLACK);
        upperPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        upperPanel.setLayout(null);
        upperPanel.add(Image);
        upperPanel.add(Image1);
//        upperPanel.add(Image3);
        panel.setBounds(0,125,875,575);
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
        panel.add(Image2);
        
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("tra.jpg"));
        frame.setSize(870,700);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(upperPanel);
        frame.add(panel);
    }
}