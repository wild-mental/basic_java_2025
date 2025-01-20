package w3_7_gyudeok_travelsystem;

public class StatelessPerson extends Person {
    private String currentCountry;
    private String currentState;

    public StatelessPerson(String name, int age, String gender,
                           String currentCountry, String currentState) {
        super(name, age, gender);
        this.currentCountry = currentCountry;
        this.currentState = currentState;
    }

    public String getCurrentCountry() {
        return currentCountry;
    }

    public String getCurrentState() {
        return currentState;
    }

    @Override
    public void travel(Nation nation) {
        System.out.println("무국적자의 여행은 제한됩니다.");
    }

    @Override
    public void emigration(Nation nation) {
        boolean screenPassed = nation.TravelOrImmigrant(this, "immigration");
        String nationName = nation.getNationName();
        if (screenPassed) {
            setNationality(nationName);
            Nation.printNation(nation);
            System.out.println(getName() + " 님의 " + nationName + " 나라의 이민을 진심으로 환영합니다!");
            System.out.println(getName() + " 님의 국적이 " + getNationality() + " 로 변경되었습니다!");
        } else {
            System.out.println(getName() + " 님의 이민 신청이 거절되었습니다.");
        }
    }
}
