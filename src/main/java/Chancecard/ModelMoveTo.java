package Chancecard;

public class ModelMoveTo extends ModelChanceCard {
    private int[] _destination;
    public ModelMoveTo(int[] desitnation){
        _destination = desitnation;
    }

    public int[] get_destination() {
        return _destination;
    }
}
