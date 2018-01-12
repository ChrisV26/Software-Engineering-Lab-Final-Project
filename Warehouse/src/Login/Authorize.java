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


public class Authorize extends JFrame implements ActionListener
{
	protected static final Object sign_in_btn = null;
	protected JTextField username_textfield;
	protected JTextField password_textfield;
	
	/* Setting the frame */
	public Authorize() 
	{	
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		
		JLabel username_label = new JLabel("UserName");
		GridBagConstraints gbc_username_label = new GridBagConstraints();
		gbc_username_label.anchor = GridBagConstraints.WEST;
		gbc_username_label.insets = new Insets(0, 0, 5, 5);
		gbc_username_label.gridx = 1;
		gbc_username_label.gridy = 1;
		getContentPane().add(username_label, gbc_username_label);
		
		username_textfield = new JTextField();
		GridBagConstraints gbc_username_textfield = new GridBagConstraints();
		gbc_username_textfield.anchor = GridBagConstraints.WEST;
		gbc_username_textfield.insets = new Insets(0, 0, 5, 0);
		gbc_username_textfield.gridx = 3;
		gbc_username_textfield.gridy = 1;
		getContentPane().add(username_textfield, gbc_username_textfield);
		username_textfield.setColumns(10);
		
		JLabel password_label = new JLabel("Password");
		GridBagConstraints gbc_password_label = new GridBagConstraints();
		gbc_password_label.insets = new Insets(0, 0, 5, 5);
		gbc_password_label.gridx = 1;
		gbc_password_label.gridy = 3;
		getContentPane().add(password_label, gbc_password_label);
		
		password_textfield = new JTextField();
		GridBagConstraints gbc_password_textfield = new GridBagConstraints();
		gbc_password_textfield.insets = new Insets(0, 0, 5, 0);
		gbc_password_textfield.anchor = GridBagConstraints.WEST;
		gbc_password_textfield.gridx = 3;
		gbc_password_textfield.gridy = 3;
		getContentPane().add(password_textfield, gbc_password_textfield);
		password_textfield.setColumns(10);
		
		JButton sign_in_btn = new JButton("Sign-In");
		GridBagConstraints gbc_sign_in_btn = new GridBagConstraints();
		gbc_sign_in_btn.insets = new Insets(0, 0, 5, 0);
		gbc_sign_in_btn.anchor = GridBagConstraints.WEST;
		gbc_sign_in_btn.gridx = 3;
		gbc_sign_in_btn.gridy = 5;
		getContentPane().add(sign_in_btn, gbc_sign_in_btn);
		
		JLabel Credential_Info = new JLabel("");
		GridBagConstraints gbc_Credential_Info = new GridBagConstraints();
		gbc_Credential_Info.gridx = 3;
		gbc_Credential_Info.gridy = 6;
		getContentPane().add(Credential_Info, gbc_Credential_Info);
		
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

