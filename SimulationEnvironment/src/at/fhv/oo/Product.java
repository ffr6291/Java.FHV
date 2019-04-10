package at.fhv.oo;

public class Product {
	private String _product;
	private int _weight;

	public int get_weight() {
		return _weight;
	}

	public Product (String product, int weight) {
		_product = product;
		_weight = weight;		
	}
	
	public String name() {
		return _product;
	}
}
