package w3_11_pokemongame_jeuk;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlyPokemon extends Pokemon implements IFlyable {
    //날고있는 상태
    private boolean flyStatus = false;

    //생성자
    public FlyPokemon(String category, int HP, int LV, int AP, int Defence, String pokemonName, boolean flyStatus) {
        super(category, HP, LV, AP, Defence, pokemonName);
        this.flyStatus = flyStatus;
    }

    @Override
    public void fly(String tgCity) {
        System.out.println(tgCity + " 로 날아갑니다.");
    }

    @Override
    public void crossable(String tgCity) {
        fly(tgCity);
    }
}
