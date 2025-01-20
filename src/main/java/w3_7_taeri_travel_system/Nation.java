package w3_7_taeri_travel_system;

public abstract class Nation {
    private String name;
    private String governmentType;
    private boolean isAtWar;
    private double creditRating;

    public boolean isAtWar() {
        return isAtWar;
    }

    public ImmigrationDepartment nationalImmigrationDepartment;

    public Nation(
        String name, String governmentType, boolean isAtWar, double creditRating,
        ImmigrationDepartment immigrationDepartment
    ) {
        this.name = name;
        this.governmentType = governmentType;
        this.isAtWar = isAtWar;
        this.creditRating = creditRating;
        this.nationalImmigrationDepartment = immigrationDepartment;
    }

    static abstract class ImmigrationDepartment implements ImmigrationPolicy {
        @Override
        public abstract boolean screenImmigration(Citizen citizen, boolean isAtWar);
    }

    public boolean screenImmigration(Citizen citizen) {
        return this.nationalImmigrationDepartment.screenImmigration(citizen, this.isAtWar);
    }

    @Override
    public String toString() {
        return "Nation{name='" + name + '\'' +
                ", governmentType='" + governmentType + '\'' +
                ", isAtWar=" + isAtWar +
                ", creditRating=" + creditRating + '}';
    }
}

class RepublicNation extends Nation {
    public RepublicNation(
        String name, boolean isAtWar, double creditRating,
        Nation.ImmigrationDepartment immigrationDepartment
    ) {
        super(name, "Republic", isAtWar, creditRating, immigrationDepartment);
    }

    public RepublicNation(
        String name, String governmentType, boolean isAtWar, double creditRating,
        Nation.ImmigrationDepartment immigrationDepartment
    ) {
        super(name, governmentType, isAtWar, creditRating, immigrationDepartment);
    }
}

class NotRepublicNation extends Nation {
    public NotRepublicNation(
        String name, String nationalSystem, boolean isAtWar, double creditRating,
        ImmigrationDepartment immigrationDepartment
    ) {
        super(name, nationalSystem, isAtWar, creditRating, immigrationDepartment);
    }
}