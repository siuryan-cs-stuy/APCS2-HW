// Team Metonymy -- Ryan Siu, Tiffany Moi, Mohamed Tamara
// APCS2 pd5
// HW29 -- Stress is the Best
// 2017-04-04

/*****************************************************
 * class DequeTester
 * used for testing methods
 ******************************************************/

import java.util.NoSuchElementException;
import java.util.ArrayList;

public class DequeTester {
    
    public static void main( String[] args ) {

	// Test using deque of Strings
	System.out.println( "\nTesting deque of Strings" );
	DLLDeque<String> stringDeque = new DLLDeque<String>(); //error if generic typing is not allowed
	System.out.println( stringDeque );
	System.out.println( "\nAdding elements..." );
	// a, b, c should be added to the deque
	stringDeque.addLast( "b" );
	stringDeque.addFirst( "a" );
	stringDeque.addLast( "c" );
	System.out.println( stringDeque ); // a b c
	System.out.println( "\nRemoving elements..." );
	// a and c should be removed from the deque
	stringDeque.removeFirst();
	stringDeque.removeLast();
	System.out.println( stringDeque ); // b
	System.out.println( "\nRemoving remaining element..." );
	// b should be removed from the deque
	stringDeque.removeFirst();
	System.out.println( stringDeque ); // empty deque

	System.out.println( "\nRemvoing element..." );
	// should print exception if exceptions are handled
	try {
	    stringDeque.removeFirst(); // error
	} catch (NoSuchElementException e) {
	    e.printStackTrace(); //prints error message
	}
	System.out.println( "\nGetting first element..." );
	// should print exception if exceptions are handled
	try {
	    stringDeque.getFirst(); //error
	} catch (NoSuchElementException e) {
	    e.printStackTrace(); //prints error message
	}

	System.out.println( "\nAdding element..." );
	// a should be added to the deque
	stringDeque.addFirst( "a" );
	System.out.println( "\nGetting first element..." );
	// a should be printed
	System.out.println( stringDeque.getFirst() + "\n" ); // a


	// Test using deque of Objects
	System.out.println( "\nTesting deque of Objects" );
	DLLDeque mixDeque = new DLLDeque();
	System.out.println( "\nAdding elements..." );
	// elements should be added to the deque
	mixDeque.addFirst( 1 );
	mixDeque.addLast( "a" );
	mixDeque.addFirst( new ArrayList<Integer>() );
	// elements should be properly printed in order
	System.out.println( mixDeque );
	System.out.println( "\nAdding 64 to the ArrayList at front" );
	// first element should be removed
	ArrayList a = (ArrayList)mixDeque.removeFirst(); //pop the ArrayList
	a.add( 64 ); //add element 64
	// ArrayList containing 64 should be added to the deque
	mixDeque.addFirst( a );
	System.out.println( mixDeque ); // [64] 1 a
	
    }
    
}
