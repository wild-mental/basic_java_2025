package w3_11_pokemongame_hyungjun;

import lombok.Getter;

import java.util.*;

@Getter
public class Trainer implements ITrainer {
    List<Pokemon> capturedPokemonList = new ArrayList<>();
    Map<String, Pokemon> capturedPokemonByName = new HashMap<>();
    Scanner inputReader = new Scanner(System.in);

    @Override
    public void hunt(Pokemon wildPokemon) {
        // 야생의 포켓몬을 만나서 싸우거나(죽이거나) 잡거나
        System.out.println("1: battle / 2: capture / else : pass" );
        int battleOrCapture = inputReader.nextInt();
        switch (battleOrCapture) {
            case 1:
                battle(wildPokemon);
                break;
            case 2:
                capture(wildPokemon);
                break;
            default:
                break;
        }

        battle(wildPokemon);
        Pokemon capturedPokemon = capture(wildPokemon);
        if(capturedPokemon != null) {
            capturedPokemonList.add(capturedPokemon);
            capturedPokemonByName.put(
                    capturedPokemon.getPokemonName(), capturedPokemon
            );
        }
    }


    @Override
    public Pokemon capture(Pokemon wildPokemon) {
        return wildPokemon;
    }

    @Override
    public void battle(Pokemon wildPokemon) {
        // Pokemon 에 대한 getter(), setter() 호출
        // this.getCaturedPokemonList() 등 호출
        List<Pokemon> myLineUp = this.getCapturedPokemonList();
        for(Pokemon pokemon: myLineUp){
            while(((pokemon.getHP() !=0) && (wildPokemon.getHP()!=0))) {
                pokemon.attack(wildPokemon);
                wildPokemon.attack(pokemon);
            }
        }
        if(wildPokemon.getHP()==0) {
            System.out.println("Win!");
        }else {
            System.out.println("Lost!");
        }
        // 결과 출력
    }
    @Override
    public void battle(ITrainer enemyTrainer) {

    }

    @Override
    public Pokemon searchDex(String pokemonName) {
    return PokeDex.searchPokemon(pokemonName);
    }

    @Override
    public Map<String, Pokemon> searchDex() {
        return Map.of();
    }
}