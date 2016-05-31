package com.entrust.trials;

/**
 * Created by rathna on 2016-05-30.
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        return helper(1, n);
    }

    public int helper(int i, int j){
        int m = i + (j-i)/2;

        if(i>=j)
            return i;

        if(isBadVersion(m)){
            return helper(i, m);
        }else{
            return helper(m+1, j); //not bad, left --> m+1
        }
    }

    private boolean isBadVersion(int m){
        return true;
    }
}
