package w2_4_stringpractice;

public class StringPool {
    public static void main(String[] args) {
        // String Pool 을 사용하는 경우와 사용하지 않는 경우
        String s1 = "example";            // String Pool에 저장
        String s2 = "example";            // String Pool에서 참조
        String s3 = new String("example"); // Heap에 별도 객체 생성

        System.out.println(s1 == s2);      // true (String Pool에서 동일한 참조)
        System.out.println(s1 == s3);      // false (메모리 주소 비교)
        System.out.println(s1.equals(s3)); // true (내용 비교)

        // s4 생성 : new 키워드로 Pool 밖에 생성
        String s4 = new String("hello");
        // s5 생성 : intern() 호출하였으나, String Pool 에 s4의 리터럴 hello 가 없기 때문에 추가하며 생성
        String s5 = s4.intern();
        // s6 참조 : String Pool 에 저장된 "hello"의 주소를 s6에 할당
        String s6 = "hello";

        System.out.println(s4 == s5);    // false (메모리 주소 비교 다름)
        System.out.println(s5 == s6);    // true (String Pool 내의 동일 주소 참조)
    }
}
