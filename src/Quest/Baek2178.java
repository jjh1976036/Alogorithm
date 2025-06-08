package src.Quest;

import java.io.*;
import java.util.*;

public class Baek2178 {
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};  // 상, 하
    static int[] dy = {0, 0, -1, 1};  // 좌, 우

    public static int bfs(int x , int y) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!que.isEmpty()) {
            int[] current = que.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 범위 안, 방문 x, 이동 가능
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[nx][ny] && maze[nx][ny] == 1) {
                        que.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        maze[nx][ny] = maze[cx][cy] + 1;  // 거리 누적
                    }
                }
            }
        }
        return maze[N - 1][M - 1];  // 도착 지점까지의 거리
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++){
            String line = br.readLine();
            for (int j = 0; j < M; j++){
                maze[i][j] = line.charAt(j) - '0';  // 문자 -> 숫자 변환
            }
        }

        System.out.println(bfs(0, 0));  // 시작 좌표


    }
}
