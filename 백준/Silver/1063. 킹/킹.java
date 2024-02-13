import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // R , L , B, T, RT, LT, RB, LB
        int[][] dis = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int[] king = new int[2]; int[] stone = new int[2];  // 열 행

        String[] str = st.nextToken().split("");
        king[0] = str[0].charAt(0) - 65 + 1; king[1] = Integer.parseInt(str[1]);
        str = st.nextToken().split("");
        stone[0] = str[0].charAt(0) - 65 + 1; stone[1] = Integer.parseInt(str[1]);
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0;i < n; i++){
            String s = br.readLine();

            switch (s){
                case "R":
                    if (!isBinary(king[1] + dis[0][0], king[0] + dis[0][1])) break;  // 킹이 갈 수 없는 경우
                    if (king[1] + dis[0][0] == stone[1] && king[0] + dis[0][1] == stone[0]){    // 돌의 위치와 같은 경우
                        // 돌이 범위를 벗어나느 경우
                        if (!isBinary(stone[1] + dis[0][0], stone[0] + dis[0][1])) break;
                        // 돌 위치 변경
                        stone[1] += dis[0][0];
                        stone[0] += dis[0][1];
                        king[1] += dis[0][0];
                        king[0] += dis[0][1];
                    }
                    // 돌의 위치와 다른 경우
                    else {
                        king[1] += dis[0][0];
                        king[0] += dis[0][1];
                    }
                    break;
                case "L":
                    if (!isBinary(king[1] + dis[1][0], king[0] + dis[1][1])) continue;  // 킹이 갈 수 없는 경우
                    if (king[1] + dis[1][0] == stone[1] && king[0] + dis[1][1] == stone[0]){    // 돌의 위치와 같은 경우
                        // 돌이 범위를 벗어나느 경우
                        if (!isBinary(stone[1] + dis[1][0], stone[0] + dis[1][1])) break;
                        // 돌 위치 변경
                        stone[1] += dis[1][0];
                        stone[0] += dis[1][1];
                        king[1] += dis[1][0];
                        king[0] += dis[1][1];
                    }
                    // 돌의 위치와 다른 경우
                    else {
                        king[1] += dis[1][0];
                        king[0] += dis[1][1];
                    }
                    break;
                case "B":
                    if (!isBinary(king[1] + dis[2][0], king[0] + dis[2][1])) break;  // 킹이 갈 수 없는 경우
                    if (king[1] + dis[2][0] == stone[1] && king[0] + dis[2][1] == stone[0]){    // 돌의 위치와 같은 경우
                        // 돌이 범위를 벗어나느 경우
                        if (!isBinary(stone[1] + dis[2][0], stone[0] + dis[2][1])) break;
                        // 돌 위치 변경
                        stone[1] += dis[2][0];
                        stone[0] += dis[2][1];
                        king[1] += dis[2][0];
                        king[0] += dis[2][1];
                    }
                    // 돌의 위치와 다른 경우
                    else {
                        king[1] += dis[2][0];
                        king[0] += dis[2][1];
                    }
                    break;
                case "T":
                    if (!isBinary(king[1] + dis[3][0], king[0] + dis[3][1])) break;  // 킹이 갈 수 없는 경우
                    if (king[1] + dis[3][0] == stone[1] && king[0] + dis[3][1] == stone[0]){    // 돌의 위치와 같은 경우
                        // 돌이 범위를 벗어나느 경우
                        if (!isBinary(stone[1] + dis[3][0], stone[0] + dis[3][1])) break;
                        // 돌 위치 변경
                        stone[1] += dis[3][0];
                        stone[0] += dis[3][1];
                        king[1] += dis[3][0];
                        king[0] += dis[3][1];
                    }
                    // 돌의 위치와 다른 경우
                    else {
                        king[1] += dis[3][0];
                        king[0] += dis[3][1];
                    }
                    break;
                case "RT":
                    if (!isBinary(king[1] + dis[4][0], king[0] + dis[4][1])) break;  // 킹이 갈 수 없는 경우
                    if (king[1] + dis[4][0] == stone[1] && king[0] + dis[4][1] == stone[0]){    // 돌의 위치와 같은 경우
                        // 돌이 범위를 벗어나느 경우
                        if (!isBinary(stone[1] + dis[4][0], stone[0] + dis[4][1])) break;
                        // 돌 위치 변경
                        stone[1] += dis[4][0];
                        stone[0] += dis[4][1];
                        king[1] += dis[4][0];
                        king[0] += dis[4][1];
                    }
                    // 돌의 위치와 다른 경우
                    else {
                        king[1] += dis[4][0];
                        king[0] += dis[4][1];
                    }
                    break;
                case "LT":
                    if (!isBinary(king[1] + dis[5][0], king[0] + dis[5][1])) break;  // 킹이 갈 수 없는 경우
                    if (king[1] + dis[5][0] == stone[1] && king[0] + dis[5][1] == stone[0]){    // 돌의 위치와 같은 경우
                        // 돌이 범위를 벗어나느 경우
                        if (!isBinary(stone[1] + dis[5][0], stone[0] + dis[5][1])) break;
                        // 돌 위치 변경
                        stone[1] += dis[5][0];
                        stone[0] += dis[5][1];
                        king[1] += dis[5][0];
                        king[0] += dis[1][1];
                    }
                    // 돌의 위치와 다른 경우
                    else {
                        king[1] += dis[5][0];
                        king[0] += dis[5][1];
                    }
                    break;
                case "RB":
                    if (!isBinary(king[1] + dis[6][0], king[0] + dis[6][1])) break;  // 킹이 갈 수 없는 경우
                    if (king[1] + dis[6][0] == stone[1] && king[0] + dis[6][1] == stone[0]){    // 돌의 위치와 같은 경우
                        // 돌이 범위를 벗어나느 경우
                        if (!isBinary(stone[1] + dis[6][0], stone[0] + dis[6][1])) break;
                        // 돌 위치 변경
                        stone[1] += dis[6][0];
                        stone[0] += dis[6][1];
                        king[1] += dis[6][0];
                        king[0] += dis[6][1];
                    }
                    // 돌의 위치와 다른 경우
                    else {
                        king[1] += dis[6][0];
                        king[0] += dis[6][1];
                    }
                    break;
                case "LB":
                    if (!isBinary(king[1] + dis[7][0], king[0] + dis[7][1])) break;  // 킹이 갈 수 없는 경우
                    if (king[1] + dis[7][0] == stone[1] && king[0] + dis[7][1] == stone[0]){    // 돌의 위치와 같은 경우
                        // 돌이 범위를 벗어나느 경우
                        if (!isBinary(stone[1] + dis[7][0], stone[0] + dis[7][1])) break;
                        // 돌 위치 변경
                        stone[1] += dis[7][0];
                        stone[0] += dis[7][1];
                        king[1] += dis[7][0];
                        king[0] += dis[7][1];
                    }
                    // 돌의 위치와 다른 경우
                    else {
                        king[1] += dis[7][0];
                        king[0] += dis[7][1];
                    }
                    break;
            }
        }

        System.out.print(Character.toChars(king[0] + 65 -1));
        System.out.println(king[1]);
        System.out.print(Character.toChars(stone[0] + 65 -1));
        System.out.println(stone[1]);
    }
    static boolean isBinary(int x, int y){
        return x > 0 && x <= 8 && y > 0 && y <= 8;
    }
}