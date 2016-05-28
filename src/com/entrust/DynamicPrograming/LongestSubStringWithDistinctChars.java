package com.entrust.DynamicPrograming;

import java.util.*;
public class LongestSubStringWithDistinctChars {
	public static String printLongestSubstring(String s){
		char[] chars = s.toCharArray();
		String strFinal=null;
		StringBuilder lngSubStr = new StringBuilder();
		Set<Character> set = new HashSet<>();
		
		for (int i=0;i<chars.length-1;i++){
			if (set.add(chars[i])){
				lngSubStr.append(chars[i]);
			} else {
				set.clear();
				set.add(chars[i]);
				if (strFinal ==null || lngSubStr.toString().length() > strFinal.length()){
				strFinal = lngSubStr.toString();
				}
				lngSubStr= new StringBuilder();
			}
		}
		return strFinal;
	}
	
	
	
	
	
	public static void main (String args[])
	{
		System.out.println(printLongestSubstring("aabsgfdgaavdbqrstuvwxyz"));
	}
}
