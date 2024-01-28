import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

public class SearchBooks extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBooks frame = new SearchBooks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	private JTextField textFieldBookName;
	private JTextField textFieldAuthor;

	/**
	 * Create the frame.
	 */
	public SearchBooks() {
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnSearchBooks = new JButton("Search Book");
		btnSearchBooks.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearchBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String bookName = textFieldBookName.getText();
					String author = textFieldAuthor.getText();

					if (bookName == null || bookName.isEmpty() || author == null || author.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Invalid input. Please enter both Book Name and Author.");
						return;
					}
					String query = "select * from BookInfo where BookName =? and Author =?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textFieldBookName.getText());
					pst.setString(2, textFieldAuthor.getText());
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception exp) {
					exp.printStackTrace();
				}
			}
		});

		btnSearchBooks.setBounds(500, 265, 160, 31);
		contentPane.add(btnSearchBooks);

		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldAuthor.setText(null);
				textFieldBookName.setText(null);

				JOptionPane.showMessageDialog(null, "Data Reset");
			}
		});
		btnReset.setBounds(540, 220, 85, 21);
		contentPane.add(btnReset);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 306, 843, 161);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		textFieldBookName = new JTextField();
		textFieldBookName.setBounds(581, 112, 140, 21);
		contentPane.add(textFieldBookName);
		textFieldBookName.setColumns(10);

		JLabel lblBookName = new JLabel("Book Name :");
		lblBookName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBookName.setBounds(473, 112, 109, 13);
		contentPane.add(lblBookName);

		textFieldAuthor = new JTextField();
		textFieldAuthor.setBounds(581, 175, 140, 21);
		contentPane.add(textFieldAuthor);
		textFieldAuthor.setColumns(10);

		JLabel lblAuthor = new JLabel("Author : ");
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAuthor.setBounds(473, 175, 109, 13);
		contentPane.add(lblAuthor);

		JLabel lblNewLabel_1 = new JLabel("BookShop Automation Software");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Rockwell Condensed", Font.BOLD, 30));
		lblNewLabel_1.setBounds(246, 0, 391, 44);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/searchicon1.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img2));
		lblNewLabel.setBounds(224, 100, 200, 150);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("developed by \u00A9Suvam");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(701, 484, 178, 27);
		contentPane.add(lblNewLabel_2);

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

				LoginFrame loginFrame = new LoginFrame();
				loginFrame.setVisible(true);
			}
		});
		btnBack.setBounds(25, 487, 85, 21);
		contentPane.add(btnBack);

	}

}
