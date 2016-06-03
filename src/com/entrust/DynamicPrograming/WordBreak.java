package com.entrust.DynamicPrograming;

import java.util.*;
import java.util.regex.*;
/*
Given a string s and a dictionary of words dict, determine if s can be segmented
into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].
Return true because "leetcode" can be segmented as "leet code".
Assuming you want to analyze the domain names of the top 10k websites
Word break II: Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word
is a valid dictionary word. Return all such possible sentences.
For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"], the solution is ["cats and dog", "cat sand dog"].
 */
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
	public static List<String> wordBreak2(String s, Set<String> dict) {
		//create an array of ArrayList<String>
		List<String> dp[] = new ArrayList[s.length()+1];
		dp[0] = new ArrayList<String>();

		for(int i=0; i<s.length(); i++){
			if( dp[i] == null )
				continue;

			for(String word:dict){
				int len = word.length();
				int end = i+len;
				if(end > s.length())
					continue;

				if(s.substring(i,end).equals(word)){
					if(dp[end] == null){
						dp[end] = new ArrayList<String>();
					}
					dp[end].add(word);
				}
			}
		}

		List<String> result = new LinkedList<String>();
		if(dp[s.length()] == null)
			return result;

		ArrayList<String> temp = new ArrayList<String>();
		dfs(dp, s.length(), result, temp);

		return result;
	}

	public static void dfs(List<String> dp[],int end,List<String> result, ArrayList<String> tmp){
		if(end <= 0){
			String path = tmp.get(tmp.size()-1);
			for(int i=tmp.size()-2; i>=0; i--){
				path += " " + tmp.get(i) ;
			}

			result.add(path);
			return;
		}

		for(String str : dp[end]){
			tmp.add(str);
			dfs(dp, end-str.length(), result, tmp);
			tmp.remove(tmp.size()-1);
		}
	}
	 
	 public static void main(String[] args) {
			HashSet<String> dict = new HashSet<String>();
			dict.add("cat");
			dict.add("cats");
			dict.add("and");
			dict.add("sand");
		 dict.add("dog");
			StringBuilder sb = new StringBuilder();
		 
			for(String s: dict){
				sb.append(s + "|");
			}
		 
			String pattern = sb.toString().substring(0, sb.length()-1);
		    System.out.println(pattern);
			pattern = "("+pattern+")*";
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher("catsanddog");
		 int count=0;
		 while(m.find()) {
			 count++;
			 System.out.println("found: " + count + " : "
					 + m.start() + " - " + m.end());
			 System.out.println("found: " + sb.toString().substring(m.start(),m.end()));
		 }
			/*if(m.matches()){
				System.out.println("lookingAt = " + m.lookingAt());
				System.out.println(m.group());
				System.out.println(m.start());
				System.out.println(m.end());
			}*/
		}

}
