// Team Queue the Lights -- Ryan Siu and Andrew Qu
// APCS2 pd5
// HW28 -- Now Let's Consider You Lot at Fake Terry's
// 2017-03-30

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite data flow for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 * maintains these invariants: 
 * dequeuing removes/returns a random element
 * _front always points to next item to be removed
 ******************************************************/


public class RQueue<T> implements Queue<T> 
{
    private LLNode<T> _front, _end;
    private int _size;


    // default constructor creates an empty queue
    public RQueue() 
    { 
	_front = null;
	_end = null;
	_size = 0;
    }


    public void enqueue( T enQVal ) 
    {
	LLNode<T> newNode = new LLNode<T>( enQVal, null );
	if (_size == 0) {
	    _front = newNode;
	} else {
	    _end.setNext( newNode );
	}
	_end = newNode;
	_size++;
    }


    // remove and return thing at front of queue, then reorder elements
    // assume _queue ! empty
    public T dequeue() 
    {
	T foo = _front.getValue();
	_front = _front.getNext();
	_size--;
	
	if (_size > 0) {
	    sample();
	}
	return foo;
    }


    //return next item to be dequeued
    public T peekFront() 
    {
	return _front.getValue();
    }


    /******************************************
     * void sample() -- a means of "shuffling" the queue
     * algo:
     * Repeatedly "move" the front node to the end a random number of times.
     * "Moving" is enqueuing the front node, then changing the front to the 
     *   next node (the node that points to the now-front node will be cleaned
     *   up by the Java garbage collector because there are no longer any
     *   pointers to it.
     * Runtime: O(n) amortized, because it's performing O(1) operations an
     *   average of n/2 times.
     ******************************************/
    public void sample() 
    {
	int shift = (int)(Math.random() * _size);
	for (int i = 0; i < shift; i++) {
	    enqueue( _front.getValue() );
	    _size--; //to balance out the _size++ from enqueue
	    _front = _front.getNext();
	}
    }


    public boolean isEmpty() 
    { 
	return false;
    }//O(1)


    // print each node, separated by spaces
    public String toString() 
    { 
	String retStr = "";
	LLNode<T> foo = _front;
	
        while (foo != null) {
	    retStr += foo.getValue() + " ";
	    foo = foo.getNext();
	}
	
	return retStr;
    }//O(n)



    //main method for testing
    public static void main( String[] args ) 
    {

	  Queue<String> PirateQueue = new RQueue<String>();

	  System.out.println("\nnow enqueuing..."); 
	  PirateQueue.enqueue("Dread");
	  PirateQueue.enqueue("Pirate");
	  PirateQueue.enqueue("Robert");
	  PirateQueue.enqueue("Blackbeard");
	  PirateQueue.enqueue("Peter");
	  PirateQueue.enqueue("Stuyvesant");
	  
	  System.out.println("\nnow testing toString()..."); 
	  System.out.println( PirateQueue ); //for testing toString()...

	  System.out.println("\nnow dequeuing..."); 
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );

	  System.out.println("\nnow dequeuing fr empty queue..."); 
	  System.out.println( PirateQueue.dequeue() );
	  
    }//end main

}//end class RQueue
