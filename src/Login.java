import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class Login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JLabel lblNewLabel_1;
	private JLabel lblpic1;
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 918, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblNewLabel_1 = new JLabel("BookShop Automation Software ");
		lblNewLabel_1.setFont(new Font("Rockwell Condensed", Font.BOLD, 22));
		lblNewLabel_1.setBounds(300, 20, 400, 44);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnContinue = new JButton("Continue to Admin Login");
		btnContinue.setFont(new Font("Tahoma", Font.BOLD, 14));
		Image img6 = new ImageIcon(this.getClass().getResource("/adminicon.png")).getImage();
		btnContinue.setIcon(new ImageIcon(img6));
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				LoginFrame loginFrame = new LoginFrame();
				loginFrame.setVisible(true);
			}
		});
		btnContinue.setBounds(320, 410, 276, 44);
		frame.getContentPane().add(btnContinue);
		
		lblpic1 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/bookicon2.png")).getImage();
		lblpic1.setIcon(new ImageIcon(img2));
		lblpic1.setBounds(248, 74, 408, 211);
		frame.getContentPane().add(lblpic1);
		
		JLabel lblNewLabel = new JLabel("developed by \u00A9Suvam");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(716, 481, 178, 27);
		frame.getContentPane().add(lblNewLabel);
	}
}
