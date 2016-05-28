package com.entrust.trials;

import java.text.Normalizer;

public class ReverseString {

	private String reverseStr;
	
	public ReverseString(String str){
		this.reverseStr= recurseReverse(str);
	}
	
	public String recurseReverse(String s){
		if(s.length() ==0 || s.length()==1) return s;
		else {
			return recurseReverse(s.substring(1))+s.charAt(0);
		}
	}

	public static String reverse(String s) {
		int N = s.length();
		if (N <= 1) return s;
		String a = s.substring(0, N/2);
		String b = s.substring(N/2, N);
		return reverse(b) + reverse(a);
	}
	
	public static void main(String[] args) throws Exception{
		ReverseString s = new ReverseString("Rathna");
		System.out.println("Reversed:"+reverse("Rathna"));
		String unicodeString = "as⃝df̅";
		byte[] data = unicodeString.getBytes("ASCII");
		String normalized = Normalizer.normalize(unicodeString,
				Normalizer.Form.NFD);
		System.out.println(normalized);
		System.out.println("Reversed:"+reverse(unicodeString));
		System.out.println(new StringBuffer(unicodeString).reverse().toString());

	}
	
}
