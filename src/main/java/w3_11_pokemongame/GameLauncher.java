package w3_11_pokemongame;

public class GameLauncher {
    public static void main(String[] args) {
        // 1. 야생 포켓몬 더미데이터 생성
        // 2. 트레이너 더미데이터 생성
        // 3. 포켓몬 사전 더미데이터 생성 (PokeDex 내부)

        Pokemon pokemon1 = new Pokemon();
        // 1) 리턴타입이 자식 타입인 EvolvedPokemon 인데 Pokemon 타입 변수에 할당
//        EvolvedPokemon evolvedPokemon1 = pokemon1.evolve();
//        pokemon1 = evolvedPokemon1;
        // 2) evolve() 리턴타입 자체를 다형성 타입으로 핸들링
        pokemon1 = pokemon1.evolve();
    }
}
