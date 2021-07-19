package project.save.sql;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class SqlApi extends project.save.api.Api {
    protected static Connection CONNECTION;

    public static Connection connection() {
        if(CONNECTION == null)
            throw new IllegalStateException("trying to access Database, but the Database isn't set up yet!");
        return CONNECTION;
    }

    public static void setupTables() throws SQLException {
        connection().createStatement().execute("CREATE TABLE IF NOT EXISTS ObjectStorage (" +
                "Identifier TEXT PRIMARY KEY," +
                "className TEXT NOT NULL" +
                ") WITHOUT ROWID;");

        connection().createStatement().execute("CREATE TABLE IF NOT EXISTS ObjectStorageLink (" +
                "Identifier TEXT NOT NULL," +
                "storedObject TEXT NOT NULL," +
                "isSimple boolean NOT NULL," +
                "FOREIGN KEY (Identifier)" +
                "   REFERENCES ObjectStorage (Identifier)" +
                "      ON DELETE CASCADE" +
                "      ON UPDATE NO ACTION" +
                ");");

        connection().createStatement().execute("CREATE TABLE IF NOT EXISTS PrimitiveStorage (" +
                "Identifier TEXT PRIMARY KEY," +
                "type TEXT NOT NULL," +
                "data TEXT NOT NULL" +
                ") WITHOUT ROWID;");
    }
}
