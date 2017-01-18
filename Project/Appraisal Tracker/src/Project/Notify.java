
/**
 *
 * @author MS Dhoni (C) (wk)
 */

package Project;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Notify extends NewWindow {
    String id, p;
    JLabel notify;
    JButton back = new JButton("Back");
    JButton logout = new JButton("Logout");
    JButton edit = new JButton("Create Profile");
    
    Notify(String str) {
        id = str;
        edit.setBounds(300,150,150,50);
        edit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    CreateProfile c = new CreateProfile(id);
            }
        });
        
        c = new JDBCConnection();
        try {
            s = c.Connect.createStatement();
            rs = s.executeQuery("select note from notify where employee_id = '" + id + "' and read = 0");
            while(rs.next()) {
                p = rs.getString("note");
                notify = new JLabel(p);
            }
            s.executeQuery("update notify set read = 1 where employee_id = '" + id + "' and read = 0");
            if (p.equals("Please update your profile")) {
                panel.add(edit);
                frame.setVisible(false);
                frame.setVisible(true);
            }
        } catch(SQLException fe) {
            System.err.println(fe.getMessage());
        }
        notify.setFont(new Font("Segoe UI", Font.BOLD, 28));
        notify.setForeground(Color.BLUE);
        notify.setBounds(50,100,1000,50);
        
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
        
        panel.add(back);
        panel.add(logout);
        panel.add(notify);
        panel.add(Image2);
        frame.setVisible(true);
    }
}
