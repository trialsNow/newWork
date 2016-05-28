package com.entrust.trials.Sorting;

public class QuickSortMyVersion {
	static int[] a = {2,1,3,4};
	int pivotPos =a.length-1;
	
	public void partition(int[] a){
		int n = a.length;
		int i=-1;
		int j=0;
		
		while(j<pivotPos){
			if (a[++j]<a[pivotPos]){
				i++;
				swap (i,j);
			}
		}
		pivotPos = i+1;
		swap(n-1,i+1);
	}


	private void swap (int k,int v){
		int temp=a[k];
		a[k]=a[v];
		a[v]=temp;
	}
	
	public static void main (String[] args){
		QuickSortMyVersion qk = new QuickSortMyVersion();
		qk.partition(a);
		
		for (int i=0;i<a.length;i++){
		System.out.print(a[i]+" ");
		}
		
	}

}
