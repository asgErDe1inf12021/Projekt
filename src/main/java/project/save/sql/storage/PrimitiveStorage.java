package project.save.sql.storage;

import project.save.api.Storage;

public abstract class PrimitiveStorage extends Storage {
    public abstract String getType();
}
