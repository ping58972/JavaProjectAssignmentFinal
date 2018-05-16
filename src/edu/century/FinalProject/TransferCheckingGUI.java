package edu.century.FinalProject;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class TransferCheckingGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void cTransferClick() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransferCheckingGUI frame = new TransferCheckingGUI();
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
	public TransferCheckingGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 442, 505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		addWindowListener(window);
		
		JLabel lblCheckingTransfer = new JLabel("Checking Transfer");
		lblCheckingTransfer.setForeground(new Color(255, 255, 255));
		lblCheckingTransfer.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
		lblCheckingTransfer.setBounds(110, 56, 237, 33);
		contentPane.add(lblCheckingTransfer);
		
		JLabel lblCheckingTransfer_1 = new JLabel("Checking Transfer");
		lblCheckingTransfer_1.setForeground(new Color(204, 204, 204));
		lblCheckingTransfer_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
		lblCheckingTransfer_1.setBounds(108, 50, 248, 44);
		contentPane.add(lblCheckingTransfer_1);
		
		String[] accounts = {"", "Saving Account", "Other Account"};
		JComboBox comboBox = new JComboBox(accounts);
		comboBox.setBounds(125, 129, 192, 26);
		contentPane.add(comboBox);
		
		JLabel label_2 = new JLabel("l");
		label_2.setForeground(new Color(255, 215, 0));
		label_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 34));
		label_2.setBounds(120, 105, 388, 77);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("________");
		label_3.setForeground(new Color(255, 215, 0));
		label_3.setFont(new Font("Microsoft YaHei", Font.BOLD, 54));
		label_3.setBounds(123, 79, 254, 86);
		contentPane.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("");
		textField_1.setText("$");
		textField_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setBounds(115, 315, 192, 26);
		contentPane.add(textField_1);
		
		JLabel label_4 = new JLabel("l");
		label_4.setForeground(new Color(255, 215, 0));
		label_4.setFont(new Font("Microsoft YaHei", Font.BOLD, 34));
		label_4.setBounds(110, 291, 388, 77);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("________");
		label_5.setForeground(new Color(255, 215, 0));
		label_5.setFont(new Font("Microsoft YaHei", Font.BOLD, 54));
		label_5.setBounds(113, 265, 254, 86);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Transfer to:");
		label_6.setForeground(new Color(255, 255, 255));
		label_6.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		label_6.setBounds(129, 98, 126, 26);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Amount to Transfer");
		label_7.setForeground(new Color(255, 255, 255));
		label_7.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		label_7.setBounds(135, 282, 155, 26);
		contentPane.add(label_7);
		
		JButton button = new JButton("Transfer");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String command = arg0.getActionCommand();
				if(command.equals("Transfer")) {
					dispose();
				}
				
				try {
					LoginGUI.customer.getCheckingAccount().makeWithdrawal(textField_1.getText().substring(1));
					LoginGUI.customer.getSavingsAccount().makeDeposit(textField_1.getText().substring(1));
					textField_1.setText("$");
					textField.setText("$" + LoginGUI.customer.getCheckingAccount().getBalance().toString());
					new EditProfileGUI().saveToFile();
				}catch(InvalidInputException e) {
					/***********************GUI FOR THIS ERROR************/
					textField_1.setText("$");
				}catch(InsufficientFundsException e) {
					ErrorGUI nw = new ErrorGUI("Invalid Input");
					nw.errorPop("Error: Insufficient Fund Entered");
					textField_1.setText("$");
				}catch(Exception e) {
					/***************GENERAL ERROR FOR EVERYTHING ELSE********************/
					textField_1.setText("$");
					e.printStackTrace();
				}
				AccountGUI.frame.setVisible(true);
				AccountGUI.frame.setLocationRelativeTo(null);
				AccountGUI.frame.setEnabled(true);
			}
		});
		button.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 11));
		button.setBounds(163, 379, 106, 32);
		contentPane.add(button);
		getRootPane().setDefaultButton(button);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setText("$" + LoginGUI.customer.getCheckingAccount().getBalance().toString());
		textField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(new Color(204, 204, 255));
		textField.setBounds(125, 216, 192, 26);
		contentPane.add(textField);
		
		JLabel label = new JLabel("l");
		label.setForeground(new Color(255, 215, 0));
		label.setFont(new Font("Microsoft YaHei", Font.BOLD, 34));
		label.setBounds(120, 192, 388, 77);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("________");
		label_1.setForeground(new Color(255, 215, 0));
		label_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 54));
		label_1.setBounds(123, 166, 254, 86);
		contentPane.add(label_1);
		
		JLabel lblAccountBalance = new JLabel("Account Balance");
		lblAccountBalance.setForeground(Color.WHITE);
		lblAccountBalance.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblAccountBalance.setBackground(Color.WHITE);
		lblAccountBalance.setBounds(156, 187, 126, 26);
		contentPane.add(lblAccountBalance);
		
		
	}
	WindowListener window = new WindowListener() {



		@Override
		public void windowClosing(WindowEvent arg0) {
			// TODO Auto-generated method stub
			dispose();
			AccountGUI.frame.setVisible(true);
			AccountGUI.frame.setLocationRelativeTo(null);
			AccountGUI.frame.setEnabled(true);
		}

		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		
	};
}
