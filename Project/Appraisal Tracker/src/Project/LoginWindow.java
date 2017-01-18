

package Project;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class LoginWindow extends NewWindow {
    int flag = 0;
    String UserName, Password;
    JLabel l1 = new JLabel("Indian Institute of Information Technology, Allahabad");
    JLabel l2 = new JLabel("The Password you entered is Wrong.");
    JLabel user_name = new JLabel("UserName :");
    JLabel passwd = new JLabel("Password  :");
    
    JTextField username = new JTextField(30);
    JPasswordField password = new JPasswordField(30);
    
    JRadioButton User = new JRadioButton("User");
    JRadioButton Admin = new JRadioButton("Admin");
    
    JButton Login = new JButton("Login");
    JButton ForgotPassword = new JButton("Forget Password");
    
    public LoginWindow() {
      
        
        user_name.setFont(new Font("Comic Sans MS", Font.ITALIC, 24));
        user_name.setForeground(Color.LIGHT_GRAY);
        user_name.setBounds(50,50,200,50);
        
        passwd.setFont(new Font("Comic Sans MS", Font.ITALIC, 24));
        passwd.setForeground(Color.lightGray);
        passwd.setBounds(50,150,200,50);
        
        l1.setFont(new Font("Ariel", Font.PLAIN, 18));
        l1.setForeground(Color.black);
        l1.setBounds(150,400,750,50);
        
        l2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        l2.setForeground(Color.RED);
        l2.setBounds(250,15,500,20);
        
        username.setBounds(250,50,225,50);
        password.setBounds(250,150,225,50);
        
        ButtonGroup buttonGroup = new ButtonGroup();
        User.setBounds(250,230,90,25);
        buttonGroup.add(User);
        User.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                flag = 1;
            }
        });
        Admin.setBounds(380,230,90,25);
        buttonGroup.add(Admin);
        Admin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                flag = 2;
            }
        });
        
        Login.setBounds(400,300,75,40);
        Login.addActionListener(new MyAction());
        
        ForgotPassword.setBounds(325,375,150,40);
        ForgotPassword.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        rs = s.executeQuery("select user_id from users where username = '" + UserName + "'");
                        rs.next();
                        frame.setVisible(false);
                        Forgot_Password f = new Forgot_Password(rs.getString(1));
                    } catch (SQLException s) {
                        System.err.println(s.getMessage());
                    }
            }
        });
        
        panel.add(l1);
        panel.add(user_name);
        panel.add(passwd);
        panel.add(username);
        panel.add(password);
        panel.add(User);
        panel.add(Admin);
        panel.add(Login);
        panel.add(Image2);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        LoginWindow m = new LoginWindow();
    }
    class MyAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (flag == 0) {
                JOptionPane.showMessageDialog(null, "Invalid attempt. Select Admin or User");
            } else if (flag == 1) {
                try {
                    c = new JDBCConnection();
                    s = c.Connect.createStatement();
                    UserName = username.getText();
                    Password = password.getText();
                    rs = s.executeQuery("select * from users where (username = '" + UserName + "')");
                } catch(SQLException se) {
                    System.err.println(se.getMessage());
                }
                try {
                    if(rs.next() == false){
                        JOptionPane.showMessageDialog(null,"Username does not exists !");
                        return;
                    }
                    if (rs.getString("password").equals(Password)) {
                        User u = new User(rs.getString("user_id"));
                        frame.setVisible(false);
                     } else {
                        panel.add(l2);
                        panel.add(ForgotPassword);
                        panel.add(Image2);
                        frame.setVisible(false);
                        frame.setVisible(true);
                     }
                } catch(SQLException se) {
                    System.err.println(se.getMessage());
                }
            } else if (flag == 2) {
                try {
                    c = new JDBCConnection();
                    s = c.Connect.createStatement();
                    UserName = username.getText();
                    Password = password.getText();
                    rs = s.executeQuery("select password from admin where (username = '" + UserName + "')");
                } catch(SQLException se) {
                    System.err.println(se.getMessage());
                }
                try {
                    if(rs.next() == false){
                        JOptionPane.showMessageDialog(null,"Username does not exists !");
                        return;
                    }
                    
                    if (rs.getString("password").equals(Password)) {
                        Admin a = new Admin();
                        frame.setVisible(false);
                     } else {
                         JOptionPane.showMessageDialog(null,"Password Incorrect");
                     }
                } catch(SQLException se) {
                    System.err.println(se.getMessage());
                }
            }
        }
    }
}