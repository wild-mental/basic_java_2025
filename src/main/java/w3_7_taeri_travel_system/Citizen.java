package w3_7_taeri_travel_system;

import w3_7_gyudeok_travelsystem.Person;

public class Citizen
    // extends Person : 안하기로
    implements Travelable {
    private String name;
    private String nationality; // 국적
    private boolean hasPassport; // 여권
    private boolean hasCriminalRecord; // 범죄이력

    public Citizen(String name, String nationality, boolean hasPassport, boolean hasCriminalRecord) {
        this.name = name;
        this.nationality = nationality;
        this.hasPassport = hasPassport;
        this.hasCriminalRecord = hasCriminalRecord;
    }

    @Override
    public void travel(Nation targetNation) {
        System.out.println(name + "님이 " + targetNation.toString() + "으로 여행을 시도합니다.");
        if (targetNation.screenImmigration(this)) {
            System.out.println("여행 성공");
        } else {
            System.out.println("여행 실패");
        }
    }

    @Override
    public void emigrate(Nation targetNation) {
        System.out.println(name + "님이 " + targetNation.toString() + "으로 이민을 시도합니다.");
        if (targetNation.screenImmigration(this)) {
            System.out.println("이민 성공");
            this.nationality = targetNation.toString(); // 국적 변경
            System.out.println("새로운 국적: " + this.nationality);
        } else {
            System.out.println("이민 실패");
        }
    }

    public boolean hasCriminalRecord() {
        return hasCriminalRecord;
    }

    @Override
    public String toString() {
        return "Citizen{name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", hasPassport=" + hasPassport +
                ", hasCriminalRecord=" + hasCriminalRecord + '}';
    }
}
