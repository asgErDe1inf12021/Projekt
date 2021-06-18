package project.config.implementation;

import project.config.api.Serializable;
import project.config.api.Storage;
import project.config.implementation.storage.primitive.*;

public class Api extends project.config.api.Api {

    public Api() {
        System.out.println("Using Simple Config Api");
    }

    @Override
    public Storage saveObject(Serializable serializable) {
        return null;
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
