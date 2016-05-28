package com.entrust.trials;

import java.util.regex.*;
import java.util.*;
public class StringManipulation {
	   public static void main(String[] args) {
	      String source = "There are thirty-three big-apple";
	      String[] tokens = source.split("\\s+|-");  // whitespace(s) or -
	      for (String token : tokens) {
	         System.out.println(token);
	      }
	      List<String> inputLst = new ArrayList<String>();
			inputLst.add("123-45-6789");
			inputLst.add("9876-5-4321");
			inputLst.add("987-65-4321 (attack)");
			inputLst.add("987-65-4321 ");
			inputLst.add("192-83-7465");


			for (String ssn : inputLst) {
				if (ssn.matches("^(\\d{3}-?\\d{2}-?\\d{4})$")) {
					System.out.println("Found good SSN: " + ssn);
				}
			}
	      String input = "This is an apple. These are 33 (thirty-three) apples";
	      String regexe = "Th";
	      Pattern pattern = Pattern.compile(regexe);
	      Matcher matcher = pattern.matcher(input);
	      while (matcher.find()) {     // find the next match
	         System.out.println("find() found the pattern \"" + matcher.group()
	               + "\" starting at index " + matcher.start()
	               + " and ending at index " + matcher.end());
	      }
	      if (matcher.matches()) {
	         System.out.println("matches() found the pattern \"" + matcher.group()
	               + "\" starting at index " + matcher.start()
	               + " and ending at index " + matcher.end());
	      } else {
	         System.out.println("matches() found nothing");
	      }
	      if (matcher.lookingAt()) {
	         System.out.println("lookingAt() found the pattern \"" + matcher.group()
	               + "\" starting at index " + matcher.start()
	               + " and ending at index " + matcher.end());
	      } else {
	         System.out.println("lookingAt() found nothing");
	      }
	   }
}
