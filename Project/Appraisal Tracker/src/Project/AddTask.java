
/**
 *
 * @author MS Dhoni (C) (wk)
 */

package Project;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddTask extends NewWindow {
    String ID, Des, str[] = {"--- Select ---","MD","General Manager","Project Manager","Employee"};
    JLabel task_id = new JLabel("New Task ID :");
    JLabel task_des = new JLabel("Task Description :");
    JLabel course = new JLabel("Course :");
    
    JTextField id = new JTextField();
    JTextField des = new JTextField();
    
    JComboBox cb = new JComboBox(str);
    
    JButton submit = new JButton("Submit");
    JButton back = new JButton("Back");
    JButton logout = new JButton("Logout");
    AddTask() {
        task_id.setBounds(50,100,200,50);
        task_id.setFont(new Font("Verdina", Font.PLAIN, 30));
        task_id.setForeground(Color.white);
        
        task_des.setBounds(50,175,250,50);
        task_des.setFont(new Font("Verdina", Font.PLAIN, 30));
        task_des.setForeground(Color.white);
        
        course.setBounds(50,250,200,50);
        course.setFont(new Font("Verdina", Font.PLAIN, 30));
        course.setForeground(Color.white);
        
        cb.setBounds(325,265,100,30);
        id.setBounds(325,100,250,50);
        des.setBounds(325,175,250,50);
        
        submit.setBounds(475,350,100,30);
        submit.addActionListener(new ActionListener() {
            int index;    
            @Override
                public void actionPerformed(ActionEvent e) {
                int flag = 0;
                    ID = id.getText();
                    Des = des.getText();
                    index = cb.getSelectedIndex();
                    if ("".equals(ID) || "".equals(Des) || "--- Select ---".equals(str[index])) {
                        JOptionPane.showMessageDialog(null, "Please fill all the attributes !!");
                    } else {
                    try {
                        c = new JDBCConnection();
                        s = c.Connect.createStatement();
                        rs = s.executeQuery("select task_id from tasks");
                        while(rs.next()) {
                            if (rs.getString("task_id").equals(ID)) {
                                JOptionPane.showMessageDialog(null, "Task ID already exists !!");
                                flag = 1;
                            }
                        }
                        if (flag != 1) {
                        s.executeQuery("insert into tasks values ('" + ID + "','" + Des + "','" + str[index] + "','u')");
                        frame.setVisible(false);
                        Admin a = new Admin();
                        }
                    } catch (SQLException se) {
                        System.err.println(se.getMessage());
                    }
                    }
                }
        });
        
        back.setBounds(0,0,120,25);
        back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    Admin a = new Admin();
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
        
        panel.add(task_id);
        panel.add(task_des);
        panel.add(course);
        panel.add(cb);
        panel.add(id);
        panel.add(des);
        panel.add(submit);
        panel.add(back);
        panel.add(logout);
        panel.add(Image2);
        frame.setVisible(true);
    }
}