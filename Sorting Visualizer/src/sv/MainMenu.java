package sv;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.EventQueue;

import java.io.IOException;


public class MainMenu {
	
	public static String algo[]={"Bubble Sort","Quick Sort","Merge Sort"};

	private JFrame frame;

	public static void menu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainMenu() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		initialize();
	}

	private static String path;

	private void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.setBounds(100, 100, 692, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel panelTop = new JPanel();
		panelTop.setBackground(Color.WHITE);
		panelTop.setBounds(0, 0, 676, 66);
		frame.getContentPane().add(panelTop);
		panelTop.setLayout(null);
		
		JLabel labelHeader = new JLabel("Sorting Algorithm Visualizer");
		labelHeader.setFont(new Font("Segoe UI", Font.BOLD, 20));
		labelHeader.setBounds(197, 0, 292, 33);
		panelTop.add(labelHeader);
		
		JLabel labelCredits = new JLabel("Felix Bergmann 2020");
		labelCredits.setBounds(250, 31, 167, 24);
		panelTop.add(labelCredits);
		labelCredits.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(Color.WHITE);
		panelLeft.setBounds(343, 72, 333, 333);
		frame.getContentPane().add(panelLeft);
		panelLeft.setLayout(null);
		
		JLabel labelStart = new JLabel("Start the Simulation");
		labelStart.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		labelStart.setBounds(72, 62, 180, 44);
		panelLeft.add(labelStart);
		
		JPanel panelRight = new JPanel();
		panelRight.setBackground(Color.WHITE);
		panelRight.setBounds(0, 72, 338, 333);
		frame.getContentPane().add(panelRight);
		panelRight.setLayout(null);
		
		JComboBox comboBox = new JComboBox(algo);
		comboBox.setBounds(71, 92, 180, 22);
		panelRight.add(comboBox);
		
		JButton buttonStart = new JButton("Start");
		buttonStart.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		buttonStart.setBounds(72, 141, 180, 83);
		panelLeft.add(buttonStart);
		
		buttonStart.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  
				  frame.dispose();

				  MainApp.algo = String.valueOf(comboBox.getItemAt(comboBox.getSelectedIndex()));

				  synchronized(MainApp.syncObj)
			        {
			          MainApp.syncObj.notify();
			        }
			  }
			
		} );
		
		
		JLabel labelChooseA = new JLabel("Choose the Algorithm");
		labelChooseA.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		labelChooseA.setBounds(71, 24, 180, 44);
		panelRight.add(labelChooseA);
		
		JLabel labelChooseF = new JLabel("Choose File to Sort");
		labelChooseF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		labelChooseF.setBounds(98, 190, 132, 44);
		panelRight.add(labelChooseF);
		
		JButton buttonChoose = new JButton("Choose File");
		buttonChoose.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		buttonChoose.setBounds(112, 260, 101, 23);
		panelRight.add(buttonChoose);
		
		buttonChoose.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  JFileChooser chooser = new JFileChooser();
			        
			        chooser.showOpenDialog(null);
			        path = chooser.getSelectedFile().getAbsolutePath();
			        
			        //label.setText(path);
			        try {
						FileInput.readFile(path);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  
			  } 
		} );
		
		JLabel labelOptional = new JLabel("(optional)");
		labelOptional.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		labelOptional.setBounds(132, 226, 64, 23);
		panelRight.add(labelOptional);
		
	}
}
