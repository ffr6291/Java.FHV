package at.fhv.oo;

public class Field extends Cell {

	private int _id;
	private String _description;

	public Field(int id, String name, String description) {
		super(name);
		_id = id;
		_description = description;
	}

	// TODO Which players are on me method
	/**
	 * Ab hier folgen die Methoden um den Output zu generieren
	 *
	 * @return
	 */
	public String getInfoNeighbors() {
		return "North: " + this.getNeighbor(Direction.NORTH) + '\n' + "East: " + this.getNeighbor(Direction.EAST) + '\n'
				+ "South: " + this.getNeighbor(Direction.SOUTH) + '\n' + "West: " + this.getNeighbor(Direction.WEST)
				+ "\n-----------------------------------------------";
	}

	@Override
	public void enter(Direction dir, Player player) {
		Cell field = this;
		removePlayer(player);
		field.setPlayer(player);
		System.out.println(getCellInfo());

	}

	public String getDescription() {
		return "Description: " + _description + '\n';
	}

	public String getInfoWeaponsOnField() {
		if (_item != null) {
			return "You found a " + getItemOnField();
		} else
			return "";
	}

	@Override
	public String getCellInfo() {
		return toString() + '\n' + getDescription() + getInfoWeaponsOnField() +
		// getInfoPlayersOnField() + '\n' +
				"\n" + getInfoNeighbors();
	}

	@Override
	public String toString() {
		return "Field " + _id + ", " + _name;

	}

}
