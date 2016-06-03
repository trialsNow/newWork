package com.entrust.DateExamples;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class DateSamples {
	
	static class Interval{
		LocalDate dob;
		LocalDate dod;
		
		public Interval(LocalDate dob,LocalDate dod){
			this.dob=dob;
			this.dod=dod;
		}
	}
	
	public static void main(String[] args){
	List<Interval> lst = new ArrayList<>();
	Interval inter1= new Interval(LocalDate.of(1998, 01, 01),LocalDate.of(2010, 12, 31));
	Interval inter2= new Interval(LocalDate.of(1988, 01, 01),LocalDate.of(2000, 12, 31));
	Interval inter3= new Interval(LocalDate.of(1971, 01, 01),LocalDate.of(1989, 12, 31));
	lst.add(inter1);
	lst.add(inter2);
	lst.add(inter3);
	Interval checkRange = new Interval(LocalDate.of(1990, 01, 01),LocalDate.of(2001, 12, 31));
	int count=0;
	for (Interval i:lst){
		if (i.dob.isBefore(checkRange.dod) 
				&& checkRange.dob.isBefore(i.dod)){
			count++;
		}
	}
	System.out.println("People lived between given date range is:"+count);
	
	LocalDate today = LocalDate.now();
	LocalDate birthday = LocalDate.of(1960, Month.JANUARY, 1);
	String e = "2014-05-10";
	LocalDate start = LocalDate.parse(e);

	Period p = Period.between(birthday, today);
	long p2 = ChronoUnit.DAYS.between(birthday, today);
	System.out.println("You are " + p.getYears() + " years, " + p.getMonths() +
	                   " months, and " + p.getDays() +
	                   " days old. (" + p2 + " days total)");
	}
}
