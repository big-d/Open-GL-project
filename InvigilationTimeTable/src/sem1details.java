import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class sem1details extends JPanel {
	sem1details()
	{
		 
		setOpaque(false);
		  ImageIcon ic = new   ImageIcon("c:\\image.jpg");  
		  JLabel lbl = new JLabel(ic);  
		  add(lbl);
	      add(lbl,new Integer(50));  

		  
		  
		  
		  
		  
		  
		  
		  Dimension size;
		Insets i = getInsets();
		JLabel sem1detail = new JLabel();
		sem1detail.setText("Enter sem1detail  details:");
		add(sem1detail);
		 sem1detail.setFont(new Font("Calibri",Font.ITALIC,25));
	     size=sem1detail.getPreferredSize();
//	JTextField  = new JTextField();
    final JTextField sub = new JTextField();
    final JTextField fromtime = new JTextField();
    final JTextField totime = new JTextField();
 //   JTextField date = new JTextField();
    final JTextField roomnoavailable = new JTextField();
    final JTextField noofstudents = new JTextField();
    JButton clear=new JButton("Clear Time Table");
    size=clear.getPreferredSize();
    clear.setBounds(1100+i.left,0+i.top,100+size.width,15+size.height);
    JButton display=new JButton("Display Time Table");
    size=display.getPreferredSize();
    display.setBounds(1100+i.left,50+i.top,90+size.width,15+size.height);
    JButton add1=new JButton("Add");
    size=add1.getPreferredSize();
    add1.setBounds(260+i.left,300+i.top,90+size.width,15+size.height);
    add(clear);
    add(display);
    add(add1);
    
    setLayout(null);
    add(sub);
	size=sub.getPreferredSize();
    sub.setBounds( 305 + i.left, 50  + i.top , 150 + size.width , 10 + size.height);
	JLabel subl = new JLabel();
	subl.setText("Subject :");
	size=subl.getPreferredSize();
    subl.setBounds( 25 + i.left, 50  + i.top , 150 + size.width , 10 + size.height);
    add(subl);
	 subl.setFont(new Font("Calibri",Font.ITALIC,25));
	 add(fromtime);
		size=fromtime.getPreferredSize();
	    fromtime.setBounds( 305+ i.left, 100  + i.top , 150 + size.width , 10 + size.height);
		JLabel fromtimel = new JLabel();
		fromtimel.setText("from time :");
		size=fromtimel.getPreferredSize();
	    fromtimel.setBounds( 25 + i.left, 100  + i.top , 150 + size.width , 10 + size.height);
	    add(fromtimel);
		 fromtimel.setFont(new Font("Calibri",Font.ITALIC,25));

		 add(totime);
			size=totime.getPreferredSize();
		   totime.setBounds( 305 + i.left, 150  + i.top , 150 + size.width , 10 + size.height);
			JLabel totimel = new JLabel();
			totimel.setText("to time :");
			size=totimel.getPreferredSize();
		    totimel.setBounds( 25 + i.left, 150  + i.top , 150 + size.width , 10 + size.height);
		    add(totimel);
			 totimel.setFont(new Font("Calibri",Font.ITALIC,25));
			 
				 add(roomnoavailable);
					size=roomnoavailable.getPreferredSize();
					roomnoavailable.setBounds( 305 + i.left, 200  + i.top , 150 + size.width , 10 + size.height);
					JLabel roomnoavailablel = new JLabel();
					roomnoavailablel.setText("No. of Rooms available :");
					size=roomnoavailablel.getPreferredSize();
					roomnoavailablel.setBounds( 25 + i.left, 200  + i.top , 150 + size.width , 10 + size.height);
				    add(roomnoavailablel);
				    roomnoavailablel.setFont(new Font("Calibri",Font.ITALIC,25));
				    add(noofstudents);
					size=noofstudents.getPreferredSize();
				    noofstudents.setBounds( 305+ i.left, 250  + i.top , 150 + size.width , 10 + size.height);
					JLabel noofstudentsl = new JLabel();
					noofstudentsl.setText("No of Students :");
					size=noofstudentsl.getPreferredSize();
					noofstudentsl.setBounds( 25 + i.left, 250  + i.top , 150 + size.width , 10 + size.height);
				    add(noofstudentsl);
				    noofstudentsl.setFont(new Font("Calibri",Font.ITALIC,25));
				    
				    	final JTextField day = new JTextField();
				    	JLabel dayl = new JLabel();
				    	dayl.setText("Day: ");
				    	size=dayl.getPreferredSize();
				    	add(dayl);
						 dayl.setFont(new Font("Calibri",Font.ITALIC,25));

				    	dayl.setBounds(50 + i.left,10 + i.top   , 150 +size.width, 10 + size.height);
				    	size=day.getPreferredSize();
				    	day.setBounds(305 + i.left,10 + i.top   , 150 +size.width, 10 + size.height);
				    	add(day);
				    	
				    	
						// sub fromtime totime roomnoavailable noofstudents day
				    	/// trial
				    	
				    add1.addActionListener(new ActionListener() {
				    	Connection conn = null;
						Statement   s ;
						String query;
						ResultSet r;
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							try
							{

								//Load the JDBC Driver
								
								Class.forName("oracle.jdbc.driver.OracleDriver");

								conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
							    //System.out.println("Connected to Oracle Database");
								System.out.println(sub.getText()+fromtime.getText());
								String i,j;
								i = fromtime.getText();
								j = totime.getText();
								// query = "select username from freetimetable natural join timetable natural join teacherdetails where ("+Integer.parseInt(fromtime.getText())+" between from2 and to2 ) and ("+Integer.parseInt(totime.getText())+" between form2 and to2 ) and day = '"+day.getText()+"' order by joindate desc";
		 
								System.out.println(query);
								
								 s=conn.createStatement();
								 System.out.println("I came here");
									
								 r = s.executeQuery("select unique username,from2,to2 from freetimetable natural join timetable natural join teacherdetails ");
								
								 
								 JFrame tempo = new JFrame("My Time Table");
								 
								 Container p = tempo.getContentPane();
								 Dimension size;
								 Insets i1 = p.getInsets();
								 p.setLayout(null);
								 tempo.setVisible(true);
								 tempo.setExtendedState(JFrame.MAXIMIZED_BOTH);
								 tempo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
								/// adding 15 jlabels here! I know it's crazy!! :P
								  JLabel j1 = new JLabel();
								tempo.add(j1);
								 size=j1.getPreferredSize();
								 
								 j1.setBounds(0 + i1.left,  0 + i1.top , 900 + size.width ,  200 + size.height);	
							  
								 JLabel j2 = new JLabel();
									tempo.add(j2);
									 size=j2.getPreferredSize();
									 
									 j2.setBounds(0 + i1.left,  20 + i1.top , 900 + size.width ,  200 + size.height);	
								  
									 JLabel j3 = new JLabel();
										tempo.add(j3);
										 size=j3.getPreferredSize();
										 
										 j3.setBounds(0 + i1.left,  40 + i1.top , 900 + size.width ,  200 + size.height);	
									  
										 JLabel j4 = new JLabel();
											tempo.add(j4);
											 size=j4.getPreferredSize();
											 
											 j4.setBounds(0 + i1.left,  60 + i1.top , 900 + size.width ,  200 + size.height);	
										  
											 JLabel j5 = new JLabel();
												tempo.add(j5);
												 size=j5.getPreferredSize();
												 
												 j5.setBounds(0 + i1.left,  80 + i1.top , 900 + size.width ,  200 + size.height);	
											  
												 JLabel j6 = new JLabel();
													tempo.add(j6);
													 size=j6.getPreferredSize();
													 
													 j6.setBounds(0 + i1.left,  100 + i1.top , 900 + size.width ,  200 + size.height);	
												  				 
													 JLabel j7 = new JLabel();
														tempo.add(j7);
														 size=j7.getPreferredSize();
														 
														 j7.setBounds(0 + i1.left,  120 + i1.top , 900 + size.width ,  200 + size.height);	
													  								 
														 JLabel j8 = new JLabel();
															tempo.add(j8);
															 size=j8.getPreferredSize();
															 
															 j8.setBounds(0 + i1.left,  140 + i1.top , 900 + size.width ,  200 + size.height);	
														  
															 JLabel j9 = new JLabel();
																tempo.add(j9);
																 size=j9.getPreferredSize();
																 
																 j9.setBounds(0 + i1.left,  160 + i1.top , 900 + size.width ,  200 + size.height);	
															   
																 JLabel j10 = new JLabel();
																	tempo.add(j10);
																	 size=j10.getPreferredSize();
																	 
																	 j10.setBounds(0 + i1.left,  180 + i1.top , 900 + size.width ,  200 + size.height);	
																  
																	 JLabel j11 = new JLabel();
																		tempo.add(j11);
																		 size=j11.getPreferredSize();
																		 
																		 j11.setBounds(0 + i1.left,  200 + i1.top , 900 + size.width ,  200 + size.height);	
																		 JLabel j12 = new JLabel();
																			tempo.add(j12);
																			 size=j12.getPreferredSize();
																			 
																			 j12.setBounds(0 + i1.left,  220 + i1.top , 900 + size.width ,  200 + size.height);	
																		  
																			 JLabel j13 = new JLabel();
																				tempo.add(j13);
																				 size=j13.getPreferredSize();
																				 
																				 j13.setBounds(0 + i1.left,  240 + i1.top , 900 + size.width ,  200 + size.height);	
																			  
																				 JLabel j14 = new JLabel();
																					tempo.add(j14);
																					 size=j14.getPreferredSize();
																					 
																					 j4.setBounds(0 + i1.left,  260 + i1.top , 900 + size.width ,  200 + size.height);	
																					 JLabel j15 = new JLabel();
																						tempo.add(j15);
																						 size=j15.getPreferredSize();
																						 
																						 j15.setBounds(0 + i1.left,  280 + i1.top , 900 + size.width ,  200 + size.height);	
																					  
								 
								 
								 
								 
								 
								 Statement st;
								 st = conn.createStatement();
								 int ia =0 ;
								 String temp[]= new String[30];
								 while(r.next())
								 {
									 int k = Integer.parseInt(r.getString(2));
									 int m = Integer.parseInt(r.getString(3));
									 int k1 = Integer.parseInt(fromtime.getText());
									 int m1 = Integer.parseInt(totime.getText());
									 if( k1 > k && k1 < m && m1 > k && m1<m)
										 {
										 
										 temp[ia]="Room :  "+(ia+1)+"    " +  r.getString(1);
										 ia++;
										 try
										 {
											 s.executeUpdate("insert into firstsemtimetable values ('" +(ia)+ "','"+r.getString(1)+"')");
											 
										 }
										 catch(Exception e)
										 {
											 
										 }
										 
										 }
								 }
								 
								 
								 
								 
								 
								 System.out.println("I came here");
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
								 conn.commit();
								 conn.close();
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
				    	///trial ends
				    final String query2 = "delete from firstsemtimetable";        
			        clear.addActionListener(new ActionListener() {
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
			        
			        
			        ////////////// display timetable starts
			        display.addActionListener(new ActionListener() {
			    		
			    		
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
			        
			        
			        
			        
			        
			        
			        

	
				    
				    
}

}