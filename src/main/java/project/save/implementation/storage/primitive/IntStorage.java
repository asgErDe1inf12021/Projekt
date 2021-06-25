package project.save.implementation.storage.primitive;

import project.save.implementation.storage.PrimitiveStorage;

public class IntStorage extends PrimitiveStorage {

    private final int i;

    public IntStorage(int i) {
        this.i = i;
    }

    public Integer read() {
        return i;
    }
}
