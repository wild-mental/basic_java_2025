package w2_17_exception;

public class MyCustomException extends RuntimeException {
    public MyCustomException() {
        super("이 Exception 객체는 OOO 한 경우의 에러를 기본으로 나타냅니다.");
    }

    public MyCustomException(String message) {
        super(message);
    }
}
