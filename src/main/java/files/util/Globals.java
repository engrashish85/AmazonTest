package files.util;

import java.io.File;

/**
 * global variables for projects
 */
public enum Globals {

    /**
     * root directory path for the project
     */
    PROJECT_PATH() {
        @Override
        public String toString() {
            return System.getProperty("user.dir");
        }
    },


    CONFIG_LOCATION() {
        @Override
        public String toString() {
            StringBuilder path= new StringBuilder();
            path.append(Globals.PROJECT_PATH.toString()).append("/src/main/resources/config/config");
            path.append(".properties");
            return path.toString();
        }
    },

    REPORT_CONFIG_PATH() {
        @Override
        public String toString() { return Globals.CONFIG_LOCATION.toString().substring(0, Globals.CONFIG_LOCATION.toString().
                lastIndexOf(File.separator)) + "/extent-config.xml"; }
    }

}
