// Ryan Siu
// APCS2 pd5
// HW23 -- Stack: What Is It Good For?
// 2017-03-23

/*****************************************************
 * class LatKtS (LatKeysToSuccess)
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 * SKELETON
 *****************************************************/

public class LatKtS 
{

    /**********************************************************
     * precondition:  input string has length > 0
     * postcondition: returns reversed string s
     *                flip("desserts") -> "stressed"
     **********************************************************/
    public static String flip( String s ) 
    { 
	String retStr = "";
	Latkes l = new Latkes(s.length());
	for (int i = 0; i < s.length(); i++) {
	    l.push( s.substring(i,i+1) );
	}
	for (int i = 0; i < s.length(); i++) {
	    retStr += l.pop();
	}
	return retStr;

    }//end flip()


    /**********************************************************
     * precondition:  s contains only the characters {,},(,),[,]
     * postcondition: allMatched( "({}[()])" )    -> true
     *                allMatched( "([)]" )        -> false
     *                allMatched( "" )            -> true
     **********************************************************/
    public static boolean allMatched( String s ) 
    {
	Latkes l = new Latkes(s.length());
	
	for (int i = 0; i < s.length(); i++) {
	    String ch = s.substring(i,i+1);
	    if ( isOpen(ch) ) {
		l.push(ch);
	    } else {
		if ( l.isEmpty() ) {
		    return false;
		}
		String openCh = l.peek();
		if ( isMatching( openCh, ch ) ) {
		    l.pop();
		} else {
		    return false;
		}
	    }
	}

	return l.isEmpty();
	
    }//end allMatched()

    //helper method for allMatched(), returns whether string is an open parens
    private static boolean isOpen( String ch ) {
	return ch.equals("(") || ch.equals("[") || ch.equals("{");
    }

    //helper method for allMatched(), returns whether parens correspond
    private static boolean isMatching( String openCh, String closeCh ) {
	return ( openCh.equals("(") && closeCh.equals(")") ) ||
	    ( openCh.equals("{") && closeCh.equals("}") ) ||
	    ( openCh.equals("[") && closeCh.equals("]") );
    }

    //main method to test
    public static void main( String[] args ) { 

	System.out.println(flip("stressed"));
	
        System.out.println(allMatched( "({}[()])" )); //true
        System.out.println(allMatched( "([)]" ) ); //false
        System.out.println(allMatched( "(){([])}" ) ); //true
        System.out.println(allMatched( "](){([])}" ) ); //false
        System.out.println(allMatched( "(){([])}(" ) ); //false
        System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
    }

}//end class LatKtS
