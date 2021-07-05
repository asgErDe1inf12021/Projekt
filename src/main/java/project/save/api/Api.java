package project.save.api;

import java.util.HashMap;

public abstract class Api {
    public static Api Api;

    public abstract void registerObject(String name, SerializableFactory<?> serializableFactory);

    public abstract Storage saveObject(Serializable serializable);
    public abstract Serializable readObject(Storage storage);

    public abstract Storage saveInt(int i);
    public abstract Storage saveBoolean(boolean b);
    public abstract Storage saveDouble(double d);
    public abstract Storage saveFloat(float f);
    public abstract Storage saveString(String s);

    public abstract int readInt(Storage storage);
    public abstract boolean readBoolean(Storage storage);
    public abstract double readDouble(Storage storage);
    public abstract float readFloat(Storage storage);
    public abstract String readString(Storage storage);

    @FunctionalInterface
    public interface SerializableFactory<C> {
        C create(HashMap<String, Storage> map);
    }
}
