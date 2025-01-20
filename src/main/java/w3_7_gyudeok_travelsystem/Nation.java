package w3_7_gyudeok_travelsystem;

public class Nation implements INation{
    private final String nationName;
    private boolean exhibitionStatus;  // 변동될 여지가 있어서 final 안씀
    private final String politicalSystem;
    private int creditRating;
    // 차후에 랜덤으로 여행가능국인지 아닌지 트릭키 요소 추가하면 재밌을 듯

    public Nation(String nationName, boolean exhibitionStatus,
                  String politicalSystem, int creditRating) {
        this.nationName = nationName;
        this.exhibitionStatus = exhibitionStatus;
        this.politicalSystem = politicalSystem;
        this.creditRating = creditRating;
    }

    public String getNationName() {
        return nationName;
    }

    public boolean isExhibitionStatus() {
        return exhibitionStatus;
    }

    public String getPoliticalSystem() {
        return politicalSystem;
    }

    public int getCreditRating() {
        return creditRating;
    }

    public static void printNation(Nation nation) {
        System.out.println("-------- 국가 정보 --------\n");
        System.out.println("국가 정보" +
                "\n국가명 : " + nation.getNationName() +
                "\n전시상황 : " + nation.isExhibitionStatus() +
                "\n정치체제 : " + nation.getPoliticalSystem() +
                "\n신용등급 : " + nation.getCreditRating() +
                "\n\n--------------------------\n");
    }

    @Override
    public String toString() {
        return "Nation{" +
            "nationName='" + nationName + '\'' +
            ", exhibitionStatus=" + exhibitionStatus +
            ", politicalSystem='" + politicalSystem + '\'' +
            ", creditRating=" + creditRating +
            '}';
    }

    public boolean TravelOrImmigrant(Person person, String userChoice) {
        // 객체 상관없이 여행인지, 이민인지 판단
        switch (userChoice) {
            case "travel":
                return (TravelApproval(person));
            case "immigration":
                return (ImmigrationApproval(person));
            default:
                System.out.println("Invalid user choice");
                return false;
        }
    }

    public boolean ImmigrationApproval(Person person) {
        System.out.println("------ 이민심사중입니다 -----\n");
        if (person instanceof Citizen myCitizen) {   // 사람중에 이 객체가 시민인지 판단
            System.out.println("이민자 정보" +
                    "\n이름 : " + myCitizen.getName() +
                    "\n나이 : " + myCitizen.getAge() +
                    "\n국적 : " + myCitizen.getNationality() +
                    "\n여권여부 : " + myCitizen.isPassport() +
                    "\n성별 : " + myCitizen.getGender() +
                    "\n범죄여부 : " + myCitizen.isCriminalRecord() +
                    "\n병역여부 : " + myCitizen.isMilitaryService() +
                    "\n");
            if (myCitizen.isPassport() && !myCitizen.isCriminalRecord() && myCitizen.isMilitaryService()) {
                System.out.println("이민심사가 승인되었습니다.");
                System.out.println("------- 이민심사종료 -------\n");
                return true;
            } else if (!myCitizen.isMilitaryService() && myCitizen.getAge() <= 18) {
                System.out.println("이민자격이 부적격으로 판단되었습니다.");
                return false;
            } else
                System.out.println("이민자격이 부적격으로 판단되었습니다.");
            System.out.println("------- 이민심사종료 -------\n");
            return false;
        } else if (person instanceof StatelessPerson myStatelessPerson) {  // 객체가 무국적자인지 판단
            System.out.println("이민자 정보" +
                    "\n이름 : " + myStatelessPerson.getName() +
                    "\n나이 : " + myStatelessPerson.getAge() +
                    "\n성별 : " + myStatelessPerson.getGender() +
                    "\n현재 거주 국가 :" + myStatelessPerson.getCurrentCountry() +
                    "\n현재 상태 : " + myStatelessPerson.getCurrentState() +
                    "\n");
            System.out.println("이민자격이 부적격으로 판단되었습니다.");
            return false;
        }
        return false;  // 객체가 시민, 무국적자가 아니면 실패 ( ex 신원 미상 )
    }

    public boolean TravelApproval(Person person) {
        System.out.println("------ 입국심사중입니다 -----\n");
        if (person instanceof Citizen myCitizen) {
            System.out.println("입국자 정보" +
                    "\n이름 : " + myCitizen.getName() +
                    "\n나이 : " + myCitizen.getAge() +
                    "\n국적 : " + myCitizen.getNationality() +
                    "\n여권여부 : " + myCitizen.isPassport() +
                    "\n성별 : " + myCitizen.getGender() +
                    "\n범죄여부 : " + myCitizen.isCriminalRecord() +
                    "\n병역여부 : " + myCitizen.isMilitaryService() +
                    "\n");
            // 심사기준 TBD
            // 조건문 검사 수행
            if (myCitizen.isPassport() && !myCitizen.isCriminalRecord() && myCitizen.isMilitaryService()) {
                System.out.println("입국심사가 승인되었습니다.");
                System.out.println("------- 입국심사종료 -------\n");
                return true;
            } else if (!myCitizen.isMilitaryService() && myCitizen.getAge() <= 18) {
                System.out.println("입국자격이 부적격으로 판단되었습니다.");
            }
            System.out.println("입국자격이 부적격으로 판단되었습니다.");
            System.out.println("------- 입국심사종료 -------\n");
            return false;
        }                      // 무국적자의 여행은 애초에 설계 불가 -> SimulationMain 에 이유 서술
        return false;
    }
}
