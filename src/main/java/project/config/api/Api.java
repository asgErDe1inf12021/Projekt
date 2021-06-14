package project.config.api;

public abstract class Api {
    public static Api Api;

    public abstract Storage saveObject(Serializable serializable);

    public abstract Storage saveInt(int i);
    public abstract Storage saveBoolean(boolean b);
    public abstract Storage saveDouble(double d);
    public abstract Storage saveFloat(float f);
    public abstract Storage saveString(String s);
}
