package w3_11_pokemongame_hyungjun;

import lombok.Getter;

@Getter
public class MysticPokemon extends Pokemon {

    private String captureDifficulty; // 포획 난이도
    private String location; //출현 장소

    public MysticPokemon(String pokemonDexNumber) {
        super(pokemonDexNumber);
    }
}