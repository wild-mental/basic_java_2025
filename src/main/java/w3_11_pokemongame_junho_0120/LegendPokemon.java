package w3_11_pokemongame_junho_0120;

import lombok.Getter;

@Getter
public class LegendPokemon extends Pokemon {
    private static LegendPokemon legendPokemon;
    public LegendPokemon(String pokemonName, int HP, int level, String type) {
        super(pokemonName, HP, level, type);
    } // 종류당 단 한마리만 생성해야 함!

    // TODO: 정해진 방식으로만 생성자 접근하기
    //      생성자 은닉 후, 클래스 내부에서 검사를 통과해야만 호출하도록 메서드 작성

    public static LegendPokemon getLegendPokemon() {
        return legendPokemon;
    }
}
