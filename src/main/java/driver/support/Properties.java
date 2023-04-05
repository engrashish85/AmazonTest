package driver.support;

import files.util.Globals;
import util.PropertyFileReader;

import java.io.IOException;
import java.util.Map;

public class Properties {
    private static Map<String, String> config;
    private static String browserName = null;
    private static String applicationUrl = null;

    public Properties() {
        try {
            Properties.config = PropertyFileReader.readProperties(Globals.CONFIG_LOCATION.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Properties.applicationUrl = Properties.config.get("applicationUrl");
        Properties.browserName = Properties.config.get("browser");
    }

    public String getBrowserName() {
        return Properties.browserName;
    }

    public String getApplicationUrl() {
        return Properties.applicationUrl;
    }

}
