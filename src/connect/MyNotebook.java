package connect;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;

public class MyNotebook extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
////		//connect to database
//		DBconnect db = new DBconnect();
//		db.getData();
//		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MyNotebook frame = new MyNotebook();
//					frame.setVisible(true);
//					frame.setTitle("Ana's notebook");
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public MyNotebook() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		
		JTextArea textArea = new JTextArea();
		textArea.setRows(15);
		textArea.setBackground(Color.PINK);
		contentPane.add(textArea, BorderLayout.CENTER);
		JScrollPane scroll = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scroll,BorderLayout.CENTER);
		
		JMenuBar JMB = new JMenuBar();
		setJMenuBar(JMB);
		JMenu file = new JMenu("File");
		JMB.add(file);
		JMenuItem New = new JMenuItem("New");
		file.add(New);
		JMenuItem save = new JMenuItem("Save");
		file.add(save);
		JMenuItem quit = new JMenuItem("Quit");
		file.add(quit);
		
		JMenu edit = new JMenu("Edit");
		JMB.add(edit);
		JMenuItem copy = new JMenuItem("Copy");
		edit.add(copy);
		JMenuItem paste = new JMenuItem("Paste");
		edit.add(paste);
	}

}
