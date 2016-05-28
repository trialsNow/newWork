package com.interview.binarysearch;

/**
 * Find missing number in consecutive numbers.
 */
public class MissingNumberInConsecutiveNumbers {

    public Integer findMissing(int arr[]){
    
        int lowNum = arr[0];
        int first = 0;
        int last = arr.length -1;
        int middle = (first + last)/2;
        while (first < last) {
            if ((arr[middle]-arr[first]) != (middle - first)) {
                /* there is a hole in the first half */
                if ((middle-first) == 1 && (arr[middle]-arr[first] > 1)) {
                    return (arr[middle]-1);
                }   
                last = middle;
            }   
            else if ((arr[last]-arr[middle]) != (last-middle)) {
                /* there is a hole in the second half */
                if ((last-middle) == 1 && (arr[last]-arr[middle] > 1)) {
                    return (arr[middle]+1);
                }   
                first = middle;
            }   
            else
                return -1; 

            middle = (first+last)/2;
        }   

        /* there is no hole */
        return -1; 
        }
    
    public static void main(String args[]){
        int arr[] = {3,4,5,6,7,8,9,10,11,12};
        int arr1[] = {-5,-4,-3,-1,0,1,2,3};
        MissingNumberInConsecutiveNumbers mn = new MissingNumberInConsecutiveNumbers();
        System.out.println(mn.findMissing(arr1));
    }
}
