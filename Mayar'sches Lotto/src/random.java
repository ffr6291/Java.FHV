import java.util.Arrays;
import java.util.Random;

public class random {

	public static void main(String[] args) {
		int possocc = 1;	//so oft darf eine Zahl gezogen werden
		int max  =32;		//Zahlen von 0 bis max werden gezogen
		int pick = 7;		//Wie viele Zahlen werden gezogen
		int[] Basis = new int[max+1];
		Basis[0] = 0;
		for (int i = 0; i < (max+1); i++) {
			Basis[i] = possocc;
		}
		Random rand = new Random();
		int[] Zahlen = new int[pick];
		
		for (int n = 0; n < pick; n++) {
			int i = rand.nextInt(max);
			i += 1;
			if (Basis[i] == 0) {
				while (Basis[i] == 0) {
					i = rand.nextInt(max);
					i += 1;
				}
			}
			Zahlen[n] = i;
			Basis[i] = Basis[i] - 1;
		}
		
		Arrays.sort(Zahlen);
		System.out.print(Arrays.toString(Zahlen));
		System.out.print(" Zusatzzahl: ");

		int zz = 1;			//wie viele Zusatzzahlen
		int[] Zusatzzahl = new int[zz];
		Zusatzzahl[0] = rand.nextInt(max) + 1;
		int i = 0;
		while (i < pick) {
			if (Zahlen[i] != Zusatzzahl[0]) {
				i++;
			} else {
				i = 0;
				Zusatzzahl[0] = rand.nextInt(max) + 1;
			}
		}
		System.out.println(Arrays.toString(Zusatzzahl));
	}

}