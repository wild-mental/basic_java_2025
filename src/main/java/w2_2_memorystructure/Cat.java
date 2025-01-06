package w2_2_memorystructure;

public class Cat {
    // 생성자
    public Cat(int age, float furLength, String name) {
        this.age = age;
        this.furLength = furLength;
        this.name = name;
    }

    // Static 변수
    public static final boolean fourLegged = true;
    public static final boolean mammal = true;

    // 인스턴스 변수
    public int age;
    public float furLength;
    public String name;

    // 인스턴스 메서드
    public int getAge() {
        return this.age;
    }

    public float getFurLength() {
        return furLength;
    }

    public String getName() {
        return name;
    }

    // Static 메서드
    public static void main (String[]args){
        // 1. Cat 객체 생성
        Cat myScottishFold = new Cat(1, 10.123f, "Scattish");
        // 2. 연산을 위한 변수 분리
        int catAge = myScottishFold.getAge();

        catAge = 10;
        catAge = 11;

        float catFurLength = myScottishFold.getFurLength();
        //
        String catName = myScottishFold.getName();
    }
}