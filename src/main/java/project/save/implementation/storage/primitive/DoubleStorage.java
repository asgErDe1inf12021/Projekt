package project.save.implementation.storage.primitive;

import project.save.implementation.storage.PrimitiveStorage;

public class DoubleStorage extends PrimitiveStorage {

    private final double d;

    public DoubleStorage(double d) {
        this.d = d;
    }

    public Double read() {
        return d;
    }
}
