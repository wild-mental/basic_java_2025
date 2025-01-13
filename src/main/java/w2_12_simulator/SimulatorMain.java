package w2_12_simulator;

import java.util.Objects;
import java.util.Scanner;

public class SimulatorMain {
    public static void main(String[] args) {
        // 1. 시뮬레이션에 필요한 객체 명세 생성
        TV myTV = new TV(11, 10, 50, 50);
        TV myTV2 = new TV(11, 10, 50, 50);
        TV myTV3 = new TV(11, 10, 50, 50);
        TVRemoteController myTVRC = new TVRemoteController();
        Scanner myScanner = new Scanner(System.in);
        
        // 2. 사용자 input 커맨드 안내 출력
        System.out.println("""
            === TV 선택 ===
            "tv1" ~ "tv5"
            ==============
            === 리모콘 버튼 명세 ===
            POWER = "pow"
            CH_UP = "ch_up"
            ====================
            ex) "tv1_pow"
            ====================
            === 시뮬레이션 종료 ===
            "exit"
            ===================
        """);

        // 3. 본격적인 시뮬레이터 동작 시작
        while(true) {
            System.out.println("리모콘 버튼을 누르세요:");
            String consoleInput = myScanner.nextLine();

            // 시뮬레이션 종료 판단
            if (consoleInput.equals("exit")) {
                System.out.println("시뮬레이션을 종료합니다.");
                return;
            }

            // ------------------------------------
            // TV 선택 접두사에 따라서 아래 메서드 호출 대상을 분기
            String selectedTv = consoleInput.split("_")[0];
            switch (selectedTv) {
                case "tv1" ->
                    // 텔레비전 1을 향해서 버튼을 누릅니다
                    myTVRC.btnPress(myTV, consoleInput);
                case "tv2" ->
                    // 텔레비전 2을 향해서 버튼을 누릅니다
                    myTVRC.btnPress(myTV2, consoleInput);
                case "tv3" ->
                    // 텔레비전 3을 향해서 버튼을 누릅니다
                    myTVRC.btnPress(myTV3, consoleInput);
                default ->
                    // 기본 타겟은 텔레비전 1입니다
                    myTVRC.btnPress(myTV, consoleInput);
            }
            // ------------------------------------

            // 텔레비전이 켜져있는 경우 동작합니다.
            myTV.showVideo();
            // 멀티 디바이스인 경우 모든 디바이스 동작을 전부 실행
            // 향후 이러한 개별 객체의 동작은 별도 프로그램 카운터로 실행되어야 하므로
            // 멀티스레딩을 사용해 구현하고 실행해야 함
            // Device2.work();
            // Device3.work();

            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}