package w6_1_stream;

import java.util.Arrays;

public class StreamSampleCount {
    public static void main(String[] args) {
        // integer 배열 내부에 자연수만 필터링해 출력하기
        int[] values = { -1, -2, -3, -4, -5, 0, 1, 2, 3, 4, 5 };
        // 중개 연산에는 stream 의 각 항목에 대해 수행할 동작을 주로 람다식으로 적용하게 됨
        int naturalNumCnt = (int) Arrays.stream(values).filter(x -> x > 0).count();
        System.out.println(naturalNumCnt);  // output = 5
    }
}
