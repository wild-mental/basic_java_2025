package algorithm.hyungjun_bj1009;

import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder(); // StringBuilder를 사용하여 출력을 모아둠

        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);

            // A의 B 제곱의 마지막 자리 수를 계산
            int lastDigit = 1;
            A = A % 10; // A의 마지막 자리 수만 필요

            for (int j = 0; j < B; j++) {
                lastDigit = (lastDigit * A) % 10;
            }

            sb.append(lastDigit).append("\n"); // 결과를 StringBuilder에 저장
        }

        System.out.print(sb.toString()); // 한 번에 출력하여 불필요한 개행 방지
    }
}
