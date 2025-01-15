package w3_7_travelsystem;

import w3_6_oop.Korea;

import java.util.*;

public class TravelSystemMain {
    static List<Citizen> createCitizens() {
        Citizen kor1 = new Citizen(
            "한규덕", Nation.getRegisteredNation("Korea"), 1,
            true, false, false
        );
        Citizen kor2 = new Citizen(
            "이형준", Nation.getRegisteredNation("Korea"), 1,
            true, true, false
        );
        Citizen us1 = new Citizen(
            "Terry", Nation.getRegisteredNation("US"), 1,
            true, false, false
        );
        Citizen us2 = new Citizen(
            "Mings", Nation.getRegisteredNation("US"), 1,
            true, true, true
        );
        Citizen russ1 = new Citizen(
            "제욱", Nation.getRegisteredNation("Russia"), 1,
            true, false, false
        );
        Citizen russ2 = new Citizen(
            "수정", Nation.getRegisteredNation("Russia"), 2,
            true, false, false
        );
        Citizen suri1 = new Citizen(
            "김민성", Nation.getRegisteredNation("Suriname"), 1,
            true, false, false
        );
        Citizen suri2 = new Citizen(
            "박태림", Nation.getRegisteredNation("Suriname"), 1,
            true, true, false
        );
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
                // 인덱스 기준 짝수 미필, 홀수 군필 | 무국적자는 전과자
                kor1, kor2, us1, us2, russ1, russ2, suri1, suri2, noNation1, noNation2
            )
        );
    }

    public static void main(String[] args) {
        //    시민 종류
        //      각 국가의 시민 2명
        //      이름과 나이
        //      남성/여성
        //      여권 보유여부
        //      병역 이행자/미이행자
        //      전과 보유자/미보유자
        List<Citizen> citizens = createCitizens();
        // System.out.println(citizens);

        // 2. 개인여행
        //    다양한 스탯을 가진 시민들이 여행 메서드를 호출
//        for (Citizen ctzn: citizens) {
//            ctzn.travel(Nation.getRegisteredNation("US"));
//            ctzn.emigration(Nation.getRegisteredNation("US"));
//        }

        // 3. 개인이민
        //    다양한 스탯을 가진 시민들이 이민 메서드를 호출

        // TBD
        // 4. 단체여행
        TravelAgengy.groupTravel(citizens.toArray(new Citizen[0]));
        // 5. 단체이민
        TravelAgengy.groupEmigration(citizens.toArray(new Citizen[0]));
    }
}
