package w3_11_1_pokemongame_ye_eun_0121;

import lombok.Getter;

@Getter
public class EvolvedPokemon extends Pokemon {
        // 진화한 포켓몬은 포켓몬이다 : 참인 명제
    public EvolvedPokemon(String pokemonName, String customName, int pokeLevel, int evolvedLevel, int HP,
                          PokeDex.PokeCategory pokeCategory) {
        super(pokemonName, customName,pokeLevel, HP, pokeCategory);
        this.evolveLevel = evolvedLevel;
    }
}
