import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;

public class MyMain {

	// SPECIFY THE APPLICATION ELEMENTS: UI AND OBJECTS
	private static JButton inputBtn;
	private static JFrame jframeWindow;
	private static JPanel panel;
	private static File fileToRead;
	private static File fileToSave;
	private static ArrayList<CodeLine> lines = new ArrayList<CodeLine>();

	public static void main(String[] args) {
		// create GUI application window
		constructAppWindow();
		addListenerEvents();
	}

	private static void constructAppWindow() {
		jframeWindow = new JFrame();
		jframeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// construct a panel container to store buttons, etc.
		panel = new JPanel(new GridLayout(3, 0)); // 3 ROWS NO COLUMNS
		panel.setPreferredSize(new Dimension(500, 150));
		panel.setBackground(Color.DARK_GRAY);

		// build buttons, etc. and add them to the panel
		inputBtn = new JButton("Specify Input Text File");
		panel.add(inputBtn);

		// add panel to the application window
		jframeWindow.getContentPane().add(panel);

		// TASK 5: MAKE THE APPLICATION WINDOW VISIBLE TO THE USER
		jframeWindow.pack();
		jframeWindow.setVisible(true);
	}

	private static void addListenerEvents() {
		inputBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requestInputFile();
			}
		});

	}

	public static void requestInputFile() {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			fileToRead = jfc.getSelectedFile();
			try {
				Scanner myReader = new Scanner(fileToRead);
				while (myReader.hasNextLine()) {
					String data = myReader.nextLine();
					if (data.contains("}") || data.contains(";") || data.contains("{")) {
						lines.add(new CodeLine(data.trim()));
					}
				}
				myReader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		performCalculations();
	}

	public static void performCalculations() {
		ProgramCounter program = new ProgramCounter();
		for (int i = 0; i < lines.size(); i++) {
			if (lines.get(i).getFor()) {
				program.addFor();
			}
			if (lines.get(i).getWhile()) {
				program.addWhile();
			}
			if (lines.get(i).getIf()) {
				program.addIf();
			}
			if (lines.get(i).methodHeader()) {
				program.addMethodHeader(lines.get(i).getCodeLine());
			}
			program.addLine();
		}
		System.out.println("Number of Total Lines: " + program.getLines() + "\nNumber of For Loops: " + program.getFor()
				+ "\nNumber of While Loops: " + program.getWhile() + "\nNumber of If/Else Statements: "
				+ program.getIf() + "\nNumber of Methods: " + program.getMethodHeaders().size());
		for (int i = 0; i < program.getMethodHeaders().size(); i++) {
			System.out.println(program.getMethodHeaders().get(i));
		}
	}
}