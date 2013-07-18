//********************************************************************************
/////////////////////////////////////////////////////////////////////////////////
//////////////////   Mohammed Nabeel Siddiqui //////////////////////////////////
/////////////////    Galab Raj Baral          /////////////////////////////////
/////////////////    Palla Golla Dwarakesh    ////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
//*************************************************************************


////////////////// code starts /////////////////////////////////////////

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.toedter.calendar.JCalendar;

import java.sql.*;





//////////////////// todo 
// creating a timetable table in th0e database for each user when a new account is created
 class LoginPage
{
	 
	 JLabel loginLabel = new JLabel();
	 JLabel passwordLabel = new JLabel();
	 JLabel signup = new JLabel();
//login frame
	 

	 
JFrame LoginPage = new JFrame("Invigilation time table Login");
JTextField loginText = new JTextField();
JPasswordField passwordText = new JPasswordField();



LoginPage()
{

///////////////    login page starts    //////////////////////////////
JButton loginButton = new JButton("Login");
JButton createAccountButton = new JButton("Create account");
LoginPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
LoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
LoginPage.setVisible(true);
Container p=LoginPage.getContentPane();
p.setBackground(Color.LIGHT_GRAY);
ImageIcon ic=new ImageIcon("C:\\image.jpg");
JLabel l= new JLabel(ic);
LoginPage.add(l);
p.setLayout(null);
p.add(loginButton);
p.add(createAccountButton);
Insets i = p.getInsets();
Dimension size = loginButton.getPreferredSize();
//size = l.getPreferredSize();
//l.setBounds(0 + i.left, 0 +  i.top , size.width + 50 , size.height + 50);

loginButton.setBounds(1250 + i.left, 20 + i.top,size.width+20, size.height+1);
size=createAccountButton.getPreferredSize();
createAccountButton.setBounds(1100 + i.left, 550 + i.top,size.width+50, size.height+20);

if(!connectionStatus)
{
	 JOptionPane.showMessageDialog(LoginPage,
               "Not connected to the database!");
}



p.add(loginText);
size=loginText.getPreferredSize();
loginText.setBounds(850 + i.left, 20  + i.top , size.width + 150 , size.height+10);
loginText.setText("");

p.add(passwordText);
size=p.getPreferredSize();
passwordText.setBounds(1090 + i.left,  20 + i.top , size.width + 150 , size.height+30);
passwordText.setText("");
loginLabel.setText("username:");
size=loginLabel.getPreferredSize();
loginLabel.setBounds(780 + i.left, 20 + i.top, size.width + 150 , size.height + 10);
p.add(loginLabel);
passwordLabel.setText("password:");
passwordLabel.setFont(new Font("Calibri",Font.ITALIC,15));
loginLabel.setFont(new Font("Calibri",Font.ITALIC,15));
p.add(passwordLabel);
size=passwordLabel.getPreferredSize();
passwordLabel.setBounds(1020 + i.left, 20 + i.top , size.width+ 150 , size.height+ 10);
signup.setText("----------------------------------  Sign Up ----------------------------");
p.add(signup);
size=signup.getPreferredSize();
signup.setBounds(850 + i.left, 70 + i.top ,size.width + 150 ,size.height + 10 );
signup.setFont(new Font("Calibri",Font.BOLD,20));
final JTextField FirstName = new JTextField();
JLabel FirstNameLabel = new JLabel();
p.add(FirstName);
p.add(FirstNameLabel);
size=FirstName.getPreferredSize();
FirstName.setBounds(1050 + i.left, 120 + i.top , size.width + 250 , size.height + 11);
FirstNameLabel.setText("First Name:");
size = FirstNameLabel.getPreferredSize();
FirstNameLabel.setBounds(900 + i.left , 130 + i.top , size.width + 200 , size.height + 11);
FirstNameLabel.setFont(new Font("calibri",Font.BOLD,25));




final JTextField SecondName = new JTextField();
JLabel SecondNameLabel = new JLabel();
p.add(SecondName);
p.add(SecondNameLabel);
size=SecondName.getPreferredSize();
SecondName.setBounds(1050 + i.left, 170 + i.top , size.width + 250 , size.height + 11);
SecondNameLabel.setText("Middle Name:");
size = SecondNameLabel.getPreferredSize();
SecondNameLabel.setBounds(900 + i.left , 170 + i.top , size.width + 200 , size.height + 11);
SecondNameLabel.setFont(new Font("calibri",Font.BOLD,25));



final JTextField ThirdName = new JTextField();
JLabel ThirdNameLabel = new JLabel();
p.add(ThirdName);
p.add(ThirdNameLabel);
size=ThirdName.getPreferredSize();
ThirdName.setBounds(1050 + i.left, 210 + i.top , size.width + 250 , size.height + 11);
ThirdNameLabel.setText("Last Name:");
size = ThirdNameLabel.getPreferredSize();
ThirdNameLabel.setBounds(900 + i.left , 210 + i.top , size.width + 200 , size.height + 11);
ThirdNameLabel.setFont(new Font("calibri",Font.BOLD,25));

final JTextField Designation = new JTextField();
JLabel DesignationLabel = new JLabel();
p.add(Designation);
p.add(DesignationLabel);
size=Designation.getPreferredSize();
Designation.setBounds(1050 + i.left, 260 + i.top , size.width + 250 , size.height + 11);
DesignationLabel.setText("Designation:");
size = DesignationLabel.getPreferredSize();
DesignationLabel.setBounds(900 + i.left , 260 + i.top , size.width + 200 , size.height + 11);
DesignationLabel.setFont(new Font("calibri",Font.BOLD,25));


final JTextField Initials = new JTextField();
JLabel InitialsLabel = new JLabel();
p.add(Initials);
p.add(InitialsLabel);
size=Initials.getPreferredSize();
Initials.setBounds(1050 + i.left, 310 + i.top , size.width + 250 , size.height + 11);
InitialsLabel.setText("Username:");
size = InitialsLabel.getPreferredSize();
InitialsLabel.setBounds(900 + i.left , 310 + i.top , size.width + 200 , size.height + 11);
InitialsLabel.setFont(new Font("calibri",Font.BOLD,25));

loginButton.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
	String a= 	loginText.getText();
	char b[]= new char[20];
	b= passwordText.getPassword();
	if(a.equals("admin") && b[0]=='1' && b[1]=='2' && b[2]=='3' ){
		
		// move to admin page
		LoginPage.dispose();
		new admin();
		JOptionPane.showMessageDialog(LoginPage,
                "welcome admin!");
		//// adminpage call will be made here
		}
	
	else
	{
		/// check for username and password in database function name is checkLoginDetails()
		// returns false if username or password is wrong or inexistent
		// true if username and passwords are correct
		String ca = new String(b);
		boolean validate;
		validate = checkLoginDetails(a, ca);
		if(validate)
		{
			LoginPage.dispose();
			new teacherpage(a);
			JOptionPane.showMessageDialog(LoginPage,
		               "welcome!\n"+a);
			/// teacher login successful 
			// teacherpage will be here
			
			
		}
		else
		{
			// teacher login not successful
			 JOptionPane.showMessageDialog(LoginPage,
		               "Username or password incorrect!");
			
		}
		
		
	}
	
	
		
	}
});



