package connect;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.sun.glass.ui.Timer;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.time.*;
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField_username;
	private JPasswordField passwordField;
	private PreparedStatement ps;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Login");
		getContentPane().setBackground(new Color(204, 204, 255));
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(45, 64, 76, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(45, 114, 63, 25);
		contentPane.add(lblNewLabel_1);
		
		textField_username = new JTextField();
		textField_username.setBounds(131, 73, 137, 20);
		contentPane.add(textField_username);
		textField_username.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(131, 116, 137, 20);
		contentPane.add(passwordField);
		
		JCheckBox checkbxShowPassword = new JCheckBox("Show password");
		checkbxShowPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkbxShowPassword.addActionListener(new ActionListener() {
			
			//set the password visible or not
			public void actionPerformed(ActionEvent e) {
				if(checkbxShowPassword.isSelected()){
					passwordField.setEchoChar((char)0);
				}else{
					passwordField.setEchoChar('*');
				}
			}
		});
		checkbxShowPassword.setBounds(292, 115, 115, 23);
		contentPane.add(checkbxShowPassword);
		
		//panel for message
		JPanel message_panel = new JPanel();
		message_panel.setBackground(Color.PINK);
		message_panel.setBounds(10, 0, 414, 68);
		contentPane.add(message_panel);
		//label for message
		JLabel label = new JLabel();
		message_panel.add(label);
		label.setBackground(Color.RED);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet result;
				
				try{
					DBconnect conn = new DBconnect();
					result = conn.getData("SELECT 'username','password' FROM users WHERE username='"
							+ textField_username.getText() +"'"
							+ " AND" + " password='"
							+ String.valueOf(passwordField.getPassword())
							+ "'");
					
					if(result.next()){
						label.setText("Connected!");
						label.setForeground(Color.green);
						
						//open the notebook jFrame
						MyNotebook notebook = new MyNotebook();
						notebook.setVisible(true);
						//when notebook is open, the login jFrame is close
						dispose();
					
					}else{
						label.setText("Invalid user or password");
						label.setForeground(Color.red);
					}
					
				}catch(SQLException e1){
					System.out.println(e1);
				}
				
				
			}
		});
		
		btnLogin.setBounds(152, 164, 94, 23);
		contentPane.add(btnLogin);	
		
		JButton btnNewButton = new JButton("Create new account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateAccount acc = new CreateAccount();
				acc.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(131, 198, 137, 23);
		contentPane.add(btnNewButton);
	}
}
