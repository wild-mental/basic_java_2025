package w3_11_1_pokemongame_ye_eun_0121;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameLauncher {
    static List<Pokemon> createTrainerPokemon1() {
        return Arrays.asList(new Pokemon[] {});
    }
    static List<Pokemon> createTrainerPokemon2() {
        return Arrays.asList(new Pokemon[] {});
    }

    static List<Pokemon> createWildPokemon1() {
        Pokemon pokemon1 = new Pokemon("파이리", "", 5, 100, PokeDex.PokeCategory.FIRE
            // , "화염방사"
        );
        Pokemon pokemon2 = new Pokemon("꼬렛", "", 8, 120, PokeDex.PokeCategory.WATER
            // , "물대포"
            );
        Pokemon pokemon3 = new Pokemon("이상해씨", "", 7, 110, PokeDex.PokeCategory.GRASS
            // , "덩굴채찍"
            );
        Pokemon pokemon4 = new FlyPokemon("구구", "", 12, 90, PokeDex.PokeCategory.SKY
            // "돌풍"
            );
        Pokemon pokemon5 = new Pokemon("잉어킹", "", 3, 50, PokeDex.PokeCategory.WATER
            // , "물결"
            );
        return new ArrayList<Pokemon>(Arrays.asList(pokemon1,pokemon2,pokemon3,pokemon4,pokemon5));
    }

    static List<Pokemon> createWildPokemon2() {
        Pokemon pokemon6 = LegendPokemon.createLegendPokemon("뮤츠", "", 50, 500, PokeDex.PokeCategory.LEGENDARY
            // "정신파"
        );
        Pokemon pokemon7 = new MysticPokemon("뮤", "", 40, 450, PokeDex.PokeCategory.MYSTIC
            // "사이킥"
        );
        Pokemon pokemon8 = new Pokemon("아르카이노", "", 70, 600, PokeDex.PokeCategory.SKY
            // , "얼음빔"
        );
        Pokemon pokemon9 = new SurfPokemon("갸라도스", "", 45, 400, PokeDex.PokeCategory.WATER
            // "하이드로펌프"
        );
        Pokemon pokemon10 = new Pokemon("용의존", "", 55, 550, PokeDex.PokeCategory.SKY
            // , "드래곤메테오"
        );
        return Arrays.asList(pokemon6,pokemon7,pokemon8,pokemon9,pokemon10);
    }

    // [질문] wildPokemon 이랑 Pokomon의 구분이 어떻게 되는지 모르겠어요.(customName이 없는 포켓몬??) wildPokemon 클래스를 또 만들어야 되나요?

    static List<Trainer> createTrainer() {
        List<Pokemon> trainer1Pokemons = createTrainerPokemon1();
        List<Pokemon> trainer2Pokemons = createTrainerPokemon2();
        Trainer trainer1 = new Trainer("석예은", true, "구리");
        for (Pokemon pokemon : trainer1Pokemons) {
            trainer1.addPokemon(pokemon);
        }
        Trainer trainer2 = new Trainer("민동휘", false, "용산");
        for (Pokemon pokemon : trainer2Pokemons) {
            trainer2.addPokemon(pokemon);
        }
        return new ArrayList<Trainer>(Arrays.asList(trainer1,trainer2));
    }
    // [질문] Map은 어떻게 넣나요? ByName Map은 왜 필요한가요??

    // 1. 야생 포켓몬 더미데이터 생성
    // 2. 트레이너 더미데이터 생성
    // 3. 포켓몬사전 더미데이터 생성 -> 포켓 덱스 내부!

    // Pokemon pokemon1 = new Pokemon();
    // 1) 리턴 타입이 자식 타입인 이볼브드 포켓몬인데 포켓몬 타입 변수에 할당 가능
    // EvolvedPokemon evolvedPokemon1 = pokemon1.evolve();
    // pokemon1 = evolvedPokemon1;

    // 2) 이볼브() 리턴 타입 자체를 다형성 타입으로 핸들링
    // pokemon1 = pokemon1.evolve();

    public static ArrayList<Trainer> main(String[] args) {
        return null;
    }
}
