package src.DP;

import java.io.*;

public class Baek1463 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[1] = 0;

        for (int i = 2; i <= N; i++){

            // 연산 3의 경우
            dp[i] = dp[i - 1] + 1;

            // 연산 2의 경우
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            // 연산 1의 경우
            if (i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}
