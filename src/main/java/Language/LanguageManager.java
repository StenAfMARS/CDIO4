package Language;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

public class LanguageManager {
    private static final String[] _languages = new String[] {"English", "Dansk"};

    private static LanguageManager _instance;
    private Properties _loadedText;
    private String _currentLanguage;

    private LanguageManager() {
        setLanguage("English");
    }

    public static LanguageManager get()
    {
        if (_instance == null) {
            _instance = new LanguageManager();
        }
        return _instance;
    }

    public void setLanguage(String newLanguage){

        for (String language : _languages) {
            if (language.equalsIgnoreCase(newLanguage)) {
                _currentLanguage = newLanguage;
                break;
            }
        }

        Properties prop = new Properties();

        try {
            prop.load(ClassLoader.getSystemResourceAsStream("LanguageFiles/" + _currentLanguage + ".properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        _loadedText = prop;
    }
    public String[] getLanguages(){
        return _languages.clone();
    }

    public String getString(String property){
        String returnValue = _loadedText.getProperty(property);
        if (returnValue == null) {
            returnValue = " ";
            System.out.println("WARNING: You tried to load a language property that doesn't exist. You tried to load: " + property);
        }
        else if (returnValue.equals("")) {
            returnValue = " ";
            System.out.println("WARNING: You tried to load a language property that is empty. You tried to load: " + property);
        }
        return returnValue;
    }
    public String getString(String property, Object... args){
        return MessageFormat.format(getString(property), args);
    }
}
