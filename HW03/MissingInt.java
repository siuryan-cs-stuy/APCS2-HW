// Team TraverseTheReverse -- Ryan Siu and Eric Zhang
// APCS2 pd5
// HW03
// 2017-02-03

/* ALGORITHM
    Let x be the missing int and y be the duplicate int.

    Let arrSum = origSum - x + y
    Let d = arrSum - origSum = y - x

    Let arrProduct = origProduct/x * y
    Let q = arrProduct / origProduct = y / x
     y = qx

    Plugging back into the first equation with the second equation,
     qx - x = d
     x * (q - 1) = d
     x = d / (q - 1)

*/

public class MissingInt {

    public static void main(String[] args) {
	int[] test = {1,1};
	int[] a = {1,3,3,4};
	int[] b = {2,5,3,5,6,1};
	int[] c = {1,2,3,4,5,6,7,8,9,10,10,12,13,14,15};
	
	System.out.println( findMissing(test) );  // 2
	System.out.println( findMissing(a) );     // 2
	System.out.println( findMissing(b) );     // 4
	System.out.println( findMissing(c) );     // 11
    }

    
    // Returns the missing int
    // Runtime: O(n) with the constraint of O(1) expanded space
    public static int findMissing(int[] arr) {
	int arrSum = sum(arr);
	int origSum = sum(arr.length);
	int d = arrSum - origSum;
	long arrProduct = product(arr);
	long origProduct = product(arr.length);
	double q = (double) arrProduct / origProduct;
	return (int)Math.round( d / (q - 1) );
    }

    // Returns sum of all the ints in an int array
    // Runtime: O(n)
    public static int sum(int[] arr) {
	int sum = 0;
	for (int i : arr) {
	    sum += i;
	}
	return sum;
    }
    
    // Returns the sum of all ints between 1 and n, inclusive
    // Runtime: O(n)
    public static int sum(int n) {
	int sum = 0;
	for (int i = 1; i <= n; i++) {
	    sum += i;
	}
	return sum;
    }

    // Returns product of all the ints in an int array
    // Runtime: O(n)
    public static long product(int[] arr) {
	long prod = 1;
	for (int i : arr) {
	    prod *= i;
	}
	return prod;
    }
    
    // Returns the product of all ints between 1 and n, inclusive
    // Runtime: O(n)
    public static long product(int n) {
	long prod = 1;
	for (int i = 1; i <= n; i++) {
	    prod *= i;
	}
	return prod;
    }
    
}
