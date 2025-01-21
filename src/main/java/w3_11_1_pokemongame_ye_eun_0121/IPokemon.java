package w3_11_1_pokemongame_ye_eun_0121;

public interface IPokemon {
    // attack
    public void attack (Pokemon tgPokemon);

    // flee
    public void flee(int enemyLv);

    // evolve : 향후 조건 추가됨에 따라 오버로딩 가능
    public Pokemon evolve();

}
