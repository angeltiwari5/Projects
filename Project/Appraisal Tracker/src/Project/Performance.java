
/**
 *
 * @author MS Dhoni (C) (wk)
 */

package Project;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Performance extends NewWindow {
    int valuePerform, valueBehave, valuePuntual, valueObediant;
    
    JLabel perform = new JLabel("Performance :");
    JLabel behave = new JLabel("Behavior :");
    JLabel puntual = new JLabel("Puntuality :");
    JLabel obediant = new JLabel("Obediance :");
    JLabel per = new JLabel();
    JLabel beh = new JLabel();
    JLabel pun = new JLabel();
    JLabel obe = new JLabel();
    
    JSlider performance = new JSlider();
    JSlider behavior = new JSlider();
    JSlider puntuality = new JSlider();
    JSlider obediance = new JSlider();
    
    JButton submit = new JButton("Submit");
    JButton back = new JButton("Back");
    JButton logout = new JButton("Logout");
    
    Performance () {
        per.setBounds(700,50,50,50);
        per.setFont(new Font("Verdina", Font.PLAIN, 30));
        per.setForeground(Color.WHITE);
        
        perform.setBounds(50,50,200,50);
        perform.setFont(new Font("Verdina", Font.PLAIN, 30));
        perform.setForeground(Color.BLUE);
        
        beh.setBounds(700,135,50,50);
        beh.setFont(new Font("Verdina", Font.PLAIN, 30));
        beh.setForeground(Color.WHITE);
        
        behave.setBounds(50,135,200,50);
        behave.setFont(new Font("Verdina", Font.PLAIN, 30));
        behave.setForeground(Color.BLUE);
        
        pun.setBounds(700,210,50,50);
        pun.setFont(new Font("Verdina", Font.PLAIN, 30));
        pun.setForeground(Color.WHITE);
        
        puntual.setBounds(50,210,200,50);
        puntual.setFont(new Font("Verdina", Font.PLAIN, 30));
        puntual.setForeground(Color.BLUE);
        
        obe.setBounds(700,305,50,50);
        obe.setFont(new Font("Verdina", Font.PLAIN, 30));
        obe.setForeground(Color.WHITE);
        
        obediant.setBounds(50,305,200,50);
        obediant.setFont(new Font("Verdina", Font.PLAIN, 30));
        obediant.setForeground(Color.BLUE);
        
        performance.setBounds(200,95,500,35);
        performance.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                valuePerform = performance.getValue();
                per.setText(Integer.toString(valuePerform));
            }
        });
        performance.setValue(50);
        performance.setMinorTickSpacing(5);
        performance.setMajorTickSpacing(10);
        performance.setPaintTicks(true);
        performance.setSnapToTicks(true);
        performance.setPaintTrack(true);
        performance.setBorder(BorderFactory.createLineBorder(Color.white));
        
        behavior.setBounds(200,180,500,35);
        behavior.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                valueBehave = behavior.getValue();
                beh.setText(Integer.toString(valueBehave));
            }
        });
        behavior.setValue(50);
        behavior.setMinorTickSpacing(5);
        behavior.setMajorTickSpacing(10);
        behavior.setPaintTicks(true);
        behavior.setSnapToTicks(true);
        behavior.setPaintTrack(true);
        behavior.setBorder(BorderFactory.createLineBorder(Color.white));
        
        puntuality.setBounds(200,265,500,35);
        puntuality.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                valuePuntual = puntuality.getValue();
                pun.setText(Integer.toString(valuePuntual));
            }
        });
        puntuality.setValue(50);
        puntuality.setMinorTickSpacing(5);
        puntuality.setMajorTickSpacing(10);
        puntuality.setPaintTicks(true);
        puntuality.setSnapToTicks(true);
        puntuality.setPaintTrack(true);
        puntuality.setBorder(BorderFactory.createLineBorder(Color.white));
        
        obediance.setBounds(200,350,500,35);
        obediance.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                valueObediant = obediance.getValue();
                obe.setText(Integer.toString(valueObediant));
            }
        });
        obediance.setValue(50);
        obediance.setMinorTickSpacing(5);
        obediance.setMajorTickSpacing(10);
        obediance.setPaintTicks(true);
        obediance.setSnapToTicks(true);
        obediance.setPaintTrack(true);
        obediance.setBorder(BorderFactory.createLineBorder(Color.white));
        
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
        
        submit.setBounds(755,425,100,30);
        submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        c = new JDBCConnection();
                        s = c.Connect.createStatement();
                        if (valuePerform != 0 || valueBehave != 0 || valuePuntual != 0 || valueObediant != 0) {
                            s.executeQuery("delete from measure");
                            s.executeQuery("insert into measure values('" + valuePerform + "','" + valueBehave + "','" + valuePuntual + "','" + valueObediant + "')");
                            JOptionPane.showMessageDialog(null,"Measures updated successfully !!");
                            frame.setVisible(false);
                            Admin a = new Admin();
                        } else {
                            JOptionPane.showMessageDialog(null,"Please change the measures !!");
                        }
                    } catch (SQLException se) {
                        System.err.println(se.getMessage());
                    }
            }
        });
        
        panel.add(per);
        panel.add(beh);
        panel.add(pun);
        panel.add(obe);
        panel.add(perform);
        panel.add(behave);
        panel.add(puntual);
        panel.add(obediant);
        panel.add(performance);
        panel.add(behavior);
        panel.add(puntuality);
        panel.add(obediance);
        panel.add(back);
        panel.add(logout);
        panel.add(submit);
        panel.add(Image2);
        frame.setVisible(true);
    }
}