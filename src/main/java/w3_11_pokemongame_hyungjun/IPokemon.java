package w3_11_pokemongame_hyungjun;

public interface IPokemon {
    public void attack(Pokemon tgPokemon); // 왜 public으로 선언?
    public void flee(int enemyLv);
    // 향후 오버로딩 가능
    public Pokemon evolve();
}
