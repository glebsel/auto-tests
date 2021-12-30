package cucumber.utils;

public class Context {
    private static final Context instance = resetInstance();

    public static Context instance(){return instance;}

    public static Context resetInstance(){
        return new Context();
    }
}
