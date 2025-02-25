package w6_2_multithreading;

import java.awt.*;

public class DelayingStrategySample {
    // [결론 요약]
    // 1) 100ms 를 10번  sleep() 한다고 해서 (= sleep(100) * 10) sleep(1000) 이 아니다.
    // 2) 정확한 시간을 측정해서 실행 간격을 두기 위해서는 스레드를 점유해야 한다.

    // sleep() 의 장단점
    // 장점 -> 한정된 CPU 코어 처리자원을 다른 프로세스가 사용할 수 있게 양보할 수 있음
    // 단점 -> CPU 자원을 반납함으로써, 일정한 대기시간을 보장할 수 없음 (작업 우선순위가 계속 밀릴 경우 무한대기 발생도 가능 -> 기아 상태)

    public static void main(String[] args) {
        int reps = 100;
        int delayTime = 10;
        Toolkit tk = Toolkit.getDefaultToolkit();

        // 두 스레드 실행 (sleep or occupy)
        boolean occupyCpu = false;  // true/false 바꿔가며 실험해 보기
        printThreadWithElapsed(reps, delayTime, occupyCpu);
        beepThreadWithElapsed(tk, reps, delayTime, occupyCpu);
    }

    public static class ThreadWithElapsed extends Thread {
        public  ThreadWithElapsed(Runnable target) {
            super(target);
        }
        @Override
        public void run() {
            long startTime = System.currentTimeMillis();
            super.run();
            long elapsedTime = System.currentTimeMillis() - startTime;
            System.out.println(this.getName()+" done at elapsed time:"+elapsedTime+"ms");
        }
    }
    public static void printThreadWithElapsed(int reps, int delayTime, boolean isOccupyThread) {
        ThreadWithElapsed printElapsedThread = new ThreadWithElapsed(() -> {
            for (int i = 0; i < reps; i++) {
                System.out.println("Beep" + i);
                delayMethod(delayTime, isOccupyThread);
            }
        });
        printElapsedThread.setName("프린팅 스레드");
        printElapsedThread.start();
    }
    public static void beepThreadWithElapsed(Toolkit tk, int reps, int delayTime, boolean isOccupyThread) {
        ThreadWithElapsed beepElapsedThread = new ThreadWithElapsed(() -> {
            for (int i = 0; i < reps; i++) {
                tk.beep();
                delayMethod(delayTime, isOccupyThread);
            }
        });
        beepElapsedThread.setName("비프음 스레드");
        beepElapsedThread.start();
    }
    public static void delayMethod(int delayTime, boolean isOccupyThread) {
        if(!isOccupyThread) {
            // sleep()을 사용한 delay
            try { Thread.sleep(delayTime); } catch (InterruptedException e) { throw new RuntimeException(e); }
        } else {
            // CPU 점유형 delay
            long startTime = System.currentTimeMillis();
            long elapsedTime = 0;
            while (elapsedTime < delayTime) {
                // Update elapsed time
                elapsedTime = System.currentTimeMillis() - startTime;
            }
        }
    }
}