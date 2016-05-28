package com.entrust.ScenarioBased;
/*There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Solution: one-dimentional DP, 
declare candies array represent how many candies each
child should have,
then loop from left to right to make the candies number of each child meet
the requirment, then right to left make the candies array meet the requirement
finally, calculate the total candies number*/


public class CandyQuestion {
    public int candy(int[] ratings) {
        if (ratings==null||ratings.length==0){
            return 0;
        }
        
        int[] candies=new int[ratings.length];
        // every child should has at least one candy
        for (int i=0; i<candies.length; i++){
            candies[i]=1;
        }
        // if child i has rating higher than i-1, which should 1 bigger than its left neighbour
        for (int i=1; i<ratings.length; i++){
            if (ratings[i]>ratings[i-1]){
                candies[i]=candies[i-1]+1;
            }
        }
        // if child i has rating higher than its right neighbour, but the candies array did not 
        // represented this situation correctly, then correct it.
        
        for (int i=ratings.length-2; i>=0; i--){
            if (ratings[i]>ratings[i+1] && candies[i]<=candies[i+1]){
                candies[i]=candies[i+1]+1;
            }
        }
        
        int total=0;
        // calculate the total candies needed
        for (int i=0; i<candies.length; i++){
            total+=candies[i];
        }
        
        return total;
    }
}