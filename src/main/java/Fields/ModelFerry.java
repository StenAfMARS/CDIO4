package Fields;

import java.awt.*;

class ModelFerry extends ModelProperty {
    private int _rent;

    /**Creates an instance of ModelFerry
     * @param rent The "rent" of the ferry
     */
     ModelFerry(String name, Color backgroundColor, int propertyPrice,int rent) {
         super(name,backgroundColor,propertyPrice,propertyPrice/2,0);

         // make sure rent is positive
        _rent = Math.max(rent, 0);
    }

    @Override
     int get_rent() {
        return _rent;
    }
}
