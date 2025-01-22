package w3_11_pokemongame_gyudeok_0122;

import lombok.Getter;

import java.util.*;

@Getter
public class Trainer implements ITrainer {
    List<Pokemon> capturedPokemonList = new ArrayList<>();
    Map<String, Pokemon> capturedPokemonByName = new HashMap<>();
    Scanner inputReader = new Scanner(System.in);
    public String trainerName;
    public int trainerLevel;
    public int clearCity;

    public Trainer(String trainerName) {
        this.trainerName = trainerName;
    }

    public Pokemon randomPokemon() {  // 랜덤 조우
        int randomPokemonNum = (int) (Math.random() * (PokeDex.pokemonByAttribute.size()-1));
        // TODO : random 에서 1 나오면 out of bound
        PokeDex.PokeAttribute meetPokemon = PokeDex.pokemonByAttribute.get(randomPokemonNum);
        return new Pokemon(meetPokemon.getPokeName());
    }

    @Override
    public boolean hunt() {
        // 야생의 포켓몬을 만나서 싸우거나 잡거나
        System.out.print("\n야생의 포켓몬을 만났습니다! 무엇을 하시겠습니까?  | " +
                " 1 ) 포켓몬과 배틀하기  |" +
                " 2 ) 포켓몬을 잡기  |" +
                // TODO : 아래는 hunt 기능에서 벗어나므로 밖으로 분리
                " 3 ) 포켓몬 진화  |" +
                " 4 ) 메인메뉴로 돌아가기  : ");
        int battleOrCapture = inputReader.nextInt();
        Pokemon wildPokemon = randomPokemon();
        switch (battleOrCapture) {
            case 1:
                battle(wildPokemon);
                return true;
            case 2:
                Pokemon capturedPokemon = capture(wildPokemon);
                if (capturedPokemon != null) {
                    Scanner sc = new Scanner(System.in);
                    capturedPokemonList.add(capturedPokemon);
                    capturedPokemonByName.put(capturedPokemon.getPokemonName(), capturedPokemon);
//                    System.out.println("\""+wildPokemon.getPokemonName() +"\" 의 이름을 변경하시겠습니까? ( 네 / 아니오 )");
//                    String input = sc.nextLine();
//                    if (input.equalsIgnoreCase("네")) {
//                        System.out.print("변경하실 이름을 입력해 주세요 : ");
//                        wildPokemon.setCustomName(sc.next());
//                        System.out.println("=======================================================");
//                        System.out.println("  ======= \" " + capturedPokemon.getCustomName() + " \" 은(는) " + this.trainerName + " 의 동료가 되었다!! =======");
//                        System.out.println("=======================================================\n");
//                    }else {
//                        System.out.println("=======================================================");
//                        System.out.println("  ======= \" " + capturedPokemon.getPokemonName() + " \" 은(는) " + this.trainerName + " 의 동료가 되었다!! =======");
//                        System.out.println("=======================================================\n");
//                    }
                    System.out.println("=======================================================");
                    System.out.println("  ======= \" " + capturedPokemon.getPokemonName() + " \" 은(는) " + this.trainerName + " 의 동료가 되었다!! =======");
                    System.out.println("=======================================================\n");
                }
                return true;
            case 3:
                List<Pokemon> myLineUp = this.getCapturedPokemonList();
                for (Pokemon pokemon : myLineUp) {
                    if (pokemon.getPokemonLevel() == 10){
                        System.out.println("\""+pokemon.getPokemonName()+"\" 는 한계에 도전할 준비가 되었다고 합니다!");
                    }
                }
                System.out.print("진화시킬 포켓몬을 선택해 주세요 ! (이름으로 입력) : ");
                // TODO : 내 포켓몬에 접근

            default:
                System.out.println("메인메뉴로 돌아갑니다...\n");
                return false;
        }
    }

    @Override
    public Pokemon capture(Pokemon wildPokemon) {
        // 확률적 포획 성공 (가중치를 적용)
        // 몬스터볼 소진 등은 TBD
        System.out.println("=======================================================");
        System.out.println("  ======= !! 야생의 \" " + wildPokemon.getPokemonName() + " \" 을(를) 발견했다 !! =======");
        System.out.println("=======================================================\n");
        Pokemon.printPokemon(wildPokemon);
        System.out.println("            가랏!  몬스터볼 !!!\n");
        return wildPokemon; //  100% 포획
    }

    @Override
    public void battle(Pokemon wildPokemon) {
        // Pokemon 에 대한 getter(), setter() 호출
        // this.getCapturedPokemonList() 등 호출
        List<Pokemon> myLineUp = this.getCapturedPokemonList();
        for (Pokemon pokemon : myLineUp) {
            while (((pokemon.getPokemonHp() != 0) && (wildPokemon.getPokemonHp() != 0))) {
                System.out.print("[나] ");
                if (pokemon.getPokemonHp() > 0) pokemon.attack(wildPokemon);
                System.out.print("[상대] ");
                if (wildPokemon.getPokemonHp() > 0) wildPokemon.attack(pokemon);
                // TODO: 턴 진행에 대한 공통부분을 여기까지 뺄 수 있음
            }
        }
        // 결과 출력
        if (wildPokemon.getPokemonHp() == 0) {
            System.out.println("전투에서 '승리' 하였습니다 !!\n");
            for (Pokemon pokemon : myLineUp) {
                if(pokemon.getPokemonLevel() < 10) {
                    pokemon.setPokemonLevel(pokemon.getPokemonLevel() + 1); // 경험치는 10까지만 오름
                }
                System.out.println("[ " + pokemon.getPokemonName() + " ]  HP: " + pokemon.getPokemonHp() + " | Exp : " + pokemon.getPokemonLevel());
                if (pokemon.getPokemonLevel() == 10) {
                    System.out.println("\""+pokemon.getPokemonName()+"\" 는 한계에 도전할 준비가 되었다고 합니다!");
                }
            }
        } else {
            System.out.println("전투에서 '패배' 하였습니다...\n");
            for (Pokemon pokemon : myLineUp) {
                if(pokemon.getPokemonLevel()!=0){
                    pokemon.setPokemonLevel(pokemon.getPokemonLevel() - 1);  // 경험치는 0까지만 내려감
                }
                System.out.println("[ " + pokemon.getPokemonName() + " ]  HP: " + pokemon.getPokemonHp() + " | Exp : " + pokemon.getPokemonLevel());
            }
        }
    }

    @Override
    public void battle(ITrainer enemyTrainer) {
        //
    }

    @Override
    public PokeDex.PokeAttribute searchDex(String pokemonName) {
        return PokeDex.searchPokemon(pokemonName);
    }

    @Override
    public PokeDex.PokeAttribute searchDex(PokeDex.PokeCategory category) {
        return PokeDex.searchPokemon(category);
    }
}