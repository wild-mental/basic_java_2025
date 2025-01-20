package w3_7_gyudeok_travelsystem;

public class Citizen extends Person {
    private boolean passport;
    private boolean criminalRecord;
    private boolean militaryService;

    public Citizen(String name, int age, String nationality,
            boolean passport, String gender, boolean criminalRecord,
            boolean militaryService) {
        super(name, age, gender);
        setNationality(nationality);   // 기본적인 사람은 국적 속성을 가지나 시민은 특별히 국적이 할당된다고 생각.
        this.passport = passport;
        this.criminalRecord = criminalRecord;
        this.militaryService = militaryService;
    }

    @Override
    public void travel(Nation nation) {
        boolean screenPassed = nation.TravelOrImmigrant(this, "travel");
        if (screenPassed) {
            Nation.printNation(nation);
            System.out.println(getName() + " 님의 " + nation.getNationName() + " 나라의 여행을 진심으로 환영합니다!");
        }
    }

    @Override
    public void emigration(Nation nation) {
        boolean screenPassed = nation.TravelOrImmigrant(this, "immigration");
        if (screenPassed) {
            setNationality(nation.getNationName());
            Nation.printNation(nation);
            System.out.println(getName() + " 님의 " + nation.getNationName() + " 나라의 이민을 진심으로 환영합니다!");
            System.out.println(getName() + " 님의 국적이 " + getNationality() + " 로 변경되었습니다!");
        } else {
            System.out.println(getName() + " 님의 이민 신청이 거절되었습니다.");
        }
    }

    public boolean isPassport() {
        return passport;
    }

    public boolean isCriminalRecord() {
        return criminalRecord;
    }

    public boolean isMilitaryService() {
        return militaryService;
    }
}
