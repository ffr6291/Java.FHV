package at.fhv.oo;

import javax.swing.JOptionPane;

public class Tester {
	public static void main(String[] args) {
		String s = JOptionPane.showInputDialog("Postfixnotation angeben:");
		int op1 = 0;
		int op2 = 0;
		
		int size = 0;
		for (int i = 0; s.charAt(i) == ' '; i++) {
			size++;
		}

		Stack st = new Stack(10);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; s.charAt(i) != ' '; i++) {
			sb = sb.append(s.charAt(i));
		}
		
		op1 = new Integer(sb.toString());
		st.push(op1);
		

	}
}
