package sv;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.IOException;

import java.util.Arrays;


public class FileInput {
	
	public static void readFile(String path) throws IOException {
		
				cleanPath(path);
		
			    Path path1 = Paths.get("C:/Users/bergm/OneDrive - HTL Saalfelden/Desktop/a.txt");
			    String read = Files.readAllLines(path1).get(0);  
			      
			    String[] splitArray = read.split(", ");
			    
		        int[] array = new int[splitArray.length];
		        for(int i=0;i<splitArray.length;i++)
		        {
		        	try {
		        		array[i] = Integer.parseInt(splitArray[i]);
		            } catch (NumberFormatException e) {
		            	array[i]=-1;
		            }
		        }
		        
		        MainApp.a = array;
	}
	
	private static String cleanPath(String path) {
		path = path.replace('\\', '/');
		return path;
	}

}
