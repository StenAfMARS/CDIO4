import java.io.*;
import java.util.*;

public class PropertySyncronicer {
    private String sharedPath;
    private String[] confiqsToSync;
    private Properties[] properties;

    public static void main(String[] args) {
        new PropertySyncronicer("LanguageFiles/", new String[]{"English", "Dansk"});
    }

    public PropertySyncronicer(String path, String[] properties){
        sharedPath = path;
        confiqsToSync = properties;
        load();
        syncProperties();
        save();
    }

    private void syncProperties(){
        Set<Object> fullSet = new HashSet<>();

        for (Properties property:properties) {
            fullSet = mergeSet(property.keySet(), fullSet);
        }

        for (Properties property:properties) {
            if (!property.keySet().equals(fullSet)) {
                for (Object key:fullSet) {
                    if (!property.containsKey(key))
                        property.setProperty((String) key, "");
                }
            }
        }
    }

    public static <T> Set<T> mergeSet(final Set<T> a, final Set<T> b)
    {
        return new HashSet<T>() {{
            addAll(a);
            addAll(b);
        } };
    }

    private File getResource(String resourcePath){
        /*File file = new File(
                    getClass().getClassLoader().getResource(sharedPath + confiqsToSync[i] + ".properties").getFile()
            );
            // this code edits the properties after builing, we want to edit the before building
            */
        File starting = new File(System.getProperty("user.dir") + "/src/main/resources/");
        File file = new File(starting,  resourcePath);
        return file;
    }

    private void load(){
        properties = new Properties[confiqsToSync.length];

        for (int i = 0; i < confiqsToSync.length; i++) {
            File file = getResource(sharedPath + confiqsToSync[i] + ".properties");

            Properties prop = new Properties(){
                @Override
                public synchronized Enumeration<Object> keys() {
                    return Collections.enumeration(new TreeSet<Object>(super.keySet()));
                }
            };

            try (InputStream input = new FileInputStream(file)) {
                // load a properties file
                prop.load(input);
            } catch (IOException ex) {
                //ex.printStackTrace();
            }

            properties[i] = prop;
        }
    }
    private void save(){
        for (int i = 0; i < properties.length; i++) {
            File file = getResource(sharedPath + confiqsToSync[i] + ".properties");

            try (OutputStream output = new FileOutputStream(file)) {
                properties[i].store(output, null);
            } catch (IOException io) {
                io.printStackTrace();
            }
        }
    }
}
