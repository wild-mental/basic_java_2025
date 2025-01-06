package w2_3_primitive_n_reference;

public class PrimitiveExample {
    public static void main(String[] args) {
        int age = 25;         // 정수형
        double height = 175.5; // 실수형
        char grade = 'A';     // 문자형
        boolean isAdult = true; // 논리형

        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Grade: " + grade);
        System.out.println("Is Adult: " + isAdult);

        int myOct = 02122;
        int myHex = 0x452;
        System.out.println("myOct: " + myOct);
        System.out.println("myHex: " + myHex);

        // 언더바는 가독성을 위한 것으로 값의 평가에서는 무시됨
        int myBin = 0b100100_100;
        int myDecimal = 1_000_000_000;
        System.out.println("myBin: " + myBin);
        System.out.println("myDecimal: " + myDecimal);
    }
}