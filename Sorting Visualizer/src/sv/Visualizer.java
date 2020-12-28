package sv;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.util.Arrays;


public class Visualizer extends JFrame implements ChangeListener{
	
	static JFrame frame = new JFrame("Draw Rectangle");
	static JSlider slider;
	
	static int max = Arrays.stream(MainApp.a).max().getAsInt();
	static int frame_width=900, frame_height=500;
	
	static int width_rect= (int) Math.round(((frame_width)/MainApp.a.length));
	static int height_rect=(int) ((frame_height/(max+10))+0.5);
	
	
	public static void visualize() throws InterruptedException {
		
		if(MainApp.a.length>50) {
			frame_width = width_rect*MainApp.a.length + width_rect*3;
		}else {
			frame_width = width_rect*MainApp.a.length + width_rect;
		}
		
		Visualizer v = new Visualizer();
		
		slider = new JSlider(0, 200, 10);
		slider.setMajorTickSpacing(50); 
		slider.setMinorTickSpacing(1);
		slider.setBackground(Color.WHITE);
		slider.setPaintLabels(true);
		slider.addChangeListener(v);
		
		JPanel panel = new JPanel() {
			@Override
		       protected void paintComponent(Graphics g) {

		        	Graphics2D g2 = (Graphics2D) g;
		        
		        	int y = frame_height-40;
		        	int width = width_rect;
	        	

		        	for(int i=0; i<MainApp.a.length; i++) {
		        		int x = 5+width_rect*i;
		        		int height = -MainApp.a[i]*height_rect;
		        	
		        		g2.fillRect(x, y, width, height);
	
		        	}
		        	
		       }
		};
		
		
			
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			panel.add(slider);
			
	        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			frame.add(panel, BorderLayout.CENTER);
	        frame.pack();
	        frame.setBackground(Color.WHITE);
	        frame.setSize(frame_width,frame_height);
	        frame.setResizable(false);
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	        
	        SortingAlgorithm.speed = slider.getValue();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		SortingAlgorithm.speed = slider.getValue();
		
	}

}