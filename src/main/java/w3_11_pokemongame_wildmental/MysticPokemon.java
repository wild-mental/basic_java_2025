package w3_11_pokemongame_wildmental;

import lombok.Getter;

@Getter
public class MysticPokemon extends Pokemon {
    // 트레이드 되었는가?
    // -> 비동기 처리 등
    // 트레이드 즉시 수행할 수 있는 동작

    // 1) 필드 추가
    // Mystic 이기 때문에 가지고 있는 속성을 넣어주자!
    // 2) 메서드 추가
    @Getter
    private IMysticActionable mysticAction;

    // Dex 전용 생성자
    public MysticPokemon(String pokemonName, int HP, PokeDex.PokeCategory pokeCategory) {
        super(pokemonName, HP, pokeCategory);
    }

    // 유저 포켓몬 전용 생성자
    // (Mystic Action 사전에서 검색해 초기화)
    public MysticPokemon(String pokemonName, String customName, int HP, PokeDex.PokeCategory pokeCategory) {
        super(pokemonName, customName, HP, pokeCategory);
        this.mysticAction = PokeDex.mysticActionDex.get(pokemonName);
    }

    // TODO : 교환 시 특별한 동작 구현!
    //   -> 함수형 인터페이스로 구현하기!
    @FunctionalInterface
    public interface IMysticActionable {
        Pokemon triggerMysticAction();
    }
}
