package w3_9_anonymousclass;

public class AnonymClassSample {
    public static void main(String[] args) {
        Duck duck = new Duck() {
            @Override
            public void quack(){
                System.out.println("QQQQQQUUUUAAAACCCKKK!!!!!!!!!!!!!!");
            }
        };
        duck.quack();
    }
}
