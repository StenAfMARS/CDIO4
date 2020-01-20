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

    /**
     * Constructer, The language is english by default
     */
    private LanguageManager() {
        //Sets the default language
        setLanguage("English");
    }

    /**
     * Singleton get methoed
     * @return The instance of the languageManager
     */
    public static LanguageManager get()
    {
        //If there isn't an instance, make one
        if (_instance == null) {
            _instance = new LanguageManager();
        }

        //Return the instance
        return _instance;
    }

    /**
     * Sets the language of the languagemanager
     * @param newLanguage The new language, not case  sensitive
     */
    public void setLanguage(String newLanguage){
        //Find the language the newlanguage matches
        for (String language : _languages) {
            if (language.equalsIgnoreCase(newLanguage)) {
                _currentLanguage = language;
                break;
            }
        }

        //Creates a property object
        Properties prop = new Properties();

        try {
            //Loads the properties from a languagefile
            prop.load(ClassLoader.getSystemResourceAsStream("LanguageFiles/" + _currentLanguage + ".properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        _loadedText = prop;
    }

    /**
     *
     * @return List of possible languages
     */
    public String[] getLanguages(){
        return _languages.clone();
    }

    /**
     * Translates a property to the current language
     * @param property the property to get
     * @return the translatet property
     */
    public String getString(String property){
        String returnValue = _loadedText.getProperty(property);

        //Null safety, prints what property didn't exist
        if (returnValue == null) {
            returnValue = " ";
            System.out.println("WARNING: You tried to load a language property that doesn't exist. You tried to load: " + property);
        }
        //Empty safety, needed because the GUI can crash with empty strings
        else if (returnValue.equals("")) {
            returnValue = " ";
            System.out.println("WARNING: You tried to load a language property that is empty. You tried to load: " + property);
        }

        return returnValue;
    }
    /**
     * Translates a property to the current language and formats it with messageformat
     * @param property the property to get
     * @param args The arguments to replace {0}, {1}... {n} with
     * @return the translatet property
     */
    public String getString(String property, Object... args){
        //Formats the translated string
        return MessageFormat.format(getString(property), args);
    }
}
