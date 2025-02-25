package algorithm.hyungjun_bj1009;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final int[][] CYCLES = {
        {1},            // a = 1  → index 0
        {2, 4, 8, 6},   // a = 2  → index 1
        {3, 9, 7, 1},   // a = 3  → index 2
        {4, 6},         // a = 4  → index 3
        {5},            // a = 5  → index 4
        {6},            // a = 6  → index 5
        {7, 9, 3, 1},   // a = 7  → index 6
        {8, 4, 2, 6},   // a = 8  → index 7
        {9, 1},         // a = 9  → index 8
        {0}             // a = 10 → index 9
    };

    public static int lastComputerNumber(int a, int b) {
        a = (a - 1) % 10; // 입력된 a를 0~9 범위의 인덱스로 변환
        int[] cycle = CYCLES[a]; // 해당하는 주기 배열 가져오기
        int cycleLength = cycle.length;

        // b가 클 경우 주기의 길이를 활용하여 빠르게 인덱스 계산
        int index = (b - 1) % cycleLength;
        return cycle[index];
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용한 빠른 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력

        StringBuilder sb = new StringBuilder(); // 결과 저장용 StringBuilder

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(lastComputerNumber(a, b)).append("\n"); // 결과 저장
        }

        System.out.print(sb.toString()); // 결과 한 번에 출력

        br.close();
    }
}

