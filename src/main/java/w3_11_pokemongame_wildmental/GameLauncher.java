package w3_11_pokemongame_wildmental;

public class GameLauncher {
    public static void main(String[] args) {
        PokeTown initTown = new PokeTown(
            "태초마을", "모험이 시작되는 마을입니다!", true,
            (trainer) -> {
                // 태초마을에서 일어나는 특별한 이벤트 정의 가능
                System.out.println("[미구현] 처음 게임을 시작하는 트레이너의 경우에만 포켓몬 선택을 수행합니다.");
            }
        );
        PokeTown moonHill = new PokeTown(
            "달맞이동산", "달 포켓몬들의 성지입니다!", false,
            // 람다식으로 함수형 인터페이스에 인라인 로직 할당 (객체 생성 시 매번 변경 가능)
            (trainer) -> {
                for (Pokemon pokemon : trainer.getCapturedPokemonList()) {
                    if (pokemon.getPokeCategory() == PokeDex.PokeCategory.MOON) {
                        System.out.println("달맞이 동산의 영향으로 " + pokemon.getPokemonName() + " 이 진화합니다!");
                        pokemon.evolve();  // TODO : 진화 상세로직 구현 필요
                    }
                }
            }
        );
        PokeTown bossTown = new PokeTown(
            "암흑마을", "최종 보스와 결투하는 마을입니다!", true,
            (trainer) -> {
                // 암흑마을에서 일어나는 특별한 이벤트 정의 가능
                System.out.println("[미구현] 최종 보스 결투 조건을 갖춘 트레이너의 경우 즉시 보스와 전투합니다.");
            }
        );
        Trainer trainer1 = new Trainer("플레이어", null);
        Trainer trainer2 = new Trainer("라이벌플레이어", null);
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
//        System.out.println(trainer1);
//        System.out.println(trainer2);

        // TODO 2. 대륙 간 이동 방식으로 달맞이 동산 진입 후 동작 수행
        //   2-1. 달맞이 동산 대륙 이동 및 특수 동작 수행
        trainer1.townMove(moonHill);
        trainer2.townMove(moonHill);
        //   2-2. 태초마을 이동 및 특수 동작 수행
//        trainer1.townMove(initTown);
//        trainer1.townMove(bossTown);
//        trainer1.townMove(bossTown);

        // TODO 3. 트레이드 수행 및 특수한 이벤트 발생
        //   3-1. 트레이드 수행 (특수 이벤트 1 발생)
        //   3-2. 트레이드 수행 (특수 이벤트 2 발생)

        // TODO 4. 전설의 포켓몬 구현 및 확인
        //   4-1. 전설의 포켓몬 Unique 처리 및 Singleton 확인
    }
}
