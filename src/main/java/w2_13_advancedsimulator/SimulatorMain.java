//package w2_13_advancedsimulator;
//
//import java.util.Scanner;
//
//public class SimulatorMain {
//    public static void main(String[] args) {
//        // 1. 시뮬레이션에 필요한 객체 명세 생성
//        SatelliteTV mySatelliteTV = new SatelliteTV(11, 10, 50, 50);
//        InternetTV myInternetTV = new InternetTV(11, 10, 50, 50);
//        Aircon myAircon = new Aircon();
//        TVRemoteController myTVRC = new TVRemoteController();
//        Scanner myScanner = new Scanner(System.in);
//
//        // 3. 본격적인 시뮬레이터 동작 시작
//        while(true) {
//            // 2. 사용자 input 커맨드 안내 출력
//            System.out.println("""
//                === 디바이스 선택 ===
//                "sat", "int", "ac"
//                ==================
//                === 타겟별 리모콘 버튼 명세 ===
//                위성 TV 제어  POWER = "pow"
//                            CH_UP = "ch_up"
//                (TV 끼리는 버튼이 같을 수도 있다 -> 명세에 표시 불필요)
//                인터넷 TV 제어 POWER = "pow"
//                            CH_UP = "ch_up"
//                에어컨 제어    POWER = "pow"
//                            AIR_UP = "air_up"
//                            TMP_UP = "tmp_up"
//                ====================
//                ex) "sat_pow", "int_pow", "ac_pow"
//                ====================
//                === 시뮬레이션 종료 ===
//                "exit"
//                ===================
//            """);
//            System.out.println("리모콘 버튼을 누르세요:");
//            String consoleInput = myScanner.nextLine();
//
//            // 시뮬레이션 종료 판단
//            if (consoleInput.equals("exit")) {
//                System.out.println("시뮬레이션을 종료합니다.");
//                return;
//            }
//
//            // 디바이스 선택 커맨드 해석
//            String selectedDevice = consoleInput.split("_")[0];
//            // ------------------------------------
//            // TV 선택 접두사에 따라서 아래 메서드 호출 대상을 분기
//            switch (selectedDevice) {
//                case "sat" ->
//
//                    // 위성 TV 를 향해서 버튼을 누릅니다
//                    myTVRC.btnPress(mySatelliteTV, consoleInput);
//                case "int" ->
//                    // 인터넷 TV 를 향해서 버튼을 누릅니다
//                    myTVRC.btnPress(myInternetTV, consoleInput);
//                case "ac" ->
//                    // 텔레비전 3을 향해서 버튼을 누릅니다
//                    myTVRC.btnPress(myAircon, consoleInput);
//                default ->
//                    System.out.println("커맨드 오류 : 디바이스 선택이 되지 않았습니다.");
//            }
//            // ------------------------------------
//
//            // 멀티 디바이스인 경우 모든 디바이스 동작을 전부 실행
//            // 향후 이러한 개별 객체의 동작은 별도 프로그램 카운터로 실행되어야 하므로
//            // 멀티스레딩을 사용해 구현하고 실행해야 함
//            mySatelliteTV.showVideo();
//            myInternetTV.showVideo();
//            myAircon.blowWind();
//
//            try {
//                Thread.sleep(1_000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//}