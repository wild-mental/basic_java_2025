package w3_7_taeri_travel_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Simulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Nation> nations = new ArrayList<>();
        List<Citizen> citizens = new ArrayList<>();

        Nation korea = new RepublicNation(
            "South Korea", false, 10.0,
            new RepublicImmigrationDepartment()
        );
        Nation northKorea = new RepublicNation(
            "North Korea", true, 1.0,
            new RepublicImmigrationDepartment()
        );

        Nation russia = new NotRepublicNation(
            "Russia", "dictatorship",true, 1.0,
            new StrictImmigrationDepartment()
        );

        citizens.add(new Citizen("Kim", "South Korea", true, false));
        citizens.add(new Citizen("Lee", "South Korea", true, true));
        citizens.add(new Citizen("BBOTIN", "Russia", false, true));
        citizens.add(new Citizen("vladimire", "Russia", false, false));
        // Person statelessPerson = new Person("Unknown Refugee");

        nations.add(korea);
        nations.add(russia);

        System.out.println("=== 여행 및 이민 시뮬레이터 ===");
        while (true) {
            System.out.println("\n메뉴를 선택하세요:");
            System.out.println("1. 국가 등록");
            System.out.println("2. 시민 등록");
            System.out.println("3. 여행 시도");
            System.out.println("4. 단체 여행 시도");
            System.out.println("5. 이민 시도");
            System.out.println("6. 종료");
            System.out.print("선택: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            int nationIndex;
            int citizenIndex;

            switch (choice) {
                case 1:
                    // 특별히 스트림을 구현하는 경우 외에는...
                    // 대화형 상호작용 -> 결국 웹에서는 API 입력 JSON 등 한번에 받아야 함
                    System.out.print("국가 이름을 입력하세요: ");
                    String nationName = scanner.nextLine();
                    System.out.print("민주주의 인가요(true/false)? ");
                    boolean isDemocracy = scanner.nextBoolean();
                    System.out.print("전쟁 중인가요? (true/false): ");
                    boolean isAtWar = scanner.nextBoolean();
                    System.out.print("신용 등급을 입력하세요 (0.0 - 10.0): ");
                    double creditRating = scanner.nextDouble();
                    scanner.nextLine();
                    String nationalSystem;
                    if (!isDemocracy) {
                        System.out.print("정치체제를 입력하세요: ");
                        nationalSystem = scanner.next();
                        nations.add(
                            new NotRepublicNation(
                                nationName, nationalSystem, isAtWar, creditRating, new StrictImmigrationDepartment()
                            )
                        );
                    } else {
                        nations.add(
                            new RepublicNation(
                                nationName, isAtWar, creditRating, new RepublicImmigrationDepartment()
                            )
                        );
                    }
                    System.out.println("국가가 등록되었습니다.");
                case 2:
                    System.out.print("시민 이름을 입력하세요: ");
                    String citizenName = scanner.nextLine();

                    if (nations.isEmpty()) {
                        System.out.println("등록된 국가가 없습니다. 먼저 국가를 등록해주세요.");
                        break;
                    }

                    System.out.println("국적을 선택하세요:");
                    for (int i = 0; i < nations.size(); i++) {
                        System.out.println((i + 1) + ". " + nations.get(i).toString());
                    }
                    System.out.print("선택: ");
                    nationIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (!isValidIndex(nationIndex, nations)) {
                        System.out.println("잘못된 선택입니다.");
                        break;
                    }

                    String nationality = nations.get(nationIndex).toString();

                    System.out.print("여권이 있나요? (true/false): ");
                    boolean hasPassport = scanner.nextBoolean();
                    System.out.print("범죄 기록이 있나요? (true/false): ");
                    boolean hasCriminalRecord = scanner.nextBoolean();
                    scanner.nextLine();

                    citizens.add(new Citizen(citizenName, nationality, hasPassport, hasCriminalRecord));
                    System.out.println("시민이 등록되었습니다.");
                    break;

                case 3:
                    if (nations.isEmpty() || citizens.isEmpty()) {
                        System.out.println("등록된 국가나 시민이 없습니다.");
                        break;
                    }
                    System.out.println("여행할 시민을 선택하세요:");
                    for (int i = 0; i < citizens.size(); i++) {
                        System.out.println((i + 1) + ". " + citizens.get(i).toString());
                    }
                    System.out.print("선택: ");
                    citizenIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    System.out.println("여행할 국가를 선택하세요:");
                    for (int i = 0; i < nations.size(); i++) {
                        System.out.println((i + 1) + ". " + nations.get(i).toString());
                    }
                    System.out.print("선택: ");
                    nationIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (isValidIndex(citizenIndex, citizens) && isValidIndex(nationIndex, nations)) {
                        Travelable selectedCitizen = citizens.get(citizenIndex);
                        Nation selectedNation = nations.get(nationIndex);
                        selectedCitizen.travel(selectedNation);
                    } else {
                        System.out.println("잘못된 선택입니다.");
                    }
                    break;

                case 4:  // 단체 여행
                    if (nations.isEmpty() || citizens.isEmpty()) {
                        System.out.println("등록된 국가나 시민이 없습니다.");
                        break;
                    }
                    System.out.println("단체 여행을 떠날 시민들을 선택하세요 (여러 명 선택 가능, 공백으로 구분):");
                    for (int i = 0; i < citizens.size(); i++) {
                        System.out.println((i + 1) + ". " + citizens.get(i).toString());
                    }
                    System.out.print("선택: ");
                    String[] citizenIndices = scanner.nextLine().split(" ");
                    List<Citizen> selectedCitizens = new ArrayList<>();
                    for (String indexStr : citizenIndices) {
                        int index = Integer.parseInt(indexStr) - 1;
                        if (isValidIndex(index, citizens)) {
                            selectedCitizens.add(citizens.get(index));
                        } else {
                            System.out.println("잘못된 시민 선택: " + (index + 1));
                        }
                    }

                    System.out.println("여행할 국가를 선택하세요:");
                    for (int i = 0; i < nations.size(); i++) {
                        System.out.println((i + 1) + ". " + nations.get(i).toString());
                    }
                    System.out.print("선택: ");
                    nationIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (isValidIndex(nationIndex, nations)) {
                        Nation selectedNation = nations.get(nationIndex);
                        for (Citizen citizen : selectedCitizens) {
                            citizen.travel(selectedNation);
                        }
                    } else {
                        System.out.println("잘못된 국가 선택입니다.");
                    }
                    break;

                case 5:
                    if (nations.isEmpty() || citizens.isEmpty()) {
                        System.out.println("등록된 국가나 시민이 없습니다.");
                        break;
                    }
                    System.out.println("이민할 시민을 선택하세요:");
                    for (int i = 0; i < citizens.size(); i++) {
                        System.out.println((i + 1) + ". " + citizens.get(i).toString());
                    }
                    System.out.print("선택: ");
                    citizenIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    System.out.println("이민할 국가를 선택하세요:");
                    for (int i = 0; i < nations.size(); i++) {
                        System.out.println((i + 1) + ". " + nations.get(i).toString());
                    }
                    System.out.print("선택: ");
                    nationIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (isValidIndex(citizenIndex, citizens) && isValidIndex(nationIndex, nations)) {
                        Travelable selectedCitizen = citizens.get(citizenIndex);
                        Nation selectedNation = nations.get(nationIndex);
                        selectedCitizen.emigrate(selectedNation);
                    } else {
                        System.out.println("잘못된 선택입니다.");
                    }
                    break;

                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;

                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        }
    }

    private static boolean isValidIndex(int index, List<?> list) {
        return index >= 0 && index < list.size();
    }
}
