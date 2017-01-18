
/**
 *
 * @author MS Dhoni (C) (wk)
 */

package Project;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AllotTask extends NewWindow {
    String id, id1, m, m1, obj, obj1, post,post1;
    ResultSet rs1, rs7;
    JComboBox cb, cb2;
    
    JButton submit = new JButton("Submit");
    JButton back = new JButton("Back");
    JButton logout = new JButton("Logout");
    
    JLabel k1, k2;
    JLabel sub = new JLabel("Sub-Ordinate :");
    JLabel task = new JLabel("Task ID :");
    JLabel deadline = new JLabel("Deadline :");
    JLabel date = new JLabel("Allot Date :");
    
    AllotTask(String str,String post){
        id1 = str;
        post1 = post;
        sub.setFont(new Font("Verdana", Font.ITALIC, 18));
        sub.setForeground(Color.RED);
        sub.setBounds(20,70,180,20);
        
        task.setFont(new Font("Verdana", Font.ITALIC, 18));
        task.setForeground(Color.RED);
        task.setBounds(20,120,180,20);
        
        date.setFont(new Font("Verdana", Font.ITALIC, 18));
        date.setForeground(Color.RED);
        date.setBounds(20,180,180,20);
         
        deadline.setFont(new Font("Verdana", Font.ITALIC, 18));
        deadline.setForeground(Color.RED);
        deadline.setBounds(20,230,180,20);
        
        cb2 = new JComboBox();
        cb2.setBounds(200,70,320,30);
        try {
             String pa;
             c = new JDBCConnection();
             s = c.Connect.createStatement();
             rs = s.executeQuery("select employee_id from superior where superior_id = '" + id1 + "'");
             cb2.addItem("--- Select ---");
             while(rs.next())
             { 
                 pa = rs.getString("employee_id");
                 if (pa != null)
                 {
                     cb2.addItem(pa);
                 }
             }
             rs1 = s.executeQuery("select add_months(sysdate,6) from dual");
             while(rs1.next())
             {   
                 m1 = rs1.getString("add_months(sysdate,6)");
             }
         }
         catch (SQLException fe)
         {
             System.err.println(fe.getMessage());
         }
         cb2.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent ie){
                String str = (String)cb2.getSelectedItem();
                obj = str;
                   }
         });
             /*  try {
                    rs = null;
                    rs = s.executeQuery("select portfolio from profile where employee_id = '" + id1 + "'");
                    rs.next();
                    post = rs.getString("portfolio");
                    
                     post1 = post;
               // System.out.println(post1+"this");
               
               /* String course[] = {"","Chairman","Md","General Manager","Project Manager","Employee"};
                for(int j=0;j<6;j++){
                    if(post.equals(course[j])){
                        System.out.println(course[j]);
                        post1 = course[j+1];
                        
                    }
                }
                } catch (SQLException fe) {
                        System.err.println(fe.getMessage());
                }
               // System.out.println(post1+"this 2");
         */
         
         cb = new JComboBox();
         cb.setBounds(200,120,180,30);
         cb.addItem("--- Select ---");
         try
            {
             String pa1;
             c = new JDBCConnection();
             s = c.Connect.createStatement();
             rs = s.executeQuery("select sysdate from dual");
             while(rs.next())
             {   
                 m = (String)rs.getString("sysdate");
             }
             System.out.println(post);
             rs1 = s.executeQuery("select task_id from tasks where course = '" + post1 + "' and task = 'u'");
             while(rs1.next())
             {   
                 pa1 = rs1.getString("task_id");
                 if(pa1 != null)
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
               }
         });
         
         submit.setBounds(250,340,100,30);
         submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    c = new JDBCConnection();
                    try {
                        s = c.Connect.createStatement();
                        if (obj != null && obj1 != null) {
                            rs7 = s.executeQuery("update tasks set task = 'a' where (task_id = '" + obj1 + "')");
                            rs7=s.executeQuery("insert into emp_task values('"+obj1+"','"+obj+"','"+id1+"')");
                            //rs7=s.executeQuery("update task set task='a' where task_id = '"+obj1+"' ");
                            rs7=s.executeQuery("insert into rate values('"+obj+"','"+obj1+"',0,0)");
                            s.executeQuery("insert into notify values ('"+obj+"','You have been alloted a task of task_id "+obj1+" by superior "+id1+"',0)");
                            JOptionPane.showMessageDialog(null,"Task has been allotted successfully !!");
                        } else {
                            JOptionPane.showMessageDialog(null,"Please select sub-ordinate and allot a task !!");
                        }
                        frame.setVisible(false);
                        User a = new User(id1);
                    } catch (SQLException fe) {
                        System.err.println(fe.getMessage());
                    }
            }
         });
         
         back.setBounds(0,0,120,25);
         back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    User u = new User(id1);
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
         
         k1 = new JLabel(m);
         k1.setFont(new Font("Verdana", Font.ITALIC, 12));
         k1.setBounds(200,150,180,90);
        
         k2 = new JLabel(m1);
         k2.setFont(new Font("Verdana", Font.ITALIC, 12));
         k2.setBounds(200,200,180,90);
         
         panel.add(sub);
         panel.add(task);
         panel.add(deadline);
         panel.add(date);
         panel.add(k1);
         panel.add(k2);
         panel.add(cb);
         panel.add(cb2);
         panel.add(submit);
         panel.add(back);
         panel.add(logout);
         panel.add(Image2);
         frame.setVisible(true);
    }
}