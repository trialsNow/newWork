package com.entrust.trials;
/*
Roman to Decimal:
Check the corresponding decimal value of the i and i+1.Loop till n-1
If i>=i+1 add the decimal value of i to rslt.
If i<i+1 subtract the decimal value of i t rslt
Always add last digit's value to rslt.

Decimal to Roman:
If given number is less than numbers list then add the corresponding roman
letter and then subtract that number from target and loop
 */
import java.util.*;
public class RomanComputations {
	private static int[]    numbers = { 1000,  900,  500,  400,  100,   90,
			50,   40,   10,    9,    5,    4,    1 };
	private static String[] letters = { "M",  "CM",  "D",  "CD", "C",  "XC",
			"L",  "XL",  "X",  "IX", "V",  "IV", "I" };
	private static int decodeSingle(char letter) {
		switch(letter) {
			case 'M': return 1000;
			case 'D': return 500;
			case 'C': return 100;
			case 'L': return 50;
			case 'X': return 10;
			case 'V': return 5;
			case 'I': return 1;
			default: return 0;
		}
	}


	public static int romanToDecimal(String roman) {
		int result = 0;
		String uRoman = roman.toUpperCase(); //case-insensitive
		for(int i = 0;i < uRoman.length() - 1;i++) {//loop over all but the last character
			//if this character has a lower value than the next character
			if (decodeSingle(uRoman.charAt(i)) < decodeSingle(uRoman.charAt(i+1))) {
				//subtract it
				result -= decodeSingle(uRoman.charAt(i));
			} else {
				//add it
				result += decodeSingle(uRoman.charAt(i));
			}
		}
		//decode the last character, which is always added
		result += decodeSingle(uRoman.charAt(uRoman.length()-1));
		return result;
	}

	public static String decimalToRoman(int num){
			String roman = "";
			int N = num;
			for (int i = 0; i < numbers.length; i++) {
				while (N >= numbers[i]) {
					roman += letters[i];
					N -= numbers[i];
				}
			}
			return roman;

	}
 
	public static void main(String[] args) {
		System.out.println(romanToDecimal("MCMXC")); //1990
		System.out.println(romanToDecimal("MMVIII")); //2008
		System.out.println(romanToDecimal("MDCLXVI")); //1666
		System.out.println(romanToDecimal("LXXXVIII")); //88
		System.out.println(decimalToRoman(88)); //88
	}
}