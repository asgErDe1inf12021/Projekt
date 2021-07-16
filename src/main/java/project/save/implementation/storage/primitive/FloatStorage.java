package project.save.implementation.storage.primitive;

import project.save.implementation.storage.PrimitiveStorage;

public class FloatStorage extends PrimitiveStorage {

    private final float f;

    public FloatStorage(float f) {
        this.f = f;
    }

    public Float read() {
        return f;
    }
}
