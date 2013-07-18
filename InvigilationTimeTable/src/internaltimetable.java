import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class internaltimetable extends JPanel {
	
	public internaltimetable() {
		// TODO Auto-generated constructor stub
	
	JButton firstsem = new JButton("First semseter");
	JButton thirdsem = new JButton("Third semester");
	JButton fifthsem = new JButton("Fifth semester");
	JButton seventhsem = new JButton("Seventh semester");
	add(firstsem);
	add(thirdsem);
	add(fifthsem);
	add(seventhsem);
	setLayout(null);
	Dimension size;
	Insets i  = getInsets();
	
	size= firstsem.getPreferredSize();
	firstsem.setBounds(50 + i.left ,  20 + i.top , 100 + size.width , 50 + size.height);
	

	size= thirdsem.getPreferredSize();
	thirdsem.setBounds(1000 + i.left ,  20 + i.top , 100 + size.width , 50 + size.height);
	

	size= fifthsem.getPreferredSize();
	fifthsem.setBounds(50 + i.left ,  100 + i.top , 100 + size.width , 50 + size.height);
	

	size= seventhsem.getPreferredSize();
	seventhsem.setBounds(1000 + i.left ,  100 + i.top , 100 + size.width , 50 + size.height);
	
	
	///////////////////////////// first semester timetable display 
	 ////////////// display timetable starts
    firstsem.addActionListener(new ActionListener() {
		
		
		String driverName="oracle.jdbc.driver.OracleDriver";
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		///////// figure out to print the timetable of the lecturer try opening a new frame
			Statement s =null;
			ResultSet r = null;
			Connection conn = null;
					String temp[] = new String[30];
					
			 String res = null;
			 String query = "select room,username from firstsemtimetable";
			try
			{
				//Load the JDBC Driver
				
				Class.forName(driverName);

				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
			    //System.out.println("Connected to Oracle Database");
				  s = conn.createStatement();
				 
				 System.out.println(query);
				  r = s.executeQuery(query);
				 System.out.println("I am here");
				  System.out.println("I am here");
				 //System.out.println(r.next());
				  JFrame tempo = new JFrame("My Time Table");
					 
					 Container p = tempo.getContentPane();
					 Dimension size;
					 Insets i = p.getInsets();
					 p.setLayout(null);
					 tempo.setVisible(true);
					 tempo.setExtendedState(JFrame.MAXIMIZED_BOTH);
					 tempo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					/// adding 15 jlabels here! I know it's crazy!! :P
					  JLabel j1 = new JLabel();
					tempo.add(j1);
					 size=j1.getPreferredSize();
					 
					 j1.setBounds(0 + i.left,  0 + i.top , 900 + size.width ,  200 + size.height);	
				  
					 JLabel j2 = new JLabel();
						tempo.add(j2);
						 size=j2.getPreferredSize();
						 
						 j2.setBounds(0 + i.left,  20 + i.top , 900 + size.width ,  200 + size.height);	
					  
						 JLabel j3 = new JLabel();
							tempo.add(j3);
							 size=j3.getPreferredSize();
							 
							 j3.setBounds(0 + i.left,  40 + i.top , 900 + size.width ,  200 + size.height);	
						  
							 JLabel j4 = new JLabel();
								tempo.add(j4);
								 size=j4.getPreferredSize();
								 
								 j4.setBounds(0 + i.left,  60 + i.top , 900 + size.width ,  200 + size.height);	
							  
								 JLabel j5 = new JLabel();
									tempo.add(j5);
									 size=j5.getPreferredSize();
									 
									 j5.setBounds(0 + i.left,  80 + i.top , 900 + size.width ,  200 + size.height);	
								  
									 JLabel j6 = new JLabel();
										tempo.add(j6);
										 size=j6.getPreferredSize();
										 
										 j6.setBounds(0 + i.left,  100 + i.top , 900 + size.width ,  200 + size.height);	
									  				 
										 JLabel j7 = new JLabel();
											tempo.add(j7);
											 size=j7.getPreferredSize();
											 
											 j7.setBounds(0 + i.left,  120 + i.top , 900 + size.width ,  200 + size.height);	
										  								 
											 JLabel j8 = new JLabel();
												tempo.add(j8);
												 size=j8.getPreferredSize();
												 
												 j8.setBounds(0 + i.left,  140 + i.top , 900 + size.width ,  200 + size.height);	
											  
												 JLabel j9 = new JLabel();
													tempo.add(j9);
													 size=j9.getPreferredSize();
													 
													 j9.setBounds(0 + i.left,  160 + i.top , 900 + size.width ,  200 + size.height);	
												   
													 JLabel j10 = new JLabel();
														tempo.add(j10);
														 size=j10.getPreferredSize();
														 
														 j10.setBounds(0 + i.left,  180 + i.top , 900 + size.width ,  200 + size.height);	
													  
														 JLabel j11 = new JLabel();
															tempo.add(j11);
															 size=j11.getPreferredSize();
															 
															 j11.setBounds(0 + i.left,  200 + i.top , 900 + size.width ,  200 + size.height);	
															 JLabel j12 = new JLabel();
																tempo.add(j12);
																 size=j12.getPreferredSize();
																 
																 j12.setBounds(0 + i.left,  220 + i.top , 900 + size.width ,  200 + size.height);	
															  
																 JLabel j13 = new JLabel();
																	tempo.add(j13);
																	 size=j13.getPreferredSize();
																	 
																	 j13.setBounds(0 + i.left,  240 + i.top , 900 + size.width ,  200 + size.height);	
																  
																	 JLabel j14 = new JLabel();
																		tempo.add(j14);
																		 size=j14.getPreferredSize();
																		 
																		 j4.setBounds(0 + i.left,  260 + i.top , 900 + size.width ,  200 + size.height);	
																		 JLabel j15 = new JLabel();
																			tempo.add(j15);
																			 size=j15.getPreferredSize();
																			 
																			 j15.setBounds(0 + i.left,  280 + i.top , 900 + size.width ,  200 + size.height);	
																		  
											 int ia=0;
				  
				  
				  
				  while(r.next())
				 {
					 temp[ia] = "Room :  "+r.getString(1)+"  Username:  "+r.getString(2);
					 //res=res+"\n"+temp;
					ia++;
					 
				 }
				System.out.println(res);
				 //System.out.println("I ca here");
				 
				 //j.setText(res);
				j1.setText(temp[0]);
				j2.setText(temp[1]);
				j3.setText(temp[2]);
				j4.setText(temp[3]);
				j5.setText(temp[4]);
				j6.setText(temp[5]);
				j7.setText(temp[6]);
				j8.setText(temp[7]);
				j9.setText(temp[8]);
				j10.setText(temp[9]);
				j11.setText(temp[10]);
				j12.setText(temp[11]);
				j13.setText(temp[12]);
				j14.setText(temp[13]);
				j15.setText(temp[14]);
				 //j.setFont(new Font("calibri",Font.BOLD,15));
				 conn.close();
				 s.close();
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
	});
    
    
    ////////////// display timetable ends
    
    
	
	
	//////////////////////////// first semester timetable display ends
	
	
	
	///////////////// third semester timetable diaplay starts 
    
    
    ////////////// display timetable starts
    thirdsem.addActionListener(new ActionListener() {
		
		
		String driverName="oracle.jdbc.driver.OracleDriver";
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		///////// figure out to print the timetable of the lecturer try opening a new frame
			Statement s =null;
			ResultSet r = null;
			Connection conn = null;
					String temp[] = new String[30];
					
			 String res = null;
			 String query = "select room,username from thirdsemtimetable";
			try
			{
				//Load the JDBC Driver
				
				Class.forName(driverName);

				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
			    //System.out.println("Connected to Oracle Database");
				  s = conn.createStatement();
				 
				 System.out.println(query);
				  r = s.executeQuery(query);
				 System.out.println("I am here");
				  System.out.println("I am here");
				 //System.out.println(r.next());
				  JFrame tempo = new JFrame("My Time Table");
					 
					 Container p = tempo.getContentPane();
					 Dimension size;
					 Insets i = p.getInsets();
					 p.setLayout(null);
					 tempo.setVisible(true);
					 tempo.setExtendedState(JFrame.MAXIMIZED_BOTH);
					 tempo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					/// adding 15 jlabels here! I know it's crazy!! :P
					  JLabel j1 = new JLabel();
					tempo.add(j1);
					 size=j1.getPreferredSize();
					 
					 j1.setBounds(0 + i.left,  0 + i.top , 900 + size.width ,  200 + size.height);	
				  
					 JLabel j2 = new JLabel();
						tempo.add(j2);
						 size=j2.getPreferredSize();
						 
						 j2.setBounds(0 + i.left,  20 + i.top , 900 + size.width ,  200 + size.height);	
					  
						 JLabel j3 = new JLabel();
							tempo.add(j3);
							 size=j3.getPreferredSize();
							 
							 j3.setBounds(0 + i.left,  40 + i.top , 900 + size.width ,  200 + size.height);	
						  
							 JLabel j4 = new JLabel();
								tempo.add(j4);
								 size=j4.getPreferredSize();
								 
								 j4.setBounds(0 + i.left,  60 + i.top , 900 + size.width ,  200 + size.height);	
							  
								 JLabel j5 = new JLabel();
									tempo.add(j5);
									 size=j5.getPreferredSize();
									 
									 j5.setBounds(0 + i.left,  80 + i.top , 900 + size.width ,  200 + size.height);	
								  
									 JLabel j6 = new JLabel();
										tempo.add(j6);
										 size=j6.getPreferredSize();
										 
										 j6.setBounds(0 + i.left,  100 + i.top , 900 + size.width ,  200 + size.height);	
									  				 
										 JLabel j7 = new JLabel();
											tempo.add(j7);
											 size=j7.getPreferredSize();
											 
											 j7.setBounds(0 + i.left,  120 + i.top , 900 + size.width ,  200 + size.height);	
										  								 
											 JLabel j8 = new JLabel();
												tempo.add(j8);
												 size=j8.getPreferredSize();
												 
												 j8.setBounds(0 + i.left,  140 + i.top , 900 + size.width ,  200 + size.height);	
											  
												 JLabel j9 = new JLabel();
													tempo.add(j9);
													 size=j9.getPreferredSize();
													 
													 j9.setBounds(0 + i.left,  160 + i.top , 900 + size.width ,  200 + size.height);	
												   
													 JLabel j10 = new JLabel();
														tempo.add(j10);
														 size=j10.getPreferredSize();
														 
														 j10.setBounds(0 + i.left,  180 + i.top , 900 + size.width ,  200 + size.height);	
													  
														 JLabel j11 = new JLabel();
															tempo.add(j11);
															 size=j11.getPreferredSize();
															 
															 j11.setBounds(0 + i.left,  200 + i.top , 900 + size.width ,  200 + size.height);	
															 JLabel j12 = new JLabel();
																tempo.add(j12);
																 size=j12.getPreferredSize();
																 
																 j12.setBounds(0 + i.left,  220 + i.top , 900 + size.width ,  200 + size.height);	
															  
																 JLabel j13 = new JLabel();
																	tempo.add(j13);
																	 size=j13.getPreferredSize();
																	 
																	 j13.setBounds(0 + i.left,  240 + i.top , 900 + size.width ,  200 + size.height);	
																  
																	 JLabel j14 = new JLabel();
																		tempo.add(j14);
																		 size=j14.getPreferredSize();
																		 
																		 j4.setBounds(0 + i.left,  260 + i.top , 900 + size.width ,  200 + size.height);	
																		 JLabel j15 = new JLabel();
																			tempo.add(j15);
																			 size=j15.getPreferredSize();
																			 
																			 j15.setBounds(0 + i.left,  280 + i.top , 900 + size.width ,  200 + size.height);	
																		  
											 int ia=0;
				  
				  
				  
				  while(r.next())
				 {
					 temp[ia] = "Room :  "+r.getString(1)+"  Username:  "+r.getString(2);
					 //res=res+"\n"+temp;
					ia++;
					 
				 }
				System.out.println(res);
				 //System.out.println("I ca here");
				 
				 //j.setText(res);
				j1.setText(temp[0]);
				j2.setText(temp[1]);
				j3.setText(temp[2]);
				j4.setText(temp[3]);
				j5.setText(temp[4]);
				j6.setText(temp[5]);
				j7.setText(temp[6]);
				j8.setText(temp[7]);
				j9.setText(temp[8]);
				j10.setText(temp[9]);
				j11.setText(temp[10]);
				j12.setText(temp[11]);
				j13.setText(temp[12]);
				j14.setText(temp[13]);
				j15.setText(temp[14]);
				 //j.setFont(new Font("calibri",Font.BOLD,15));
				 conn.close();
				 s.close();
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
	});
    
    
    ////////////// display timetable ends
    				    
	    
    
    
    
    
    //////////////// third semester timetable display ends
	
	
	/////////////////////// fifth semester diaplay starts 
    
    ////////////// display timetable starts
   fifthsem.addActionListener(new ActionListener() {
		
		
		String driverName="oracle.jdbc.driver.OracleDriver";
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		///////// figure out to print the timetable of the lecturer try opening a new frame
			Statement s =null;
			ResultSet r = null;
			Connection conn = null;
					String temp[] = new String[30];
					
			 String res = null;
			 String query = "select room,username from fifthsemtimetable";
			try
			{
				//Load the JDBC Driver
				
				Class.forName(driverName);

				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
			    //System.out.println("Connected to Oracle Database");
				  s = conn.createStatement();
				 
				 System.out.println(query);
				  r = s.executeQuery(query);
				 System.out.println("I am here");
				  System.out.println("I am here");
				 //System.out.println(r.next());
				  JFrame tempo = new JFrame("My Time Table");
					 
					 Container p = tempo.getContentPane();
					 Dimension size;
					 Insets i = p.getInsets();
					 p.setLayout(null);
					 tempo.setVisible(true);
					 tempo.setExtendedState(JFrame.MAXIMIZED_BOTH);
					 tempo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					/// adding 15 jlabels here! I know it's crazy!! :P
					  JLabel j1 = new JLabel();
					tempo.add(j1);
					 size=j1.getPreferredSize();
					 
					 j1.setBounds(0 + i.left,  0 + i.top , 900 + size.width ,  200 + size.height);	
				  
					 JLabel j2 = new JLabel();
						tempo.add(j2);
						 size=j2.getPreferredSize();
						 
						 j2.setBounds(0 + i.left,  20 + i.top , 900 + size.width ,  200 + size.height);	
					  
						 JLabel j3 = new JLabel();
							tempo.add(j3);
							 size=j3.getPreferredSize();
							 
							 j3.setBounds(0 + i.left,  40 + i.top , 900 + size.width ,  200 + size.height);	
						  
							 JLabel j4 = new JLabel();
								tempo.add(j4);
								 size=j4.getPreferredSize();
								 
								 j4.setBounds(0 + i.left,  60 + i.top , 900 + size.width ,  200 + size.height);	
							  
								 JLabel j5 = new JLabel();
									tempo.add(j5);
									 size=j5.getPreferredSize();
									 
									 j5.setBounds(0 + i.left,  80 + i.top , 900 + size.width ,  200 + size.height);	
								  
									 JLabel j6 = new JLabel();
										tempo.add(j6);
										 size=j6.getPreferredSize();
										 
										 j6.setBounds(0 + i.left,  100 + i.top , 900 + size.width ,  200 + size.height);	
									  				 
										 JLabel j7 = new JLabel();
											tempo.add(j7);
											 size=j7.getPreferredSize();
											 
											 j7.setBounds(0 + i.left,  120 + i.top , 900 + size.width ,  200 + size.height);	
										  								 
											 JLabel j8 = new JLabel();
												tempo.add(j8);
												 size=j8.getPreferredSize();
												 
												 j8.setBounds(0 + i.left,  140 + i.top , 900 + size.width ,  200 + size.height);	
											  
												 JLabel j9 = new JLabel();
													tempo.add(j9);
													 size=j9.getPreferredSize();
													 
													 j9.setBounds(0 + i.left,  160 + i.top , 900 + size.width ,  200 + size.height);	
												   
													 JLabel j10 = new JLabel();
														tempo.add(j10);
														 size=j10.getPreferredSize();
														 
														 j10.setBounds(0 + i.left,  180 + i.top , 900 + size.width ,  200 + size.height);	
													  
														 JLabel j11 = new JLabel();
															tempo.add(j11);
															 size=j11.getPreferredSize();
															 
															 j11.setBounds(0 + i.left,  200 + i.top , 900 + size.width ,  200 + size.height);	
															 JLabel j12 = new JLabel();
																tempo.add(j12);
																 size=j12.getPreferredSize();
																 
																 j12.setBounds(0 + i.left,  220 + i.top , 900 + size.width ,  200 + size.height);	
															  
																 JLabel j13 = new JLabel();
																	tempo.add(j13);
																	 size=j13.getPreferredSize();
																	 
																	 j13.setBounds(0 + i.left,  240 + i.top , 900 + size.width ,  200 + size.height);	
																  
																	 JLabel j14 = new JLabel();
																		tempo.add(j14);
																		 size=j14.getPreferredSize();
																		 
																		 j4.setBounds(0 + i.left,  260 + i.top , 900 + size.width ,  200 + size.height);	
																		 JLabel j15 = new JLabel();
																			tempo.add(j15);
																			 size=j15.getPreferredSize();
																			 
																			 j15.setBounds(0 + i.left,  280 + i.top , 900 + size.width ,  200 + size.height);	
																		  
											 int ia=0;
				  
				  
				  
				  while(r.next())
				 {
					 temp[ia] = "Room :  "+r.getString(1)+"  Username:  "+r.getString(2);
					 //res=res+"\n"+temp;
					ia++;
					 
				 }
				System.out.println(res);
				 //System.out.println("I ca here");
				 
				 //j.setText(res);
				j1.setText(temp[0]);
				j2.setText(temp[1]);
				j3.setText(temp[2]);
				j4.setText(temp[3]);
				j5.setText(temp[4]);
				j6.setText(temp[5]);
				j7.setText(temp[6]);
				j8.setText(temp[7]);
				j9.setText(temp[8]);
				j10.setText(temp[9]);
				j11.setText(temp[10]);
				j12.setText(temp[11]);
				j13.setText(temp[12]);
				j14.setText(temp[13]);
				j15.setText(temp[14]);
				 //j.setFont(new Font("calibri",Font.BOLD,15));
				 conn.close();
				 s.close();
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
	});
    
    
    ////////////// display timetable ends
    				    
	    
    
    
    
    /////////////////////// fifth semester diaplay ends
	
	/////////////////////////////// seventh semester diaplay starts
   

   ////////////// display timetable starts
   seventhsem.addActionListener(new ActionListener() {
		
		
		String driverName="oracle.jdbc.driver.OracleDriver";
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		///////// figure out to print the timetable of the lecturer try opening a new frame
			Statement s =null;
			ResultSet r = null;
			Connection conn = null;
					String temp[] = new String[30];
					
			 String res = null;
			 String query = "select room,username from seventhsemtimetable";
			try
			{
				//Load the JDBC Driver
				
				Class.forName(driverName);

				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
			    //System.out.println("Connected to Oracle Database");
				  s = conn.createStatement();
				 
				 System.out.println(query);
				  r = s.executeQuery(query);
				 System.out.println("I am here");
				  System.out.println("I am here");
				 //System.out.println(r.next());
				  JFrame tempo = new JFrame("My Time Table");
					 
					 Container p = tempo.getContentPane();
					 Dimension size;
					 Insets i = p.getInsets();
					 p.setLayout(null);
					 tempo.setVisible(true);
					 tempo.setExtendedState(JFrame.MAXIMIZED_BOTH);
					 tempo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					/// adding 15 jlabels here! I know it's crazy!! :P
					  JLabel j1 = new JLabel();
					tempo.add(j1);
					 size=j1.getPreferredSize();
					 
					 j1.setBounds(0 + i.left,  0 + i.top , 900 + size.width ,  200 + size.height);	
				  
					 JLabel j2 = new JLabel();
						tempo.add(j2);
						 size=j2.getPreferredSize();
						 
						 j2.setBounds(0 + i.left,  20 + i.top , 900 + size.width ,  200 + size.height);	
					  
						 JLabel j3 = new JLabel();
							tempo.add(j3);
							 size=j3.getPreferredSize();
							 
							 j3.setBounds(0 + i.left,  40 + i.top , 900 + size.width ,  200 + size.height);	
						  
							 JLabel j4 = new JLabel();
								tempo.add(j4);
								 size=j4.getPreferredSize();
								 
								 j4.setBounds(0 + i.left,  60 + i.top , 900 + size.width ,  200 + size.height);	
							  
								 JLabel j5 = new JLabel();
									tempo.add(j5);
									 size=j5.getPreferredSize();
									 
									 j5.setBounds(0 + i.left,  80 + i.top , 900 + size.width ,  200 + size.height);	
								  
									 JLabel j6 = new JLabel();
										tempo.add(j6);
										 size=j6.getPreferredSize();
										 
										 j6.setBounds(0 + i.left,  100 + i.top , 900 + size.width ,  200 + size.height);	
									  				 
										 JLabel j7 = new JLabel();
											tempo.add(j7);
											 size=j7.getPreferredSize();
											 
											 j7.setBounds(0 + i.left,  120 + i.top , 900 + size.width ,  200 + size.height);	
										  								 
											 JLabel j8 = new JLabel();
												tempo.add(j8);
												 size=j8.getPreferredSize();
												 
												 j8.setBounds(0 + i.left,  140 + i.top , 900 + size.width ,  200 + size.height);	
											  
												 JLabel j9 = new JLabel();
													tempo.add(j9);
													 size=j9.getPreferredSize();
													 
													 j9.setBounds(0 + i.left,  160 + i.top , 900 + size.width ,  200 + size.height);	
												   
													 JLabel j10 = new JLabel();
														tempo.add(j10);
														 size=j10.getPreferredSize();
														 
														 j10.setBounds(0 + i.left,  180 + i.top , 900 + size.width ,  200 + size.height);	
													  
														 JLabel j11 = new JLabel();
															tempo.add(j11);
															 size=j11.getPreferredSize();
															 
															 j11.setBounds(0 + i.left,  200 + i.top , 900 + size.width ,  200 + size.height);	
															 JLabel j12 = new JLabel();
																tempo.add(j12);
																 size=j12.getPreferredSize();
																 
																 j12.setBounds(0 + i.left,  220 + i.top , 900 + size.width ,  200 + size.height);	
															  
																 JLabel j13 = new JLabel();
																	tempo.add(j13);
																	 size=j13.getPreferredSize();
																	 
																	 j13.setBounds(0 + i.left,  240 + i.top , 900 + size.width ,  200 + size.height);	
																  
																	 JLabel j14 = new JLabel();
																		tempo.add(j14);
																		 size=j14.getPreferredSize();
																		 
																		 j4.setBounds(0 + i.left,  260 + i.top , 900 + size.width ,  200 + size.height);	
																		 JLabel j15 = new JLabel();
																			tempo.add(j15);
																			 size=j15.getPreferredSize();
																			 
																			 j15.setBounds(0 + i.left,  280 + i.top , 900 + size.width ,  200 + size.height);	
																		  
											 int ia=0;
				  
				  
				  
				  while(r.next())
				 {
					 temp[ia] = "Room :  "+r.getString(1)+"  Username:  "+r.getString(2);
					 //res=res+"\n"+temp;
					ia++;
					 
				 }
				System.out.println(res);
				 //System.out.println("I ca here");
				 
				 //j.setText(res);
				j1.setText(temp[0]);
				j2.setText(temp[1]);
				j3.setText(temp[2]);
				j4.setText(temp[3]);
				j5.setText(temp[4]);
				j6.setText(temp[5]);
				j7.setText(temp[6]);
				j8.setText(temp[7]);
				j9.setText(temp[8]);
				j10.setText(temp[9]);
				j11.setText(temp[10]);
				j12.setText(temp[11]);
				j13.setText(temp[12]);
				j14.setText(temp[13]);
				j15.setText(temp[14]);
				 //j.setFont(new Font("calibri",Font.BOLD,15));
				 conn.close();
				 s.close();
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
	});
   
   
   ////////////// display timetable ends
   				    
	    
	
   
   
   
   
   
   
   
   ///////////////////////////////// seventh semester display ends
	
	
	
	
	
	}

public static void main(String args[])
{
	SwingUtilities.invokeLater(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			new internaltimetable();
		}
	});
}

}
