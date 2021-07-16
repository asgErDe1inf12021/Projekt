package project.save.sql;

import java.sql.Connection;

public abstract class SqlApi extends project.save.api.Api {
    protected static Connection CONNECTION;

    public Connection Connection() {
        if (CONNECTION == null)
            throw new IllegalStateException("trying to access Database, but the Database isn't set up yet!");
        return CONNECTION;
    }
}
