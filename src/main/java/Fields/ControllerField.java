package Fields;

public class ControllerField {
    private ModelField[] _fields;
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
    public int getFieldLength (){
        return this._fields.length;
    }
}
