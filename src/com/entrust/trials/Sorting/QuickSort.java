package com.entrust.trials.Sorting;
/*
Quick Sort logic:
	1. Find Split position.
		a. Mark first element(a[0]) as pivot, i as 1 and j as length-1;
		Do this until i<=j;
		b. Scan from left to right comparing a[i]..with piv.
			1. If a[i]<=a[piv] go to next element
			2. If a[j] > a[pivot], deccrement j
			3. Else swap (i++,j--) values
		c. After the loop check if a[pivot] >= a[j] if yes swap(pivot,j) values.
	2. Get the split position and recursively call with sort(A,0,splitPos-1) and sort(A,splitPos+1,high)
 */
public class QuickSort {

    private void swap(int A[],int i,int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    private int split1(int A[],int low,int high){
        
        int pivot = low;
        int i = low+1;
        int j = high;
        while(i <= j){
            
            if(A[i] <= A[pivot]){
                i++;
                continue;
            }
            if(A[j] > A[pivot]){
                j--;
                continue;
            }
           swap(A,i++,j--);
        }
        if(A[pivot] >= A[j]){
            swap(A,pivot,j);
            return j;
        }
        return pivot;
        
    }

    public void sort(int A[],int low,int high)
    {
        if(low>=high)
        {
            return;
        }
        int pos = split1(A,low,high);
        sort(A,low,pos-1);
        sort(A,pos+1,high);
    }   
    
    private void printArray(int arr[]){
        for(int a : arr){
            System.out.println(a);
        }
    }
    public static void main(String args[]){
        QuickSort qs = new QuickSort();
       int A[] = {11,19,0,-1,5,6,16,-3,6,0,14,18,7,21,18,-6,-8};
 //int A[] = {101,1,2,8,17,71,101};
        qs.sort(A, 0, A.length-1);
        qs.printArray(A);
        
    }
}
