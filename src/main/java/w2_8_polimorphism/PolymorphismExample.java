package w2_8_polimorphism;

class Parent {
    public void display() {
        System.out.println("Parent class");
    }
}

class Child extends Parent {
    @Override
    public void display() {
        System.out.println("Child class");
    }
}

public class PolymorphismExample {
    public static void main(String[] args) {
        Parent obj = new Child(); // Promotion
        obj.display(); // Child class 출력
    }
}