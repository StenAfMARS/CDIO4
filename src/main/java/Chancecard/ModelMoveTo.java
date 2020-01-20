package Chancecard;

 class ModelMoveTo extends ModelChanceCard {
    private int[] _destination;
     ModelMoveTo(int iD, int[] desitnation){
         super(iD);
        _destination = desitnation;
    }

     int[] get_destination() {
        return _destination;
    }
}
