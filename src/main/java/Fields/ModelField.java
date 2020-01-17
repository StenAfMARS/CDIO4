package Fields;

import java.awt.*;

 abstract class ModelField {
    private String _name;
    private Color _backgroundColor;

     /**
      * ModelField used to find the name and backgroundColor for a given field.
      * @param name the name of the field.
      * @param backgroundColor the background color of the field.
      */
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

     /**
      * get_name() used to
      * @return private attribute _name.
      */
     public String get_name() {
         return _name;
     }
 }
