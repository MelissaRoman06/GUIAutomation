package theNinjaStore.ui.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class NinjaStoreConfig {
    private String email;
    private String password;
    private static NinjaStoreConfig ninjaStoreConfigInstance;

    /**
     * Constructor NinjaStoreConfig.
     */
    protected NinjaStoreConfig() {
        readProperties();
    }

    /**
     * Gets the instance of WebDriverConfig.
     *
     * @return configInstance.
     */
    public static NinjaStoreConfig getInstance() {
        if (ninjaStoreConfigInstance == null) {
            ninjaStoreConfigInstance = new NinjaStoreConfig();
        }
        return ninjaStoreConfigInstance;
    }

    /**
     * Reads properties file for Web Driver waits' config.
     */
    public void readProperties() {
        try (InputStream input = new FileInputStream("ninjaStore.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            email = properties.getProperty("email");
            password = properties.getProperty("password");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
