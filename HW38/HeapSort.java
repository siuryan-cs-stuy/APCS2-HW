// Ryan Siu
// APCS2 pd5
// HW38 -- Sort of Like Magic
// 2017-05-10

/*****************************************************
 * class HeapSort
 * Uses ALHeap to sort an ArrayList
 *****************************************************/

import java.util.ArrayList;

public class HeapSort {

    public ArrayList<Integer> sort( ArrayList<Integer> data ) {
	ALHeap heap = new ALHeap();
	for (int i : data) {
	    heap.add(i);
	}
	ArrayList<Integer> retArr = new ArrayList<Integer>();
        while (!heap.isEmpty()) {
	    retArr.add( heap.removeMin() );
	}
	return retArr;
    }

    public static void main( String[] args ) {
	HeapSort h = new HeapSort();
	ArrayList<Integer> dataset = new ArrayList<Integer>();
        dataset.add(6);
	dataset.add(4);
	dataset.add(9);
	dataset.add(0);
	dataset.add(3);
	dataset.add(2);
	dataset.add(5);
	dataset.add(1);
	dataset.add(7);
	dataset.add(8);
	System.out.println( dataset );          // 6490325178
	System.out.println( h.sort(dataset) );  // 0123456789
    }
    
}
