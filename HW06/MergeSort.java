// Ryan Siu
// APCS2 pd5
// HW06 -- Step 1: Split, Step 2: ?, Step 3: Sorted!
// 2017-02-12

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 
  1. If there's one element in the array, it's sorted. Return.
  2. Divide array into halves recursively.
  3. Merge smaller arrays into larger arrays (the larger arrays are sorted 
     upon merge).

  ======================================*/

public class MergeSort {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) 
    {
        int[] retArr = new int[a.length + b.length];
	int aIndex = 0;
	int bIndex = 0;
	while (a.length > aIndex && b.length > bIndex) {
	    if (a[aIndex] < b[bIndex]) {
		retArr[aIndex + bIndex] = a[aIndex];
		aIndex++;
	    } else {
		retArr[aIndex + bIndex] = b[bIndex];
		bIndex++;
	    }
	}
	for (int i = bIndex; i < b.length; i++) {
	    retArr[aIndex + i] = b[i];
	}
	for (int i = aIndex; i < a.length; i++) {
	    retArr[i + bIndex] = a[i];
	}
	return retArr;
    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) 
    {
	if (arr.length == 1) {
	    return arr;
	}
	
	int[] firstHalf = new int[arr.length/2];
	int[] secondHalf = new int[arr.length-arr.length/2];

	for (int i = 0; i < firstHalf.length; i++) {
	    firstHalf[i] = arr[i];
	}
	for (int i = arr.length/2; i < arr.length; i++) {
	    secondHalf[i-(arr.length/2)] = arr[i];
	}

	firstHalf = sort(firstHalf);
	secondHalf = sort(secondHalf);

	return merge( firstHalf, secondHalf );
	
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {

	
	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );

	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );

	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(arr4,arr6) );
	
	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );
	/*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class MergeSort

