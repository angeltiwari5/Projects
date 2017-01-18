
/**
 *
 * @author MS Dhoni (C) (wk)
 */

package Project;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.*;

public class SelfRate extends NewWindow {
    String id, obj1;
    int rate1;
    JLabel l;
    JLabel self = new JLabel("Self Rate :");
    JLabel task = new JLabel("Task :");
    JLabel rate = new JLabel("Rating :");
    
    JSlider slider = new JSlider();
    JComboBox cb;
    
    JButton submit = new JButton("Submit");
    JButton back = new JButton("Back");
    JButton logout = new JButton("Logout");
    
    SelfRate(String str) {
         id = str;
         l = new JLabel();
         l.setBounds(200,170,60,60);
         l.setForeground(Color.WHITE);
         l.setFont(new Font("Verdana", Font.ITALIC, 24));
         
         task.setFont(new Font("Verdana", Font.ITALIC, 22));
         task.setForeground(Color.BLUE);
         task.setBounds(20,125,180,20);
         
         rate.setFont(new Font("Verdana", Font.ITALIC, 22));
         rate.setForeground(Color.BLUE);
         rate.setBounds(20,185,180,25);
         
         slider.setValue(65);
         slider.addChangeListener(new MyChangeAction());
         slider.setMajorTickSpacing(10);
         slider.setPaintLabels(true);
         slider.setBorder(BorderFactory.createLineBorder(Color.black));
         slider.setBounds(40,270,480,30);
         slider.setBackground(Color.GRAY);
         
         cb = new JComboBox();
         cb.setBounds(200,120,180,30);
         cb.addItem("--- Select ---");
         try {
             String pa1; 
             c = new JDBCConnection();
             s = c.Connect.createStatement();
             rs = s.executeQuery("select TASK_ID from emp_task where employee_id = '"+ id +"' ");
             while(rs.next())
             {   
                 pa1 = rs.getString("TASK_ID");
                 if(pa1!=null)
                 {
                     cb.addItem(pa1);
                 }
             }
         }
         catch (SQLException fe)
         {
             System.err.println(fe.getMessage());
         }
         cb.addItemListener(new ItemListener(){
             @Override
             public void itemStateChanged(ItemEvent ie){
                String str1 = (String)cb.getSelectedItem();
                obj1 = str1;
                System.out.println(str1);
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
         
         submit.setBounds(350,330,170,40);
         submit.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent e){
             try
             {
                 String pa1 = null;
                 c = new JDBCConnection();
                 s = c.Connect.createStatement();
                 rs = s.executeQuery("update rate set self_rate = '" + rate1 + "' where task_id = '" + obj1 + "'");
                 JOptionPane.showMessageDialog(null,"Self Rating has been done for the given task !!");
            } catch (SQLException fe) {
                 System.err.println(fe.getMessage());
            }
            SelfRate sr = new SelfRate(id);
            frame.setVisible(false);
            }
         });
         
         panel.add(l);
         panel.add(self);
         panel.add(task);
         panel.add(rate);
         panel.add(slider);
         panel.add(cb);
         panel.add(submit);
         panel.add(back);
         panel.add(logout);
         panel.add(Image2);
         frame.setVisible(true);
    }
    public class MyChangeAction implements ChangeListener{
        @Override
        public void stateChanged(ChangeEvent e){
            int value = slider.getValue();
            rate1 = value;
            String str = Integer.toString(value);
            l.setText(str);
        }
    }
}