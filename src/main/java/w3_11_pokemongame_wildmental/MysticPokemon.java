package w3_11_pokemongame_wildmental;

import lombok.Getter;

@Getter
public class MysticPokemon extends Pokemon {
    public MysticPokemon(String pokemonName, int HP, PokeDex.PokeCategory pokeCategory) {
        super(pokemonName, HP, pokeCategory);
    }

    public MysticPokemon(String pokemonName, String customName, int HP, PokeDex.PokeCategory pokeCategory) {
        super(pokemonName, customName, HP, pokeCategory);
    }

    // TODO : 교환 시 특별한 동작 구현!
}
