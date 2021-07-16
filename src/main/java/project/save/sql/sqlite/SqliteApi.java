package project.save.sql.sqlite;

import project.save.api.Serializable;
import project.save.api.Storage;
import project.save.implementation.storage.ObjectStorage;
import project.save.implementation.storage.primitive.*;
import project.save.sql.SqlApi;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SqliteApi extends SqlApi {

    private final HashMap<String, SerializableFactory<?>> deserializers = new HashMap<>();

    public SqliteApi() {
        System.out.println("Using Sqlite Config Api");
        try {
            Class.forName("org.sqlite.JDBC");
            CONNECTION = DriverManager.getConnection("JDBC:sqlite:gameDb.db");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection().nativeSQL("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load() {
        //TODO load objects from Database
    }

    @Override
    public void save() {
        for(Map.Entry<String, SerializableFactory<?>> entry: deserializers.entrySet()) {
            String id = entry.getKey();
            SerializableFactory<?> object;
        }
    }

    @Override
    public void registerObject(String name, SerializableFactory<?> serializableFactory) {
        if (deserializers.containsKey(name)) return;
        deserializers.put(name, serializableFactory);
    }

    @Override
    public Storage saveObject(Serializable serializable) {
        return new ObjectStorage(serializable.getIdentifier(), serializable);
    }

    @Override
    public Serializable readObject(Storage storage) {
        ObjectStorage objectStorage = (ObjectStorage) storage;
        return (Serializable) deserializers.get((objectStorage).getIdentifier()).create(objectStorage.read());
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
