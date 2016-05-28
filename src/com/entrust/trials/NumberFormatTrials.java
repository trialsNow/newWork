package com.entrust.trials;

import java.text.NumberFormat;
import java.text.ParseException;

public class NumberFormatTrials {
	
	double x = 12.456d;
	public static void main (String[] args) throws ParseException{
		NumberFormatTrials t = new NumberFormatTrials();
		//NumberFormat n = NumberFormat.getInstance().getCurrencyInstance();
		String a ="1034";
		
		System.out.println(NumberFormat.getPercentInstance().format(t.x));
		System.out.println(NumberFormat.getInstance().parse(a));
	}
}
