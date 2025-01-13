package w2_13_advancedsimulator;

public class SatelliteTV extends TV {
    public SatelliteTV(int channel, int volume, int brightness, int contrast) {
        super(channel, volume, brightness, contrast);
    }

    // 위성 TV 에만 존재하는 변수 및 메서드를 선언합니다

    // 방송 송출 같은 경우 내용 변경 필요하므로 오버라이드 합니다
}
