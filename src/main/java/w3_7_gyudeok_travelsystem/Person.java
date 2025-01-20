package w3_7_gyudeok_travelsystem;

abstract public class Person implements IPerson {
    private final String name;
    private final int age;
    private final String gender;
    private String nationality;
    // 사람이라면 응당 가져야할 속성

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.nationality = null;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
