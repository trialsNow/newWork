package com.entrust.trials;

import java.util.*;

public class CustomIterator<Item extends Comparable<Item>> implements Iterable<Item>{
	private List<Item> strLst1;
	private List<Item> strLst2;
	
	public CustomIterator(List<Item> items1,List<Item> items2){
		this.strLst1=items1;
		this.strLst2=items2;
	}
	
	@Override
	public Iterator<Item> iterator(){
		return new ListCustomIterator(strLst1,strLst2);
	}
	
	public class ListCustomIterator implements Iterator<Item>{
		boolean visited1,visited2;
		int cursor1,cursor2;
		List<Item> items1;
		List<Item> items2;
		public ListCustomIterator(List<Item> items1,List<Item> items2){
			this.items1=items1;
			this.items2=items2;
			cursor1 =0;
			cursor2 =0;
		}
		
		@Override
		public Item next(){
			Item it=null;
			if (hasNext()){
				if (visited1){
					visited2=true;
					visited1 =false;
					it= items2.get(cursor2);
					cursor2++;
				} else {
					visited1=true;
					visited2=false;
					it= items1.get(cursor1);
					cursor1++;
				}
			
			}
			return it;
		}
		
		@Override
		public boolean hasNext(){
			return cursor1 < items1.size()
					|| cursor2 < items2.size();
		}
		
		@Override
		public void remove(){
			throw new UnsupportedOperationException();
		}
		
		
	}
	
	public static void main(String[] args){
		List<String> lst1=new ArrayList<>();
		List<String> lst2=new ArrayList<>();
		lst1.add("a1");
		lst1.add("a2");
		lst1.add("a3");
		lst2.add("b1");
		lst2.add("b2");
		lst2.add("b3");
		CustomIterator<String> custom = new CustomIterator<>(lst1,lst2);
		Iterator<String> it = custom.iterator();
		while (it.hasNext()){
			System.out.println(it.next());
		}
	}

	
}
