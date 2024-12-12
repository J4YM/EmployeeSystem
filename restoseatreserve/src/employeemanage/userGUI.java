package ProjectGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class userGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userGUI frame = new userGUI();
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
	public userGUI() {
		setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel sidePanel = new JPanel();
		sidePanel.setBackground(new Color(0, 64, 128));
		sidePanel.setBounds(0, 0, 279, 661);
		contentPane.add(sidePanel);
		sidePanel.setLayout(null);
		
		JLabel greetings = new JLabel("Welcome back,");
		greetings.setHorizontalAlignment(SwingConstants.CENTER);
		greetings.setFont(new Font("Arial", Font.PLAIN, 14));
		greetings.setForeground(new Color(255, 255, 255));
		greetings.setBounds(44, 73, 178, 51);
		sidePanel.add(greetings);
		
		JLabel usernameField = new JLabel("User Name");
		usernameField.setHorizontalAlignment(SwingConstants.CENTER);
		usernameField.setForeground(Color.WHITE);
		usernameField.setFont(new Font("Arial", Font.BOLD, 25));
		usernameField.setBounds(44, 103, 178, 51);
		sidePanel.add(usernameField);
		
		JLabel idLabel = new JLabel("ID:");
		idLabel.setForeground(Color.WHITE);
		idLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		idLabel.setBounds(44, 165, 17, 51);
		sidePanel.add(idLabel);
		
		JLabel idField = new JLabel("idField");
		idField.setForeground(Color.WHITE);
		idField.setFont(new Font("Arial", Font.PLAIN, 14));
		idField.setBounds(66, 165, 156, 51);
		sidePanel.add(idField);
		
		JButton logoutBtn = new JButton("LOGOUT");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select = JOptionPane.showConfirmDialog(logoutBtn, "Are you sure you want to logout?");
				if(select == 0) {
					dispose();
					JOptionPane.showMessageDialog(null, "Logout successfully");
					Restoseatreserve.main(null);
				}
			}
		});
		logoutBtn.setFont(new Font("Arial", Font.BOLD, 11));
		logoutBtn.setBounds(92, 584, 89, 23);
		sidePanel.add(logoutBtn);
		
		JLabel balanceLabel = new JLabel("Balance");
		balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		balanceLabel.setForeground(new Color(64, 0, 64));
		balanceLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		balanceLabel.setBounds(347, 56, 178, 51);
		contentPane.add(balanceLabel);
		
		JLabel salaryLabel = new JLabel("Salary");
		salaryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		salaryLabel.setForeground(new Color(64, 0, 64));
		salaryLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		salaryLabel.setBounds(535, 56, 178, 51);
		contentPane.add(salaryLabel);
		
		JLabel lastpaidLabel = new JLabel("Last Paid");
		lastpaidLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lastpaidLabel.setForeground(new Color(64, 0, 64));
		lastpaidLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lastpaidLabel.setBounds(723, 56, 178, 51);
		contentPane.add(lastpaidLabel);
		
		JLabel balanceField = new JLabel("balanceField");
		balanceField.setHorizontalAlignment(SwingConstants.CENTER);
		balanceField.setForeground(new Color(64, 0, 64));
		balanceField.setFont(new Font("Arial", Font.PLAIN, 18));
		balanceField.setBounds(347, 86, 178, 51);
		contentPane.add(balanceField);
		
		JLabel salaryField = new JLabel("salaryField");
		salaryField.setHorizontalAlignment(SwingConstants.CENTER);
		salaryField.setForeground(new Color(64, 0, 64));
		salaryField.setFont(new Font("Arial", Font.PLAIN, 18));
		salaryField.setBounds(535, 86, 178, 51);
		contentPane.add(salaryField);
		
		JLabel lastpaidField = new JLabel("lastpaidFIeld");
		lastpaidField.setHorizontalAlignment(SwingConstants.CENTER);
		lastpaidField.setForeground(new Color(64, 0, 64));
		lastpaidField.setFont(new Font("Arial", Font.PLAIN, 18));
		lastpaidField.setBounds(723, 86, 178, 51);
		contentPane.add(lastpaidField);
		
		
		JLabel graphField = new JLabel("");
		graphField.setForeground(new Color(0, 0, 0));
		graphField.setBackground(new Color(192, 192, 192));
		graphField.setBounds(334, 265, 600, 355);
		contentPane.add(graphField);
		
		ImageIcon bar = new ImageIcon("C:\\Users\\nigel\\eclipse-workspace\\ProjectGUI\\src\\ProjectGUI\\bar-graph.png");
		ImageIcon line = new ImageIcon("C:\\Users\\nigel\\eclipse-workspace\\ProjectGUI\\src\\ProjectGUI\\line-graph.png");
		graphField.setIcon(bar);
		
		JButton lineBtn = new JButton("Line Graph");
		lineBtn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lineBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				graphField.setIcon(line);
			}
		});
		lineBtn.setBounds(723, 216, 89, 23);
		contentPane.add(lineBtn);
		
		JButton barBtn = new JButton("Bar Graph");
		barBtn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		barBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				graphField.setIcon(bar);
			}
		});
		barBtn.setBounds(812, 216, 89, 23);
		contentPane.add(barBtn);
	}
}
