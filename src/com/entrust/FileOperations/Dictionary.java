package com.entrust.FileOperations;

import java.time.*;
import java.util.*;
import java.util.Map.Entry;
public class Dictionary {
	static TreeMap<Person,String> treeMap = new TreeMap<>(new CustomDateComparator());
	/* 
	 * Read from File
	 * BufferedReader br = new BufferedReader(new FileReader("FlatFile.txt"));
   		String line = "";
   		while((line = br.readLine()) != null) {  
       String[] fields = line.split("\|");
       pojo p = new pojo(fields[0], fields[1], fields[2]);
       pojoList.add(p);
   }
	 */
 static{
	Person p1 = new Person(LocalDate.of(1991, 01, 01),LocalDate.of(1997, 12, 31));
	Person p2 = new Person(LocalDate.of(1981, 01, 01),LocalDate.of(1990, 12, 31));
	Person p3 = new Person(LocalDate.of(1993, 01, 01),LocalDate.of(1996, 12, 31));
	treeMap.put(p1,"A");
	treeMap.put(p2,"B");
	treeMap.put(p3,"C");
	for (Map.Entry<Person, String> entry:treeMap.entrySet()){
		System.out.println(entry.getKey());
	}
 }
	public static String findPersonCount(int start,int end){
		int count=0;
		LocalDate startDate = LocalDate.of(start, 01, 01);
		LocalDate endDate= LocalDate.of(end, 12, 31);
		Person key = new Person(startDate,endDate);
		Entry<Person,String> e = treeMap.floorEntry(key);
		if (e != null && e.getValue() == null) {
	        e = treeMap.lowerEntry(key);
	    }
		Entry<Person,String> e1 = treeMap.ceilingEntry(key);
		if (e1 != null && e1.getValue() == null) {
	        e1 = treeMap.lowerEntry(key);
	    }
		SortedMap<Person,String> submap = treeMap.subMap(e.getKey(), e1.getKey());
		Iterator it = submap.entrySet().iterator();
		for (Map.Entry<Person, String> entry:submap.entrySet()){
			System.out.println(entry.getValue());
		}
		
		
	   return e.getValue()+""+e1.getValue();
	}

	static class CustomDateComparator implements Comparator<Person>{
		@Override
		public int compare(Person e1,Person e2){
			int i= e1.getDateOfBirth().compareTo(e2.getDateOfBirth());
			if (i!=0) return i;
			int j =e1.getDateOfDeath().compareTo(e2.getDateOfDeath());
			return j;
		}
	}
	
	public static void main(String[] args){
		findPersonCount(1992,1995);
		//System.out.println(findPersonCount(1992,1995));
		
		
	}
	
}
