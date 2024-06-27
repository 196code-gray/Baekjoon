import java.util.*;
import java.io.*;

class Main{
    static BufferedReader br;
    static int n, k , turn;
    static int[][] xy = {{0, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static Horse[] horse;
    static ArrayList<Integer>[] other;
    static int[][] map, horseMap;
    static StringTokenizer st;
    static class Horse{
        int direction, r, c;
        boolean down;

        Horse(int direction, boolean down, int r, int c){
            this.direction = direction;
            this.down = down;
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args)throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
        map = new int[n][n]; horseMap = new int[n][n];
        turn =0;
        horse = new Horse[k +1];
        other = new ArrayList[k + 1];
        for (int i = 1; i<= k; i++)
            other[i] = new ArrayList<>();

        for (int i = 0;i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <=k; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) -1;
            int c = Integer.parseInt(st.nextToken()) -1;
            int d = Integer.parseInt(st.nextToken());
            horseMap[r][c] = i; // 말 번호
            other[i].add(i); // 본인 위 말 본인
            horse[i] = new Horse(d, true, r, c);
        }

        end : while(true){
            turn++;
            if (turn > 1000){ // 1000 넘을 시 -1 출력
                System.out.println(-1);
                return;
            }
            for (int i = 1; i <= k; i++){
                if (!horse[i].down) continue; // 본인이 가장 아래 아닌 경우
                Horse now = horse[i];
                int r = xy[now.direction][0] + now.r;
                int c = xy[now.direction][1] + now.c;
                if (r < 0 || r >= n || c < 0 || c >= n) {
                    if (blue(i, now))
                        break end;
                } else if (map[r][c] == 2){
                    if (blue(i, now))
                        break end;
                } else if (map[r][c] == 1){
                    if (red(i, now, r, c))
                        break end;
                } else {
                    if (white(i, now, r, c))
                        break end;
                }
            }
        }
        System.out.println(turn);
    }

    private static boolean white(int i, Horse now, int r, int c) {
        horseMap[now.r][now.c] = 0;
        if (horseMap[r][c] != 0) { // 말 있는 경우
            if (other[i].size() + other[horseMap[r][c]].size() >= 4)
                return true;
            else plus(i, horseMap[r][c]);
        } else{
            horseMap[r][c] = i;
            now.r = r;
            now.c = c;
        }
        return false;
    }

    // 말 쌓는 경우
    private static void plus(int i, int origin) {
        for (Integer j : other[i])
            other[origin].add(j);
//        other[i] = new ArrayList<>(); // 생각해보기
        horse[i].down = false;
    }

    private static boolean red(int i, Horse now, int r, int c) {
        int originR = now.r;
        int originC = now.c;
        if (other[i].size() > 1) { // 본인 위 말 있는 경우
            Stack<Integer> stack = new Stack<>();
            for (Integer j : other[i]) {
                stack.push(j);
            }
            now.down = false;
            horse[stack.peek()].down = true;
            i = stack.peek(); // 현재 말 변경
            other[i] = new ArrayList<>();

            while (!stack.isEmpty())
                other[i].add(stack.pop());
        }
            if (horseMap[r][c] != 0){ // 이미 말 존재
                if (other[i].size() + other[horseMap[r][c]].size() >= 4) // 말이 4개 이상 쌓인 경우
                    return true;
                else plus(i, horseMap[r][c]);
            } else { // 말 x
                horseMap[r][c] = i; // 현재 위치에 현재 말 번호 저장
                horse[i].r = r; // 말 위치 업테이트
                horse[i].c = c;
            }
        horseMap[originR][originC] = 0; // 기존 자리 말 없음 표시
        return false;
    }

    private static boolean blue(int i, Horse now) {
        if (now.direction == 1 || now.direction == 2)
            now.direction = now.direction == 1 ? 2 : 1;
        else now.direction = now.direction == 3 ? 4 : 3;

        int r = xy[now.direction][0] + now.r;
        int c = xy[now.direction][1] + now.c;
        if (r < 0 || r >= n || c < 0 || c >= n) // 범위 밖 이동 x
            return false;
        else if (map[r][c] == 2) return false; // 파랑 경우 이동 x
        else if (map[r][c] == 1){
            return red(i, now, r, c);
        }
        else return white(i, now, r, c);
    }
}