size = l.getPreferredSize();
l.setBounds(0 + i.left, 0 +  i.top , size.width + 100 , size.height + 100);
  
final JTextField day = new JTextField();
final JTextField month = new JTextField();
final JTextField year = new JTextField();


p.add(day);
//p.add(InitialsLabel);
size=day.getPreferredSize();
day.setBounds(1050 + i.left, 450 + i.top , size.width + 60 , size.height + 11);


p.add(month);
size=month.getPreferredSize();
month.setBounds(1150 + i.left, 450 + i.top , size.width + 50 , size.height + 11);

p.add(year);
size=year.getPreferredSize();
year.setBounds(1250 + i.left, 450 + i.top , size.width + 50 , size.height + 11);

JLabel dayt = new JLabel();
 dayt.setText("DAY");
 p.add(dayt);
 size=dayt.getPreferredSize();
 dayt.setBounds(1050 + i.left, 420 + i.top , size.width + 50 , size.height + 11);
 dayt.setFont(new Font("calibri",Font.BOLD,20));

 JLabel montht = new JLabel();
 montht.setText("MONTH");
 p.add(montht);
 size=montht.getPreferredSize();
 montht.setBounds(1150 + i.left, 420 + i.top , size.width + 50 , size.height + 11);
 montht.setFont(new Font("calibri",Font.BOLD,20));


 JLabel yeart = new JLabel();
 yeart.setText("YEAR");
 p.add(yeart);
 size=yeart.getPreferredSize();
 yeart.setBounds(1250 + i.left, 420 + i.top , size.width + 50 , size.height + 11);
 yeart.setFont(new Font("calibri",Font.BOLD,20));


 JLabel joindatet = new JLabel();
 joindatet.setText("Join Date:");
 p.add(joindatet);
 size=joindatet.getPreferredSize();
 joindatet.setBounds(900 + i.left, 450 + i.top , size.width + 50 , size.height + 11);
 joindatet.setFont(new Font("calibri",Font.BOLD,25));

final JPasswordField pass = new JPasswordField();

 p.add(pass);
//p.add(InitialsLabel);
size=pass.getPreferredSize();
pass.setBounds(1050 + i.left, 365 + i.top , size.width + 250 , size.height + 11);

 JLabel passt = new JLabel();
 passt.setText("password:");
 p.add(passt);
//p.add(InitialsLabel);
size=passt.getPreferredSize();
passt.setBounds(900 + i.left, 365 + i.top , size.width + 60 , size.height + 11);
passt.setFont(new Font("calibri",Font.BOLD,25));
 

