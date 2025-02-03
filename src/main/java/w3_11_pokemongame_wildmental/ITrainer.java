package w3_11_pokemongame_wildmental;

import java.util.Map;

public interface ITrainer<POKEMON_TYPE extends Pokemon> {
    void hunt(POKEMON_TYPE wildPokemon);
    POKEMON_TYPE capture(POKEMON_TYPE wildPokemon);
    void battle(ITrainer enemyTrainer);
    void battle(POKEMON_TYPE wildPokemon);
    Pokemon searchDex(String pokemonName);
    Map<String, Pokemon> searchDex(PokeDex.PokeCategory category);
    void trade(Trainer<POKEMON_TYPE> tgTrainer);
}
