package w3_7_travelsystem;

public class Citizen implements ITravelable {
    String personName;        // 이름
    Nation nationality;       // 국적
    int gender;               // 1, 3 - 남성, 2, 4 - 여성 (%2 연산으로 처리 예정)
    boolean hasPassport;      // 여권
    boolean hasDoneMilitary;  // 병역
    boolean hasCrimeRecord;   // 범죄

    public Citizen(
        String personName, Nation nationality, int gender,
        boolean hasPassport, boolean hasDoneMilitary, boolean hasCrimeRecord
    ) {
        this.personName = personName;
        this.nationality = nationality;
        this.gender = gender;
        this.hasPassport = hasPassport;
        this.hasDoneMilitary = hasDoneMilitary;
        this.hasCrimeRecord = hasCrimeRecord;
    }

    public String getPersonName() {
        return personName;
    }

    public Nation getNationality() {
        return nationality;
    }

    public int getGender() {
        return gender;
    }

    public boolean hasPassport() {
        return hasPassport;
    }

    public boolean hasDoneMilitary() {
        return hasDoneMilitary;
    }

    public boolean hasCrimeRecord() {
        return hasCrimeRecord;
    }

    // 외부에서 호출하는 용도로 구현하면 적절해 보임
    public void travelOrEmigration(
        Nation tgNation,
        String purpose  // 여행 목적을 enum 으로 처리하면 좋다!
    ) {
        // 아래 두 메서드의 코드 중복을 개선하고자 하는 경우 하나로 묶어서 처리 가능
        // 1) 개별 메서드를 유지할지
        // 2) 아예 개별 메서드가 필요 없게 구현할지
        // 는 개발자 선택
    }

    @Override
    public void travel(Nation tgNation) {
        // 여행 대상국에서 검사 통과/차단 케이스에 따라서
        // 시민의 상태 변화 및 출력을 구현
        boolean screenPassed = tgNation.screenImmigration(
            this, "travel"
            // 또는
            // this.특정정보1, this.특정정보2
        );
        if (screenPassed) {
            System.out.println("[여행 성공]" + this.personName + "이 대상 국가:" + tgNation.getNationName() + " 여행 입국에 성공했습니다.");
        } else {
            System.err.println("[여행 실패]" + this.personName + "이 대상 국가:" + tgNation.getNationName() + " 여행 입국에 실패했습니다.");
        }
    }

    @Override
    public void emigration(Nation tgNation) {
        // 이민 대상국에서 검사 통과/차단 케이스에 따라서
        // 시민의 상태 변화 및 출력을 구현
        boolean screenPassed = tgNation.screenImmigration(
            this, "immigration"
            // 또는
            // this.특정정보1, this.특정정보2
        );
        if (screenPassed) {
            System.out.println("[이민 성공]" + this.personName + "이 대상 국가:" + tgNation.getNationName() + " 이민 입국에 성공했습니다.");
        } else {
            System.err.println("[이민 실패]" + this.personName + "이 대상 국가:" + tgNation.getNationName() + " 이민 입국에 실패했습니다.");
        }
    }

    @Override
    public String toString() {
        return "Citizen{" +
            "gender=" + gender +
            ", nationality=" +
            ((nationality != null) ? nationality.getNationName() : "무국적") +
            ", personName='" + personName + '\'' +
            "}\n";
    }
}
