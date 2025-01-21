package w3_11_1_pokemongame_ye_eun_0121;

import lombok.Getter;

@Getter
public class FlyPokemon extends Pokemon implements IFlyable {

    public FlyPokemon(String pokemonName, String customName, int pokeLevel, int HP, PokeDex.PokeCategory pokeCategory) {
        super(pokemonName, customName, pokeLevel, HP, pokeCategory);
    }

    @Override
    public void fly(String tgCity) {
    }

    @Override
    public void crossOcean(String tgCity) {
        fly(tgCity);
    }
}
