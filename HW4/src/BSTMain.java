import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class BSTMain {

	private JFrame frame;
	private JTextField input;
	private JTextField showResult;
	private JButton add;
	private JButton delete;
	private JButton search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BSTMain window = new BSTMain();
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
	public BSTMain() {
		initialize();
		String str = "Here is the perfect system for cleaning your room "
				+ "First move all of the items that do not have a proper place to the center of the room "
				+ "Get rid of at least five things that you have not used within the last year "
				+ "Take out all of the trash and place all of the dirty dishes in the kitchen sink "
				+ "Now find a location for each of the items you had placed in the center of the room "
				+ "For any remaining items see if you can squeeze them in under your bed or stuff "
				+ "them into the back of your closet "
				+ "See that was easy ";
		String[] index = str.split(" ");
		BST d = new BST();
		for(int i = 0;i <index.length;i++) {
			d.insertWordNode(index[i]);
		}
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String i = input.getText();
				d.insertWordNode(i);
				showResult.setText("Successfully added " + i + " to the Binary Search Tree");
			}
		});
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String i = input.getText();
				d.checkWord(i);
				showResult.setText("Successfully deleted " + i + " from the Binary Search Tree");
			}
		});
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String i = input.getText();
				boolean x = d.search(i);
				if(x) {
					showResult.setText(i + " is contained in the BST");
				}
				showResult.setText(i + " is not contained in the BST");
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
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dictionary Binary Search Tree");
		lblNewLabel.setBounds(121, 11, 185, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton add = new JButton("Add Word");
		add.setBounds(41, 129, 89, 23);
		frame.getContentPane().add(add);
		
		JButton delete = new JButton("Delete Word");
		delete.setBounds(140, 129, 102, 23);
		frame.getContentPane().add(delete);
		
		JButton search = new JButton("Search Word");
		search.setBounds(252, 129, 111, 23);
		frame.getContentPane().add(search);
		
		input = new JTextField();
		input.setBounds(83, 81, 223, 20);
		frame.getContentPane().add(input);
		input.setColumns(10);
		
		showResult = new JTextField();
		showResult.setBounds(83, 189, 223, 20);
		frame.getContentPane().add(showResult);
		showResult.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Input a word you would like to do work on the binary search tree:");
		lblNewLabel_1.setBounds(10, 65, 390, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Output:");
		lblNewLabel_2.setBounds(160, 163, 49, 14);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
