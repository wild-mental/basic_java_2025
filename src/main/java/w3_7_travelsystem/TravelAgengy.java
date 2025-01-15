package w3_7_travelsystem;

import java.util.List;

public class TravelAgengy {
    public static void groupTravel(
        Citizen[] travelers
    ) {
        // TODO : 그룹 여행의 경우 전원 검사부터 수행하는 로직으로 변경 가능
        for (Citizen ctzn: travelers) {
            ctzn.travel(Nation.getRegisteredNation("US"));
        }
    }

    public static void groupEmigration(
        Citizen[] migrators
    ) {
        // TODO : 그룹 이민의 경우 전원 검사부터 수행하는 로직으로 변경 가능
        for (Citizen ctzn: migrators) {
            ctzn.emigration(Nation.getRegisteredNation("US"));
        }
    }
}
