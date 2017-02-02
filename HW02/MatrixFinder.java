// Team CRy -- Ryan Siu and Caleb Smith-Salzberg
// APCS2 pd5
// HW02 -- I Am Still Searching
// 2017-02-02

/*
ALGORITHM

Assume target is the integer you're searching for:

1. Begin with the number at the top right of the array.
2. If the current number is equal to target, the search is finished.
3. If the current number is at the leftmost column OR at the bottommost row 
   and does not match, target is not in the array.
4. If the current number is greater than target, change the current number to 
   the number in the row below and go to step 2.
5. If the current number is less than target, change the current number to the 
   number to the left and go to step 2.
*/

public class MatrixFinder
{
    public static String find(int[][] array, int target){
	int col = array.length-1;   // start at leftmost col
	int row = 0;                // start at top row
	if (array[0].length == 0){    // to handle empty array
	    return "(-1,-1)";
	}
	int curr = array[row][col];   // set the curr val to the start location

	// while the curr does not match
	while (curr != target) {
	    
	    // this means the number does not exist in the array
	    if (col == 0 || (row == array.length-1 && curr < target)) { 
		return "(-1,-1)";
	    }
	    else if (curr < target) { //if curr is too large
		row++; // move down for a larger number
	    }
	    else { // if curr is too small
		col--; // move right for a smaller number
	    }

	    // change the value of curr
	    curr = array[row][col]; 
	    
	}

	// if the number has been found, return the location
	return "(" + row + "," + col + ")"; 
    }
    
    public static void main(String args[]){
	int[][] bey = {
	    { 1,  3,  5 },
	    { 3,  7,  8 },
	    { 5, 12, 15 },
	};
	int[][] test = {
	    {1, 5, 8, 10, 13},
	    {3, 7, 9, 11, 15},
	    {6, 12, 13, 16, 17},
	    {11, 13, 15, 19, 21},
	    {14, 17, 18, 22, 30}
	};
	int[][] cry = {{}};

	System.out.println(find(test,8));  //(0,2)
	System.out.println(find(test,30)); //(4,4)
	System.out.println(find(test,45)); //(-1,-1)
	System.out.println(find(bey,-4));  //(-1,-1)
	System.out.println(find(bey,5));   //(0,2)
	System.out.println(find(cry,1));   //(-1,-1)
	System.out.println(find(cry,0));   //(-1,-1)
    }
}
