import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.text.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import java.util.Date;

public class teacherpage{

	
public  teacherpage(String a)
{
//	System.out.println("whoa!");
	final JFrame teacherpg = new JFrame("Teacher page");
		Container p= teacherpg.getContentPane();
		Insets i = p.getInsets();
		p.setLayout(null);
		Dimension size;
		teacherpg.setVisible(true);
		teacherpg.setExtendedState(JFrame.MAXIMIZED_BOTH);
		teacherpg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel welcome = new JLabel();
		welcome.setText("welcome " + a +"!");
		p.add(welcome);
		size=welcome.getPreferredSize();
	welcome.setBounds(1250 + i.left, 0 + i.top , 0 + size.width , 0 + size.height);
	//welcome.setFont(new Font("calibri",Font.BOLD,25));

	/////////////////  adding tabs in this area/*
	
	//System.out.println("I am here!");

	JTabbedPane tabs = new JTabbedPane();
	tabs.addTab("My class time table",new mytimetable(a));
	
	tabs.addTab("My free time table",new freetimetable(a));
	tabs.addTab("My lab time table",new labtimetable(a));
	tabs.addTab("Internals time table",new internaltimetable());
	teacherpg.add(tabs);
	//Container pa = teacherpg.getContentPane();
    //pa.setLayout(null);
     size = tabs.getPreferredSize();
        tabs.setBounds(0 + i.left ,  100 + i.top, 1200+  size.width, 525 +  size.height);
    
		
		//System.out.println("I am here!");

	
	
	/// logout button
        JButton logout = new JButton("Logout");
        size = logout.getPreferredSize();
        logout.setBounds(1240 + i.left, 23 + i.top , 30 + size.width , 10 + size.height);
        p.add(logout);
        
        logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			
				new LoginPage();
				teacherpg.dispose();
			}
		});
        
        ///// logout button ends
        
	
	
	//////////////////       adding tabs in this area
	
	
	
	
	
	
	JLabel name = new JLabel();
	JLabel desigl = new JLabel();
	JLabel expl = new JLabel();
	Connection conn;
	//System.out.println("I am here!");

	Statement st= null;
	ResultSet r = null;
	try
	{
		//Load the JDBC Driver
		//System.out.println("I am here!");

		String driverName="oracle.jdbc.driver.OracleDriver";
		Class.forName(driverName);
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");

		
		
		String query = "select fname,lname,designation,joindate from teacherdetails where username='"+a+"'";
		st= conn.createStatement();
		r = st.executeQuery(query);
		
		
		String fname,lname,designation,name1;
		//Date joindate;
		while(r.next())
		{ 
		
			
			fname=r.getString(1);				
			lname=r.getString(2);
			designation=r.getString(3);
			//joindate=r.getString(4);
			name1="Name: " + fname + " "+lname;
			name = new JLabel();
			name.setText(  name1 );
			p.add(name);
			size=name.getPreferredSize();
		name.setBounds(10 + i.left, 0 + i.top , 70 + size.width , 10 + size.height);
		desigl = new JLabel();
		desigl.setText("Designation: "+ designation );
		p.add(desigl);
		size=desigl.getPreferredSize();
	desigl.setBounds(10 + i.left, 20 + i.top , 70 + size.width , 25 + size.height);
	
	 name.setFont(new Font("Calibri",Font.ITALIC,25));
	 desigl.setFont(new Font("Calibri",Font.ITALIC,25));
	 

	
			
			
		}
		//System.out.println("I came here!");

		query = "select extract(year from joindate) from teacherdetails where username='"+a+"'";
		r= st.executeQuery(query);
		while(r.next())
		{
		int year = Integer.parseInt(r.getString(1));
		//System.out.println("I came here!");
		Date dNow = new Date(0);
	       SimpleDateFormat ft = 
	       new SimpleDateFormat ("yyyy");
	       	String temp = ft.format(dNow);
	       	year = year - Integer.parseInt(temp);
	       //	System.out.println(ft.format(dNow));
	       	
	     expl = new JLabel();
	    	expl.setText("Experience: " + year +"years" );
	    	p.add(expl);
	    	size=expl.getPreferredSize();
	    expl.setBounds(10 + i.left, 40 + i.top , 150 + size.width , 35 + size.height);
	    expl.setFont(new Font("Calibri",Font.ITALIC,25));
		//System.out.println("i"); 
		
		}
		
		
		
	    //System.out.println("Connected to Oracle Database");
		 conn.close();   
		 st.close();
		 
		 //System.out.print("came hre");
	}
	
	catch(ClassNotFoundException e)
	{
		 JOptionPane.showMessageDialog(teacherpg,
	               "Not connected to the database!");
		//System.out.println("Not connected to the database");
	}
	catch(SQLException e)
	{
		 JOptionPane.showMessageDialog(teacherpg,
	               "Not connected to the database!");
		//System.out.println("Not coonected to the driver");
	}


		
	
}
	
public static void main(String agrs[])
{
	SwingUtilities.invokeLater(new Runnable() { 
	    public void run() { 
	       new teacherpage("r"); 
	     } 
	  }); 
		
}
	
	
}