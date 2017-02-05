// Team TraverseTheReverse -- Ryan Siu and Eric Zhang
// APCS2 pd5
// HW04 -- Where In the Array Is Carmen San Numero?
// 2017-02-05

/* ALGORITHM
   Uses the input array's indicies as a way to keep track if that index number 
    has already appeared in the array.

   Assume the input array is arr.
   1. Looks at an index i:
   2. If you've traversed the entire array, the index of the number in the 
      array that is still positive is the missing number.
   2. If the value at index arr[i] is positive, change the value at index 
      arr[i] so it's negative. Increment i and go back to 1.
   3. Else, the value is already negative, which means this arr[i] is the 
      dupicate. Increment i and go back to 1.

*/

public class MissingNum {

    public static void main(String[] args) {
	int[] test = {1,1};
	int[] a = {1,3,3,4};
	int[] b = {2,5,3,5,6,1};
	int[] c = {1,2,3,4,5,6,7,8,9,10,10,12,13,14,15};
        int[] coffee = {6,2,10,27,49,21,5,16,34,50,31,2,11,38,14,25,28,36,12,1,3,43,22,40,4,44,7,17,18,29,41,8,33,19,46,9,45,20,13,23,24,42,39,30,15,35,26,32,37,47};
	
	System.out.println( findMissing(test) );     // 2
	System.out.println( findMissing(a) );        // 2
	System.out.println( findMissing(b) );        // 4
	System.out.println( findMissing(c) );        // 11
	System.out.println( findMissing(coffee) );   // 48  
    }

    
    // Returns the missing int
    // Runtime: O(n) with the constraint of O(1) expanded space
    public static int findMissing(int[] arr) {
	
	// Assign negatives as markers for found numbers
        for (int i = 0; i < arr.length; i++) {
	    int index = Math.abs(arr[i]) - 1;
	    if (arr[index] > 0) {
		arr[index] = -arr[index];
	    }
	}
	// Look through array for positive number
	for (int i = 0; i < arr.length; i++) {
	    if (arr[i] > 0) {
	        return i + 1;
	    }
	}

	// never gets to this point
	return 0;
	
    }
    
}
