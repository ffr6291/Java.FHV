package at.fhv.oo;

public class Weapon extends Wearable {

    private int _damage;
    private int _range;
    private Field _position;

    public Weapon(String name, float weight, String description, int damage, int range, Field position) {
        super(name, weight, description);
        _damage = damage;
        _range = range;
        _position = position;
        position.setItemOnField(this);
    }



    public int getDamage() {
        return _damage;
    }

    public void setDamage(int damage) {
        _damage = damage;
    }

    public int getRange() {
        return _range;
    }

    public void setRange(int range) {
        _range = range;
    }

    public Field getPosition() {
        return _position;
    }

    public void setPosition(Field position) {
        _position = position;
    }

    public String getWeaponInfo() {
        return "This is a " + _name +
                ", it weights " + _weight +
                ", makes " + _damage +
                " damage and has a range of " + _range +
                "fields. Description: " + _description +
                '.';
    }
}
