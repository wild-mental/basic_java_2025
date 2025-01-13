//package w2_13_advancedsimulator;
//
//// 위성 TV, 인터넷 TV, 에어컨 모두 제어
//public class MultiDeviceRC {
//// public class TVRemoteController {
//    // 상수 개별 관리 -> enum 으로 묶음 관리
//    final static String POWER = "pow";
//    final static String CH_UP = "ch_up";
//    final static String CH_DN = "ch_dn";  // 미구현
//
//    public enum TVButton {
//        POWER, CH_UP, CH_DN
//        // 생성자가 있는 형태로 변경
//        // 1) 각 상수 enum 에 "user_cmd" 속성을 부여
//        // 2) "user_cmd" 속성을 대상 디바이스별 함수 호출로 연결할 수 있도록 동작 구현
//    }
//
//    public enum ACButton {
//        POWER, WIND_UP, WIND_DN
//        // 생성자가 있는 형태로 변경
//        // 1) 각 상수 enum 에 "user_cmd" 속성을 부여
//        // 2) "user_cmd" 속성을 대상 디바이스별 함수 호출로 연결할 수 있도록 동작 구현
//    }
//
//    // 아래 btnPress 메서드는 오버로딩을 통해서
//    // 대상 기기, 누른 버튼에 맞게 자동으로 선택될 수 있도록 구현
//    public void btnPress(
//        TV targetTV,     // 대상 객체에 따라서 파라미터 타입 선언 필요
//        String btnInput  // 문자열이 아닌 enum 객체로 받음 (대상 객체에 맞는 Button enum 으로)
//    ) {
//        switch (btnInput) {
//            case POWER:
//                targetTV.powerToggle();
//                break;
//            case CH_UP:
//                targetTV.channelUp();
//                break;
//            default:
//                break;
//        }
//    }
//
//    // 별도 조작이 필요한 기기 개수만큼 오버로딩
//    // (조작 니즈에 따라서 버튼 세트도 달라지므로 1:1로 늘어나게 됨)
//    public void btnPress(
//        SatelliteTV targetTV,     // 대상 객체에 따라서 파라미터 타입 선언 필요
//        TVButton btnInput  // 문자열이 아닌 enum 객체로 받음 (대상 객체에 맞는 Button enum 으로)
//    ) {
//        switch (btnInput) {
//            case POWER:
//                targetTV.powerToggle();
//                break;
//            case CH_UP:
//                targetTV.channelUp();
//                break;
//            default:
//                break;
//        }
//    }
//}
