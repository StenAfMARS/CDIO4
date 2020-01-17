package Chancecard;

 class ModelMoveTo extends ModelChanceCard {
    private int[] _destination;

     /**
      * Modelmoveto() used to mmake a model for a chance card where you have to move to a given destination.
      * @param desitnation the destination for a given chance card.
      */
     ModelMoveTo(int[] desitnation){
        _destination = desitnation;
    }

     /**
      * get_destination() used to
      * @return private attribute _destination.
      */
     int[] get_destination() {
        return _destination;
    }
}
