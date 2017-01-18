
/**
 *
 * @author MS Dhoni (C) (wk)
 */

package Project;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class EditProfile extends NewWindow {
    ResultSet rs1 = null;
    String id;
    JLabel New;
    
    JTextField NEW = new JTextField();
    
    JButton name = new JButton("Change Name");
    JButton username = new JButton("Change Username");
    JButton password = new JButton("Change Password");
    JButton dob = new JButton("Change Date Of Birth");
    JButton email = new JButton("Change Email ID");
    JButton city = new JButton("Change City");
    JButton back = new JButton("Back");
    JButton logout = new JButton("Logout");
    JButton line = new JButton();
    JButton submit = new JButton("Submit");
    
    EditProfile(String strng) {
        id = strng;
            
        name.setBounds(75,75,175,30);
        name.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    New = new JLabel("New Name :");
                    New.setBounds(450,100,300,50);
                    New.setFont(new Font("Verdina", Font.PLAIN, 30));
                    New.setForeground(Color.BLUE);
        
                    NEW.setBounds(550,150,200,40);
        
                    submit.setBounds(650,210,100,30);
                    submit.addActionListener(new ActionListener() {
                         String str, pass1;
                         @Override
                         public void actionPerformed(ActionEvent e) {
                             JLabel pass = new JLabel("Enter Password :");
                             final JPasswordField Pass = new JPasswordField();
                             JButton sub = new JButton("Submit");
                             pass.setBounds(450,250,300,50);
                             pass.setFont(new Font("Verdina", Font.PLAIN, 30));
                             pass.setForeground(Color.BLUE);
                             Pass.setBounds(550,300,200,40);
                             str = NEW.getText();
                             sub.setBounds(650,375,100,30);
                             sub.addActionListener(new ActionListener() {
                                  @Override
                                  public void actionPerformed(ActionEvent e) {
                                  try {
                                       pass1 = Pass.getText();
                                       c = new JDBCConnection();
                                       s = c.Connect.createStatement();
                                       rs = s.executeQuery("select password from users where (user_id = '" + id + "')");
                                       rs.next();
                                       if (rs.getString(1).equals(pass1)) {
                                            rs = s.executeQuery("update profile set name = '" + str + "' where (employee_id = '" + id + "')");
                                            JOptionPane.showMessageDialog(null,"Name changed successfully !!");
                                            frame.setVisible(false);
                                            EditProfile p = new EditProfile(id);
                                       } else {
                                            JOptionPane.showMessageDialog(null,"Wrong Password\nCannot change the name !!");
                                            frame.setVisible(false);
                                            EditProfile p = new EditProfile(id);
                                        }
                                    } catch (SQLException sq) {
                                           System.err.println(sq.getMessage());
                                    }
                                 }
                             });
                             panel.add(pass);
                             panel.add(Pass);
                             panel.add(sub);
                             panel.add(Image2);
                             frame.setVisible(false);
                             frame.setVisible(true);
                         }
                    });
                    line.setBounds(250,78,175,2);
                    panel.add(line);
                    panel.add(submit);
                    panel.add(New);
                    panel.add(NEW);
                    panel.add(Image2);
                    frame.setVisible(false);
                    frame.setVisible(true);
            }
        });
        
        username.setBounds(75,125,175,30);
        username.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    New = new JLabel("New UserName :");
                    New.setBounds(450,100,300,50);
                    New.setFont(new Font("Verdina", Font.PLAIN, 30));
                    New.setForeground(Color.BLUE);
        
                    NEW.setBounds(550,150,200,40);
        
                    submit.setBounds(650,210,100,30);
                    submit.addActionListener(new ActionListener() {
                         String str, pass1;
                         @Override
                         public void actionPerformed(ActionEvent e) {
                             JLabel pass = new JLabel("Enter Password :");
                             final JPasswordField Pass = new JPasswordField();
                             JButton sub = new JButton("Submit");
                             pass.setBounds(450,250,300,50);
                             pass.setFont(new Font("Verdina", Font.PLAIN, 30));
                             pass.setForeground(Color.BLUE);
                             Pass.setBounds(550,300,200,40);
                             str = NEW.getText();
                             sub.setBounds(650,375,100,30);
                             sub.addActionListener(new ActionListener() {
                                  @Override
                                  public void actionPerformed(ActionEvent e) {
                                  try {
                                       pass1 = Pass.getText();
                                       c = new JDBCConnection();
                                       s = c.Connect.createStatement();
                                       rs = s.executeQuery("select password from users where (user_id = '" + id + "')");
                                       rs.next();
                                       if (rs.getString(1).equals(pass1)) {
                                            rs = s.executeQuery("update users set username = '" + str + "' where (user_id = '" + id + "')");
                                            JOptionPane.showMessageDialog(null,"UserName changed successfully !!");
                                            frame.setVisible(false);
                                            EditProfile p = new EditProfile(id);
                                       } else {
                                            JOptionPane.showMessageDialog(null,"Wrong Password\nCannot change the UserName !!");
                                            frame.setVisible(false);
                                            EditProfile p = new EditProfile(id);
                                        }
                                    } catch (SQLException sq) {
                                           System.err.println(sq.getMessage());
                                    }
                                 }
                             });
                             panel.add(pass);
                             panel.add(Pass);
                             panel.add(sub);
                             panel.add(Image2);
                             frame.setVisible(false);
                             frame.setVisible(true);
                         }
                    });
                    line.setBounds(250,128,175,2);
                    panel.add(line);
                    panel.add(submit);
                    panel.add(New);
                    panel.add(NEW);
                    panel.add(Image2);
                    frame.setVisible(false);
                    frame.setVisible(true);
            }
        });
        
        password.setBounds(75,175,175,30);
        password.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JLabel New1 = new JLabel("Retype Password :");
                    final JPasswordField NEW1 = new JPasswordField();
                    final JPasswordField NEW2 = new JPasswordField();
                    
                    New1.setBounds(400,150,250,50);
                    New1.setFont(new Font("Verdina", Font.PLAIN, 30));
                    New1.setForeground(Color.BLUE);
                    
                    New = new JLabel("New Password :");
                    New.setBounds(400,100,250,50);
                    New.setFont(new Font("Verdina", Font.PLAIN, 30));
                    New.setForeground(Color.BLUE);
        
                    NEW1.setBounds(670,100,170,40);
                    NEW2.setBounds(670,150,170,40);
        
                    submit.setBounds(740,210,100,30);
                    submit.addActionListener(new ActionListener() {
                         String str, str1, pass1;
                         @Override
                         public void actionPerformed(ActionEvent e)  {
                             str = NEW1.getText();
                             str1 = NEW2.getText();
                             if (str.equals(str1)) {
                             JLabel pass = new JLabel("Enter Old Password :");
                             final JPasswordField Pass = new JPasswordField();
                             JButton sub = new JButton("Submit");
                             pass.setBounds(400,250,300,50);
                             pass.setFont(new Font("Verdina", Font.PLAIN, 30));
                             pass.setForeground(Color.BLUE);
                             Pass.setBounds(550,300,200,40);
                             sub.setBounds(740,375,100,30);
                             sub.addActionListener(new ActionListener() {
                                  @Override
                                  public void actionPerformed(ActionEvent e) {
                                  try {
                                       pass1 = Pass.getText();
                                       c = new JDBCConnection();
                                       s = c.Connect.createStatement();
                                       rs1 = s.executeQuery("select password from users where (user_id = '" + id + "')");
                                       rs1.next();
                                       if (rs1.getString("password").equals(pass1)) {
                                            s.executeQuery("update users set password = '" + str + "' where (user_id = '" + id + "')");
                                            JOptionPane.showMessageDialog(null,"Password changed successfully !!");
                                            frame.setVisible(false);
                                            EditProfile p = new EditProfile(id);
                                       } else {
                                            JOptionPane.showMessageDialog(null,"Wrong Password\nCannot change the Password !!");
                                            frame.setVisible(false);
                                            EditProfile p = new EditProfile(id);
                                        }
                                    } catch (SQLException sq) {
                                           System.err.println(sq.getMessage());
                                    }
                                  } 
                             });
                             panel.add(pass);
                             panel.add(Pass);
                             panel.add(sub);
                             panel.add(Image2);
                             frame.setVisible(false);
                             frame.setVisible(true);
                             } else {
                                 JOptionPane.showMessageDialog(null,"Wrong Inputs\nCannot change the Password !!");
                                 frame.setVisible(false);
                                 EditProfile p = new EditProfile(id);
                             }
                         }
                    });
                    line.setBounds(250,178,125,2);
                    panel.add(line);
                    panel.add(submit);
                    panel.add(New);
                    panel.add(New1);
                    panel.add(NEW1);
                    panel.add(NEW2);
                    panel.add(Image2);
                    frame.setVisible(false);
                    frame.setVisible(true);
            }
        });
        
        dob.setBounds(75,225,175,30);
        dob.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    New = new JLabel("New Date Of Birth :");
                    New.setBounds(450,100,300,50);
                    New.setFont(new Font("Verdina", Font.PLAIN, 30));
                    New.setForeground(Color.BLUE);
        
                    NEW.setBounds(550,150,200,40);
        
                    submit.setBounds(650,210,100,30);
                    submit.addActionListener(new ActionListener() {
                         String str, pass1;
                         @Override
                         public void actionPerformed(ActionEvent e) {
                             JLabel pass = new JLabel("Enter Password :");
                             final JPasswordField Pass = new JPasswordField();
                             JButton sub = new JButton("Submit");
                             pass.setBounds(450,250,300,50);
                             pass.setFont(new Font("Verdina", Font.PLAIN, 30));
                             pass.setForeground(Color.BLUE);
                             Pass.setBounds(550,300,200,40);
                             str = NEW.getText();
                             sub.setBounds(650,375,100,30);
                             sub.addActionListener(new ActionListener() {
                                  @Override
                                  public void actionPerformed(ActionEvent e) {
                                  try {
                                       pass1 = Pass.getText();
                                       c = new JDBCConnection();
                                       s = c.Connect.createStatement();
                                       rs = s.executeQuery("select password from users where (user_id = '" + id + "')");
                                       rs.next();
                                       if (rs.getString(1).equals(pass1)) {
                                            rs = s.executeQuery("update profile set dob = '" + str + "' where (employee_id = '" + id + "')");
                                            JOptionPane.showMessageDialog(null,"Date Of Birth changed successfully !!");
                                            frame.setVisible(false);
                                            EditProfile p = new EditProfile(id);
                                       } else {
                                            JOptionPane.showMessageDialog(null,"Wrong Password\nCannot change the Date Of Birth !!");
                                            frame.setVisible(false);
                                            EditProfile p = new EditProfile(id);
                                        }
                                    } catch (SQLException sq) {
                                           System.err.println(sq.getMessage());
                                    }
                                 }
                             });
                             panel.add(pass);
                             panel.add(Pass);
                             panel.add(sub);
                             panel.add(Image2);
                             frame.setVisible(false);
                             frame.setVisible(true);
                         }
                    });
                    line.setBounds(250,228,175,2);
                    panel.add(line);
                    panel.add(submit);
                    panel.add(New);
                    panel.add(NEW);
                    panel.add(Image2);
                    frame.setVisible(false);
                    frame.setVisible(true);
            }
        });
        
        email.setBounds(75,275,175,30);
        email.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    New = new JLabel("New Email ID :");
                    New.setBounds(450,100,300,50);
                    New.setFont(new Font("Verdina", Font.PLAIN, 30));
                    New.setForeground(Color.BLUE);
        
                    NEW.setBounds(550,150,200,40);
        
                    submit.setBounds(650,210,100,30);
                    submit.addActionListener(new ActionListener() {
                         String str, pass1;
                         @Override
                         public void actionPerformed(ActionEvent e) {
                             JLabel pass = new JLabel("Enter Password :");
                             final JPasswordField Pass = new JPasswordField();
                             JButton sub = new JButton("Submit");
                             pass.setBounds(450,250,300,50);
                             pass.setFont(new Font("Verdina", Font.PLAIN, 30));
                             pass.setForeground(Color.BLUE);
                             Pass.setBounds(550,300,200,40);
                             str = NEW.getText();
                             sub.setBounds(650,375,100,30);
                             sub.addActionListener(new ActionListener() {
                                  @Override
                                  public void actionPerformed(ActionEvent e) {
                                  try {
                                       pass1 = Pass.getText();
                                       c = new JDBCConnection();
                                       s = c.Connect.createStatement();
                                       rs = s.executeQuery("select password from users where (user_id = '" + id + "')");
                                       rs.next();
                                       if (rs.getString(1).equals(pass1)) {
                                            rs = s.executeQuery("update profile set email_id = '" + str + "' where (employee_id = '" + id + "')");
                                            JOptionPane.showMessageDialog(null,"Email ID changed successfully !!");
                                            frame.setVisible(false);
                                            EditProfile p = new EditProfile(id);
                                       } else {
                                            JOptionPane.showMessageDialog(null,"Wrong Password\nCannot change the Email ID !!");
                                            frame.setVisible(false);
                                            EditProfile p = new EditProfile(id);
                                        }
                                    } catch (SQLException sq) {
                                           System.err.println(sq.getMessage());
                                    }
                                 }
                             });
                             panel.add(pass);
                             panel.add(Pass);
                             panel.add(sub);
                             panel.add(Image2);
                             frame.setVisible(false);
                             frame.setVisible(true);
                         }
                    });
                    line.setBounds(250,278,175,2);
                    panel.add(line);
                    panel.add(submit);
                    panel.add(New);
                    panel.add(NEW);
                    panel.add(Image2);
                    frame.setVisible(false);
                    frame.setVisible(true);
            }
        });
        
        city.setBounds(75,325,175,30);
        city.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    New = new JLabel("New City :");
                    New.setBounds(450,100,300,50);
                    New.setFont(new Font("Verdina", Font.PLAIN, 30));
                    New.setForeground(Color.BLUE);
        
                    NEW.setBounds(550,150,200,40);
        
                    submit.setBounds(650,210,100,30);
                    submit.addActionListener(new ActionListener() {
                         String str, pass1;
                         @Override
                         public void actionPerformed(ActionEvent e) {
                             JLabel pass = new JLabel("Enter Password :");
                             final JPasswordField Pass = new JPasswordField();
                             JButton sub = new JButton("Submit");
                             pass.setBounds(450,250,300,50);
                             pass.setFont(new Font("Verdina", Font.PLAIN, 30));
                             pass.setForeground(Color.BLUE);
                             Pass.setBounds(550,300,200,40);
                             str = NEW.getText();
                             sub.setBounds(650,375,100,30);
                             sub.addActionListener(new ActionListener() {
                                  @Override
                                  public void actionPerformed(ActionEvent e) {
                                  try {
                                       pass1 = Pass.getText();
                                       c = new JDBCConnection();
                                       s = c.Connect.createStatement();
                                       rs = s.executeQuery("select password from users where (user_id = '" + id + "')");
                                       rs.next();
                                       if (rs.getString(1).equals(pass1)) {
                                            rs = s.executeQuery("update profile set city = '" + str + "' where (employee_id = '" + id + "')");
                                            JOptionPane.showMessageDialog(null,"City changed successfully !!");
                                            frame.setVisible(false);
                                            EditProfile p = new EditProfile(id);
                                       } else {
                                            JOptionPane.showMessageDialog(null,"Wrong Password\nCannot change the City !!");
                                            frame.setVisible(false);
                                            EditProfile p = new EditProfile(id);
                                        }
                                    } catch (SQLException sq) {
                                           System.err.println(sq.getMessage());
                                    }
                                 }
                             });
                             panel.add(pass);
                             panel.add(Pass);
                             panel.add(sub);
                             panel.add(Image2);
                             frame.setVisible(false);
                             frame.setVisible(true);
                         }
                    });
                    line.setBounds(250,328,175,2);
                    panel.add(line);
                    panel.add(submit);
                    panel.add(New);
                    panel.add(NEW);
                    panel.add(Image2);
                    frame.setVisible(false);
                    frame.setVisible(true);
            }
        });
        
        back.setBounds(0,0,120,25);
        back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    Profile p = new Profile(id);
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
        panel.add(username);
        panel.add(password);
        panel.add(dob);
        panel.add(email);
        panel.add(city);
        panel.add(back);
        panel.add(logout);
        panel.add(Image2);
        frame.setVisible(true);
    }
}