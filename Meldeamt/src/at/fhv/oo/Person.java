package at.fhv.oo;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Person {

	private String _fname;
	private String _lname;
	private String _maidenname;
	private LocalDateTime _birthday;
	private Person _person;
	private String _gender;

	public Person(String fname, String lname, LocalDateTime now) {
		_fname = fname;
		_lname = lname;
		_birthday = now;
	}

	public void setGender(String gender) {
		if (gender != "Female" && gender != "Male") {
			System.out.println("Gender muss entweder Female oder Male sein!!!");
		} else {
			_gender = gender;
		}
	}

	public String getGender() {
		return _gender;
	}

	public void Marriage(Person p1, Person p2) {

		if (p1.getGender() != p2.getGender()) {
			System.out.println("Sie dürfen die Braut jetzt küssen!");

		} else {
			System.out.println("Gleichgeschlechtliche Ehe nicht möglich!!");

		}
	}

}