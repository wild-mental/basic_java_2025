package w6_2_multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static java.lang.Thread.sleep;

public class ConcurrencyAdvancedSample {
    // 여러 스레드가 동시에 접근할 필드 선언
    static int sharedVariable = 0;
    // 여러개의 스레드가 동시에 접근하는 것을 고려하지 않음
    // 불필요한 연산이 없어서 효율적, 하지만 동시성 발생시 안전하지 않음
    //   => Thread Unsafe 한 자료형
    static List<Integer> integerArrayList = new ArrayList<>();
    // Thread Safe 한 메서드를 제공하는 Vector
    static List<Integer> integerVector = new Vector<>();

    // 1)
    static Runnable threadWorkload = () -> {
        // 코드 임계영역을 사용하지 않음
        // 1) 변수 동시 접근할 때, 스레드 간 순서 달라질 수 있음
        // 2) ArrayList.add() 와 같이 Thread Unsafe 메서드를 호출할 때,
        //    실패하거나 선후 관계가 뒤바뀌는 일이 발생
        // 3) Vector.add() 동시 접근할 때, 순차처리 Sync 적용되어 실패 또는 순서 왜곡 없음
        //    하지만 변수 연산 시에 이미 동시접근 때문에 연산처리 완료 전 변수가 참조되는 문제는 그대로 반영됨
        for (int i = 0; i < 10; i++) {
            sharedVariable++;
            integerArrayList.add(sharedVariable);
            integerVector.add(sharedVariable);
            try {Thread.sleep(10);} catch (InterruptedException e) {throw new RuntimeException(e);}
        }
    };

    // 2), 3)
    // 함수형 인터페이스 구현체 (Runnable 의 자식 객체)
    static class syncedThreadWorkload implements Runnable {
        // 호출부를 Synchronize 하더라도, 호출 되는 부분까지 Sync 할 수는 없음
        @Override
        public synchronized void run() {
            for (int i = 0; i < 10; i++) {
                sharedVariable++;
                integerArrayList.add(sharedVariable);
                integerVector.add(sharedVariable);
                try {Thread.sleep(10);} catch (InterruptedException e) {throw new RuntimeException(e);}
            }
        }
    }

    // 4)
    static synchronized void syncedRun() {
        for (int i = 0; i < 10; i++) {
            sharedVariable++;
            integerArrayList.add(sharedVariable);
            integerVector.add(sharedVariable);
            try {Thread.sleep(10);} catch (InterruptedException e) {throw new RuntimeException(e);}
        }
    }

    // 5-1)
    static void blockSyncedRun() {
        for (int i = 0; i < 10; i++) {
            synchronized (
                // 싱크 기준이 되는 프로그램 항목 -> 객체 또는 클래스
                ConcurrencyAdvancedSample.class
                // 사용자가 정의한 상속구조 등등 자식 클래스가 있는 경우, 싱크 단위가 세분화될 수 있기 때문에
                // 명시적으로 지정하는 이점을 구현 맥락에 따라 적용 필요!
            ) {
                sharedVariable++;
                integerArrayList.add(sharedVariable);
                integerVector.add(sharedVariable);
                try {Thread.sleep(10);} catch (InterruptedException e) {throw new RuntimeException(e);}
            }
        }
    }

    // 5-2)
    static class BlockSyncedThreadWorkload implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (ConcurrencyAdvancedSample.class) {
                    sharedVariable++;
                    integerArrayList.add(sharedVariable);
                    integerVector.add(sharedVariable);
                    try {Thread.sleep(10);} catch (InterruptedException e) {throw new RuntimeException(e);}
                }
            }
        }
    }

    // 6)
    static class MinimumBlockSyncedThreadWorkload implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (ConcurrencyAdvancedSample.class) {
                    // 임계 영역이 작으면 작을 수록, Multithreading 의 효과를 유지할 수 있습니다.
                    sharedVariable++;
                    integerArrayList.add(sharedVariable);
                }
                integerVector.add(sharedVariable);
                try {Thread.sleep(10);} catch (InterruptedException e) {throw new RuntimeException(e);}
            }
        }
    }

    public static void main(String[] args) {
        // 1) UnSynced
//        Thread t1 = new Thread(threadWorkload);
//        Thread t2 = new Thread(threadWorkload);

        // 2) Method Synced (객체 단위 Sync, 여러 객체 사용)
        //    -> 스레드 생성 시마다 별도의 Runnable 객체가 전달되고 있음
        //    -> 아무리 정의된 워크로드가 Sync 되어 있어도,
        //       객체 단위 Sync 이기 때문에, (static sync 가 아님)
        //       t1, t2 간 동시성은 해결되지 않는다.
//        Thread t1 = new Thread(new syncedThreadWorkload());
//        Thread t2 = new Thread(new syncedThreadWorkload());

        // ====== 맞는 사례 ======
        // 3) Method Synced (객체 단위 Sync, 단일 객체 사용)
        // 2번 사례와 비교해서 "싱크 단위를 하나로 묶어주어야 한다" 라는 원칙 파악하기!
//        Runnable syncedRunnableObj = new syncedThreadWorkload();
//        Thread t1 = new Thread(syncedRunnableObj);
//        Thread t2 = new Thread(syncedRunnableObj);

        // 4) Method Synced (Static Sync)
//        Thread t1 = new Thread(ConcurrencyAdvancedSample::syncedRun);
//        Thread t2 = new Thread(ConcurrencyAdvancedSample::syncedRun);

        // 5-1) 블럭 단위 Sync (Static Sync)
        // 메서드를 통째로 Sync 하기보다 block {} 요소를 사용하면
        // 효과적이고, Sync 기준점도 명시적으로 선언할 수 있다.
//        Thread t1 = new Thread(ConcurrencyAdvancedSample::blockSyncedRun);
//        Thread t2 = new Thread(ConcurrencyAdvancedSample::blockSyncedRun);
        // 5-2) 블럭 단위 Sync (개별 객체 할당)
        // 명시적인 방식의 Sync 가 언제나 더 바람직
//        Thread t1 = new Thread(new BlockSyncedThreadWorkload());
//        Thread t2 = new Thread(new BlockSyncedThreadWorkload());

        // 6) 임계 영역 최소화 블럭 단위 Sync
        Thread t1 = new Thread(new MinimumBlockSyncedThreadWorkload());
        Thread t2 = new Thread(new MinimumBlockSyncedThreadWorkload());

        // 실행 및 결과 확인
        t1.start();
        t2.start();

        // 쓰레드가 작업을 마친 후 종료된 시점까지 본 라인에서 Blocking 상태로 대기
        try {
            t1.join();
            t2.join();
            System.out.println(
                integerArrayList + "\n" +
                integerArrayList.size()
            );
            System.out.println(
                integerVector + "\n" +
                integerVector.size()
            );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
