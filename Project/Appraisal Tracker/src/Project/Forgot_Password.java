
/**
 *
 * @author MS Dhoni (C) (wk)
 */

package Project;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Forgot_Password extends NewWindow {
    String id, ans, Pass1, Pass2;
    /*JDBCConnection c = new JDBCConnection();
    Statement s = null;
    ResultSet rs = null;*/
    
    /*JFrame frame = new JFrame("Forgot Password :");
    
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    
    ImageIcon i = new ImageIcon("background.jpg");
    ImageIcon i1 = new ImageIcon("avn_logo.jpg");
    ImageIcon i2 = new ImageIcon("background1.jpg");
    
    JLabel Image = new JLabel(i);
    JLabel Image1 = new JLabel(i1);
    JLabel Image2 = new JLabel(i2);*/
    JLabel sq = new JLabel("Security Question :");
    JLabel question;
    JLabel New = new JLabel("New Password :");
    JLabel Retype = new JLabel("Retype Password :");
    JLabel wrong = new JLabel("Wrong Answer");
    
    JTextField Answer = new JTextField();
    JPasswordField pass1 = new JPasswordField();
    JPasswordField pass2 = new JPasswordField();
    
    JButton button = new JButton("Submit");
    JButton button1 = new JButton("Submit");
    JButton logout = new JButton("Logout");
    
    Forgot_Password(String str) {
        //frame = new JFrame("Forgot Password :");
        id = str;
        /*Image.setBounds(342,0,658,125);
        Image1.setBounds(0,0,341,124);
        Image2.setBounds(0,0,875,575);*/
        try {
            c = new JDBCConnection();
            s = c.Connect.createStatement();
            rs = s.executeQuery("select security_question from users where (user_id = '" + id + "')");
            rs.next();
            question = new JLabel(rs.getString(1));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        sq.setBounds(30,0,870,50);
        sq.setFont(new Font("Verdina", Font.PLAIN, 20));
        sq.setForeground(Color.RED);
        
        question.setBounds(50,50,870,50);
        question.setFont(new Font("Verdina", Font.PLAIN, 30));
        question.setForeground(Color.BLUE);
        
        New.setBounds(50,250,250,50);
        New.setFont(new Font("Verdina", Font.PLAIN, 30));
        New.setForeground(Color.white);
        
        Retype.setBounds(50,325,250,50);
        Retype.setFont(new Font("Verdina", Font.PLAIN, 30));
        Retype.setForeground(Color.white);
        
        Answer.setBounds(50,125,200,50);
        pass1.setBounds(350,250,200,50);
        pass2.setBounds(350,325,200,50);
        
        /*p2.setBounds(0,125,875,575);
        p2.setLayout(null);*/
        panel.add(sq);
        panel.add(question);
        panel.add(Answer);
        panel.add(button);
        panel.add(logout);
        panel.add(Image2);
        
        ButtonGroup buttonGroup = new ButtonGroup();
        button1.setBounds(520,400,100,30);
        buttonGroup.add(button1);
        button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    rs = null;
                    Pass1 = pass1.getText();
                    Pass2 = pass2.getText();
                    if (Pass1.equals(Pass2)) {
                        try {
                            rs = s.executeQuery("update users set password = '" + Pass1 + "' where user_id = '" + id + "'");
                        } catch (SQLException se) {
                            System.err.println(se.getMessage());
                        }
                        JOptionPane.showMessageDialog(null, "Password Updated successfully !!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update password !!");
                    }
                    frame.setVisible(false);
                    LoginWindow m = new LoginWindow();
            }
        });
        button.setBounds(520,200,100,30);
        buttonGroup.add(button);
        button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    rs = null;
                    ans = Answer.getText();
                    try {
                        rs = s.executeQuery("select answer from users where (user_id = '" + id + "')");
                        rs.next();
                        if (ans.equals(rs.getString(1))) {
                            panel.add(New);
                            panel.add(Retype);
                            panel.add(pass1);
                            panel.add(pass2);
                            panel.add(button1);
                            panel.add(Image2);
                            frame.setVisible(false);
                            frame.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Wrong Answer !!\nCannot change your password !!");
                            frame.setVisible(false);
                            LoginWindow m = new LoginWindow();
                        }
                    } catch (SQLException s) {
                        System.err.println(s.getMessage());
                    }
            }
        });
        logout.setBounds(755,0,120,25);
        buttonGroup.add(logout);
        logout.addActionListener(new ActionListener() {
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
        
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("avn_logo.jpg"));
        frame.setSize(1000,700);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(p1);
        frame.add(p2);*/
        frame.setVisible(true);
    }
}