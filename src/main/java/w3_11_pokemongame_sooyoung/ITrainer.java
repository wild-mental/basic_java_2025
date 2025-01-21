package w3_11_pokemongame_sooyoung;

import java.util.Map;

public interface ITrainer {
    void hunt(Pokemon wildPokemon);
    Pokemon capture(Pokemon wildPokemon);
    void battle(ITrainer enemyTrainer);
    Pokemon searchDex(String pokemonName);

    Pokemon encounterWildPokemon();

    Map<String, Pokemon> searchDex(PokeDex.PokeCategory category);
}
