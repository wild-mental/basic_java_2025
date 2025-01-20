package w3_7_taeri_travel_system;

public class RepublicImmigrationDepartment extends Nation.ImmigrationDepartment {
    @Override
    public boolean screenImmigration(Citizen citizen, boolean isAtWar) {
        if (isAtWar) {
            System.out.println("입국 거부: 전시 상태입니다.");
            return false;
        }
        if (citizen.hasCriminalRecord()) {
            System.out.println("입국 거부: 범죄 기록이 있습니다.");
            return false;
        }
        return true;
    }
}
