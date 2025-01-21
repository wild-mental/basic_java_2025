package w3_11_pokemongame_wildmental;

import lombok.Getter;

import java.util.*;

@Getter
public class Trainer implements ITrainer {
    List<Pokemon> capturedPokemonList = new ArrayList<>();
    Map<String, Pokemon> capturedPokemonByName = new HashMap<>();
    Scanner inputReader = new Scanner(System.in);

    @Override
    public void hunt(Pokemon wildPokemon) {
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
                Pokemon capturedPokemon = capture(wildPokemon);
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
    public Pokemon capture(Pokemon wildPokemon) {
        // 확률적 포획 성공 (가중치를 적용)
        // 몬스터볼 소진 등은 TBD
        return wildPokemon; //  100% 포획
    }

    @Override
    public void battle(Pokemon wildPokemon) {
        // Pokemon 에 대한 getter(), setter() 호출
        // this.getCapturedPokemonList() 등 호출
        List<Pokemon> myLineUp = this.getCapturedPokemonList();
        for (Pokemon pokemon: myLineUp) {
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

    public void crossOcean(String tgCity) {
        for (Pokemon pokemon: this.getCapturedPokemonList()) {
            if (pokemon instanceof IOceanCrossable) {
                ((IOceanCrossable) pokemon).crossOcean(tgCity);
            }
        }
    }
}