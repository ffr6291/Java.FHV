package at.fhv.oo;

public class Main {
	public static void main(String[] args) {
		
		Cell c1 = new Cell("East");
		Cell c2 = new Cell("West");
		
		c1.setNeighbour(Direction.East, c2);

		Product pizza = new Product("Pizza", 5);
		c1.setProduct(pizza, 0);
		c1.getProduct(0);
		
		Product apple = new Product("Apfel", 2);
		c1.setProduct(apple, 3);
		c1.getProduct(3);

		Trolley t1 = new Trolley(c1, 10);
		t1.pickup(apple, 0);
		t1.pickup(pizza, 1);
		
		t1.offload(t1);
	}
	


}
