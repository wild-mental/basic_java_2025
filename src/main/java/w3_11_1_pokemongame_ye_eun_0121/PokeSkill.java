package w3_11_1_pokemongame_ye_eun_0121;

public class PokeSkill {
    private String skillName;
    private String effect;
    private int damage;

    public PokeSkill(String skillName, String effect, int damage) {
        this.skillName = skillName;
        this.effect = effect;
        this.damage = damage;
    }

    public String getSkillName() {
        return skillName;
    }

    public int getDamage() {
        return damage;
    }

    public String getEffect() {
        return effect;
    }
}
