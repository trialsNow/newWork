package com.entrust.DynamicPrograming;

import java.util.*;
public class EncodeStringa2toaa {

	public static String compress(String s){
		Map<Character,Integer> map = new HashMap<>();
		map.put(s.charAt(0), 0);
		
		for (int c=1;c<s.toCharArray().length;c++){
			if (s.charAt(c)==s.charAt(c-1) && map.containsKey(s.charAt(c))){
				map.put(s.charAt(c), map.get(s.charAt(c))+1);
			} 
			else {
			map.put(s.charAt(c), 0);
			}
		}
		StringBuilder comprsd = new StringBuilder();
		for (Map.Entry<Character, Integer> entry:map.entrySet()){
			String val= entry.getValue()==0?"":"x"+String.valueOf(entry.getValue());
			comprsd.append(""+entry.getKey()+val);
		}
		return comprsd.toString();
	}
	
	public static void main(String[] args){
		System.out.println(compress("p14akkkkkkkkpq"));
	}
	
}
