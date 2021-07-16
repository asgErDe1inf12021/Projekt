package project.save.sql.storage.primitive;

import project.save.sql.storage.PrimitiveStorage;

public class BooleanStorage extends PrimitiveStorage {

    private final boolean b;

    public BooleanStorage(boolean b) {
        this.b = b;
    }

    public Boolean read() {
        return b;
    }
}
