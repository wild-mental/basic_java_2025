package w3_11_pokemongame_wildmental;

public class GameLauncher {
    public static void main(String[] args) {
        // 트레이드용 더미 데이터 생성
        Trainer trainer1 = new Trainer();  // 특수 이벤트 1번 포켓몬 보유
        Trainer trainer2 = new Trainer();  // 특수 이벤트 2번 포켓몬 보유
        //   1-2. 트레이너의 보유 포켓몬
        Pokemon[] trainer1Pokemon = {
            new MysticPokemon("근육몬", "내근육몬0", 10, PokeDex.PokeCategory.MYSTIC),
            new MysticPokemon("근육몬", "내근육몬1", 10, PokeDex.PokeCategory.MYSTIC),
            new MysticPokemon("근육몬", "내근육몬2", 10, PokeDex.PokeCategory.MYSTIC),
        };
        trainer1.getPokemon(trainer1Pokemon);
        Pokemon[] trainer2Pokemon = {
            new MysticPokemon("킹스톤", "니킹스톤0", 10, PokeDex.PokeCategory.MYSTIC),
            new MysticPokemon("킹스톤", "니킹스톤1", 10, PokeDex.PokeCategory.MYSTIC),
            new MysticPokemon("킹스톤", "니킹스톤2", 10, PokeDex.PokeCategory.MYSTIC),
        };
        trainer2.getPokemon(trainer2Pokemon);
        // TODO 3. 트레이드 수행 및 특수한 이벤트 발생
        //   3-1. 트레이드 수행 (특수 이벤트 2가지 발생)
        trainer1.trade(trainer2);  // 트레이드 한방에 처리하자!
    }
}
