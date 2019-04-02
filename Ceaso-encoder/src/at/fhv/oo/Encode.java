package at.fhv.oo;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class Encode {
	public static void main(String[] args) {
//		String text = ("Das ist ein Text!");
		String text = JOptionPane.showInputDialog("Plaintext:");
		System.out.println(text);
		// int i = 0;
		// char c = text.charAt(i);
		char[] letter = new char[text.length()];
		for (int j = 0; j < text.length(); j++) {
			letter[j] = text.charAt(j);
// 		System.out.print(letter[j]);
		}
		System.out.println();

//		System.out.println("Um wie viele Stellen soll verschoben werden?");
//		// Tastatureingabe um wie viele Stellen verschoben werden soll:
//		Scanner sc = new Scanner(System.in);
//		int no = sc.nextInt();
		String shift = JOptionPane.showInputDialog("Um wie viele Stellen soll verschoben werden?");
		int no = Integer.parseInt(shift);

		System.out.println();
		if (no < 0) {
			no = no + 26;
			System.out.println("Verschlüsselt um " + (no - 26) + " Stellen:");
		} else {
			System.out.println("Verschlüsselt um " + no + " Stellen:");
		}
		// Tastatureingabe schließen
//		sc.close();

		for (int l = 0; l < letter.length; l++) {
			if (letter[l] == ' ') {
				letter[l] = ' ';
			} else {
				if (letter[l] == '!') {
					letter[l] = '!';
				} else {
					if (letter[l] == '?') {
						letter[l] = '?';
					} else {
						if ((char) (letter[l]) >= 'a' && (char) (letter[l]) <= 'z') {
							if ((char) ((letter[l]) + no) > 122) {
								letter[l] = (char) (letter[l] + no - 26);
							} else {
								letter[l] = (char) (letter[l] + no);
							}
						} else {
							if ((char) (letter[l]) >= 'A' && (char) (letter[l]) <= 'Z') {
								if ((char) ((letter[l]) + no) > 90) {
									letter[l] = (char) (letter[l] + no - 26);
								} else {
									letter[l] = (char) (letter[l] + no);
								}
							}
						}
					}
				}
			}
			System.out.print(letter[l]);
		}
	}

}
