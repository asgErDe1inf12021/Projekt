package project.config.implementation;

import project.config.api.Serializable;
import project.config.api.Storage;

public class Api extends project.config.api.Api {

    @Override
    public Storage saveObject(Serializable serializable) {
        return null;
    }

    @Override
    public Storage saveInt(int i) {
        return null;
    }

    @Override
    public Storage saveBoolean(boolean b) {
        return null;
    }

    @Override
    public Storage saveDouble(double d) {
        return null;
    }

    @Override
    public Storage saveFloat(float f) {
        return null;
    }

    @Override
    public Storage saveString(String s) {
        return null;
    }

    @Override
    public int readInt(Storage storage) {
        return 0;
    }

    @Override
    public boolean readBoolean(Storage storage) {
        return false;
    }

    @Override
    public double readDouble(Storage storage) {
        return 0;
    }

    @Override
    public float readFloat(Storage storage) {
        return 0;
    }

    @Override
    public String readString(Storage storage) {
        return "";
    }
}
