package Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import gui.GUI;
import javax.swing.JButton;
import java.awt.Font;
import Login.ConnectionManager;


public class Authorize extends JFrame implements ActionListener
{
	
	private Connection conn = null;
	protected static final Object SIGNINBTN = null;
	protected JTextField UsernameTextfield; // NOPMD by Chris on 27/1/2018 10:20 μμ
	protected JTextField PasswordTextfield;
	
	/* Setting the frame */
	public Authorize() 
	{
		setTitle("Login");
		setBounds(100, 100, 300, 200);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel username_label = new JLabel("UserName");
		username_label.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
		username_label.setBounds(40, 30, 100, 30);
		getContentPane().add(username_label);
		
		UsernameTextfield = new JTextField();
		UsernameTextfield.setBounds(150, 30, 100, 30);
		getContentPane().add(UsernameTextfield);
		UsernameTextfield.setColumns(10);
		
		JLabel password_label = new JLabel("Password");
		password_label.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
		password_label.setBounds(40, 72, 100, 30);
		getContentPane().add(password_label);
		
		PasswordTextfield = new JTextField();
		PasswordTextfield.setBounds(150, 71, 100, 30);
		getContentPane().add(PasswordTextfield);
		PasswordTextfield.setColumns(10);
		
		JButton SIGNINBTN = new JButton("Sign-In");
		SIGNINBTN.setBounds(100, 135, 100, 25);
		getContentPane().add(SIGNINBTN);
		
		JLabel Credential_Info = new JLabel("");
		Credential_Info.setBounds(0, 0, 300, 200);
		getContentPane().add(Credential_Info);
		
		SIGNINBTN.addActionListener(this); // attach a listener for the sign-in button
	}
	
	
	/* Implementing the method for sign in button */
	public void actionPerformed(ActionEvent e)
    {
          
            /* Create a connection with our database
    		 *  Fetch the saved Username and Password 
    		 *  */
    		try
    		{
    			conn = ConnectionManager.getConnection();
    			 String user_input =UsernameTextfield.getText().trim();
    	         String passw_input= PasswordTextfield.getText().trim(); 
    	          
    	         /* prepare the query and statement */
    	         String query="select * from credentials where Username=? and Password=?";
    	         PreparedStatement statement=conn.prepareStatement(query);
    	         statement.setString(1,user_input);
    	         statement.setString(2,passw_input);
    	         
    	         ResultSet rs=statement.executeQuery(); // execute the query
    	         	 
    				if(rs.next())
    				{
    					dispose();   					 // NOPMD by Chris on 27/1/2018 10:20 μμ
    					GUI.main(null);
    					
    				}
    				else
    				{
    					JOptionPane.showMessageDialog(null,"Wrong UserName or Password");
    				}
    							
    		}
    		catch(SQLException e1)
    		{
    			e1.printStackTrace();
    		}
    			
    } //end of actionperformed
	
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
	} // end of main


} //end of class

