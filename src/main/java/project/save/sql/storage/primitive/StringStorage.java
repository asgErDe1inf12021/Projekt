package project.save.sql.storage.primitive;

import project.save.sql.storage.PrimitiveStorage;

public class StringStorage extends PrimitiveStorage {

    private final String s;

    public StringStorage(String s) {
        this.s = s;
    }

    public String read() {
        return s;
    }
}
