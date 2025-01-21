package w3_11_pokemongame_hyungjun;

import lombok.Getter;

@Getter
public class EvolvedPokemon extends Pokemon {
    // 진화 전 개체에서 진화형 개체를 어떻게 조회할 수 있는가?

    // EvolvedPokemon is a Pokemon : 참인 명제
    public EvolvedPokemon(String pokemonDexNumber) {
        super(pokemonDexNumber);
    }

    static public EvolvedPokemon evolveFrom(Pokemon formBefore) {
        // formBefore 를 통해서
        // 1) 진화 대상 포켓몬의 넘버를 Dex 에 등록 또는
        //    Pokemon 객체 자체가 가지고 있어야 함
        String evolveTgNum = "1";  // Num 이라고 이름지을 변수는 Integer 또는 int 로 핸들링 필요
        return new EvolvedPokemon(evolveTgNum);
    }


}