package edu.century.FinalProject;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import java.awt.Dialog.ModalExclusionType;

public class ErrorGUI extends JFrame{

	private static JPanel contentPane;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void errorPop(String message) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErrorGUI frame = new ErrorGUI(message);
					contentPane.setLayout(null);
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
	public ErrorGUI(String message) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 392, 203);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//JLabel lblNewLabel = new JLabel("Error:\r\n Amount not available.");
		JLabel lblNewLabel = new JLabel(message);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, -5, 366, 136);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setAction(action);
		btnNewButton.setBounds(126, 99, 89, 23);
		contentPane.add(btnNewButton);
		getRootPane().setDefaultButton(btnNewButton);
		}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "OK");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
}
