// Ryan Siu
// APCS2 pd5
// HW26 -- The English Do Not Wait In Line
// 2017-03-29

/*****************************************************
 * class LLQueue
 * uses a singly-linked nodes to implement a QUEUE
 * (a collection with FIFO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 ******************************************************/

import java.util.NoSuchElementException;
//import java.lang.RuntimeException;

public class LLQueue<T> implements Queue<T> 
{
    private LLNode<T> _front, _end;

    // default constructor creates an empty queue
    public LLQueue()
    { 
	_front = null;
	_end = null;
    }

    // means of adding a thing to the collection
    public void enqueue( T enQVal ) 
    {
	LLNode<T> addNode = new LLNode<T>( enQVal, _end );
	_end = addNode;
	if (_front == null) {
	    _front = addNode;
	}
    }//O(1)


    // means of removing a thing from the collection
    // remove and return thing at front of queue
    // handles _queue ! empty by throwing an exception
    public T dequeue() 
    {
	if ( isEmpty() ) {
	    throw new NoSuchElementException( "Queue is empty, nodes cannot be removed" );
	}
	
	LLNode<T> temp = _end;

	// if only one element
	if (temp == _front) {
	    T retVal = _end.getValue();
	    _end = null;
	    _front = null;
	    return retVal;
	}

	// if more than one element
	while (temp.getNext() != _front) {
	    temp = temp.getNext();
	}

	T retVal = temp.getNext().getValue();
	_front = temp;
	temp.setNext(null);
	
	return retVal;
    }//O(n) for most cases, b/c you need to get the node that points to front by iterating


    // means of peeking at thing next in line for removal
    public T peekFront() 
    {
	return _front.getValue();
    }//O(1)


    public boolean isEmpty() 
    {
	return _front == null && _end == null;
    }//O(1)


    // print each node, separated by spaces
    public String toString() 
    {
	LLNode<T> temp = _end;
	String retStr = "";

	while (temp != null) {
	    retStr = temp.getValue() + " " + retStr;
	    temp = temp.getNext();
	}
	return retStr;
    }//O(n), iterate through each node once



    public static void main( String[] args ) {

	
	  Queue<String> LLQueuelJ = new LLQueue<String>();

	  System.out.println("\nnow enqueuing thrice..."); 
	  LLQueuelJ.enqueue("James");
	  LLQueuelJ.enqueue("Todd");
	  LLQueuelJ.enqueue("Smith");

	  System.out.println("\nnow testing toString()..."); 
	  System.out.println( LLQueuelJ ); //for testing toString()...
	  
	  System.out.println("\nnow dequeuing thrice..."); 
	  System.out.println( LLQueuelJ.dequeue() );
	  System.out.println( LLQueuelJ.dequeue() );
	  System.out.println( LLQueuelJ.dequeue() );

	  
	  System.out.println("\nDequeuing from empty queue should yield error..."); 
	  System.out.println( LLQueuelJ.dequeue() );

    }//end main

}//end class LLQueue
