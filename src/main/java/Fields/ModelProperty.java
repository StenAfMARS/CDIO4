package Fields;

import java.awt.*;

abstract class ModelProperty extends ModelField {
    private int _propertyPrice;
    private int _mortgage;
    private int _owner;

    /**
     * ModelProperty used to make a model for a property field.
     * @param name name of the field.
     * @param backgroundColor background color of a field.
     * @param propertyPrice property price for a field.
     * @param mortgage mortgage of a field.
     */
    public ModelProperty(String name, Color backgroundColor,int propertyPrice, int mortgage) {
        super(name,backgroundColor);
        this._propertyPrice = propertyPrice;
        this._mortgage = mortgage;
        this._owner = -1;
    }

    /**
     * get_propertyPrice() used to get the price of a property.
     * @return private attribute _propertyPrice
     */
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
     * get_rent() used to
     * @return The rent to be paid when landing on the property.
     */
     abstract int get_rent();

    /**
     * get_owner() used to
     * @return _owner of a field.
     */
     int get_owner() {
        return _owner;
    }

    /**
     * set_owner() used to set owner of a field.
     * @param _owner
     */
     void set_owner(int _owner) {
        this._owner = _owner;
    }

    /**
     * isOwned() used to check if a field is owned.
     * @return private attribute _owner.
     */
    boolean isOwned(){
         return _owner != -1;
    }
}
