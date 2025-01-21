package w3_11_1_pokemongame_ye_eun_0121;

import lombok.Getter;

import java.util.*;

@Getter
public class Trainer implements ITrainer {
    private String trainerName;
    private boolean isGymLeader;
    private String trainerCurrentLocation;

    // 트레이너가 oceanCross 를 쓸 수 있는가?
    // TODO : 이 안에 IOceanCrossable 타입으로 판별될 수 있는 포켓몬이 있는지 검사
    List<Pokemon> capturedPokemonList = new ArrayList<Pokemon>();
    Map<String, Pokemon> capturedPokemonByName = new HashMap<>();
    Scanner inputReader = new Scanner(System.in);

    public Trainer(String trainerName, boolean isGymLeader, String trainerCurrentLocation
                   // Map<String, Pokemon> capturedPokemonByName
    ) {
        this.trainerName = trainerName;
        this.isGymLeader = false;
        this.trainerCurrentLocation = trainerCurrentLocation;
        // this.capturedPokemonList = capturedPokemonList;
        // this.capturedPokemonByName = capturedPokemonByName;
    }

    @Override
    public void hunt(Pokemon wildPokemon) {
        // 야생의 포켓몬을 만나서 싸우거나 잡거나
        System.out.println("1: 배틀 / 2: 캡쳐 / else: 패스");
        // TODO: 아무거나 입력했을 때 예외처리??
        int battleOrCapture = inputReader.nextInt();
        switch (battleOrCapture) {
            case 1:
                battle(wildPokemon);
                break;
            case 2:
                Pokemon capturedPokemon = capture(wildPokemon);
                if (capturedPokemon != null) {
                    capturedPokemonList.add(capturedPokemon);
                    capturedPokemonByName.put(
                            capturedPokemon.getPokemonName(), capturedPokemon);
                }
                break;
            default:
                System.out.println("패스합니다.");
                break;
        }
    }

    public void addPokemon(Pokemon pokemon) {
        capturedPokemonList.add(pokemon);
        capturedPokemonByName.put(pokemon.getPokemonName(), pokemon);
    }

    @Override
    public Pokemon capture(Pokemon wildPokemon) {
        int wildPokemonHP = wildPokemon.getHP();
        int captureChance; // 캡쳐 성공 확률

        if (wildPokemonHP > 80) {
            captureChance = (int) (Math.random() * 10); // 0~9% 확률
        } else if (wildPokemonHP > 50) {
            captureChance = (int) (Math.random() * 50); // 0~49% 확률
        } else if (wildPokemonHP > 20) {
            captureChance = (int) (Math.random() * 80); // 0~79% 확률
        } else if (wildPokemonHP > 0) {
            captureChance = (int) (Math.random() * 100); // 0~99% 확률
        } else {
            System.out.println("포켓몬이 도망갔습니다. 포획할 수 없습니다.");
            return null;
        }

        // 랜덤 값 생성하여 비교함 운빨요소
        int randomValue = (int) (Math.random() * 100);

        // 포획 성공 여부 판단
        if (randomValue < captureChance) {
            System.out.println("캡쳐 성공! " + wildPokemon.getPokemonName() + "을 잡았습니다.");
            return wildPokemon; // 성공 시 포켓몬 반환
        } else {
            System.out.println("캡쳐 실패! " + wildPokemon.getPokemonName() + "이 도망쳤습니다.");
            return null; // 실패 시 null 반환
        }
        // 확률적 포획 성공 (가중치를 적용)
        // TBD: 몬스터볼 소진 등
        // 100% 포획 몬스터볼
    }

    @Override
    public void battle(Pokemon wildPokemon) {
        // 포켓몬에 대한 게터 세터 호출
        // this.겟캡쳐드포켓몬리스트() 호출
        List<Pokemon> myLineUp = this.getCapturedPokemonList();

        // 라인업이 비어 있는 경우 -> 배틀 불가
        if (myLineUp.isEmpty()) {
            System.out.println("배틀할 수 있는 포켓몬이 없습니다. 배틀에 참여할 수 없습니다.");
            System.out.println("Lose");
            return;
        }

        // 배틀 시작!
        System.out.println("야생 포켓몬" + wildPokemon.getPokemonName() + "마주쳤다!");
        for (Pokemon pokemon : myLineUp) {
            while ((pokemon.getHP() != 0) && (wildPokemon.getHP() != 0)) {
                pokemon.attack(wildPokemon);
                if (wildPokemon.getHP() == 0) {
                    break; // 야생 포켓몬 쓰러지면 라인업 더 안 돌고 끝!
                }
                wildPokemon.attack(pokemon); // 서로 싸움
            }
        }
        // 결과 출력
        if (wildPokemon.getHP() == 0) {
            System.out.println("Win! 야생 포켓몬을 쓰러뜨렸습니다.");
            // TBD: 경험치, 유대감 상승 -> 진화 조건이 되기도!!
        } else {
            System.out.println("Lose! 모든 포켓몬이 쓰러졌습니다. 포켓몬 센터로 이동합니다...");
            goPokemonCenter(myLineUp);
        }
    }

