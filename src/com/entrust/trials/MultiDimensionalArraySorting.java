package com.entrust.trials;

import java.util.Arrays;
import java.util.Comparator;

public class MultiDimensionalArraySorting {

	public static void main(String[] args) {
	Integer unSorted[][] = {{0,1,2},
			                {6,7,8},
			                {3,14,5},
			                {11,12,10}};
	 System.out.println("Unsorted:"+Arrays.deepToString(unSorted));
	 Arrays.sort(unSorted,new ColumnComparator(0,SortingOrder.ASCENDING));
	 System.out.println("Sorted:"+Arrays.deepToString(unSorted));
	}
	
	enum SortingOrder {
		ASCENDING,DESCENDING;
	}
	
	public static class ColumnComparator implements Comparator<Comparable[]>{
		
		private final int index;
		private final SortingOrder order;
		
		public ColumnComparator(int index,SortingOrder sortOrder){
			this.index=index;
			this.order=sortOrder;
		}
		
		@Override
		public int compare(Comparable[] c1,Comparable[] c2){
			int result = c1[index].compareTo(c2[index]);
			System.out.println("c1 value:"+c1[index]);
			System.out.println("c2 value:"+c2[index]);
			System.out.println("Result:"+result);
			return order==SortingOrder.ASCENDING?result:-result;
		}
		
	}

}
