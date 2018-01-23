package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import gui.gui_test;

import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Font;


public class Authorize extends JFrame implements ActionListener
{
	protected static final Object sign_in_btn = null;
	protected JTextField username_textfield;
	protected JTextField password_textfield;
	
	/* Setting the frame */
	public Authorize() 
	{
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Giaro\\Desktop\\SELF-Project\\Software-Engineering-Lab-Final-Project\\Warehouse\\src\\selfp\\box_PNG49.png"));
		setBounds(100, 100, 300, 200);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel username_label = new JLabel("UserName");
		username_label.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
		username_label.setBounds(40, 30, 100, 30);
		getContentPane().add(username_label);
		
		username_textfield = new JTextField();
		username_textfield.setBounds(150, 30, 100, 30);
		getContentPane().add(username_textfield);
		username_textfield.setColumns(10);
		
		JLabel password_label = new JLabel("Password");
		password_label.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
		password_label.setBounds(40, 72, 100, 30);
		getContentPane().add(password_label);
		
		password_textfield = new JTextField();
		password_textfield.setBounds(150, 71, 100, 30);
		getContentPane().add(password_textfield);
		password_textfield.setColumns(10);
		
		JButton sign_in_btn = new JButton("Sign-In");
		sign_in_btn.setBounds(100, 135, 100, 25);
		getContentPane().add(sign_in_btn);
		
		JLabel Credential_Info = new JLabel("");
		Credential_Info.setIcon(new ImageIcon("C:\\Users\\Giaro\\Desktop\\SELF-Project\\Software-Engineering-Lab-Final-Project\\Warehouse\\src\\selfp\\box.jpg"));
		Credential_Info.setBounds(0, 0, 300, 200);
		getContentPane().add(Credential_Info);
		
		sign_in_btn.addActionListener(this); // attach a listener for the sign-in button
	}
	
	/* Implementing the method for sign in button */
	static String user_input;
	static String passw_input;
	
	public void actionPerformed(ActionEvent e)
    {
            user_input =username_textfield.getText().trim();
            passw_input= password_textfield.getText().trim(); 
    }

	public static void main(String[] args) 
	{
		/* Launch the application */
		EventQueue.invokeLater(new Runnable() {
			public void run() 
			{
				try 
				{
					Authorize frame = new Authorize();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	
		/* Create a connection with our database
		 *  Fetch the saved UserName and Password 
		 *  */
		try
		{
			 Class.forName("com.mysql.jdbc.Driver").newInstance(); //instance of JDBC
		
			 String conn_url="jdbc:mysql://127.0.0.1:3306/jdbc_login"; // URL connection using our IP and DB
		
			 String username="root"; // our DB_Username
			 String pass="test123"; // our DB_Password
		
			 Connection conn=DriverManager.getConnection(conn_url,username,pass); // Sign in DB using the DB_Credentials
		
			 Statement stmt=conn.createStatement(); // making a statement for DB
			 ResultSet rs=stmt.executeQuery("select * from credentials"); // execute the query
			
			 
			 String user = null;
			 String passw=null;
			 	 
			 while(rs.next())
			 {	
				user=rs.getString("Username"); // fetch username from db
				passw=rs.getString("Password"); // fetch password from db
				//System.out.println("ID:" +id+ "User:"+ user+ "Pass:"+ passw);		
			 }
				if(user.equals(user_input) && passw.equals(passw_input))
				{
					 new gui_test();
				}
				else
				{
					//Credential_Info.setText("Wrong UserName or Password");
					System.out.println("wrong cred");
				}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	} // end of main

} //end of class

