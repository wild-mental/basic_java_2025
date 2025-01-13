package w2_17_exception;

public class MyExceptionSample {
    public static void throwCustomException() {
        throw new MyCustomException();
    }

    public static void main(String[] args) {
        throwCustomException();
    }
}
