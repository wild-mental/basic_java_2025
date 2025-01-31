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
        Pokemon triggerMysticAction(MysticPokemon mysticPokemon);
        // 인터페이스 자체에 현재 객체와 동일한 객체를 부여하면,
        // static 한 동작이 아니라, 객체 기준 동작으로 수행 가능 (instance 맥락)
    }

    // Mystic Action 유형 1  (인스턴스 멤버 참조)
    public Pokemon mysticEvolve() {
        // 인스턴스 메서드이기 때문에 반드시 기준 인스턴스 파라미터가 존재하는 경우에만 호출 가능
        // 인스턴스 참조를 포함하는 로직 구현 가능
        System.out.println(this.getPokemonName()+ "의 Mystic Action 으로 진화가 일어납니다!");
        // 상속구조 등을 통한 this, super 기반 메서드 호출 가능
        return this.evolve();
    }

    public Pokemon mysticTransform() {
        System.out.println(this.getPokemonName()+ "의 Mystic Action 으로 변형이 일어납니다!");
        return new LegendPokemon(
            // TODO: 전설 포켓몬은 특수한 처리 추가 구현 필요
            this.getPokemonName(), this.getCustomName(), this.getHP(),
            PokeDex.PokeCategory.LEGENDARY
        );
    }
}
