package edu.century.FinalProject;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowFocusListener;

public class AccountGUI implements WindowListener{

	public static JFrame frame;
	private final JPanel AccountOverview = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtSocialSecurityXxxxxx;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private JTextField txtAccount;
	private JTextField textField_2;
	private JTextArea savingsConsole;
	private JTextArea checkingConsole;

	/**
	 * Launch the application.
	 */
	public static void loginClick() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountGUI window = new AccountGUI();
					window.frame.setLocationRelativeTo(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AccountGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		UserInformation accountShow = LoginGUI.customer;
		
		frame = new JFrame();
		frame.setResizable(false);
		
		/*Update account information when AccountGUI regains focus from depositing/withdrawing from accounts.*/
		frame.addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				int customerIndex;
				//Update checking account balance text fields
				textField.setText("$ " + accountShow.getCheckingAccount().getBalance().toString());
				textField_4.setText("$ " + accountShow.getCheckingAccount().getBalance().toString());
				checkingConsole.setText(accountShow.getCheckingAccount().archiveTransactionToString());
				//Update savings account balance text fields
				textField_1.setText("$ " + accountShow.getSavingsAccount().getBalance().toString());
				textField_5.setText("$ " + accountShow.getSavingsAccount().getBalance().toString());
				savingsConsole.setText(accountShow.getSavingsAccount().archiveTransactionToString());
				
				//Update changes the customerList arrayList
				customerIndex = LoginGUI.customerList.indexOf(accountShow);
				LoginGUI.customerList.set(customerIndex, accountShow);
				
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		
		frame.setBounds(100, 100, 460, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.addWindowListener(this);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 415, 517);
		frame.getContentPane().add(tabbedPane);
		AccountOverview.setForeground(new Color(255, 255, 255));
		AccountOverview.setBackground(new Color(0, 153, 255));
		tabbedPane.addTab("Account", null, AccountOverview, null);
		AccountOverview.setLayout(null);
		frame.setEnabled(true);
		
		JLabel lblWelcome = new JLabel("Welcome,"+ LoginGUI.customer.getFirstName()+" "+ LoginGUI.customer.getLastName()+" \nto Smalls Wargo Bank");
		lblWelcome.setBounds(10, 24, 400, 65);
		AccountOverview.add(lblWelcome);
		lblWelcome.setFont(new Font("Microsoft JhengHei", Font.BOLD, 14));
		
		JLabel lblNewLabel = new JLabel("Checking");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
		lblNewLabel.setBounds(150, 100, 119, 44);
		AccountOverview.add(lblNewLabel);
		
		JLabel label = new JLabel("Checking");
		label.setForeground(new Color(204, 204, 204));
		label.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
		label.setBounds(148, 100, 119, 44);
		AccountOverview.add(label);
		
		textField = new JTextField();
		textField.setBackground(new Color(204, 204, 255));
		textField.setEditable(false);
		textField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		textField.setText("$ "+ accountShow.getCheckingAccount().getBalance().toString());
		textField.setToolTipText("");
		textField.setColumns(10);
		textField.setBounds(112, 142, 192, 26);
		AccountOverview.add(textField);
		
		JLabel label_2 = new JLabel("l");
		label_2.setForeground(new Color(255, 215, 0));
		label_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 34));
		label_2.setBounds(107, 118, 388, 77);
		AccountOverview.add(label_2);
		
		JLabel label_3 = new JLabel("________");
		label_3.setForeground(new Color(255, 215, 0));
		label_3.setFont(new Font("Microsoft YaHei", Font.BOLD, 54));
		label_3.setBounds(110, 92, 254, 86);
		AccountOverview.add(label_3);
		
		JLabel lblSavings = new JLabel("Savings");
		lblSavings.setForeground(new Color(255, 255, 255));
		lblSavings.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
		lblSavings.setBounds(162, 240, 119, 44);
		AccountOverview.add(lblSavings);
		
		JLabel label_1 = new JLabel("Savings");
		label_1.setForeground(new Color(204, 204, 204));
		label_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
		label_1.setBounds(160, 240, 119, 44);
		AccountOverview.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(204, 204, 255));
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		textField_1.setText("$"+ accountShow.getSavingsAccount().getBalance().toString());
		textField_1.setToolTipText("");
		textField_1.setColumns(10);
		textField_1.setBounds(112, 282, 192, 26);
		AccountOverview.add(textField_1);
		
		JLabel label_4 = new JLabel("l");
		label_4.setForeground(new Color(255, 215, 0));
		label_4.setFont(new Font("Microsoft YaHei", Font.BOLD, 34));
		label_4.setBounds(107, 258, 388, 77);
		AccountOverview.add(label_4);
		
		JLabel label_5 = new JLabel("________");
		label_5.setForeground(new Color(255, 215, 0));
		label_5.setFont(new Font("Microsoft YaHei", Font.BOLD, 54));
		label_5.setBounds(110, 232, 254, 86);
		AccountOverview.add(label_5);
		
		JPanel Checking = new JPanel();
		Checking.setBackground(new Color(0, 153, 255));
		tabbedPane.addTab("Checking", null, Checking, null);
		Checking.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBounds(10, 249, 390, 229);
		Checking.add(panel);
		
		
