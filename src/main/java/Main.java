import Fields.ModelFerry;
import Fields.ModelProperty;
import gui_main.GUI;
import Language.LanguageManager;

public class Main {
    public static void main(String[] args) {
        LanguageManager.get().setLanguage("English");
        System.out.println(LanguageManager.get().getString("helloWorld"));
        LanguageManager.get().setLanguage("Dansk");
        System.out.println(LanguageManager.get().getString("helloWorld"));

        GUI gui = new GUI();
    }
}
