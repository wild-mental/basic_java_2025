package w2_7_abstract_n_interface;

public interface InterfaceSample2 {
    abstract void absMethod2();

    default void absMethod2(int a, int b, int c) {
        System.out.println(
            "여기는 2번째 인터페이스입니다."
        );
    }
}
