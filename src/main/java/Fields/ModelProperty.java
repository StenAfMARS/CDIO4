package Fields;

 abstract class ModelProperty extends ModelField {
    private int _propertyPrice;
    private int _mortgage;
    private int _owner;

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
}
