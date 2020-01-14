package Fields;

import java.awt.*;

public class ModelBrewery extends ModelProperty {
    private int _rent;

    /**Creates an instance of ModelBrewery
     * @param rent The "rent" of the brewery
     */
    public ModelBrewery(String name, Color backgroundColor, int propertyPrice, int rent) {
        super(name,backgroundColor,propertyPrice,propertyPrice/2,0);
        // make sure rent is positive
        _rent = Math.max(rent, 0);
    }

    @Override
    public int get_rent() {
        return _rent;
    }
}
