// Ryan Siu
// APCS2 pd5
// HW35 -- BSTs is the Perfect Place for Shade t
// 2017-05-04

/*****************************************************
 * class BST
 * <<< skeleton >>>
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT) 
 * A BST maintains the invariant that, for any node N with value V, 
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value, 
 *  and any value in its right subtree must be greater.)
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/

public class BST 
{
    private TreeNode _root; 

    /*****************************************************
     * default constructor
     *****************************************************/
    BST( ) 
    {
	_root = null;
    }


    /*****************************************************
     * void insert( int ) 
     * Adds a new data element to the tree at appropriate location.
     *****************************************************/
    public void insert( int newVal ) 
    {
	_root = insert( newVal, _root );
    }

    public TreeNode insert( int newVal, TreeNode root ) {
	if ( root == null ) {
	    root = new TreeNode( newVal );
	    return root;
	} else if ( newVal < root.getValue() ) {
	    root.setLeft( insert( newVal, root.getLeft() ) );
	} else {
	    root.setRight( insert( newVal, root.getRight() ) );
	}
	return root;
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

    // each traversal should simply print to standard out 
    // the nodes visited, in order

    public void preOrderTrav() 
    {
	preOrderTrav( _root );
    }

    public void preOrderTrav( TreeNode root )
    {
	if (root != null) {
	    System.out.println( root.getValue() );
	    preOrderTrav( root.getLeft() );
	    preOrderTrav( root.getRight() );
	}
    }

    public void inOrderTrav() 
    {
        inOrderTrav( _root );
    }

    public void inOrderTrav( TreeNode root )
    {
	if (root != null) {
	    inOrderTrav( root.getLeft() );
	    System.out.println( root.getValue() );
	    inOrderTrav( root.getRight() );
	}
    }

    public void postOrderTrav() 
    {
        postOrderTrav( _root );
    }

    public void postOrderTrav( TreeNode root )
    {
	if (root != null) {
	    postOrderTrav( root.getLeft() );
	    postOrderTrav( root.getRight() );
	    System.out.println( root.getValue() );
	}
    }
    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    TreeNode search( int target )
    {
	return search( target, _root );
    }

    TreeNode search( int target, TreeNode root )
    {
	if (target == root.getValue()) {
	    return root;
	} else if (target < root.getValue()) {
	    return search( target, root.getLeft() );
	} else {
	    return search( target, root.getRight() );
	}
    }


    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 1
     *****************************************************/
    public int height()
    {
        return height( _root );
    }

    public int height( TreeNode root )
    {
	if ( root == null ) {
	    return 0;
	} else {
	    if ( height( root.getLeft() ) > height( root.getRight() ) ) {
		return height( root.getLeft() ) + 1;
	    } else {
		return height( root.getRight() ) + 1;
	    }
	}
    }


    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves()
    {
	return numLeaves( _root );
    }

    public int numLeaves( TreeNode root )
    {
	if ( root == null ) {
	    return 0;
	} else if ( root.getLeft() == null && root.getRight() == null ) {
	    return 1;
	} else {
	    return numLeaves( root.getLeft() ) + numLeaves( root.getRight() );
	}
    }


    //main method for testing
    public static void main( String[] args ) 
    {
	
	BST arbol = new BST();

	arbol.insert( 4 );
	arbol.insert( 2 );
	arbol.insert( 5 );
	arbol.insert( 6 );
	arbol.insert( 1 );
	arbol.insert( 3 );
	

	System.out.println( "\npre-order traversal:" );
	arbol.preOrderTrav();
	//expected:
	//421356

	System.out.println( "\nin-order traversal:" );
	arbol.inOrderTrav();
	//expected:
	//123456
 
	System.out.println( "\npost-order traversal:" );
	arbol.postOrderTrav();	
	//expected:
	//132654

	System.out.println( "\nSearching for 5" );
	TreeNode t = arbol.search(5);
	System.out.println( t.getValue() );

	System.out.println( "\nHeight of tree" );
	System.out.println( arbol.height() ); //3

	System.out.println( "\nNumber of leaves on tree" );
	System.out.println( arbol.numLeaves() ); //3
    }

}//end class
