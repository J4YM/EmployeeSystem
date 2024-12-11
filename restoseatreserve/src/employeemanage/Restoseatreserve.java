package employeemanage;

/**
 *
 * @author Rubs
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import employee.backend.credsBackend;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Restoseatreserve extends credsBackend{

	private JFrame frame;
	private JPasswordField password;
	private JTextField username;
	

	/**
	 * Launch the application.
     * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
                    try {
                        var window = new Restoseatreserve();
                        window.frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
	}

	/**
	 * Create the application.
	 */
	public Restoseatreserve() {
            createRequiredFileIfDoesNotExist();
            initialize();
	}
        
        
        private static void createRequiredFileIfDoesNotExist() {
            String fileNames [];
        
            File rootDir = new File("DATABASE");
            rootDir.mkdirs();
        
            fileNames = new String [] {"DATABASE/reservedatabase.txt"};
        
            for (String fileName : fileNames) {
                File f = new File(fileName);
                if(!f.exists())
                {  
                    try {
                        f.createNewFile();
                    } catch (IOException ex) {
                        Logger.getLogger(Restoseatreserve.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }        
        }
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
                
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(58, 58, 58));
		frame.getContentPane().setForeground(new Color(58, 58, 58));
		frame.setBounds(100, 100, 450, 314);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOG IN");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblNewLabel.setBounds(151, 11, 127, 54);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblNewLabel_1.setBounds(73, 90, 103, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(73, 120, 103, 23);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		password = new JPasswordField();
		password.setBounds(176, 124, 186, 20);
		frame.getContentPane().add(password);
		
		username = new JTextField();
		username.setBounds(176, 95, 186, 20);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener((ActionEvent e) -> {
                    String uName = username.getText();
                    String pass = password.getText();
                    
                    credsBackend cb = new credsBackend();
                    
                    if(pass.contains("1234")&& uName.contains("admin")) {
                        SRProject.main(null);
                        frame.dispose();
                    } else if(cb.checkCreds(uName, pass)) {
                        userDash.main(null);
                        frame.dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"           LOGIN ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
                        username.setText("");
                        password.setText("");
                    }
                });
		btnLogin.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnLogin.setBounds(59, 203, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener((ActionEvent e) -> {
                    username.setText("");
                    password.setText("");
                });
		btnReset.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnReset.setBounds(176, 203, 89, 23);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener((ActionEvent e) -> {
                    System.exit(0);
                });
		btnExit.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnExit.setBounds(291, 203, 89, 23);
		frame.getContentPane().add(btnExit);
	}
}
