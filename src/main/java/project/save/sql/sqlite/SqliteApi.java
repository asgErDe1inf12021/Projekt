package project.save.sql.sqlite;

import project.save.api.Serializable;
import project.save.api.Storage;
import project.save.sql.SqlApi;
import project.save.sql.storage.ObjectStorage;
import project.save.sql.storage.PrimitiveStorage;
import project.save.sql.storage.primitive.*;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SqliteApi extends SqlApi {

    private final HashMap<String, SerializableFactory<?>> deserializers = new HashMap<>();

    public SqliteApi(String database) {
        System.out.println("Using Sqlite Config Api");
        try {
            Class.forName("org.sqlite.JDBC");
            CONNECTION = DriverManager.getConnection("JDBC:sqlite:" + database);
            SqlApi.setupTables();
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load() {
        //TODO probably not here too
    }

    public void saveObjectToDB(String parentIdentifier, String identifier, ObjectStorage storage) {
        HashMap<String, Storage> map = storage.read();
        try {
            connection().createStatement().execute("INSERT OR IGNORE INTO ObjectStorageLink(Identifier, storedObject, isSimple) VALUES('" + parentIdentifier + "', '" + identifier + "', false)");
            connection().createStatement().execute("REPLACE INTO ObjectStorage(Identifier, className) VALUES('" + identifier + "', '" + storage.getClassName() + "')");
        } catch(SQLException e) {
            e.printStackTrace();
        }
        for(Map.Entry<String, Storage> entry : map.entrySet()) {
            String id = entry.getKey();
            Storage subStorage = entry.getValue();
            if(subStorage instanceof ObjectStorage) {
                saveObjectToDB(identifier, identifier + "." + id, (ObjectStorage) subStorage);
            } else if(subStorage instanceof PrimitiveStorage) {
                savePrimitiveToDB(identifier, identifier + "." + id, (PrimitiveStorage) subStorage);
            }
        }
    }

    public void savePrimitiveToDB(String parentIdentifier, String identifier, PrimitiveStorage storage) {
        try {
            connection().createStatement().execute("REPLACE INTO PrimitiveStorage(Identifier, type, data) VALUES('" + identifier + "', '" + storage.getType() + "', '" + storage.read() + "')");
            connection().createStatement().execute("INSERT OR IGNORE INTO ObjectStorageLink(Identifier, storedObject, isSimple) VALUES('" + parentIdentifier + "', '" + identifier + "', true)");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void registerObject(String name, SerializableFactory<?> serializableFactory) {
        if(deserializers.containsKey(name)) return;
        deserializers.put(name, serializableFactory);
    }

    @Override
    public Storage saveObject(Serializable serializable) {
        return new ObjectStorage(serializable.getIdentifier(), serializable, serializable.getClassName());
    }

    @Override
    public Serializable readObject(Storage storage) {
        ObjectStorage objectStorage = (ObjectStorage) storage;
        return (Serializable) deserializers.get((objectStorage).getClassName()).create(objectStorage.read());
    }

    @Override
    public Storage saveInt(int i) {
        return new IntStorage(i);
    }

    @Override
    public Storage saveBoolean(boolean b) {
        return new BooleanStorage(b);
    }

    @Override
    public Storage saveDouble(double d) {
        return new DoubleStorage(d);
    }

    @Override
    public Storage saveFloat(float f) {
        return new FloatStorage(f);
    }

    @Override
    public Storage saveString(String s) {
        return new StringStorage(s);
    }

    @Override
    public int readInt(Storage storage) {
        return (int) storage.read();
    }

    @Override
    public boolean readBoolean(Storage storage) {
        return (boolean) storage.read();
    }

    @Override
    public double readDouble(Storage storage) {
        return (double) storage.read();
    }

    @Override
    public float readFloat(Storage storage) {
        return (float) storage.read();
    }

    @Override
    public String readString(Storage storage) {
        return (String) storage.read();
    }
}
