package w3_11_pokemongame_hyungjun;

import lombok.Getter;
import w2_3_primitive_n_reference.PrimitiveExample;

@Getter
public class LegendPokemon extends Pokemon {
    private String legendAbility; //전설 능력
    private String captureDifficulty; // 포획 난이도
    private String location; //출현 장소

    // 희귀함 -> 객체가 한정적 -> 얼마나 한정적이어야 하는가?
    // 총 몇개까지 존재할 수 있는가?

}