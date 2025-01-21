package w3_11_1_pokemongame_ye_eun_0121;

import lombok.Getter;

import java.util.Map;

@Getter
public class LegendPokemon extends Pokemon {
    static Map<String, LegendPokemon> existingLegendPokemon;  //

    private LegendPokemon(String pokemonName, String customName, int pokeLevel, int HP, PokeDex.PokeCategory pokeCategory) {
        super(pokemonName, customName, pokeLevel, HP, pokeCategory);
    }

    // [질문] 만약에 이미 하나 있으면 생성 안 되고, 없으면 생성을 어떻게 구현하면 좋을까요?
    // [답] 생성자 호출 전에 검사 단계를 거쳐서 실패/성공이 반환되도록 구현
    public static LegendPokemon createLegendPokemon(
        String pokemonName, String customName, int pokeLevel, int HP,
        PokeDex.PokeCategory pokeCategory
    ) {
        if (existingLegendPokemon.containsKey(pokemonName)) {
            return null;
        }
        existingLegendPokemon.put(
            pokemonName, new LegendPokemon(pokemonName, customName, pokeLevel, HP, pokeCategory)
        );
        return existingLegendPokemon.get(pokemonName);
    }
}
