package w3_11_pokemongame_gyudeok_0122;

import lombok.Getter;

@Getter
public class FlyPokemon extends Pokemon implements IFlyable {
    public FlyPokemon(String pokemonName) {
        super(pokemonName);
    }

    @Override
    public void fly(String tgCity) {

    }

    @Override
    public void crossOcean(String tgCity) {
        fly(tgCity);
    }
}