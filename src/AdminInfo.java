import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.sql.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class AdminInfo extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminInfo frame = new AdminInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection=null;
	private JLabel lblName;
	private JLabel lblEID;
	private JLabel lblUserID;
	private JLabel lblPassword;
	private JTextField textFieldEID;
	private JTextField textFieldName;
	private JTextField textFieldUserID;
	private JTextField textFieldPassword;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnBack;
	private JLabel lblNewLabel_3;
	
	
	public void refreshTable() {
		try {
			String query="select EID,Name,UserID,Password from AdminInfo";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			pst.close();
			rs.close();
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public AdminInfo() {
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoadData = new JButton("Load Admin Data");
		btnLoadData.setFont(new Font("Dialog", Font.BOLD, 14));
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select EID,Name,UserID,Password from AdminInfo";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					rs.close();
					
				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}
		});
		btnLoadData.setBounds(588, 63, 190, 42);
		contentPane.add(btnLoadData);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(487, 120, 391, 344);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblName = new JLabel("Name :");
		lblName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblName.setBounds(50, 225, 62, 28);
		contentPane.add(lblName);
		
		lblEID = new JLabel("EID :");
		lblEID.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEID.setBounds(50, 187, 85, 28);
		contentPane.add(lblEID);
		
		lblUserID = new JLabel("UserID :");
		lblUserID.setFont(new Font("Dialog", Font.BOLD, 14));
		lblUserID.setBounds(50, 263, 74, 27);
		contentPane.add(lblUserID);
		
		lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPassword.setBounds(50, 300, 85, 31);
		contentPane.add(lblPassword);
		
		textFieldEID = new JTextField();
		textFieldEID.setBounds(159, 194, 91, 19);
		contentPane.add(textFieldEID);
		textFieldEID.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(159, 232, 91, 19);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldUserID = new JTextField();
		textFieldUserID.setBounds(159, 269, 91, 19);
		contentPane.add(textFieldUserID);
		textFieldUserID.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(159, 308, 91, 19);
		contentPane.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		lblNewLabel = new JLabel("developed by \u00A9Suvam");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(720, 482, 184, 31);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("BookShop Automation Software ");
		lblNewLabel_1.setFont(new Font("Rockwell Condensed", Font.BOLD, 22));
		lblNewLabel_1.setBounds(239, 10, 401, 43);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New Admin Registration :");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 106, 268, 40);
		contentPane.add(lblNewLabel_2);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Dialog", Font.BOLD, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

				LoginFrame loginFrame = new LoginFrame();
				loginFrame.setVisible(true);
			}
		});
		btnBack.setBounds(10, 480, 91, 28);
		contentPane.add(btnBack);
		
		lblNewLabel_3 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/lock_icon_1.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img2));
		lblNewLabel_3.setBounds(277, 138, 200, 353);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query="insert into AdminInfo (EID,Name,UserID,Password) values (?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textFieldEID.getText());
					pst.setString(2, textFieldName.getText());
					pst.setString(3, textFieldUserID.getText());
					pst.setString(4, textFieldPassword.getText());
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Saved");
					
					pst.close();
					
				} catch (Exception exc) {
					exc.printStackTrace();
				}
				refreshTable();
			}
		});
		btnNewButton.setBounds(40, 374, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldEID.setText(null);
				textFieldName.setText(null);
				textFieldPassword.setText(null);
				textFieldUserID.setText(null);
				
				
				JOptionPane.showMessageDialog(null, "Data Reset");
			}
		});
		btnReset.setBounds(150,374, 85,21);
		contentPane.add(btnReset);
	}
}
