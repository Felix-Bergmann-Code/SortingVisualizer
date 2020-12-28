package sv;

public class SortingAlgorithm {
	
	static int a[];
	static int speed=10;
	
	public SortingAlgorithm(int a[]) throws InterruptedException{
		
		this.a = a;
	}
	
	public int[] BubbleSort() throws InterruptedException {
		
		int temp;
		
		for(int i= 0; i<a.length;i++) {
			for(int j = 0; j<a.length-1-i;j++) {
				if(a[j]>=a[j+1]) {
					temp = a[j];
					a[j]= a[j+1];
					a[j+1]= temp;
				}
				Thread.sleep(speed);
				Visualizer.frame.repaint();
			}
		}
		
		return a;
		
	}
	
	public static int[] QuickSort(int low, int high) throws InterruptedException{
		
		int t;
		
		  if (low < high) {
		    t = SplitQuickSort(low, high);
		    
		    Thread.sleep(speed);
			Visualizer.frame.repaint();
		    
		    QuickSort(low, t);
		    
		    QuickSort(t + 1, high);
		    
		  }
		  
		return a;
		  
	}
	
	private static int SplitQuickSort(int low, int high) throws InterruptedException{
		
		int i, j, pivot = a[low];
		  i = low - 1;
		  j = high + 1;
		  while (true) {
		    do {
		      i++;
		    } while (a[i] < pivot);
		    do {
		      j--;
		    } while (a[j] > pivot);
		    if (i < j) {
		      int b = a[i];
		      a[i] = a[j];
		      a[j] = b;
		      
		      Thread.sleep(speed);
		      Visualizer.frame.repaint();
		      
		    } else {
		      return j;
		    }
		 }
	}
	
	void MergeSort(int l, int r) throws InterruptedException{
        
		if (l < r) {
            
            int m = (l + r) / 2;
 
            Thread.sleep(speed);
			Visualizer.frame.repaint();
			
            MergeSort(l, m);
            MergeSort(m + 1, r);
 
            MergeSortMerge(l, m, r);
        }
    }
	
	void MergeSortMerge(int l, int m, int r) throws InterruptedException{
      
        int n1 = m - l + 1;
        int n2 = r - m;
 
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        for (int i = 0; i < n1; ++i)
            L[i] = a[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = a[m + 1 + j];

        int i = 0, j = 0;
 
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            }
            else {
                a[k] = R[j];
                j++;
            }
            k++;
            
            Thread.sleep(speed);
    		Visualizer.frame.repaint();
        }

        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
            
            Thread.sleep(speed);
    		Visualizer.frame.repaint();
        }
 
        while (j < n2) {
            a[k] = R[j];
            j++;
            k++;
            
            Thread.sleep(speed);
    		Visualizer.frame.repaint();
        }
    }
}