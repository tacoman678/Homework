import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JScrollBar;

public class ScrabbleMain extends JFrame {

	private JPanel contentPane;
	private JTextField Letter1;
	private JTextField Letter2;
	private JTextField Letter3;
	private JTextField Letter4;
	private JTextField showResult;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScrabbleMain frame = new ScrabbleMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ScrabbleMain() {
		initialize();

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrabble();
			}
		});
	}
	
	private void scrabble() {
		Scrabble b = new Scrabble(Letter1.getText(),Letter2.getText(),Letter3.getText(),Letter4.getText());
		b.checkLetters();
		if(!b.error) {
			Scrabble.permutations(b.getL1()+b.getL2()+b.getL3()+b.getL4(), "");
		}
		showResult.setText("hello");
		//showResult.setText(b.getOutput());
	}

	/**
	 * Create the frame.
	 */
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Scrabble App");
		lblNewLabel.setBounds(173, 11, 80, 27);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Generate Combinations");
		btnNewButton.setBounds(128, 92, 175, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Please Enter 4 Characters");
		lblNewLabel_1.setBounds(128, 36, 163, 14);
		contentPane.add(lblNewLabel_1);
		
		Letter1 = new JTextField();
		Letter1.setBounds(102, 61, 59, 20);
		contentPane.add(Letter1);
		Letter1.setColumns(10);
		
		Letter2 = new JTextField();
		Letter2.setText("");
		Letter2.setBounds(171, 61, 59, 20);
		contentPane.add(Letter2);
		Letter2.setColumns(10);
		
		Letter3 = new JTextField();
		Letter3.setBounds(240, 61, 51, 20);
		contentPane.add(Letter3);
		Letter3.setColumns(10);
		
		Letter4 = new JTextField();
		Letter4.setBounds(299, 61, 51, 20);
		contentPane.add(Letter4);
		Letter4.setColumns(10);
		
		showResult = new JTextField();
		showResult.setBounds(102, 143, 231, 59);
		contentPane.add(showResult);
		showResult.setColumns(10);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(316, 143, 17, 59);
		contentPane.add(scrollBar);
	}
}
