package w3_11_pokemongame_gyudeok_0122;

import lombok.Data;
import lombok.Getter;

@Data
public class Pokemon implements IPokemon {
    private String pokemonName;
    @Getter
    private String customName;
    private int pokemonHp;
    private int pokemonDmg;
    private String pokemonType;
    private int pokemonLevel;


    public Pokemon(String pokemonName) {
        this.pokemonName = PokeDex.searchPokemon(pokemonName).getPokeName();
        this.customName = "";
        this.pokemonHp = PokeDex.searchPokemon(pokemonName).getPokeHp();
        this.pokemonDmg = PokeDex.searchPokemon(pokemonName).getPokeDmg();
        this.pokemonType = PokeDex.searchPokemon(pokemonName).getPokeCategory().toString();
        this.pokemonLevel = 0;
    }

    @Override
    public boolean attack(Pokemon tgPokemon) {
        // 데이터 및 동작 : tgPokemon.getHP(), tgPokemon.setHP()
        // 그 외 추가 동작 및 결과 출력
        tgPokemon.setPokemonHp(tgPokemon.getPokemonHp() - this.pokemonDmg);
        int checkZeroHp = tgPokemon.getPokemonHp();
        if (checkZeroHp <= 0) {
            tgPokemon.setPokemonHp(0);
//            if (tgPokemon.getCustomName() != null) {
//                System.out.println("\""+this.getCustomName() + "\"의 " + this.pokemonDmg + " 필살 공격 !");
//                System.out.println("\""+tgPokemon.getPokemonName() + "\"의 HP가 " + tgPokemon.getPokemonHp() + " 으로 감소했다..\n");
//                return false;
//            }else {
//                System.out.println("\""+this.getPokemonName() + "\"의 " + this.pokemonDmg + " 필살 공격 !");
//                System.out.println("\""+tgPokemon.getPokemonName() + "\"의 HP가 " + tgPokemon.getPokemonHp() + " 으로 감소했다..\n");
//                return false;   // 이겼으면 false , 지면 true
//            }
            System.out.println("\"" + this.getPokemonName() + "\"의 " + this.pokemonDmg + " 필살 공격 !");
            // TODO : 공통 출력부 통합하기
            System.out.println("\"" + tgPokemon.getPokemonName() + "\"의 HP가 " + tgPokemon.getPokemonHp() + " 으로 감소했다..\n");
            return false;   // 이겼으면 false , 지면 true
        }
//        if (tgPokemon.getCustomName() != null) {
//            System.out.println("\""+this.getCustomName() + "\"의 " + this.pokemonDmg + " 데미지 공격 !");
//            System.out.println("\""+tgPokemon.getCustomName() + "\"의 HP가 " + tgPokemon.getPokemonHp() + " 으로 감소했다..\n");
//            return true;
//        }else {
//            System.out.println("\""+this.getPokemonName() + "\"의 " + this.pokemonDmg + " 데미지 공격 !");
//            System.out.println("\""+tgPokemon.getPokemonName() + "\"의 HP가 " + tgPokemon.getPokemonHp() + " 으로 감소했다..\n");
//            return true;
//        }
        System.out.println("\"" + this.getPokemonName() + "\"의 " + this.pokemonDmg + " 데미지 공격 !");
        System.out.println("\"" + tgPokemon.getPokemonName() + "\"의 HP가 " + tgPokemon.getPokemonHp() + " 으로 감소했다..\n");
        return true;
    }

    @Override
    public void flee(int enemyLv) {
        // 결과 출력
    }

    @Override
    public Pokemon evolve() {
        // 데이터 및 동작
        // : this.getLevel()
        // : this.setters()
        // 기존 객체 참조 삭제
        // 진화된 객체 생성 및 리턴
        return null;
        // 리턴 타입은 부모 타입으로 선언되어 있는데
        // 실제 리턴 객체는 자식 타입으로 반환
        // => 다형성에 따른 부모 타입으로의 변환
    }

    public static void printPokemon(Pokemon wildPokemon) {
//        if (wildPokemon.getCustomName() != null) {
//            System.out.println("[  포켓몬 이름 : \" " + wildPokemon.getCustomName() + " \" ]" +
//                    "\n ● 포켓몬 타입 : " + wildPokemon.getPokemonType() + " 타입" +
//                    "\n ● 체력       : " + wildPokemon.getPokemonHp() +
//                    "\n ● 공격력     : " + wildPokemon.getPokemonDmg() + "\n");
//        }
//        System.out.println("[  포켓몬 이름 : \" " + wildPokemon.getPokemonName() + " \" ]" +
//                "\n ● 포켓몬 타입 : " + wildPokemon.getPokemonType() + " 타입" +
//                "\n ● 체력       : " + wildPokemon.getPokemonHp() +
//                "\n ● 공격력     : " + wildPokemon.getPokemonDmg() + "\n");
        System.out.println("[  포켓몬 이름 : \" " + wildPokemon.getPokemonName() + " \" ]" + "\n ● 포켓몬 타입 : " + wildPokemon.getPokemonType() + " 타입" + "\n ● 체력       : " + wildPokemon.getPokemonHp() + "\n ● 공격력     : " + wildPokemon.getPokemonDmg() + "\n");
    }

}