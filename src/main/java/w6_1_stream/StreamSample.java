package w6_1_stream;

import java.util.Arrays;
import java.util.List;

public class StreamSample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(
            "a", "b", "c", "d", "e", "f"
            // ,"ab", "b", "c", "d", "e", "f"
        );
        // 리스트 내부 모든 항목 출력
        // 일반적 for 문 사용
//        for (String str : list) {
//            // 여기에 조건문을 그냥 쓰면 되는 것 아닌지?
//            System.out.println(str);
//        }
        // 스트림 문법 중 forEach() 사용
        list.forEach(System.out::println);
        // 스트림 자료형을 추가 작업 수행(중개 연산)을 위한 완충지점으로 쓸 수 있음
//        list.stream()
//            .filter(str -> str.startsWith("a"))  // 뜯어보자!
//            // .filter(str -> str.endsWith("b"))  // 메서드 체이닝
//            .forEach(System.out::println);
        // 멀티스레딩 방식의 스트리밍 가능
        list.parallelStream().forEach(System.out::println);
        // => 데이터 항목들이 여러 개의 스레드로 분리되어서 처리 (성능 향상 가능)
    }
}
