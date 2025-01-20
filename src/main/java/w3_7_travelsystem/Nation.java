package w3_7_travelsystem;

import java.util.*;

public class Nation {
    // 메모리 할당 초기화 후, static 블록에서 실제 데이터 추가
    private static Map<String, Nation> registeredNations = new HashMap<>();  // Dictionary

    private List<Citizen> nationalCitizen;

    public List<Citizen> getNationalCitizen() {
        return nationalCitizen;
    }

    static {  // 변수의 라이프 사이클이 시작되고 종료됨
        // 1. 국가와 시민들을 생성
        //    국가 종류
        //      국가명
        //      체제
        //        자유민주주의 체제 2개
        //          : "Korea", "US"
        //        독재 체제 2개
        //          : "Russia", "Suriname"
        registeredNations.put("Korea", new Nation(
            "Korea", "Democracy", new DemocraticTravelControlDepartment()
            )
        );
        registeredNations.put("US", new Nation(
            "US", "Democracy", new DemocraticTravelControlDepartment()
            )
        );
        registeredNations.put("Russia", new Nation(
            "Russia", "Tyranny", new CorruptedTravelControlDepartment()
            )
        );
        registeredNations.put("Suriname", new Nation(
            "Suriname", "Tyranny", new CorruptedTravelControlDepartment()
            )
        );
        // System.out.println(registeredNations);
    }

    void createFixtureCitizens(String nationName) {
        switch (nationName) {
            case "Korea":
                Citizen kor1 = new Citizen(
                    "한규덕", Nation.getRegisteredNation("Korea"), 1,
                    true, false, false
                );
                Citizen kor2 = new Citizen(
                    "이형준", Nation.getRegisteredNation("Korea"), 1,
                    true, true, false
                );
                this.nationalCitizen = Arrays.asList(kor1, kor2);
                break;
            case "US":
                Citizen us1 = new Citizen(
                    "Terry", Nation.getRegisteredNation("US"), 1,
                    true, false, false
                );
                Citizen us2 = new Citizen(
                    "Mings", Nation.getRegisteredNation("US"), 1,
                    true, true, true
                );
                this.nationalCitizen = Arrays.asList(us1, us2);
                break;
        }
    }

    private String nationName;
    private String nationalSystem;

    private IControlTravel travelControlDepartment;
        // = new DemocraticTravelControlDepartment();
        // = new CorruptedTravelControlDepartment();
        // 구체 클래스 객체를 생성해서 추상 타입 변수에 할당
    // 매번 생성되는 국가에 여행관리국을 서로 다른 로직으로 할당할 수 있다.


    public IControlTravel getTravelControlDepartment() {
        return travelControlDepartment;
    }

    public boolean screenImmigration(
        Citizen screenTgPerson, String incomingPurpose
    ) {
        // 더 큰 단위, 처리 순서상 앞단에 위치한 객체에서 별도의 전용 객체로 처리를 위임
        // => 인터페이스 다형성을 이용!
        return travelControlDepartment.screenImmigration(
            screenTgPerson, incomingPurpose
        );
    }

    public Nation(String nationName, String nationalSystem,
                  IControlTravel travelControlDepartment) {
        this.nationName = nationName;
        this.nationalSystem = nationalSystem;
        this.travelControlDepartment = travelControlDepartment;
        // 아래 호출은 생성자가 아니라 인스턴스 블록에서 수행 시 객체 생성 완료가 되지 않아서 필드 조회에 실패
        createFixtureCitizens(this.nationName);
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

    @Override
    public String toString() {
        return "Nation{" +
            "nationName='" + nationName + '\'' +
            ", nationalSystem='" + nationalSystem + '\'' +
            "}\n";
    }
}
