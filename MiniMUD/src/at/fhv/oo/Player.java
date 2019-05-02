package at.fhv.oo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {

	/**
	 * capacity of the backpack, in [kg]
	 */
	private String _name;
	private float _backpackStorageInKg;
	private float _maxBackpackStorageInKg;
	private int _health;
	private int _maxHealth = 200;
	private Map<String, Wearable> _gear = new HashMap<>();
	private ArrayList<Consumable> _backpack = new ArrayList<>();
	private List<Cell> _destinationCells = new ArrayList<>();
	private Cell _myPosition;
	public Field deathCell = new Field(0, "cemetery", "Rest in peace ");
	private static ArrayList<Player> playerList = new ArrayList<>();

	public Player(String name) {
		_name = name;
		_backpackStorageInKg = 0;
		_maxBackpackStorageInKg = 5;
		_health = _maxHealth;

	}

	public void joinGame(Cell startingCell) {
		_myPosition = startingCell;
		playerList.add(this);
		startingCell.setPlayer(this);
		System.out.println(_name + " joined the game. He/She starts here: \n\n" + getMyPosition().getCellInfo());
	}

	public void removePlayer(Player player) {
		if (player.getHealth() > 0) {
			System.out.println("Player can't be removed. He isn't dead yet!"
					+ "\n-----------------------------------------------");
		} else {
			this.setMyPosition(deathCell);
			playerList.remove(player);
		}
	}

	public static void currentPlayerOnline() {
		System.out.println("Current Player online: ");
		playerList.forEach(Player -> {
			System.out.println(Player.getName() + " " + Player.getHealth() + "/" + Player.getMaxHealth());
		});
		System.out.println("-----------------------------------------------");
	}

	public void stats() {
		System.out.println("-----------------------------------------------\n" + "STATS:" + "\nName: " + getName()
				+ "\nPosition: " + getMyPosition().getCellInfo() + "\nHealth: " + getHealth() + "/" + getMaxHealth()
				+ "\nBackpackstorage: " + (getMaxBackpackStorageInKg() - getBackpackStorageInKg()) + "Kg" + "\nGear: "
				+ getGear().keySet());
		if (_backpack.isEmpty()) {
			System.out.println("-----------------------------------------------");
		}
		_backpack.forEach(consumable -> {
			System.out.println(
					"Backpack: " + consumable.getName() + "\n-----------------------------------------------\n");
		});

	}

	// TODO HIER WURDE POLYMORPHISMUS ANGEWANDT
	public void enter(Direction dir) {
		if (this.getMyPosition() == deathCell) {
			System.out.println("You can't move. You are dead!");

		} else {
			Cell destinationCell = getMyPosition().getNeighbor(dir);
			_destinationCells.add(destinationCell);

			if (destinationCell == null) {
				System.out.println("You can't go there, it's nothing there");
			}
			for (Cell cell : _destinationCells) {
				cell.enter(dir, this);
			}
			_destinationCells.remove(destinationCell);

			// } else if (destinationCell instanceof Door) {
			// if (((Door) destinationCell).getDoorStatus().equals(DoorStatus.CLOSED)) {
			// System.out.println("The door is locked, find a key first!");
			// }
			// if (((Door) destinationCell).getDoorStatus().equals(DoorStatus.OPENED)) {
			// System.out.println("You entered through the door.\n");
			// // if(destinationCell.getNeighbor(dir).isFreeForPlayer()) {
			// destinationCell.removePlayer(this);
			// destinationCell.getNeighbor(dir).setPlayer(this);
			// System.out.println(getMyPosition().getCellInfo());
			// //}
			// }
			// } else if (destinationCell instanceof Wall) {
			// int _damage = 10;
			// System.out.println("You bumped your head as you walked into the Wall. You
			// lost " + _damage + " health");
			// setHealth(getHealth() - _damage);
			// } else if (destinationCell instanceof Field) {
			// //if(destinationCell.isFreeForPlayer()) {
			// destinationCell.removePlayer(this);
			// destinationCell.setPlayer(this);
			// // }
			// System.out.println(getMyPosition().getCellInfo());
			// }
//
		}
	}

	public void pickupItem(Field field, Consumable consumable) {
		if (!isBackpackFull()) {
			if (doesFitInBackpack(consumable)) {
				if (!(field.equals(getMyPosition()))) { // Check if right field is entered
					System.out.println("You are not on that field!!");
				} else {
					if (!(consumable.equals(field.getItemOnField()))) {// TODO ASK why wont
																		// .getymyposition.getItemOnField work?
						System.out.println("There is no such Item here!!");
					} else {
						_backpack.add(consumable);
						_backpackStorageInKg = _backpackStorageInKg + consumable.getWeight();
						field.setItemOnField(null);
						System.out.println("You put the " + consumable.getName() + " in your Backpack!");
					}
				}
			}
		}
	}

	/**
	 * You can pickup the item on your field
	 *
	 * @param field    must be the field you are on
	 * @param wearable Type in the Item on your field, you can only equip wearables
	 */
	public void equipItem(Field field, Wearable wearable) {
		if (field.getItemOnField() != (null)) {
			if (!(field.equals(getMyPosition()))) { // Check if right field is entered
				System.out.println("You are not on that field!!");
			} else {
				if (!(wearable.equals(getMyPosition().getItemOnField()))) {// TODO ASK why wont
																			// .getymyposition.getItemOnField work?
					System.out.println("There is no such Item here!!");
				} else {
					_gear.put(field.getItemOnField().getName(), wearable);// TODO throw excaption if its already in
					field.setItemOnField(null);
					System.out.println("You equipped the " + wearable.getName() + ".");
				}
			}
		}
	}

	/**
	 *
	 * You can useWeapon to attack other Players. Range 0 means you can only attack
	 * Players on your field. Range 1 means you can attack Players on a field which
	 * is neighboring your field.
	 *
	 * @param weapon Choose which Weapon you want to use.
	 * @param player Choose which Player you want to attack.
	 */
	public void useWeapon(Weapon weapon, Player player) {
		if (isItemEquipped(weapon)) {
			if (weapon.getRange() == 0) {
				if (player.getMyPosition().equals(this.getMyPosition())) {// checks if player is on same cell as you
					player.setHealth(player.getHealth() - weapon.getDamage());
					System.out.println();
				}
			}
			if (weapon.getRange() == 1) {// checks if player is on a cell next to you
				// if(player.getMyPosition().equals(this.getMyPosition())
				// || (this.getMyPosition().getNeighbors()));//TODO FIX that you can shoot on
				// next field

			}
		} else {
			System.out.println("This Item is not equipped");
		}
	}

	// TODO IF DRANK REMOVE FROM BACKPACK, RESTORE STORAGE
	// TODO FIX OVERHEALING
	public void consume(Consumable consumable) {
		int realHealingAmount;
		if (this.isItemInBackpack(consumable)) {// only possible if item is in players backpack
			if (consumable.getHealingAmount() < 0) {
				setHealth(getHealth() + consumable.getHealingAmount());
				System.out.println("You drank an " + consumable.getName() + " and dealt yourselfe "
						+ consumable.getHealingAmount() + " damage!");
				_backpack.remove(consumable);
				_backpackStorageInKg = _backpackStorageInKg - consumable.getWeight();
			} else if (getHealth() < getMaxHealth()) {// Here the healing happens
				if (getMaxHealth() - getHealth() < consumable.getHealingAmount()) {
					realHealingAmount = getMaxHealth() - getHealth();
				} else {
					realHealingAmount = consumable.getHealingAmount();
				}
				setHealth(getHealth() + consumable.getHealingAmount());
				if (getHealth() > getMaxHealth()) { // If Health is over maxhealth reduce to maxhealth
					setHealth(getMaxHealth());
				}
				_backpack.remove(consumable);
				_backpackStorageInKg = _backpackStorageInKg - consumable.getWeight();
				System.out.println(
						"You drank an " + consumable.getName() + " and healed yourself for " + realHealingAmount + ".");
			} else {
				System.out.println("You can't heal yourself when your health is full!");
			}
		} else {
			System.out.println("You don't have that Item in your Backpack!");
		}
	}

	public boolean isItemInBackpack(Consumable consumable) {
		return _backpack.contains(consumable);
	}

	public boolean isItemEquipped(Wearable wearable) {
		return _gear.containsKey(wearable.getName());
	}

	public boolean isBackpackFull() {
		return (_backpackStorageInKg >= _maxBackpackStorageInKg);
	}

	public boolean isBackpackEmpty() {
		return (_backpackStorageInKg < 1);
	}

	public boolean doesFitInBackpack(Consumable consumable) {
		return ((_backpackStorageInKg + consumable.getWeight()) <= _maxBackpackStorageInKg);
	}

	public void setMyPosition(Cell cell) {
		if (this.getMyPosition() == deathCell) {
			System.out.println("You can't go there. You are dead!");
			_myPosition = deathCell;
		} else {
			_myPosition = cell;
		}
	}

	public Cell getMyPosition() {
		return _myPosition;
	}

	public String getName() {
		return _name;
	}

	public int getHealth() {
		return _health;
	}

	public void setHealth(int health) {
		_health = health;
	}

	public int getMaxHealth() {
		return _maxHealth;
	}

	public float getBackpackStorageInKg() {
		return _backpackStorageInKg;
	}

	public void setBackpackStorageInKg(float backpackStorageInKg) {
		_backpackStorageInKg = backpackStorageInKg;
	}

	public float getMaxBackpackStorageInKg() {
		return _maxBackpackStorageInKg;
	}

	public void setMaxBackpackStorageInKg(float maxBackpackStorageInKg) {
		_maxBackpackStorageInKg = maxBackpackStorageInKg;
	}

	public Map<String, Wearable> getGear() {
		return _gear;
	}

	public ArrayList<Consumable> getBackpack() {
		return _backpack;
	}

}
