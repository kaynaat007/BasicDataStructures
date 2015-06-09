import java.util.Scanner;


public class Heap {
	
	static int heapSize = 0;
	
	static void print ( int [] h , int s ) {
		
		int i;
		for ( i = 0; i < s; i++ ) {
			
			System.out.print ( h[i] ) ;
			System.out.print ( ' ') ;
						
		}
		
		System.out.println ( "end") ;
	}
	
	

	
	static void heapify ( int [] h, int index,  int n ) {
		
		int largest ;
		if  ( index >= heapSize) {
			
			return ;
			
		}
		if ( ( 2 * index + 1 >= heapSize) && ( 2 * index + 2 >= heapSize) ) {
			
			return ;
			
		}
		
		if ( 2 * index + 2 >= heapSize ) { // no right child of index, but there is  left child ofcourse.  
			 
		
			
			  if ( h[index] > h[ 2 * index + 1 ]) { // if index  is greater than only left child 
				  
				  largest = index;
				   
			  }
			  else { 
				  
				  
				   largest = 2 * index + 1;
				   
				  
			  }
			  
			  
			    int t = h[index] ;
				h[index] = h[largest];
				h[largest] = t;
				
			   if ( largest != index ) {
				   
		  		 heapify ( h, largest,  n ) ;
		  		
			   }
			   else {
				   
				   return ;
				   
			   }
			  		  
			
		} // if 
		// reach here only if index has two children, both left and right. 
		
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		
		if ( h[left] > h[right] ) {
			
			 largest = left;
			
		}
		else {
			
			
			 largest  = right ;
			
			
		} // else  
		
		
		
		if ( h[index] > h[largest] ) {
			
			largest = index ;
			
			
		}
		
		int t = h[index] ;
		h[index] = h[largest];
		h[largest] = t;
		
	   if ( largest != index ) {
		   
  		 heapify ( h, largest,  n ) ;
  		
	   }
		
		
	
	}
	
	static void build_heap ( int [] h,  int n  ) {
		
		int  i;
		for ( i = heapSize/2; i >= 0; i--) {
			
			heapify ( h, i , n  ) ;
						
		}
		
		
		
	}
	static int extract_max ( int [] h,  int n ) {
		
		if ( heapSize == 0 ) {
			
			return  -1;
		}
		
		int x = h[0];
		h[0] = h[heapSize-1];
		h[heapSize-1] = x;
		heapSize = heapSize-1;
		heapify ( h, 0, n ) ;
		
		return x;
		
	}
	public static void main ( String args[] ) {
		
		int [] heap = new int[ 100 ]; // array of max size; 
		int n  = 100;
	
		Scanner in = new Scanner(System.in);
		System.out.println ( "enter size of heap : ") ;
	    heapSize = in.nextInt(); // take size of heap.
	    
		System.out.println ( "enter elements of heap : ") ;
		    
		for ( int  i = 0; i < heapSize; i++ ) {
			
			  heap[i] = in.nextInt();
			
		}
		
		Heap.print ( heap, heapSize ) ;
		build_heap ( heap,  n ) ;
		print ( heap, heapSize ) ;
		//int x = extract_max ( heap , n) ;
		///System.out.println ( "maximum element : " + x ) ;
	//	print ( heap, heapSize) ;
		
					
	} // main 

	
	
	
}
