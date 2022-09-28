import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PasswordBuilderMain1 {

	private JFrame frame;
	private JTextField enterPassword;
	private JTextField showResult;
	private JButton testPassword;
	private JLabel password;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordBuilderMain1 window = new PasswordBuilderMain1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void TestPassword() {
		PasswordBuilder pass = new PasswordBuilder(enterPassword.getText());
		pass.checkPassword();
		showResult.setText(pass.getOutput());
	}
	/**
	 * Create the application.
	 */
	public PasswordBuilderMain1() {
		initialize();
		testPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TestPassword();
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel password = new JLabel("Password Tester");
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		password.setBounds(-24, 41, 438, 34);
		frame.getContentPane().add(password);

		enterPassword = new JTextField();
		enterPassword.setBounds(137, 74, 130, 26);
		frame.getContentPane().add(enterPassword);
		enterPassword.setColumns(10);

		//TEST PASSWORD BUTTON
		testPassword = new JButton("Test Password");
		testPassword.setBounds(147, 104, 117, 29);
		frame.getContentPane().add(testPassword);


		//OUTPUT PASSWORD STRENGTH:  TEXTFIELD
		showResult = new JTextField();
		showResult.setBounds(80, 144, 270, 64);
		frame.getContentPane().add(showResult);
		showResult.setColumns(10);
	}

}
