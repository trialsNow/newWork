package com.entrust.FileOperations;

import java.time.*;
public class Person {
	LocalDate dateOfBirth;
	LocalDate dateOFDeath;

	public Person(LocalDate dob,LocalDate dod){
		this.dateOfBirth=dob;
		this.dateOFDeath=dod;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getDateOfDeath() {
		return dateOFDeath;
	}

	public void setDateOFDeath(LocalDate dateOFDeath) {
		this.dateOFDeath = dateOFDeath;
	}
	
	@Override
	public boolean equals(Object o){
		if (o==null) return false;
		if (!(o instanceof Person)) return false;
		Person person = (Person)o;
		if (this.dateOfBirth!=null && this.dateOFDeath!=null){
			if (this.dateOfBirth.equals(person.getDateOfBirth())
				&& this.dateOFDeath.equals(person.getDateOfDeath())){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString(){
		return this.dateOfBirth+"   "+this.dateOFDeath;
	}

	
}
