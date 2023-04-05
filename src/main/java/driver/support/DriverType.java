package driver.support;

import org.openqa.selenium.WebDriver;

public enum DriverType {

    CHROME("CHROME") {
        @Override
        public WebDriver getDriver() {
            AbstractDriverFactory chrome = new ChromeDriverFactory();
            return chrome.getDriver();
        }
    },

    EDGE ( "EDGE") {
        @Override
        public WebDriver getDriver() {
            AbstractDriverFactory edge = new EdgeDriverFactory();
            return edge.getDriver();
        }
    };

    private String name;
    private DriverType(String name) { this.name = name; }
    public String getName() { return name; }
    public abstract WebDriver getDriver();

}
