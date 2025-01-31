package w3_11_pokemongame_wildmental;

public class GameLauncher {
    public static void main(String[] args) {
        // 트레이드용 더미 데이터 생성
        Trainer trainer1 = new Trainer();  // 특수 이벤트 1번 포켓몬 보유
        Trainer trainer2 = new Trainer();  // 특수 이벤트 2번 포켓몬 보유
        // TODO 3. 트레이드 수행 및 특수한 이벤트 발생
        //   3-1. 트레이드 수행 (특수 이벤트 2가지 발생)
        trainer1.trade(trainer2);  // 트레이드 한방에 처리하자!
    }
}
