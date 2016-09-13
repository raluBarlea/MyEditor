package connect;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CreateAccount extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUserN;
	private JTextField textFieldPass;
	private JTextField textFieldName;
	private JTextField textFieldMail;
	private JButton btnCreateAccount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount frame = new CreateAccount();
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
	public CreateAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblYourUsername = new JLabel("username:");
		lblYourUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblYourUsername.setBounds(45, 60, 100, 14);
		contentPane.add(lblYourUsername);
		
		JLabel lblPassword = new JLabel("password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(45, 89, 103, 14);
		contentPane.add(lblPassword);
		
		JLabel lblYourName = new JLabel("your name:");
		lblYourName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblYourName.setBounds(45, 120, 80, 14);
		contentPane.add(lblYourName);
		
		JLabel lblNewLabel = new JLabel("e-mail:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(45, 151, 80, 14);
		contentPane.add(lblNewLabel);
		
		textFieldUserN = new JTextField();
		textFieldUserN.setBounds(146, 58, 86, 20);
		contentPane.add(textFieldUserN);
		textFieldUserN.setColumns(10);
		
		textFieldPass = new JTextField();
		textFieldPass.setBounds(146, 87, 86, 20);
		contentPane.add(textFieldPass);
		textFieldPass.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(146, 118, 86, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldMail = new JTextField();
		textFieldMail.setBounds(146, 149, 86, 20);
		contentPane.add(textFieldMail);
		textFieldMail.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Complete next fields");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(105, 11, 246, 14);
		contentPane.add(lblNewLabel_1);
		
		btnCreateAccount = new JButton("Create account!");
		btnCreateAccount.addActionListener(new ActionListener() {
		//insert the date into db
			ResultSet result;
			public void actionPerformed(ActionEvent e) {
				
				try {
					DBconnect conn = new DBconnect();
					conn.insertData(" INSERT INTO users (username,password,fullname,email) VALUES ('" + textFieldUserN.getText() 
									+ "','" + textFieldPass.getText() + "','" + textFieldName.getText()
									+ "','" +textFieldMail.getText() + "');");
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});
		btnCreateAccount.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCreateAccount.setBounds(83, 193, 127, 23);
		contentPane.add(btnCreateAccount);
		
	}

}
