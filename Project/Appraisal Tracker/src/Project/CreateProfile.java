
/**
 *
 * @author MS Dhoni (C) (wk)
 */

package Project;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class CreateProfile extends NewWindow {
    String id, s1, s2, s3, s4, s5, s6, s7, s8, s9,s10;
    JLabel name = new JLabel("Name :");
    JLabel pass = new JLabel("Password :");
    JLabel retype = new JLabel("Retype Password :");
    JLabel dob = new JLabel("Born On :");
    JLabel gender = new JLabel("Gender :");
    JLabel email = new JLabel("Email ID :");
    JLabel superior = new JLabel("Superior_id");
    JLabel city = new JLabel("City");
    JLabel security = new JLabel("Security Question :");
    JLabel answer = new JLabel("Answer :");
    
    JTextField Name = new JTextField();
    JPasswordField Pass = new JPasswordField();
    JPasswordField Retype = new JPasswordField();
    JTextField Dob = new JTextField();
    JTextField Gender = new JTextField();
    JTextField Email = new JTextField();
    JTextField Superior = new JTextField();
    JTextField City = new JTextField();
    JTextField Security = new JTextField();
    JTextField Answer = new JTextField();
    
    JButton submit = new JButton("Submit");
    JButton back = new JButton("Back");
    JButton logout = new JButton("Logout");
    
    CreateProfile(String str) {
        id = str;
        
        name.setFont(new Font("Segoe UI", Font.BOLD, 18));
        name.setForeground(Color.BLUE);
        name.setBounds(20,50,180,20);
        Name.setBounds(200,50,180,20);
        
        pass.setFont(new Font("Segoe UI", Font.BOLD, 18));
        pass.setForeground(Color.BLUE);
        pass.setBounds(20,100,180,20);
        Pass.setBounds(200,100,180,20);
        
        retype.setFont(new Font("Segoe UI", Font.BOLD, 18));
        retype.setForeground(Color.BLUE);
        retype.setBounds(20,150,180,20);
        Retype.setBounds(200,150,180,20);
        
        dob.setFont(new Font("Segoe UI", Font.BOLD, 18));
        dob.setForeground(Color.BLUE);
        dob.setBounds(20,200,220,20);
        Dob.setBounds(200,200,180,20);
        
        gender.setFont(new Font("Segoe UI", Font.BOLD, 18));
        gender.setForeground(Color.BLUE);
        gender.setBounds(20,250,180,20);
        Gender.setBounds(200,250,180,20);
        
        email.setFont(new Font("Segoe UI", Font.BOLD, 18));
        email.setForeground(Color.BLUE);
        email.setBounds(20,300,180,20);
        Email.setBounds(200,300,180,20);
        
        superior.setFont(new Font("Segoe UI",Font.BOLD,18));
        superior.setForeground(Color.BLUE);
        superior.setBounds(20,500,180,20);
        Superior.setBounds(200,500,180,20);
        
        
        city.setFont(new Font("Segoe UI", Font.BOLD, 18));
        city.setForeground(Color.BLUE);
        city.setBounds(20,350,180,20);
        City.setBounds(200,350,180,20);
        
        security.setFont(new Font("Segoe UI", Font.BOLD, 18));
        security.setForeground(Color.BLUE);
        security.setBounds(20,400,180,20);
        Security.setBounds(200,400,180,20);
        
        answer.setFont(new Font("Segoe UI", Font.BOLD, 18));
        answer.setForeground(Color.BLUE);
        answer.setBounds(20,450,180,20);
        Answer.setBounds(200,450,180,20);
        
        submit.setBounds(430,500,100,20);
        submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    s1 = Name.getText();
                    s2 = Pass.getText();
                    s3 = Retype.getText();
                    s4 = Dob.getText();
                    s5 = Gender.getText();
                    s6 = Email.getText();
                    s7 = City.getText();
                    s8 = Security.getText();
                    s9 = Answer.getText();
                    s10 = Superior.getText();
                    if ("".equals(s1) || "".equals(s2) || "".equals(s3) || "".equals(s4) || "".equals(s5) || "".equals(s6) || "".equals(s7) || "".equals(s8) || "".equals(s9) || (s2 == null ? s3 != null : !s2.equals(s3))) {
                        JOptionPane.showMessageDialog(null, "Enter inputs properly !!");
                    } else {
                        c = new JDBCConnection();
                        try {
                            s = c.Connect.createStatement();
                            s.executeQuery("update profile set name = '" + s1 + "' where employee_id = '" + id + "'");
                            s.executeQuery("update profile set dob = '" + s4 + "' where employee_id = '" + id + "'");
                            s.executeQuery("update profile set gender = '" + s5 + "' where employee_id = '" + id + "'");
                            s.executeQuery("update profile set email_id = '" + s6 + "' where employee_id = '" + id + "'");
                            s.executeQuery("update profile set city = '" + s6 + "' where employee_id = '" + id + "'");
                            s.executeQuery("update users set password = '" + s2 + "' where user_id = '" + id + "'");
                            s.executeQuery("update users set security_question = '" + s8 + "' where user_id = '" + id + "'");
                            s.executeQuery("update users set answer = '" + s9 + "' where user_id = '" + id + "'");
                            s.executeQuery("insert into superior values ('"+id+"','"+s10+"')");
                        } catch (SQLException fe) {
                            System.out.println(fe.getMessage());
                        }
                        JOptionPane.showMessageDialog(null, "Profile created successfully !!");
                        frame.setVisible(false);
                        User u = new User(id);
                    }
            }
        });
        
        back.setBounds(0,0,120,25);
        back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    User u = new User(id);
            }
        });
        
        logout.setBounds(755,0,120,25);
        logout.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    LoginWindow m = new LoginWindow();
            }
        });
        
        panel.add(name);
        panel.add(pass);
        panel.add(retype);
        panel.add(dob);
        panel.add(gender);
        panel.add(email);
        panel.add(city);
        panel.add(security);
        panel.add(answer);
        panel.add(Name);
        panel.add(Pass);
        panel.add(Retype);
        panel.add(Dob);
        panel.add(Gender);
        panel.add(Email);
        panel.add(City);
        panel.add(Security);
        panel.add(Answer);
        panel.add(back);
        panel.add(logout);
        panel.add(submit);
        panel.add(superior);
        panel.add(Superior);
        panel.add(Image2);
        frame.setVisible(true);
    }
}
