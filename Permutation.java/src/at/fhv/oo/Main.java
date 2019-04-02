package at.fhv.oo;

public class Main {
	public static void main(String[] args) {

		TestPermutation tester = new TestPermutation();
		if (!tester.isPermutationPossible()) {
			System.out.println("Not possible ");
		} else {
			System.out.println("Possible");
		}

		Stack s = new Stack(4);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.pop();
		s.push(7);
				
		System.out.println(s.isEmpty());
		System.out.println(s.isFull());
	
	}
}
