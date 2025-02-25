package algorithm.hyungjun_bj1009;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainBefore {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String lastDigits = "";

        for (int i = 0; i < T; i++) {
            String line = br.readLine();
            String[] input = line.split(" ");

            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);

            int lastDigit = A % 10; // A의 마지막 자리 수만 필요
            for (int j = 0; j < B; j++) {
                lastDigit = A % 10;
            }
            // 이진 정렬


        }
    }
}