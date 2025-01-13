package w2_15_overflow_underflow;

import java.math.BigDecimal;

public class OverUnderFlowSample {
    public static void main(String[] args) {
        // 오버플로우 기본 예제
        int intMax = Integer.MAX_VALUE;
        int intOverflow = intMax + 1;
        System.out.printf("%d, %d\n", intMax, intOverflow);

        // 아래 예제는 언더플로우가 아닙니다
        int intMin = Integer.MIN_VALUE;
        int intOverflow2 = intMin - 1;
        System.out.printf("%d, %d\n", intMin, intOverflow2);

        // 언더플로우 기본 예제
        float smallValue = 1.4e-45f; // float의 최소 양수 값
        float result = smallValue / 10; // 1.4e-46, 표현 불가능한 값

        System.out.println("Original value: " + smallValue);
        System.out.println("After division: " + result); // 0.0 출력 (언더플로우)

        float a = 0.1f;
        float b = 0.2f;
        // 부동 소수점 연산 시 정밀도가 항상 표현을 원하는 자릿수 만큼 지원되지 않음
        System.out.printf("a +b : %6f\n", (a + b));
        // 6자리 이상으로 출력 시 정밀도 오차 확인 가능
        // 0.300000 (현재 출력)
        // 0.300000000402013 (실제 저장된 값)
        // 부동 소수점은 오차가 거의 항상 발생하고 있다고 보면 정확함

        // 언더플로우 방지 예제
        double smallValue2 = 1.4e-45d;
        double noLossResult = smallValue2 / 10; // 1.4e-46, long 으로 표현
        System.out.println("After division: " + noLossResult); // 0.0 출력 (언더플로우)

        // BigDecimal 사용
        BigDecimal smallValueBD = new BigDecimal("1.4e-45");
        // BigDecimal resultBigDecimal = smallValueBD / 10;  // 기본 타입 산술 연산자 사용 불가
        BigDecimal resultBigDecimal = smallValueBD.divide(new BigDecimal("10"));
        System.out.println("BigDecimal result: " + resultBigDecimal.toPlainString()); // 정확한 결과 출력
    }
}
