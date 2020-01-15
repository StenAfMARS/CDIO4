package Fields;

public class ControllerField {
    private ModelField[] _fields;

    private static ControllerField _instance;

    public static ControllerField get()
    {
        if (_instance == null) {
            _instance = new ControllerField();
        }
        return _instance;
    }

    private ControllerField(){

    }

    public void createBoard (){
        _fields = new ModelField[40];
        for (int i = 0; i < _fields.length; i++) {
            //All fields are currently estates. Will be changed in later iteration.
            new ModelEstate(new int[]{1,2,3,4,5,6}, 1);
        }
    }
    
    public String getFieldTitle (int fieldID) {
        if (0 > fieldID || fieldID >= _fields.length){
            System.out.println("WARNING: ControllerField, getFieldTitle, fieldID out of boundary.");
            return "";
        }

        ModelField field = _fields[fieldID];
        return field.get_title();

    }
    public String getFieldSubtext (int fieldID){
        if (0 > fieldID || fieldID >= _fields.length){
            System.out.println("WARNING: ControllerField, getFieldSubtext, fieldID out of boundary.");
            return "";
        }
        ModelField field = _fields[fieldID];
        return field.get_subtext();
    }
    public String getFieldDescription (int fieldID){
        if (0 > fieldID || fieldID >= _fields.length){
            System.out.println("WARNING: ControllerField, getFieldDescription, fieldID out of boundary.");
            return "";
        }
        ModelField field = _fields[fieldID];
        return field.get_description();
    }

    public int getPropertyPrice(int fieldID){
        if (0 > fieldID || fieldID >= _fields.length){
            System.out.println("WARNING: ControllerField, getFieldPrice, fieldID out of boundary.");
            return 0;
        }

        if (!(_fields[fieldID] instanceof ModelProperty)){
            System.out.println("WARNING: ControllerField, getFieldPrice, fieldID not a property.");
            return 0;
        }

        return ((ModelProperty)_fields[fieldID]).get_propertyPrice();
    }

    public void setPropertyOwner(int fieldID, int playerID){
        if (0 > fieldID || fieldID >= _fields.length){
            System.out.println("WARNING: ControllerField, setPropertyOwner, fieldID out of boundary.");
            return;
        }

        if (!(_fields[fieldID] instanceof ModelProperty)){
            System.out.println("WARNING: ControllerField, setPropertyOwner, fieldID not a property.");
            return;
        }

        ((ModelProperty)_fields[fieldID]).set_owner(playerID);
    }
    public int getFieldLength (){
        return this._fields.length;
    }
    private int[] _ownedField;
    public int[] getOwnedField(int playerID){
        for (int i = 0; i<= 40; i++){
            int fieldID = i;

            if(((ModelProperty)_fields[fieldID]).get_owner() == playerID){
                _ownedField[i] =  fieldID;
            }
        }

        return _ownedField;
    }
    private int _HotelCount;

    public int getHotelCount(int playerID)
    {
        for(int i = 0; i<= 40; i++){
            int fieldID = i;

            if(((ModelProperty)_fields[fieldID]).get_owner() == playerID && ((ModelEstate)_fields[fieldID]).get_amountOfHouses() == 5 ){
                _HotelCount = _HotelCount + ((ModelEstate)_fields[fieldID]).get_amountOfHouses();
            }
        }
        return _houseCount;
    }

    private int _houseCount;
    public int getHouseCount(int playerID)
    {
     for(int i = 0; i<= 40; i++){
        int fieldID = i;

        if(((ModelProperty)_fields[fieldID]).get_owner() == playerID && ((ModelEstate)_fields[fieldID]).get_amountOfHouses() != 5 ){
            _houseCount = _houseCount + ((ModelEstate)_fields[fieldID]).get_amountOfHouses();
        }
     }
        return _houseCount;
    }
}
