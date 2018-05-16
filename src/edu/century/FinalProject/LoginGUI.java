package edu.century.FinalProject;

import java.applet.Applet;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

//import com.opencsv.CSVReader;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private JTextField txtFillInUsername;
	private JTextField txtTypePassword;
	public static  ArrayList<UserInformation> customerList = new ArrayList<UserInformation>();
	public static UserInformation customer;
	private JLabel lblNewLabel_2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 344);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblBank = new JLabel("Smalls Wargo");
		lblBank.setForeground(new Color(255, 255, 255));
		lblBank.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 55));
		lblBank.setBounds(71, -24, 376, 134);
		contentPane.add(lblBank);
		
		JLabel label_9 = new JLabel("Smalls Wargo");
		label_9.setForeground(new Color(204, 204, 204));
		label_9.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 55));
		label_9.setBounds(67, -24, 388, 134);
		contentPane.add(label_9);
		
		txtUsername = new JTextField();
		txtUsername.setToolTipText("");
		txtUsername.setBounds(123, 100, 192, 26);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		pwdPassword = new JPasswordField(); 
		
		pwdPassword.setBounds(121, 152, 192, 27);
		contentPane.add(pwdPassword);
		
		takeInfoList();
		
		JButton btnLogin = new JButton("LOGIN");
		
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				if(loginTest()){
					lblNewLabel_2.setText("");
					setVisible(false);
					AccountGUI nw = new AccountGUI();
					nw.loginClick();
					
				}else
					lblNewLabel_2.setText("The account doesn't exist!");
				lblNewLabel_2.setForeground(Color.RED);
					//System.out.println("Login Problem...hahaha!");
				
				}
		});
		getRootPane().setDefaultButton(btnLogin);
		
		btnLogin.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 11));
		btnLogin.setBounds(182, 190, 70, 32);
		contentPane.add(btnLogin);
		
		
		
		JButton btnRegister = new JButton("No Account? REGISTER");
		btnRegister.setBorder(null);
		btnRegister.setBackground(new Color(0, 153, 255));
		btnRegister.setForeground(new Color(0, 0, 0));
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnRegister.setBounds(145, 230, 141, 23);
		btnRegister.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				new RegisterGUI().registerClick();
				//setVisible(true);
				
			}
		});
		contentPane.add(btnRegister);
		
		txtFillInUsername = new JTextField();
		txtFillInUsername.setForeground(new Color(255, 255, 255));
		txtFillInUsername.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 14));
		txtFillInUsername.setBorder(null);
		txtFillInUsername.setEditable(false);
		txtFillInUsername.setBackground(new Color(0, 153, 255));
		txtFillInUsername.setDisabledTextColor(new Color(30, 144, 255));
		txtFillInUsername.setText("Enter Username");
		txtFillInUsername.setBounds(158, 82, 141, 20);
		contentPane.add(txtFillInUsername);
		txtFillInUsername.setColumns(10);
		
		txtTypePassword = new JTextField();
		txtTypePassword.setForeground(new Color(255, 255, 255));
		txtTypePassword.setText("Enter Password\r\n");
		txtTypePassword.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 14));
		txtTypePassword.setEditable(false);
		txtTypePassword.setDisabledTextColor(new Color(30, 144, 255));
		txtTypePassword.setColumns(10);
		txtTypePassword.setBorder(null);
		txtTypePassword.setBackground(new Color(0, 153, 255));
		txtTypePassword.setBounds(158, 133, 133, 20);
		contentPane.add(txtTypePassword);
		
		JLabel lblNewLabel = new JLabel("l");
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 34));
		lblNewLabel.setForeground(new Color(255, 215, 0));
		lblNewLabel.setBounds(118, 76, 388, 77);
		contentPane.add(lblNewLabel);
		
		JLabel label_23 = new JLabel("________");
		label_23.setForeground(new Color(255, 215, 0));
		label_23.setFont(new Font("Microsoft YaHei", Font.BOLD, 54));
		label_23.setBounds(121, 49, 254, 86);
		contentPane.add(label_23);
		
		JLabel label_22 = new JLabel("l");
		label_22.setForeground(new Color(255, 215, 0));
		label_22.setFont(new Font("Microsoft YaHei", Font.BOLD, 34));
		label_22.setBounds(116, 128, 388, 77);
		contentPane.add(label_22);
		
		JLabel lblNewLabel_1 = new JLabel("________");
		lblNewLabel_1.setForeground(new Color(255, 215, 0));
		lblNewLabel_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 54));
		lblNewLabel_1.setBounds(119, 102, 254, 86);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(139, 264, 176, 14);
		contentPane.add(lblNewLabel_2);
		
		//Create Array List for taking info from csv file.
		
	}
	private boolean loginTest() {
		for(int i=0; i<customerList.size(); i++){
			if(txtUsername.getText().equals(customerList.get(i).getUserName())
				&&(String.valueOf(pwdPassword.getPassword()).equals(customerList.get(i).getPassword()))){
				customer = customerList.get(i);
				return true;
				}
		} return false;
		
	}
	private void takeInfoList() {
		Scanner read;
		try{
			
			 read = new Scanner(new File("customerAccountsList.csv"));
			// System.out.println("sfgf");
			while(read.hasNextLine()){
				String lineCSV = read.nextLine();
				
				//String[] tokens = lineCSV.split(",");
				String[] tokens = lineCSV.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
				//System.out.println("sfgf");
				UserInformation customerCSV = new UserInformation();
			
			customerCSV.setUserName(tokens[0]);
			customerCSV.setPassword(tokens[1]);
			customerCSV.setFirstName(tokens[2]);
			customerCSV.setLastName(tokens[3]);
			customerCSV.setSsn(tokens[4]);
			customerCSV.setPhoneNumber(tokens[5]);
			customerCSV.setEmail(tokens[6]);
			customerCSV.setCheckingAccount(tokens[7], tokens[8]);
			customerCSV.setSavingsAccount(tokens[9], tokens[10]);
			customerCSV.setAddress(tokens[11].replace("\"", ""));
			customerCSV.setMoreInfo(tokens[12].replace("\"", ""));
					customerList.add(customerCSV);
			}


		}catch(IOException ioe){
			ioe.getStackTrace();
			System.out.println("The problem is at LoginGUI.java, line:229");
		}
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "SwingAction_1");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	public static ArrayList<UserInformation> getCustomerList() {
		return customerList;
	}

	public  void setCustomerList(ArrayList<UserInformation> customerList) {
		this.customerList = customerList;
	}

	public UserInformation getCustomer() {
		return customer;
	}

	public void setCustomer(UserInformation customer) {
		this.customer = customer;
	}
}
