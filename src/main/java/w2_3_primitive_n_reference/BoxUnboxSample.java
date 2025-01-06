package w2_3_primitive_n_reference;

public class BoxUnboxSample {
    public static void main(String[] args) {
        int num = 10;
        Integer boxedNum = Integer.valueOf(num); // 박싱
        // 박싱을 하는 이유
        // : Wrapper Class 가 가지고 있는
        //   다양한 데이터 핸들링 방법을 Util 처럼 활용하기 위해서!
        int unboxedNum = boxedNum.intValue(); // 언박싱
        // 언박싱을 하는 이유
        // : 가볍고 다양한 기본 연산에 편리하기 때문에

        System.out.println(boxedNum);
        System.out.println(unboxedNum);

        Integer autoBoxed = 10; // 자동 박싱
        int autoUnboxed = autoBoxed; // 자동 언박싱
        System.out.println(autoBoxed);
        System.out.println(autoUnboxed);
    }
}
