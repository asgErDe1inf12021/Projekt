package project.config.api;

import java.util.HashMap;

public interface Serializable {
    HashMap<String, Storage> serialize();
    Serializable readFrom(HashMap<String, Storage> map);
}
