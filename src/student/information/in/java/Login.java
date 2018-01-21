package student.information.in.java;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
       
        JLabel l1,l2,lbl_title;
        JTextField t1,t2;
        JButton b1,b2,b3;
        ResultSet rs;
        PreparedStatement ps;
        Statement st;
        Connection con;
     
        Login(){
              super("Login Form");
              setLayout(null);
             
            
            lbl_title = new JLabel("Login ",JLabel.CENTER);
            add(lbl_title);
            lbl_title.setBounds(70, 10, 200, 30);
                        
            l1 = new JLabel("User Name :");
            add(l1);
            l1.setBounds(20, 50, 170, 30);
            
            t1 = new JTextField();
            t1.setToolTipText("Enter UserName");
            add(t1);
            t1.setBounds(120, 55, 200, 22);
                        
            l2 = new JLabel("Password   :");
            add(l2);
            l2.setBounds(20, 85, 150, 20);
                        
            t2 = new JPasswordField();
            t2.setToolTipText("Enter Password");
            add(t2);
            t2.setBounds(120, 85, 200, 22);
            
            b1 = new JButton("Login");
            add(b1);
            b1.setBounds(80, 130,100, 30);
            
            b2 = new JButton("Cancel");
            add(b2);
            b2.setBounds(200, 130, 100, 30);
            
            b3 = new JButton("Create New Account");
            add(b3);
            b3.setBounds(90, 190, 200, 30);
                 
            b1.addActionListener(this);
            b2.addActionListener(this);
            b3.addActionListener(this);
              
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
                String s1="",s2="";
                String user =t1.getText();
                String pass =t2.getText();
                
                
                if(user.length()==0 || pass.length()==0){
                    
                    JOptionPane.showMessageDialog(null, "Invalid user or pass,try again","error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                {
                 try{
                     st = con.createStatement();
                     rs = st.executeQuery("select * from reg where UserName='"+t1.getText()+"' AND Password='"+t2.getText()+"'");
                      
                   while(rs.next()){
                       
                       s1 = rs.getString("UserName");
                       s2 = rs.getString("Password");
                               
                   } 
                   if(!s1.equals(t1.getText()) || !s2.equals(t2.getText())){
                       
                       JOptionPane.showMessageDialog(null, "Invalid Field,try again","Error Message",JOptionPane.ERROR_MESSAGE);
                       t1.setText("");
                       t2.setText("");
                   }
                   else
                   {
                       JOptionPane.showMessageDialog(null, "Login Successfullyy....","Message",JOptionPane.INFORMATION_MESSAGE);
                      StudentInfo si = new StudentInfo();       
                      si.setVisible(true);
                      si.setSize(600, 600);
                       t1.setText("");
                       t2.setText("");
                      dispose();
                   }          
                    }catch(Exception ex){
                     
                      
                 }
                }
                }
             }
              
             if(e.getSource()==b2){
                 
                 int reply = JOptionPane.showConfirmDialog(null, "Are you Sure you want to exit ?","Message",JOptionPane.YES_NO_OPTION);
                    
                 if(reply==JOptionPane.YES_OPTION){
                    
                     System.exit(0);
                 }
                 
             }
             
             if(e.getSource()==b3){
                 
                Register rg = new Register();
                 rg.setVisible(true);
                 rg.setBounds(100, 100, 400, 400);
                dispose();
                 
             }
            
        }
        
    public static void main(String[] args) {
       Login lg = new Login();
       lg.setVisible(true);
       lg.setSize(400, 350);
       lg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
    
}
