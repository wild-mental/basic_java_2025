package w3_11_1_pokemongame_ye_eun_0121;

// import lombok.Getter;

// @Getter -> 외부에서 접근 X
public class MysticPokemon extends Pokemon {
    MysticPokemon(String pokemonName, String customName, int pokeLevel, int HP, PokeDex.PokeCategory pokeCategory) {
        super(pokemonName, customName, pokeLevel, HP, pokeCategory);
    }

    // 출력하면 ???만 뜨게
    @Override
    public String toString() {
        return "???";
    }
}
