package w3_8_functionalInterface;

public class MyStaticClass {
    private static int mutableVar = 1;

    public static void setMutableVar(int mutableVar) {
        MyStaticClass.mutableVar = mutableVar;
    }

    public static int getMutableVar() {
        return mutableVar;
    }
}
