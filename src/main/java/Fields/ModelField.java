package Fields;

import java.awt.*;

public abstract class ModelField {
    private String _title;
    private String _subtext;
    private String _description;
    private Color _backgroundColor;

    public String get_title() {
        return _title;
    }
    public void set_title(String _title) {
        this._title = _title;
    }

    public String get_subtext() {
        return _subtext;
    }
    public void set_subtext(String _subtext) {
        this._subtext = _subtext;
    }

    public String get_description() {
        return _description;
    }
    public void set_description(String _description) {
        this._description = _description;
    }

    public Color get_backgroundColor() {
        return _backgroundColor;
    }
    public void set_backgroundColor(Color _backgroundColor) {
        this._backgroundColor = _backgroundColor;
    }
}
