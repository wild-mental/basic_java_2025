package w3_9_pokemon_taeri_0120;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Battle {  // 인터페이스 구현체가 되어야 함
    // DONE : 필드 의존성이 아니라 파라미터 의존성으로 변경

    public static void start(Trainer trainer1, Trainer trainer2) {

        System.out.println(trainer1.getName() + "이(가) " + trainer2.getName() + "에게 전투를 신청했습니다!");
        System.out.println("전투 시작!");

        Scanner scanner = new Scanner(System.in);
        int myIndex = 0; // 현재 사용 중인 포켓몬의 인덱스
        int oppIndex = 0; // 상대방의 현재 포켓몬 인덱스

        // TODO: 향상된 포문 중첩으로 해결하면 좋음
        while (myIndex < trainer1.getMyPokemon().size() && oppIndex < trainer2.getMyPokemon().size()) {
            // 1. 등장 출력
            List<Pokemon> pokemons = printPokemonAppear(trainer1, myIndex, trainer2, oppIndex);
            Pokemon myPokemon = pokemons.get(0);
            Pokemon oppPokemon = pokemons.get(1);

            // 2. 내 턴 호출
            System.out.println("\n" + trainer1.getName() + "의 차례!");
            System.out.println(myPokemon.name + "의 스킬: " + myPokemon.getSkillNames());
            System.out.print("사용할 스킬을 선택하세요: ");
            String mySkill = scanner.nextLine(); // 사용자 입력 대기
            myPokemon.useSkill(mySkill, "battle");  // 사용할 대상이 지정되어야 함
            // TODO: 아래 내용은 스킬 사용 시 포함되어야 함
            // 상대 포켓몬의 HP 감소
            for (Skill skill : myPokemon.Pskill) {
                if (skill.getName().equals(mySkill)) {
                    if (skill instanceof BattleSkill) {
                        oppPokemon.hp -= ((BattleSkill) skill).getDamage();
                    } else if (skill instanceof VisionSkill) {
                        oppPokemon.hp -= ((VisionSkill) skill).getDamage();
                    }
                    break;
                }
            }
            System.out.println(oppPokemon.name + "의 남은 HP: " + oppPokemon.hp);

            // 3. 턴 종료 평가
            // TODO : 턴 호출이 내턴과 상대 턴 코드 메서드 분리를 통해서 일원화 되면
            //        종료 평가도 해당 메서드에 포함되어야 함
            if (oppPokemon.hp <= 0) {
                oppIndex++;
                System.out.println(oppPokemon.name + "이(가) 쓰러졌습니다!");
                oppPokemon = trainer2.getMyPokemon().get(oppIndex);
                if (oppIndex >= trainer2.getMyPokemon().size()) {
                    System.out.println(trainer2.getName() + "의 모든 포켓몬이 쓰러졌습니다!");
                    System.out.println(trainer1.getName() + "의 승리!");
                    trainer1.winBattle(); // 승리한 트레이너의 포켓몬 레벨 업
                    return;
                }
                System.out.println(trainer2.getName() + "은(는) 다음 포켓몬으로 " + oppPokemon.name + "을(를) 꺼냈습니다!");
            }

            // 4. 상대 턴 호출
            System.out.println("\n" + trainer2.getName() + "의 차례!");
            System.out.println(oppPokemon.name + "의 스킬: " + oppPokemon.getSkillNames());
            System.out.print("사용할 스킬을 선택하세요: ");
            String oppSkill = scanner.nextLine(); // 사용자 입력 대기
            oppPokemon.useSkill(oppSkill, "battle");
            // 내 포켓몬의 HP 감소
            for (Skill skill : oppPokemon.Pskill) {
                if (skill.getName().equals(oppSkill)) {
                    if (skill instanceof BattleSkill) {
                        myPokemon.hp -= ((BattleSkill) skill).getDamage();
                    } else if (skill instanceof VisionSkill) {
                        myPokemon.hp -= ((VisionSkill) skill).getDamage();
                    }
                    break;
                }
            }

            System.out.println(myPokemon.name + "의 남은 HP: " + myPokemon.hp);

            // 내 포켓몬이 쓰러졌는지 확인
            // TODO : 위 턴 종료 평가와 동일
            if (myPokemon.hp <= 0) {
                System.out.println(myPokemon.name + "이(가) 쓰러졌습니다!");
                myIndex++;
                if (myIndex >= trainer1.getMyPokemon().size()) {
                    System.out.println(trainer1.toString());
                    System.out.println(trainer1.getName() + "의 모든 포켓몬이 쓰러졌습니다!");
                    System.out.println(trainer2.getName() + "의 승리!");
                    trainer2.winBattle(); // 승리한 트레이너의 포켓몬 레벨 업
                    return;
                }
                myPokemon = trainer1.getMyPokemon().get(myIndex);
                System.out.println(trainer1.getName() + "은(는) 다음 포켓몬으로 " + myPokemon.name + "을(를) 꺼냈습니다!");
            }
        }
    }

    private static List<Pokemon> printPokemonAppear(Trainer trainer1, int myIndex, Trainer trainer2, int oppIndex) {
        Pokemon myPokemon = trainer1.getMyPokemon().get(myIndex);
        Pokemon oppPokemon = trainer2.getMyPokemon().get(oppIndex);
        System.out.println("\n" + trainer1.getName() + "의 " + myPokemon.name + " vs " + trainer2.getName() + "의 " + oppPokemon.name);
        return Arrays.asList(myPokemon, oppPokemon);
    }
}