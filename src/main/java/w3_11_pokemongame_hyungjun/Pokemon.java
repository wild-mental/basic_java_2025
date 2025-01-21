package w3_11_pokemongame_hyungjun;


import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter @Setter
public class Pokemon implements IPokemon {
    private String pokemonDexNumber;
    private String pokemonName;// 포켓몬 이름
    private int HP;
    private String customName;
    private int level;
    private int dmg;
    private Pokemon nextEvolveForm;
            // = null; (다음 진화형이 없는 경우)

    private PokeDex.PokeCategory category;
    //희귀도에 따른 포켓몬 잡을 확률, 포켓몬 등급마다 잡을 확률이 다르게 해야 하기 때문에 생성

    @Override
    public void attack(Pokemon tgPokemon) {
        // 데이터 : 타켓 포켓몬의 getHP(), setHP()
        // 그 외 추가 동작 및 결과 출력
    }

    @Override
    public void flee(int enemyLv) {
        // 결과 출력
    }

    @Override
    public Pokemon evolve() {
        // 다음 진화형이 무엇인지 PokeDex 에 등록
        // 현재 Pokemon 타입에서 다음 진화형을 확인할 수 있게 참조시켜 놓기
        // return new EvolvedPokemon(this);

        return EvolvedPokemon.evolveFrom(this);
    }

    public Pokemon(String pokemonDexNumber) {
        Pokemon dexPokemon = PokeDex.searchPokemonByDexNum(pokemonDexNumber);
        this.pokemonDexNumber = pokemonDexNumber;
        this.pokemonName = dexPokemon.getPokemonName();
        // 포켓몬 이름 더미 데이터를 넣기 위한 생성자
    }

    public Pokemon(String pokemonDexNumber, String pokemonName, int HP, int level, PokeDex.PokeCategory category, int dmg) {
        this.pokemonDexNumber = pokemonDexNumber;
        this.pokemonName = pokemonName;
        this.HP = HP;
        this.level = level;
        this.category = category;
        this.dmg = dmg;
    }

    // 생성자를 클래스 내부에서만 접근할 수 있게 변경하고,
    // PokeDex -> 몬스터 이름별 제한된 개수를 사전에 등록하고
    Map<String, Integer> pokemonCntLimit = new HashMap<>();
    Map<String, Integer> pokemonCntCurrent = new HashMap<>();
    // 현재 생성된 개수를 관리하는 변수를 static 으로 선언 후
    // 생성자 호출 전, 가용 개수가 남았는지 검사하도록 메서드 구현

// 포켓몬 성별
}