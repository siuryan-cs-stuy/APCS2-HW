// Ryan Siu
// APCS2 pd5
// HW08 -- Luxembourg Beckons
// 2017-02-20


/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */

public class QueenBoard 
{
    //2D array to represent n*n chessboard
    private int[][] _board;

    //constructor allows for specifying size
    public QueenBoard( int size ) 
    {
	_board = new int[size][size];
    }


    /***
     * precondition: board is filled with 0's only.
     * postcondition: 
     * If a solution is found, board shows position of N queens, 
     * returns true.
     * If no solution, board is filled with 0's, 
     * returns false.
     * ALGORITHM:
     * 1. If you're past the last column, you have a solution. Return true.
     * 2. Otherwise, go through each row of a column. If you can add a queen on
     *    that column, do so and continue running that scenario for the next 
     *    column.
     * 3. If this branch yields a solution, return true.
     * 4. Otherwise, remove the queen you placed in this row and move on to 
     *    the next row.
     * 5. If you run out of rows without finding a solution, there are no 
     *    solutions. Return false.
     */
    public boolean solve()
    {
	boolean solved = solveH( 0 );
	printSolution();
	return solved;
    }

    /**
     *Helper method for solve. 
     */
    private boolean solveH( int col ) 
    {
        if (col >= _board.length) {
	    return true;
	}
	for (int i = 0; i < _board.length; i++) {
	    if (addQueen(i, col)) {
		if (solveH(col+1)) {
		    return true;
		}
		removeQueen(i,col);
	    }
	}

	return false;
	
    }


    //print a valid placement of n queens
    public void printSolution()
    {
	/** Print board, a la toString...
	    Except:
	    all negs and 0's replaced with underscore
	    all 1's replaced with 'Q'
	*/

	String board = this.toString();
	String retStr = "";
	for (int i = 0; i < board.length(); i++) {
	    if (board.substring(i,i+1).equals("0")) {
		retStr += "_";
	    } else if (board.substring(i,i+1).equals("1")) {
		retStr += "Q";
	    } else if (board.substring(i,i+1).equals("-")) {
	        retStr += "_";
		i++;
	    } else {
		retStr += board.substring(i,i+1);
	    }
	}

	System.out.println( retStr );
    }



    //================= YE OLDE SEPARATOR =================

    /***
     * Adds queen at coordinate (row, col) and marks invalid moves in columns
     * to the right
     * Negative values denote invalid move, 1 denotes Q, 0 denotes valid move
     * precondition: row and col are within the range of the board
     * postcondition: the board is edited to reflect the move, boolean is 
     * returned reflecting successfulness of the move
     */
    private boolean addQueen(int row, int col)
    {
	// Check to see if this is a legal move
	if(_board[row][col] != 0){
	    return false;
	}

	// Set the square on the board to be occupied by a Q
	_board[row][col] = 1;

	// For changing values offset number of squares away
	int offset = 1;

	// Continue running until after the last col has been run through
	while(col+offset < _board[row].length) {
	    // Mark square horizotonal to Q as invalid
	    _board[row][col+offset]--;

	    // Mark square diagonally up/down to Q as invalid
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]--;
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]--;
	    }
	    // Move on to next set of squares to mark as invalid
	    offset++;
	}
	return true;
    }


    /***
     * Removes queen at coordinate (row, col) and adds valid moves in columns 
     * to the right
     * Negative values denote invalid move, 1 denotes Q, 0 denotes valid move
     * precondition: row and col are within the range of the board
     * postcondition: the board is edited to reflect the move, boolean is 
     * returned reflecting successfulness of the move
     */
    private boolean removeQueen(int row, int col)
    {
	// Check to see if this is a legal move
	if ( _board[row][col] != 1 ) {
	    return false;
	}

	// Set the square on the board to be not occupied by a Q and valid move
	_board[row][col] = 0;
	
	int offset = 1;	   // For changing values offset number of squares away

	// Continue undoing invalid moves until after the last col has been run
	// through
	while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }


    /***
     * Creates a String representation of the chessboard
     * precondition: _board exists
     * postcondition: String representation is returned
     */
    public String toString() 
    {
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
	}
	return ans;
    }


    //main method for testing...
    public static void main( String[] args )
    {
	QueenBoard a = new QueenBoard(2);
	a.solve();

	QueenBoard b = new QueenBoard(5);

	/*
	b.addQueen(3,0);
	b.addQueen(0,1);
        System.out.println(b);
        b.printSolution();
	b.removeQueen(3,0);
        System.out.println(b);
        b.printSolution();
	*/
	
	b.solve();

	QueenBoard c = new QueenBoard(8);
	c.solve();

	QueenBoard d = new QueenBoard(10);
	d.solve();
	
    }//end main()
    
}//end class
