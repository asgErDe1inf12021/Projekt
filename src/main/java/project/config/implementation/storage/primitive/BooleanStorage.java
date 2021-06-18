package project.config.implementation.storage.primitive;

import project.config.api.Storage;

public class BooleanStorage extends Storage {

    private final boolean b;

    public BooleanStorage(boolean b) {
        this.b = b;
    }

    public Boolean read() {
        return b;
    }
}
