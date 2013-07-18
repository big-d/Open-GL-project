import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;



public class admin {
	
    
    JFrame frm;
  //  JPanel panel1;
    JTabbedPane jtp;
 
    
    admin()
    {
        frm=new JFrame("ADMIN PAGE");
        frm.setVisible(true);
        frm.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        Container p=frm.getContentPane();
        Dimension size;
     Insets i=p.getInsets();
     p.setLayout(null);
     JButton cleartt=new JButton("Clear Time Table details");
     JButton clearl=new JButton("Clear Login details");
     JButton cleart=new JButton("Clear Teacher details");
     size=cleartt.getPreferredSize();
     cleartt.setBounds(10+i.left,0+i.top,100+size.width,15+size.height);
     size=clearl.getPreferredSize();
     clearl.setBounds(10+i.left,50+i.top,130+size.width,15+size.height);
     size=cleart.getPreferredSize();
     cleart.setBounds(10+i.left,100+i.top,115+size.width,15+size.height);
     p.add(cleartt);
     p.add(clearl);
     p.add(cleart);
     JButton logout = new JButton("Logout");
     size = logout.getPreferredSize();
     logout.setBounds(1240 + i.left, 23 + i.top , 30 + size.width , 10 + size.height);
     p.add(logout);
logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			
				new LoginPage();
				frm.dispose();
			}
		});
     
        jtp=new JTabbedPane();
        jtp.addTab("1st Semester",new sem1details());
        jtp.addTab("3rd Semester",new sem2details());
        jtp.addTab("5th Semester",new sem3details());
        jtp.addTab("7th Semester",new sem4details());
       size=jtp.getPreferredSize();
       jtp.setBounds(0+i.left,10+i.top,50+size.width,50+size.height);
        frm.add(jtp);
        size = jtp.getPreferredSize();
        jtp.setBounds(0+i.left,150+i.top,1500+size.width,1000+size.height);
        
     
        String driverName = "oracle.jdbc.driver.OracleDriver";
        final String query = "delete from timetable";
        cleartt.addActionListener(new ActionListener() {
        	Connection conn = null;
			Statement   s ;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try
			{
				//Load the JDBC Driver
				
				Class.forName("oracle.jdbc.driver.OracleDriver");

				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
			    //System.out.println("Connected to Oracle Database");
				
				 
				 System.out.println(query);
				  s=conn.createStatement();
				  s.executeQuery(query);
				 //System.out.println("I am here");
				  //System.out.println("I am here");
				 //System.out.println(r.next());
				 //while(r.next())
				  JOptionPane.showInputDialog(
			               "Deleted!");
				
				 conn.commit();
				 
				// new teacherpage(a);
				 
			}
			
			catch(ClassNotFoundException et)
			{
				 JOptionPane.showInputDialog(
			               "Not connected to the database!");
				
				//System.out.println("Not connected to the database");
			}
			catch(SQLException et)
			{
				
				
				 JOptionPane.showInputDialog(
			               "Database error!!");
				//System.out.println("Not coonected to the driver");
			}
			
			
			
			
			
			
			
		}
	})  ;
        
        
final String query1 = "delete from teacherdetails";
        cleart.addActionListener(new ActionListener() {
        	Connection conn = null;
			Statement   s ;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try
			{
				//Load the JDBC Driver
				
				Class.forName("oracle.jdbc.driver.OracleDriver");

				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
			    //System.out.println("Connected to Oracle Database");
				
				 
				 System.out.println(query1);
				  s=conn.createStatement();
				  s.executeQuery(query1);
				 //System.out.println("I am here");
				  //System.out.println("I am here");
				 //System.out.println(r.next());
				 //while(r.next())
				  JOptionPane.showInputDialog(
			               "Deleted!");
				
				 conn.commit();
				 
				// new teacherpage(a);
				 
			}
			
			catch(ClassNotFoundException et)
			{
				 JOptionPane.showInputDialog(
			               "Not connected to the database!");
				
				//System.out.println("Not connected to the database");
			}
			catch(SQLException et)
			{
				
				
				 JOptionPane.showInputDialog(
			               "Database error!!");
				//System.out.println("Not coonected to the driver");
			}
			
			
			
			
			
			
			
		}
	})  ;
        

final String query2 = "delete from logindetails";        
        clearl.addActionListener(new ActionListener() {
        	Connection conn = null;
			Statement   s ;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try
			{
				//Load the JDBC Driver
				
				Class.forName("oracle.jdbc.driver.OracleDriver");

				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
			    //System.out.println("Connected to Oracle Database");
				
				 
				 System.out.println(query2);
				  s=conn.createStatement();
				  s.executeQuery(query2);
				 //System.out.println("I am here");
				  //System.out.println("I am here");
				 //System.out.println(r.next());
				 //while(r.next())
				  JOptionPane.showInputDialog(
			               "Deleted!");
				
				 conn.commit();
				 
				// new teacherpage(a);
				 
			}
			
			catch(ClassNotFoundException et)
			{
				 JOptionPane.showInputDialog(
			               "Not connected to the database!");
				
				//System.out.println("Not connected to the database");
			}
			catch(SQLException et)
			{
				
				
				 JOptionPane.showInputDialog(
			               "Database error!!");
				//System.out.println("Not coonected to the driver");
			}
			
			
			
			
			
			
			
		}
	})  ;
        

        
        
        
        
        
        
        
        
        
        
        
      
    }
    public static void main(String args[])
    {
    	SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new admin();
				
			}
		});
    }

}