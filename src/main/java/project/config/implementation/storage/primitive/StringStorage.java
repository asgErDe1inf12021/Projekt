package project.config.implementation.storage.primitive;

import project.config.implementation.storage.PrimitiveStorage;

public class StringStorage extends PrimitiveStorage {

    private final String s;

    public StringStorage(String s) {
        this.s = s;
    }

    public String read() {
        return s;
    }
}
