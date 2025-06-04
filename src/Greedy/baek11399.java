package src.Greedy;

import java.util.*;
import java.io.*;

public class baek11399 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 받은 n만큼을 times 배열로 저장
        int[] times = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            times[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(times);

        int sum = 0;
        int total = 0;
        for(int i = 0; i < n; i++){
            sum += times[i];  // 누적 대기 시간
            total += sum;  // 총 대기 시간
        }

        System.out.println(total);
    }
}
