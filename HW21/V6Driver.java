/*****************************************************
 * class V6Driver
 * ...for testing implementation of Iterable interface
 *    (ability to run a FOREACH loop over your LList)
 * Assumes local version of List.java, overriding Java built-in interface
 *****************************************************/

import java.util.Iterator;

public class V6Driver {

    public static void main( String[] args ) {

	List<String> wu = new LList<String>();

	System.out.println(wu);
	wu.add("RZA");
	wu.add("GZA");
	wu.add("ODB");
	wu.add("Inspectah Deck");
	wu.add("Raekwon the Chef");
	wu.add("U-God");
	wu.add("Ghostface");
	wu.add("Method Man");
	System.out.println(wu);

	for( String s : wu ) {
	    System.out.println( s + " raps for the Wu");
	}

	System.out.println(wu);
	Iterator<String> it = wu.iterator();
	while (it.hasNext()) {
	    String test = it.next();
	    if (test.equals("Method Man")) {
		it.remove();
	    }
	    System.out.println(wu);
	}
    }

}//end class
