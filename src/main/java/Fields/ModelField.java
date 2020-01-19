package Fields;

import java.awt.*;

 abstract class ModelField {
    private String _name;
    private Color _backgroundColor;

    protected ModelField(String name, Color backgroundColor){
        this._name = name;
        this._backgroundColor = backgroundColor;
    }

     Color get_backgroundColor() {
        return _backgroundColor;
    }
     void set_backgroundColor(Color _backgroundColor) {
        this._backgroundColor = _backgroundColor;
    }

     public String get_name() {
         return _name;
     }
 }
