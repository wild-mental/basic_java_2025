package w3_11_pokemongame;

import lombok.Getter;

@Getter
public class SurfPokemon extends Pokemon implements ISurfable {
    @Override
    public void surf(String tgCity) {

    }

    @Override
    public void crossOcean(String tgCity) {
        surf(tgCity);
    }
}
