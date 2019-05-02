package at.fhv.oo;

public class Consumable extends Item {

    private int _healingAmount;
    private Field _position;

    public Consumable(String name, float weight, int healingAmount, String description, Field position) {
        super(name, weight, description);
        _healingAmount = healingAmount;
        _position = position;
        _position.setItemOnField(this);

    }




    public int getHealingAmount() {
        return _healingAmount;
    }


}

