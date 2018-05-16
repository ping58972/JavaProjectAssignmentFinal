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

public class DepositCheckingGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void cDepositClick() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepositCheckingGUI frame = new DepositCheckingGUI();
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
	public DepositCheckingGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 388);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		addWindowListener(window);
		
		JLabel lblCheckingDeposit = new JLabel("Checking Deposit");
		lblCheckingDeposit.setForeground(new Color(255, 255, 255));
		lblCheckingDeposit.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
		lblCheckingDeposit.setBounds(109, 45, 246, 44);
		contentPane.add(lblCheckingDeposit);
		
		JLabel lblCheckingDeposit_1 = new JLabel("Checking Deposit");
		lblCheckingDeposit_1.setForeground(new Color(204, 204, 204));
		lblCheckingDeposit_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
		lblCheckingDeposit_1.setBounds(107, 45, 248, 44);
		contentPane.add(lblCheckingDeposit_1);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setText("$"+LoginGUI.customer.getCheckingAccount().getBalance().toString());
		textField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(new Color(204, 204, 255));
		textField.setBounds(117, 124, 192, 26);
		contentPane.add(textField);
		
		JLabel label_2 = new JLabel("l");
		label_2.setForeground(new Color(255, 215, 0));
		label_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 34));
		label_2.setBounds(112, 100, 388, 77);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("________");
		label_3.setForeground(new Color(255, 215, 0));
		label_3.setFont(new Font("Microsoft YaHei", Font.BOLD, 54));
		label_3.setBounds(115, 74, 254, 86);
		contentPane.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("");
		textField_1.setText("$");
		textField_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(117, 203, 192, 26);
		contentPane.add(textField_1);
		
		JLabel label_4 = new JLabel("l");
		label_4.setForeground(new Color(255, 215, 0));
		label_4.setFont(new Font("Microsoft YaHei", Font.BOLD, 34));
		label_4.setBounds(112, 179, 388, 77);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("________");
		label_5.setForeground(new Color(255, 215, 0));
		label_5.setFont(new Font("Microsoft YaHei", Font.BOLD, 54));
		label_5.setBounds(115, 153, 254, 86);
		contentPane.add(label_5);
		
		JLabel lblAccountBalance = new JLabel("Account Balance");
		lblAccountBalance.setBackground(Color.WHITE);
		lblAccountBalance.setForeground(new Color(255, 255, 255));
		lblAccountBalance.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblAccountBalance.setBounds(148, 95, 126, 26);
		contentPane.add(lblAccountBalance);
		
		JLabel lblAmountToDeposit = new JLabel("Amount to Deposit");
		lblAmountToDeposit.setBackground(new Color(255, 204, 0));
		lblAmountToDeposit.setForeground(new Color(255, 255, 255));
		lblAmountToDeposit.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblAmountToDeposit.setBounds(137, 170, 155, 26);
		contentPane.add(lblAmountToDeposit);
		
		JButton btnDeposit = new JButton("DEPOSIT");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String command = arg0.getActionCommand();
				if(command.equals("DEPOSIT")) {
					dispose();

				}
				
				try {
					LoginGUI.customer.getCheckingAccount().makeDeposit(textField_1.getText().substring(1));
					textField.setText("$" + LoginGUI.customer.getCheckingAccount().getBalance().toString());
					textField_1.setText("$");
					new EditProfileGUI().saveToFile();
				}catch(InvalidInputException e) {
					/*******************GUI FOR THIS ERROR*************/
					textField_1.setText("$");
				}catch(Exception e) {
					/*******************GENERAL ERROR GUI FOR EVERYTHING ELSE***********/
					textField_1.setText("$");
				}
				AccountGUI.frame.setVisible(true);
				AccountGUI.frame.setLocationRelativeTo(null);
				AccountGUI.frame.setEnabled(true);
			}
		});
		btnDeposit.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 11));
		btnDeposit.setBounds(156, 267, 106, 32);
		contentPane.add(btnDeposit);
		getRootPane().setDefaultButton(btnDeposit);
		

		
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
