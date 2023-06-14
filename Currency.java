import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;


class CurrencyConverter extends JFrame implements ActionListener
{
    JFrame jb = new JFrame("CurrencyConverter");
    JLabel title,countryname1,countryname2,ea;
    JButton convert,reset;
    JTextField t1,t2,ans;
   JComboBox cb,cb2;
   LineBorder line;
    public CurrencyConverter()
    {
        setLayout(null);
        title=new JLabel("WELCOME TO Currency Converter APP");
        countryname1=new JLabel("Currency Name");
        countryname2=new JLabel("Currency Name");
        String country[]={"Rupee","Dollar","Pound"};        
        cb=new JComboBox(country);  
        cb2=new JComboBox(country);    
        convert=new JButton("Convert Now");
        reset = new JButton("Reset");
        t1=new JTextField();
        t2=new JTextField();
        ans=new JTextField();
        title.setBounds(290,-15,600,100);
        title.setForeground(Color.RED);
        title.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        countryname1.setBounds(80,150, 100, 100);
        cb.setBounds(300, 180,120,50); 
        t1.setBounds(500, 230, 400,50);
        countryname2.setBounds(80,220, 100, 100);
        cb2.setBounds(300, 250,120,50); 
        ea=new JLabel("Enter the ammount:");
        ea.setBounds(500, 170, 400, 100);
        t2.setBounds(200, 50, 600,100);
        t2.setBackground(Color.BLACK);
        t2.setForeground(Color.WHITE);
        t2.setFont(new Font("Times New Roman",Font.PLAIN,30));
        line = new LineBorder(Color.blue, 2, true);
        t2.setBorder(line);

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        convert.setBounds(300,350,200,50);
        reset.setBounds(550,350,200,50);
        convert.setCursor(cursor);
        reset.setCursor(cursor);
        add(cb);
        add(cb2);
        add(title);
        add(countryname1);
        add(countryname2);
        add(convert);
        add(reset);
        add(t1);
        add(t2);
        add(ea);
        convert.addActionListener(this);
        reset.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windoeClosing(WindowEvent we){
                System.exit(0);
            }
        });

    }
    public void actionPerformed(ActionEvent ae){
        double d1,d2,ans;
  d1=Double.parseDouble(t1.getText());
        String fans="";
        JPanel panel = new JPanel();
        if(ae.getSource()==convert){
            // d1=Double.parseDouble(t1.getText());
            if(d1<=0){
               JOptionPane.showMessageDialog(panel, "Enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
            }
           if( (cb.getSelectedItem().equals("Rupee")) && (cb2.getSelectedItem().equals("Dollar")))
           {
            ans = d1*0.012;
              t2.setText("Rupee-Dollar"+":-"+ans);

           }
           else if((cb.getSelectedItem().equals("Dollar")) && (cb2.getSelectedItem().equals("Rupee"))){
              ans = d1*82;
              t2.setText("Dollar-Rupee"+":-"+ans);
           }
            else if((cb.getSelectedItem().equals("Rupee")) && (cb2.getSelectedItem().equals("Pound"))){
              ans = d1*0.0096;
              t2.setText("Rupee-Pound"+":-"+ans);
              ans=0;
           }
            else if((cb.getSelectedItem().equals("Pound")) && (cb2.getSelectedItem().equals("Rupee"))){
               ans = d1*103.71;
              t2.setText("Pound-Rupee"+":-"+ans);
              ans=0;
           }
            else if((cb.getSelectedItem().equals("Dollar")) && (cb2.getSelectedItem().equals("Pound"))){
                      ans = d1*0.79;
                  t2.setText("Dollar-Pound"+":-"+ans);
                  ans=0;
           }
            else if((cb.getSelectedItem().equals("Pound")) && (cb2.getSelectedItem().equals("Dollar"))){
                  ans = d1*1.26;
                  t2.setText("Pound-Dollar"+":-"+ans);
                  ans=0;
           }
       
         
        }
        else if(ae.getSource()==reset){
            t1.setText(" ");
            t2.setText("");
        }
    }
}
public class Currency{
    public static void main(String[] args) {
        CurrencyConverter c = new CurrencyConverter();
        c.setTitle("My Currency Converter");
        c.setSize(1000,700);
        c.setVisible(true);
        c.getContentPane().setBackground(Color.CYAN);
 
    }
}