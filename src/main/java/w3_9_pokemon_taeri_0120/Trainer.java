package w3_9_pokemon_taeri_0120;

import java.util.ArrayList;

public class Trainer {
    String name;
    boolean isGymLeader;
    boolean gender; // true = 남자, false = 여자

    ArrayList<Pokemon> myPokemon;   // 트레이너가 소지하고있는 포켓몬
    ArrayList<Pokemon> myPokemonPc; // 트레이너의 포켓몬이 꽉차면 저장할 PC 창고

    private static final int MAX_POKEMON = 6; // 트레이너가 소지할 수 있는 최대 포켓몬 수

    public Trainer(String name, boolean isGymLeader, boolean gender) {
        this.name = name;
        this.isGymLeader = isGymLeader;
        this.gender = gender;
        this.myPokemon = new ArrayList<>(MAX_POKEMON);
        this.myPokemonPc = new ArrayList<>();
    }

    // 포켓몬 추가 메서드
    public boolean addPokemon(Pokemon pokemon) {
        if (myPokemon.size() < MAX_POKEMON) {
            myPokemon.add(pokemon);
            System.out.println(myPokemon.size() + "번째 포켓몬 추가 성공");
            return true; // 추가 성공
        } else {
            System.out.println(this.name + "은(는) 이미 최대 " + MAX_POKEMON + "마리의 포켓몬을 보유하고 있습니다.");
            System.out.println(pokemon.name + " 을(를)" + this.name + " pc에 저장합니다.");
            myPokemonPc.add(pokemon);
            return false; // 추가 실패
        }
    }

    // 트레이너 pc에 있는 포켓몬 출력
    public String getPcPokemon() {
        int pcnt = 1;
        StringBuilder sb = new StringBuilder();
        sb.append("===" + this.name + " 트레이너의 pc ===");
        if (myPokemonPc.isEmpty()) {
            sb.append("\nPC가 비어있습니다.");
        } else {
            for (Pokemon pokemon : myPokemonPc) {
                sb.append("\n").append(pcnt++).append(". ").append(pokemon.name)
                        .append(", 레벨: ").append(pokemon.level)
                        .append(", HP: ").append(pokemon.hp)
                        .append(", 보유 스킬: ").append(pokemon.getSkillNames());
            }
        }
        return sb.toString();
    }

    // Trainer 정보 출력
    public String toString() {
        int pcnt = 1;
        StringBuilder sb = new StringBuilder();
        sb.append("=== 트레이너 정보 ===")
                .append("\n트레이너 이름: ").append(this.name)
                .append("\n체육관 관장 여부: ").append(this.isGymLeader ? "예" : "아니오")
                .append("\n성별: ").append(this.gender ? "남자" : "여자")
                .append("\n보유 포켓몬: ");
        if (myPokemon.isEmpty()) {
            sb.append("없음");
        } else {
            for (Pokemon pokemon : myPokemon) {
                sb.append("\n- 포켓몬" + pcnt++ + ": ").append(pokemon.name)
                        .append(", 레벨: ").append(pokemon.level)
                        .append(", HP: ").append(pokemon.hp)
                        .append(", 보유 스킬: ").append(pokemon.getSkillNames());
            }
        }
        return sb.toString();
    }

    // 전투 시작 메서드
    public void startBattle(Trainer opponent) {
        Battle.start(this, opponent);
    }

    // 야생 포켓몬과의 전투 시작 메서드
    public void startWildBattle(Pokemon wildPokemon) {
        WildBattle wildBattle = new WildBattle(this, wildPokemon);
        wildBattle.start();
    }

    // 전투라는 행위가 대상은 달라도 실행 맥락이 매우 유사할 것
    // => 추상 계층을 두면 유리할 것
    // => 상속으로 할 지, 구현으로 할 지 선택가능
    // => 오버로딩으로 하면 아예 타입을 일원화 해도 좋을 것 : 가능하면 이 판단으로 바로 구현하면 좋음

    // 치료실에서 포켓몬 치료
    public void visitHealingCenter(HealingCenter healingCenter) {
        healingCenter.healPokemons(this);
    }

    // 전투에서 승리했을 때 호출되는 메서드
    public void winBattle() {

        System.out.println("\n" + this.name + "이(가) 전투에서 승리했습니다!");
        System.out.println("모든 포켓몬의 레벨이 1 상승합니다.");

        for (Pokemon pokemon : myPokemon) {
            pokemon.levelUp(); // 포켓몬 레벨 업

        }
    }



    // Getter 메서드 추가
    public String getName() {
        return name;
    }

    public ArrayList<Pokemon> getMyPokemon() {
        return myPokemon;
    }
}