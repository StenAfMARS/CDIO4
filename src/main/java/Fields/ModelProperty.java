package Fields;

import java.awt.*;

abstract class ModelProperty extends ModelField {
    private int _propertyPrice;
    private int _mortgage;
    private int _owner;

    public ModelProperty(String name, Color backgroundColor,int propertyPrice, int mortgage) {
        super(name,backgroundColor);
        this._propertyPrice = propertyPrice;
        this._mortgage = mortgage;
        this._owner = -1;
    }

    int get_propertyPrice() {
        return _propertyPrice;
    }
     void set_propertyPrice(int _propertyPrice) {
        this._propertyPrice = _propertyPrice;
    }

     int get_mortgage() {
        return _mortgage;
    }
     void set_mortgage(int _mortgage) {
        this._mortgage = _mortgage;
    }

    /**
     * @return The rent to be paid when landing on the property.
     */
     abstract int get_rent();

     int get_owner() {
        return _owner;
    }
     void set_owner(int _owner) {
        this._owner = _owner;
    }
    boolean isOwned(){
         return _owner != -1;
    }
}
