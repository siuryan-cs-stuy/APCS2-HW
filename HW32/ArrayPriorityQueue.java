//Team Far Corner: Tiffany Moi, Ryan Siu, Mohamed Tamara
//APCS2 pd5
//HW32 -- Getting Past the Velvet Rope
//2017-04-20

import java.util.ArrayList;
import java.lang.RuntimeException;

public class ArrayPriorityQueue{
    
    private ArrayList<Integer> _data;
    
    public ArrayPriorityQueue(){
	_data = new ArrayList<Integer>();
    }
    
    public void add(Integer x){
	_data.add(x);
    }//O(1)
    
    public boolean isEmpty(){
	return _data.size() == 0;
    }//O(1)
    
    public Integer peekMin(){
	if (isEmpty()){
	    throw new RuntimeException();
	}
	Integer x = _data.get(0);
	for (int i = 1; i < _data.size(); i ++){
	    if (_data.get(i).compareTo(x) < 0){
		x = _data.get(i);
	    }
	}
	return x;
    }//O(n)
    
    public Integer removeMin(){
	if (isEmpty()){
	    throw new RuntimeException();
	}
	Integer x = _data.get(0);
	int index = 0;
	for (int i = 1; i < _data.size(); i ++){
	    if (_data.get(i).compareTo(x) < 0){
		x = _data.get(i);
		index = i;
	    }
	}
	_data.remove(index);
	return x;
    }//O(n)
    
    public String toString(){
	return _data.toString();
    }
    
    public static void main(String[] args){
	ArrayPriorityQueue bob = new ArrayPriorityQueue();
	bob.add(9);
	bob.add(18);
	bob.add(7);
	bob.add(1);
	System.out.println(bob);
	System.out.println(bob.peekMin());//1
	System.out.println(bob.removeMin());
	System.out.println(bob);
	System.out.println(bob.peekMin());//7
	System.out.println(bob.removeMin());
	System.out.println(bob);
	System.out.println(bob.peekMin());//9
	System.out.println(bob.removeMin());
	System.out.println(bob);
	System.out.println(bob.peekMin());//18
	System.out.println(bob.removeMin());
	System.out.println(bob);
	System.out.println(bob.peekMin()); //should throw exception
    }

}
