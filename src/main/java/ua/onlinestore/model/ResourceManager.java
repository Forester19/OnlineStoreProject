package ua.onlinestore.model;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Владислав on 17.11.2017.
 */
public enum ResourceManager {
    INSTANCE;
    private ResourceBundle resourceBundle;
    private final String resourceName = "property.text";

    private ResourceManager() {
     resourceBundle = ResourceBundle.getBundle(resourceName, Locale.getDefault());
    }
    public void changeResource(Locale locale){
        resourceBundle = ResourceBundle.getBundle(resourceName, locale);
    }
    public String getString(String key){
        return resourceBundle.getString(key);
    }
}
