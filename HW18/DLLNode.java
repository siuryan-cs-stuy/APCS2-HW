// Ryan Siu
// APCS2 pd5
// HW18a -- On the DLL
// 2017-03-15

/*****************************************************
 * class DLLNode
 * Implements a node, for use in lists and other container classes.
 *****************************************************/

public class DLLNode 
{

    private String _cargo;    //cargo may only be of type String
    private DLLNode _nextNode; //pointer to next LLNode
    private DLLNode _prevNode; //pointer to prev LLNode

    // constructor -- initializes instance vars
    public DLLNode( String value, DLLNode next, DLLNode prev ) 
    {
	_cargo = value;
	_nextNode = next;
	_prevNode = prev;
	
    }


    //--------------v  ACCESSORS  v--------------
    public String getCargo() { return _cargo; }

    public DLLNode getNext() { return _nextNode; }

    public DLLNode getPrev() { return _prevNode; }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo( String newCargo ) 
    {
	String temp = _cargo;
	_cargo = newCargo;
	return temp;
    }

    public DLLNode setNext( DLLNode newNext ) 
    {
	DLLNode temp = _nextNode;
	_nextNode = newNext;
	return temp;
    }

    public DLLNode setPrev( DLLNode newPrev )
    {
	DLLNode temp = _prevNode;
	_prevNode = newPrev;
	return temp;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString() { return _cargo.toString(); }

}//end class DLLNode
