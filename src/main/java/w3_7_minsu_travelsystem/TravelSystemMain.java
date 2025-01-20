package w3_7_minsu_travelsystem;

import java.util.*;

public class TravelSystemMain {

    private static List<DetailedNation> nations = new ArrayList<>();
    private static List<DetailedCitizen> citizens = new ArrayList<>();

    static {
        // 국가
        nations.add(new DetailedNation("ROK", "Republic", "한글", 50000000, "Seoul", "won", true, "High"));
        nations.add(new DetailedNation("USA", "Republic", "English", 100000000, "D.C", "dollar", false, "Medium"));
        nations.add(new DetailedNation("China", "Confederation", "Chinese", 1300000000, "Beijing", "yuan", false, "Low"));

        // 시민
        citizens.add(new DetailedCitizen("Mings", 30, 1, nations.get(0), 123123, true, false));
        citizens.add(new DetailedCitizen("Teari", 25, 2, nations.get(1), 456456, false, false));
        citizens.add(new DetailedCitizen("Gyu", 40, 3, null, 789789, false, true));
    }

    // 임베디드 시스템에서 중앙관리형으로 모든 시스템 실행이 일어나는 패러다임이 보임
    // 객체지향적, 클래스 기반 핸들링, 분류가 안된 최상위 영역은 없다고 보는 방식의 패러다임 -> 객체지향적 데이터 관리에 더 가까움

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("반갑습니다.");

        System.out.print("이름을 입력하세요 : ");
        String name = scanner.nextLine();

        // 시민 검색
        DetailedCitizen citizen = findCitizenByName(name);

        if (citizen == null) {
            System.out.println("시민 정보를 찾을 수 없습니다.");
            return;
        }

        DetailedNation nationality = (DetailedNation) citizen.getNationality();

        if (nationality == null) {
            System.out.println("해당 시민은 무국적자입니다.");
            return;
        } else {
            System.out.println("시민의 국적: " + nationality.getName());

            // 해당 시민 여권번호, 병역여부, 범죄기록 출력 -> DetailedCitizen 클래스의 toString()
            // toString() 의 경우 sout으로 출력할 때 자동 호출됨. => citizen.toString()일 필요 없음
            System.out.println(citizen);
        }

        // 입국 심사 시행
        System.out.println("입국 심사를 시행합니다...");

        // sout으로 출력하는 안내문의 경우 Main 함수와 클래스 메서드 중 어디에 적는것이 맞는가?
        boolean isImmigrationAllowed = nationality.screenImmigration(citizen);

        if (!isImmigrationAllowed) {
            // System.out.println("입국이 거부되었습니다.");
            return;
        }

        // 입국 가능 국가 출력 및 선택
        System.out.println("입국 가능 국가 :");
        for (int i = 0; i < nations.size(); i++) {
            System.out.println((i + 1) + ". " + nations.get(i).getName());
        }

        System.out.print("목적지 국가 (1-" + nations.size() + "): ");
        int nationChoice = scanner.nextInt();

        if (nationChoice < 1 || nationChoice > nations.size()) {
            System.out.println("잘못입력하셨습니다.");
            return;
        }

        DetailedNation targetNation = nations.get(nationChoice - 1);

        System.out.println("목적지 국가의 입국 심사를 진행합니다.");
        boolean targetNationAllowed = targetNation.screenImmigration(citizen);

        if (!targetNationAllowed) {
            //System.out.println("선택한 국가에서 입국이 거부되었습니다.");
            return;
        }

        System.out.println("처리중입니다.");
        citizen.travel(targetNation); // 여행 처리
    }

    private static DetailedCitizen findCitizenByName(String name) {
        // 객체지향적으로 볼 때, 국가가 지원하는 기능
        // findCitizen 동작을 수행하기 위해서는 관리 자료형을 Map
        for (DetailedCitizen citizen : citizens) {
            // 시민 이름이 일치하는지 확인
            if (citizen.getName() != null && citizen.getName().equalsIgnoreCase(name)) {
                return citizen;
            }
        }
        return null;
    }
}
