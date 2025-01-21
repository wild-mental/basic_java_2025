package w3_11_1_pokemongame_ye_eun_0121;

import lombok.Getter;

import java.util.*;

@Getter
public class Pokemon implements IPokemon {

    //    final private String pokemonName;
//
//    public Pokemon(String pokemonName) {
//        this.pokemonName = pokemonName;
//    }
    private String pokemonName;
    private String customName;
    private int pokeLevel;
    private int HP;
    private PokeDex.PokeCategory pokeCategory;
    int evolveLevel = 1; // 초기 레벨 1

    // 키: 스킬 명, 값: 효과, 데미지
    // [질문] 포켓 덱스에 스킬 관련 정보들을 포함하려면 어떻게 해야 하나요? 생성자 매개변수에 포함하기?
    Map<String, PokeSkill> skillSet;

    public Pokemon(String pokemonName, String customName, int pokeLevel, int HP, PokeDex.PokeCategory pokeCategory) {
        this.pokemonName = pokemonName;
        this.customName = customName;
        this.pokeLevel = pokeLevel;
        this.HP = HP;
        this.pokeCategory = pokeCategory;
        this.skillSet = PokeDex.pokeSkills.get(pokemonName);

        // 포켓몬이 새롭게 생성될 때마다 포켓몬 도감에 자동으로 추가되게 하기
        PokeDex.addPokemon(this);
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setCustomName() {
        this.customName = customName;
    }

    // 스킬 가져오기
    private PokeSkill getRandomSkill() {
        // 랜덤한 스킬 pick 수행 (스킬 전체 리스트 순회하며 1/2 확률로 스킬 사용)
        for (PokeSkill skill : skillSet.values()) {
            if (Math.random() > 0.5) return skill;
        }
        return null;
    }

    // 스킬 사용
    public void useSkill(Pokemon tgPokemon) {
        // [스킬 랜덤 Pick]
        PokeSkill skillToUse = getRandomSkill();
        if (skillToUse == null) {
            System.out.println("스킬을 찾을 수 없습니다.");
            return;
        }
        // 스킬 선택 및 사용 결과 출력
        System.out.println(
            "사용한 스킬: " + skillToUse.getSkillName() +
            " | 데미지: " + skillToUse.getDamage() +
            " | 효과: " + skillToUse.getEffect()
        );
        tgPokemon.setHP(tgPokemon.getHP() - skillToUse.getDamage());  // setter 사용, 상대 HP 감소
    }

    @Override
    public void attack(Pokemon tgPokemon) {
        // 상대 포켓몬과 전투 시작!!
        System.out.println(this.pokemonName + "이(가) " + tgPokemon.getPokemonName() + "과(와) 전투를 시작합니다!");

        // 턴마다 공격을 주고받으며 전투 진행, 둘다 죽기 전까지 반복
        while (this.HP > 0 && tgPokemon.getHP() > 0) {
            // 자신의 턴: 스킬 사용
            System.out.println(this.pokemonName + "의 턴!");
            useSkill(tgPokemon);  // 자신의 스킬 사용
            System.out.println(tgPokemon.getPokemonName() + "의 현재 HP: " + tgPokemon.getHP());

            if (tgPokemon.getHP() <= 0) {
                System.out.println(tgPokemon.getPokemonName() + "이(가) 쓰러졌습니다! " + this.pokemonName + " 승리!");
                break; // 전투 끝!
            }

            // 상대의 턴: 스킬 사용
            System.out.println(tgPokemon.getPokemonName() + "의 턴!");
            tgPokemon.useSkill(this);  // 상대의 스킬 사용
            System.out.println(this.pokemonName + "의 현재 HP: " + this.HP);

            if (this.HP <= 0) {
                System.out.println(this.pokemonName + "이(가) 쓰러졌습니다! " + tgPokemon.getPokemonName() + " 승리!");
                break;
            }
        }
    }

    // 도망치기
    @Override
    public void flee(int enemyLv) {
        if (enemyLv > this.pokeLevel) {
            System.out.println("도망갑니다.");
        }
    }

    @Override
    public Pokemon evolve() {
        // 진화 조건 레벨 10이상 혹은 20이상 될 때마다
        if (pokeLevel >= 10 && pokeLevel >= 20) {
            System.out.println(this.getPokemonName() + "가 진화합니다!!");
            // 레벨이 1씩 상승
            this.evolveLevel += 1;
            return new EvolvedPokemon(
                    this.getPokemonName(),
                    this.getCustomName(),
                    this.getPokeLevel(),
                    this.getEvolveLevel() + 1,
                    this.getHP(),
                    this.getPokeCategory());
        } else {
            System.out.println("진화 조건이 충족되지 않았습니다.");
            return this;
        }
    }
}

        // 데이터 및 동작 : this.getLevel, this.setters
        // 기존 객체 참조 삭제
        // 진화된 객체 생성 및 리턴

        // 리턴타입은 부모타입으로 선언되어 있는데, 실제 리턴 객체는 자식 타입으로 반환
        // 다형성에 따른 부모 타입으로의 변환
