package student.information.in.java;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StudentInfo extends JFrame implements ActionListener{
    
   JLabel lbl_sid,lbl_fname,lbl_lname,lbl_std,lbl_dob,lbl_mo,lbl_email,lbl_city,lbl_state,lbl_addr,lbl_title;
   JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
   JButton btn_add,btn_update,btn_delete,btn_search,btn_exit;
   
   Connection con;
   Statement st;
   ResultSet rs;
  
    StudentInfo(){
        
            super("Student Information");
            setLayout(null);
    
             lbl_title = new JLabel("Student Information",JLabel.CENTER);
             add(lbl_title);
             lbl_title.setBounds(70, 05, 450, 30);
             
            lbl_sid = new JLabel("Student Id :");
            add(lbl_sid);
            lbl_sid.setBounds(100, 40, 100, 30);
            
            t1 = new JTextField();
            add(t1);
            t1.setBounds(230, 45, 250, 22);
            t1.setToolTipText("Enter Student ID");
            
            lbl_fname = new JLabel("First Name :");
            add(lbl_fname);
            lbl_fname.setBounds(100, 80, 100, 30);
            
            t2 = new JTextField();
            add(t2);
            t2.setBounds(230, 85, 250, 22);
            t2.setToolTipText("Enter First Name");
             
            lbl_lname = new JLabel("Last Name :");
            add(lbl_lname);
            lbl_lname.setBounds(100, 120, 100, 30);
            
            t3 = new JTextField();
            add(t3);
            t3.setBounds(230, 125, 250, 22);
            t3.setToolTipText("Enter Last Name");
            
            lbl_std = new JLabel("Standard :");
            add(lbl_std);
            lbl_std.setBounds(100, 160, 100, 30);
            
            t4 = new JTextField();
            add(t4);
            t4.setBounds(230, 165, 250, 22);
            t4.setToolTipText("Enter Standard");
            
            lbl_dob = new JLabel("Date Of Birth :");
            add(lbl_dob);
            lbl_dob.setBounds(100, 200, 150, 30);
            
            t5 = new JTextField();
            add(t5);
            t5.setBounds(230, 205, 250, 22);
            t5.setToolTipText("Enter Date Of Birth");
            
            lbl_mo = new JLabel("Mobile No :");
            add(lbl_mo);
            lbl_mo.setBounds(100, 240, 100, 30);
            
            t6 = new JTextField();
            add(t6);
            t6.setBounds(230, 245, 250, 22);
            t6.setToolTipText("Enter Mobile No");
            
            lbl_email = new JLabel("Email :");
            add(lbl_email);
            lbl_email.setBounds(100, 280, 100, 30);
            
            t7 = new JTextField();
            add(t7);
            t7.setBounds(230, 285, 250, 22);
            t7.setToolTipText("Enter Email");
            
            lbl_city = new JLabel("State :");
            add(lbl_city);
            lbl_city.setBounds(100, 320, 100, 30);
            
            t8 = new JTextField();
            add(t8);
            t8.setBounds(230, 325, 250, 22);
            t8.setToolTipText("Enter State");
            
            lbl_state = new JLabel("Address :");
            add(lbl_state);
            lbl_state.setBounds(100, 360, 100, 30);
            
            t9 = new JTextField();
            add(t9);
            t9.setBounds(230, 365, 250, 22);
            t9.setToolTipText("Enter Address");
            
            lbl_addr = new JLabel("City :");
            add(lbl_addr);
            lbl_addr.setBounds(100, 400, 100, 30);
            
            t10 = new JTextField();
            add(t10);
            t10.setBounds(230, 405, 250, 22);
            t10.setToolTipText("Enter City");  
             
            btn_add= new JButton("Add");
            add(btn_add);
            btn_add.setBounds(50, 450, 100, 30);
            
            btn_delete= new JButton("Delete");
            add(btn_delete);
            btn_delete.setBounds(160, 450, 100, 30);           
            
            btn_search= new JButton("Search");
            add(btn_search);
            btn_search.setBounds(270, 450, 100, 30);
            btn_exit = new JButton("Cancel");
            add(btn_exit);
            btn_exit.setBounds(380, 450, 100, 30);
            
            btn_update= new JButton("Update");
            add(btn_update);
            btn_update.setBounds(50, 500, 100, 30);
            
            btn_add.addActionListener(this);
            btn_delete.addActionListener(this);
            btn_search.addActionListener(this);
            btn_exit.addActionListener(this);
            btn_update.addActionListener(this);
            
    }
    
    public  Connection getConnection(){
        
       try{
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","system","amit");
            st = con.createStatement();
          
            
        }catch(Exception ex){
                System.out.println(ex);
           JOptionPane.showMessageDialog(null, "Failed Connection","Error",JOptionPane.ERROR_MESSAGE);
        }
        
        return con;
    }
    
    public  void SearchRecord(){
        
            con = getConnection();
            
            String sid = null,fname = null,lname = null,std = null,dob = null,mo = null,email = null,city = null,state = null,addr = null;
            
            String query = "select * from info where ID like '"+t1.getText()+"'";
            
            try{
                st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                
                while(rs.next()){
                    
                    sid = rs.getString("ID");
                    fname = rs.getString("Fname");
                    lname = rs.getString("Lname");
                    std = rs.getString("Standard");
                    dob = rs.getString("DOB");
                    mo = rs.getString("MobileNo");
                    email = rs.getString("Email");
                    state = rs.getString("State");
                    addr = rs.getString("Address");
                    city = rs.getString("City");
                   
                    
                    
                }
                st.close();
                con.close();
                
            }catch(Exception ex){
                
                System.err.println(ex.getMessage());
            }
            
            t1.setText(sid);
            t2.setText(fname);
            t3.setText(lname);
            t4.setText(std);
            t5.setText(dob);
            t6.setText(mo);
            t7.setText(email);
            t8.setText(state);
            t9.setText(addr);
            t10.setText(city);
            
            if(t1.getText().equals("") && t2.getText().equals("") && t3.getText().equals("") && t4.getText().equals("") && t5.getText().equals("") && t6.getText().equals("") && t7.getText().equals("") && t8.getText().equals("") && t9.getText().equals("") && t10.getText().equals("")){
                
                JOptionPane.showMessageDialog(null, "Search Record Not Found,Try Again","Error",JOptionPane.ERROR_MESSAGE);
                
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t8.setText("");
                t9.setText("");
                t10.setText("");
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Search Record Found","Message",JOptionPane.INFORMATION_MESSAGE);          
                 t1.setText(sid);
                 t2.setText(fname);
                 t3.setText(lname);
                 t4.setText(std);
                 t5.setText(dob);
                 t6.setText(mo);
                 t7.setText(email);
                 t8.setText(state);
                 t9.setText(addr);
                 t10.setText(city);
            
            }
                
    }
    
    public void InsertRecord(){
        
        
        if(t1.getText().length()==0 || t2.getText().length()==0 || t3.getText().length()==0 || t4.getText().length()==0 || t5.getText().length()==0 || t6.getText().length()==0 || t7.getText().length()==0 || t8.getText().length()==0 || t9.getText().length()==0 || t10.getText().length()==0){
            
            JOptionPane.showMessageDialog(null, "Please Required All Field","Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
            con = getConnection();
        String query = "insert into info values('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"','"+t6.getText()+"','"+t7.getText()+"','"+t8.getText()+"','"+t9.getText()+"','"+t10.getText()+"')";
        try{
            st = con.createStatement();
            st.executeQuery(query);
            st.close();
            con.close();
            
        }catch(Exception ex){
            
            System.err.println(ex.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Record Saved Successfully...","Success",JOptionPane.INFORMATION_MESSAGE);
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t8.setText("");
                t9.setText("");
                t10.setText("");
        }
                
    }
    
    public void DeleteRecord(){
        
        con = getConnection();
        
        int rply = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Delete Record","Delete",JOptionPane.YES_NO_OPTION);
        
        if(rply==JOptionPane.YES_OPTION){
             String query = "delete from info where ID like '"+t1.getText()+"'";
        
        try{
            st = con.createStatement();
            st.executeQuery(query);
            
            st.close();
            con.close();
            
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
       JOptionPane.showMessageDialog(null, "Record Deleted..","Message",JOptionPane.INFORMATION_MESSAGE);
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t8.setText("");
                t9.setText("");
                t10.setText("");
    }
        else{
            
            
            
        }
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btn_add){
            
           InsertRecord();
            
        }
        
        if(e.getSource()==btn_delete){
            DeleteRecord();
        }
        
         if(e.getSource()==btn_search){
            
             SearchRecord();
        
         }
       
        if(e.getSource()==btn_exit){
            
            int reply = JOptionPane.showConfirmDialog(null, "Are Sure You Want To Exit ","Message",JOptionPane.YES_NO_OPTION);
            
            if(reply==JOptionPane.YES_OPTION){
                
                System.exit(0);
            }
            
        }
        
        if(e.getSource()==btn_update){
            
             update();
        
         }
       
    
    }
    
    public  void update(){
        
            if(t1.getText().length()==0 || t2.getText().length()==0 || t3.getText().length()==0 || t4.getText().length()==0 || t5.getText().length()==0 || t6.getText().length()==0 || t7.getText().length()==0 || t8.getText().length()==0 || t9.getText().length()==0 || t10.getText().length()==0){
            
            JOptionPane.showMessageDialog(null, "Please Required All Field","Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
            con = getConnection();
        String query = "update info set ID = '"+t1.getText()+"' , Fname = '"+t2.getText()+"' , Lname = '"+t3.getText()+"' , Standard = '"+t4.getText()+"' , DOB = '"+t5.getText()+"' , mobileno = '"+t6.getText()+"' , email = '"+t7.getText()+"' , state='"+t8.getText()+"' , address='"+t9.getText()+"',city='"+t10.getText()+"' where id='"+t1.getText()+"'";
        try{
            st = con.createStatement();
            st.executeQuery(query);
            st.close();
            con.close();
            
        }catch(Exception ex){
            
            System.err.println(ex.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Record Saved Successfully...","Success",JOptionPane.INFORMATION_MESSAGE);
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t8.setText("");
                t9.setText("");
                t10.setText("");
        }
                
    }
    
    
}
