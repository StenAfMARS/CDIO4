package Chancecard;

 class ModelMoveTo extends ModelChanceCard {
    private int[] _destination;
     ModelMoveTo(int[] desitnation){
        _destination = desitnation;
    }

     int[] get_destination() {
        return _destination;
    }
}
