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

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class WithdrawCheckingGUI extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void cWithdrawClick() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WithdrawCheckingGUI frame = new WithdrawCheckingGUI();
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
	public WithdrawCheckingGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 388);
		contentPane = new JPanel();
		getContentPane().setBackground(new Color(0, 153, 255));
		getContentPane().setLayout(null);
		addWindowListener(window);
		
		JLabel lblCheckingWithdraw = new JLabel("Checking Withdraw");
		lblCheckingWithdraw.setBounds(104, 49, 237, 33);
		getContentPane().add(lblCheckingWithdraw);
		lblCheckingWithdraw.setForeground(new Color(255, 255, 255));
		lblCheckingWithdraw.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
		
		JLabel lblCheckingWithdraw_1 = new JLabel("Checking Withdraw");
		lblCheckingWithdraw_1.setForeground(new Color(204, 204, 204));
		lblCheckingWithdraw_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
		lblCheckingWithdraw_1.setBounds(102, 43, 248, 44);
		getContentPane().add(lblCheckingWithdraw_1);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("");
		textField_2.setText("$"+LoginGUI.customer.getCheckingAccount().getBalance().toString());
		textField_2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(204, 204, 255));
		textField_2.setBounds(128, 122, 192, 26);
		getContentPane().add(textField_2);
		
		JLabel label_2 = new JLabel("l");
		label_2.setForeground(new Color(255, 215, 0));
		label_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 34));
		label_2.setBounds(122, 98, 388, 77);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("________");
		label_3.setForeground(new Color(255, 215, 0));
		label_3.setFont(new Font("Microsoft YaHei", Font.BOLD, 54));
		label_3.setBounds(125, 72, 254, 86);
		getContentPane().add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("");
		textField_1.setText("$");
		textField_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(127, 201, 192, 26);
		getContentPane().add(textField_1);
		
		JLabel label = new JLabel("l");
		label.setForeground(new Color(255, 215, 0));
		label.setFont(new Font("Microsoft YaHei", Font.BOLD, 34));
		label.setBounds(122, 177, 388, 77);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("________");
		label_1.setForeground(new Color(255, 215, 0));
		label_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 54));
		label_1.setBounds(125, 151, 254, 86);
		getContentPane().add(label_1);
		
		JLabel lblAmountAvailable = new JLabel("Account Balance");
		lblAmountAvailable.setForeground(new Color(255, 255, 255));
		lblAmountAvailable.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblAmountAvailable.setBounds(158, 93, 126, 26);
		getContentPane().add(lblAmountAvailable);
		
		JLabel lblAmountToWithdraw = new JLabel("Amount to Withdraw");
		lblAmountToWithdraw.setForeground(new Color(255, 255, 255));
		lblAmountToWithdraw.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblAmountToWithdraw.setBounds(147, 168, 155, 26);
		getContentPane().add(lblAmountToWithdraw);
		
		JButton button = new JButton("WITHDRAW");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String command = arg0.getActionCommand();
				if(command.equals("WITHDRAW")) {
					dispose();
				}
				
				try {
					LoginGUI.customer.getCheckingAccount().makeWithdrawal((textField_1.getText().substring(1)));
					textField_2.setText("$ " + LoginGUI.customer.getCheckingAccount().getBalance().toString());
					textField_1.setText("$");
					new EditProfileGUI().saveToFile();
				}catch(InvalidInputException e) {
					ErrorGUI nw = new ErrorGUI("Error: Insufficient Fund Entered");
					
					textField_1.setText("$");
				}catch(InsufficientFundsException e){
					ErrorGUI nw = new ErrorGUI("Error: Insufficient Fund Entered");
					nw.errorPop("Error: Insufficient Fund Entered");
					textField_1.setText("$");
				} catch (Exception e) {
					/**********GENERAL ERROR GUI FOR EVERYTHING ELSE***********/
				}
				AccountGUI.frame.setVisible(true);
				AccountGUI.frame.setLocationRelativeTo(null);
				AccountGUI.frame.setEnabled(true);
			}
		});
		button.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 11));
		button.setBounds(166, 265, 106, 32);
		getContentPane().add(button);
		setBackground(new Color(0, 153, 204));
		getRootPane().setDefaultButton(button);

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
