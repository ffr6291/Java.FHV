package at.fhv.oo;

public abstract class Wearable extends Item {

    public Wearable(String name,float weight, String description){
        super(name, weight, description); //super hier weil Oberklasse keinen defaultkonstruktor hat
    }
}
