package at.fhv.oo;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {

		String exp = JOptionPane.showInputDialog("Postfixnotation angeben:");
		System.out.println(exp);
		System.out.println("Das Ergebnis ist: " + evaluatePostfix(exp));

	}

	static int evaluatePostfix(String exp) {
		// create a stack
		int size = 0;
		for (int i = 0; i < exp.length(); i++) {
			if (exp.charAt(i) == ' ') {
				size++;
			}
		}
		Stack stack = new Stack(size);

		// Scan all characters one by one
		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);

			if (c == ' ')
				continue;

			// If the scanned character is an operand push number to stack
			else if (Character.isDigit(c)) {
				int n = 0;
				// extract the characters and store it in num
				while (Character.isDigit(c)) {
					n = n * 10 + (int) (c - '0');
					i++;
					c = exp.charAt(i);
				}
				i--;

				// push the number in stack
				stack.push(n);
			}

			// If the scanned character is an operator, pop two
			else {
				int val1 = stack.pop();
				int val2 = stack.pop();

				switch (c) {
				case '+':
					stack.push(val2 + val1);
					break;

				case '-':
					stack.push(val2 - val1);
					break;

				case '/':
					stack.push(val2 / val1);
					break;

				case '*':
					stack.push(val2 * val1);
					break;
				}
			}
		}
		return stack.pop();
	}
}
