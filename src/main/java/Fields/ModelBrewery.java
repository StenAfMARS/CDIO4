package Fields;

import java.awt.*;

public class ModelBrewery extends ModelProperty {
    private int _rent;

    /**Creates an instance of ModelBrewery
     * @param rent The "rent" of the brewery
     */
    public ModelBrewery(String title, String subtext, String description, Color backgroundColor, int propertyPrice, int mortgage, int owner, int rent) {
        super(title,subtext,description,backgroundColor,propertyPrice,mortgage,owner);
        // make sure rent is positive
        _rent = Math.max(rent, 0);
    }

    @Override
    public int get_rent() {
        return _rent;
    }
}
