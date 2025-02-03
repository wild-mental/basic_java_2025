package w3_11_pokemongame_wildmental;

import lombok.Getter;

import java.util.*;

// Generic 을 적용할 때 "코드 수정" 방식으로 적용 -> 연습용
@Getter
public class Trainer<POKEMON_TYPE extends Pokemon> implements ITrainer<POKEMON_TYPE> {
    List<POKEMON_TYPE> capturedPokemonList = new ArrayList<>();
    // 진화/변화 시의 결과가 타입 벗어나는 경우 사용
    List<Pokemon> capturedNormalPokemonList = new ArrayList<>();
    Map<String, POKEMON_TYPE> capturedPokemonByName = new HashMap<>();
    Scanner inputReader = new Scanner(System.in);

    @Override
    public void hunt(POKEMON_TYPE wildPokemon) {
        System.out.println("야생의 포켓몬 " + wildPokemon.getPokemonName() + "을(를) 만났습니다!");
        // 야생의 포켓몬을 만나서 싸우거나 잡거나 그냥 지나가거나
        System.out.println("1: battle / 2: capture / else: pass");
        int battleOrCapture = inputReader.nextInt();
        switch (battleOrCapture) {
            case 1:
                battle(wildPokemon);
                break;
            case 2:
                capture(wildPokemon);
                POKEMON_TYPE capturedPokemon = capture(wildPokemon);
                if (capturedPokemon != null) {
                    capturedPokemonList.add(capturedPokemon);
                    capturedPokemonByName.put(
                        capturedPokemon.getPokemonName(), capturedPokemon
                    );
                }
                break;
            default:
                System.out.println("야생의 포켓몬 " + wildPokemon.getPokemonName() + "을(를) 그냥 지나갑니다.");
                break;
        }
    }

    @Override
    public POKEMON_TYPE capture(POKEMON_TYPE wildPokemon) {
        // 확률적 포획 성공 (가중치를 적용)
        // 몬스터볼 소진 등은 TBD
        return wildPokemon; //  100% 포획
    }

    @Override
    public void battle(POKEMON_TYPE wildPokemon) {
        // Pokemon 에 대한 getter(), setter() 호출
        // this.getCapturedPokemonList() 등 호출
        List<POKEMON_TYPE> myLineUp = this.getCapturedPokemonList();
        for (POKEMON_TYPE pokemon: myLineUp) {
            while (((pokemon.getHP()!=0) && (wildPokemon.getHP()!=0))) {
                pokemon.attack(wildPokemon);
                wildPokemon.attack(pokemon);
            }
        }
        // 결과 출력
        if (wildPokemon.getHP()==0) {
            System.out.println("Win!");
        } else {
            System.out.println("Lost!");
        }
    }

    @Override
    public void battle(ITrainer enemyTrainer) {
        //
    }

    @Override
    public Pokemon searchDex(String pokemonName) {
        return PokeDex.searchPokemon(pokemonName);
    }

    @Override
    public Map<String, Pokemon> searchDex(PokeDex.PokeCategory category) {
        return PokeDex.searchPokemon(category);
    }

