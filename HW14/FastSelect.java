// Ryan Siu
// APCS2 pd5
// HW14 -- So So Fast
// 2017-03-07

/*****************************************************
 * class FastSelect
 *
 * ALGORITHM
 * 1. Find the number of numbers less than (to the left of) the number at 
 *    pos right
 * 2. If this number is the yth letter, you're done.
 * 3. If this number is at a position greater than y, find the
 *    correct number in the smaller indicies.
 * 4. Otherwise, if this number is at a position less than y, find the 
 *    correct number in the larger indicies.
 ******************************************************/

public class FastSelect 
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

    // Wrapper method for find
    public static int find( int arr[], int y) {
	return find( arr, 0, arr.length - 1, y ); 
    }


    // Recursive method
    public static int find( int arr[], int left, int right, int y ) {
	int pos = partition( arr, left, right, right );

	if (pos - left == y - 1) {
	    return arr[pos];
	} else if (pos - left > y - 1) {
	    return find( arr, left, pos - 1, y);
	} else {
	    return find( arr, pos + 1, right, y - pos + left - 1);
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
	//init test arrays of magic numbers
	int[] arr = buildArray( 10, 10 );

	printArr( arr );
	System.out.println( find( arr, 2 ) );
	printArr( arr );

    }//end main

}//end class Mysterion
