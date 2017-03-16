// Ryan Siu
// APCS2 pd5
// HW19 -- Generically Speaking
// 2017-03-16

/*****************************************************
 * class LList
 * skeleton
 * Implements a linked list of DLLNodes.
 *****************************************************/

public class LList<T> implements List<T> 
{ //your homemade List.java must be in same dir

    //instance vars
    private DLLNode<T> _head;
    private DLLNode<T> _tail;
    private int _size;

    // constructor -- initializes instance vars
    public LList( ) 
    {
	_size = 0;
	_head = null;
	_tail = null;
    }


    //--------------v  List interface methods  v--------------

    public boolean add( T x ) {
	if (this.size() == 0) {
	    _head = new DLLNode<T>( x, null, null );
	    _tail = _head;
	    _size++;
	    return true;
	}

        _tail.setNext( new DLLNode<T>( x, null, _tail) );
	_tail = _tail.getNext();
	_size++;
	return true;
    }

    public void add( int index, T newVal ) {
	DLLNode<T> newNode = new DLLNode<T>( newVal, null, null );
	if (index == 0) {
	    newNode.setNext( _head );
	    _head.setPrev( newNode );
	    _head = newNode;
	} else if (index == this.size()) {
	    newNode.setPrev( _tail );
	    _tail.setNext( newNode );
	    _tail = newNode;
	} else {
	    DLLNode<T> currentNode;
	    if (index > this.size() / 2) {
		currentNode = _head;
		for (int i = 0; i < index-1; i++) {
		    currentNode = currentNode.getNext();
		}
	    } else {
		currentNode = _tail;
		for (int i = this.size()-1; i > index-1; i--) {
		    currentNode = currentNode.getPrev();
		}
	    }
	    DLLNode<T> addNode = currentNode.getNext();
	    currentNode.setNext( newNode );
	    addNode.setPrev( newNode );
	    newNode.setNext( addNode );
	    newNode.setPrev( currentNode );
	}
	_size++;
    }

    public T remove( int index ) {
	if (index == 0) {
	    T temp = _head.getCargo();
	    _head = _head.getNext();
	    _head.setPrev( null );
	    _size--;
	    return temp;
	} else if (index == this.size()-1) {
	    T temp = _tail.getCargo();
	    _tail = _tail.getPrev();
	    _tail.setNext( null );
	    _size--;
	    return temp;
	} else {
	    DLLNode<T> currentNode;
	    if (index > this.size() / 2) {
		currentNode = _head;
		for (int i = 0; i < index-1; i++) {
		    currentNode = currentNode.getNext();
		}
	    } else {
		currentNode = _tail;
		for (int i = this.size()-1; i > index-1; i--) {
		    currentNode = currentNode.getPrev();
		}
	    }
	    DLLNode<T> removeNode = currentNode.getNext();
	    currentNode.setNext( removeNode.getNext() );
	    currentNode.getNext().setPrev( currentNode );

	    _size--;
	    return removeNode.getCargo();
	}
    }

    public T get( int i ) {
	DLLNode<T> currentNode = _head;
	for (int j = 0; j < i; j++) {
	    currentNode = currentNode.getNext();
	}
	return currentNode.getCargo();
    }

    public T set( int i, T x ) {
	T temp = get(i);
	
        DLLNode<T> currentNode;
        if (i > this.size() / 2) {
		currentNode = _head;
		for (int j = 0; j < i-1; j++) {
		    currentNode = currentNode.getNext();
		}
	    } else {
		currentNode = _tail;
		for (int j = this.size()-1; j > i-1; j--) {
		    currentNode = currentNode.getPrev();
		}
	    }
	
	currentNode.setCargo(x);
	return temp;
    }

    //return number of nodes in list
    public int size() { return _size; } 

    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString() { 
	String retStr = "HEAD->";
	DLLNode<T> tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args ) 
    {
	
	LList<String> james = new LList<String>();

	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("beat");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("a");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("need");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("I");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	System.out.println( "2nd item is: " + james.get(1) );
	
	james.set( 1, "got" );
	System.out.println( "...and now 2nd item is: " + james.set(1,"got") );
	System.out.println( james );

	System.out.println( "Removing 2nd item..." );
	james.remove(1);
       	System.out.println( james );

	System.out.println( "Adding 'hi' to index 3..." );
	james.add( 3, "hi" );
       	System.out.println( james );

    }

}//end class LList



