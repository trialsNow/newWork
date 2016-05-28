package com.entrust.DynamicPrograming;

import java.util.*;
import java.util.regex.*;
public class WordBreak {
	 public boolean wordBreak(String s, Set<String> dict) {
	        boolean[] t = new boolean[s.length()+1];
	        t[0] = true; //set first to be true, why?
	        //Because we need initial state
	 
	        for(int i=0; i<s.length(); i++){
	            //should continue from match position
	            if(!t[i]) 
	                continue;
	 
	            for(String a: dict){
	                int len = a.length();
	                int end = i + len;
	                if(end > s.length())
	                    continue;
	 
	                if(t[end]) continue;
	 
	                if(s.substring(i, end).equals(a)){
	                    t[end] = true;
	                }
	            }
	        }
	 
	        return t[s.length()];
	    }
	 
	 public static void main(String[] args) {
			HashSet<String> dict = new HashSet<String>();
			dict.add("go");
			dict.add("goal");
			dict.add("goals");
			dict.add("special");
		 
			StringBuilder sb = new StringBuilder();
		 
			for(String s: dict){
				sb.append(s + "|");
			}
		 
			String pattern = sb.toString().substring(0, sb.length()-1);
			pattern = "("+pattern+")*";
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher("goalspecial");
		 
			if(m.matches()){
				System.out.println("match");
			}
		}

}
