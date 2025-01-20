package w3_7_travelsystem;

import java.util.*;

public class TravelSystemMain {
    static List<Citizen> createNoNationCitizens() {
        Citizen noNation1 = new Citizen(
            "putin", null, 1,
            false, true, true
        );
        Citizen noNation2 = new Citizen(
            "johan", null, 1,
            false, false, true
        );
        return new ArrayList<>(
            Arrays.asList(
                noNation1, noNation2
            )
        );
    }

    public static void main(String[] args) {
        Nation korea = Nation.getRegisteredNation("Korea");
        // System.out.println("한국 국적 시민들: " + korea.getNationalCitizen());
        System.out.println("한국의 여행 관리국: " + korea.getTravelControlDepartment());
        Nation us = Nation.getRegisteredNation("US");
        // System.out.println("미국 국적 시민들: " + us.getNationalCitizen());
        System.out.println("미국의 여행 관리국: " + us.getTravelControlDepartment());

        Nation russ = Nation.getRegisteredNation("Russia");
//        System.out.println("러시아 국적 시민들: " + russ.getNationalCitizen());
        System.out.println("러시아의 여행 관리국: " + russ.getTravelControlDepartment());
        Nation suri = Nation.getRegisteredNation("Suriname");
//        System.out.println("수리남 국적 시민들: " + suri.getNationalCitizen());
        System.out.println("수리남의 여행 관리국: " + suri.getTravelControlDepartment());
        // List<Citizen> noNationCitizens = createNoNationCitizens();

        // System.out.println(citizens);
        // 테스트용 더미데이터 -> 기본 기능들에 대해서 항상 고정적으로 필요한 경우
        //  : Fixture
        //    Initial Data, Bootstrapping Data

        // 2. 개인여행
        //    다양한 스탯을 가진 시민들이 여행 메서드를 호출
//        for (Citizen ctzn: korea.getNationalCitizen()) {
//            ctzn.travel(Nation.getRegisteredNation("US"));
//            ctzn.emigration(Nation.getRegisteredNation("US"));
//        }

        // 3. 개인이민
        //    다양한 스탯을 가진 시민들이 이민 메서드를 호출

        // 4. 단체여행
        // TravelAgency.groupTravel(noNationCitizens.toArray(new Citizen[0]));
        // 5. 단체이민
        // TravelAgency.groupEmigration(noNationCitizens.toArray(new Citizen[0]));
    }
}
