package project.save.sql.storage;

import project.save.api.Serializable;
import project.save.api.Storage;

import java.util.HashMap;

public class ObjectStorage extends Storage {
    private final HashMap<String, Storage> serializedObject;
    private final String className;

    public ObjectStorage(Serializable serializable, String className) {
        serializedObject = serializable.serialize();
        this.className = className;
    }

    @Override
    public HashMap<String, Storage> read() {
        return serializedObject;
    }

    public String getClassName() {
        return className;
    }
}
