package w3_2_collection;

import java.util.List;  // 인터페이스
import java.util.ArrayList;  // AbstractList 를 확장
import java.util.LinkedList;  // AbstractList 를 확장
import java.util.Objects;

public class ListSample {
    public static void main(String[] args) {
        // ArrayList, LinkedList implements List

        // 광범위한 타입 선언은 비권장
        List<Objects> myList1 = new ArrayList<>();
        List<Object> myList2 = new ArrayList<>();

        // 변수에 제네릭 타입 선언한 경우, 할당되는 객체 생성문에는 그에 맞는 타입이 들어가는 것이 상식
        // => 자동으로 타입 추론되므로 생략 권장 -> 연역 추론 (컴파일러의 기본 타입 추론 방법)
        // 3단 논법에서의 추론 / 통계적 추론
        // A는 B다, B는 C다, 그러므로 A는 C다. (연역법) -> 연역법 (명제적 참을 도출)
        List<String> myStrArrList = new ArrayList<>(10000);
        // => ArrayList 생성 시 메모리 점유 크기를 바꿔가면서 1000번 반복시키며 소요시간 테스트하기
        //    (시간 측정에 currentTimeMillis 사용하기) : 10초 이상 소요될 때까지 확인
        List<String> myStrLnkList = new LinkedList<>();

        myStrArrList.add("1");
        myStrArrList.add("2");
        myStrArrList.add("3");
        myStrArrList.add(2, "2.5");
        myStrArrList.set(2, "2.7");
        System.out.println(myStrArrList);

        if (myStrArrList.contains("1")) {
            System.out.println("1 is in my List!");
        }

        // 자료형이 주어졌을 때, 안전한 연산인지를 확인하고 사용하자
        System.out.println(myStrArrList.get(3));  // IndexOutOfBoundsException 발생 가능
        System.out.println(myStrArrList.isEmpty());
        System.out.println(myStrArrList.size());
        myStrArrList.clear();
        System.out.println(myStrArrList);
    }
}
