package w3_7_travelsystem;

public class DemocraticTravelControlDepartment implements IControlTravel{
    String travelControlType = "Reasonable";

    @Override
    public String toString() {
        return "DemocraticTravelControlDepartment{" +
            "travelControlType='" + travelControlType + '\'' +
            '}';
    }

    @Override
    // 입국 심사
    // 여행자, 이민자 등 정보 수신 필요
    // 개인 정보만 들어오면 될 수도 있고
    // 국적에 해당하는 객체 참조 필요할 수도 있음
    // 파라미터 개수와 관계 없이 데이터 접근만 가능하면 됨
    public boolean screenImmigration(
        Citizen screenTgPerson, String incomingPurpose
    ) {
        // AS-IS
        // 0. 일반 여행과 이민의 공통 검사
        if (!screenTgPerson.hasPassport()) {
            return false;
        }
        if (
            screenTgPerson.getGender() % 2 == 1
                && !screenTgPerson.hasDoneMilitary()
        ) {
            return false;
        }
        // 1) 중첩 스타일의 조건 검사 로직
//        if (screenTgPerson.hasPassport()) {
//            if (screenTgPerson.getGender() % 2 == 1) {
//                return screenTgPerson.hasDoneMilitary();
//            } else {
//                return true;
//            }
//        }
//        return false;
        // 2) 단계적 소거 스타일의 조건 검사 로직 : 가독성이 높다
        if (incomingPurpose.equals("travel")) {
            // 1. 일반여행 입국 검사 수행
            // 일반 여행 목적의 검사 로직이 추가되는 경우 여기에 구현
            return true;
        } else if (incomingPurpose.equals("immigration")) {
            // 이민 목적의 경우 검사 로직
            if (screenTgPerson.hasCrimeRecord()) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }
}
