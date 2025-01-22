package w3_11_pokemongame_gyudeok_0122;

import java.util.Objects;
import java.util.Scanner;

public class GameLauncher {
    public static void main(String[] args) {
        // 1. 야생 포켓몬 더미데이터 생성
        // 2. 트레이너 더미데이터 생성
        // 3. 포켓몬 사전 더미데이터 생성 (PokeDex 내부)
        // 1) 리턴타입이 자식 타입인 EvolvedPokemon 인데 Pokemon 타입 변수에 할당
//        EvolvedPokemon evolvedPokemon1 = pokemon1.evolve();
//        pokemon1 = evolvedPokemon1;
        // 2) evolve() 리턴타입 자체를 다형성 타입으로 핸들링
//        pokemon1 = pokemon1.evolve();

        Scanner sc = new Scanner(System.in);
        System.out.println("=========== \"모험을 시작할 트레이너의 이름을 입력해주세요.\" ===========");
        String userName = sc.nextLine();
        Trainer trainer = new Trainer(userName);
        System.out.println(

                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⠞⢳⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡔⠋⠀⢰⠎⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⢆⣤⡞⠃⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⢠⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⢀⣀⣾⢳⠀⠀⠀⠀⢸⢠⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n " +
                "⣀⡤⠴⠊⠉⠀⠀⠈⠳⡀⠀⠀⠘⢎⠢⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀ \n" +
                "⠳⣄⠀⠀⡠⡤⡀⠀⠘⣇⡀⠀⠀⠀⠉⠓⠒⠺⠭⢵⣦⡀⠀⠀⠀\n" +
                "⠀⢹⡆⠀⢷⡇⠁⠀⠀⣸⠇⠀⠀⠀⠀⠀⢠⢤⠀⠀⠘⢷⣆⡀⠀⠀⠀⠀⠀======================================================================\n" +
                "⠀⠀⠘⠒⢤⡄⠖⢾⣭⣤⣄⠀⡔⢢⠀⡀⠎⣸⠀⠀⠀⠀⠹⣿⡀⠀⠀⠀⠀⠀환영 합니다 ! [ \" "+ userName + " \" ] 님, 포켓몬 세계에 오신 것을 환영합니다!⠀\n" +
                "⠀⠀⢀⡤⠜⠃⠀⠀⠘⠛⣿⢸⠀⡼⢠⠃⣤⡟⠀⠀⠀⠀⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀이제 새롭게 만날 포켓몬을 확인하고, 멋진 모험을 시작해보세요!⠀⠀\n" +
                "⠀⠀⠸⠶⠖⢏⠀⠀⢀⡤⠤⠇⣴⠏⡾⢱⡏⠁⠀⠀⠀⠀⢠⣿⠃⠀⠀⠀======================================================================\n" +
                "⠀⠀⠀⠀⠀⠈⣇⡀⠿⠀⠀⠀⡽⣰⢶⡼⠇⠀⠀⠀⠀⣠⣿⠟⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠈⠳⢤⣀⡶⠤⣷⣅⡀⠀⠀⠀⣀⡠⢔⠕⠁⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠫⠿⠿⠿⠛⠋⠁⠀⠀⠀⠀");
        Scanner scanner = new Scanner(System.in);
        System.out.println("===============================================================");
        System.out.print("게임시작을 원하시면 아무키를 입력하세요 !\n게임종료를 원하시면 \" 나가기 \" 를 입력해 주세요.  ");
        String userChoice = scanner.nextLine();
        while (!Objects.equals(userChoice, "나가기")) {
            if (!trainer.hunt()) {
                System.out.println("게임시작을 원하시면 아무키를 입력하세요 !\n게임종료를 원하시면 \" 나가기 \" 를 입력해 주세요.");
                userChoice = scanner.next();
            }
        }

    }
}
