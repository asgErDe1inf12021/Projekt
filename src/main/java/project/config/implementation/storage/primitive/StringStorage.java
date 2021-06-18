package project.config.implementation.storage.primitive;

import project.config.api.Storage;

public class StringStorage extends Storage {

    private final String s;

    public StringStorage(String s) {
        this.s = s;
    }

    public String read() {
        return s;
    }
}
