package project.config.implementation.storage.primitive;

import project.config.api.Storage;

public class FloatStorage extends Storage {

    private final float f;

    public FloatStorage(float f) {
        this.f = f;
    }

    public Float read() {
        return f;
    }
}
