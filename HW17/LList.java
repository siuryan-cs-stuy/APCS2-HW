// Ryan Siu
// APCS2 pd5
// HW17: Give and Take
// 2017-03-13

/*****************************************************
 * class LList
 * skeleton
 * Implements a linked list of LLNodes.
 *****************************************************/

public class LList implements List 
{ //your homemade List.java must be in same dir

    //instance vars
    private LLNode _head;
    private int _size;

    // constructor -- initializes instance vars
    public LList( ) 
    {
	_size = 0;
	_head = null;
    }


    //--------------v  List interface methods  v--------------

    public boolean add( String x ) {
	if (this.size() == 0) {
	    _head = new LLNode( x, null );
	    _size++;
	    return true;
	}
	
	LLNode currentNode = _head;
	for (int i = 0; i < this.size()-1; i++) {
	    currentNode = currentNode.getNext();
	}
	currentNode.setNext( new LLNode( x, null ) );
	_size++;
	return true;
    }

    public void add( int index, String newVal ) {
	LLNode newNode = new LLNode( newVal, null );
	if (index == 0) {
	    newNode.setNext(_head);
	    _head = newNode;
	} else {
	    LLNode currentNode = _head;
	    for (int i = 0; i < index-1; i++) {
		currentNode = currentNode.getNext();
	    }
	    LLNode addNode = currentNode.getNext();
	    currentNode.setNext( newNode );
	    newNode.setNext( addNode );
	}
    }

    public String remove( int index ) {
	if (index == 0) {
	    String temp = _head.getCargo();
	    _head = _head.getNext();
	    return temp;
	} else {
	    LLNode currentNode = _head;
	    for (int i = 0; i < index-1; i++) {
		currentNode = currentNode.getNext();
	    }
	    LLNode removeNode = currentNode.getNext();
	    currentNode.setNext( removeNode.getNext() );
	
	    return removeNode.getCargo();
	}
    }

    public String get( int i ) {
	LLNode currentNode = _head;
	for (int j = 0; j < i; j++) {
	    currentNode = currentNode.getNext();
	}
	return currentNode.getCargo();
    }

    public String set( int i, String x ) {
	String temp = get(i);
	
        LLNode currentNode = _head;
	for (int j = 0; j < i; j++) {
	    currentNode = currentNode.getNext();
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
	LLNode tmp = _head; //init tr
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
	
	LList james = new LList();

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



