package at.fhv.oo;

public class Cell {
	private Cell[] _neighbours;
	private boolean _isFull= false;
	private String _cellid;
	private String[] _product;
	
	public Cell(String id) {
		_product = new String[4];
		_neighbours = new Cell[Direction.values().length];
		_cellid = id;
	}
	
	public void setNeighbour(Direction dir, Cell neighbour) {
		_neighbours[dir.ordinal()]=neighbour;
		
	}	
	public void setProduct(Product product, int stelle) {
		_product[stelle]=product.name();
	}
	public String getProduct(int stelle) {
		System.out.println(_product[stelle]);
		return _product[stelle];
	}
	
	
	
}
