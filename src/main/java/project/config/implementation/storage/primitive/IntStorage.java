package project.config.implementation.storage.primitive;

import project.config.api.Storage;

public class IntStorage extends Storage {

    private final int i;

    public IntStorage(int i) {
        this.i = i;
    }

    public Integer read() {
        return i;
    }
}
