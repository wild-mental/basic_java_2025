package w3_8_pocketmon_minsung;

import java.util.Map;

public interface ITrainer {
   void hunt(Pokemon wildPokemon);
   Pokemon capture(Pokemon wildPokemon);
   void battle(ITrainer enemyTrainer);
   void battle(Pokemon wildPokemon);
   Pokemon searchDex(String pokemonName);
   Map<String, Pokemon> searchDex(PokeDex.PokeCategory category);
   void showPokemons();
}