createAccountButton.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String fname = FirstName.getText();
		String sname = SecondName.getText();
		String tname = ThirdName.getText();
		String des = Designation.getText();
		String usrname = Initials.getText();
		String day1 = day.getText();
		String month1 = month.getText();
		String year1 = year.getText();
		char baca[] = new char[20];
		baca= pass.getPassword();
		String pass1 = new String(baca);
		System.out.println("THese are the values"+fname+sname+tname+des+usrname+day1+month1+year1);
	if(fname.length() == 0 || sname.length() == 0 || tname.length() == 0 || des.length() == 0 || usrname.length() == 0
			|| day1.length()== 0 || month1.length() == 0 || year1.length() == 0 || pass1.length()==0)	
	{
		System.out.println("I came here");
		 JOptionPane.showMessageDialog(LoginPage,
	               "All fields are mandatory!");	
	}
		
	else
	{
		// all fieds are entered and working
	if(checkLoginDetails1(usrname, pass1))
		JOptionPane.showMessageDialog(LoginPage,
	               "Username already exists!");
	else
	{
	// insert details  into the database into two tables
		// logindetails and teacherdetails
		
		try
		{
			//Load the JDBC Driver
			String driverName="oracle.jdbc.driver.OracleDriver";
			Class.forName(driverName);
			 conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
		    //System.out.println("Connected to Oracle Database");
			 
			 String date1 = day1+"-"+month1+"-"+year1;
			 String query = "insert into teacherdetails values ('"+fname+"','"+sname+"','"+tname+"','"+des+"','"+usrname+"','"+date1+"')";
			 System.out.println(query);
			 Statement s = conn.createStatement();
			 s.executeQuery(query);
			 System.out.println(query);
			 query = "insert into logindetails values ('"+usrname+"','"+pass1+"')";
			 s.executeQuery(query);
			 System.out.println("I am here");
			 conn.commit();
			 conn.close();
			 s.close();
			 JOptionPane.showMessageDialog(LoginPage,
		               "Account successfully created!");
			 
		}
		
		catch(ClassNotFoundException e)
		{
			 JOptionPane.showMessageDialog(LoginPage,
		               "Not connected to the database!");
			//System.out.println("Not connected to the database");
		}
		catch(SQLException e)
		{
			 JOptionPane.showMessageDialog(LoginPage,
		               "Not connected to the database dumbass!");
			//System.out.println("Not coonected to the driver");
		}
		
		
		
		
		
		
		
		
		}
		
	
	}
		
		
		
	}
});



//////////////   login page ends  ///////////////////////////////////




}

public static boolean checkLoginDetails1 (String username, String password)
{
	String login,passwords;
	Statement s = null;
	ResultSet r = null;
	String query ="select * from logindetails";
	try{
		String driverName="oracle.jdbc.driver.OracleDriver";
		Class.forName(driverName);
	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
	//System.out.println("connected to the database!");
	s= conn.createStatement();
	r = s.executeQuery(query);
//	System.out.println("came here!" + r.next());
	
	while(r.next())
	{
	//	System.out.println("came here!");
		 login = r.getString(1);
		 passwords = r.getString(2);
		System.out.println("checking:" + username + ":" + login+":");
		System.out.println("checking:"+password + ":" + passwords+":");
		System.out.println(""+login.equals(username) + passwords.equals(password));
		if(login.equals(username))
		{
		
			return true;
		}
	}
	//r.close();
	//s.close();
//	conn.close();
	
	
	
	}
	catch (ClassNotFoundException e)
	{
		
	}
	catch(SQLException e)
	{
		System.out.println("Not connected to the database");
	}
	
	
	return false;
}


























public static boolean checkLoginDetails (String username, String password)
{
	String login,passwords;
	Statement s = null;
	ResultSet r = null;
	String query ="select * from logindetails";
	try{
		String driverName="oracle.jdbc.driver.OracleDriver";
		Class.forName(driverName);
	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
	//System.out.println("connected to the database!");
	s= conn.createStatement();
	r = s.executeQuery(query);
//	System.out.println("came here!" + r.next());
	
	while(r.next())
	{
	//	System.out.println("came here!");
		 login = r.getString(1);
		 passwords = r.getString(2);
		System.out.println("checking:" + username + ":" + login+":");
		System.out.println("checking:"+password + ":" + passwords+":");
		System.out.println(""+login.equals(username) + passwords.equals(password));
		if(login.equals(username) && passwords.equals(password))
		{
		
			return true;
		}
	}
	//r.close();
	//s.close();
//	conn.close();
	
	
	
	}
	catch (ClassNotFoundException e)
	{
		
	}
	catch(SQLException e)
	{
		System.out.println("Not connected to the database");
	}
	
	
	return false;
}

static Connection conn;
static boolean connectionStatus=true;
public static void main(String args[])
{
	
	try
	{
		//Load the JDBC Driver
		String driverName="oracle.jdbc.driver.OracleDriver";
		Class.forName(driverName);
		 conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
	    //System.out.println("Connected to Oracle Database");
		 conn.close();    
	}
	
	catch(ClassNotFoundException e)
	{
		connectionStatus=false;
		//System.out.println("Not connected to the database");
	}
	catch(SQLException e)
	{
		connectionStatus=false;
		//System.out.println("Not coonected to the driver");
	}

	
SwingUtilities.invokeLater(new Runnable() { 
    public void run() { 
       new LoginPage(); 
     } 
  }); 
	
	
	
}
}




