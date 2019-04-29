package at.fhv.oo;

public abstract class Item {
    protected String _name;
    protected float _weight;
    protected String _description;

    public Item(String name, float weight, String description) {
        _name = name;
        _weight = weight;
        _description = description;
    }


    public float getWeight() {
        return _weight;
    }


    public String getName(){ return _name;}

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    @Override
    public String toString() {
        return _name +
                ", it weights " + _weight + " Kg. Do you want to pick it up? \n"
                ;
    }
}
