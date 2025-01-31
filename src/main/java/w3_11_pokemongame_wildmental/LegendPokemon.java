package w3_11_pokemongame_wildmental;

import lombok.Getter;

@Getter
public class LegendPokemon extends Pokemon {
    public LegendPokemon(String pokemonName, int HP, PokeDex.PokeCategory pokeCategory) {
        super(pokemonName, HP, pokeCategory);
    }

    public LegendPokemon(String pokemonName, String customName, int HP, PokeDex.PokeCategory pokeCategory) {
        super(pokemonName, customName, HP, pokeCategory);
    }
}
