package project.config.implementation.storage.primitive;

import project.config.implementation.storage.PrimitiveStorage;

public class BooleanStorage extends PrimitiveStorage {

    private final boolean b;

    public BooleanStorage(boolean b) {
        this.b = b;
    }

    public Boolean read() {
        return b;
    }
}
