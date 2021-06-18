package project.config.implementation.storage.primitive;

import project.config.implementation.storage.PrimitiveStorage;

public class DoubleStorage extends PrimitiveStorage {

    private final double d;

    public DoubleStorage(double d) {
        this.d = d;
    }

    public Double read() {
        return d;
    }
}
