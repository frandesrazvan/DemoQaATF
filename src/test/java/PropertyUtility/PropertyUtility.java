package PropertyUtility;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;

public class PropertyUtility {

    private Properties properties;

    public PropertyUtility(String fileName) {
        loadFile(fileName);
    }

    //facem o metoda care sa incarce un fisier
    @SneakyThrows(Exception.class)
    private void loadFile(String fileName) {
        properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/" + fileName + ".properties");
        properties.load(fileInputStream);
    }

    //facem o metoda ca returneaza toate datele dintr-un fisier
    public HashMap<String, String> getAllData() {
        HashMap<String, String> testData = new HashMap<>();

        for (String key : properties.stringPropertyNames()) {
            testData.put(key, properties.getProperty(key));
        }

        return testData;
    }
}
