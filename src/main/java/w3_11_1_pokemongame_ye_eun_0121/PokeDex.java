package w3_11_1_pokemongame_ye_eun_0121;

import java.util.*;

public class PokeDex {
    // 데이터 타입 추가
    static Map<String, Pokemon> pokemonByName;
    static Map<PokeCategory, Map<String, Pokemon>> pokemonByCategory;
    static String pokemonName;
    static PokeCategory pokeCategory;
    static Map<String, Map<String, PokeSkill>> pokeSkills;


    static {
        // 3. 포켓몬사전 더미데이터 생성
        for (PokeCategory Category : PokeCategory.values()) {
            pokemonByCategory.put(Category, new HashMap<>());
        }

        List<Pokemon> pokemonList = new ArrayList<Pokemon>();
        // 아래에 더미 데이터 생성 (매 객체 생성 시 해당 객체의 바이 네임과 바이 카테고리가 둘다 업데이트 해야 함)
//        Pokemon p1 = new Pokemon();
//        Pokemon p2 = new Pokemon();
//        Pokemon p3 = new Pokemon();
        // 위 변수들은 리스트로 변경,

    }
    public static void addPokemon(Pokemon pokemon) {
        pokemonByName.put(pokemon.getPokemonName(), pokemon);
        pokemonByCategory.get(pokemon.getPokeCategory()).put(pokemon.getPokemonName(), pokemon);

        // 아래 구문들은 반복문으로 변경
//        pokemonByName.put("p1", p1);
//        pokemonByCategory.get(PokeCategory.WATER).put(p1.getPokemonName(), p1);
//        pokemonByName.put("p2", p2);
//        pokemonByCategory.get(PokeCategory.WATER).put(p2.getPokemonName(), p2);
//        pokemonByName.put("p3", p3);
//        pokemonByCategory.get(PokeCategory.WATER).put(p3.getPokemonName(), p3);

    }

    // 포켓몬 카테고리
    public enum PokeCategory {
        FIRE, WATER, EARTH, SKY, MYSTIC, LEGENDARY, NORMAL, ELECTRIC, GRASS
    }

    // 포켓몬 이름으로 검색하기
    public static Pokemon searchPokemon(String name) {
        return pokemonByName.get(name);
    }

    // 포켓몬 카테고리로 검색하기
    public static Map<String, Pokemon> searchPokemon(PokeCategory category) {
        return pokemonByCategory.get(category);
    }
}

// 아래 기능 필요 없음
//    public static Pokemon searchPokemon (PokeCategory category, String name){
//        searchPokemon(category).get(name);
//        return null;
//    }