    @Override
    public void trade(Trainer<POKEMON_TYPE> tgTrainer) {
        System.out.println("포켓몬 트레이드를 시작합니다!");
        // 1) 소지 포켓몬 옵션 출력 및 선택
        // 내 포켓몬
        int idx = 0;
        for (Pokemon pokemon: this.getCapturedPokemonList()) {
            System.out.println(idx + ": " + pokemon);
            idx++;
        }
        System.out.print("교환할 내 포켓몬을 선택하세요:");
        int myPokemonPickIdx = inputReader.nextInt();
        POKEMON_TYPE myPickedPokemon = this.capturedPokemonList.get(myPokemonPickIdx);

        // 상대 포켓몬
        idx = 0;
        for (Pokemon pokemon: tgTrainer.getCapturedPokemonList()) {
            System.out.println(idx + ": " + pokemon);
            idx++;
        }
        System.out.print("교환할 상대 포켓몬을 선택하세요:");
        int tgPokemonPickIdx = inputReader.nextInt();
        POKEMON_TYPE tgPickedPokemon = tgTrainer.capturedPokemonList.get(tgPokemonPickIdx);

        // 2) 교환 대상 포켓몬 확인 출력
        System.out.println(
            "내 포켓몬 " + myPickedPokemon + " 과\n" +
            "상대 포켓몬 " + tgPickedPokemon + " 을 교환합니다!"
        );

        // 3) 교환 수행
        tgTrainer.capturedPokemonList.set(tgPokemonPickIdx, myPickedPokemon);
        this.capturedPokemonList.set(myPokemonPickIdx, tgPickedPokemon);

        // 4) MysticPokemon 한정 교환 후 이벤트 발생
        Pokemon result = null;
        POKEMON_TYPE mysticResult = null;
        // POKEMON_TYPE 이 MysticPokemon 인 경우에만 아래 이벤트 발생 가능
        if (tgPickedPokemon instanceof MysticPokemon myMysticPokemon) {
            System.out.println("트레이딩의 결과 신비의 포켓몬 " + myMysticPokemon.getPokemonName() + "이 반응합니다!");
            // 형 안정성을 보장할 수 없는 데이터 변환이 있음
            try {
                result = myMysticPokemon.getMysticAction().triggerMysticAction(myMysticPokemon);
                mysticResult = (POKEMON_TYPE) result;
            } catch (Exception e) {
                // 타입 캐스팅 문제 시 출력
                System.out.println("트레이너 타입과 맞지 않는 결과 발생:" + result.getClass().getName());
                System.out.println("포켓몬의 Mystic 변화에 실패했습니다!");  // 특정 속성 트레이너는 진화/변화 결과가 속성과 맞지 않으면 실패
                System.out.println(e.getMessage());
            }
            this.capturedPokemonList.set(myPokemonPickIdx, mysticResult);
        }
        if (myPickedPokemon instanceof MysticPokemon tgMysticPokemon) {
            System.out.println("트레이딩의 결과 신비의 포켓몬 " + tgMysticPokemon.getPokemonName() + "이 반응합니다!");
            // 형 안정성을 보장할 수 없는 데이터 변환이 있음
            // 형 안정성을 보장할 수 없는 데이터 변환이 있음
            try {
                result = tgMysticPokemon.getMysticAction().triggerMysticAction(tgMysticPokemon);
                mysticResult = (POKEMON_TYPE) result;
            } catch (Exception e) {
                // 타입 캐스팅 문제 시 출력
                System.out.println("트레이너 타입과 맞지 않는 결과 발생:" + result.getClass().getName());
                System.out.println("포켓몬의 Mystic 변화에 실패했습니다!");  // 특정 속성 트레이너는 진화/변화 결과가 속성과 맞지 않으면 실패
                System.out.println(e.getMessage());
            }
            tgTrainer.capturedPokemonList.set(tgPokemonPickIdx, mysticResult);
        }

        // 5) 교환 후 결과 출력
        System.out.println(
            "교환 결과:\n" +
                "\t내 포켓몬:\n" +
                "\t\t" + this.capturedPokemonList + "\n" +
                "\t상대 포켓몬:\n" +
                "\t\t" + tgTrainer.capturedPokemonList
        );
    }

    public void crossOcean(String tgCity) {
        for (POKEMON_TYPE pokemon: this.getCapturedPokemonList()) {
            if (pokemon instanceof IOceanCrossable) {
                ((IOceanCrossable) pokemon).crossOcean(tgCity);
            }
        }
    }

    public void getPokemon(POKEMON_TYPE[] trainer1Pokemon) {
        capturedPokemonList.addAll(Arrays.asList(trainer1Pokemon));
    }

    public void getPokemon(POKEMON_TYPE newPokemon) {
        capturedPokemonList.add(newPokemon);
    }
}