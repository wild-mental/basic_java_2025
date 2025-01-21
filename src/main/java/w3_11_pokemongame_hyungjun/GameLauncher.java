package w3_11_pokemongame_hyungjun;

import static w3_11_pokemongame.PokeDex.addPokemon;

public class GameLauncher {
    public static void main(String[] args) {
        // 1. 야생 포켓몬 더미데이터 생성
        addPokemon(new Pokemon("009", "거북왕", 95, 45, PokeDex.PokeCategory.WATER, 85)),
        addPokemon(new Pokemon("130", "갸라도스", 90, 50, PokeDex.PokeCategory.WATER, 92)),
        addPokemon(new Pokemon("134", "샤미드", 85, 42, PokeDex.PokeCategory.WATER, 78)),
        addPokemon(new Pokemon("245", "스이쿤", 100, 50, PokeDex.PokeCategory.WATER, 90)),
        addPokemon(new Pokemon("260", "대짱이", 88, 44, PokeDex.PokeCategory.WATER, 80)),
        addPokemon(new Pokemon("006", "리자몽", 92, 50, PokeDex.PokeCategory.FIRE, 95)),
        addPokemon(new Pokemon("059", "윈디", 90, 48, PokeDex.PokeCategory.FIRE, 89)),
        addPokemon(new Pokemon("157", "블레이범", 85, 45, PokeDex.PokeCategory.FIRE, 84)),
        addPokemon(new Pokemon("485", "히드런", 98, 50, PokeDex.PokeCategory.FIRE, 94)),
        addPokemon(new Pokemon("636", "활화르바", 80, 40, PokeDex.PokeCategory.FIRE, 75)),
        addPokemon(new Pokemon("112", "코뿌리", 95, 45, PokeDex.PokeCategory.EARTH, 87)),
        addPokemon(new Pokemon("450", "맘모꾸리", 92, 47, PokeDex.PokeCategory.EARTH, 85)),
        addPokemon(new Pokemon("383", "그란돈", 100, 50, PokeDex.PokeCategory.EARTH, 98)),
        addPokemon(new Pokemon("248", "마기라스", 97, 50, PokeDex.PokeCategory.EARTH, 95)),
        addPokemon(new Pokemon("340", "메깅", 88, 42, PokeDex.PokeCategory.EARTH, 80)),
        addPokemon(new Pokemon("142", "프테라", 90, 46, PokeDex.PokeCategory.SKY, 88)),
        addPokemon(new Pokemon("277", "스왈로", 80, 40, PokeDex.PokeCategory.SKY, 75)),
        addPokemon(new Pokemon("373", "보만다", 95, 50, PokeDex.PokeCategory.SKY, 94)),
        addPokemon(new Pokemon("398", "찌르호크", 85, 44, PokeDex.PokeCategory.SKY, 83)),
        addPokemon(new Pokemon("468", "토게키스", 88, 42, PokeDex.PokeCategory.SKY, 80)),
        addPokemon(new Pokemon("144", "프리져", 97, 50, PokeDex.PokeCategory.LEGENDARY, 92)),
        addPokemon(new Pokemon("145", "썬더", 98, 50, PokeDex.PokeCategory.LEGENDARY, 93)),
        addPokemon(new Pokemon("146", "파이어", 97, 50, PokeDex.PokeCategory.LEGENDARY, 94)),
        addPokemon(new Pokemon("249", "루기아", 100, 50, PokeDex.PokeCategory.LEGENDARY, 96)),
        addPokemon(new Pokemon("250", "칠색조", 100, 50, PokeDex.PokeCategory.LEGENDARY, 97)),
        addPokemon(new Pokemon("151", "뮤", 95, 50, PokeDex.PokeCategory.MYSTIC, 90)),
        addPokemon(new Pokemon("251", "세레비", 95, 50, PokeDex.PokeCategory.MYSTIC, 91)),
        addPokemon(new Pokemon("385", "지라치", 96, 50, PokeDex.PokeCategory.MYSTIC, 92)),
        addPokemon(new Pokemon("489", "마나피", 92, 50, PokeDex.PokeCategory.MYSTIC, 88)),
        addPokemon(new Pokemon("488", "크레세리아", 98, 50, PokeDex.PokeCategory.MYSTIC, 95)),
        addPokemon(new Pokemon("143", "잠만보", 100, 50, PokeDex.PokeCategory.NORMAL, 85)),
        addPokemon(new Pokemon("242", "해피너스", 105, 50, PokeDex.PokeCategory.NORMAL, 75)),
        addPokemon(new Pokemon("463", "케오퍼스", 85, 44, PokeDex.PokeCategory.NORMAL, 83)),
        addPokemon(new Pokemon("335", "잔비얀", 87, 45, PokeDex.PokeCategory.NORMAL, 82)),
        addPokemon(new Pokemon("506", "요테리", 80, 40, PokeDex.PokeCategory.NORMAL, 75)),
        addPokemon(new Pokemon("025", "피카츄", 80, 42, PokeDex.PokeCategory.ELECTRIC, 78)),
        addPokemon(new Pokemon("135", "쥬피썬더", 85, 45, PokeDex.PokeCategory.ELECTRIC, 84)),
        addPokemon(new Pokemon("243", "라이코", 98, 50, PokeDex.PokeCategory.ELECTRIC, 94)),
        addPokemon(new Pokemon("466", "에레키블", 90, 48, PokeDex.PokeCategory.ELECTRIC, 88)),
        addPokemon(new Pokemon("522", "줄뮤마", 82, 40, PokeDex.PokeCategory.ELECTRIC, 80))


        // 2. 트레이너 더미데이터 생성

        Pokemon pokemon1 = new Pokemon();
        // 리턴타입이 자식 타입인 EvolvedPokemon 인데 Pokemon 타입 변수에 할당
        pokemon1.evolve();
    }
}
