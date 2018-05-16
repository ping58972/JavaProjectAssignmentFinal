package edu.century.FinalProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JPasswordField;
import javax.swing.border.EtchedBorder;

public class RegisterGUI extends JFrame implements ActionListener, WindowListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private UserInformation personInfo= new UserInformation();
	private JTextArea textArea;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_20;
	private JLabel lblNewLabel_22;
	private JLabel lblNewLabel_7;
	//private ArrayList<UserInformation> customerList;

	/**
	 * Launch the application.
	 */
	public static void registerClick() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterGUI frame = new RegisterGUI();
					frame.setLocationRelativeTo(null);
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
	public RegisterGUI() {
		setTitle("Create a new Account");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		UIManager.put("Label.font", new Font("Arial", Font.ROMAN_BASELINE,20));
		UIManager.put("Label.foreground", Color.BLACK);
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Register New Account");
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 26));
		lblNewLabel.setForeground(new Color(128, 0, 128));
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Input Informations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new GridLayout(9, 3, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("User Name:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(SystemColor.textText);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_3.add(lblNewLabel_1);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_7 = new JLabel("Name for LogIn");
		lblNewLabel_7.setFont(new Font("Arial", Font.ITALIC, 12));
		lblNewLabel_7.setForeground(SystemColor.controlShadow);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_2 = new JLabel("Passwords:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(SystemColor.textText);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_3.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		panel_3.add(passwordField);
		
		lblNewLabel_8 = new JLabel("Set more than 6 : Numbers and Characters");
		lblNewLabel_8.setFont(new Font("Arial", Font.ITALIC, 12));
		lblNewLabel_8.setForeground(SystemColor.controlShadow);
		panel_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm Passwords:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(SystemColor.textText);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_3.add(lblNewLabel_3);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setEchoChar('*');
		panel_3.add(passwordField_1);
		
		lblNewLabel_4 = new JLabel("Comfirm");
		lblNewLabel_4.setFont(new Font("Arial", Font.ITALIC, 12));
		lblNewLabel_4.setForeground(SystemColor.controlShadow);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("First Name:");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_5.setForeground(SystemColor.textText);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_3.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Nick Name");
		lblNewLabel_10.setFont(new Font("Arial", Font.ITALIC, 12));
		lblNewLabel_10.setForeground(SystemColor.controlShadow);
		panel_3.add(lblNewLabel_10);
		
		JLabel lblNewLabel_6 = new JLabel("Last Name:");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_6.setForeground(SystemColor.textText);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_3.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		panel_3.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Family Name");
		lblNewLabel_9.setFont(new Font("Arial", Font.ITALIC, 12));
		lblNewLabel_9.setForeground(SystemColor.controlShadow);
		panel_3.add(lblNewLabel_9);
		
		JLabel lblNewLabel_13 = new JLabel("SSN:");
		lblNewLabel_13.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_13.setForeground(SystemColor.textText);
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_3.add(lblNewLabel_13);
		
		textField_5 = new JTextField();
		panel_3.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Social Security Number");
		lblNewLabel_11.setFont(new Font("Arial", Font.ITALIC, 12));
		lblNewLabel_11.setForeground(SystemColor.controlShadow);
		panel_3.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Address:");
		lblNewLabel_12.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_12.setForeground(SystemColor.textText);
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_3.add(lblNewLabel_12);
		
		textField_7 = new JTextField();
		panel_3.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("For sending a mail.");
		lblNewLabel_15.setFont(new Font("Arial", Font.ITALIC, 12));
		lblNewLabel_15.setForeground(SystemColor.controlShadow);
		panel_3.add(lblNewLabel_15);
		
		JLabel lblNewLabel_14 = new JLabel("Phone Number:");
		lblNewLabel_14.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_14.setForeground(SystemColor.textText);
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_3.add(lblNewLabel_14);
		
		textField_6 = new JTextField();
		panel_3.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("Mobile or Home");
		lblNewLabel_16.setFont(new Font("Arial", Font.ITALIC, 12));
		lblNewLabel_16.setForeground(SystemColor.controlShadow);
		panel_3.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Email:");
		lblNewLabel_17.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_17.setForeground(SystemColor.textText);
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_3.add(lblNewLabel_17);
		
		textField_8 = new JTextField();
		panel_3.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_18 = new JLabel("Personal Email");
		lblNewLabel_18.setFont(new Font("Arial", Font.ITALIC, 12));
		lblNewLabel_18.setForeground(SystemColor.controlShadow);
		panel_3.add(lblNewLabel_18);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Input a balance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new GridLayout(2, 3, 5, 5));
		
		JLabel lblNewLabel_19 = new JLabel("Checking Account:");
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_19.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_19.setForeground(SystemColor.textText);
		panel_5.add(lblNewLabel_19);
		
		textField_9 = new JTextField();
		panel_5.add(textField_9);
		textField_9.setColumns(10);
		
		lblNewLabel_20 = new JLabel("Money for using");
		lblNewLabel_20.setFont(new Font("Arial", Font.ITALIC, 12));
		lblNewLabel_20.setForeground(SystemColor.controlShadow);
		panel_5.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("Saving Account:");
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_21.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_21.setForeground(SystemColor.textText);
		panel_5.add(lblNewLabel_21);
		
		textField_10 = new JTextField();
		panel_5.add(textField_10);
		textField_10.setColumns(10);
		
		lblNewLabel_22 = new JLabel("Money for saving");
		lblNewLabel_22.setFont(new Font("Arial", Font.ITALIC, 12));
		lblNewLabel_22.setForeground(SystemColor.controlShadow);
		panel_5.add(lblNewLabel_22);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "More Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		
		
		textArea = new JTextArea();
		//panel_4.add(textArea);
		JScrollPane scrollPane = new JScrollPane(textArea);
		panel_6.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("DONE");
		btnNewButton.addActionListener(this);
		panel_1.add(btnNewButton);
		getRootPane().setDefaultButton(btnNewButton);
		JButton btnCancle = new JButton("CANCEL");
		btnCancle.addActionListener(this);
		panel_1.add(btnCancle);
		
		addWindowListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("CANCEL")) {
			dispose();
			LoginGUI frame = new LoginGUI();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		}
		if(command.equals("DONE")) {
			testInfo();	

		}
		
	}


	private void testInfo() {
		if(userNameTest()){
			lblNewLabel_7.setText("Correct!");
			lblNewLabel_7.setForeground(Color.BLUE);
		if(passwordField.getPassword().length>=6) {
			lblNewLabel_8.setText("Correct!");
			lblNewLabel_8.setForeground(Color.BLUE);
			if(new String(passwordField.getPassword()).equals(new String(passwordField_1.getPassword()))) {
				lblNewLabel_4.setText("Correct!");
				lblNewLabel_4.setForeground(Color.BLUE);
				try{
					Double.parseDouble(textField_9.getText());
					try{
					Double.parseDouble(textField_10.getText());
					takeInfo();
					saveToFile();
					dispose();
					LoginGUI frame = new LoginGUI();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					}catch(NumberFormatException e2){
						lblNewLabel_22.setText("Please! enter correct numbers.");
						lblNewLabel_22.setForeground(Color.RED);
						e2.getStackTrace();			
					}
				}catch(NumberFormatException e){
					lblNewLabel_20.setText("Please! enter correct numbers.");
					lblNewLabel_20.setForeground(Color.RED);
					e.getStackTrace();			
				}
				
			}
			else {
				lblNewLabel_4.setText("Password is not comfirm!");
				lblNewLabel_4.setForeground(Color.RED);
			}
		}else {
			lblNewLabel_8.setText("Password must be at least 6!");
			lblNewLabel_8.setForeground(Color.RED);
		}
		}else{
			lblNewLabel_7.setText("Exist User Name!");
			lblNewLabel_7.setForeground(Color.RED);
		}
		
	}
		private boolean userNameTest() {
			//customerList = new ArrayList<UserInformation>();
			//customerList = LoginGUI.customerList;
			for(int i=0; i<LoginGUI.customerList.size(); i++){
				if(textField.getText().equals(LoginGUI.customerList.get(i).getUserName()))
					return false;
			} return true;
			
		}
	private void takeInfo() {
		
		personInfo.setUserName(textField.getText());
		personInfo.setPassword(new String(passwordField.getPassword()));
		personInfo.setFirstName(textField_3.getText());
		personInfo.setLastName(textField_4.getText());
		personInfo.setSsn(textField_5.getText());
		personInfo.setAddress(textField_7.getText());
		personInfo.setPhoneNumber(textField_6.getText());
		personInfo.setEmail(textField_8.getText());
		personInfo.setMoreInfo(textArea.getText());
		personInfo.setCheckingAccount(textField_9.getText());
		personInfo.setSavingsAccount(textField_10.getText());
		
	}
	private void saveToFile() {
		//FileWriter csvFile;
		//System.out.println(personInfo.toString());
		try{
			FileWriter wFile = new FileWriter(new File("customerAccountsList.csv"), true);
			BufferedWriter bw = new BufferedWriter(wFile);
			PrintWriter csvFile = new PrintWriter(bw);
			csvFile.println(personInfo.toString());
			csvFile.close();
		}catch(Exception e){
			e.getStackTrace();
			System.out.println("dfgfg");
		}
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		dispose();
		new LoginGUI().setVisible(true);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
