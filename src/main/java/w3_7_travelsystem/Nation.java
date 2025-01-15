package w3_7_travelsystem;

import java.util.Map;

public class Nation {  // TODO (2) : 인터페이스 구현 형태로 변경
    private static Map<String, Nation> registeredNations;  // Dictionary

    static {  // 변수의 라이프 사이클이 시작되고 종료됨
        // 1. 국가와 시민들을 생성
        //    국가 종류
        //      국가명
        //      체제
        //        자유민주주의 체제 2개
        //          : "Korea", "US"
        //        독재 체제 2개
        //          : "Russia", "Suriname"
        registeredNations = Map.of(
            "Korea", new Nation("Korea", "Democracy"),
            "US", new Nation("US", "Democracy"),
            "Russia", new Nation("Russia", "Tyranny"),
            "Suriname", new Nation("Suriname", "Tyranny")
        );
        // System.out.println(registeredNations);
    }

    private String nationName;
    private String nationalSystem;

    // TODO : 각 국가별로 screenImmigration() 의 기능을 다르게 수행하고 싶은 경우
    //   -> 국가에 screenImmigration 을 가진 인터페이스를 구현한 "여행관리국" 객체를 할당
    private IControlTravel travelControlDepartment
        // = new TravelControlDepartmentA();
        = new TravelControlDepartmentB();
        // 구체 클래스 객체를 생성해서 추상 타입 변수에 할당
    // 매번 생성되는 국가에 여행관리국을 서로 다른 로직으로 할당할 수 있다.

    public Nation(String nationName, String nationalSystem) {
        this.nationName = nationName;
        this.nationalSystem = nationalSystem;
    }

    public static Nation getRegisteredNation(String nationName) {
        return registeredNations.get(nationName);  // 없으면 null 리턴
    }

    public String getNationName() {
        return nationName;
    }

    public String getNationalSystem() {
        return nationalSystem;
    }

    // 입국 심사
    // 여행자, 이민자 등 정보 수신 필요
    // 개인 정보만 들어오면 될 수도 있고
    // 국적에 해당하는 객체 참조 필요할 수도 있음
    // 파라미터 개수와 관계 없이 데이터 접근만 가능하면 됨
    public boolean screenImmigration(
        Citizen screenTgPerson, String incomingPurpose
    ) {
        // TODO : 여행관리국에 위임하는 형태로 코드 간소화, 책임 분할
        // travelControlDepartment.screenImmigration();

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

    @Override
    public String toString() {
        return "Nation{" +
            "nationName='" + nationName + '\'' +
            ", nationalSystem='" + nationalSystem + '\'' +
            "}\n";
    }
}
