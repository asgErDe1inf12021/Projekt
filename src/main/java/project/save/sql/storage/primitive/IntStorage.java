package project.save.sql.storage.primitive;

import project.save.sql.storage.PrimitiveStorage;

public class IntStorage extends PrimitiveStorage {

    private final int i;

    public IntStorage(int i) {
        this.i = i;
    }

    public Integer read() {
        return i;
    }

    @Override
    public String getType() {
        return "Integer";
    }
}
