package student.information.in.java;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;


public class Register extends JFrame implements ActionListener{
    
     JLabel l1,l2,l3,l4,lbl_title;
    JTextField t1,t2,t3,t4;
    JButton b1,b2;
    ResultSet rs;
    PreparedStatement ps;
    Statement st;
    Connection con;
    Register(){
        super("Registration Form");
        setLayout(null);
   
         lbl_title = new JLabel("Register",JLabel.CENTER);
         add(lbl_title);
         lbl_title.setBounds(70, 10, 250, 30);
                     
        l1 = new JLabel("UserName :");
        add(l1);
        l1.setBounds(30, 50, 100, 30);
        
        t1 = new JTextField();
        add(t1);
        t1.setBounds(130, 55, 200, 22);
        
        t1.setToolTipText("Enter UserName");
        
        l2 = new JLabel("Password :");
        add(l2);
        l2.setBounds(30, 80, 100, 30);
        
        t2 = new JPasswordField();
        add(t2);
        t2.setBounds(130, 85, 200, 22);
        t2.setToolTipText("Enter Password");
         
        l3 = new JLabel("Email :");
        add(l3);
        l3.setBounds(30, 110, 100, 30);
        
        t3 = new JTextField();
        add(t3);
        t3.setBounds(130, 115, 200, 22);
        t3.setToolTipText("Enter Email");
        
        l4 = new JLabel("Mobile No: ");
        add(l4);
        l4.setBounds(30, 140, 200, 30);
        
        t4 = new JTextField();
        add(t4);
        t4.setBounds(130, 145, 200, 22);
        t4.setToolTipText("Enter Mobile No");
         
        b1 = new JButton("Register");
        add(b1);
        b1.setBounds(50, 200, 100, 30);
         
        b2 = new JButton("Cancel");
        add(b2);
        b2.setBounds(180, 200, 100, 30);
         
        b1.addActionListener(this);
        b2.addActionListener(this);
  
          try{
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","system","amit");
            st = con.createStatement();
          
            
        }catch(Exception ex){
                System.out.println(ex);
           JOptionPane.showMessageDialog(null, "Failed Connection","Error",JOptionPane.ERROR_MESSAGE);
        }
          
         
    }
    public void actionPerformed(ActionEvent e){
        
       if(e.getSource()==b1){
           
           try{
       String s1="",s2="",s3="",s4="";
       String str_user=t1.getText();
       String str_pass=t2.getText();
       String str_email=t3.getText();
       String str_mobile=t4.getText();
       
            
            if(str_user.length()==0 && str_pass.length()==0 && str_email.length()==0 && str_mobile.length()==0){
                
                JOptionPane.showMessageDialog(null, "Please Required All Field ?", "Error",JOptionPane.ERROR_MESSAGE);
           
            }
           
           else if(!s1.equals("'") || !s2.equals("'") ||!s3.equals("'") ||!s4.equals("'")){
              
                  
               String query =("insert into reg values('"+str_user+"','"+str_pass+"','"+str_email+"','"+str_mobile+"')");
               st = con.createStatement();
               st.executeUpdate(query);
               
               JOptionPane.showMessageDialog(null, "Registration Successfully....", "Message",JOptionPane.INFORMATION_MESSAGE);
               
               Login l = new Login();
               l.setVisible(true);
               l.setSize(400, 350);
               dispose();
               
               t1.setText("");
               t2.setText("");
               t3.setText("");
               t4.setText("");
               st.close();
              
                
            }
          
            
           }catch(Exception ex){
               
               
           }
       }
       
       if(e.getSource()==b2){
           
           int reply = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Exit ?","Message",JOptionPane.YES_NO_OPTION);
           
           if(reply==JOptionPane.YES_OPTION){
               
               System.exit(0);
           }
       }
}
}