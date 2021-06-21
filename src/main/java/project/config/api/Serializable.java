package project.config.api;

import java.util.HashMap;

public interface Serializable {
    /**
     * Serialize an Object to a HashMap
     * @return the Object as a HashMap
     */
    HashMap<String, Storage> serialize();

    /**
     * Deserialize from a HashMap
     * If the Object is already fully initialized, throw an InvalidStateException
     * @param map the map to deserialize from
     * @return the deserialized Object
     */
    @Deprecated
    Serializable readFrom(HashMap<String, Storage> map);

    String getIdentifier();
}
