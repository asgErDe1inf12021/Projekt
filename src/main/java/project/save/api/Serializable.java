package project.save.api;

import java.util.HashMap;

public interface Serializable {
    /**
     * Serialize an Object to a HashMap
     * @return the Object as a HashMap
     */
    HashMap<String, Storage> serialize();

    String getClassName();
}
