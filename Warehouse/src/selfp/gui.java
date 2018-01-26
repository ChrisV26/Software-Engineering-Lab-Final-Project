package selfp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSpinner;
import java.awt.TextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import selfp.gui;

import java.awt.Frame;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Window.Type;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.Toolkit;

@SuppressWarnings({ "serial", "unused" })
public class gui extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtID;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	

					gui frame = new gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public gui() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(gui.class.getResource("/selfp/box_PNG49.png")));
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
		
		JButton btnNew = new JButton("New");
		btnNew.setForeground(new Color(0, 0, 0));
		btnNew.setBounds(10, 474, 100, 40);
		contentPane.add(btnNew);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(120, 474, 100, 40);
		contentPane.add(btnSave);
		
		JButton btnSellings = new JButton("Sellings");
		btnSellings.setBounds(230, 474, 100, 40);
		contentPane.add(btnSellings);
		
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
		image.setIcon(new ImageIcon(gui.class.getResource("/selfp/box.jpg")));
		image.setBounds(0, 0, 794, 550);
		contentPane.add(image);
	
	}	
}