//		JList list = new JList();
//		list.setBounds(10, 11, 370, 250);
//		panel.add(list);
		checkingConsole = new JTextArea(20,20);
		checkingConsole.setEditable(false);
		panel.add(new JScrollPane(checkingConsole));
		
		JLabel label_6 = new JLabel("Checking");
		label_6.setForeground(new Color(255, 255, 255));
		label_6.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
		label_6.setBounds(143, 11, 119, 44);
		Checking.add(label_6);
		
		JLabel label_7 = new JLabel("Checking");
		label_7.setForeground(new Color(204, 204, 204));
		label_7.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
		label_7.setBounds(141, 11, 119, 44);
		Checking.add(label_7);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("");
		textField_4.setText("$"+ accountShow.getCheckingAccount().getBalance().toString());
		textField_4.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBackground(new Color(204, 204, 255));
		textField_4.setBounds(98, 73, 192, 26);
		Checking.add(textField_4);
		
		JLabel label_8 = new JLabel("l");
		label_8.setForeground(new Color(255, 215, 0));
		label_8.setFont(new Font("Microsoft YaHei", Font.BOLD, 34));
		label_8.setBounds(93, 49, 388, 77);
		Checking.add(label_8);
		
		JLabel label_9 = new JLabel("________");
		label_9.setForeground(new Color(255, 215, 0));
		label_9.setFont(new Font("Microsoft YaHei", Font.BOLD, 54));
		label_9.setBounds(96, 23, 254, 86);
		Checking.add(label_9);
		
		JButton btnCTransfer = new JButton("TRANSFER");
		btnCTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TransferCheckingGUI nw = new TransferCheckingGUI();
				nw.cTransferClick();
				frame.setEnabled(false);
			}
		});
		btnCTransfer.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 11));
		btnCTransfer.setBounds(141, 174, 94, 32);
		Checking.add(btnCTransfer);
		
		JButton btnCDeposit = new JButton("DEPOSIT");
		btnCDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DepositCheckingGUI nw = new DepositCheckingGUI();
				nw.cDepositClick();
				frame.setEnabled(false);
			}
		});
		btnCDeposit.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 11));
		btnCDeposit.setBounds(61, 115, 106, 32);
		Checking.add(btnCDeposit);
		
		JButton btnCWithdraw = new JButton("WITHDRAW");
		btnCWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WithdrawCheckingGUI nw = new WithdrawCheckingGUI();
				nw.cWithdrawClick();
				frame.setEnabled(false);
				
			}
		});
		btnCWithdraw.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 11));
		btnCWithdraw.setBounds(200, 115, 106, 32);
		Checking.add(btnCWithdraw);
		
		txtAccount = new JTextField();
		txtAccount.setText("Account #:" + LoginGUI.customer.getCheckingAccount().getAccountNumber());
		txtAccount.setForeground(Color.WHITE);
		txtAccount.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 12));
		txtAccount.setEditable(false);
		txtAccount.setDisabledTextColor(new Color(30, 144, 255));
		txtAccount.setColumns(10);
		txtAccount.setBorder(null);
		txtAccount.setBackground(new Color(0, 153, 255));
		txtAccount.setBounds(139, 57, 136, 20);
		Checking.add(txtAccount);
		
		JPanel Savings = new JPanel();
		Savings.setBackground(new Color(0, 153, 255));
		tabbedPane.addTab("Savings", null, Savings, null);
		Savings.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BorderLayout());
		panel_1.setBounds(10, 249, 390, 229);
		Savings.add(panel_1);
		
		savingsConsole = new JTextArea();
		savingsConsole.setEditable(false);
		panel_1.add(new JScrollPane(savingsConsole));
		//JList list_1 = new JList();
		//list_1.setBounds(10, 11, 370, 204);
		//panel_1.add(list_1);
		
		textField_5 = new JTextField();
		textField_5.setToolTipText("");
		textField_5.setText("$"+ accountShow.getSavingsAccount().getBalance().toString());
		textField_5.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBackground(new Color(204, 204, 255));
		textField_5.setBounds(100, 71, 192, 26);
		Savings.add(textField_5);
		
		JLabel label_10 = new JLabel("l");
		label_10.setForeground(new Color(255, 215, 0));
		label_10.setFont(new Font("Microsoft YaHei", Font.BOLD, 34));
		label_10.setBounds(95, 47, 388, 77);
		Savings.add(label_10);
		
		JLabel label_11 = new JLabel("________");
		label_11.setForeground(new Color(255, 215, 0));
		label_11.setFont(new Font("Microsoft YaHei", Font.BOLD, 54));
		label_11.setBounds(98, 21, 254, 86);
		Savings.add(label_11);
		
		JButton btnSTransfer = new JButton("TRANSFER");
		btnSTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TransferSavingsGUI nw = new TransferSavingsGUI();
				nw.sTransferClick();
				frame.setEnabled(false);
			}
		});
		btnSTransfer.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 11));
		btnSTransfer.setBounds(141, 174, 94, 32);
		Savings.add(btnSTransfer);
		
		JButton btnSDeposit = new JButton("DEPOSIT");
		btnSDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DepositSavingsGUI nw = new DepositSavingsGUI();
				nw.sDepositClick();
				frame.setEnabled(false);
			}
		});
		btnSDeposit.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 11));
		btnSDeposit.setBounds(61, 115, 106, 32);
		Savings.add(btnSDeposit);
		
		JButton btnSWithdraw = new JButton("WITHDRAW");
		btnSWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WithdrawSavingsGUI nw = new WithdrawSavingsGUI();
				nw.sWithdrawClick();
				frame.setEnabled(false);
			}
		});
		btnSWithdraw.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 11));
		btnSWithdraw.setBounds(200, 115, 106, 32);
		Savings.add(btnSWithdraw);
		
		JLabel label_12 = new JLabel("Savings");
		label_12.setForeground(new Color(255, 255, 255));
		label_12.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
		label_12.setBounds(150, 11, 119, 44);
		Savings.add(label_12);
		
		JLabel label_13 = new JLabel("Savings");
		label_13.setForeground(new Color(204, 204, 204));
		label_13.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
		label_13.setBounds(148, 11, 119, 44);
		Savings.add(label_13);
		
		textField_2 = new JTextField();
		textField_2.setText("Account #" + LoginGUI.customer.getSavingsAccount().getAccountNumber());
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 12));
		textField_2.setEditable(false);
		textField_2.setDisabledTextColor(new Color(30, 144, 255));
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(new Color(0, 153, 255));
		textField_2.setBounds(135, 56, 136, 20);
		Savings.add(textField_2);
		
		JPanel Profile = new JPanel();
		Profile.setBackground(new Color(0, 153, 255));
		tabbedPane.addTab("Profile", null, Profile, null);
		
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setBounds(22, 11, 79, 25);
		lblProfile.setForeground(new Color(255, 255, 255));
		lblProfile.setFont(new Font("Microsoft YaHei", Font.PLAIN, 24));
		
		JLabel lblProfile_1 = new JLabel("Profile");
		lblProfile_1.setBounds(20, 11, 81, 25);
		lblProfile_1.setForeground(new Color(204, 204, 204));
		lblProfile_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 24));
		
		txtFirstName = new JTextField();
		txtFirstName.setEditable(false);
		txtFirstName.setBounds(26, 53, 362, 31);
		txtFirstName.setToolTipText("");
		txtFirstName.setText("First Name:"+ accountShow.getFirstName());
		txtFirstName.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		txtFirstName.setColumns(10);
		txtFirstName.setBackground(new Color(255, 255, 255));
		
		JLabel label_14 = new JLabel("l");
		label_14.setBounds(20, 43, 367, 55);
		label_14.setForeground(new Color(255, 215, 0));
		label_14.setFont(new Font("Microsoft YaHei", Font.BOLD, 39));
		
		JLabel label_15 = new JLabel("_______________");
		label_15.setBounds(23, 11, 364, 81);
		label_15.setForeground(new Color(255, 215, 0));
		label_15.setFont(new Font("Microsoft YaHei", Font.BOLD, 54));
		
		txtLastName = new JTextField();
		txtLastName.setEditable(false);
		txtLastName.setBounds(26, 107, 362, 31);
		txtLastName.setToolTipText("");
		txtLastName.setText("Last Name:"+ accountShow.getLastName());
		txtLastName.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		txtLastName.setColumns(10);
		txtLastName.setBackground(new Color(255, 255, 255));
		
		JLabel label_16 = new JLabel("l");
		label_16.setBounds(20, 97, 367, 55);
		label_16.setForeground(new Color(255, 215, 0));
		label_16.setFont(new Font("Microsoft YaHei", Font.BOLD, 39));
		
		JLabel label_17 = new JLabel("_______________");
		label_17.setBounds(23, 65, 364, 81);
		label_17.setForeground(new Color(255, 215, 0));
		label_17.setFont(new Font("Microsoft YaHei", Font.BOLD, 54));
		
		txtSocialSecurityXxxxxx = new JTextField();
		txtSocialSecurityXxxxxx.setBounds(26, 167, 362, 31);
		txtSocialSecurityXxxxxx.setToolTipText("");
		txtSocialSecurityXxxxxx.setText("SSN: "+ accountShow.getSsn());
		txtSocialSecurityXxxxxx.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		txtSocialSecurityXxxxxx.setEditable(false);
		txtSocialSecurityXxxxxx.setColumns(10);
		txtSocialSecurityXxxxxx.setBackground(Color.WHITE);
		
		JLabel label_18 = new JLabel("l");
		label_18.setBounds(20, 157, 367, 55);
		label_18.setForeground(new Color(255, 215, 0));
		label_18.setFont(new Font("Microsoft YaHei", Font.BOLD, 39));
		
		JLabel label_19 = new JLabel("_______________");
		label_19.setBounds(23, 125, 364, 81);
		label_19.setForeground(new Color(255, 215, 0));
		label_19.setFont(new Font("Microsoft YaHei", Font.BOLD, 54));
		
		txtPhone = new JTextField();
		txtPhone.setEditable(false);
		txtPhone.setBounds(26, 224, 362, 31);
		txtPhone.setToolTipText("");
		txtPhone.setText("Phone: "+ accountShow.getPhoneNumber());
		txtPhone.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		txtPhone.setColumns(10);
		txtPhone.setBackground(new Color(255, 255, 255));
		
		JLabel label_20 = new JLabel("l");
		label_20.setBounds(20, 214, 367, 55);
		label_20.setForeground(new Color(255, 215, 0));
		label_20.setFont(new Font("Microsoft YaHei", Font.BOLD, 39));
		
		JLabel label_21 = new JLabel("_______________");
		label_21.setBounds(23, 182, 364, 81);
		label_21.setForeground(new Color(255, 215, 0));
		label_21.setFont(new Font("Microsoft YaHei", Font.BOLD, 54));
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setBounds(26, 281, 362, 31);
		txtEmail.setToolTipText("");
		txtEmail.setText("E-Mail:"+ accountShow.getEmail());
		txtEmail.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBackground(new Color(255, 255, 255));
		
		JLabel label_22 = new JLabel("l");
		label_22.setBounds(20, 271, 367, 55);
		label_22.setForeground(new Color(255, 215, 0));
		label_22.setFont(new Font("Microsoft YaHei", Font.BOLD, 39));
		
		JLabel label_23 = new JLabel("_______________");
		label_23.setBounds(23, 239, 364, 81);
		label_23.setForeground(new Color(255, 215, 0));
		label_23.setFont(new Font("Microsoft YaHei", Font.BOLD, 54));
		
		txtAddress = new JTextField();
		txtAddress.setBounds(26, 322, 362, 31);
		txtAddress.setToolTipText("");
		txtAddress.setText("Address:"+ accountShow.getAddress());
		txtAddress.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		txtAddress.setEditable(false);
		txtAddress.setColumns(10);
		txtAddress.setBackground(Color.WHITE);
		
		JLabel label_24 = new JLabel("l");
		label_24.setBounds(20, 312, 367, 55);
		label_24.setForeground(new Color(255, 215, 0));
		label_24.setFont(new Font("Microsoft YaHei", Font.BOLD, 39));
		
		JLabel label_25 = new JLabel("_______________");
		label_25.setBounds(23, 280, 364, 81);
		label_25.setForeground(new Color(255, 215, 0));
		label_25.setFont(new Font("Microsoft YaHei", Font.BOLD, 54));
		Profile.setLayout(null);
		Profile.add(lblProfile);
		Profile.add(lblProfile_1);
		Profile.add(txtFirstName);
		Profile.add(label_14);
		Profile.add(label_15);
		Profile.add(txtLastName);
		Profile.add(label_16);
		Profile.add(label_17);
		Profile.add(txtSocialSecurityXxxxxx);
		Profile.add(label_18);
		Profile.add(label_19);
		Profile.add(txtPhone);
		Profile.add(label_20);
		Profile.add(label_21);
		Profile.add(txtEmail);
		Profile.add(label_22);
		Profile.add(label_23);
		Profile.add(txtAddress);
		Profile.add(label_24);
		Profile.add(label_25);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(20, 360, 360, 110);
		textArea.setText(accountShow.getMoreInfo());
		Profile.add(textArea);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(261, 18, 89, 23);
		btnEdit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//frame.setVisible(true);
				new EditProfileGUI().editProfileClick();;
				frame.setEnabled(false);
			}
			
		});
		Profile.add(btnEdit);
	}
	


	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		//LoginGUI login = new LoginGUI();
		//System.out.println("Closing");
		frame.dispose();
		LoginGUI frame = new LoginGUI();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
		
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
