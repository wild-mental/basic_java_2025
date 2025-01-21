package w3_11_pokemongame_sooyoung;

import lombok.Getter;

@Getter
public class EvolvedPokemon extends Pokemon {
    public EvolvedPokemon(String pokemonName, int HP, int level) {
        super(pokemonName, HP, level);
    }
}
