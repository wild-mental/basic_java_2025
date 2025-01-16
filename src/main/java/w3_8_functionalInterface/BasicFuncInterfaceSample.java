package w3_8_functionalInterface;
import java.util.function.BinaryOperator;

public class BasicFuncInterfaceSample {
    public static void main(String[] args) {
        // 람다 표현식을 사용하여 두 수를 더하기
        BinaryOperator<Integer> add =  // 함수형 인터페이스 타입 변수 선언으로 "기능" 이라는 프로그래밍 단위 핸들링 가능
            (a, b) -> a + b;  // 람다 표현식

        // apply 라는 이름이 정해져 있는 위치 : 인터페이스
        int result = add.apply(3, 4); // 7
        System.out.println(result);

        // 내가 직접 선언한 함수형 인터페이스 사용하기
        MyMathIntBinaryOperation addition = (a, b) -> a + b;  // 람다 표현식으로 함수 선언
        result = addition.operate(1, 2);
        System.out.println(result); // 3
    }
}
