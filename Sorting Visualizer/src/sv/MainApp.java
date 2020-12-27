package sv;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

import javax.swing.*;

public class MainApp {
	
	static int a[] = {42, 70, 60, 53, 100, 99, 86, 16, 65, 88, 91, 3, 41, 5, 21, 81, 80, 63, 50, 98, 66, 37, 68, 96, 26, 15, 77, 6, 36, 97, 45, 82, 58, 93, 73, 34, 14, 89, 56, 59, 32, 94, 19, 7, 48, 87, 71, 12, 31, 55, 76, 90, 61, 39, 10, 8, 69, 28, 35, 44, 78, 4, 40, 67, 17, 85, 83, 13, 95, 84, 49, 43, 23, 51, 79, 64, 18, 30, 2, 20, 22, 29, 47, 74, 54, 25, 75, 33, 38, 72, 24, 92, 52, 46, 9, 11, 62, 57, 27, 1};
	public static Object syncObj = new Object();
	public static String algo;
	
	public static void main(String[] args) throws InterruptedException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		//System.out.print(height_rect);
		
		
		MainMenu.menu();
		
		synchronized(syncObj)
	      {
	        syncObj.wait();
	      }
		
		SortingAlgorithm alg = new SortingAlgorithm(a);
		//System.out.println(java.util.Arrays.toString(a));
		Visualizer.visualize();
		
        Thread.sleep(100);
        
        switch (algo) {
		case "Bubble Sort": {
			alg.BubbleSort();
		}
		case "Quick Sort": {
			alg.QuickSort(0, a.length-1);
		}
		case "Merge Sort": {
			alg.MergeSort(0, a.length-1);
		}
        }
             
        
		Visualizer.frame.repaint();
		
		
	}
	
}