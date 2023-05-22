package Utils;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class SettingsReader {
    static ISettingsFile environment = new JsonSettingsFile("Config.json");
    static ISettingsFile environment1 = new JsonSettingsFile("test_data.json");
    public static String readUrlJson(String value){
        return environment.getValue("/"+value).toString();
    }
    public static int readJsonInt(String value){
        return (int) environment.getValue("/"+value);
    }
    public static String readDataJson(String value){
        return environment1.getValue("/"+value).toString();
    }
}
