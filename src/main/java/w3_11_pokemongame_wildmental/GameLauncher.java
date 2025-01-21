package w3_11_pokemongame_wildmental;

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

        // Scenario 1
        // 트레이너 VS 야생포켓몬 전투
        Trainer trainer1 = new Trainer();
        Trainer trainer2 = new Trainer();
        Pokemon pokemon2 = new Pokemon();
        trainer1.hunt(pokemon1);
        trainer2.hunt(pokemon2);

        // Scenario 2
        // 대륙 간 횡단
        trainer1.crossOcean("태초마을");
        trainer2.crossOcean("어둠시티");
    }
}
