package w3_11_pokemongame_wildmental;

import java.util.HashMap;
import java.util.Map;

public class PokeDex {
    // 포켓몬 정보 관리할 데이터 타입 필드 추가
    static Map<String, Pokemon> pokemonByName = new HashMap<>();
    static Map<PokeCategory, Map<String, Pokemon>> pokemonByCategory = new HashMap<>();
    // 진화형 검색용 인덱스 Map
    static Map<String, String> evolveMap = new HashMap<>();
    static Map<String, MysticPokemon.IMysticActionable> mysticActionDex = new HashMap<>();

    static {
        // 달 포켓몬 & 진화형 더미데이터 생성
        // 모든 PokeCategory 값을 키로 하여 내부 Map 을 초기화
        Pokemon[] pokemons = {
            // 생성하고자 하는 포켓몬을 여기에 new 로 얼마든지 추가 가능
            new MysticPokemon("근육몬", 10, PokeDex.PokeCategory.MYSTIC),
            new MysticPokemon("킹스톤", 10, PokeDex.PokeCategory.MYSTIC),
        };

        for (PokeCategory category : PokeCategory.values()) {
            pokemonByCategory.put(category, new HashMap<>());  // 세부 카테고리에 대한 해시맵 초기화
        }

        for (Pokemon pokemon : pokemons) {
            // 위 생성 포켓몬을 적절한 사전 데이터 색인으로 할당
            pokemonByName.put(pokemon.getPokemonName(), pokemon);
            pokemonByCategory.get(pokemon.getPokeCategory()).put(pokemon.getPokemonName(), pokemon);
        }

        mysticActionDex.put(
            "근육몬",
            // IMysticActionable 의 인라인 구현체
            () -> {
                System.out.println("근육몬의 MysticAction 입니다!");
                return null;
            }
        );
        mysticActionDex.put(
            "킹스톤",
            // IMysticActionable 의 인라인 구현체
            () -> {
                System.out.println("킹스톤의 MysticAction 입니다!");
                return null;
            }
        );
    }

    public static EvolvedPokemon getEvolveForm(String currentForm) {
        String evolveTo = evolveMap.get(currentForm);
        return (EvolvedPokemon) pokemonByName.get(evolveTo);
    }

    public enum PokeCategory {
        WATER, FIRE, EARTH, SKY, LEGENDARY, MYSTIC, NORMAL, ELECTRIC
    }

    public static Pokemon searchPokemon(String name) {
        return pokemonByName.get(name);
    }
    public static Map<String, Pokemon> searchPokemon(PokeCategory category) {
        return pokemonByCategory.get(category);
    }
    // 아래 기능 필요 없음
//    public static Pokemon searchPokemon(PokeCategory category, String name) {
//        return searchPokemon(category).get(name);
//    };
}
