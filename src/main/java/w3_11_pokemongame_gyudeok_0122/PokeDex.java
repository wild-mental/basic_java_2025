package w3_11_pokemongame_gyudeok_0122;

import lombok.Getter;

import java.util.*;

public class PokeDex {

    // TODO: 검색에 사용하기 위해서는 Map 자료형을 써야 함
    static List<PokeAttribute> pokemonByAttribute = new ArrayList<>(Arrays.asList(PokeAttribute.values()));
    static List<PokeCategory> pokemonByCategory = new ArrayList<>();

    static {
        pokemonByCategory.addAll(Arrays.asList(PokeCategory.values()));
    }

    @Getter
    public enum PokeAttribute {
        BULBASAUR(1, "이상해씨", PokeCategory.풀, 45, 49),
        IVYSAUR(2, "이상해풀", PokeCategory.풀, 60, 62),
        VENUSAUR(3, "이상해꽃", PokeCategory.풀, 80, 82),
        CHARMANDER(4, "파이리", PokeCategory.불, 39, 52),
        CHARMELEON(5, "리자드", PokeCategory.불, 58, 64),
        CHARIZARD(6, "리자몽", PokeCategory.불, 78, 84),
        SQUIRTLE(7, "꼬부기", PokeCategory.물, 44, 48),
        WARTORTLE(8, "어니부기", PokeCategory.물, 59, 63),
        BLASTOISE(9, "거북왕", PokeCategory.물, 79, 83),
        CATERPIE(10, "캐터피", PokeCategory.벌레, 45, 30),
        METAPOD(11, "단데기", PokeCategory.벌레, 50, 20),
        BUTTERFREE(12, "버터플", PokeCategory.벌레, 60, 45),
        WEEDLE(13, "뿔충이", PokeCategory.벌레, 40, 35),
        KAKUNA(14, "딱충이", PokeCategory.벌레, 45, 25),
        BEEDRILL(15, "독침붕", PokeCategory.벌레, 65, 90),
        PIDGEY(16, "구구", PokeCategory.노말, 40, 45),
        PIDGEOTTO(17, "피죤", PokeCategory.노말, 63, 60),
        PIDGEOT(18, "피죤투", PokeCategory.노말, 83, 80),
        RATTATA(19, "꼬렛", PokeCategory.노말, 30, 56),
        RATICATE(20, "레트라", PokeCategory.노말, 55, 81),
        PIKACHU(21, "피카츄", PokeCategory.전기, 35, 55),
        RAICHU(22, "라이츄", PokeCategory.전기, 60, 90),
        SANDSHREW(23, "모래두지", PokeCategory.땅, 50, 75),
        SANDSLASH(24, "고지", PokeCategory.땅, 75, 100),
        NIDORAN_F(25, "니드런♀", PokeCategory.독, 55, 47),
        NIDORINA(26, "니드리나", PokeCategory.독, 70, 62),
        NIDOQUEEN(27, "니드퀸", PokeCategory.독, 90, 92),
        NIDORAN_M(28, "니드런♂", PokeCategory.독, 46, 57),
        NIDORINO(29, "니드리노", PokeCategory.독, 61, 72),
        NIDOKING(30, "니드킹", PokeCategory.독, 81, 102),
        VULPIX(31, "식스테일", PokeCategory.불, 38, 41),
        NINETALES(32, "나인테일", PokeCategory.불, 73, 76),
        JIGGLYPUFF(33, "푸린", PokeCategory.노말, 115, 45),
        WIGGLYTUFF(34, "푸크린", PokeCategory.노말, 140, 70),
        ZUBAT(35, "주뱃", PokeCategory.독, 40, 45),
        GOLBAT(36, "골뱃", PokeCategory.독, 75, 80),
        ODDISH(37, "뚜벅쵸", PokeCategory.풀, 45, 50),
        GLOOM(38, "냄새꼬", PokeCategory.풀, 60, 65),
        MACHOP(39, "알통몬", PokeCategory.격투, 70, 80),
        MACHOKE(40, "근육몬", PokeCategory.격투, 80, 100),
        MACHAMP(41, "괴력몬", PokeCategory.격투, 90, 130),
        GEODUDE(42, "꼬마돌", PokeCategory.바위, 40, 80),
        GRAVELER(43, "데구리", PokeCategory.바위, 55, 95),
        GOLEM(44, "딱구리", PokeCategory.바위, 80, 120),
        PONYTA(45, "포니타", PokeCategory.불, 50, 85),
        RAPIDASH(46, "날쌩마", PokeCategory.불, 65, 100),
        SLOWPOKE(47, "야돈", PokeCategory.물, 90, 65),
        SLOWBRO(48, "야도란", PokeCategory.물, 95, 75),
        MAGNEMITE(49, "코일", PokeCategory.전기, 25, 35),
        MAGNETON(50, "레어코일", PokeCategory.전기, 50, 60),
        FARFETCHD(51, "파오리", PokeCategory.노말, 52, 90),
        DODUO(52, "두두", PokeCategory.노말, 35, 85),
        DODRIO(53, "두트리오", PokeCategory.노말, 60, 110),
        SEEL(54, "쥬쥬", PokeCategory.물, 65, 45),
        DEWGONG(55, "쥬레곤", PokeCategory.물, 90, 70),
        GRIMER(56, "질퍽이", PokeCategory.독, 80, 80),
        MUK(57, "질뻐기", PokeCategory.독, 105, 105),
        SHELLDER(58, "셀러", PokeCategory.물, 30, 65),
        CLOYSTER(59, "파르셀", PokeCategory.물, 50, 95),
        GASTLY(60, "고오스", PokeCategory.고스트, 30, 35),
        HAUNTER(61, "고우스트", PokeCategory.고스트, 45, 50),
        GENGAR(62, "팬텀", PokeCategory.고스트, 60, 65);

        private int pokeDexNumber;
        private String pokeName;
        private PokeCategory pokeCategory;
        private int pokeHp;
        private int pokeDmg;

        PokeAttribute(int pokeDexNumber, String pokeName, PokeCategory pokeCategory, int pokeHp, int pokeDmg) {
            this.pokeDexNumber = pokeDexNumber;
            this.pokeName = pokeName;
            this.pokeCategory = pokeCategory;
            this.pokeHp = pokeHp;
            this.pokeDmg = pokeDmg;
        }

    }

    public enum PokeCategory {
        물, 불, 노말, 전기, 풀, 벌레, 독, 바위, 땅, 얼음, 격투, 에스퍼,
        고스트, 드래곤, 악, 강철, 페어리, 비행, 전설, 신비, 환상
    }

    public static PokeAttribute searchPokemon(String searchString) {  // 이름검색 또는 카테고리 검색을 번호로 받음
        for (PokeAttribute tgPokemon : pokemonByAttribute) {
            if (tgPokemon.pokeName.equals(searchString)) {
                return tgPokemon;  // 1 개만 반환함
            }
        }
        System.out.println("검색된 결과가 없음");
        return null;
    }

    public static PokeAttribute searchPokemon(PokeCategory searchString) {  // 이름검색 또는 카테고리 검색을 번호로 받음
        for (PokeAttribute tgPokemon : pokemonByAttribute) {
            if (tgPokemon.pokeCategory.equals(searchString)) {
                return tgPokemon;    // 속성에 해당하는 포켓본 전부 전달
            }
        }
        System.out.println("검색된 결과가 없음");
        return null;
    }

}