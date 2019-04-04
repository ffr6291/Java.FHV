package at.fhv.oo;

import java.time.LocalDateTime;

public class Main {
	public static void main(String[] args)  {
	Person Frau = new Person("Test", "Musterfrau", Gender.Female, "01.03.1997");
	Person Mann = new Person("Mann", "Mustermann", Gender.Male, "08.08.2005");
	
	
	Mann.status(Mann);
	Frau.status(Frau);
	
	Mann.marriage(Mann, Frau);
	
	Mann.status(Mann);
	Frau.status(Frau);

	Mann.divorce(Mann, Frau);
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
		
	}

