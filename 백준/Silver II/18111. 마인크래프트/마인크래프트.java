import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        int invan = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int time = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < n; i++){
            st= new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 가장 최소 시간 찾기
        for (int h = 0; h <= 256; h++){
            int del, plus; del = plus = 0;
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    if (map[i][j] - h >= 0){    // 지정 높이 보다 크다면 빼야하는 땅
                        del += map[i][j] - h;
                    } else plus += h - map[i][j];
                }
            }

            // 가능한 땅인지 확인
            if (del + invan >= plus){
                int nowTime = del *2 + plus; // 지우는 시간 2초 + 채우는 시간 1초
                if (nowTime <= time) {
                    time = nowTime;
                    max = h;
                }
            }
        }
        System.out.println(time + " " + max);
    }
}