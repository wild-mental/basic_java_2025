package w3_11_pokemongame_hyungjun;

import lombok.Getter;

@Getter
public class FlyPokemon extends Pokemon implements IFlyable {

    public FlyPokemon(String pokemonDexNumber) {
        super(pokemonDexNumber);
    }

    @Override
    public void fly(String tgCity) {

    }

    @Override
    public void crossOcean(String tgCity) {
        fly(tgCity);
    }
}