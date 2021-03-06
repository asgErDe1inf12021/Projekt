package project.save.sql.storage.primitive;

import project.save.sql.storage.PrimitiveStorage;

public class FloatStorage extends PrimitiveStorage {

    private final float f;

    public FloatStorage(float f) {
        this.f = f;
    }

    public Float read() {
        return f;
    }

    @Override
    public String getType() {
        return "Float";
    }
}
