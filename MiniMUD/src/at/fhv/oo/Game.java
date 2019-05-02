package at.fhv.oo;

public class Game {

    public static void main(String[] args) {


        Wall wall = new Wall("Wall"){};
        Door door1 = new Door("Door", DoorStatus.OPENED){};
        
        
        Field startingCell = new Field(1, "Church","This is a holy place");
        Field field2 = new Field(2,"School", "Place to learn");
        Field field3 = new Field(3, "Dragonscave", "Elderdragon lives here");
        Field field4 = new Field(4, "Beartrap", "Here is a beartrap");
        Field field5 = new Field(5, "Waterfall", "Here is a waterfall");
        
        startingCell.setNeighbor(Direction.EAST,field2);
        startingCell.setNeighbor(Direction.SOUTH,field4);
        startingCell.setNeighbor(Direction.WEST,null);

        field2.setNeighbor(Direction.NORTH,null);
        field2.setNeighbor(Direction.EAST,door1);
        field2.setNeighbor(Direction.SOUTH,field5);
        field2.setNeighbor(Direction.WEST,startingCell);

        door1.setNeighbor(Direction.EAST,field3);
        door1.setNeighbor(Direction.WEST,field2);

        field3.setNeighbor(Direction.NORTH,wall);
        field3.setNeighbor(Direction.EAST,wall);
        field3.setNeighbor(Direction.SOUTH,wall);
        field3.setNeighbor(Direction.WEST,door1);

        field4.setNeighbor(Direction.NORTH,startingCell);
        field4.setNeighbor(Direction.EAST,field5);
        field4.setNeighbor(Direction.SOUTH,wall);
        field4.setNeighbor(Direction.WEST,wall);

        field5.setNeighbor(Direction.NORTH,field2);
        field5.setNeighbor(Direction.EAST,wall);
        field5.setNeighbor(Direction.SOUTH,null);
        field5.setNeighbor(Direction.WEST,field4);

        Weapon Sword = new Weapon("Sword", 2, "Its a heavy two-handed sword which can damage players on your field",100, 0,field2);
        Consumable HealingPotion = new Consumable("Healingpotion", 0.5f, 50, "This item heals the Player for 50.", field3);
        Consumable HealPot = new Consumable("Healpot", 1.2f, 40, "Heals for 40", field4);
        Consumable Alkopop = new Consumable("Alkopop", 2.0f, -50, "Deals 50 damage and makes you dizzy!", field5);

        Player Despot = new Player("Despot");
        Player Fabian = new Player("Fabian");
        Player Mario = new Player("Mario");
        Player Nico = new Player("Nico");

        Despot.joinGame(startingCell, Despot);
        Fabian.joinGame(startingCell, Fabian);
        Mario.joinGame(startingCell, Mario);
        Nico.joinGame(startingCell, Nico);
        
        startingCell.getInfoPlayersOnField();
        Despot.enter(Direction.EAST);
        field2.getInfoPlayersOnField();
        startingCell.getInfoPlayersOnField();
        field4.getInfoPlayersOnField();
        
        
        
       
        
        
        
        
        
       
      
        
        
        
        
        
      
        
        
        	
    
        
      







    }
}
