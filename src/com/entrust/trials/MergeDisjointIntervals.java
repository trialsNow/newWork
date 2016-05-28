package com.entrust.trials;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * 
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */

public class MergeDisjointIntervals {
	
	public static class Interval {
	    int start;
	  int end;
	 Interval() { start = 0; end = 0; }
	  Interval(int s, int e) { start = s; end = e; }
	 }
	 
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
 
        List<Interval> result = new ArrayList<Interval>();
 
        for(Interval interval: intervals){
            if(interval.end < newInterval.start){
                result.add(interval);
            }else if(interval.start > newInterval.end){
                result.add(newInterval);
                newInterval = interval;        
            }else if(interval.end >= newInterval.start || interval.start <= newInterval.end){
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(newInterval.end, interval.end));
            }
        }
 
        result.add(newInterval); 
 
        return result;
    }
    
    public static void main(String[] args){
    	Interval s1 = new Interval(2,3);
    	Interval s2 = new Interval(6,10);
        List<Interval> lst = new ArrayList<>();
        lst.add(s1);
        lst.add(s2);
        List<Interval> result =insert(lst,new Interval(4,8));
        for (Interval i:result){
        System.out.print(i.start+" "+i.end);
        System.out.println("");
        }
        
    }

}