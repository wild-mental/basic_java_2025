package w3_2_collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayMemorySample {
    public static void main(String[] args) {
        int arrInitSize = 100_000_000; // * 32 byte 기준으로 메모리 할당에 소요되는 부담
        // 100MB 단위에서부터 할당 시간 부담 : 금융 - 호가 및 거래량 자료 등등
        // -> 프로그램 로직에 따라서 메모리에 올리는 선택지를 배제하거나 최초 실행시 모두 미리 로드하는 전략 사용 필요
        // 원페이지 앱, 캐시 메모리 사전 로드, 비동기 호출 및 CDN(Contents Delivery Network) 기법 사용
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            List<String> myList = new ArrayList<>(arrInitSize);
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Creating size " + arrInitSize +
            " ArrayList * 1000 times finished " +
            " (took " + elapsedTime + "ms)");
    }
}
