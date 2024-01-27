import java.io.*;
import java.util.*;

public class Main {
    static int[][] a;
    static int[] place;
    static boolean[] check;
    static int max = Integer.MIN_VALUE, n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n][9]; check = new boolean[9]; place = new int[9];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j= 0; j < 9; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
            check[3] = true;
            place[3] = 0;   // 타순
            dfs(1);

        System.out.println(max);
    }
    static void dfs(int depth){
        if (depth == 9){
            score();
            return;
        }
        for (int i = 0; i < 9; i++){
            if (!check[i]){
             check[i] = true;
             place[i] = depth;
             dfs(depth + 1);
             check[i] = false;
            }
        }
    }

    private static void score() {
        int score = 0;
        int start = 0;

        for (int i = 0; i < n; i++){
            int out = 0;
            boolean[] vi = new boolean[3];

            outer: while (true){
                for (int j = start; j < 9; j++){
                    int now = a[i][place[j]];

                    switch (now){
                        case 0: // out.
                            out++;
                            break;
                        case 1: // 1루타
                            for (int k = 2; k >= 0; k--) {
                                if (vi[k]) {
                                    if (k == 2) { // 3루에 있는 선수는 홈으로 들어옴.
                                        score++; // 동시에 점수 획득.
                                        vi[k] = false; // 3루는 비어있게 됨.
                                        continue;
                                    }
                                    // 1, 2루에 경우 1루씩 진루하고 원래 있던 자리는 비어있게 됨.
                                    vi[k] = false;
                                    vi[k + 1] = true;
                                }
                            }
                            vi[0] = true; // 홈에서 1루로 진루.
                            break;
                        case 2: // 2루타
                            for (int k = 2; k >= 0; k--){
                                if (vi[k]) {
                                    if (k == 2 || k == 1) { // 3루 혹은 2루에 있는 선수는 홈으로 들어옴.
                                        score++; // 동시에 점수 획득.
                                        vi[k] = false; // 2루 또는 3루는 비어있게 됨.
                                        continue;
                                    }

                                    // 1루에 경우 2루씩 진루하고 원래 있던 자리는 비어있게 됨.
                                    vi[k] = false;
                                    vi[k + 2] = true;
                                }
                            }
                            vi[1] = true; // 홈에서 2루로 진루.
                            break;
                        case 3: // 3루타
                            for (int k = 2; k >= 0; k--){
                                if (vi[k]) { // 홈 제외 모든 선수는 홈으로 들어옴.
                                    score++; // 동시에 점수 획득.
                                    vi[k] = false;
                                }
                            }

                            vi[2] = true; // 홈에서 3루로 진루.
                            break;
                        case 4: // 홈런
                            for (int k = 2; k >= 0; k--){
                                if (vi[k]) { // 루상에 모든 주자가 홈으로 들어옴.
                                    score++; // 주자 1명 당 점수 1점씩 획득
                                    vi[k] = false;
                                }
                            }
                            score++; // 홈런친 타자의 점수 1점 추가.
                            break;
                    }
//                    if (now == 0) out++;
//                    else if (now == 1){
//                        for (int w = 2; w >= 0; w--){
//                            if (vi[w]){
//                                if (w == 2){
//                                    score++;
//                                    vi[w] = false;
//                                    continue;
//                                }
//                                    vi[w + 1] = true;
//                                    vi[w] = false;
//                            }
//                        }
//                        vi[now -1] = true;
//                    }
//                    else if (now == 2){
//                        for (int w = 2; w >= 0; w--){
//                            if (vi[w]){
//                                if (w != 0){
//                                    score++;
//                                    vi[w] = false;
//                                    continue;
//                                }
//                                    vi[w + 1] = true;
//                                    vi[w] = false;
//                            }
//                        }
//                        vi[now -1] = true;
//                    }
//                    else if (now == 3){
//                        for (int w = 2; w >= 0; w--){
//                            if (vi[w]){
//                                 score++;
//                                 vi[w] = false;
//                            }
//                        }
//                        vi[now -1] = true;
//                    }
//                    else if (now == 4){
//                        for (int w = 2; w >= 0; w--){
//                            if (vi[w]){
//                                score++;
//                                vi[w] = false;
//                            }
//                        }
//                        score++;
//                    }
                    if (out == 3){
                        start = j + 1;
                        if (start == 9) start = 0;
//                        start = ((j + 1) == 9) ? 0 : j + 1;
                        break outer;
                    }
                }
                start = 0;
            }
        }
        //System.out.println(score);
        max = Math.max(score, max);
    }
}