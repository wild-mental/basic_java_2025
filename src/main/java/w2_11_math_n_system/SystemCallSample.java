package w2_11_math_n_system;

import java.time.Instant;

public class SystemCallSample {
    public static void main(String[] args) {
        // 시간 가져오기
        Instant nowTime = Instant.now();
        System.out.println("Instant now: " + nowTime);

        long currentTime = System.currentTimeMillis();
        System.out.println("현재 시간(밀리초): " + currentTime);

        long nanoTime = System.nanoTime();
        System.out.println("현재 시간(나노초): " + nanoTime);

        // 환경변수 가져오기
        String userName = System.getenv("USER");
        System.out.println("사용자 이름: " + userName);
        String pathEnv = System.getenv("PATH");
        System.out.println("시스템 PATH ENV: " + pathEnv);

        System.out.println("종료 전");
        System.exit(0); // 상태 0으로 JVM 종료
        System.out.println("종료 후"); // 이 줄은 실행되지 않음
    }
}
