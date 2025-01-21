package w3_11_1_pokemongame_ye_eun_0121;

import lombok.Getter;

@Getter
public class SurfPokemon extends Pokemon implements ISurfable {

    public SurfPokemon(String pokemonName, String customName, int evolveLevel, int HP, PokeDex.PokeCategory pokeCategory) {
        super(pokemonName, customName, evolveLevel, HP, pokeCategory);
    }

    @Override
    public void surf(String tgCity) {

    }

    @Override
    public void crossOcean(String tgCity) {
        surf(tgCity);
    }
}
