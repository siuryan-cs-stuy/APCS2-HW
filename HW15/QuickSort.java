// Ryan Siu
// APCS2 pd5
// HW15 -- So So Quick
// 2017-03-08

/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): Run partition on an array, break the array into subarrays on
 *             either side of the number placed in the correct index, and 
 *             run partition on each of the subarrays. Repeat.
 *
 * 2a. Worst pivot choice / array state and associated runtime: 
 *     When the chosen pivot value is moved to either extreme of the array.
 *     O(n^2)
 *
 * 2b. Best pivot choice / array state and associated runtime: 
 *     When the chosen pivot value is moved to the middle of the array.
 *     O(nlogn)
 *
 * 3. Approach to handling duplicate values in array: 
 *    Duplicates are already handled by the partition method; they are put to
 *     the left of the partitioned array.
 *
 *****************************************************/

public class QuickSort 
{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }
    //--------------^  HELPER METHODS  ^--------------



    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort( int[] d ) 
    { 
	qsort( d, 0, d.length - 1);
    }

    // Thinkers are encouraged to roll their own subroutines.
    // Insert your auxiliary helper methods here.


    // Helper method for wrapper
    public static void qsort( int[] d, int left, int right ) 
    { 
	if (left < right) {
	    int pvtPos = partition( d, left, right, left); // last param doesn't matter
	    System.out.println(pvtPos);
	    qsort( d, left, pvtPos - 1);
	    qsort( d, pvtPos + 1, right);
	}
    }


    // Partition method
    public static int partition( int arr[], int left, int right, int pivPos)
    {
	int pivVal = arr[pivPos];

	swap( pivPos, right, arr );
	int s = left;

	for( int i = left; i < right; i++ ) {
	    if ( arr[i] <= pivVal) {
		swap( i, s, arr );
		s++;}
	}
	swap( s, right, arr);

	return s;
    }

    //main method for testing
    public static void main( String[] args ) 
    {
	
	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,12,3};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);

	qsort( arr1 );	
       	System.out.println("arr1 after qsort: " );
	printArr(arr1);

	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	    arrN[i] = i;
       
	System.out.println("\narrN init'd to: " );
	printArr(arrN);

       	shuffle(arrN);
       	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	qsort( arrN );
	System.out.println("arrN after sort: " );
	printArr(arrN);

	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2 );	
       	System.out.println("arr2 after qsort: " );
	printArr(arr2);


	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	    arrMatey[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

       	shuffle(arrMatey);
       	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);

    }//end main

}//end class QuickSort
