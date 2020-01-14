package Fields;

import java.awt.*;

class ModelFerry extends ModelProperty {
    private int _rent;

    /**Creates an instance of ModelFerry
     * @param rent The "rent" of the ferry
     */
     ModelFerry(String title, String subtext, String description, Color backgroundColor, int propertyPrice, int mortgage, int owner,int rent) {
         super(title,subtext,description,backgroundColor,propertyPrice,mortgage,owner);

         // make sure rent is positive
        _rent = Math.max(rent, 0);
    }

    @Override
     int get_rent() {
        return _rent;
    }
}
