package w2_12_simulator;

public class TVRemoteController {
    final static String POWER = "pow";
    final static String CH_UP = "ch_up";
    final static String CH_DN = "ch_dn";  // 미구현

    public void btnPress(TV targetTV, String btnInput) {
        switch (btnInput) {
            case POWER:
                targetTV.powerToggle();
                break;
            case CH_UP:
                targetTV.channelUp();
                break;
            default:
                break;
        }
    }
}
