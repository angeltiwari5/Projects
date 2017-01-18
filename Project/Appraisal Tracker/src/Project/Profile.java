
/**
 *
 * @author MS Dhoni (C) (wk)
 */

package Project;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Profile extends NewWindow {
    String []str = new String[6];
    String st;
    ImageIcon img = new ImageIcon("p.jpg");
    /*JDBCConnection c = new JDBCConnection();
    Statement st = null;
    ResultSet rs = null;
    JFrame frame = new JFrame("Profile Window :");
    
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    
    ImageIcon i = new ImageIcon("background.jpg");
    ImageIcon i1 = new ImageIcon("avn_logo.jpg");
    ImageIcon i2 = new ImageIcon("background1.jpg");
    
    JLabel Image = new JLabel(i);
    JLabel Image1 = new JLabel(i1);
    JLabel Image2 = new JLabel(i2);*/
    JLabel Img = new JLabel(img);
    JLabel name, name1, dob, dob1, gender, gender1, email, email1, city, city1, id, id1;
    
    JButton back = new JButton("Back");
    JButton logout = new JButton("Logout");
    JButton edit = new JButton("Edit Profile");
    
    Profile(String strng) {
        //frame = new JFrame("Profile :");
        st = strng;
        
        Img.setBounds(700,60,175,200);
        /*Image.setBounds(342,0,658,125);
        Image1.setBounds(0,0,341,124);
        Image2.setBounds(0,0,875,575);*/
        
        edit.setBounds(699,261,176,40);
        edit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    EditProfile p = new EditProfile(st);
            }
        });
        
        back.setBounds(0,0,120,25);
        back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    User u = new User(st);
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
        
        try {
            rs = null;
            c = new JDBCConnection();
            s = c.Connect.createStatement();
            rs = s.executeQuery("select * from profile, users where employee_id = user_id and user_id = '" + st + "'");
            rs.next();
            str[0] = rs.getString("name");
            str[1] = rs.getString("dob");
            str[2] = rs.getString("gender");
            str[3] = rs.getString("email_id");
            str[4] = rs.getString("city");
            str[5] = rs.getString("employee_id");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        
        name = new JLabel("Name         : ");
        name.setBounds(50,50,200,50);
        name.setFont(new Font("Bradley Hand ITC", Font.PLAIN, 30));
        name.setForeground(Color.BLUE);
        name1 = new JLabel(str[0]);
        name1.setFont(new Font("Bradley Hand ITC", Font.BOLD, 30));
        name1.setForeground(Color.WHITE);
        name1.setBounds(275,50,425,50);
        
        dob = new JLabel("Born on      : ");
        dob.setBounds(50,100,200,50);
        dob.setFont(new Font("Bradley Hand ITC", Font.BOLD, 30));
        dob.setForeground(Color.BLUE);
        dob1 = new JLabel(str[1]);
        dob1.setFont(new Font("Bradley Hand ITC", Font.BOLD, 30));
        dob1.setForeground(Color.WHITE);
        dob1.setBounds(275,100,500,50);
        
        gender = new JLabel("Gender       : ");
        gender.setBounds(50,150,200,50);
        gender.setFont(new Font("Bradley Hand ITC", Font.BOLD, 30));
        gender.setForeground(Color.BLUE);
        gender1 = new JLabel(str[2]);
        gender1.setFont(new Font("Bradley Hand ITC", Font.BOLD, 30));
        gender1.setForeground(Color.WHITE);
        gender1.setBounds(275,150,500,50);
        
        email = new JLabel("Email ID     : ");
        email.setBounds(50,300,200,50);
        email.setFont(new Font("Bradley Hand ITC", Font.BOLD, 30));
        email.setForeground(Color.BLUE);
        email1 = new JLabel(str[3]);
        email1.setFont(new Font("Bradley Hand ITC", Font.BOLD, 30));
        email1.setForeground(Color.WHITE);
        email1.setBounds(275,300,500,50);
        
        city = new JLabel("City             : ");
        city.setBounds(50,200,200,50);
        city.setFont(new Font("Bradley Hand ITC", Font.BOLD, 30));
        city.setForeground(Color.BLUE);
        city1 = new JLabel(str[4]);
        city1.setFont(new Font("Bradley Hand ITC", Font.BOLD, 30));
        city1.setForeground(Color.WHITE);
        city1.setBounds(275,200,400,50);
        
        id = new JLabel("ID No.         : ");
        id.setBounds(50,250,200,50);
        id.setFont(new Font("Bradley Hand ITC", Font.BOLD, 30));
        id.setForeground(Color.BLUE);
        id1 = new JLabel(str[5]);
        id1.setFont(new Font("Bradley Hand ITC", Font.BOLD, 30));
        id1.setForeground(Color.WHITE);
        id1.setBounds(275,250,500,50);
        

        panel.add(name);
        panel.add(name1);
        panel.add(dob);
        panel.add(dob1);
        panel.add(gender);
        panel.add(gender1);
        panel.add(email);
        panel.add(email1);
        panel.add(city);
        panel.add(city1);
        panel.add(id);
        panel.add(id1);
        panel.add(edit);
        panel.add(back);
        panel.add(logout);
        panel.add(Img);
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