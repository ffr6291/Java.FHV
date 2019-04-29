package at.fhv.oo;

public class Wall extends Cell {
	
	
	public Wall(String name) {
		super(name);
	}

	public void enter(Direction direction, Player player) {
	
		int _damage = 10;
		if (player.getHealth() - _damage <= 0) {
			System.out.println("We`re sorry. You died. Never lucky!");
			player.setHealth(0);
			player.removePlayer();
			

		} else {
			System.out.println("You bumped your head as you walked into the Wall. You lost " + _damage
					+ " health. Chose another direction.");
			player.setHealth(player.getHealth() - _damage);
		}

	}
}