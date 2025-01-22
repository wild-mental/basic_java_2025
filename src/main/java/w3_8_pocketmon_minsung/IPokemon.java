package w3_8_pocketmon_minsung;

public interface IPokemon {
    // attack
    public void attack(Pokemon pokemon);
    // flee
    public void flee(int enemyLv);
    //evolve
    public Pokemon evolve();

}
