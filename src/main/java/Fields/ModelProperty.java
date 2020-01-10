package Fields;

public abstract class ModelProperty extends ModelField {
    private int _propertyPrice;
    private int _mortgage;

    public int get_propertyPrice() {
        return _propertyPrice;
    }
    public void set_propertyPrice(int _propertyPrice) {
        this._propertyPrice = _propertyPrice;
    }

    public int get_mortgage() {
        return _mortgage;
    }
    public void set_mortgage(int _mortgage) {
        this._mortgage = _mortgage;
    }

    /**
     * @return The rent to be paid when landing on the property.
     */
    public abstract int get_rent();
}
