package w2_3_primitive_n_reference;

public class ReferenceExample {
    public static void main(String[] args) {
        // 클래스
        String name = "John";
        System.out.println("Name: " + name);

        // 배열
        int[] numbers = {1, 2, 3, 4, 5};  // 배열의 리터럴 작성 시 {} 사용
        for (int number : numbers) {  // 향상된 for 문
            System.out.println("Number: " + number);
        }
    }
}