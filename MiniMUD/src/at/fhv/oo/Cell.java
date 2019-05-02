package at.fhv.oo;

import java.util.ArrayList;

public abstract class Cell {

    protected DoorStatus _doorStatus;
    protected String _name;
    protected Item _item = null;
    private Cell[] _neighboring = new Cell[4];
    private ArrayList<Player> _players = new ArrayList<>();

    protected Cell(String name) {
        _name = name;
    }

    public void setNeighbor(Direction dir, Cell cell) {
        _neighboring[dir.ordinal()] = cell;
    }

    public Cell getNeighbor(Direction dir) {
        return _neighboring[dir.ordinal()];
    }

    public Cell[] getNeighbors(){
        return _neighboring;
    }

    //For the One player which is moving
    public void setPlayer(Player player) {
        _players.add(player);
        player.setMyPosition(this);

    }

    public void removePlayer(Player player) {
        _players.remove(player);
        player.setMyPosition(null);

    }


    public void setItemOnField(Item item){
        _item = item;
    }

    public Item getItemOnField(){
        return _item;
    }

    public DoorStatus getDoorStatus() {
        return _doorStatus;
    }

    public abstract void enter(Direction direction, Player player);

    //public boolean isFreeForPlayer() {
    //    return (_playerOnCell == null);
    //}

    /**
     * All this beneath are for Output
     *
     * @return
     */
    public void getInfoPlayersOnField(){//TODO FIX THIS FOR EACH
    	System.out.print("Players on Field: ");
		_players.forEach(Player -> {
			if(Player.getMyPosition() == this) {
				System.out.print('[' + Player.getName() + "] ");}
		
		});
		System.out.println("\n-----------------------------------------------");}
		

    //public String getInfoPlayersOnField(){
    //    if(_players.size() > 0) {//for 1 Player on field
    //        return "Ohh, " +
    //                (_players.size() +
    //                " other Player is also on " +
    //                toString() + '\n';
    //    }
    //    if(_players.size()> 1) {//For Mutlpiple Players on field
    //        return "Ohh, " +
    //                (_players.size() +
    //                " other Players are also on " +
    //                toString() + '\n';
    //    }
    //    return "";
    //}
    public String getCellInfo() {
        return toString();
    }


    @Override
    public String toString() {
        return _name;
    }
}
