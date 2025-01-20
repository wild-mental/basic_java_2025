package w3_11_pokemongame_junho_0120;

import lombok.Getter;

@Getter
public class Pokemon implements IPokemon {
    private String pokemonName;
    private String customName;
    private int HP;
    private int level;
    private String type;

    public Pokemon(String pokemonName , int HP, int level, String type) {
        this.pokemonName = pokemonName;
        this.customName = pokemonName;
        this.HP = HP;
        this.level = level;
        this.type = type;
    }

    @Override
    public void attack(Pokemon tgPokemon) {
        int damage = 10;
        tgPokemon.setHP(Math.max(0, tgPokemon.getHP() - damage));
        System.out.println(tgPokemon.getPokemonName() + "'남은 HP: " + tgPokemon.getHP());

        int receivedDamage=10;
        this.setHP(Math.max(0, this.getHP() - receivedDamage));
        System.out.println(this.pokemonName + "'남은 HP: " + this.getHP());
    }

    private void setHP(int HP) {
        this.HP=HP;
    }

    @Override
    public void flee(int enemyLv) {
        if (this.level < enemyLv) {
            System.out.println(this.pokemonName + " 도망칠수가 없다!");
        } else {
            System.out.println(this.pokemonName + " 무사히 도망쳤다!");
        }
    }

    @Override
    public Pokemon evolve() {
        System.out.println(this.pokemonName + " 진화했다!");
        return new EvolvedPokemon(this.pokemonName + " Evo", this.HP + 20, this.level + 1, 1, this.type);
    }
}