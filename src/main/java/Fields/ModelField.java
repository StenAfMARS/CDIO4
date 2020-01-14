package Fields;

import java.awt.*;

 abstract class ModelField {
    private String _title;
    private String _subtext;
    private String _description;
    private Color _backgroundColor;

    protected ModelField(String title, String subtext, String description, Color backgroundColor){
        this._title = title;
        this._subtext = subtext;
        this. _description = description;
        this._backgroundColor = backgroundColor;
    }

     String get_title() {
        return _title;
    }
     void set_title(String _title) {
        this._title = _title;
    }

     String get_subtext() {
        return _subtext;
    }
     void set_subtext(String _subtext) {
        this._subtext = _subtext;
    }

     String get_description() {
        return _description;
    }
     void set_description(String _description) {
        this._description = _description;
    }

     Color get_backgroundColor() {
        return _backgroundColor;
    }
     void set_backgroundColor(Color _backgroundColor) {
        this._backgroundColor = _backgroundColor;
    }
}
