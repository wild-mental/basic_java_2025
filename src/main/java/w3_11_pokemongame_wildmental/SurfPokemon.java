package w3_11_pokemongame_wildmental;

import lombok.Getter;

@Getter
public class SurfPokemon extends Pokemon implements ISurfable {
    public SurfPokemon(String pokemonName, int HP, PokeDex.PokeCategory pokeCategory) {
        super(pokemonName, HP, pokeCategory);
    }

    public SurfPokemon(String pokemonName, String customName, int HP, PokeDex.PokeCategory pokeCategory) {
        super(pokemonName, customName, HP, pokeCategory);
    }

    @Override
    public void surf(String tgCity) {
        // 미구현
    }

    @Override
    public void surf(PokeTown pokeTown) {
        System.out.println("Surf to :" + pokeTown.getName());
    }

    @Override
    public void crossOcean(String tgCity) {
        surf(tgCity);
    }

    @Override
    public void crossOcean(PokeTown pokeTown) {
        this.surf(pokeTown);  // 동작 위임
    }
}
