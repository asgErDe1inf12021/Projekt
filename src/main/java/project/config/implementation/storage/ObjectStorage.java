package project.config.implementation.storage;

import project.config.api.Serializable;
import project.config.api.Storage;

import java.util.HashMap;

class ObjectStorage {
    private final HashMap<String, Storage> serializedObject;

    public ObjectStorage(Serializable serializable) {
        serializedObject = serializable.serialize();
    }

    protected HashMap<String, Storage> getSerializedObject() {
        return serializedObject;
    }
}
