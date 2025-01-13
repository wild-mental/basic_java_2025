package w2_11_math_n_system;

// 임포트 순서 관리 및 자동완성을 통한 임포트

// 빌트인 라이브러리
// import com.sun.security.auth.module.UnixLoginModule;

// 기타 언어 유틸 라이브러리
//import java.util.ArrayList;
//import java.util.Scanner;

// 써드파티 의존성 라이브러리
// : 각종 프레임워크 제공 패키지 임포트

// 사용자 정의 프로젝트 내부 클래스
//import w2_2_memorystructure.Cat;

public class MathSample {
    public static void main(String[] args) {
        // 기본 리터럴은 각 타입에 맞는 표현방식으로
        // 값을 직관적으로 읽을 수 있도록 사용해주면 좋다
        byte myByte = 0b1;
        int myInt = 1;
        long myLong1 = 1;   // integer 타입을 묵시적 타입 캐스팅
        long myLong2 = 1L;

        double absoluteValue = Math.abs(-5.67d);
        System.out.println("Absolute Value: " + absoluteValue);

        double ceilingValue = Math.ceil(4.25);
        System.out.println("Ceiling: " + ceilingValue);

        // 반올림 -> 일반적인 10진법 반올림을 적절히 수행
        float result1 = Math.round(10.5f); // Rounds to 11
        float result2 = Math.round(11.5f); // Rounds to 12
        float result3 = Math.round(10.2f); // Rounds to 10
        float result4 = Math.round(10.8f); // Rounds to 11

        System.out.println("Result 1: " + result1);
        System.out.println("Result 2: " + result2);
        System.out.println("Result 3: " + result3);
        System.out.println("Result 4: " + result4);
    }
}
