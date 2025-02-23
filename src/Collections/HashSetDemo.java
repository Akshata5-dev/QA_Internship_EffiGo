package Collections;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Declaration
		HashSet myset=new HashSet();
		//Set myset=new HashSet();
		//HashSet <String>myset=new HashSet<String>();
		
		//Adding data into hashSet
		myset.add(100);
		myset.add(10.5);
		myset.add("welcome");
		myset.add('A');
		myset.add(true);
		myset.add(100);
		myset.add(null);
		myset.add(null);
		
		//Printing hasset
		System.out.println(myset); //[null, A, 100, 10.5, welcome, true]
		
		//size of hashset
		System.out.println("Size of hashset:"+myset.size());//6
		
		//Remove element from arraylist
		myset.remove(10.5);//10.5 is value(not index)
		System.out.println("After removing:"+myset);//[null, A, 100, welcome, true]
		
		//Inserting element - not possible
		//Access specific wlement - not possible
		
		//convert HashSet --->ArrayList
		ArrayList al=new ArrayList(myset);//[null, A, 100, welcome, true]
		System.out.println(al);
		System.out.println(al.get(2));//100
		
		//Read all the elements using for..each
		/*for(Object x:myset) { //forloop can't use index required
			System.out.println(x);
		}*/
		
		//Using iterator
		
		Iterator <Object> it=myset.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());    //multiple remove values not possible in set
		}
		
		//Clearing all the elements in hashset
		myset.clear();
		System.out.println(myset.isEmpty()); //true	
	}
}
