package project.config.implementation.storage.primitive;

import project.config.api.Storage;

public class DoubleStorage extends Storage {

    private final double d;

    public DoubleStorage(double d) {
        this.d = d;
    }

    public Double read() {
        return d;
    }
}
