// Ryan Siu
// APCS2 pd5
// HW39 -- Heaping Piles of Sordidness
// 2017-05-10

/*****************************************************
 * class HeapSort
 * Uses heapification to sort an array of ints
 *****************************************************/

public class HeapSort {

    public void sort( int[] data ) {
	heapify( data );
	for (int i = data.length-1; i > 0; i--) {
	    swap( data, 0, i );
	    walkDown( data, 0, i );
	}
	if (data[0] > data[1]) {
	    swap( data, 0, 1 );
	}
    }

    private void heapify( int[] data ) {
	int startPos = (data.length-1-1)/2;
	for (int i = startPos; i >= 0; i--) {
	    walkDown( data, i, data.length-1 );
	}
    }

    private void walkDown( int[] data, int pos, int end ) {
	while( pos < end ) {

	    //choose child w/ min value, or check for child
	    int maxPos = maxChildPos(data, pos);

	    //if no children, then i've walked far enough
	    if ( maxPos == -1 || maxPos >= end ) 
		break;
	    //if i am more than my greatest child, then i've walked far enough
	    else if ( data[pos] >= data[maxPos] ) 
		break;
	    //if i am < least child, swap with that child
	    else {
		swap( data, pos, maxPos );
		pos = maxPos;
	    }
	}
    }

    private int maxChildPos( int[] data, int pos ) 
    {
	int retVal;
	int lc = 2*pos + 1; //index of left child
	int rc = 2*pos + 2; //index of right child

	//pos is not in the heap or pos is a leaf position
	if ( pos < 0 || pos >= data.length || lc >= data.length )
	    retVal = -1;
	//if no right child, then left child is only option for min
	else if ( rc >= data.length )
	    retVal = lc;
	//have 2 children, so compare to find least 
	else if ( data[lc] < data[rc] )
	    retVal = rc;
	else
	    retVal = lc;
	return retVal;
    }//O(1)
    

    private void swap( int[] data, int pos1, int pos2 ) {
	int temp = data[pos1];
	data[pos1] = data[pos2];
	data[pos2] = temp;	
    }

    public static void main( String[] args ) {
	HeapSort h = new HeapSort();
	int[] arr = {2,9,3,6,7,1,4,8,0,5};
	h.sort(arr);
	for (int i : arr) {
	    System.out.println(i);
	}
    }
    
}
