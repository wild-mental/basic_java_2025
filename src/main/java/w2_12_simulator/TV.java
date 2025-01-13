package w2_12_simulator;

public class TV {
    private boolean powerOn;
    private int channel;
    private int volume;
    private int brightness;
    private int contrast;

    public TV(
        // 초기값 지정을 위한 생성자 파라미터 선언 가능
    ) {
        this.powerOn = false;
    }

    public TV(
        int channel, int volume,
        int brightness, int contrast
    ) {
        this.powerOn = false;
        this.channel = channel;
        this.volume = volume;
        this.brightness = brightness;
        this.contrast = contrast;
    }

    public void powerToggle() {
        // 특수한 상태를 먼저 검사
        if (this.powerOn) {
            this.powerOn = false;
            System.out.println("TV Power Off!");
            return;
        }
        // 일반, 공통 동작을 마지막에 조건 분기 없이 수행
        this.powerOn = true;
        System.out.println("TV Power On!");
    };

    // channelUp(), channelDown()
    // 각 동작시에 TV는 외부와의 상호작용을 할 필요는 없음
    // 동작별 출력문을 작성해서 마무리
    public void channelUp() {
        if (!this.powerOn) {
            return;
        }
        this.channel++;
        System.out.println("Channel up to: " + this.channel);
    }

    // volumeUp(), volumeDown()

    // contrastUp(), contrastDown()

    // showVideo()
    public void showVideo() {
        if (!this.powerOn) {
            return;
        }
        System.out.println("TV 에서 위성/디지털 방송이 송출됩니다.");
    }
}
