package at.fhv.oo;

import java.time.LocalDateTime;

public class Main {
	public static void main(String[] args)  {
	Person Frau = new Person("Test", "Musterfrau", LocalDateTime.now());
	Person Mann = new Person("Mann", "Mustermann", LocalDateTime.now());
	
	Frau.setGender("Male");
	Mann.setGender("Female");
	Frau.Marriage(Frau, Mann);
	//test
	
	
	
	
	
	
	
	
	
	
	
	
	}
		
	}

