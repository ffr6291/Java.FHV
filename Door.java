package at.fhv.oo;

public class Door extends Cell {



    /**
     * Here you can create a Door
     * @param name Name of the Door matching to the keys
     * @param doorStatus Door can be CLOSED or OPENED
     */
    public Door(String name , DoorStatus doorStatus) {
        super(name);
        _doorStatus = doorStatus;
    }

    @Override
    public void enter(Direction dir, Player player) {
        Cell destinationCell = getNeighbor(dir);

        if (getDoorStatus().equals(DoorStatus.CLOSED)) {
            System.out.println("The door is locked, find a key first!");
        }

        if(getDoorStatus().equals(DoorStatus.OPENED)){
                System.out.println("You entered through the door.\n");
                removePlayer(player);
                destinationCell.setPlayer(player);
        }
        System.out.println(destinationCell.getCellInfo());
    }


    public void openDoor() {
        _doorStatus = DoorStatus.OPENED;
    }

    public void closeDoor(){
        _doorStatus = DoorStatus.CLOSED;
    }


    @Override //TODO ASK why i need this override here.
    public String toString() {
        return _name + " " ; //TODO ad where the door leads to
    }
}
