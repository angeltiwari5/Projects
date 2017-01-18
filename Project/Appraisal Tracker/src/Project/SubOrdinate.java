
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

public class SubOrdinate extends NewWindow {
    int p, b, pc, o, fin;
    int m1,m2,m3,m4,flg = 0;
    String id, obj, obj1;
    JComboBox cb2,cb;
    JSlider pes,bs,ps,os;
    
    JButton submit = new JButton("Submit");
    JButton back = new JButton("Back");
    JButton logout = new JButton("Logout");
    
    JLabel sub = new JLabel("Sub-Ordinate ID :");
    JLabel task = new JLabel("Task ID :");
    JLabel perform = new JLabel("Performance :");
    JLabel behave = new JLabel("Behavior :");
    JLabel puntual = new JLabel("Puntuality :");
    JLabel obediant = new JLabel("Obediance :");
    
    SubOrdinate(String str) {
        id = str;
         //id = "user_002";
         
         sub.setFont(new Font("Segoe UI", Font.BOLD, 18));
         sub.setForeground(Color.BLUE);
         sub.setBounds(20,70,180,20);
         
         task.setFont(new Font("Segoe UI", Font.BOLD, 18));
         task.setForeground(Color.BLUE);
         task.setBounds(20,120,180,20);
         
         perform.setFont(new Font("Segoe UI", Font.BOLD, 18));
         perform.setForeground(Color.BLUE);
         perform.setBounds(20,170,180,20);
         
         behave.setFont(new Font("Segoe UI", Font.BOLD, 18));
         behave.setForeground(Color.BLUE);
         behave.setBounds(20,220,180,20);
         
         puntual.setFont(new Font("Segoe UI", Font.BOLD, 18));
         puntual.setForeground(Color.BLUE);
         puntual.setBounds(20,270,180,20);
         
         obediant.setFont(new Font("Segoe UI", Font.BOLD, 18));
         obediant.setForeground(Color.BLUE);
         obediant.setBounds(20,320,180,20);
         
         cb2 = new JComboBox();
         cb2.setBounds(200,70,320,30);
         cb2.addItem("--- Select ---");
         c = new JDBCConnection();
         try {
             String paq;
             s = c.Connect.createStatement();
             rs = s.executeQuery("select employee_id from superior where superior_id = '" + id + "'");
             while (rs.next()) {
                 paq = rs.getString("employee_id");
                 if (paq != null) {
                     cb2.addItem(paq);
                 }
             }
         } catch (SQLException fe) {
             System.out.println(fe.getMessage());
         }
         cb2.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent ie){
                 String str = (String)cb2.getSelectedItem();
                 obj = str;
            }
         });
         
         cb = new JComboBox();
         cb.addItem("--- Select ---");
         cb.setBounds(200,120,320,30);
         c = new JDBCConnection();
         try {
             String paq;
             s = c.Connect.createStatement();
             rs = s.executeQuery("select task_id from tasks where task = 'a'");
             while (rs.next()) {
                 paq = rs.getString("task_id");
                 if (paq != null) {
                     cb.addItem(paq);
                 }
             }
         } catch (SQLException fe) {
             System.out.println(fe.getMessage());
         }
         cb.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent ie){
                 String str = (String)cb.getSelectedItem();
                 obj1 = str;
            }
         });
         
         pes = new JSlider();
         pes.setBounds(200,170,320,30);
         pes.addChangeListener(new MyChangeAction1());
         pes.setValue(50);
         pes.setMajorTickSpacing(10);
         pes.setPaintTicks(true);
         pes.setSnapToTicks(true);
         pes.setPaintTrack(true);
         pes.setBorder(BorderFactory.createLineBorder(Color.white));
        
         bs = new JSlider();
         bs.setBounds(200,220,320,30);
         bs.addChangeListener(new MyChangeAction2());
         bs.setValue(50);
         bs.setMajorTickSpacing(10);
         bs.setPaintTicks(true);
         bs.setSnapToTicks(true);
         bs.setPaintTrack(true);
         bs.setBorder(BorderFactory.createLineBorder(Color.white));
         
         ps = new JSlider();
         ps.setBounds(200,270,320,30);
         ps.addChangeListener(new MyChangeAction3());
         ps.setValue(50);
         ps.setMajorTickSpacing(10);
         ps.setPaintTicks(true);
         ps.setSnapToTicks(true);
         ps.setPaintTrack(true);
         ps.setBorder(BorderFactory.createLineBorder(Color.white));
         
         os = new JSlider();
         os.setBounds(200,320,320,30);
         os.addChangeListener(new MyChangeAction4());
         os.setValue(50);
         os.setMajorTickSpacing(10);
         os.setPaintTicks(true);
         os.setSnapToTicks(true);
         os.setPaintTrack(true);
         os.setBorder(BorderFactory.createLineBorder(Color.white));
         
         submit.setBounds(420,380,100,30);
         submit.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 c = new JDBCConnection();
                 try {
                     s = c.Connect.createStatement();
                     rs = s.executeQuery("select * from measure");
                     while(rs.next()) {
                        m1 = rs.getInt("performance");
                        m2 = rs.getInt("behavior");
                        m3 = rs.getInt("puntuality");
                        m4 = rs.getInt("obediance");
                 }
                 fin = ((m1 * p) + (m2 * b) + (m3 * pc) + (m4 * o)) / (m1 + m2 + m3 + m4);
                 rs = s.executeQuery("update rate set superior_rate = '" + fin + "' where task_id = '" + obj1 +"'");
                 s.executeQuery("insert into notify values ('"+obj+"','You have been rated by a superior and your rating is "+fin+"',0)");
                 JOptionPane.showMessageDialog(null,"U have given ur Subordinate rating is '"+fin+"'!!");
                 } catch (SQLException fe) {
                     System.out.println(fe.getMessage());
                 }
                 frame.setVisible(false);
                 SubOrdinate s = new SubOrdinate(id);
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
         
         panel.add(sub);
         panel.add(task);
         panel.add(perform);
         panel.add(behave);
         panel.add(puntual);
         panel.add(obediant);
         panel.add(cb);
         panel.add(cb2);
         panel.add(pes);
         panel.add(os);
         panel.add(bs);
         panel.add(ps);
         panel.add(submit);
         panel.add(back);
         panel.add(logout);
         panel.add(Image2);
         frame.setVisible(true);
    }
    
    public class MyChangeAction1 implements ChangeListener{
        @Override
        public void stateChanged(ChangeEvent e){
            int value1 = pes.getValue();
            p = value1;
        }
    }
   
    public class MyChangeAction2 implements ChangeListener{
        @Override
        public void stateChanged(ChangeEvent e){
            int value2 = bs.getValue();
            b = value2;
        }
    }
   
    public class MyChangeAction3 implements ChangeListener{
        @Override
        public void stateChanged(ChangeEvent e){
            int value3 = ps.getValue();
            pc = value3;
        }
    }
   
    public class MyChangeAction4 implements ChangeListener{
        @Override
        public void stateChanged(ChangeEvent e){
            int value4 = os.getValue();
            o = value4;
        }
    }
}