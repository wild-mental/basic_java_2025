package w3_7_travelsystem;

public class TravelAgency {
    // 확장에 열려있는 방식으로 프로젝트 코드를 추가 개발할 수 있다
    // 의존이란? 클래스 내부에 다른 타입의 변수가 선언되어 있어서, 해당 타입 로딩 실패 시 동작 불가한 상황
    // 의존성 역전이란? DIP - 클래스 선언 시 추상적인 타입에 의존하고, 추상적 타입이 실제 동작을 구체적 로직에 의존
    //   (효용: 의존성의 안정적 핸들링, 개발 완료 전 동작 쿠셔닝 - 최초 개발 및 확장 시)
    public static void groupTravel(
        ITravelable[] travelers  // 여행객, 반려동물 또는 단독 수하물 배송까지 객체로 수신 가능
    ) {
        // TODO : 그룹 여행의 경우 전원 검사부터 수행하는 로직으로 변경 가능
        for (ITravelable traveler: travelers) {
            traveler.travel(Nation.getRegisteredNation("US"));
        }
    }

    public static void groupEmigration(
        ITravelable[] migrators
    ) {
        // TODO : 그룹 이민의 경우 전원 검사부터 수행하는 로직으로 변경 가능
        for (ITravelable traveler: migrators) {
            traveler.emigration(Nation.getRegisteredNation("US"));
        }
    }
}
