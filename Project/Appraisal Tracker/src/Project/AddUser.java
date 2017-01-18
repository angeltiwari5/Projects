
/**
 *
 * @author MS Dhoni (C) (wk)
 */

package Project;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddUser extends NewWindow {
    int index;
    String str, obj;
    String course[] = {"--- Select ---", "Chairman", "MD", "General Manager", "Project Manager", "Employee"};
    JLabel newID = new JLabel("New ID :");
    JLabel portfolio = new JLabel("Portfolio :");
    
    JTextField newId = new JTextField();
    
    JComboBox cb = new JComboBox(course);
    
    JButton submit = new JButton("Submit");
    JButton back = new JButton("Back");
    JButton logout = new JButton("Logout");
    
    AddUser() {
        newID.setBounds(50,100,200,50);
        newID.setFont(new Font("Verdina", Font.PLAIN, 30));
        newID.setForeground(Color.BLUE);
        
        portfolio.setBounds(50,175,200,50);
        portfolio.setFont(new Font("Verdina", Font.PLAIN, 30));
        portfolio.setForeground(Color.BLUE);
        
        newId.setBounds(200,100,200,50);
        
        cb.setBounds(200,185,200,30);
        cb.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent ie){
                 String str = (String)cb.getSelectedItem();
                 obj = str;
            }
         });
        
        ButtonGroup buttonGroup = new ButtonGroup();
        submit.setBounds(150,300,100,30);
        buttonGroup.add(submit);
        submit.addActionListener(new ActionListener() {
            int flag = 0;
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        index = cb.getSelectedIndex();
                        str = newId.getText();
                        if ("".equals(str)) {
                            JOptionPane.showMessageDialog(null, "Enter an ID !!");
                        } else {
                            if(course[index].equals("--- Select ---")) {
                                JOptionPane.showMessageDialog(null, "Select a portfolio !!");
                            } else {
                        c = new JDBCConnection();
                        s = c.Connect.createStatement();
                        rs = s.executeQuery("select user_id from users");
                        while(rs.next()) {
                            if (rs.getString("user_id").equals(str)) {
                                JOptionPane.showMessageDialog(null, "User ID already exists !!");
                                flag = 1;
                            }
                        }
                        System.out.println(obj);
                        if (flag != 1) {
                        s.executeQuery("insert into users values ('" + str + "','" + str + "','" + "avn" + "','','')");
                        s.executeQuery("insert into profile values ('" + str + "','','','','','','"+obj+"')");
                        s.executeQuery("insert into notify values('" + str + "','" + "Please update your profile" + "',0)");
                        JOptionPane.showMessageDialog(null, "New User has been added successfully !!\nUsername will be his User ID\nPassword will be '007'");
                        frame.setVisible(false);
                        Admin a = new Admin();
                        }
                        }}
                    } catch (SQLException se) {
                        System.err.println(se.getMessage());
                    }
                }
        });
        
        back.setBounds(0,0,120,25);
        buttonGroup.add(back);
        back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    Admin a = new Admin();
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
        
        panel.add(submit);
        panel.add(newId);
        panel.add(newID);
        panel.add(portfolio);
        panel.add(cb);
        panel.add(back);
        panel.add(logout);
        panel.add(Image2);
        frame.setVisible(true);
    }
}