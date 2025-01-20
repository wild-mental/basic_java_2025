package w3_7_gyudeok_travelsystem;

abstract interface INation {
    public boolean TravelOrImmigrant(Person person, String userChoice);
    public boolean ImmigrationApproval(Person person);
    public boolean TravelApproval(Person person);

}
