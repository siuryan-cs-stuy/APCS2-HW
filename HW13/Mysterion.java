// Ryan Siu
// APCS2 pd5
// HW13 -- We Be Dem
// 2017-03-06

public class Mysterion {

    
    /* Arranges the elements in an array when run continously on an array. If 
     * partition is the average of low and high, then the final modified array
     * will be sorted. Otherwise, the final modified array will contain elements
     * greater than the partition element at indicies greater than partiton,
     * less than the partition element at indicies less than partition. This 
     * method should be run until the returned number is the same two times in
     * a row.
     * low - lower bound for arranging
     * high - upper bound for arranging
     */
    public int arrange( int[] arr, int low, int high, int partition) {
	int v = arr[partition];
	swap( arr, partition, high );
	int s = low;

	for (int i = low; i < high; i++) {
	    if (arr[i] < v) {
		swap( arr, s, i );
		s += 1;
	    }
	}

	swap( arr, b, s );
	return s;
    }
    

    // Helper method for swapping
    private void swap( int[] arr, int pos1, int pos2 ) {
	int placeholder = arr[pos1];
	arr[pos1] = arr[pos2];
	arr[pos2] = placeholder;
    }


    // Test calls
    public static void main( String[] args ) {

	int a = 0;
	int b = 8;
	int c = 4;
	
	Mysterion m = new Mysterion();
	int[] test = { 3, 0, 16, 599, 1024, 9, 15, 1, 2 };

	int prevTest = 0;
        int currTest = m.test(test, a, b, c);

	while (prevTest != currTest) {
	    prevTest = currTest;
	    currTest = m.test(test, a, b, c);
	    System.out.println( currTest );
	}
	
	System.out.print("{");
	for (int i = 0; i < test.length; i++) {
	    System.out.print( test[i] + ", " );
	}
	System.out.println("}");
	
    }
    
}
