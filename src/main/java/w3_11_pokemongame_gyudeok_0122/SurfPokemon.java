package w3_11_pokemongame_gyudeok_0122;

import lombok.Getter;

@Getter
public class SurfPokemon extends Pokemon implements ISurfable {
    public SurfPokemon(String pokemonName) {
        super(pokemonName);
    }

    @Override
    public void surf(String tgCity) {

    }

    @Override
    public void crossOcean(String tgCity) {
        surf(tgCity);
    }
}
