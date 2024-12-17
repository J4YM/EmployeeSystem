package employeemanage;


import employee.backend.backend;
import employee.backend.employee;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class adminGUI {
    private final backend ItemService;
	private JFrame frame;
	private JTextField idEmployee;
	private JTextField nameEmployee;
	private JTextField salaryData;
	private JTable table;
	DefaultTableModel mod;
	private JTextField balanceData;
	private JTextField dateTimeData;
	private JTextField dayText;
	private JTextField timeText;
	private JTextField timeBoxT;

	/**
	 * Launch the application.
     * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminGUI window = new adminGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public adminGUI() {
            ItemService = new backend();
            initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 930, 790);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(58, 58, 58));
		panel.setBackground(new Color(58, 58, 58));
		panel.setBounds(0, 0, 914, 727);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee ID");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(31, 81, 160, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Employee Name");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(31, 146, 160, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Paid");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(31, 341, 108, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Monthly Salary");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(31, 213, 123, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Balance");
		lblNewLabel_3_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(31, 279, 108, 14);
		panel.add(lblNewLabel_3_1);
		
		idEmployee = new JTextField();
		idEmployee.setBounds(31, 106, 199, 20);
		panel.add(idEmployee);
		idEmployee.setColumns(10);
		
		nameEmployee = new JTextField();
		nameEmployee.setColumns(10);
		nameEmployee.setBounds(31, 171, 199, 20);
		panel.add(nameEmployee);
		
		salaryData = new JTextField();
		salaryData.setColumns(10);
		salaryData.setBounds(31, 238, 199, 20);
		panel.add(salaryData);
		
		balanceData = new JTextField();
		balanceData.setColumns(10);
		balanceData.setBounds(31, 304, 199, 20);
		panel.add(balanceData);
		
		JTextArea txtrStockManagementSystem = new JTextArea();
		txtrStockManagementSystem.setForeground(new Color(255, 255, 255));
		txtrStockManagementSystem.setBackground(new Color(58, 58, 58));
		txtrStockManagementSystem.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtrStockManagementSystem.setText("Employee Management");
		txtrStockManagementSystem.setBounds(58, 30, 172, 22);
		panel.add(txtrStockManagementSystem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(265, 11, 639, 707);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int etab = table.getSelectedRow();
				idEmployee.setText(mod.getValueAt(etab, 0).toString());
				nameEmployee.setText(mod.getValueAt(etab, 1).toString());
				salaryData.setText(mod.getValueAt(etab, 2).toString());
				balanceData.setText(mod.getValueAt(etab, 3).toString());
                                
			}
		});
		mod = new DefaultTableModel();
		Object[] column = {"Employee ID", "Name", "Monthly Salary", "Balance", "Last Paid" }; //years worked [5]
		Object[] row = new Object[5];
		mod.setColumnIdentifiers(column);
		table.setModel(mod);
		scrollPane.setViewportView(table);
                
                ItemService.getAll().forEach((item) -> {
                    row[0] = item.getID();
					row[1] = item.getName();
					row[2] = item.getSalary();
					row[3] = item.getBalance();
					row[4] = item.getDaT();
					
					mod.addRow(row);
                });
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idEmployee.getText().equals("") || nameEmployee.getText().equals("") || timeText.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Fill out the Information");
				} else if(timeBoxT.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Choose 'AM' or 'PM'");
				} else if (idEmployee.getText().equals(row[0]) || idEmployee.getText().equals(row[0])) {
					JOptionPane.showMessageDialog(null, "This seat was already reserved.");
				} else {
                                        //Add item to database
                                        String id = idEmployee.getText();
                                        String Name = nameEmployee.getText();
                                        String salary = salaryData.getText();
                                        String balance = balanceData.getText();
                                        String DaT = dateTimeData.getText() + "  " +dayText.getText() + "  " + timeText.getText() + " " +timeBoxT.getText();
                                        
                                        employee item = new employee(id, Name, salary, balance, DaT);
                                        
                                        ItemService.create(item);
                                        
                                        //Initial display
					row[0] = idEmployee.getText();
					row[1] = nameEmployee.getText();
					row[2] = salaryData.getText();
					row[3] = balanceData.getText();
					row[4] = dateTimeData.getText() + "  " +dayText.getText() + "  " + timeText.getText() + " " +timeBoxT.getText();
					
					mod.addRow(row);
					
					idEmployee.setText("");
					nameEmployee.setText("");
					dateTimeData.setText("");
					salaryData.setText("");
					balanceData.setText("");
					dayText.setText("");
					timeText.setText("");
					timeBoxT.setText("");
					JOptionPane.showMessageDialog(null, "New Reservation Succesfully added!");
				}
			}
		});
		btnNewButton.setBounds(38, 541, 75, 23);
		panel.add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                                String id = idEmployee.getText();
                                
				int tab = table.getSelectedRow();
				int select = JOptionPane.showConfirmDialog(btnDelete, "WARNING: This will remove this data!");
				if (tab >= 0) {
					if (select == 0) {
						mod.removeRow(tab);
                                                boolean isDeleted = ItemService.delete(id);
                                                if (!isDeleted) {
                                                    JOptionPane.showMessageDialog(null, "No Item has been found to delete");
                                                    return;
                                                }
						JOptionPane.showMessageDialog(null, "Employee Data Succesfully removed!");
					} else {	
						JOptionPane.showMessageDialog(null, "Data has been retained!");
					}
				}
			}
		});
		btnDelete.setBounds(143, 541, 75, 23);
		panel.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (idEmployee.getText().equals("") || nameEmployee.getText().equals("") || dateTimeData.getText().equals("") || salaryData.getText().equals("") || timeText.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Complete New Information!");
				} else if(timeBoxT.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Choose 'AM' or 'PM'");
				} else {
					int etab = table.getSelectedRow();
					mod.setValueAt(idEmployee.getText(), etab, 0); //numbers 0-4 are the table
					mod.setValueAt(nameEmployee.getText(), etab, 1);
					mod.setValueAt(salaryData.getText(), etab, 2);
					mod.setValueAt(balanceData.getText(), etab, 3);
					mod.setValueAt(dateTimeData.getText()+ "  "+dayText.getText() +" "+timeText.getText()+ " "+timeBoxT.getText(), etab, 4);
                                        
                                        String srcName = idEmployee.getText();
                                        employee updatedItem = new employee(idEmployee.getText(), nameEmployee.getText(), salaryData.getText(), balanceData.getText(), dateTimeData.getText()+ " "+dayText.getText()+" "+timeText.getText()+ " "+timeBoxT.getText());
                                        
                                        boolean isUpdated = ItemService.update(srcName, updatedItem);

                                        if (!isUpdated) {
                                            JOptionPane.showMessageDialog(null, "No item name was found to be updated.");
                                            return;
                                        }
                                        
					JOptionPane.showMessageDialog(null, "Employee info updated successfully!");
				}
			}
		});
		btnUpdate.setBounds(38, 589, 75, 23);
		panel.add(btnUpdate);
		
		JButton removeText = new JButton("Clear");
		removeText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idEmployee.setText("");
				nameEmployee.setText("");
				dateTimeData.setText("");
				salaryData.setText("");
				balanceData.setText("");
				dayText.setText("");
				timeText.setText("");
				timeBoxT.setText("");
			}
		});
		removeText.setBounds(143, 589, 75, 23);
		panel.add(removeText);
		
		JComboBox monthBox = new JComboBox();
		monthBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedValue = monthBox.getSelectedItem().toString();
				dateTimeData.setText(selectedValue);
			}
		});
		monthBox.setMaximumRowCount(6);
		monthBox.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		monthBox.setBounds(142, 386, 88, 22);
		panel.add(monthBox);
		
		dateTimeData = new JTextField();
		dateTimeData.setBounds(31, 386, 88, 22);
		panel.add(dateTimeData);
		dateTimeData.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Month");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(58, 366, 46, 14);
		panel.add(lblNewLabel_4);
		
		JComboBox dayBox = new JComboBox();
		dayBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedValue = dayBox.getSelectedItem().toString();
				dayText.setText(selectedValue);
			}
		});
		dayBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dayBox.setMaximumRowCount(6);
		dayBox.setBounds(142, 429, 88, 22);
		panel.add(dayBox);
		
		dayText = new JTextField();
		dayText.setColumns(10);
		dayText.setBounds(31, 429, 87, 22);
		panel.add(dayText);
		
		JLabel lblNewLabel_4_1 = new JLabel("Day");
		lblNewLabel_4_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_4_1.setBounds(62, 412, 46, 14);
		panel.add(lblNewLabel_4_1);
		
		timeText = new JTextField();
		timeText.setColumns(10);
		timeText.setBounds(31, 478, 87, 22);
		panel.add(timeText);
		
		JLabel lblNewLabel_4_2 = new JLabel("Time");
		lblNewLabel_4_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_4_2.setBounds(62, 457, 46, 14);
		panel.add(lblNewLabel_4_2);
		
		JComboBox timeBox = new JComboBox();
		timeBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedValue = timeBox.getSelectedItem().toString();
				timeBoxT.setText(selectedValue);
			}
		});
		
		timeBox.setModel(new DefaultComboBoxModel(new String[] {"AM", "PM"}));
		timeBox.setMaximumRowCount(6);
		timeBox.setBounds(142, 478, 88, 22);
		panel.add(timeBox);
		
		timeBoxT = new JTextField();
		timeBoxT.setColumns(10);
		timeBoxT.setBounds(67, 508, 0, 22);
		panel.add(timeBoxT);
		
		JButton logoutBtn = new JButton("LOGOUT");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select = JOptionPane.showConfirmDialog(logoutBtn, "Are you sure you want to logout?");
				if(select == 0) {
					frame.dispose();
					JOptionPane.showMessageDialog(null, "Logout successfully");
					loginGUI.main(null);
				}
			}
		});
		logoutBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		logoutBtn.setBounds(83, 662, 89, 23);
		panel.add(logoutBtn);
	}
}
