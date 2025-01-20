package w3_11_pokemongame_junho_0120;

import java.util.Map;

public interface ITrainer {
    void hunt(Pokemon wildPokemon);
    Pokemon capture(Pokemon wildPokemon);
    void battle(ITrainer enemyTrainer);
    void battle(Pokemon wildPokemon);
    Pokemon searchDex(String pokemonName);
    Map<String, Pokemon> searchDex(PokeDex.PokeCategory category);
}
