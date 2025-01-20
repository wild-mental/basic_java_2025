package w3_9_pokemon_taeri_0120;

import java.util.ArrayList;

public class Pokemon {
    String name;
    ArrayList<String> Ptype;  // TODO: pType
    String category;
    ArrayList<Skill> Pskill;  // TODO: pSkill
    int level;
    int hp;
    // 필드 의존성으로 처리하면 오히려 좋음
    // null 또는 다음 포켓몬 상태가 도감 데이터로 참조
    // Pokemon nextEvolve = Pokedex.PokedexData.getNextPokemon(this.name);

    public Pokemon(String name, ArrayList<String> Ptype, String category, ArrayList<Skill> Pskill, int level, int hp) {
        this.name = name;
        this.Ptype = Ptype;
        this.category = category;
        this.Pskill = Pskill;
        this.level = level;
        this.hp = hp;
    }

    // 스킬 사용 메서드
    public void useSkill(String skillName, String context) {
        // TODO : 이름을 알면 전체순회를 절대 해선 안됨
        //        Map 자료형으로 바꿔서 한번에 조회
        for (Skill skill : Pskill) {
            if (skill.getName().equals(skillName)) {
                if (context.equals("outside") && !skill.canUseSkillOutside()) {
                    System.out.println(skillName + " 스킬은 전투 외에서는 사용할 수 없습니다.");
                } else {
                    skill.use(context);
                }
                return;
            }
        }
        System.out.println(this.name + "은(는) 스킬 " + skillName + "을(를) 배우지 않았습니다.");
    }

    // 스킬 이름을 반환하는 메서드
    // TODO : Map 자료형의 keySet() 적용
    public ArrayList<String> getSkillNames() {
        ArrayList<String> skillNames = new ArrayList<>();
        for (Skill skill : Pskill) {
            skillNames.add(skill.getName());
        }
        return skillNames;
    }

    // 레벨 업 메서드
    public void levelUp() {
        if (this.level < 100){
            this.level++;
            //this.hp = this.level * 10; // HP를 레벨에 맞게 업데이트
            System.out.println(this.name + "의 레벨이 " + this.level + "로 상승했습니다!");
        }else {
            System.out.println(this.name + "의 레벨은 이미 최고단계입니다 ");
        }
        PokeEvolution.checkAndEvolve(this); // 진화 조건 확인 및 처리
    }
}