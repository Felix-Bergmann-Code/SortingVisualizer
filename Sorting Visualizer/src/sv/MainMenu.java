package sv;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;


public class MainMenu {

	private JFrame frame;
	
	
	
	public static void menu() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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

	public MainMenu() {
		initialize();
	}

	private static String path;
	
	private void initialize() {
		String algo[]={"Bubble Sort","Quick Sort","Merge Sort"};
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		
		JLabel lblNewLabel = new JLabel("Please select a Sorting Algorithm");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
		JComboBox comboBox = new JComboBox(algo);
		
		
		JButton select = new JButton("Select File");
		
		select.addActionListener(new ActionListener() { 
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
		
		
		JButton btnStartSimulation = new JButton("Start Sorting");
		btnStartSimulation.setForeground(Color.BLACK);
		
		btnStartSimulation.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  
				 
				  frame.dispose();

				  
				  MainApp.algo = String.valueOf(comboBox.getItemAt(comboBox.getSelectedIndex()));
				  
				  //Visualizer.visualize(String.valueOf(comboBox.getItemAt(comboBox.getSelectedIndex())));
				  synchronized(MainApp.syncObj)
			        {
			          MainApp.syncObj.notify();
			        }
			  }
			
		} );
		
		
		
		JLabel lblSelectExternalFile = new JLabel("Select External File to Sort");
		lblSelectExternalFile.setFont(new Font("Segoe UI", Font.BOLD, 18));
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(169)
					.addComponent(btnStartSimulation, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
					.addGap(172))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(319, Short.MAX_VALUE)
					
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(lblNewLabel)
					.addContainerGap(34, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(177)
					.addComponent(select)
					.addContainerGap(186, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblSelectExternalFile, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(96)
							.addComponent(comboBox, 0, 254, Short.MAX_VALUE)))
					.addGap(94))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(lblSelectExternalFile, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(select)
					.addGap(4)
					
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnStartSimulation, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
		);
		frame.getContentPane().setLayout(groupLayout);
		
	}
}