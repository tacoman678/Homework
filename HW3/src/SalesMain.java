import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SalesMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesMain frame = new SalesMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		SalesItem s = new SalesItem("cake", 3.44, 3);
		String a = s.toString();
		SalesItem t = new SalesItem("cakeass", 3.33, 2);
		SalesItem u = new SalesItem("cakebutt", 3.22, 4);
		SalesSlip x = new SalesSlip();
		x.addSalesItem(s);
		x.addSalesItem(u);
		x.addSalesItem(t);
		String b = x.toString();
		String c = x.computeTotal();
	}

	/**
	 * Create the frame.
	 */
	public SalesMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
