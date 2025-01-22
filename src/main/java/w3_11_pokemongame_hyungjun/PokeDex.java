package w3_11_pokemongame_hyungjun;

import java.util.HashMap;
import java.util.Map;

public class PokeDex {
    // 데이터 타입 필드 추가
    static String pokemonName;
    static String pokemonDexNumber;
    static Map<String, Pokemon> pokemonByDexNum = new HashMap<>();
    static Map<String, Pokemon> pokemonByName = new HashMap<>();
    static Map<PokeCategory, Map<String, Pokemon>> pokemonByCategory = new HashMap<>();

    public static Pokemon searchPokemonByDexNum(String pokemonDexNumber) {
        return pokemonByDexNum.get(pokemonDexNumber);
    }

    // PokeCategory enum 선언
    public enum PokeCategory {
        WATER, FIRE, EARTH, SKY, LEGENDARY, MYSTIC, NORMAL, ELECTRIC
    }

    static {
        // 모든 PokeCategory 값을 키로 하여 내부 Map을 초기화
        for (PokeCategory category : PokeCategory.values()) {
            pokemonByCategory.put(category, new HashMap<>());
        }
        // 포켓몬 생성자에서 도감 번호와 포켓몬 이름을 저장하는 생성자 만들어야댐.
        // 아래에 더미데이터 생성
        pokemonByName.put("피카츄", new Pokemon("1", "피카츄", 10, 1, PokeCategory.ELECTRIC, 10));  // 맨 처음에 넣은 숫자는 도감 번호.(일껄)
    }
    public static void addPokemon(Pokemon pokemon) { // 포켓몬을 카테고리에 추가하는 메서드 (포켓몬 이름, 포켓몬 객체 추가)
        // pokemonByName에 추가
        pokemonByName.put(pokemon.getPokemonName(), pokemon);

        // pokemonByCategory에 추가
        PokeCategory category = pokemon.getCategory();
        pokemonByCategory.get(category).put(pokemon.getPokemonName(), pokemon);
    }

    public static Pokemon searchPokemon(String name) {
        // 서치 로직
        return pokemonByName.get(name);
    }

    public static Map<String, Pokemon> searchPokemon(PokeCategory category) {
        return pokemonByCategory.get(category);
    }
}