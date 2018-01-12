package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class gui_test extends JFrame {

	private JPanel contentPane;
	private JTextField txtItem;
	private JTextField txtItemName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_test frame = new gui_test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gui_test() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		JMenuItem mntmExir = new JMenuItem("Exit");
		mnFile.add(mntmExir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblItem = new JLabel("Item Name #1");
		lblItem.setBounds(12, 12, 114, 15);
		contentPane.add(lblItem);
		
		txtItem = new JTextField();
		txtItem.setText("Item Name #1");
		txtItem.setBounds(12, 39, 114, 19);
		contentPane.add(txtItem);
		txtItem.setColumns(10);
		
		txtItemName = new JTextField();
		txtItemName.setText("Item Code #2");
		txtItemName.setBounds(138, 39, 114, 19);
		contentPane.add(txtItemName);
		txtItemName.setColumns(10);
		
		JLabel lblItemName = new JLabel("Item Code #2");
		lblItemName.setBounds(138, 12, 114, 15);
		contentPane.add(lblItemName);
		
		JButton btnExitCancel = new JButton("Stats");
		btnExitCancel.setBounds(321, 242, 117, 25);
		contentPane.add(btnExitCancel);
		
		JButton btnSave = new JButton("New Product");
		btnSave.setBounds(191, 242, 117, 25);
		contentPane.add(btnSave);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(311, 36, 117, 25);
		contentPane.add(btnSearch);
		
		JButton btnNewButton = new JButton("Stock");
		btnNewButton.setBounds(12, 242, 117, 25);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 70, 416, 160);
		contentPane.add(scrollPane);
	}
}
