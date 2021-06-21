package project.config.implementation.storage;

import project.config.api.Serializable;
import project.config.api.Storage;

import java.util.HashMap;

public class ObjectStorage extends Storage {
    private final HashMap<String, Storage> serializedObject;
    private final String identifier;

    public ObjectStorage(String identifier, Serializable serializable) {
        serializedObject = serializable.serialize();
        this.identifier = identifier;
    }

    protected HashMap<String, Storage> getSerializedObject() {
        return serializedObject;
    }

    @Override
    public HashMap<String, Storage> read() {
        return serializedObject;
    }

    public String getIdentifier() {
        return identifier;
    }
}
