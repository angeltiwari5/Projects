

package Project;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class User extends NewWindow {
    int flag = 0,i;
    String str,post,post1;
    JLabel welcome = new JLabel("Welcome");
    JLabel name;
    JLabel note = new JLabel("You have some notification(s) to read");
    
    JButton b1 = new JButton("View Profile");
    JButton b2 = new JButton("Self Rate");
    JButton b3 = new JButton("Rate Sub");
    JButton b4 = new JButton("Allot Task");
    JButton b5 = new JButton("Notifications");
    JButton b6 = new JButton("Back");
    JButton b7 = new JButton("Logout");
    ResultSet rs1;
    User(String id) {
        str = id;
        welcome.setBounds(50,80,125,50);
        welcome.setFont(new Font("Verdina", Font.ITALIC, 24));
        welcome.setForeground(Color.BLUE);
        
        note.setBounds(50,40,500,40);
        note.setFont(new Font("Verdina", Font.BOLD, 18));
        note.setForeground(Color.RED);
        
        try {
            rs = null;
            c = new JDBCConnection();
            s = c.Connect.createStatement();
            rs = s.executeQuery("select note from notify where employee_id = '" + str + "' and read = 0");
            //rs = s.executeQuery("select ")
            if (rs.next() != false) {
                panel.add(note);
                frame.setVisible(false);
                frame.setVisible(true);
            }else {
                flag = 1;
            }
            rs = s.executeQuery("select name,gender from profile, users where employee_id = user_id and users.user_id = '" + str + "'");
            rs.next();
            name = new JLabel(rs.getString("name"));
        } catch (SQLException se) {
            System.err.println(se.getMessage());
        }
        
        try
               {
                s = c.Connect.createStatement();
                rs=s.executeQuery("select portfolio from profile where employee_id='"+str+"'");
                while(rs.next())
                {
                    post = rs.getString("PORTFOLIO");
                }
               System.out.println(post+"  sjjsjs");
               // System.out.println(post1);
               
                String course[] = {"","Chairman","MD","General Manager","Project Manager","Employee"};
                for(i=0;i<6;i++){
       
                    if(post.equals(course[i])){
                        //System.out.println(post+"entered");
                        post1 = course[i+1];
                        //System.out.println(post1);
                        
                    }
                }
                
                System.out.println(post1 + "sjsjjsj ss");
               
             
         }
            
          catch (SQLException fe)
          {
                 System.err.println("actionpermd(): SQLException: " + fe.getMessage());

          }
        
        name.setBounds(175,80,600,50);
        name.setFont(new Font("Bradley Hand ITC", Font.BOLD, 36));
        name.setForeground(Color.WHITE);
        
        ButtonGroup buttonGroup = new ButtonGroup();
        b1.setBounds(120,200,120,75);
        buttonGroup.add(b1);
        b1.addActionListener(new ActionListener(){
            @Override
         public void actionPerformed(ActionEvent e){
                 Profile p = new Profile(str);
                 frame.setVisible(false);
             }
        });
        
        b2.setBounds(240,200,120,75);
        buttonGroup.add(b2);
        b2.addActionListener(new ActionListener(){
            @Override
         public void actionPerformed(ActionEvent e){
                 SelfRate s = new SelfRate(str);
                 frame.setVisible(false);
             }
        });
        
        b3.setBounds(360,200,120,75);
        buttonGroup.add(b3);
        b3.addActionListener(new ActionListener(){
            @Override
         public void actionPerformed(ActionEvent e){
                 SubOrdinate s = new SubOrdinate(str);
                 frame.setVisible(false);
             }
        });
        
        b4.setBounds(480,200,120,75);
        buttonGroup.add(b4);
        b4.addActionListener(new ActionListener(){
            @Override
         public void actionPerformed(ActionEvent e){
                 AllotTask a = new AllotTask(str,post1);
                 frame.setVisible(false);
             }
        });
        
        b5.setBounds(600,200,120,75);
        buttonGroup.add(b5);
        b5.addActionListener(new ActionListener(){
            @Override
         public void actionPerformed(ActionEvent e){
                if (flag == 1) {
                    JOptionPane.showMessageDialog(null, "There are no notifications for you !!");
                } else {
                 Notify n = new Notify(str);
                 frame.setVisible(false);
                }
             }
        });
        
        b6.setBounds(0,0,120,25);
        buttonGroup.add(b6);
        b6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    LoginWindow m = new LoginWindow();
            }
        });
        
        b7.setBounds(755,0,120,25);
        buttonGroup.add(b7);
        b7.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    LoginWindow m = new LoginWindow();
            }
        });
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(b7);
        panel.add(welcome);
        panel.add(name);
        panel.add(Image2);
        frame.setVisible(true);
    }
}