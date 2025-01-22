package w3_11_pokemongame_gyudeok_0122;

public interface ITrainer {
    boolean hunt();
    Pokemon capture(Pokemon wildPokemon);
    void battle(ITrainer enemyTrainer);
    void battle(Pokemon wildPokemon);
    PokeDex.PokeAttribute searchDex(String pokemonName);
    PokeDex.PokeAttribute searchDex(PokeDex.PokeCategory category);
}
