package w3_11_pokemongame;

import lombok.Getter;

@Getter
public class FlyPokemon extends Pokemon implements IFlyable {
    @Override
    public void fly(String tgCity) {

    }

    @Override
    public void crossOcean(String tgCity) {
        fly(tgCity);
    }
}