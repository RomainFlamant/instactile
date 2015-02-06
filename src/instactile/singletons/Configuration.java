/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instactile.singletons;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.ini4j.Wini;

/**
 * This singleton class allows easy access to the config/settings.ini file.
 * @author Vincent Courtois <vincent.courtois@mycar-innovations.com>
 */
public class Configuration {
    
    /**
     * Main method to use. Keys can be passed as simple string, or dot (".") separated strings in the case of the access to a categorized key.
     * @param key the key to access in the configuration file.
     * @return the value of the configuration key as an object. Don't forget to cast it.
     */
    public static Object getKey(String key) {
        Object returnedValue = null;
        try {
            returnedValue = getInstance().getInternalKey(key);
        } catch (IOException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnedValue;
    }
    
    /** PRIVATE REPRESENTATION */
    
    /** Internal instance used for singleton purpose */
    private static Configuration instance;
    /** Inner representation of the INI file. */
    private final Wini innerRepresentation;
    
    /**
     * Constructor of a configuration for a given filename.
     * @param filename the name of the configuration file to open.
     * @throws IOException an exception if the opening of the file fails.
     */
    private Configuration(String filename) throws IOException {
        innerRepresentation = new Wini(new File("config/settings.ini"));
    }
    
    /**
     * Singleton method.
     * @return the singleton instance of the configuration.
     * @throws IOException an exception if the opening of the file fails when it's not yet opened.
     */
    private static Configuration getInstance() throws IOException {
        if(instance == null) instance = new Configuration("config/settings.ini");
        return instance;
    }
    
    /**
     * Gets the internal value of a given key, in the opened INI file.
     * @param key the key to search in the ININ file, to see rules about format, see {@link Configuration#getKey(java.lang.String) Configuration.getKey}.
     * @return the value of the key as an object, don't forget to cast it.
     */
    private Object getInternalKey(String key) {
        Object result;
        if(Pattern.matches("^.+[.]{1}.+$", key)) {
            String[] split = key.split("\\.");
            result = innerRepresentation.get(split[0]).get(split[1]);
        }
        else {
            result = innerRepresentation.get(key);
        }
        return result;
    }
}
