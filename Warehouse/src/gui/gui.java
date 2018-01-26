package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

@SuppressWarnings({ "serial", "unused" })
public class GUI extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtID;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNew = new JMenu("File");
		menuBar.add(mnNew);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnNew.add(mntmNew);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnNew.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnNew.add(mntmExit);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("MastroElectronics");
		contentPane.setLayout(null);
		
		JLabel Name = new JLabel("Product Name");
		Name.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 15));
		Name.setBounds(10, 11, 210, 30);
		contentPane.add(Name);
		
		JLabel ID = new JLabel("Product ID");
		ID.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 15));
		ID.setBounds(230, 11, 210, 30);
		contentPane.add(ID);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 93, 770, 370);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnNew = new JButton("New");
		btnNew.setForeground(new Color(0, 0, 0));
		btnNew.setBounds(10, 474, 100, 40);
		contentPane.add(btnNew);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(120, 474, 100, 40);
		contentPane.add(btnSave);
		
		JButton btnStats = new JButton("Stats");
		btnStats.setBounds(230, 474, 100, 40);
		contentPane.add(btnStats);
		btnStats.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver").newInstance(); //instance of JDBC
		    		
					String conn_url="jdbc:mysql://127.0.0.1:3306/jdbc_login"; // URL connection using our IP and DB
    		
					String username="root"; // our DB_Username
					String pass="test123"; // our DB_Password
    		
					Connection conn=DriverManager.getConnection(conn_url,username,pass); // Sign in DB using the DB_Credentials
    			     			     			    	     
					/* prepare the search query and statement */
					String search_query="select * from warehouse_stock";
					PreparedStatement statement=conn.prepareStatement(search_query);
    			
					ResultSet rs=statement.executeQuery(); // execute the query
    			
					while (rs.next()) 
					{
    				 	/* fetch from db id,name,stock and stats and show it in the text area */
    				    int id = rs.getInt("PRODUCT_ID");
    				    String product_name = rs.getString("PRODUCT_NAME");
    				    int product_stock=rs.getInt("STOCK");
    				    float stats=rs.getFloat("STATS");
    				    textArea.append("ID:"+id+"\t"+"Product:"+product_name+"\t"+"Stock:"+product_stock+"\t"+"Sell Stats:"+stats+"\n");
					}
    			   			     			 
				}
				
				catch(ClassNotFoundException |SQLException | InstantiationException | IllegalAccessException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(550, 474, 100, 40);
		contentPane.add(btnExit);
		
		txtName = new JTextField();
		txtName.setBounds(10, 52, 210, 30);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(230, 52, 210, 30);
		contentPane.add(txtID);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(450, 52, 100, 30);
		contentPane.add(btnSearch);
		JLabel image = new JLabel("");
		image.setBounds(0, 0, 794, 550);
		contentPane.add(image);
		/* Implementing */
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try
				{
				 Class.forName("com.mysql.jdbc.Driver").newInstance(); //instance of JDBC
		    		
    			 String conn_url="jdbc:mysql://127.0.0.1:3306/jdbc_login"; // URL connection using our IP and DB
    		
    			 String username="root"; // our DB_Username
    			 String pass="test123"; // our DB_Password
    		
    			 Connection conn=DriverManager.getConnection(conn_url,username,pass); // Sign in DB using the DB_Credentials
    			 
    			 
    			 String  name_input =txtName.getText().trim(); // retrieve product name from name input
    	         int id_input=Integer.parseInt(txtID.getText().trim()); // retrieve id from id input
    	         
    			  /* prepare the search query and statement */
    			 String search_query="select PRODUCT_ID,PRODUCT_NAME,STOCK from warehouse_stock where PRODUCT_ID=? or PRODUCT_NAME=? ";
    			 PreparedStatement statement=conn.prepareStatement(search_query);
    			 statement.setInt(1,id_input);
      	         statement.setString(2,name_input);
      	         
    			 ResultSet rs=statement.executeQuery(); // execute the query
    			 
    			 if (rs.next()) 
    			 {
    				 	/* fetch from db id,name and stock and show it in the text area */
    				    int id = rs.getInt("PRODUCT_ID");
    				    String product_name = rs.getString("PRODUCT_NAME");
    				    int product_stock=rs.getInt("STOCK");    				
    				    textArea.append("ID:"+id+"\t"+"Product:"+product_name+"\t"+"Stock:"+product_stock+"\n");
    			 }
    			 else
    			 {
    				 JOptionPane.showMessageDialog(null, "Product not found");
    			 }
    			 
				}
				
				catch(ClassNotFoundException |SQLException | InstantiationException | IllegalAccessException e1)
				{
					e1.printStackTrace();
				}
			}
		});
	
	}	
}

