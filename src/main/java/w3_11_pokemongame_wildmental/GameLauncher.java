package w3_11_pokemongame_wildmental;

public class GameLauncher {
    public static void main(String[] args) {
        PokeTown initTown = new PokeTown(
            "태초마을", "모험이 시작되는 마을입니다!", true
        );
        PokeTown moonHill = new PokeTown(
            "달맞이동산", "달 포켓몬들의 성지입니다!", false
        );
        Trainer trainer1 = new Trainer("플레이어", initTown);
        Trainer trainer2 = new Trainer("라이벌플레이어", initTown);
        //   1-2. 트레이너의 보유 포켓몬
        Pokemon[] trainer1Pokemon = {
            new Pokemon("삐삐", "내 삐삐", 10, PokeDex.PokeCategory.MOON),
            new Pokemon("푸린", "내 푸린", 10, PokeDex.PokeCategory.MOON),
            new FlyPokemon("피죤", "내 피죤", 10, PokeDex.PokeCategory.SKY),
        };
        trainer1.getPokemon(trainer1Pokemon);
        Pokemon[] trainer2Pokemon = {
            new Pokemon("삐삐", "니 삐삐", 10, PokeDex.PokeCategory.MOON),
            new Pokemon("푸린", "니 푸린", 10, PokeDex.PokeCategory.MOON),
            new SurfPokemon("거북왕", "니 거북왕", 10, PokeDex.PokeCategory.WATER),
        };
        trainer2.getPokemon(trainer2Pokemon);

        // 더미데이터 생성 완료 확인!
        System.out.println(trainer1);
        System.out.println(trainer2);

        // TODO 2. 대륙 간 이동 방식으로 달맞이 동산 진입 후 동작 수행
        //   대륙 이동 가능한 포켓몬 필요 -> 1-1 에서 생성
        //   2-1. 달맞이 동산 대륙 이동 및 특수 동작 수행
        //   2-2. 태초마을 이동 및 특수 동작 수행

        // TODO 3. 트레이드 수행 및 특수한 이벤트 발생
        //   3-1. 트레이드 수행 (특수 이벤트 1 발생)
        //   3-2. 트레이드 수행 (특수 이벤트 2 발생)

        // TODO 4. 전설의 포켓몬 구현 및 확인
        //   4-1. 전설의 포켓몬 Unique 처리 및 Singleton 확인
    }
}
