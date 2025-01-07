package w2_9_sealed_n_final;

sealed class Shape permits Circle, Square {
    void draw(){
        System.out.println(
            "Drawing Default Shape"
        );
    };
}

final class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

// Final 클래스는 더이상 상속 불가
class ChildCircle
//    extends Circle
{
//    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

// non-sealed 클래스는 다음 상속 구조를 이루는 클래스 부터는
// sealed 제어 구조로부터 제거함으로써 봉인효과를 해제
non-sealed class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

class ChildSquare extends Square {
    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

public class SealedClassSample {
    public static void main(String[] args) {

    }
}