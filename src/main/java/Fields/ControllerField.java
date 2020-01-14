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
        int[] oof = new int[]{0,1,2,3,4,5};
        _fields = new ModelField[40];
        _fields[0] = new ModelStart("Start","Oof",);
        _fields[1] = new ModelEstate(new int[]{50,250,750,2250,4000,6000}, 1000,1200);
        _fields[2] = new ModelChanceField();
        _fields[3] = new ModelEstate(new int[]{50,250,750,2250,4000,6000}, 1000,1200);
        _fields[4] = new ModelIncomeTax();
        _fields[5] = new ModelFerry(500);
        _fields[6] = new ModelEstate(new int[]{100,600,1800,5400,8000,11000}, 1000,2000);
        _fields[7] = new ModelChanceField();
        _fields[8] = new ModelEstate(new int[]{100,600,1800,5400,8000,11000}, 1000,2000);
        _fields[9] = new ModelEstate(new int[]{100,600,1800,5400,8000,11000}, 1000,2000);
        _fields[10] = new ModelVisitJail();
        _fields[11] = new ModelEstate(new int[]{200,1000,3000,9000,12500,15000}, 2000,2800);
        _fields[12] = new ModelBrewery(100);
        _fields[13] = new ModelEstate(oof, 0);
        _fields[14] = new ModelEstate(oof, 0);
        _fields[15] = new ModelFerry(0);
        _fields[16] = new ModelEstate(oof, 0);
        _fields[17] = new ModelChanceField();
        _fields[18] = new ModelEstate(oof, 0);
        _fields[19] = new ModelEstate(oof, 0);
        _fields[20] = new ModelParking();
        _fields[21] = new ModelEstate(oof, 0);
        _fields[22] = new ModelChanceField();
        _fields[23] = new ModelEstate(oof, 0);
        _fields[24] = new ModelEstate(oof, 0);
        _fields[25] = new ModelFerry(0);
        _fields[26] = new ModelEstate(oof, 0);
        _fields[27] = new ModelEstate(oof, 0);
        _fields[28] = new ModelBrewery(0);
        _fields[29] = new ModelEstate(oof, 0);
        _fields[30] = new ModelGotoJail();
        _fields[31] = new ModelEstate(oof, 0);
        _fields[32] = new ModelEstate(oof, 0);
        _fields[33] = new ModelChanceField();
        _fields[34] = new ModelEstate(oof, 0);
        _fields[35] = new ModelFerry(0);
        _fields[36] = new ModelChanceField();
        _fields[37] = new ModelEstate(oof, 0);
        _fields[38] = new ModelIncomeTax();
        _fields[39] = new ModelEstate(oof, 0);
    }

    public int getFieldType(int fieldID){
      //  _fields[fieldID].
        return 1;
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
}
