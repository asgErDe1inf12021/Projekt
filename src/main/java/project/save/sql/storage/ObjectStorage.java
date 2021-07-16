package project.save.sql.storage;

import project.save.api.Serializable;
import project.save.api.Storage;

import java.util.HashMap;

public class ObjectStorage extends Storage {
    private final HashMap<String, Storage> serializedObject;
    private final String identifier;

    public ObjectStorage(String identifier, Serializable serializable) {
        serializedObject = serializable.serialize();
        this.identifier = identifier;
    }

    @Override
    public HashMap<String, Storage> read() {
        return serializedObject;
    }

    public String getIdentifier() {
        return identifier;
    }
}
