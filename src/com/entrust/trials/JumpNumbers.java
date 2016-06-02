package com.entrust.trials;

/**
 * We can track the maximum index that can be reached. The key to solve this problem is to find: 1)
 * when the current position can not
 * reach next position (return false) , and 2) when the maximum index can reach the end (return true).

 The largest index that can be reached is: i + A[i].
 */
public class JumpNumbers {
    public static boolean canJump(int[] A) {
        if(A.length <= 1)
            return true;

        int max = A[0]; //max stands for the largest index that can be reached.

        for(int i=0; i<A.length; i++){
            //if not enough to go to next
            if(max <= i && A[i] == 0)
                return false;

            //update max
            if(i + A[i] > max){
                max = i + A[i];
            }

            //max is enough to reach the end
            if(max >= A.length-1)
                return true;
        }

        return false;
    }

    public static void main (String[] args)
    {
        int arr[] = {3,2,1,0,4};
        int n = arr.length;
        System.out.println(
                canJump(arr));
    }
}
