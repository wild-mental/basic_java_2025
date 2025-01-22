package w3_11_pokemongame_hyungjun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class SurfPokemon extends Pokemon implements ISurfable {
    public SurfPokemon(String pokemonDexNumber) {
        super(pokemonDexNumber);
    }

    @Override
    public void surf(String tgCity) {

    }

    @Override
    public void crossOcean(String tgCity) {
        surf(tgCity);
    }
}