    @Override
    public void battle(ITrainer enemyTrainer) {
        List<Pokemon> myLineUp = this.getCapturedPokemonList();
        List<Pokemon> enemyLineUp = enemyTrainer.getCapturedPokemonList();
        // 라인업이 비어 있는 경우 > 배틀 불가
        if (myLineUp.isEmpty()) {
            System.out.println("배틀할 수 있는 포켓몬이 없습니다. 배틀에 참여할 수 없습니다.");
            System.out.println("Lose");
            return;
        }
        // 배틀 시작!
        System.out.println("트레이너 " + enemyTrainer + "가 배틀을 신청합니다!");
        for (Pokemon myPokemon : myLineUp) {
            for (Pokemon enemyPokemon : enemyLineUp) {
                while (myPokemon.getHP() > 0 && enemyPokemon.getHP() > 0) {
                    myPokemon.attack(enemyPokemon); // 내 포켓몬의 공격
                    if (enemyPokemon.getHP() <= 0) {
                        System.out.println(enemyPokemon.getPokemonName() + "이 쓰러졌습니다.");
                        break; // 상대 포켓몬이 쓰러지면 다음 상대 포켓몬으로 이동
                    }
                    // 상대 포켓몬의 공격
                    enemyPokemon.attack(myPokemon);
                    if (myPokemon.getHP() <= 0) {
                        System.out.println(myPokemon.getPokemonName() + "이 쓰러졌습니다.");
                        break; // 내 포켓몬이 쓰러지면 다음 내 포켓몬으로 이동
                    }
                }

                // [질문] 상대 포켓몬이 쓰러져도 내 포켓몬은 남은 HP 그대로 배틀을 계속하려면 어떻게 하나요?
                // 상대 포켓몬이 쓰러져도 내 포켓몬은 그대로 유지
                if (enemyPokemon.getHP() <= 0) {
                    continue;// 현재 포켓몬 쓰러짐, 다음 포켓몬으로
                }
            }

            // 모든 내 포켓몬이 쓰러졌다면 배틀 종료
            if (myLineUp.stream().allMatch(pokemon -> pokemon.getHP() <= 0)) {
                System.out.println("모든 내 포켓몬이 쓰러졌습니다. 배틀 종료!");
                break;
            }
        }

        // 결과 출력
        boolean allEnemyPokemonDown = enemyLineUp.stream().allMatch(pokemon -> pokemon.getHP() <= 0);
        boolean allMyPokemonDown = myLineUp.stream().allMatch(pokemon -> pokemon.getHP() <= 0);

        if (allEnemyPokemonDown) {
            System.out.println("Win! 상대 트레이너의 모든 포켓몬을 쓰러뜨렸습니다.");
            // TBD: 경험치, 유대감 상승
        } else {
            System.out.println("Lose! 모든 포켓몬이 쓰러졌습니다. 포켓몬 센터로 이동합니다...");
            goPokemonCenter(myLineUp);
        }
    }

    @Override
    public Pokemon searchDex(String pokemonName) {
        return PokeDex.searchPokemon(pokemonName);
    }

    @Override
    public Map<String, Pokemon> searchDex(PokeDex.PokeCategory category) {
        return PokeDex.searchPokemon(category);
    }

    public void goPokemonCenter(List<Pokemon> PokemonList) {
        List<Pokemon> myLineUp = this.getCapturedPokemonList();
        for (Pokemon pokemon : myLineUp) {
            if (pokemon.getHP() != 100) {
                System.out.println(pokemon.getPokemonName() + "이 회복합니다...");
                pokemon.setHP(100);
            }
        }
        boolean allMyPokemonHeal = myLineUp.stream().allMatch(pokemon -> pokemon.getHP() <= 0);
        if (allMyPokemonHeal == true) {
            System.out.println("모든 포켓몬이 회복되었습니다!");
        }
    }
}
