package w2_17_exception;

public class ExceptionSample {
    public static void exceptionThrow() throws Throwable {
        Throwable myThrowable = new Throwable();
        throw myThrowable;
    }

    public static void exceptionHandle() {
        try {
            exceptionThrow();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        exceptionHandle();  // 메인함수에 도달하기 전에 핸들링 되어 있는 것이 바람직!

        // 최상위 객체들은 계통을 표현하기 위해서 존재함
        Error myError = new Error();
        // throw myError;  // Application 단위 개발자의 관심사에서는 벗어나는 영역
        Exception myException = new Exception();
        // 핸들링의 대상은 Exception! -> Application 에서 고려된 범위를 벗어나는 영역
    }
}
