// Ryan Siu
// APCS2 pd5
// HW22 -- Stacks on Stacks on Stacks on Stacks...
// 2017-03-22

/***
 * class Latkes
 * SKELETON
 * (actually: a class to implement a stack of Strings)
 * uses an array as underlying data structure
 ***/

public class Latkes 
{

    private String [] _stack;
    private int _stackSize;

    //constructor
    public Latkes(int size) 
    { 
	_stack = new String[size];
	_stackSize = 0;
    }

    //means of insertion
    public void push( String s ) 
    {
        _stack[_stackSize] = s;
	_stackSize++;
    }

    //means of removal
    public String pop( ) 
    {
        String temp = _stack[_stackSize-1];
	_stack[_stackSize-1] = null;
	_stackSize--;
	return temp;
    }

    //chk for emptiness
    public boolean isEmpty() 
    { 
	return _stackSize == 0;
    }

    //chk for fullness
    public boolean isFull() 
    {
        return _stack[_stackSize-1] != null;
    }

}//end class Latkes

