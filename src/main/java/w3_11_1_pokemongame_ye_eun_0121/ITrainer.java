package w3_11_1_pokemongame_ye_eun_0121;

import java.util.List;
import java.util.Map;

public interface ITrainer {
    public void hunt(Pokemon wildpokemon);
    public Pokemon capture(Pokemon wildPokemon);
    public void battle(ITrainer enemyTrainer);
    public void battle(Pokemon wildPokemon);
    public Pokemon searchDex(String pokemonName);
    public Map<String, Pokemon> searchDex(PokeDex.PokeCategory category);

    List<Pokemon> getCapturedPokemonList();
}
