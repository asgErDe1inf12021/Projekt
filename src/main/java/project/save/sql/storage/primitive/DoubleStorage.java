package project.save.sql.storage.primitive;

import project.save.sql.storage.PrimitiveStorage;

public class DoubleStorage extends PrimitiveStorage {

    private final double d;

    public DoubleStorage(double d) {
        this.d = d;
    }

    public Double read() {
        return d;
    }
}
