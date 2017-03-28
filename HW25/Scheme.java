// Ryan Siu
// APCS2 pd5
// HW25 -- What a Racket
// 2017-03-27

/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 * 1. Iterate through expr and put each meaningful character into a expr stack
 * 2. Pop elements into another stack until an open parens is reached
 * 3. Evaluate the expression until a closed parens is reached
 * 4. Pop remaining elements back into the expr stack 
 * 5. If there is only one element left, you're done. Otherwise, go back to 2.
 *
 * STACK OF CHOICE: Latkes by library
 * b/c Latkes uses the simplest underlying data container (an array), and
 * although generic typing is not supported with arrays (and therefore Latkes),
 * generic typing isn't necessary here because we're only dealing with Strings
 ******************************************************/

public class Scheme 
{

    /****************************************************** 
     * precond:  Assumes expr is a valid Scheme (prefix) expression,
     *           with whitespace separating all operators, parens, and 
     *           integer operands.
     * postcond: Returns simplified value of expression, as a String
     * eg,
     *           evaluate( "( + 4 3 )" ) -> 7
     *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
     ******************************************************/
    public static String evaluate( String expr ) 
    {
	String[] temp = expr.split("\\s+");
	Latkes expArr = new Latkes(temp.length);

	for (String s : temp) {
	    expArr.push(s);
	}

	Latkes evalArr = new Latkes(temp.length);
        while (!expArr.isEmpty()) {
	    if (!expArr.peek().equals("(")) {
		evalArr.push( expArr.pop() );
	    } else {
		expArr.pop();
		if (expArr.isEmpty()) {
		    return unload( getOp(evalArr), evalArr );
		}
		expArr.push( unload( getOp( evalArr ), evalArr ) );
		evalArr.pop(); // get rid of close parens
		while (!evalArr.isEmpty()) {
		    expArr.push( evalArr.pop() );
		}
	    }
	}

	return expArr.pop();
    }

    private static int getOp( Latkes stack ) {
	if (stack.peek().equals("+")) {
	    stack.pop();
	    return 1;
	} else if (stack.peek().equals("-")) {
	    stack.pop();
	    return 2;
	} else {
	    stack.pop();
	    return 3;
	}
    }


    /****************************************************** 
     * precond:  Assumes top of input stack is a number.
     * postcond: Performs op on nums until closing paren
     *           is seen thru peek().
     *           Returns result of applying operator to
     *           sequence of operands.
     *           Ops: + is 1, - is 2, * is 3
     ******************************************************/
    public static String unload( int op, Latkes numbers ) 
    {
	if (op == 1) {
	    int sum = 0;
	    while ( !numbers.peek().equals(")") ) {
	        sum += Integer.parseInt( numbers.pop() );
	    }
	    return String.valueOf( sum );
	} else if (op == 2) {
	    int diff = Integer.parseInt( numbers.pop() );
	    while ( !numbers.peek().equals(")") ) {
	        diff -= Integer.parseInt( numbers.pop() );
	    }
	    return String.valueOf( diff );
	} else {
	    int prod = 1;
	    while ( !numbers.peek().equals(")") ) {
	        prod *= Integer.parseInt( numbers.pop() );
	    }
	    return String.valueOf( prod );
	}
    }


    /*
    //optional check-to-see-if-its-a-number helper fxn:
    public static boolean isNumber( String s ) {
        try {
	    Integer.parseInt(s);
	    return true;
	}
        catch( NumberFormatException e ) {
	    return false;
	}
    }
    */


    //main method for testing
    public static void main( String[] args ) 
    {
	
	String zoo1 = "( + 4 3 )";
	System.out.println(zoo1);
	System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
	//...7

	String zoo2 = "( + 4 ( * 2 5 ) 3 )";
	System.out.println(zoo2);
	System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
	//...17

	String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
	System.out.println(zoo3);
	System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
	//...29

	String zoo4 = "( - 1 2 3 )";
	System.out.println(zoo4);
	System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
	//...-4

    }//main

}//end class Scheme
