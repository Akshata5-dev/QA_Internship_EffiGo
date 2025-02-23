package Collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//declaration
		//HashMap hm=new HashMap();
		HashMap<Integer,String> hm=new HashMap<Integer,String>();
		
		//Adding pairs
		hm.put(101, "John");
		hm.put(102, "Scott");
		hm.put(103, "Mary");
		hm.put(103,"Scott");
		hm.put(102,"David");
		System.out.println(hm);//{101=John, 102=David, 103=Scott}
		
		//size of hash map
		System.out.println("Size of hashmap:"+hm.size());//3
		
		//remove pair
		hm.remove(103);
		System.out.println("After removing pair:"+hm);
		
		//access value of key
		System.out.println(hm.get(102));
		
		//get all keys from hashmap
		System.out.println(hm.keySet());
		
		//get all values from hashmap
		System.out.println(hm.values());
		//key with values
		System.out.println(hm.entrySet());	
		
		//Reading data from hashmap
		//using for..each
		
		for(int k:hm.keySet()) {
			System.out.println(k+" "+hm.get(k));
		}
		
		//using Iterator
		Iterator<Entry<Integer,String>> it=hm.entrySet().iterator();
		while(it.hasNext()){
			Entry<Integer,String> entry=it.next();
			System.out.println(entry.getKey()+"  "+entry.getValue());
		}		
		hm.clear();
		System.out.println(hm.isEmpty());		
		}
}
