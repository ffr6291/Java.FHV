package at.fhv.oo;

public class Trolley {
	boolean _isfull;
	Cell _cell;
	private String[] _space;
	private int _maxload;

	public Trolley(Cell location, int maxload) {
		_maxload =maxload;
		_space = new String[2];
		_cell = location;
	}

	public void pickup(Product product, int ware) {
		_space[ware] = product.name();

	}
	public void offload(Trolley trolley) {
		for(int i = 0; i<trolley._space.length; i++) {
			System.out.println("Sie haben gekauft: " + trolley._space[i]);
		}
	}

}
