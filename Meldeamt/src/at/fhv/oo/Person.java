package at.fhv.oo;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Person {

	private String _fname;
	private String _lname;
	private String _maidenname;
	private String _birthday;
	private Person _person;
	private Gender _gender;
	private String _status;

	public Person(String fname, String lname, Gender gender, String birthday) {
		_fname = fname;
		_lname = lname;
		_gender = gender;
		_birthday = birthday;
		_status = "Ledig";
		}
	
	public void marriage(Person p1, Person p2) {
		if(p1._gender == p2._gender) {
			System.out.println("Gleichgeschlechtliche Ehe nicht möglich!");
		} else {
			System.out.println("Sie dürfen die Braut jetzt Küssen!");
			p1._status= "Verheiratet";
			p2._status = "Verheiratet";
		}
	}
	public String status(Person p1) {
		System.out.println("Beziehungsstatus von " + _fname + " "+ _lname + ": " + _status);
		return _status;
	}
	
	public void divorce(Person p1, Person p2) {
		if(p1._status == "Verheiratet" && p2._status == "Verheiratet") {
			p1._status = "Geschieden";
			p2._status = "Geschieden";
			System.out.println("Beziehungsstatus von " + p1._fname + " "+ p1._lname + ": " + p1._status);
			System.out.println("Beziehungsstatus von " + p2._fname + " "+ p2._lname + ": " + p2._status);
		}
	}
	
//	public void hasMarriagaAge() {
//		if(Period.between(_birthday, LocalDate.now()).getYears() >=18) {
//			System.out.println("Alt genug!");
//		}else {
//			System.out.println("Werd erwachsen!");
//		}
//	}
//	public void setGender(String gender) {
//		if (gender != "Female" && gender != "Male") {
//			System.out.println("Gender muss entweder Female oder Male sein!!!");
//		} else {
//			_gender = gender;
//		}
//	}
//
//	public String getGender() {
//		return _gender;
//	}
//
//	public void Marriage(Person p1, Person p2) {
//
//		if (p1.getGender() != p2.getGender()) {
//			System.out.println("Sie dürfen die Braut jetzt küssen!");
//
//		} else {
//			System.out.println("Gleichgeschlechtliche Ehe nicht möglich!!");
//
//		}
//	}
//
}