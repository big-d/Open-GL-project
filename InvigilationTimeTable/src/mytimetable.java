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

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.omg.PortableServer.POAManagerPackage.State;


public class mytimetable extends JPanel {
	
	public mytimetable(final String a) {
	// TODO Auto-generated constructor stub
		
	
		////////////////////////// view my timetable
		JButton existingtimetable = new JButton("View my time table");
	add(existingtimetable);
	setLayout(null);
	Dimension size;
	Insets i = getInsets();
	size=existingtimetable.getPreferredSize();
	existingtimetable.setBounds(1180 + i.left,  0 + i.top ,  10 + size.width, 10 + size.height );
	
	existingtimetable.addActionListener(new ActionListener() {
		
		
		String driverName="oracle.jdbc.driver.OracleDriver";
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		///////// figure out to print the timetable of the lecturer try opening a new frame
			Statement s =null;
			ResultSet r = null;
			Connection conn = null;
					String temp[] = new String[30];
					
			 String res = null;
			 String query = "select day,sem,sec,subcode,from1,to1 from timetable where username ='"+a+"'";
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
					 temp[ia] = r.getString(1)+":  Semester: "+r.getString(2)+"  Section:"+r.getString(3)+"  Subcode:"+r.getString(4)+"  from:"+r.getString(5)+"  to:"+r.getString(6)+"\n";
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
	///////////////////////////////// view my timetable ends
	
	/////////////////////////////// addtimetable /////////////////////
	/*JButton addtimetable = new JButton("Add my timetable");
	size=addtimetable.getPreferredSize();
	addtimetable.setBounds(1180 + i.left , 40 + i.top , 20 +  size.width  ,  10 + size.height);
	add(addtimetable);
	*/
	
	JLabel entertimetable = new JLabel();
	entertimetable.setText("Enter your time table details:");
	add(entertimetable);
	 entertimetable.setFont(new Font("Calibri",Font.ITALIC,25));
     size=entertimetable.getPreferredSize();
     entertimetable.setBounds(0 + i.left, 0 + i.top , 100 + size.width , 10 + size.height);
     final JTextField day = new JTextField();
     final JTextField sem = new JTextField();
     final JTextField sec = new JTextField();
     final JTextField subcode = new JTextField();
     final JTextField from = new JTextField();
     final JTextField to = new JTextField();
	add(day);
	size=day.getPreferredSize();
    day.setBounds( 150 + i.left, 50  + i.top , 150 + size.width , 10 + size.height);
	JLabel dayl = new JLabel();
	dayl.setText("Day:");
	size=dayl.getPreferredSize();
    dayl.setBounds( 85 + i.left, 50  + i.top , 150 + size.width , 10 + size.height);
    add(dayl);
	 dayl.setFont(new Font("Calibri",Font.ITALIC,25));

    
    add(sem);
    size=sem.getPreferredSize();
    sem.setBounds( 150 + i.left, 100  + i.top , 150 + size.width , 10 + size.height);
	JLabel seml = new JLabel();
	seml.setText("Semester:");
	size=seml.getPreferredSize();
    seml.setBounds( 45 + i.left, 100  + i.top , 150 + size.width , 10 + size.height);
    add(seml);
	 seml.setFont(new Font("Calibri",Font.ITALIC,25));
    
    
    
    
    
    add(sec);
    size=sec.getPreferredSize();
    sec.setBounds( 150 + i.left, 150  + i.top , 150 + size.width , 10 + size.height);
	JLabel secl = new JLabel();
	secl.setText("Section:");
	size=secl.getPreferredSize();
    secl.setBounds( 45 + i.left, 150  + i.top , 150 + size.width , 10 + size.height);
    add(secl);
	 secl.setFont(new Font("Calibri",Font.ITALIC,25));
   
	 
	 
	 add(subcode);
	 
	 size=subcode.getPreferredSize();
	    subcode.setBounds( 150 + i.left, 200  + i.top , 150 + size.width , 10 + size.height);
		JLabel subl = new JLabel();
		subl.setText("Subject code:");
		size=subl.getPreferredSize();
	    subl.setBounds( 15 + i.left, 200  + i.top , 150 + size.width , 10 + size.height);
	    add(subl);
		 subl.setFont(new Font("Calibri",Font.ITALIC,25));
	    
	 
	 
	 
	 
	add(from);
	 size=from.getPreferredSize();
	    from.setBounds( 150 + i.left, 250 + i.top , 150 + size.width , 10 + size.height);
		JLabel froml = new JLabel();
		froml.setText("from: ");
		size=froml.getPreferredSize();
	    froml.setBounds( 80 + i.left, 250  + i.top , 150 + size.width , 10 + size.height);
	    add(froml);
		 froml.setFont(new Font("Calibri",Font.ITALIC,25));
	    
	
	
	
	
	
	
	
	
	add(to);
	size=to.getPreferredSize();
    to.setBounds( 150 + i.left, 300 + i.top , 150 + size.width , 10 + size.height);
	JLabel tol = new JLabel();
	tol.setText("to: ");
	size=tol.getPreferredSize();
    tol.setBounds( 95 + i.left, 300  + i.top , 150 + size.width , 10 + size.height);
    add(tol);
	 tol.setFont(new Font("Calibri",Font.ITALIC,25));
	
	
	
	JButton add = new JButton("Add");
	add(add);
    size=add.getPreferredSize();
    add.setBounds( 0 + i.left, 350  + i.top , 25 + size.width , 10 + size.height);
	
    
    
    
    
    add.addActionListener(new ActionListener() {
		Connection conn;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//// put all the values into the database
			try
			{
				 String days = day.getText();
				 String sems = sem.getText();
				 String secs = sec.getText();
				 String subcodes = subcode.getText();
				 String froms = from.getText();
				 String tos = to.getText();
				//Load the JDBC Driver
				String driverName="oracle.jdbc.driver.OracleDriver";
				Class.forName(driverName);
				 conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
			    //System.out.println("Connected to Oracle Database");
				 Statement s = conn.createStatement();
				 String query = "insert into timetable values ('"+a+"','"+days+"','"+sems+"','"
						 +secs+"','"+subcodes+"','"+froms+"','"+tos+"')";
				 System.out.println(query);
				 s.executeQuery(query);	
				 conn.commit();
				 conn.close();  
				 JOptionPane.showInputDialog(
			               "Successfully added into the database!");
			}
			
			catch(ClassNotFoundException e)
			{
				 JOptionPane.showInputDialog(
			               "Not connected to the database!");
				
				//System.out.println("Not connected to the database");
			}
			catch(SQLException e)
			{
				
				
				 JOptionPane.showInputDialog(
			               "Database error!!");
				//System.out.println("Not coonected to the driver");
			}

			
			
			
			
			
		}
	});
	
	///////////////////// check this part for later
	
    JButton cleartimetable = new JButton("Clear my existing time table");
	size= cleartimetable.getPreferredSize();
	cleartimetable.setBounds(1100 + i.left , 50 + i.top  , 40 + size.width  , 15 + size.height);
	add(cleartimetable);
	
	
		
	// TODO Auto-generated method stub
	String driverName = "oracle.jdbc.driver.OracleDriver";
	 
	ResultSet r = null;
	
			String temp = null;
	 String res = null;
	 final String query = "delete from timetable where username  ='"+a+"'";
	
	
	
	
	
	
	
			cleartimetable.addActionListener(new ActionListener() {
				
				 Connection conn = null;
				Statement   s ;
				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				///////// figure out to print the timetable of the lecturer try opening a new frame
					
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
	});

	////////////////////////////////// check this part for later ends /////////////
	////////////////////////////// addtimetable ends ///////////////
	
	
	
	 
	
	
	

}
}

